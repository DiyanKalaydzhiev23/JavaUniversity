package building;

public class Apartment extends PlaceInBuilding {
    private final int countBalconies;

    public Apartment(Building building, double area, int countBalconies) {
        super(building, area);
        this.countBalconies = countBalconies;
    }

    public int getCountBalconies() {
        return this.countBalconies;
    }

    @Override
    public String toString() {
        return "Apartment{" + "countBalconies=" + countBalconies + ", area=" + super.getArea() + '}';
    }
}
