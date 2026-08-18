package services;

public class HourlyStrategy implements PricingStrategy{

    private final double hourlyRate;
    public HourlyStrategy(double rate){ this.hourlyRate = rate; }

    @Override
    public double calculateFee(long durationMs){
        double hours = Math.ceil(durationMs/3600000.0);
        return Math.max(1.0, hours)*hourlyRate;
    }

}
