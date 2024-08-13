package ru.bublinoid.otusbasic.entity;

public class Animal {
    protected String name;
    protected double speedRunning;
    protected double speedSwimming;
    protected int endurance;

    public Animal(String name, double speedRunning, double speedSwimming, int endurance) {

        this.name = name;
        this.speedRunning = speedRunning;
        this.speedSwimming = speedSwimming;
        this.endurance = endurance;
    }

    public void run(int distance) {
        double time = distance / speedRunning;
        if (endurance >= distance) {
            endurance -= distance;
            System.out.println(name + " пробежал " + distance + " метров за " + time + " секунд");

        } else {

            System.out.println(name + " устал и не может пробежать " + distance + " метров");
            endurance = 0;
        }
    }
    public void swim(int distance) {
        System.out.println(name + " не умеет плавать");
    }

    public void info() {
        System.out.println(name + " - выносливость: " + endurance);
    }
}