package a4_strategies.non_corrects;

import a4_strategies.DiscountStrategy;
import a4_strategies.FareStrategy;
import a4_strategies.RegularStrategy;
import a4_strategies.SurgeStrategy;

public class RideContext {
    private FareStrategy fareStrategy;
    private static final double MINIMUM_FARE = 5.0;  // Minimum fare for short rides

    public RideContext(FareStrategy fareStrategy) {
        this.fareStrategy = fareStrategy;
    }

    public void setFareStrategy(FareStrategy fareStrategy) {
        this.fareStrategy = fareStrategy;
    }

    // Automatically selects a fare strategy based on the conditions (e.g., time of day, distance)
    public void selectStrategy(boolean isPeakHours, double distance) {
        if (isPeakHours) {
            setFareStrategy(new SurgeStrategy());
        } else if (distance < 3.0) {
            setFareStrategy(new DiscountStrategy());
        } else {
            setFareStrategy(new RegularStrategy());
        }
    }

    // Calculate fare and handle edge cases (e.g., invalid inputs and minimum fare)
    public double calculateFare(double distance, int duration, boolean isPeakHours) {
        if (distance < 0 || duration < 0) {
            throw new IllegalArgumentException("Distance or duration cannot be negative");
        }

        // Select strategy based on conditions if not already set
        selectStrategy(isPeakHours, distance);

        // Calculate the fare
        double fare = fareStrategy.calculateFare(distance, duration, isPeakHours);

        // Apply minimum fare if applicable
        return Math.max(fare, MINIMUM_FARE);
    }
}
