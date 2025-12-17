package finalProjectBookingConsole;

import java.util.Date;

public class EconomyBooking extends Booking {
    // Inheritance

    public EconomyBooking(User bookedBy, String destinationCity, String flightDetails, Date travelDate) {
        super(bookedBy, destinationCity, flightDetails, travelDate);
    }

    public String getSeatClass() {
        return "Economy";
    }
    // Polymorphism
}
