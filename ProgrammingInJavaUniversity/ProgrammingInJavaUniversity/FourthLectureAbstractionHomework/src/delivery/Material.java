package delivery;

public class Material {
    private String name;
    private boolean isFragile;

    public Material(String name, boolean isFragile) {
        this.name = name;
        this.isFragile = isFragile;
    }

    public boolean getIsFragile() {
        return this.isFragile;
    }
}
