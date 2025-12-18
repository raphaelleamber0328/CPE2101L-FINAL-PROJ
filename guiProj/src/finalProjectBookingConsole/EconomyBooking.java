package finalProjectBookingConsole;

import java.util.Date;

import finalProjectBooking.Booking;
import finalProjectBooking.User;

public class EconomyBooking extends Booking {

    public EconomyBooking(
            User bookedBy,
            String destinationCity,
            String flightDetails,
            Date travelDate
    ) {
        super(bookedBy, destinationCity, flightDetails, travelDate);
    }

    @Override
    public String getBookingType() {
        return "Economy - " + super.getBookingType();
    }
}
