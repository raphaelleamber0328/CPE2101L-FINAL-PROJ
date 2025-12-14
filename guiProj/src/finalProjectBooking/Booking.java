package finalProjectBooking;

import java.util.Date;
import java.util.UUID; 

public class Booking {
    private String bookingID; 
    private User bookedBy; 
    private String destinationCity; 
    private String flightDetails; 
    private Date dateBooked; 
    private Date travelDate; 
    private String status; 

    public static final String CONFIRMED = "Confirmed";
    public static final String CANCELED = "Canceled";

    public Booking(User bookedBy, String destinationCity, String flightDetails, Date travelDate) { 
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
        if (this.status.equals(CONFIRMED)) {
            if (travelDate.after(new Date())) {
                this.status = CANCELED;
                return true;
            }
        }
        return false;
    }
    
    public String getBookingType() {
        return travelDate.after(new Date()) ? "Upcoming" : "Past";
    }
}