package com.hotelbilling;

import java.util.ArrayList;
import java.util.Scanner;

public class HotelBillingSystem {
    private static ArrayList<Customer> customers = new ArrayList<>();
    private static RoomDAO roomDAO = new RoomDAO();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        System.out.println("===== Welcome to Hotel Billing System =====");

        while (running) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. View Available Rooms");
            System.out.println("2. Book a Room");
            System.out.println("3. View Customers");
            System.out.println("4. Generate Bill");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = getIntInput();

            switch (choice) {
                case 1:
                    viewAvailableRooms();
                    break;
                case 2:
                    bookRoom();
                    break;
                case 3:
                    viewCustomers();
                    break;
                case 4:
                    generateBill();
                    break;
                case 5:
                    running = false;
                    System.out.println("Exiting... Thank you for using the system!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // --- View Available Rooms ---
    private static void viewAvailableRooms() {
        System.out.println("\n--- Available Rooms ---");
        ArrayList<Room> availableRooms = (ArrayList<Room>) roomDAO.getAvailableRooms();
        if (availableRooms.isEmpty()) {
            System.out.println("No rooms available.");
        } else {
            for (Room room : availableRooms) {
                System.out.println(room);
            }
        }
    }

    // --- Book a Room ---
    private static void bookRoom() {
        System.out.println("\n--- Book a Room ---");
        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();
        System.out.print("Enter customer phone: ");
        String phone = scanner.nextLine();
        System.out.print("Enter customer email: ");
        String email = scanner.nextLine();

        System.out.println("\nSelect a room to book:");
        ArrayList<Room> availableRooms = (ArrayList<Room>) roomDAO.getAvailableRooms();
        if (availableRooms.isEmpty()) {
            System.out.println("No rooms available to book.");
            return;
        }
        for (Room room : availableRooms) {
            System.out.println(room);
        }

        System.out.print("Enter Room Number: ");
        int roomNumber = getIntInput();

        Room selectedRoom = roomDAO.findRoomByNumber(roomNumber);
        if (selectedRoom != null && !selectedRoom.isBooked()) {
            selectedRoom.setBooked(true);
            Customer customer = new Customer(name, phone, email, selectedRoom);
            customers.add(customer);
            System.out.println("Room booked successfully for " + name + "!");
        } else {
            System.out.println("Invalid room number or room already booked.");
        }
    }

    // --- View Customers ---
    private static void viewCustomers() {
        System.out.println("\n--- Customers List ---");
        if (customers.isEmpty()) {
            System.out.println("No customers found.");
        } else {
            for (Customer c : customers) {
                System.out.println(c);
            }
        }
    }

    // --- Generate Bill ---
    private static void generateBill() {
        System.out.println("\n--- Generate Bill ---");
        System.out.print("Enter customer phone number: ");
        String phone = scanner.nextLine();

        Customer foundCustomer = null;
        for (Customer c : customers) {
            if (c.getPhone().equals(phone)) {
                foundCustomer = c;
                break;
            }
        }

        if (foundCustomer != null) {
            Room room = foundCustomer.getBookedRoom();
            if (room != null) {
                double totalAmount = room.getPrice(); // Simple billing based on price
                System.out.println("\nBill for " + foundCustomer.getName());
                System.out.println("Room: " + room.getRoomNumber() + " (" + room.getType() + ")");
                System.out.println("Price per night: ₹" + room.getPrice());
                System.out.println("Total Amount: ₹" + totalAmount);
            } else {
                System.out.println("No room booked for this customer.");
            }
        } else {
            System.out.println("Customer not found.");
        }
    }

    // --- Helper method to safely read integer input ---
    private static int getIntInput() {
        while (true) {
            try {
                int value = Integer.parseInt(scanner.nextLine());
                return value;
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a number: ");
            }
        }
    }
}
