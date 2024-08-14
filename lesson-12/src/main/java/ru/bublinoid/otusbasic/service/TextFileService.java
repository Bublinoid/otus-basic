package ru.bublinoid.otusbasic.service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.List;
import java.util.Scanner;

public class TextFileService {

    private static Scanner scanner = new Scanner(System.in);

    public static void run() {
        try {
            FileList();
            String fileName = getFileNameFromUser();

            Path filePath = Paths.get(fileName);

            if (Files.exists(filePath) && Files.isRegularFile(filePath)) {
                FileContent(filePath);

                System.out.println("Напишите текст для записи в файл (для завершения введите 'exit'): ");

                while (true) {
                    String input = scanner.nextLine();

                    if ("exit".equalsIgnoreCase(input.trim())) {
                        break;
                    }
                    writeToFile(filePath, input);
                }

            } else {
                System.out.println("Файл не существует. Повторите попытку");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }

    private static void FileList() throws IOException {
        System.out.println("Список текстовых файлов в корневом каталоге проекта: ");

        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get("."), "*.txt")) {
            for (Path file : directoryStream) {
                System.out.println(file.getFileName());
            }
        }
    }

    private static void FileContent(Path filePath) throws IOException {
        System.out.println("Содержимое файла: ");
        List<String> lines = Files.readAllLines(filePath, StandardCharsets.UTF_8);
        for(String line : lines) {
            System.out.println(line);
        }
    }

    private static void writeToFile(Path filePath, String content) throws IOException {
        try {
            Files.write(filePath, (content + System.lineSeparator()).getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getFileNameFromUser() {
        System.out.print("Введите имя файла: ");
        return scanner.nextLine();
    }
}