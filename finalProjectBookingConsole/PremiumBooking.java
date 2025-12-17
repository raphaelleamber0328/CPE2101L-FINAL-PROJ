package finalProjectBookingConsole;

import java.util.Date;

public class PremiumBooking extends Booking {
    // Inheritance

    public PremiumBooking(User bookedBy, String destinationCity, String flightDetails, Date travelDate) {
        super(bookedBy, destinationCity, flightDetails, travelDate);
    }

    @Override
    public String getSeatClass() {
        return "Premium";
    }
    // Polymorphism
}
