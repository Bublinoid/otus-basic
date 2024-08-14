package ru.bublinoid.otusbasic.entity;

public class Car implements Transport {
    private int fuel;

    public Car(int initialFuel) {
        this.fuel = initialFuel;
    }

    @Override
    public String getType() {
        return "машина";
    }

    @Override
    public boolean move(int distance, TerrainType terrainType, Rider rider) {
        if (terrainType == TerrainType.DENSE_FOREST || terrainType == TerrainType.SWAMP) {
            System.out.println("Машина не может переместиться по данному типу местности");
            return false;
        }

        if (fuel >= distance) {
            fuel -= distance;
            return true;
        } else {
            System.out.println("Недостаточно топлива для перемещения на " + distance + " км");
            return false;
        }
    }
}
