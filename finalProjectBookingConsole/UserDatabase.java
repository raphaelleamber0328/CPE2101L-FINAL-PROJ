package finalProjectBookingConsole;

import java.util.ArrayList;

public class UserDatabase {

	private static UserDatabase instance; // Encapsulation

	private final ArrayList<User> userList; // Encapsulation

	private UserDatabase() {
		userList = new ArrayList<>();
	} // Encapsulation

	public static UserDatabase getInstance() {
		if (instance == null) {
			instance = new UserDatabase();
		}
		return instance;
	} // Singleton

	public User authenticateUser(String email, String password) {
		for (User user : userList) {
			if (user.getEmail().equalsIgnoreCase(email) &&
					user.getPassword().equals(password)) {
				return user;
			}
		}
		return null;
	} // Abstraction

	public void addUser(User user) {
		userList.add(user);
	} // Encapsulation
}
