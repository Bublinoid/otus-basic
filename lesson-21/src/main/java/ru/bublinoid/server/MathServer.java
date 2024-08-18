package ru.bublinoid.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MathServer {

    public static void main(String[] args) {
        startServer();
    }

    public static void startServer() {
        try {
            ServerSocket serverSocket = new ServerSocket(5555);
            System.out.println("Сервер запущен. Ожидание подключения...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Клиент подключен: " + clientSocket.getInetAddress().getHostAddress());

                try (
                        BufferedReader on = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)
                ) {
                    out.println("Вам доступны операции: сложение(+), вычитание(-), умножение(*), деление(/)");

                    while (true) {
                        String request = on.readLine();
                        System.out.println("Клиент ввел: " + request);

                        if (request == null || request.equalsIgnoreCase("exit")) {
                            break;
                        }

                        try {
                            String[] details = request.split(" ");
                            double operations1 = Double.parseDouble(details[0]);
                            double operations2 = Double.parseDouble(details[2]);
                            char operation = details[1].charAt(0);

                            double result = performOperation(operations1, operations2, operation);

                            out.println("Результат вашей операции равен: " + result);
                        } catch (NumberFormatException | ArrayIndexOutOfBoundsException | ArithmeticException e) {
                            out.println("Ошибка. " + e.getMessage());
                        }
                    }
                }

                clientSocket.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static double performOperation(double operations1, double operations2, char operation) {
        switch (operation) {
            case '+':
                return operations1 + operations2;
            case '-':
                return operations1 - operations2;
            case '*':
                return operations1 * operations2;
            case '/':
                if (operations2 != 0) {
                    return operations1 / operations2;
                } else {
                    throw new ArithmeticException("Нельзя делить на нуль.");
                }
            default:
                throw new IllegalArgumentException("Такой операции нет: " + operation);
        }
    }
}