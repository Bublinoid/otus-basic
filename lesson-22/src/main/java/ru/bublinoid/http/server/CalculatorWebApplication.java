package ru.bublinoid.http.server;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class CalculatorWebApplication implements MyWebApplication {
    private static final Logger logger = LogManager.getLogger(CalculatorWebApplication.class);
    private String name;

    public CalculatorWebApplication() {
        this.name = "Web Calculator";
    }

    @Override
    public void execute(Request request, OutputStream output) throws IOException {
        String result = "";

        // Проверка наличия параметров "a" и "b"
        if (request.getParam("a") != null && request.getParam("b") != null) {
            try {
                int a = Integer.parseInt(request.getParam("a"));
                int b = Integer.parseInt(request.getParam("b"));

                if (request.getUri().contains("/add")) {
                    result = String.format("%d + %d = %d", a, b, a + b);
                } else if (request.getUri().contains("/subtract")) {
                    result = String.format("%d - %d = %d", a, b, a - b);
                } else if (request.getUri().contains("/multiply")) {
                    result = String.format("%d * %d = %d", a, b, a * b);
                } else if (request.getUri().contains("/divide")) {
                    // Проверка деления на 0
                    if (b != 0) {
                        result = String.format("%d / %d = %d", a, b, a / b);
                    } else {
                        result = "Division by zero";
                    }
                } else {
                    result = "Unknown operation";
                }
            } catch (NumberFormatException e) {
                // Обработка ошибки парсинга чисел
                result = "Invalid number format";
                logger.error("Invalid number format", e);
            }
        } else {
            // Обработка отсутствия параметров "a" и/или "b"
            result = "Parameters 'a' and 'b' are required";
        }

        logger.info("Start CalculatorWebApplication with result: {}", result);

        output.write(("HTTP/1.1 200 OK\r\nContent-Type: text/html\r\n\r\n<html><body><h1>" + name + "</h1><h2>" + result + "</h2></body></html>").getBytes(StandardCharsets.UTF_8));
    }
}