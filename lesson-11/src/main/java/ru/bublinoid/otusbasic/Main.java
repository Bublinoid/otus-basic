package ru.bublinoid.otusbasic;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] array = {5, 4, 9, 0, 1, 2, 7, 3, 8, 6};
        sort(array, 0, array.length - 1);

        System.out.println("Отсортированный массив: ");
        System.out.println(Arrays.toString(array));
    }

    public static void sort(int[] array, int low, int high) {

        if (low < high) {
            int partitionIndex = partition(array, low, high);

            sort(array, low, partitionIndex - 1);
            sort(array, partitionIndex + 1, high);
        }
    }

    public static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;

                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }
}