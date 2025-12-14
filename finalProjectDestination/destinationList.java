package finalProjectDestination;

import finalProjectDestination.PackageOptions.Pricing;

public class destinationList {

    public static void main(String[] args) {

        // --- Create supporting objects (description, location, etc.) ---
        Description desc = new Description(
                "Beautiful coastal destination with clear waters.",
                "Coastal",
                "Tropical"
        );

        Location loc = new Location(
                "Philippines",
                "Boracay",
                "GMT+8"
        );

        PackageOptions.Pricing price = new PackageOptions.Pricing(
                15000.00,
                "Summer Sale",
                10
        );

        PackageOptions pkg = new PackageOptions(
                "Premium Package",
                2, // number of people
                price,
                "Day 1: Island hopping\nDay 2: Beach activities\nDay 3: Free time",
                "5-star beachfront resort"
        );

        Reviews review = new Reviews(
                4.8,
                2450
        );

        // --- Create a full destination object ---
        TravelDestinations boracay = new TravelDestinations(
                "DEST001",
                loc,
                desc,
                pkg,
                review
        );

        // Here you could print or store the destination
        System.out.println(boracay);
    }
}

