package a4_strategies;

public class RegularStrategy implements FareStrategy {
    @Override
    public double calculateFare(double distance, int duration, boolean isPeakHours) {
        return (1.0 * distance) + (0.25 * duration);  // $1.00 per km, $0.25 per minute
    }
}