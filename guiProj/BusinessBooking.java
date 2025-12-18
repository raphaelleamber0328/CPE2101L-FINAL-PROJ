package guiProj;

import java.util.Date;

public class BusinessBooking extends Booking {
    // Inheritance

    public BusinessBooking(User bookedBy, String destinationCity, String flightDetails, Date travelDate) {
        super(bookedBy, destinationCity, flightDetails, travelDate);
    }

    public String getSeatClass() {
        return "Business"; 
    }
    // Polymorphism
}
