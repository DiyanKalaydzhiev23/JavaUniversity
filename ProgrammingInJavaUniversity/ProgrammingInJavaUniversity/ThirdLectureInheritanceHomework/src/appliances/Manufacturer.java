package appliances;

public class Manufacturer {
    protected final String name;
    protected final boolean providesExtendedWarranty;

    public Manufacturer(String name, boolean providesWarranty) {
        this.name = name;
        this.providesExtendedWarranty = providesWarranty;
    }
}
