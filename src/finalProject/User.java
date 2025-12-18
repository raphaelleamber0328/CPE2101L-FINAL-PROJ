package finalProject;

import java.io.Serializable;
import java.util.ArrayList;


public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    // Encapsulated user data
    private String username;
    private String password;
    private String fullName;
    private int age;
    private String phoneNumber;
    private String email;
    private String address;

    // Abstraction: User HAS-A list of Booking objects
    private ArrayList<Booking> bookingHistory;

    public User(String username, String password, String fullName, int age,
                String phoneNumber, String address, String email) {

        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.email = email;
        this.bookingHistory = new ArrayList<>();
    }

    // Getters provide controlled access (Encapsulation)
    public String getPassword() { return password; }
    public String getFullName() { return fullName; }
    public String getEmail() { return email; }
    public String getPhoneNumber() { return phoneNumber; }
    public int getAge() { return age; }

    public ArrayList<Booking> getBookingHistory() {
        return bookingHistory;
    }

    // Business logic method
    public void addBooking(Booking booking) {
        this.bookingHistory.add(booking);
    }
}

/*
 * ===================== ABSTRACTION =====================
 * The User class represents the real-world concept of a system user.
 * It abstracts user-related details such as login credentials and
 * booking history into a single logical unit.
 *
 * The internal details (how bookings are stored, how data is saved)
 * are hidden from other classes.
 *
 * ===================== ENCAPSULATION =====================
 * - All fields are declared private.
 * - Access to data is controlled through public getter methods.
 * - This protects the integrity of user data.
 *
 * ===================== INHERITANCE =====================
 * - This class implements Serializable.
 * - Serializable is a marker interface that allows objects of this
 *   class to be converted into a byte stream for file storage.
 *
 * ===================== POLYMORPHISM =====================
 * - The User object is treated as a Serializable object
 *   when written to a file using ObjectOutputStream.
 */