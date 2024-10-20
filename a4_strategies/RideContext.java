package a4_strategies;

public class RideContext {
    private FareStrategy fareStrategy;
    private static final double MINIMUM_FARE = 5.0;  // Minimum fare for short rides

    public RideContext(FareStrategy fareStrategy) {
        this.fareStrategy = fareStrategy;
    }

    public void setFareStrategy(FareStrategy fareStrategy) {
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
