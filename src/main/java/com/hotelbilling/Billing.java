package com.hotelbilling;

public class Billing {

    // Method to calculate the bill amount
    public static double calculateBill(Room room, int days) {
        if (room == null) {
            throw new IllegalArgumentException("Room cannot be null for bill calculation.");
        }
        return room.getPrice() * days;
    }

    // Method to print the bill details
    public static void printBill(Customer customer, int days) {
        if (customer == null || customer.getBookedRoom() == null) {
            System.out.println("Error: Customer or booked room information is missing.");
            return;
        }

        double total = calculateBill(customer.getBookedRoom(), days);

        System.out.println("\n===== Hotel Bill =====");
        System.out.println("Customer: " + customer.getName());
        System.out.println("Phone: " + customer.getPhone());
        System.out.println("Room: " + customer.getBookedRoom().getType());
        System.out.println("Price per Day: Rs." + customer.getBookedRoom().getPrice());
        System.out.println("Days Stayed: " + days);
        System.out.println("Total Amount: Rs." + total);
        System.out.println("======================\n");
    }
}
