package previous_assignments.a1.a4_strategies;

public class DiscountStrategy implements FareStrategy {
    @Override
    public double calculateFare(double distance, int duration, boolean isPeakHours) {
        return (0.8 * distance) + (0.2 * duration);  // $0.80 per km, $0.20 per minute
    }
}
