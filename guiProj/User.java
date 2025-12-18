package guiProj;

import java.util.ArrayList;

public class User {

	private String username;
	private String password;
	private String fullName;
	private int age;
	private String phoneNumber;
	private String address;
	private String email;

	private ArrayList<Booking> bookingHistory; // Encapsulation

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

	public String getUsername() { return username; }
	public String getPassword() { return password; }
	public String getFullName() { return fullName; }
	public int getAge() { return age; }
	public String getPhoneNumber() { return phoneNumber; }
	public String getAddress() { return address; }
	public String getEmail() { return email; }

	public void setFullName(String fullName) {
		this.fullName = fullName;
	} // Encapsulation

	public void setAge(int age) {
		this.age = age;
	} // Encapsulation

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	} // Encapsulation

	public void setAddress(String address) {
		this.address = address;
	} // Encapsulation

	public void setEmail(String email) {
		this.email = email;
	} // Encapsulation

	public ArrayList<Booking> getBookingHistory() {
		return bookingHistory;
	} // Encapsulation

	public void addBooking(Booking booking) {
		bookingHistory.add(booking);
	} // Encapsulation
}
