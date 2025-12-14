package finalProjectDestination;

public class Description {
	private String shortDesc;
	private String category; //if coastal ba or mountainy chuchu
	private String climate;
	
	public Description(String shortDesc, String category, String climate) {
		this.shortDesc = shortDesc;
		this.category = category;
		this.climate = climate;
	}

	public String getShortDesc() {
		return shortDesc;
	}

	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getClimate() {
		return climate;
	}

	public void setClimate(String climate) {
		this.climate = climate;
	}
	
	public String toString() {
        return "Description: " +
               "\n   Short Description: " + shortDesc +
               "\n   Category: " + category +
               "\n   Climate: " + climate;
    }
	
}
