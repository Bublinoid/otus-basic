package ru.bublinoid.otusbasic;

import ru.bublinoid.otusbasic.entity.Cat;
import ru.bublinoid.otusbasic.service.PlateService;

public class Main {
    public static void main(String[] args) {

        PlateService plate = new PlateService(100, 40);
        Cat[] cats = {
                new Cat("Barsik", 10),
                new Cat("Murzik", 15),
                new Cat("Smooky", 20),
        };

        for (Cat cat : cats) {
            cat.eat(plate);
            cat.info();
        }

        plate.info();
        plate.addFood(85);
        plate.info();
    }
}