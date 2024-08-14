package ru.bublinoid.otusbasic.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class MathClient {

    public static void serverCommunication() {
        try {
            Socket socket = new Socket("localhost", 5555);

            BufferedReader on = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String operations = on.readLine();
            System.out.println(operations);

            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

            String userInputStr;
            while (true) {
                System.out.println("Введите операцию, например: 1 + 1:");
                userInputStr = userInput.readLine();

                if (userInputStr.equalsIgnoreCase("exit")) {
                    out.println("exit");
                    break;
                }

                out.println(userInputStr);

                String result = on.readLine();
                if (result.startsWith("Результат вашей операции равен:")) {
                    System.out.println(result);
                } else {
                    System.out.println("Ошибка: " + result);
                }
            }

            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}