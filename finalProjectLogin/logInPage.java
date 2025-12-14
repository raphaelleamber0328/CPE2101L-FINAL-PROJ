package finalProjectLogin;
import java.util.Scanner;

public class logInPage {

    static User user = null;  // store the user object

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nUSER SYSTEM MENU");
            System.out.println("1. Register");
            System.out.println("2. Log In");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    register(sc);
                    break;
                case 2:
                    login(sc);
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        } while (choice != 3);

        sc.close();
    }

    public static void register(Scanner sc) {
        System.out.print("\nEnter Username: ");
        String username = sc.nextLine();

        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        System.out.print("Confirm Password: ");
        String confirm = sc.nextLine();

        if (!password.equals(confirm)) {
            System.out.println("Passwords do not match. Registration failed.");
            return;
        }

        System.out.print("Enter Full Name: ");
        String fullName = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Phone Number: ");
        String phone = sc.nextLine();

        System.out.print("Enter Address: ");
        String address = sc.nextLine();

        System.out.print("Enter Email Address: ");
        String email = sc.nextLine();

        user = new User(username, password, fullName, age, phone, address, email);
        System.out.println("Registration successful!");
    }

    public static void login(Scanner sc) {
        if (user == null) {
            System.out.println("No users registered yet.");
            return;
        }

        System.out.print("\nEnter Username: ");
        String u = sc.nextLine();

        System.out.print("Enter Password: ");
        String p = sc.nextLine();

        if (u.equals(user.getUsername()) && p.equals(user.getPassword())) {
            System.out.println("Login successful!");
            profileMenu(sc);
        } else {
            System.out.println("Invalid credentials.");
        }
    }

    public static void profileMenu(Scanner sc) {
        int choice;

        do {
            System.out.println("\nPROFILE MENU");
            System.out.println("1. View Profile");
            System.out.println("2. Update Profile");
            System.out.println("3. Log Out");
            System.out.print("Choose an option: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    viewProfile();
                    break;
                case 2:
                    updateProfile(sc);
                    break;
                case 3:
                    System.out.println("Logging out...");
                    break;
            }
        } while (choice != 3);
    }

    public static void viewProfile() {
        System.out.println("\nUSER PROFILE");
        System.out.println("Full Name: " + user.getFullName());
        System.out.println("Age: " + user.getAge());
        System.out.println("Phone Number: " + user.getPhoneNumber());
        System.out.println("Address: " + user.getAddress());
        System.out.println("Email Address: " + user.getEmail());
    }


    public static void updateProfile(Scanner sc) {
        int choice;

        do {
            System.out.println("\nUPDATE PROFILE");
            System.out.println("1. Update Full Name");
            System.out.println("2. Update Age");
            System.out.println("3. Update Phone Number");
            System.out.println("4. Update Address");
            System.out.println("5. Update Email Address");
            System.out.println("6. Back to Profile Menu");
            System.out.print("Choose an option: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter New Full Name: ");
                    user.setFullName(sc.nextLine());
                    System.out.println("Full Name updated!");
                    break;

                case 2:
                    System.out.print("Enter New Age: ");
                    user.setAge(sc.nextInt());
                    sc.nextLine();
                    System.out.println("Age updated!");
                    break;

                case 3:
                    System.out.print("Enter New Phone Number: ");
                    user.setPhoneNumber(sc.nextLine());
                    System.out.println("Phone Number updated!");
                    break;

                case 4:
                    System.out.print("Enter New Address: ");
                    user.setAddress(sc.nextLine());
                    System.out.println("Address updated!");
                    break;

                case 5:
                    System.out.print("Enter New Email Address: ");
                    user.setEmail(sc.nextLine());
                    System.out.println("Email updated!");
                    break;

                case 6:
                    System.out.println("Returning to profile menu...");
                    break;

                default:
                    System.out.println("Invalid option.");
            }

        } while (choice != 6);
    }

}
