package ru.bublinoid.otusbasic;

import ru.bublinoid.otusbasic.service.PhoneBookService;

public class Main {
    public static void main(String[] args) {

        PhoneBookService phonebook = new PhoneBookService();

        phonebook.add("Otus1", "Home1", "Work1" , "+420-111-111-111" );
        phonebook.add("Otus1", "Home1", "Work1", "+420-111-111-112" );
        phonebook.add("Otus2", "Home1", "Work2", "+420-222-222-222" );
        phonebook.add("Otus3", "Home3", "Work3", "+420-333-333-333" );
        phonebook.add("Otus4", "Home4", "Work4", "+420-444-444-444" );

        System.out.println("Номер телефона для Otus1 Home1 Work1: " + phonebook.find("Otus1", "Home1", "Work1"));
        System.out.println("Номер телефона для Otus2 Home1 Work2: " + phonebook.find("Otus2", "Home1", "Work2"));
        System.out.println("Номер телефона для Otus4 Home4 Work4: " + phonebook.find("Otus4", "Home4", "Work4"));

        System.out.println("Есть ли номер телефона +420-111-111-111 в справочнике? " + phonebook.containsPhoneNumber("+420-111-111-111"));
        System.out.println("Есть ли номер телефона +420-333-333-333 в справочнике? " + phonebook.containsPhoneNumber("+420-333-333-333"));
        System.out.println("Есть ли номер телефона +420-111-111-113 в справочнике? " + phonebook.containsPhoneNumber("+420-111-111-113"));
    }
}