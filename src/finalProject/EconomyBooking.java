package finalProject;

import java.util.Date;

public class EconomyBooking extends Booking {
    // Inheritance

	private static final long serialVersionUID = 1L;

	public EconomyBooking(User bookedBy, String destinationCity, String flightDetails, Date travelDate) {
        super(bookedBy, destinationCity, flightDetails, travelDate);
    }

    public String getSeatClass() {
        return "Economy";
    }
    // Polymorphism
}
