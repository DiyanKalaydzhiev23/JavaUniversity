package delivery;

import static java.lang.Math.max;

public class Document extends DeliverableItem {
    private double minPriceForDelivery;

    public Document(double minPriceForDelivery, boolean deliveredToAddress) {
        super(deliveredToAddress);
        this.setMinPriceForDelivery(minPriceForDelivery);
    }

    public void setMinPriceForDelivery(double minPriceForDelivery) {
        this.minPriceForDelivery = max(minPriceForDelivery, 1);
    }

    public double deliveryPrice() {
        if (super.deliveredToAddress) {
            return this.minPriceForDelivery + DeliverableItem.extraPrice;
        }

        return this.minPriceForDelivery;
    }
}
