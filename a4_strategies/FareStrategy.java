package a4_strategies;

public interface FareStrategy {
    double calculateFare(double distance, int duration, boolean isPeakHours);
}
