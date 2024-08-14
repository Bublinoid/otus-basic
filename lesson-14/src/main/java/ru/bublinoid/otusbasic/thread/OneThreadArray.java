package ru.bublinoid.otusbasic.thread;

public class OneThreadArray {

    private static long startTime;

    public static void RunOneThreadArray() {

        startTime = System.currentTimeMillis();
        int arraySize = 100_000_000;
        double[] array = new double[arraySize];

        fillTheArray(array);
        printTime();
    }

    private static void fillTheArray(double[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
        }
    }

    private static void printTime() {

        long endTime = System.currentTimeMillis();
        double seconds = (endTime - startTime) / 1_000.0;
        System.out.println("Время выполнения в одном потоке: " + seconds + " c");

    }
}