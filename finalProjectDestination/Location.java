package finalProjectDestination;

public class Location {
	private String country;
	private String city;
	private String timezone;
	
	public Location(String country, String city, String timezone) {
		this.country = country;
		this.city = city;
		this.timezone = timezone;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getTimezone() {
		return timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}
	  public String toString() {
	        return "Location: " +
	               "\n   Country: " + country +
	               "\n   City: " + city +
	               "\n   Timezone: " + timezone;
	  }
}
