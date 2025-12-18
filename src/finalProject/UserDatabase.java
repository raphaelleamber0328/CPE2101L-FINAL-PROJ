package finalProject;

import java.io.*;
import java.util.ArrayList;


public class UserDatabase {

    // Singleton instance (Abstraction + Encapsulation)
    private static UserDatabase instance;

    // Private list ensures controlled access
    private ArrayList<User> userList;

    private final String FILE_NAME = "users.dat";

    // Private constructor enforces Singleton pattern
    private UserDatabase() {
        loadFromFile();

        // Automatically add a test account if database is empty
        if (userList.isEmpty()) {
            userList.add(new User(
                "test@flight.com",
                "pass123",
                "Test User",
                30,
                "09123456789",
                "Test Address",
                "test@flight.com"
            ));
            saveToFile();
        }
    }

    // Provides a single access point to the database
    public static UserDatabase getInstance() {
        if (instance == null) {
            instance = new UserDatabase();
        }
        return instance;
    }

    // Business logic: authentication
    public User authenticateUser(String email, String password) {
        for (User user : userList) {
            if (user.getEmail().equalsIgnoreCase(email)
                && user.getPassword().equals(password)) {
                return user; // Polymorphic return of a User object
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
        saveToFile();
    }

    // ================= FILE HANDLING (ENCAPSULATED) =================

    private void saveToFile() {
        try (ObjectOutputStream oos =
                 new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {

            // Polymorphism: User objects treated as Serializable
            oos.writeObject(userList);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    private void loadFromFile() {
        File file = new File(FILE_NAME);

        if (!file.exists()) {
            userList = new ArrayList<>();
            return;
        }

        try (ObjectInputStream ois =
                 new ObjectInputStream(new FileInputStream(file))) {

            userList = (ArrayList<User>) ois.readObject();

        } catch (Exception e) {
            userList = new ArrayList<>();
        }
    }
}

/*
 * ===================== ABSTRACTION =====================
 * The UserDatabase class abstracts all database-related operations:
 * - User storage
 * - Authentication
 * - File handling
 *
 * Other classes do NOT need to know how users are stored or loaded.
 *
 * ===================== ENCAPSULATION =====================
 * - userList is private
 * - File operations are hidden inside private methods
 *
 * ===================== INHERITANCE =====================
 * - Uses FileInputStream, ObjectInputStream, etc.,
 *   which inherit from InputStream and OutputStream.
 *
 * ===================== POLYMORPHISM =====================
 * - ObjectInputStream reads objects polymorphically
 *   as Serializable objects.
 * - Methods return User objects based on runtime conditions.
 */