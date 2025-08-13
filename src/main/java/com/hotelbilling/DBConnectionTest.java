package com.hotelbilling;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionTest {

    static String url = "jdbc:mysql://localhost:3306/hotel_billing";
    static String user = "root";          // ✅ your MySQL username
    static String password = "DK81@mysql"; // ✅ your MySQL password


    public static Connection getConnection() {
        try {
            // Load MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Get connection
            return DriverManager.getConnection(url, user, password);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        try (Connection conn = getConnection()) {
            if (conn != null) {
                System.out.println("✅ Connected to the database!");
            } else {
                System.out.println("❌ Failed to connect to the database!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
