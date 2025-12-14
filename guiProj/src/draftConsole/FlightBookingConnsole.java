package draftConsole;

import java.util.*;

public class FlightBookingConnsole {

    static Scanner input = new Scanner(System.in);
    static ArrayList<Customer> customers = new ArrayList<>();

    static String[] places = { "Manila","Davao","Iloilo","Bacolod","Tacloban","Bohol" };
    static int[] prices     = { 3000,3500,2800,2700,2500,2600 };

    public static void main(String[] args){
        menu();
    }

    public static void menu(){
        while(true){
            System.out.println("\n===== FLIGHT BOOKING SYSTEM (Console) =====");
            System.out.println("[1] Create Account");
            System.out.println("[2] Login");
            System.out.println("[3] Exit");
            System.out.print("Select: ");
            int ch = input.nextInt(); input.nextLine();

            switch(ch){
                case 1 -> createAccount();
                case 2 -> loginAccount();
                case 3 -> { System.out.println("Thank you!"); return; }
                default -> System.out.println("Invalid input.");
            }
        }
    }

    // ================= CREATE ACCOUNT =================
    public static void createAccount(){
        System.out.println("\n=== CREATE ACCOUNT ===");
        System.out.print("First Name: "); String fn = input.nextLine();
        System.out.print("Last Name: ");  String ln = input.nextLine();
        System.out.print("Age: ");        int age = input.nextInt(); input.nextLine();

        if(age < 18){ System.out.println("Must be 18+ to register."); return; }

        System.out.print("Email: ");    String email = input.nextLine();
        System.out.print("Password: "); String pass = input.nextLine();

        customers.add(new Customer(fn,ln,age,email,pass));
        System.out.println("Account Created Successfully!");
    }

 
    public static void loginAccount(){
        System.out.println("\n=== LOGIN ===");
        System.out.print("Email: ");
        String email = input.nextLine();
        System.out.print("Password: ");
        String pass = input.nextLine();

        for(Customer c : customers){
            if(c.email.equals(email) && c.password.equals(pass)){
                System.out.println("Login Successful!");
                c.displayInfo();  // polymorphism in action
                bookFlight(c);
                return;
            }
        }
        System.out.println("Account not found!");
    }

    public static void bookFlight(Customer user){
        while(true){
            System.out.println("\n=== FLIGHT BOOKING ===");
            System.out.println("Available destinations:");
            for(int i=0;i<places.length;i++){
                System.out.println((i+1)+". "+places[i]+" - ₱"+prices[i]);
            }
            System.out.print("Choose Destination: ");
            int choice = input.nextInt(); input.nextLine();

            if(choice<1 || choice>places.length){ 
                System.out.println("Invalid choice"); continue;
            }

            System.out.print("How many seats? ");
            int seat = input.nextInt(); input.nextLine();
            int total = prices[choice-1] * seat;

            System.out.println("\n--- BOOKING DETAILS ---");
            System.out.println("Passenger: " + user.getEmail());
            System.out.println("Destination: " + places[choice-1]);
            System.out.println("Seats: " + seat);
            System.out.println("Total Price: ₱" + total);
            System.out.println("Booking Confirmed!\n");
            return;
        }
    }
}

