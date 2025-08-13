package com.hotelbilling;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RoomDAO {
    private Connection connection;

    public RoomDAO() {
        this.connection = DBConnection.getConnection();
    }

    // Add room using Room object
    public void addRoom(Room room) {
        String sql = "INSERT INTO rooms (room_type, price, status) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, room.getRoomType());
            stmt.setDouble(2, room.getPrice());
            stmt.setString(3, room.getStatus());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error adding room: " + e.getMessage());
        }
    }

    // Add room using individual fields
    public void addRoom(String type, double price, String status) {
        String sql = "INSERT INTO rooms (room_type, price, status) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, type);
            stmt.setDouble(2, price);
            stmt.setString(3, status);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error adding room: " + e.getMessage());
        }
    }

    // View all rooms
    public void viewRooms() {
        String sql = "SELECT * FROM rooms";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("Room ID: " + rs.getInt("id") +
                                   ", Type: " + rs.getString("room_type") +
                                   ", Price: " + rs.getDouble("price") +
                                   ", Status: " + rs.getString("status"));
            }
        } catch (SQLException e) {
            System.out.println("Error viewing rooms: " + e.getMessage());
        }
    }

    // Update room status
    public void updateRoomStatus(int roomId, String status) {
        String sql = "UPDATE rooms SET status = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, status);
            stmt.setInt(2, roomId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error updating room status: " + e.getMessage());
        }
    }

    // Get all rooms from DB
    public List<Room> getAllRooms() {
        List<Room> rooms = new ArrayList<>();
        String sql = "SELECT * FROM rooms";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Room room = new Room(
                    rs.getInt("id"),
                    rs.getString("room_type"),
                    rs.getDouble("price")
                );
                room.setAvailable("Available".equalsIgnoreCase(rs.getString("status")));
                rooms.add(room);
            }
        } catch (SQLException e) {
            System.out.println("Error getting rooms: " + e.getMessage());
        }
        return rooms;
    }

    // Get available rooms only
    public List<Room> getAvailableRooms() {
        List<Room> rooms = new ArrayList<>();
        String sql = "SELECT * FROM rooms WHERE status = 'Available'";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Room room = new Room(
                    rs.getInt("id"),
                    rs.getString("room_type"),
                    rs.getDouble("price")
                );
                room.setAvailable(true);
                rooms.add(room);
            }
        } catch (SQLException e) {
            System.out.println("Error getting available rooms: " + e.getMessage());
        }
        return rooms;
    }

    // Book room (set status to Booked)
    public boolean bookRoom(int roomId) {
        String sql = "UPDATE rooms SET status = 'Booked' WHERE id = ? AND status = 'Available'";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, roomId);
            int updated = stmt.executeUpdate();
            return updated > 0;
        } catch (SQLException e) {
            System.out.println("Error booking room: " + e.getMessage());
            return false;
        }
    }

    // Get room price by ID
    public double getRoomPrice(int roomId) {
        String sql = "SELECT price FROM rooms WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, roomId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getDouble("price");
            }
        } catch (SQLException e) {
            System.out.println("Error getting room price: " + e.getMessage());
        }
        return 0.0;
    }

    public Room findRoomByNumber(int roomNumber) {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'findRoomByNumber'");
    }

    public Room getRoom(int roomNumber) {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getRoom'");
    }
}
