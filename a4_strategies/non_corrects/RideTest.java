package a4_strategies.non_corrects;

import a4_strategies.RegularStrategy;

public class RideTest {
    public static void main(String[] args) {
        RideContext rideContext = new RideContext(new RegularStrategy());

        // Test regular fare during non-peak hours
        System.out.println("Regular Fare (10 km, 20 mins, non-peak): " + rideContext.calculateFare(10, 20, false));

        // Test surge pricing during peak hours
        System.out.println("Surge Fare (10 km, 20 mins, peak hours): " + rideContext.calculateFare(10, 20, true));

        // Test discount strategy for a short ride (less than 3 km)
        System.out.println("Discount Fare (2 km, 5 mins, non-peak): " + rideContext.calculateFare(2, 5, false));

        // Test invalid inputs
        try {
            System.out.println("Invalid Ride (negative distance): " + rideContext.calculateFare(-5, 10, false));
        } catch (IllegalArgumentException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }

        // Test minimum fare application
        System.out.println("Minimum Fare Test (0.5 km, 2 mins): " + rideContext.calculateFare(0.5, 2, false));
    }
}
