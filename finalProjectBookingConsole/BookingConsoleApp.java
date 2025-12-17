package finalProjectBookingConsole;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class BookingConsoleApp {

    private static final Scanner scanner = new Scanner(System.in);

    private static final UserDatabase userDatabase = UserDatabase.getInstance();
    // Singleton

    private static final String[] destinations = {
            "Manila", "Davao", "Iloilo", "Bacolod", "Tacloban", "Bohol"
    };

    private static final String[] flightNumbers = {
            "PR101", "PR202", "PR303", "PR404", "PR505", "PR606"
    };

    private static final String[] departureTimes = {
            "08:00 AM", "09:30 AM", "07:45 AM", "01:15 PM", "10:00 AM", "06:30 AM"
    };

    private static final String[] arrivalTimes = {
            "09:30 AM", "11:00 AM", "09:15 AM", "02:45 PM", "11:30 AM", "08:00 AM"
    };

    public static void main(String[] args) throws Exception {

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        User user = userDatabase.authenticateUser(email, password);
        // Encapsulation

        if (user == null) {
            System.out.print("Full Name: ");
            String name = scanner.nextLine();

            System.out.print("Age: ");
            int age = Integer.parseInt(scanner.nextLine());

            System.out.print("Phone: ");
            String phone = scanner.nextLine();

            user = new User(email, password, name, age, phone, "N/A", email);
            userDatabase.addUser(user);
            // Encapsulation
        }

        while (true) {
            System.out.println("1 Create Booking");
            System.out.println("2 View Bookings");
            System.out.println("3 Cancel Booking");
            System.out.println("4 Exit");

            int choice = Integer.parseInt(scanner.nextLine());

            if (choice == 1) {

                System.out.println("Available Destinations:");
                for (int i = 0; i < destinations.length; i++) {
                    System.out.println(
                            (i + 1) + " " + destinations[i] +
                            " | Flight " + flightNumbers[i] +
                            " | " + departureTimes[i] +
                            " - " + arrivalTimes[i]
                    );
                }

                System.out.print("Choose destination number: ");
                int destChoice = Integer.parseInt(scanner.nextLine()) - 1;

                if (destChoice < 0 || destChoice >= destinations.length) {
                    System.out.println("Invalid destination");
                    continue;
                }

                String flightDetails =
                        "Flight " + flightNumbers[destChoice] +
                        " | Depart " + departureTimes[destChoice] +
                        " | Arrive " + arrivalTimes[destChoice];

                System.out.print("Travel Date yyyy-MM-dd: ");
                Date date = new SimpleDateFormat("yyyy-MM-dd")
                        .parse(scanner.nextLine());

                System.out.print("Class (1 Economy, 2 Premium): ");
                int cls = Integer.parseInt(scanner.nextLine());

                Booking booking;

                if (cls == 1) {
                    booking = new EconomyBooking(
                            user,
                            destinations[destChoice],
                            flightDetails,
                            date
                    );
                } else {
                    booking = new PremiumBooking(
                            user,
                            destinations[destChoice],
                            flightDetails,
                            date
                    );
                }
                // Polymorphism
                // Inheritance

                user.addBooking(booking);
                // Association

                System.out.println("Booking created. ID: " + booking.getBookingID());
            }

            if (choice == 2) {
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

                for (Booking b : user.getBookingHistory()) {
                    System.out.println("Booking ID: " + b.getBookingID());
                    System.out.println("Passenger: " + user.getFullName());
                    System.out.println("Destination: " + b.getDestinationCity());
                    System.out.println("Flight Info: " + b.getFlightDetails());
                    System.out.println("Travel Date: " + df.format(b.getTravelDate()));
                    System.out.println("Date Booked: " + df.format(b.getDateBooked()));
                    System.out.println("Seat Class: " + b.getSeatClass());
                    System.out.println("Status: " + b.getStatus());
                    System.out.println("Type: " + b.getBookingType());
                    System.out.println();
                }
                // Polymorphism
            }

            if (choice == 3) {
                System.out.print("Booking ID: ");
                String id = scanner.nextLine();

                for (Booking b : user.getBookingHistory()) {
                    if (b.getBookingID().equalsIgnoreCase(id)) {
                        System.out.println(
                                b.cancelBooking()
                                        ? "Booking canceled"
                                        : "Cannot cancel booking"
                        );
                    }
                }
            }

            if (choice == 4) {
                break;
            }
        }
    }
}
