package ru.bublinoid.otusbasic;

import ru.bublinoid.otusbasic.exception.AppArrayDataException;
import ru.bublinoid.otusbasic.exception.AppArraySizeException;
import ru.bublinoid.otusbasic.processor.ArrayProcess;

public class Main {
    public static void main(String[] args) {
        String[][] nowArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"},
        };

        try {
            int result = ArrayProcess.arrayProcess(nowArray);
            System.out.println("Сумма элементов массима: " + result);

        } catch (AppArraySizeException | AppArrayDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}