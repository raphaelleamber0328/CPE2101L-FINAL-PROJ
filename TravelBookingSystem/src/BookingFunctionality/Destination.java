package BookingFunctionality;

public class Destination {
	
		private String name;
	    private double price;
	    private String description;

	    public Destination(String name, double price, String description) {
	        this.name = name;
	        this.price = price;
	        this.description = description;
	    }

	    public String getName() {
	        return name;
	    }

	    public double getPrice() {
	        return price;
	    }

	    public String getDescription() {
	        return description;
	    }

	    public String toString() {
	        return name;
	    }
	}
