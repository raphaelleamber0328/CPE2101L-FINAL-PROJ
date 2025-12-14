package Bonus;

public class EconomyClass extends PackageOptions{
	private String EconomyClassDescription;
	
	public EconomyClass(int noOfPeople, Pricing pricing, String itinerary, String accommodation) {
		super(noOfPeople, pricing, itinerary, accommodation);
	}

	public String getFirstClassDescription() {
		return EconomyClassDescription;
	}

	public void setFirstClassDescription(String firstClassDescription) {
		EconomyClassDescription = firstClassDescription;
	}

}
