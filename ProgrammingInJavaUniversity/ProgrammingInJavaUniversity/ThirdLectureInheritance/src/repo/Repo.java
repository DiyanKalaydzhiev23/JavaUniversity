package repo;

public class Repo {
    private double limit;
    private int numberOfDocument;
    private double usedSpace;

    public Repo(double limit, int numberOfDocument, double usedSpace) {
        this.limit = limit;
        this.numberOfDocument = numberOfDocument;
        this.usedSpace = usedSpace;
    }

    public Repo(double limit) {
        this.limit = limit;
        this.numberOfDocument = 0;
        this.usedSpace = 0;
    }

    public double getFreeSpace() {
        return this.limit - this.usedSpace;
    }

    public boolean uploadDocument(Document document) {
        if (this.getFreeSpace() < document.getDocSize()) {
            return false;
        }

        this.usedSpace += document.getDocSize();
        this.numberOfDocument++;

        document.setRepo(this);

        return true;
    }

    @Override
    public String toString() {
        return "Repo{" + "limit=" + limit + ", numberOfDocument=" + numberOfDocument + ", usedSpace=" + usedSpace + '}';
    }
}
