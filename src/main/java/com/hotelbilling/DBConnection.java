package com.hotelbilling;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/hotel_billing"; // Change DB name if needed
    private static final String USER = "root"; // Your MySQL username
    private static final String PASSWORD = "DK81@mysql"; // Your MySQL password

    private static Connection connection = null;

    // Get a single shared connection (Singleton Pattern)
    public static Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("✅ Database connected successfully.");
            } catch (ClassNotFoundException e) {
                System.out.println("❌ MySQL JDBC Driver not found.");
                e.printStackTrace();
            } catch (SQLException e) {
                System.out.println("❌ Database connection failed.");
                e.printStackTrace();
            }
        }
        return connection;
    }
}
