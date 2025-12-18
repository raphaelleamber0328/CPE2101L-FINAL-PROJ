package finalProjectBookingConsole;

import java.util.Date;

import finalProjectBooking.Booking;
import finalProjectBooking.User;

public class PremiumBooking extends Booking {

    private double premiumFee = 1500;

    public PremiumBooking(
            User bookedBy,
            String destinationCity,
            String flightDetails,
            Date travelDate
    ) {
        super(bookedBy, destinationCity, flightDetails, travelDate);
    }

    public double getPremiumFee() {
        return premiumFee;
    }

    @Override
    public String getBookingType() {
        return "Premium - " + super.getBookingType();
    }
}
