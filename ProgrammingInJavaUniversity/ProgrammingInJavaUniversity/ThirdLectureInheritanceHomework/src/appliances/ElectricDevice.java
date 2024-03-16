package appliances;

import static java.lang.Math.max;

public class ElectricDevice {
    private static final int addWarranty = 12;
    protected final Manufacturer manufacturer;
    protected final int minMonthsWarranty;

    public ElectricDevice(Manufacturer manufacturer, int minMonthsWarranty) {
        this.manufacturer = manufacturer;
        this.minMonthsWarranty = setMinMonthsWarranty(minMonthsWarranty);
    }

    public int setMinMonthsWarranty(int minMonthsWarranty) {
        return max(minMonthsWarranty, 6);
    }

    public int warranty() {
        return this.minMonthsWarranty + (this.manufacturer.providesExtendedWarranty ? addWarranty : 0);
    }
}
