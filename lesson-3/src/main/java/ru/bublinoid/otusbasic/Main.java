package ru.bublinoid.otusbasic;

public class Main {
    public static void main(String[] args) {
        int[][] array = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println("Sum of positive elements: " + sumOfPositiveElements(array));

        int size = 4;
        printSquare(size);

        zeroForDiagonal(array);
        System.out.println("Array zeroing diagonal element:");
        printArray(array);

        int maxElement = findMax(array);
        System.out.println("Max element: " + maxElement);

        int sumSecondRow = sumSecondRow(array);
        System.out.println("Sum element of the second row: " + sumSecondRow);
    }

    public static int sumOfPositiveElements(int[][] array) {
        int sum = 0;
        for (int[] row : array) {
            for (int elements : row) {
                if (elements > 0) {
                    sum += elements;
                }
            }
        }
        return sum;
    }
    public static void printSquare(int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    public static void zeroForDiagonal(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (i == j || i + j == array.length - 1) {
                    array[i][j] = 0;
                }
            }
        }

    }

    public static int findMax(int[][] array) {
        int max = Integer.MIN_VALUE;
        for (int[] row : array) {
            for (int elements : row) {
                if (elements > max) {
                    max = elements;
                }
            }
        }
        return max;
    }

    public static int sumSecondRow(int[][] array) {
        if (array.length > 1) {
            int sum = 0;
            for (int element : array[1]) {
                sum += element;
            }
            return sum;
        } else {
            return -1;
        }
    }
    public static void printArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}