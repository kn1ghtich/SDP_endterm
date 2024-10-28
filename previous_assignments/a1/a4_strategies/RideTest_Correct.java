package previous_assignments.a1.a4_strategies;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RideTest_Correct {
    public static void main(String[] args) {
        Map <String, FareStrategy> fares = new HashMap<String, FareStrategy>();
        FareStrategy fare;
        Double distance;
        Integer duration;
        Boolean isPeakHours;

        fares.put("Discount", new DiscountStrategy());
        fares.put("Premium", new PremiumStrategy());
        fares.put("Regular", new RegularStrategy());
        fares.put("Surge", new SurgeStrategy());

        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the Ride Test.");

        while (true) {
            try {
                System.out.print("What is your tariff?: ");
                fare = fares.get(sc.nextLine());
                RideContext_Correct rideContext = new RideContext_Correct(fare);
                System.out.print("Enter your distance: ");
                distance = Double.parseDouble(sc.nextLine());
                System.out.print("Enter your time: ");
                duration = Integer.parseInt(sc.nextLine());
                System.out.print("Is it peak hours?(yes/no): ");
                isPeakHours = sc.nextLine().equalsIgnoreCase("yes");

                System.out.println(rideContext.calculateFare(distance, duration, isPeakHours));

                System.out.print("Do you want to continue? (Y/N): ");
                if (sc.nextLine().equalsIgnoreCase("no")) {
                    break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }
}
