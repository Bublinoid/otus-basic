package ru.bublinoid.otusbasic.server;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import ru.bublinoid.otusbasic.service.ClientService;

public class Server {

    private static final int PORT = 5431;
    private static final Map<String, ClientService> clients = new HashMap<>();
    private final ExecutorService clientThreadPool = Executors.newCachedThreadPool();

    public Server() {
        start();
    }

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Сервер запущен на порту " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                ClientService clientService = new ClientService(clientSocket, this);
                clientThreadPool.submit(clientService);
            }
        } catch (IOException e) {
            throw new RuntimeException("Ошибка при запуске сервера", e);
        }
    }

    public synchronized void addClient(String name, ClientService clientService) {
        clients.put(name, clientService);
        System.out.println(name + " присоединился");
    }

    public synchronized void removeClient(String name) {
        clients.remove(name);
        System.out.println(name + " отключился");
    }

    public synchronized void broadcastMessage(String message) {
        clients.values().forEach(client -> client.sendMessage(message));
    }

    public synchronized void sendPersonalMessage(String sender, String recipient, String message) {
        ClientService recipientHandler = clients.get(recipient);
        if (recipientHandler != null) {
            recipientHandler.sendMessage("Лично для " + sender + ": " + message);
        } else {
            ClientService senderHandler = clients.get(sender);
            if (senderHandler != null) {
                senderHandler.sendMessage("Получатель " + recipient + " не найден. Сообщение возвращено отправителю.");
            }
        }
    }
}
