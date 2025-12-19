package finalProject;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

public abstract class Booking implements Serializable {

    private static final long serialVersionUID = 1L;

    private String bookingID;
    private User bookedBy;
    private String destinationCity;
    private String flightDetails;
    private Date dateBooked;
    private Date travelDate;
    private String status;

    public static final String CONFIRMED = "Confirmed";
    public static final String CANCELED = "Canceled";

    // Constructor
    public Booking(User bookedBy, String destinationCity,
                   String flightDetails, Date travelDate) {

        this.bookingID = UUID.randomUUID()
                .toString()
                .substring(0, 8)
                .toUpperCase();

        this.bookedBy = bookedBy;
        this.destinationCity = destinationCity;
        this.flightDetails = flightDetails;
        this.dateBooked = new Date();
        this.travelDate = travelDate;
        this.status = CONFIRMED;
    }

    //getters
    public String getBookingID() {
        return bookingID;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public String getFlightDetails() {
        return flightDetails;
    }

    public Date getDateBooked() {
        return dateBooked;
    }

    public Date getTravelDate() {
        return travelDate;
    }

    public String getStatus() {
        return status;
    }

    
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

    // abstraction
    public abstract String getSeatClass();
}
