package ru.bublinoid.otusbasic;

import ru.bublinoid.otusbasic.entity.User;
import ru.bublinoid.otusbasic.service.BoxService;


public class Main {
    public static void main(String[] args) {
        User[] users = new User[10];

        users[0] = new User("Иванов", "Иван", "Иванович", 1970, "test0@gmail.com");
        users[1] = new User("Петров", "Петр", "Петрович", 1980, "test1@gmail.com");
        users[2] = new User("Сидоров", "Сидр", "Сидрович", 1972, "test2@gmail.com");
        users[3] = new User("Попов", "Евгений", "Попович", 1973, "test3@gmail.com");
        users[4] = new User("Серегев", "Алексей", "Сергеевич", 1960, "test4@gmail.com");
        users[5] = new User("Олегов", "Олег", "Олегович", 1999, "test5@gmail.com");
        users[6] = new User("Глебов", "Глеб", "Глебович", 1988, "test6@gmail.com");
        users[7] = new User("Левов", "Максим", "Львович", 1985, "test7@gmail.com");
        users[8] = new User("Орлов", "Никита", "Орлович", 1976, "test8@gmail.com");
        users[9] = new User("Орленок", "Семен", "Никитич", 1955, "test9@gmail.com");

        for (User user : users) {
            if (user != null && user.getBirthYear() < 1982) {
                user.printInfoUser();
            }
        }

        BoxService box = new BoxService(30, 20, 40, "Красный");
        box.printInfo();

        box.open();
        box.putItem("Ручка");
        box.printInfo();

        box.close();
        box.putItem("Книга");
        box.printInfo();

        box.open();
        box.takeItem();
        box.printInfo();
    }

}