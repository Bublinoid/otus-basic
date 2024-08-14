package ru.bublinoid.otusbasic.entity;

public class Rider {
    private String name;
    private int energy;

    public Rider(String name, int initialEnergy) {
        this.name = name;
        this.energy = initialEnergy;
    }

    public String getName() {
        return name;
    }

    public int getEnergy() {
        return energy;
    }

    public void decreaseEnergy(int amount) {
        if (energy >= amount) {
            energy -= amount;
        } else {
            energy = 0;
        }
    }

    public boolean hasEnoughEnergy(int amount) {
        return energy >= amount;
    }
}
