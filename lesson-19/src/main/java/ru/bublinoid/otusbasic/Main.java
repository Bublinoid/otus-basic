package ru.bublinoid.otusbasic;

import ru.bublinoid.otusbasic.entity.Apple;
import ru.bublinoid.otusbasic.entity.Box;
import ru.bublinoid.otusbasic.entity.Orange;

public class Main {
    public static void main(String[] args) {

        Box<Apple> appleBox1 = new Box<>();
        appleBox1.addFruit(new Apple(0.15));
        appleBox1.addFruit(new Apple(0.2));

        Box<Apple> appleBox2 = new Box<>();
        appleBox2.addFruit(new Apple(0.4));

        Box<Orange> orangeBox = new Box<>();
        orangeBox.addFruit(new Orange(0.4));
        orangeBox.addFruit(new Orange(0.5));

        System.out.println("Вес коробки №1 с яблоками: " + appleBox1.getWeight());
        System.out.println("Вес коробки №2 с яблоками: " + appleBox2.getWeight());
        System.out.println("Вес коробки с апельсинами: " + orangeBox.getWeight());

        System.out.println("Сравнение коробок №1 и №2 с яблоками: " + appleBox1.compare(appleBox2));
        System.out.println("Сравнение коробки №1 с яблоками и коробки с апельсинами: " + appleBox1.compare(orangeBox));

        appleBox1.transferFruits(appleBox2);
        System.out.println("Вес коробки №1 с яблоками после пересыпания: " + appleBox1.getWeight());
        System.out.println("Вес коробки №2 с яблоками после пересыпания: " + appleBox2.getWeight());
    }
}