package hotelmanagement.service;

import hotelmanagement.model.Customer;
import hotelmanagement.model.Room;

import java.util.ArrayList;
import java.util.List;

public class HotelService {
    private List<Room> rooms;
    private List<Customer> customers;

    public HotelService(int totalRooms) {
        rooms = new ArrayList<>();
        customers = new ArrayList<>();
        for (int i = 1; i <= totalRooms; i++) {
            rooms.add(new Room(i));
        }
    }

    public boolean bookRoom(String name, String contact) {
        for (Room room : rooms) {
            if (!room.isBooked()) {
                room.bookRoom();
                customers.add(new Customer(name, contact, room.getRoomNumber()));
                return true;
            }
        }
        return false; // No rooms available
    }

    public boolean vacateRoom(int roomNumber) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber && room.isBooked()) {
                room.vacateRoom();
                customers.removeIf(c -> c.getRoomNumber() == roomNumber);
                return true;
            }
        }
        return false;
    }

    public List<Room> getAllRooms() {
        return rooms;
    }

    public List<Customer> getAllCustomers() {
        return customers;
    }
}
