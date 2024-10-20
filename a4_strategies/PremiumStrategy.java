package a4_strategies;

public class PremiumStrategy implements FareStrategy {
    @Override
    public double calculateFare(double distance, int duration, boolean isPeakHours) {
        return (2.0 * distance) + (0.5 * duration);  // $2.00 per km, $0.50 per minute
    }
}