package appliances;

public class Cooker extends ElectricDevice {
    private static final int addWarranty = 12;
    private final boolean isOnGas;

    public Cooker(ElectricDevice electricDevice, int minMonthsWarranty, boolean isOnGas) {
        super(electricDevice.manufacturer, minMonthsWarranty);
        this.isOnGas = isOnGas;
    }

    public boolean getIsOnGas() {
        return this.isOnGas;
    }

    public int warranty() {
        return super.warranty() + (isOnGas ? addWarranty : 0);
    }
}
