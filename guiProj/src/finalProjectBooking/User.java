package finalProjectBooking;

import java.util.ArrayList;

public class User {
    private String username; 
    private String password;
    private String fullName;
    private int age;
    private String phoneNumber;
    private String email;
    private String address; 
    
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

    public String getPassword() { return password; }
    public String getFullName() { return fullName; }
    public String getEmail() { return email; }
    public String getPhoneNumber() { return phoneNumber; } 
    public int getAge() { return age; } 
    
        public ArrayList<Booking> getBookingHistory() { 
        return bookingHistory;
    }
    public void addBooking(Booking booking) { 
        this.bookingHistory.add(booking);
    }
}