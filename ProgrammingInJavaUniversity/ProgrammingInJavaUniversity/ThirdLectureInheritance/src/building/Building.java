package building;

public class Building {
    private final double area;

    public Building(double area) {
        this.area = area;
    }

    public double getArea() {
        return this.area;
    }

    @Override
    public String toString() {
        return "Building{" + "area=" + area + '}';
    }
}
