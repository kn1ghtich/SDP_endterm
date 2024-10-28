package previous_assignments.a1.a4_strategies;

public class RideContext_Correct {
    private FareStrategy fareStrategy;
    private static final double MINIMUM_FARE = 5.0;

    public RideContext_Correct(FareStrategy fareStrategy) {
        this.fareStrategy = fareStrategy;
    }


    public double calculateFare(double distance, int duration, boolean isPeakHours) {
        if (distance < 0 || duration < 0) {
            throw new IllegalArgumentException("Distance or duration cannot be negative");
        }
        double fare = fareStrategy.calculateFare(distance, duration, isPeakHours);
        return Math.max(fare, MINIMUM_FARE);
    }
}
