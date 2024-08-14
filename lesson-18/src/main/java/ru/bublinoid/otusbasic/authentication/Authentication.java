package ru.bublinoid.otusbasic.authentication;



import at.favre.lib.crypto.bcrypt.BCrypt;

import java.sql.*;

public class Authentication {

    private static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String DATABASE_USER = "postgres";
    private static final String DATABASE_PASSWORD = "7117513Brat";

    public static boolean authenticateUser(String username, String password) {
        try (Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD)) {
            String query = "SELECT password_hash FROM users WHERE username = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, username);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    String storedHash = resultSet.getString("password_hash");

                    return BCrypt.verifyer().verify(password.toCharArray(), storedHash).verified;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        String username = "testuser";
        String password = "testpassword";

        String hashedPassword = BCrypt.withDefaults().hashToString(8, password.toCharArray());
        saveUser(username, hashedPassword, "USER");

        if (authenticateUser(username, password)) {
            System.out.println("Пользователь успешно аутентифицирован");
        } else {
            System.out.println("Неверные данные");
        }
    }

    private static void saveUser(String username, String passwordHash, String role) {
        try (Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD)) {
            String query = "INSERT INTO users (username, password_hash, role) VALUES (?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, passwordHash);
                preparedStatement.setString(3, role);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}