package shop;

public class Vehicle extends Goods {
    private double materialsCosts;
    private double salariesCosts;

    public Vehicle(double overcharge, double materialsCosts, double salariesCosts) {
        super(overcharge);

        this.materialsCosts = materialsCosts;
        this.salariesCosts = salariesCosts;
    }

    public double getMaterialsCosts() {
        return materialsCosts;
    }

    public double getSalariesCosts() {
        return salariesCosts;
    }

    @Override
    public double productionPrice() {
        return this.materialsCosts + this.salariesCosts;
    }

    @Override
    public String toString() {
        return "Vehicle{" + "materialsCosts: " + materialsCosts + "salariesCosts: " + salariesCosts + "}";
    }
}
