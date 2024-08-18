package ru.bublinoid.processor;

import java.util.Arrays;

public class ArrayOperations {

    private ArrayOperations() {
    }

    public static int[] operationArray(int[] inputArray) {
        for (int i = inputArray.length - 1; i >= 0; i--) {
            if (inputArray[i] == 1) {
                return Arrays.copyOfRange(inputArray, i + 1, inputArray.length);
            }
        }
        throw new RuntimeException("Массив не содержит единицы");
    }

    public static boolean isArrayValid(int[] inputArray) {
        boolean containsOne = false;
        boolean containsTwo = false;

        for (int number : inputArray) {
            if (number != 1 && number != 2) {
                return false;
            }

            if (number == 1) {
                containsOne = true;
            } else {
                containsTwo = true;
            }
        }

        return containsOne && containsTwo;
    }
}