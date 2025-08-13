package com.hotelbilling;

import java.util.Date;

public class Bill {
    private int billId;
    private int customerId;
    private int roomId;
    private double amount;
    private Date billDate;

    // Constructor
    public Bill(int customerId, int roomId, double amount, Date date) {
        this.customerId = customerId;
        this.roomId = roomId;
        this.amount = amount;
        this.billDate = billDate;
    }

    // Getters and Setters
    public int getBillId() { return billId; }
    public void setBillId(int billId) { this.billId = billId; }

    public int getCustomerId() { return customerId; }
    public void setCustomerId(int customerId) { this.customerId = customerId; }

    public int getRoomId() { return roomId; }
    public void setRoomId(int roomId) { this.roomId = roomId; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public Date getBillDate() { return billDate; }
    public void setBillDate(Date billDate) { this.billDate = billDate; }
}
