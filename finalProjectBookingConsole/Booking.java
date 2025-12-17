package finalProjectBookingConsole;

import java.util.Date;
import java.util.UUID;

public abstract class Booking {
    // Abstraction

    protected String bookingID;
    protected User bookedBy;
    // Encapsulation

    protected String destinationCity;
    protected String flightDetails;
    protected Date dateBooked;
    protected Date travelDate;
    protected String status;

    public static final String CONFIRMED = "Confirmed";
    public static final String CANCELED = "Canceled";

    public Booking(User bookedBy, String destinationCity, String flightDetails,
                   Date travelDate) {

        this.bookingID = UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        this.bookedBy = bookedBy;
        this.destinationCity = destinationCity;
        this.flightDetails = flightDetails;
        this.dateBooked = new Date();
        this.travelDate = travelDate;
        this.status = CONFIRMED;
    }

    public String getBookingID() { return bookingID; }
    public String getDestinationCity() { return destinationCity; }
    public String getFlightDetails() { return flightDetails; }
    public Date getDateBooked() { return dateBooked; }
    public Date getTravelDate() { return travelDate; }
    public String getStatus() { return status; }

    public boolean cancelBooking() {
        if (status.equals(CONFIRMED) && travelDate.after(new Date())) {
            status = CANCELED;
            return true;
        }
        return false;
    }

    public String getBookingType() {
        return travelDate.after(new Date()) ? "Upcoming" : "Past";
    }

    public abstract String getSeatClass();
    // Polymorphism
}
