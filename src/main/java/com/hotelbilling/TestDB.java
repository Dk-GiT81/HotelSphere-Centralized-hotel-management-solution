package com.hotelbilling;

import java.sql.Connection;

public class TestDB {
    public static void main(String[] args) {
        Connection conn = DBConnection.getConnection();
        if (conn != null) {
            System.out.println("Database connection test passed ✅");
        } else {
            System.out.println("Database connection test failed ❌");
        }
    }
}
