package com.hotelbilling;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;

public class BillDAO {
    private Connection connection;

    public BillDAO(Connection connection) {
        this.connection = connection;
    }

    public void addBill(Bill bill) {
        String sql = "INSERT INTO bills (customer_id, room_id, amount, bill_date) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, bill.getCustomerId());
            stmt.setInt(2, bill.getRoomId());
            stmt.setDouble(3, bill.getAmount());
            stmt.setDate(4, new Date(bill.getBillDate().getTime())); // Convert java.util.Date to java.sql.Date
            stmt.executeUpdate();

            BillDAO billDAO = new BillDAO(connection);
            Bill bill1 = new Bill(1, 1, 2500.0, new Date(140920221)); // assuming IDs
            billDAO.addBill(bill1);


            System.out.println("Bill added successfully!");
        } catch (SQLException e) {
            System.out.println("Error adding bill: " + e.getMessage());
        }
    }

    public Bill getBillByCustomerPhone(String searchPhone) {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getBillByCustomerPhone'");
    }

    public void printBill(Bill bill) {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'printBill'");
    }
}
