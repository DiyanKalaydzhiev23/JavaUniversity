package building;

public class Office extends PlaceInBuilding {
    private final int countWorkingSpaces;

    public Office(Building building, double area, int countWorkingSpaces) {
        super(building, area);
        this.countWorkingSpaces = countWorkingSpaces;
    }

    public int getCountWorkingSpaces() {
        return this.countWorkingSpaces;
    }

    @Override
    public String toString() {
        return "Office{" + "countWorkingSpaces=" + countWorkingSpaces + ", area=" + super.getArea() + '}';
    }
}
