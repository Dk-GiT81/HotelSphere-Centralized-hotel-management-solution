package com.hotelbilling;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {
    private List<Customer> customers = new ArrayList<>();

    public CustomerDAO(Connection conn) {
      //TODO Auto-generated constructor stub
    }

    // Add a new customer
    public int addCustomer(Customer customer) {
        customers.add(customer);
        System.out.println("Customer added: " + customer.getName());
        return 0;
    }

    // Get all customers
    public List<Customer> getAllCustomers() {
        return customers;
    }

    // Find customer by phone
    public Customer findCustomerByPhone(String phone) {
        for (Customer customer : customers) {
            if (customer.getPhone().equals(phone)) {
                return customer;
            }
        }
        return null;
    }

    // Book a room for customer
    public boolean bookRoom(String phone, Room room) {
        Customer customer = findCustomerByPhone(phone);
        if (customer != null) {
            if (room.isBooked()) {
                System.out.println("Room " + room.getRoomNumber() + " is already booked!");
                return false;
            }
            customer.setBookedRoom(room);
            room.setBooked(true);
            System.out.println("Room " + room.getRoomNumber() + " booked for " + customer.getName());
            return true;
        } else {
            System.out.println("Customer not found!");
            return false;
        }
    }

    // Cancel booking
    public boolean cancelBooking(String phone) {
        Customer customer = findCustomerByPhone(phone);
        if (customer != null && customer.getBookedRoom() != null) {
            Room room = customer.getBookedRoom();
            room.setBooked(false);
            customer.setBookedRoom(null);
            System.out.println("Booking cancelled for customer: " + customer.getName());
            return true;
        } else {
            System.out.println("No booking found for this customer.");
            return false;
        }
    }
}
