package delivery;

import static java.lang.Math.max;

public class WeightedItem extends DeliverableItem {
    private Material material;
    private double weight;
    private double priceForKgDelivery;

    public WeightedItem(Material material, double weight, double priceForKgDelivery, boolean deliveredToAddress) {
        super(deliveredToAddress);

        this.material = material;
        this.setWeight(weight);
        this.setPriceForKgDelivery(priceForKgDelivery);
    }

    public void setWeight(double weight) {
        this.weight = max(weight, 1);
    }

    public void setPriceForKgDelivery(double weight) {
        this.priceForKgDelivery = max(weight, 1);
    }

    public double deliveryPrice() {
        double totalPrice = this.priceForKgDelivery * this.weight;

        if (super.deliveredToAddress) {
            totalPrice = totalPrice + DeliverableItem.extraPrice;
        }

        if (material.getIsFragile()) {
            totalPrice = totalPrice * 1.01;
        }

        return totalPrice;
    }

}
