package ru.bublinoid.otusbasic.entity;

public class Dog extends Animal {
    public Dog(String name, double speedRunning, double speedSwimming, int endurance) {
        super(name, speedRunning, speedSwimming, endurance);
    }

    @Override
    public void swim(int distance) {
        double time = distance / speedSwimming;
        if (endurance >= distance * 2) {
            endurance -= distance * 2;
            System.out.println(name + " проплыло " + distance + " метров за " + time + " секунд");

        } else {
            System.out.println(name + " устало и не может проплыть " + distance + " метров");
            endurance = 0;
        }
    }
}