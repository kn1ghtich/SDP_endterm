package a4_strategies;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RideTest {
    public static void main(String[] args) {
        RideContext rideContext = new RideContext(new RegularStrategy());;
        Map <String, FareStrategy> fares = new HashMap<String, FareStrategy>();
        FareStrategy fare;

        fares.put("Discount", new DiscountStrategy());
        fares.put("Premium", new PremiumStrategy());
        fares.put("Regular", new RegularStrategy());
        fares.put("Surge", new SurgeStrategy());

        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the Ride Test.");

        while (true) {
            try {
                System.out.println("What is your tariff?: ");
                fare = fares.get(sc.nextLine());

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
//        // Test regular fare during non-peak hours
//        System.out.println("Regular Fare (10 km, 20 mins, non-peak): " + rideContext.calculateFare(10, 20, false));
//
//        // Test surge pricing during peak hours
//        System.out.println("Surge Fare (10 km, 20 mins, peak hours): " + rideContext.calculateFare(10, 20, true));
//
//        // Test discount strategy for a short ride (less than 3 km)
//        System.out.println("Discount Fare (2 km, 5 mins, non-peak): " + rideContext.calculateFare(2, 5, false));
//
//        // Test invalid inputs
//        try {
//            System.out.println("Invalid Ride (negative distance): " + rideContext.calculateFare(-5, 10, false));
//        } catch (IllegalArgumentException e) {
//            System.out.println("Caught exception: " + e.getMessage());
//        }
//
//        // Test minimum fare application
//        System.out.println("Minimum Fare Test (0.5 km, 2 mins): " + rideContext.calculateFare(0.5, 2, false));
    }
}
