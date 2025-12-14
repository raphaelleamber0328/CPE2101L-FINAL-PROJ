package Bonus;

public class FirstClass extends PackageOptions{
	private String FirstClassDescription;
	
	public FirstClass(int noOfPeople, Pricing pricing, String itinerary, String accommodation) {
		super(noOfPeople, pricing, itinerary, accommodation);
	}

	public String getFirstClassDescription() {
		return FirstClassDescription;
	}

	public void setFirstClassDescription(String firstClassDescription) {
		FirstClassDescription = firstClassDescription;
	}

}