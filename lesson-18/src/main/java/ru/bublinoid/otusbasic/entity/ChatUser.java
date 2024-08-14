package ru.bublinoid.otusbasic.entity;

import java.io.PrintWriter;

public class ChatUser {

    private String name;
    private PrintWriter writer;
    private UserRole role;

    public ChatUser(String name, PrintWriter writer, UserRole role) {
        this.name = name;
        this.writer = writer;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public PrintWriter getWriter() {
        return writer;
    }

    public UserRole getRole() {
        return role;
    }


    public enum UserRole {
        USER, ADMIN
    }
}