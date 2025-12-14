package Bonus;

public class PackageOptions {
    private int noOfPeople;
    private Pricing pricing;
    private String itinerary;
    private String accommodation;

    public PackageOptions(int noOfPeople, Pricing pricing,
                          String itinerary, String accommodation) {
        this.noOfPeople = noOfPeople;
        this.pricing = pricing;
        this.itinerary = itinerary;
        this.accommodation = accommodation;
    }

    public int getNoOfPeople() {
		return noOfPeople;
	}

	public void setNoOfPeople(int noOfPeople) {
		this.noOfPeople = noOfPeople;
	}

	public Pricing getPricing() {
		return pricing;
	}

	public void setPricing(Pricing pricing) {
		this.pricing = pricing;
	}

	public String getItinerary() {
		return itinerary;
	}

	public void setItinerary(String itinerary) {
		this.itinerary = itinerary;
	}

	public String getAccommodation() {
		return accommodation;
	}

	public void setAccommodation(String accommodation) {
		this.accommodation = accommodation;
	}

	public static class Pricing {
        private double price;
        private String discountName;
        private int discount;

        public Pricing(double price, String discountName, int discount) {
            this.price = price;
            this.discountName = discountName;
            this.discount = discount;
        }

        public double getPrice() { return price; }
        public String getDiscountName() { return discountName; }
        public int getDiscount() { return discount; }

    }
}

