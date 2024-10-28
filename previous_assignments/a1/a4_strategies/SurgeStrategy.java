package previous_assignments.a1.a4_strategies;

public class SurgeStrategy implements FareStrategy {
    @Override
    public double calculateFare(double distance, int duration, boolean isPeakHours) {
        double rateMultiplier = isPeakHours ? 2.0 : 1.0;  // Double the rate during peak hours
        return rateMultiplier * ((1.0 * distance) + (0.25 * duration));  // Base rates with surge
    }
}
