package ru.bublinoid.otusbasic.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBookService {

    private Map<String, List<String>> contacts;

    public PhoneBookService() {
        this.contacts = new HashMap<>();
    }

    private String buildFullName(String name, String surname, String middleName) {
        return name + " " + surname + " " + middleName;
    }

    public void add(String name, String surname, String middleName, String phoneNumber) {
        String fullName = buildFullName(name, surname, middleName);
        contacts.computeIfAbsent(fullName, k -> new ArrayList<>()).add(phoneNumber);
    }

    public List<String> find(String name, String surname, String middleName) {
        String fullName = buildFullName(name, surname, middleName);
        return contacts.getOrDefault(fullName, new ArrayList<>());
    }

    public boolean containsPhoneNumber(String phoneNumber) {
        return contacts.values()
                .stream()
                .anyMatch(phoneNumbers -> phoneNumbers.contains(phoneNumber));
    }
}
