package ru.bublinoid.http.server;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class MainApplication {
    public static final int PORT = 8189;
    private static final int THREAD_POOL_SIZE = 10;
    private static final Logger logger = LogManager.getLogger(MainApplication.class);

    // + К домашнему задания:
    // Добавить логирование!!!

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            Map<String, MyWebApplication> router = new HashMap<>();
            router.put("/calculator", new CalculatorWebApplication());
            router.put("/greetings", new GreetingsWebApplication());
            logger.info("Сервер запущен на порт: {}", PORT);

            ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

            while (true) {
                try {
                    Socket socket = serverSocket.accept();
                    logger.info("Клиент подключился");

                    executorService.execute(() -> handleRequest(socket, router));

                } catch (IOException e) {
                    logger.error("Ошибка при соединении", e);
                }
            }
        } catch (IOException e) {
            logger.error("Ошибка при создании ServerSocket", e);
        }
    }

    private static void handleRequest(Socket socket, Map<String, MyWebApplication> router) {
        try {
            byte[] buffer = new byte[2048];
            int n = socket.getInputStream().read(buffer);
            String rawRequest = new String(buffer, 0, n);
            Request request = new Request(rawRequest);
            System.out.println("Получен запрос:");
            request.show();
            boolean executed = false;
            for (Map.Entry<String, MyWebApplication> e : router.entrySet()) {
                if (request.getUri().startsWith(e.getKey())) {
                    e.getValue().execute(request, socket.getOutputStream());
                    executed = true;
                    break;
                }
            }
            if (!executed) {
                socket.getOutputStream().write(("HTTP/1.1 200 OK\r\nContent-Type: text/html\r\n\r\n<html><body><h1>Unknown application</h1></body></html>").getBytes(StandardCharsets.UTF_8));
            }
        } catch (IOException e) {
            logger.error("Ошибка при создании запроса", e);
        } finally {
            try {
                socket.close();
                logger.info("Соединение закрыто");
            } catch (IOException e) {
                logger.error("Ошибка при закрытии сокета", e);
            }
        }
    }
}