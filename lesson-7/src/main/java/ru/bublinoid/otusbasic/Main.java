package ru.bublinoid.otusbasic;

import ru.bublinoid.otusbasic.entity.*;

public class Main {
    public static void main(String[] args) {

        Human person = new Human("Otus", 30);
        Car car = new Car(40);
        Horse horse = new Horse();
        Bicycle bicycle = new Bicycle();
        OffRoadVehicle offRoadVehicle = new OffRoadVehicle();

        person.sitOnTransport(car);
        person.move(10, TerrainType.PLAIN);
        person.move(15, TerrainType.DENSE_FOREST);

        person.getOffTransport();
        person.sitOnTransport(horse);
        person.move(10, TerrainType.SWAMP);

        person.getOffTransport();
        person.sitOnTransport(bicycle);
        person.move(15, TerrainType.PLAIN);
        person.move(5, TerrainType.SWAMP);

        person.getOffTransport();
        person.sitOnTransport(offRoadVehicle);
        person.move(25, TerrainType.DENSE_FOREST);
    }
}