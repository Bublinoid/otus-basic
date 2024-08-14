package ru.bublinoid.otusbasic.client;



import ru.bublinoid.otusbasic.entity.ChatUser;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 5431;

    private Socket socket;

    private final String name;

    public Client(String name) {
        this.name = name;
    }

    public void start() {
        try {
            Scanner scanner = new Scanner(System.in);

            socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
            Scanner in = new Scanner(socket.getInputStream());
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            System.out.print("Введите ваше имя: ");
            String name = scanner.nextLine();
            out.println(name);

            System.out.print("Введите вашу роль (USER или ADMIN): ");
            String roleInput = scanner.nextLine();
            ChatUser.UserRole role = ChatUser.UserRole.valueOf(roleInput.toUpperCase());
            out.println(role);

            String passwordRequest = in.nextLine();
            System.out.println(passwordRequest);

            String password = scanner.nextLine();

            out.println(password);

            new Thread(() -> {
                while (true) {
                    if (in.hasNextLine()) {
                        String message = in.nextLine();
                        System.out.println(message);

                        System.out.print("Введите сообщение (или /exit для выхода): ");
                    }
                }
            }).start();

            while (true) {
                String message = scanner.nextLine();
                if ("/exit".equalsIgnoreCase(message)) {
                    disconnect();
                    break;
                } else {
                    out.println(message);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String message) {
        try {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendPersonalMessage(String recipient, String message) {
        try {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println("/w " + recipient + " " + message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void disconnect() {
        try {
            System.out.println("Отключение");
            Thread.sleep(100);
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void kickUser(String username) {
        try {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println("/kick " + username);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}