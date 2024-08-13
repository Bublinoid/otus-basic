package ru.bublinoid.otusbasic.entity;

public class Horse extends Animal {
    public Horse(String name, double speedRunning, double speedSwimming, int endurance) {
        super(name, speedRunning, speedSwimming, endurance);
    }

    @Override
    public void swim(int distance) {
        double time = distance / speedSwimming;
        if (endurance >= distance * 4) {
            endurance -= distance * 4;
            System.out.println(name + " проплыло " + distance + " метров за " + time + " секунд");

        } else {
            System.out.println(name + " устало и не может проплыть " + distance + " метров");
            endurance = 0;
        }
    }
}