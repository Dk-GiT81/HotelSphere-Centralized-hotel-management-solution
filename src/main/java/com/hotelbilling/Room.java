package com.hotelbilling;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private int roomNumber;
    private String type;
    private double price;
    private boolean isAvailable;

    // Main constructor
    public Room(int roomNumber, String type, double price) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.price = price;
        this.isAvailable = true; // Default when created
    }

    // Overloaded constructor for DB results
    public Room(int roomNumber, String type, double price, boolean isAvailable) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.price = price;
        this.isAvailable = isAvailable;
    }

    public List<Room> getAllRooms() {
    List<Room> rooms = new ArrayList<>();
    rooms.add(new Room(101, "Single", 1500));
    rooms.add(new Room(102, "Double", 2500));
    rooms.add(new Room(103, "Suite", 5000));
    return rooms;
}


    public int getRoomNumber() {
        return roomNumber;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public String getRoomType() {
        return type;
    }

    public String getStatus() {
        return isAvailable ? "Available" : "Booked";
    }

    @Override
    public String toString() {
        return "Room " + roomNumber + " (" + type + ") - Rs." + price + " - " + getStatus();
    }

    public boolean isBooked() {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'isBooked'");
    }

    public void setBooked(boolean b) {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'setBooked'");
    }
}
