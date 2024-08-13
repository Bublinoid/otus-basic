package ru.bublinoid.otusbasic.entity;

public class User {

    private final String lastName;
    private final String firstName;
    private final String middleName;
    private final int birthYear;
    private final String email;

    public User(String lastName, String firstName, String middleName, int birthYear, String email) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.birthYear = birthYear;
        this.email = email;
    }

    public void printInfoUser() {
        System.out.println("ФИО: " + lastName + " " + firstName + " " + middleName);
        System.out.println("Год рождения: " + birthYear);
        System.out.println("email: " + email);
        System.out.println();
    }

    public int getBirthYear() {
        return birthYear;
    }
}