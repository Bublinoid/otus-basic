package ru.bublinoid.otusbasic;

import ru.bublinoid.otusbasic.client.Client;
import ru.bublinoid.otusbasic.server.Server;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        new Thread(() -> {
            Server server = new Server();
            server.start();
        }).start();

        Client tom = new Client("tomi");
        tom.start();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите команду (/exit, /kick username) или сообщение:");
            String input = scanner.nextLine();

            if ("/exit".equalsIgnoreCase(input)) {
                tom.disconnect();
                break;
            } else if (input.startsWith("/kick")) {
                String[] parts = input.split(" ");
                if (parts.length == 2) {
                    String usernameToKick = parts[1];
                    tom.kickUser(usernameToKick);
                } else {
                    System.out.println("Некорректный формат команды /kick");
                }
            } else {
                tom.sendMessage(input);
            }
        }
    }
}
