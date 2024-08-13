package ru.bublinoid.otusbasic.entity;

public class Cat extends Animal {

    public Cat(String name, double speedRunning, double speedSwimming, int endurance) {
        super(name, speedRunning, 0, endurance);
    }
}