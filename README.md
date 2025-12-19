## Introduction 

This project is a local travel booking system designed to allow users to book domestic flights from Cebu to different destinations within the Philippines. The system provides essential features such as creating an account, flight searching, booking confirmation, and booking history management.
The application is implemented using Java with Object-Oriented Programming (OOP) principles and includes a Graphical User Interface (GUI) developed using Java Swing. The system ensures data organization, code reusability, and maintainability by applying abstraction, encapsulation, inheritance, and polymorphism. This project demonstrates how object-oriented concepts can be used to model real-world travel booking scenarios effectively.


## Object Oriented Analysis
Object-Oriented Analysis (OOA) focuses on identifying the software requirements and translating real-world entities into system objects.

Functional Requirements:
- Users can create an account and can log in.
- Users can search for flights from Cebu to selected Philippine destinations.
- Users can select flight class, travel date, and number of seats.
- Users can confirm and cancel bookings but you can only cancel if it is a future booking.
- Users can view their booking history.

Non-Functional Requirements:
- System must be user-friendly through a GUI.
- Data should be securely encapsulated.
- System should be easy to maintain.
- System should support future enhancements 

Identified Objects: 

User – can create and manage flight bookings.

Booking – general concept of a flight booking and contains common booking information such as booking ID, destination, travel date, and status.

EconomyBooking – represents an economy-class flight booking and inherits from the Booking class, reusing its attributes and behaviors while providing a specific seat classification.

BusinessBooking – represents a business-class flight booking and inherits from the Booking class, extending the base booking functionality with business-class specific behavior.

UserDatabase – manages user records, authentication, and persistent storage.

GUI Components – handle user interaction.

## Object Oriented Design

The Flight Booking System is architected using the four fundamental pillars of Object-Oriented Programming (OOP), ensuring the application remains modular, extensible, and maintainable.

I. Core OOP Principles Implementation

1. Encapsulation: This principle is strictly applied to ensure data integrity and security. In the User and Booking classes, all sensitive attributes—such as password, email, and status—are declared with private access modifiers. Direct external manipulation is prohibited; instead, interaction is mediated through controlled public getter methods, such as getPassword() and getStatus(), which protect the internal state of the objects.

2. Inheritance: The system employs a hierarchical class structure to maximize code reuse. The BusinessBooking and EconomyBooking classes extend the base Booking class, inheriting core attributes like destinationCity, travelDate, and the unique ID generation logic. This specialization allows the system to support diverse booking types while maintaining a single, shared source of truth for general booking behaviors.

3. Polymorphism: The system utilizes both static and dynamic polymorphism. Dynamic polymorphism is achieved through Method Overriding, where subclasses provide distinct implementations of the getSeatClass() method—returning "Business" or "Economy" respectively—despite being treated as the parent Booking type during runtime. Furthermore, polymorphic behavior is used in file I/O operations, where the UserDatabase handles various objects as Serializable types.

4. Abstraction: Complexity is managed by exposing only essential features while hiding the underlying mechanics. For example, the Booking class abstracts the generation of an 8-character unique identifier via UUID, presenting a finished string to the interface without exposing the generation algorithm. Similarly, the UserDatabase class abstracts the entire data persistence layer, allowing the UI to save or load data without knowledge of the specific file handling logic.


