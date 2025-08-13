package com.hotelbilling;

public class Customer {
    private String name;
    private String phone;
    private String email;
    private Room bookedRoom;

    // Constructor without booking yet
    public Customer(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.bookedRoom = null; // no booking yet
    }

    // Constructor with booking
    public Customer(String name, String phone, String email, Room bookedRoom) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.bookedRoom = bookedRoom;
    }

    public String getName() { return name; }
    public String getPhone() { return phone; }
    public String getEmail() { return email; }
    public Room getBookedRoom() { return bookedRoom; }

    public void setBookedRoom(Room bookedRoom) {
        this.bookedRoom = bookedRoom;
    }

    @Override
    public String toString() {
        return "Customer: " + name + " (" + phone + "), Email: " + email +
               ", Booked Room: " + (bookedRoom != null ? bookedRoom : "None");
    }
}
