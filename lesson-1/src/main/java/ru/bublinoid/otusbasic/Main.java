package ru.bublinoid.otusbasic;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        final Scanner scanner = new Scanner(System.in);

        System.out.println("Введите число от 1 до 5:");
        int number = scanner.nextInt();

        if (number == 1) {
            greetings();
        } else if (number == 2) {
            checkSign(1, -10, 9);
        } else if (number == 3) {
            selectColor();
        } else if (number == 4) {
            compareNumbers();
        } else if (number == 5) {
            addOrSubtractAndPrint(scanner.nextInt(), scanner.nextInt(), scanner.nextBoolean());
        } else {
            System.out.println("Некорректное значение, введите число от 1 до 5:");
        }
    }

    public static void greetings() {
        System.out.println("Hello");
        System.out.println("World");
        System.out.println("from");
        System.out.println("Java");
    }

    public static void checkSign(int a, int b, int c) {
        int sum = a + b + c;
        if (sum >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    public static void selectColor() {
        int data = 25;

        if (data <= 10) {
            System.out.println("Красный");
        } else if (data <= 20) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    public static void compareNumbers() {
        int a = 10;
        int b = 15;

        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    public static void addOrSubtractAndPrint(int initValue, int delta, boolean increment) {
        if (increment) {
            int result = initValue + delta;
            System.out.println("Результат прибавления: " + result);
        } else {
            int result = initValue - delta;
            System.out.println("Результат вычитания: " + result);
        }
    }


}