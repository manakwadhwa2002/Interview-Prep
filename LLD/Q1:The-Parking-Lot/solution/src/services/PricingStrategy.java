package services;

public interface PricingStrategy {
    double calculateFee(long durationMs);
}
