package finalProjectBookingConsole;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class BookingConsoleApp {

    private static Scanner scanner = new Scanner(System.in);
    private static UserDatabase userDatabase = UserDatabase.getInstance();

    public static void main(String[] args) {

        System.out.println("Flight Booking System");

        User loggedInUser = login();

        if (loggedInUser == null) {
            System.out.println("Login failed");
            return;
        }

        int choice;
        do {
            System.out.println("1. Create Booking");
            System.out.println("2. View Bookings");
            System.out.println("3. Cancel Booking");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    createBooking(loggedInUser);
                    break;
                case 2:
                    viewBookings(loggedInUser);
                    break;
                case 3:
                    cancelBooking(loggedInUser);
                    break;
                case 4:
                    System.out.println("Thank you for using the system");
                    break;
                default:
                    System.out.println("Invalid option");
            }
        } while (choice != 4);
    }

    private static User login() {
        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        User user = userDatabase.authenticateUser(email, password);

        if (user != null) {
            System.out.println("Login successful");
            return user;
        }

        System.out.println("Account not found");

        System.out.print("Full Name: ");
        String fullName = scanner.nextLine();

        System.out.print("Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Phone Number: ");
        String phone = scanner.nextLine();

        System.out.print("Address: ");
        String address = scanner.nextLine();

        User newUser = new User(
                email,
                password,
                fullName,
                age,
                phone,
                address,
                email
        );

        userDatabase.addUser(newUser);
        System.out.println("Account created successfully");

        return newUser;
    }

    private static void createBooking(User user) {
        try {
            System.out.print("Destination City: ");
            String city = scanner.nextLine();

            System.out.print("Flight Details: ");
            String flightDetails = scanner.nextLine();

            System.out.print("Travel Date (yyyy-MM-dd): ");
            String dateInput = scanner.nextLine();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date travelDate = sdf.parse(dateInput);

            System.out.println("Choose Booking Type");
            System.out.println("1. Economy");
            System.out.println("2. Premium");
            System.out.print("Choice: ");
            int type = scanner.nextInt();
            scanner.nextLine();

            Booking booking;

            if (type == 2) {
                booking = new PremiumBooking(user, city, flightDetails, travelDate);
            } else {
                booking = new EconomyBooking(user, city, flightDetails, travelDate);
            }

            user.addBooking(booking);

            System.out.println("Booking created successfully");
            System.out.println("Booking ID: " + booking.getBookingID());

        } catch (ParseException e) {
            System.out.println("Invalid date format");
        }
    }

    private static void viewBookings(User user) {
        if (user.getBookingHistory().isEmpty()) {
            System.out.println("No bookings found");
            return;
        }

        for (Booking b : user.getBookingHistory()) {
            System.out.println("ID: " + b.getBookingID());
            System.out.println("Destination: " + b.getDestinationCity());
            System.out.println("Flight: " + b.getFlightDetails());
            System.out.println("Travel Date: " + b.getTravelDate());
            System.out.println("Status: " + b.getStatus());
            System.out.println("Type: " + b.getBookingType());
        }
    }

    private static void cancelBooking(User user) {
        System.out.print("Enter Booking ID to cancel: ");
        String id = scanner.nextLine();

        for (Booking b : user.getBookingHistory()) {
            if (b.getBookingID().equalsIgnoreCase(id)) {
                if (b.cancelBooking()) {
                    System.out.println("Booking canceled successfully");
                } else {
                    System.out.println("Booking cannot be canceled");
                }
                return;
            }
        }
        System.out.println("Booking ID not found");
    }
}
