package ru.bublinoid.otusbasic.service;

import ru.bublinoid.otusbasic.server.Server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ClientService implements Runnable {

    private final Socket clientSocket;
    private final Server server;
    private PrintWriter out;
    private String name;

    public ClientService(Socket clientSocket, Server server) {
        this.clientSocket = clientSocket;
        this.server = server;
    }

    @Override
    public void run() {
        try (
                Scanner in = new Scanner(clientSocket.getInputStream());
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)
        ) {
            this.out = out;
            this.name = in.nextLine();
            server.addClient(name, this);

            while (true) {
                try {
                    String message = in.nextLine();
                    if (message.startsWith("/w")) {
                        String[] details = message.split(" ", 3);
                        String recipient = details[1];
                        String personalMessage = details[2];
                        server.sendPersonalMessage(name, recipient, personalMessage.trim());
                    } else {
                        server.broadcastMessage(name + ": " + message);
                    }
                } catch (NoSuchElementException e) {
                    server.removeClient(name);
                    break;
                }
            }
        } catch (IOException e) {
            System.err.println("Ошибка взаимодействия с клиентом");
        }
    }

    public void sendMessage(String message) {
        out.println(message);
    }
}
