package ru.bublinoid.otusbasic.service;

public class BoxService {
    private final int width;
    private final int height;
    private final int depth;
    private final String color;
    private boolean isOpen;
    private String item;

    public BoxService(int width, int height, int depth, String color) {
        this.width = width;
        this.height = height;
        this.depth = depth;
        this.color = color;
        this.isOpen = false;
        this.item = null;
    }

    public void open() {
        isOpen = true;
        System.out.println("Коробка открыта");
    }

    public void close() {
        isOpen = false;
        System.out.println("Коробка закрыта");
    }

    public void putItem(String item) {
        if (isOpen) {
            if (this.item == null) {
                this.item = item;
                System.out.println("Предмет помещен в коробку: " + item);
            } else {
                System.out.println("В коробке уже есть предмет. Выкиньте его, чтобы положить новый.");
            }
        } else {
            System.out.println("Коробка закрыта. Откройте коробку перед тем, как что-то положить в нее.");
        }
    }

    public void takeItem() {
        if (isOpen) {
            if (item != null) {
                System.out.println("Предмет вынут из коробки: " + item);
                item = null;
            } else {
                System.out.println("В коробке нет предмета. Положите что-то, прежде чем вынимать.");
            }
        } else {
            System.out.println("Коробка закрыта. Откройте коробку перед тем, как что-то вынимать из нее.");
        }
    }

    public void printInfo() {
        System.out.println("Коробка: " + width + "x" + height + "x" + depth + ", Цвет: " + color);
        System.out.println("Статус: " + (isOpen ? "Открыта" : "Закрыта"));
        if (item != null) {
            System.out.println("Внутри: " + item);
        } else {
            System.out.println("Внутри пусто");
        }
        System.out.println();
    }
}