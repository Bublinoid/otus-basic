package ru.bublinoid.otusbasic;

import ru.bublinoid.otusbasic.service.FileService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        final Scanner scanner = new Scanner(System.in);

        System.out.println("Введите имя файла: ");
        String fileName = scanner.nextLine();

        System.out.println("Введите требуюмую последовательно символов: ");
        String sequence = scanner.nextLine();

        scanner.close();

        FileService fileOperations = new FileService();
        int character = fileOperations.characterCount(fileName, sequence);

        System.out.println("Количество вхождений: " + character);

    }
}