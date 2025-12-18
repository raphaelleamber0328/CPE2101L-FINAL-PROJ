package finalProject;

import java.util.Date;

public class BusinessBooking extends Booking {
    // Inheritance

	private static final long serialVersionUID = 1L;

	public BusinessBooking(User bookedBy, String destinationCity, String flightDetails, Date travelDate) {
        super(bookedBy, destinationCity, flightDetails, travelDate);
    }

    public String getSeatClass() {
        return "Business"; 
    }
    // Polymorphism
}
