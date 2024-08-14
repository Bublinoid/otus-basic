package ru.bublinoid.otusbasic.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileService {

    public int characterCount(String fileName, String sequence) {
        int character = 0;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;

            while ((line = reader.readLine()) != null) {
                character += countCharacterInLine(line, sequence);
            }
            reader.close();
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }
        return character;
    }

    private int countCharacterInLine(String text, String target) {
        int count = 0;
        int index = text.indexOf(target);

        while (index != -1) {
            count++;
            index = text.indexOf(target, index + 1);
        }
        return count;
    }
}