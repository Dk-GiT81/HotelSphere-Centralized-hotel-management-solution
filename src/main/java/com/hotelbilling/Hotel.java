package com.hotelbilling;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private List<Room> rooms;
    private List<Customer> customers;

    public Hotel() {
        rooms = new ArrayList<>();
        customers = new ArrayList<>();
    }

    // Add a new room to the hotel
    public void addRoom(Room room) {
        rooms.add(room);
    }

    // List all available rooms
    public List<Room> getAvailableRooms() {
        List<Room> available = new ArrayList<>();
        for (Room r : rooms) {
            if (!r.isBooked()) {
                available.add(r);
            }
        }
        return available;
    }

    // Book a room for a customer
    public boolean bookRoom(Customer customer, Room room) {
        if (!room.isBooked()) {
            room.setBooked(true);
            customers.add(customer);
            return true;
        }
        return false;
    }

    // Get all customers
    public List<Customer> getCustomers() {
        return customers;
    }

    // Find a room by number
    public Room findRoomByNumber(int roomNumber) {
        for (Room r : rooms) {
            if (r.getRoomNumber() == roomNumber) {
                return r;
            }
        }
        return null;
    }
}
