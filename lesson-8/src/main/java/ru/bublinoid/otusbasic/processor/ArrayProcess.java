package ru.bublinoid.otusbasic.processor;

import ru.bublinoid.otusbasic.exception.AppArrayDataException;
import ru.bublinoid.otusbasic.exception.AppArraySizeException;

public class ArrayProcess {

    public static int arrayProcess(String[][] array) throws AppArraySizeException, AppArrayDataException {
        int expectedSize = 4;
        if (array.length != expectedSize) {
            throw new AppArraySizeException("Некорректный размер массива, ожидается массив " + expectedSize + "x" + expectedSize);
        }

        for (String[] row : array) {
            if (row.length != expectedSize) {
                throw new AppArraySizeException("Некорректный размер строки массива, ожидается строка длиной " + expectedSize);
            }
        }

        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new AppArrayDataException("Ошибка данных в ячейке [" + i + "][" + j + "]. Неверные данные: " + array[i][j]);
                }
            }
        }
        return sum;
    }
}
