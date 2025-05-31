package hotelmanagement.main;

import hotelmanagement.model.Room;
import hotelmanagement.model.Customer;
import hotelmanagement.service.HotelService;

import java.util.Scanner;

public class HotelManagementApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HotelService hotelService = new HotelService(5); // 5 rooms

        while (true) {
            System.out.println("\nHotel Management System");
            System.out.println("1. Book Room");
            System.out.println("2. Vacate Room");
            System.out.println("3. View All Rooms");
            System.out.println("4. View All Customers");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter customer name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter contact number: ");
                    String contact = scanner.nextLine();
                    boolean booked = hotelService.bookRoom(name, contact);
                    System.out.println(booked ? "Room booked successfully!" : "No available rooms.");
                    break;

                case 2:
                    System.out.print("Enter room number to vacate: ");
                    int roomNumber = scanner.nextInt();
                    boolean vacated = hotelService.vacateRoom(roomNumber);
                    System.out.println(vacated ? "Room vacated successfully!" : "Invalid room number or already vacant.");
                    break;

                case 3:
                    for (Room room : hotelService.getAllRooms()) {
                        System.out.println(room);
                    }
                    break;

                case 4:
                    for (Customer customer : hotelService.getAllCustomers()) {
                        System.out.println(customer);
                    }
                    break;

                case 5:
                    System.out.println("Exiting... Thank you!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
