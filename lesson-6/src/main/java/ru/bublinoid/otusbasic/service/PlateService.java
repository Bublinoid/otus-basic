package ru.bublinoid.otusbasic.service;

public class PlateService {

    private int maxFood;
    private int currentFood;

    public PlateService(int maxFood, int nowFood) {
        this.maxFood = maxFood;
        this.currentFood = nowFood;
    }

    public void addFood(int amount) {
        if (currentFood + amount <= maxFood) {
            currentFood += amount;
            System.out.println("Добавлено " + amount + " еды в тарелку");

        } else {
            System.out.println("Нельзя добавить столько еды, тарелка переполниться.");
        }
    }

    public boolean reduceFood(int amount, String catName) {
        if (currentFood >= amount) {
            currentFood -= amount;
            System.out.println("Кот " + catName + " поел " + amount + " еды");
            return true;

        } else {
            System.out.println("Недостаточно еды в тарелке");
            return false;
        }
    }

    public void info() {
        System.out.println("В тарелке: " + currentFood + " / " + maxFood + " еды");
    }
}