package appliances;

public class WashingMachine extends ElectricDevice {
    private static final int addWarranty = 12;
    private final boolean hasDryFunction;

    public WashingMachine(ElectricDevice electricDevice, int minMonthsWarranty, boolean hasDryFunction) {
        super(electricDevice.manufacturer, minMonthsWarranty);
        this.hasDryFunction = hasDryFunction;
    }

    public int warranty() {
        return super.warranty() + (hasDryFunction ? super.minMonthsWarranty / 2 : 0);
    }
}
