package building;

public class PlaceInBuilding {
    private final Building building;
    private final double area;

    public PlaceInBuilding(Building building, double area) {
        this.building = building;
        this.area = area;
    }

    public Building getBuilding() {
        return this.building;
    }

    public double getArea() {
        return this.area;
    }

    @Override
    public String toString() {
        return "PlaceInBuilding{" + "building=" + building + ", area=" + area + '}';
    }
}
