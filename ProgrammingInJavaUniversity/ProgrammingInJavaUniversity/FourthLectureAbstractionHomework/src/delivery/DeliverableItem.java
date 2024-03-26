package delivery;


import static java.lang.Math.max;

public abstract class DeliverableItem implements Deliverable {
    public static double extraPrice;
    protected boolean deliveredToAddress;

    public DeliverableItem(boolean deliveredToAddress) {
        this.deliveredToAddress = deliveredToAddress;
    }

    public static void setExtraPrice(double extraPrice) {
        DeliverableItem.extraPrice = max(extraPrice, 1);
    }

    abstract public double deliveryPrice();
}
