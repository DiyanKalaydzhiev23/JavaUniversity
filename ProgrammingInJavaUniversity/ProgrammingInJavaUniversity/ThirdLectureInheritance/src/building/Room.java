package building;

public class Room {
    private final Building building;
    private final Apartment apartment;
    private final int countBeds;
    private final double area;

    public Room(Building building, Apartment apartment, int countBeds, double area) {
        this.building = building;
        this.apartment = apartment;
        this.countBeds = countBeds;
        this.area = area;
    }

    public Building getBuilding() {
        return this.building;
    }

    public Apartment getApartment() {
        return this.apartment;
    }

    public int getCountBeds() {
        return this.countBeds;
    }

    @Override
    public String toString() {
        return "Room{" +
                "building=" + building +
                ", apartment=" + apartment +
                ", countBeds=" + countBeds +
                ", area=" + area +
                '}';
    }

}
