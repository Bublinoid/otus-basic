package ru.bublinoid.otusbasic.server;

import ru.bublinoid.otusbasic.authentication.Authentication;
import ru.bublinoid.otusbasic.entity.ChatUser;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Server {

    private static final int PORT = 5431;
    private static final Map<String, ChatUser> clients = new HashMap<>();

    public Server() {
        start();
    }

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Сервер запущен на порту " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                new Thread(() -> clientManagement(clientSocket)).start();
            }
        } catch (IOException e) {
            throw new RuntimeException("Ошибка при запуске сервера", e);
        }
    }

    private void clientManagement(Socket clientSocket) {
        try (
                Scanner in = new Scanner(clientSocket.getInputStream());
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)
        ) {
            String name = in.nextLine();
            ChatUser.UserRole userRole = ChatUser.UserRole.valueOf(in.nextLine());

            out.println("Введите пароль:");

            String passwordHash = in.nextLine();

            if (Authentication.authenticateUser(name, passwordHash)) {
                ChatUser user = new ChatUser(name, out, userRole);
                clients.put(name, user);

                System.out.println(name + " присоединился с ролью " + userRole);
                System.out.print("Введите сообщение (или /exit для выхода): ");

                while (true) {
                    try {
                        String message = in.nextLine();
                        if (message.startsWith("/w")) {
                            String[] details = message.split(" ", 3);
                            String recipient = details[1];
                            String personalMessage = details[2];
                            sendPersonalMessage(user, recipient, personalMessage.trim());
                        } else if (message.startsWith("/kick") && user.getRole() == ChatUser.UserRole.ADMIN) {
                            String[] details = message.split(" ", 2);
                            String userToKick = details[1];
                            kickUser(user, userToKick);
                            streaming(user, userToKick + " был отключен администратором " + user.getName());
                        } else {
                            streaming(user, user.getName() + ": " + message);
                        }

                        System.out.print("Введите сообщение (или /exit для выхода): ");
                    } catch (NoSuchElementException e) {
                        clients.remove(name);
                        System.out.println(name + " отключился");
                        break;
                    }
                }
            } else {
                System.out.println("Ошибка аутентификации для пользователя " + name);
                out.println("Ошибка аутентификации. Проверьте учетные данные.");
            }
        } catch (IOException e) {
            System.err.println("Ошибка взаимодействия с клиентом");
        }
    }



    private void sendPersonalMessage(ChatUser sender, String recipient, String message) {
        ChatUser recipientUser = clients.get(recipient);

        if (recipientUser != null) {
            recipientUser.getWriter().println("Лично от " + sender.getName() + ": " + message);
        } else {
            System.out.println("Получатель " + recipient + " не найден.");
            sender.getWriter().println("Получатель " + recipient + " не найден. Сообщение возвращено отправителю.");
        }
    }

    private void kickUser(ChatUser admin, String userToKick) {
        ChatUser user = clients.get(userToKick);
        if (user != null) {
            clients.remove(userToKick);
            user.getWriter().println("Вы были отключены администратором " + admin.getName());
            System.out.println(userToKick + " был отключен администратором " + admin.getName());
        } else {
            System.out.println("Пользователь " + userToKick + " не найден.");
        }
    }

    private void streaming(ChatUser sender, String message) {
        for (ChatUser user : clients.values()) {
            try {
                user.getWriter().println(message);
            } catch (Exception e) {
            }
        }
    }

    public static void main(String[] args) {
        new Server().start();
    }
}