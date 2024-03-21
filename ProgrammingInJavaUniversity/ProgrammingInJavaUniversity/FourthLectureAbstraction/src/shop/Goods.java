package shop;

public abstract class Goods implements Sellable, Producable {
    private double overcharge;

    public abstract double productionPrice();

    public Goods(double overcharge) {
        this.overcharge = overcharge;
    }

    public double getOvercharge() {
        return this.overcharge;
    }

    @Override
    public double sellingPrice() {
        return this.overcharge / 100 * this.productionPrice() + this.productionPrice();
    }

    @Override
    public String toString() {
        return "Goods{" + "overcharge: " + overcharge + "}";
    }
}
