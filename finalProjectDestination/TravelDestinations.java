package finalProjectDestination;

public class TravelDestinations {
    private String destinationID;
    private Location location;
    private Description description;
    private PackageOptions packageOptions;
    private Reviews reviews;

    public TravelDestinations(String destinationID, Location location, Description description,
                              PackageOptions packageOptions, Reviews reviews) {
        this.destinationID = destinationID;
        this.location = location;
        this.description = description;
        this.packageOptions = packageOptions;
        this.reviews = reviews;
    }

	public String getDestinationID() {
		return destinationID;
	}

	public void setDestinationID(String destinationID) {
		this.destinationID = destinationID;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Description getDescription() {
		return description;
	}

	public void setDescription(Description description) {
		this.description = description;
	}

	public PackageOptions getPackageOptions() {
		return packageOptions;
	}

	public void setPackageOptions(PackageOptions packageOptions) {
		this.packageOptions = packageOptions;
	}

	public Reviews getReviews() {
		return reviews;
	}

	public void setReviews(Reviews reviews) {
		this.reviews = reviews;
	}
    public String toString() {
        return "\n========== TRAVEL DESTINATION ==========" +
                "\nDestination ID: " + destinationID +
                "\n" + location +
                "\n" + description +
                "\n" + packageOptions +
                "\n" + reviews +
                "\n========================================\n";
    }
}
