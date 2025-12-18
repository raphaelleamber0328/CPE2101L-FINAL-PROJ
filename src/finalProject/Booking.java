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

    // Constants improve abstraction
    public static final String CONFIRMED = "Confirmed";
    public static final String CANCELED = "Canceled";

    public Booking(User bookedBy, String destinationCity,
                   String flightDetails, Date travelDate) {

        // Automatic ID generation hides implementation detail
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

    // Getter methods enforce encapsulation
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

    // Business rule for cancellation
    public boolean cancelBooking() {
        if (this.status.equals(CONFIRMED)) {
            if (travelDate.after(new Date())) {
                this.status = CANCELED;
                return true;
            }
        }
        return false;
    }

    // Runtime behavior depends on current date (Polymorphism)
    public abstract String getBookingType() {
        return travelDate.after(new Date()) ? "Upcoming" : "Past";
    }
}
	public String getSeatClass() {
		return null;
	}
}

/*
 * ===================== ABSTRACTION =====================
 * The Booking class abstracts the concept of a flight booking.
 * It hides internal booking details such as ID generation
 * and status rules from other classes.
 *
 * ===================== ENCAPSULATION =====================
 * - All booking details are private
 * - Status can only be changed through business rules
 *
 * ===================== INHERITANCE =====================
 * - Implements Serializable for file storage
 *
 * ===================== POLYMORPHISM =====================
 * - Booking objects are treated as Serializable
 *   when saved to a file.
 * - Date comparison behavior depends on runtime values.
 */
