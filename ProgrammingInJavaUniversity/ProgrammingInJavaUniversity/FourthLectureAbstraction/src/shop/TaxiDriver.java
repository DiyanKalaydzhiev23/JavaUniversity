package shop;


public class TaxiDriver extends RegisteredProvider {
    private double distanceTraveled;
    private double priceForKm;

    public TaxiDriver(String regNumber, double distanceTravel, double priceForKm) {
        super(regNumber);

        this.distanceTraveled = distanceTravel;
        this.priceForKm = priceForKm;
    }

    @Override
    public double earnings() {
        return this.distanceTraveled * this.priceForKm;
    }
}
