package ru.bublinoid.otusbasic;

public class Main {
    public static void main(String[] args) {
        printStringNumberOfTimes(4, "Hello World!");

        int[] numbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        printSumGreaterThanFive(numbers);

        int fillValue = 11;
        fillArrayWithValue(fillValue, numbers);
        printArray(numbers);

        int incrementValue = 5;
        increaseArrayValues(numbers, incrementValue);
        printArray(numbers);

        printGreaterHalfSum(numbers);
    }

    public static void printStringNumberOfTimes(int count, String str) {
        for (int i = 0; i < count; i++) {
            System.out.println(str);
        }
    }

    public static void printSumGreaterThanFive(int[] array) {
        int sum = 0;
        for (int number : array) {
            if (number > 5) {
                sum += number;
            }
        }
        System.out.println("Сумма значений больше 5: " + sum);
    }

    public static void fillArrayWithValue(int value, int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = value;
        }
    }

    public static void increaseArrayValues(int[] array, int increment) {
        for (int i = 0; i < array.length; i++) {
            array[i] += increment;
        }
    }

    public static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void printGreaterHalfSum(int[] array) {
        int middle = array.length / 2;
        int sumFirstHalf = 0;
        int sumSecondHalf = 0;

        for (int i = 0; i < middle; i++) {
            sumFirstHalf += array[i];
        }

        for (int i = middle; i < array.length; i++) {
            sumSecondHalf += array[i];
        }

        if (sumFirstHalf > sumSecondHalf) {
            System.out.println("Сумма элементов первой половины больше.");
        } else if (sumFirstHalf < sumSecondHalf) {
            System.out.println("Сумма элементов второй половины больше.");
        } else {
            System.out.println("Суммы элементов половин равны.");
        }
    }
}