package finalProjectBooking;

import java.util.ArrayList;

public class UserDatabase {
    private static UserDatabase instance; 
    private final ArrayList<User> userList; 

    private UserDatabase() { 
        userList = new ArrayList<>();
        userList.add(new User("test@flight.com", "pass123", "Test User", 30, "09123456789", "Test Address", "test@flight.com"));
    }

    public static UserDatabase getInstance() { 
        if (instance == null) {
            instance = new UserDatabase();
        }
        return instance;
    }

    public User authenticateUser(String email, String password) { 
        for (User user : userList) {
            if (user.getEmail().equalsIgnoreCase(email) && user.getPassword().equals(password)) {
                return user; 
            }
        }
        return null;
    }

    public User findUserByEmail(String email) { 
        for (User user : userList) {
            if (user.getEmail().equalsIgnoreCase(email)) {
                return user;
            }
        }
        return null;
    }

    public void addUser(User user) { 
        userList.add(user);
    }
}