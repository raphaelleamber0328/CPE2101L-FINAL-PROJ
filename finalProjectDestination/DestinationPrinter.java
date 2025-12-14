package finalProjectDestination;

public class DestinationPrinter {

    public static void printDestination(TravelDestinations dest) {

        System.out.println("\n========== TRAVEL DESTINATION ==========");
        System.out.println("Destination ID: " + dest.getDestinationID());

        System.out.println("\n--- LOCATION ---");
        System.out.println("Country: " + dest.getLocation().getCountry());
        System.out.println("City: " + dest.getLocation().getCity());
        System.out.println("Timezone: " + dest.getLocation().getTimezone());

        System.out.println("\n--- DESCRIPTION ---");
        System.out.println("Short Description: " + dest.getDescription().getShortDesc());
        System.out.println("Category: " + dest.getDescription().getCategory());
        System.out.println("Climate: " + dest.getDescription().getClimate());

        System.out.println("\n--- PACKAGE OPTIONS ---");
        System.out.println("Package: " + dest.getPackageOptions().getPackageOpt());
        System.out.println("Number of People: " + dest.getPackageOptions().getNoOfPeople());

        System.out.println("\n   >> PRICING <<");
        System.out.println("Base Price: " + dest.getPackageOptions().getPricing().getPrice());
        System.out.println("Discount Name: " + dest.getPackageOptions().getPricing().getDiscountName());
        System.out.println("Discount: " + dest.getPackageOptions().getPricing().getDiscount() + "%");

        System.out.println("\nItinerary: " + dest.getPackageOptions().getItinerary());
        System.out.println("Accommodation: " + dest.getPackageOptions().getAccommodation());

        System.out.println("\n--- REVIEWS ---");
        System.out.println("Star Rating: " + dest.getReviews().starRating);
        System.out.println("Reviews Count: " + dest.getReviews().reviewsCount);

        System.out.println("========================================\n");
    }
}

