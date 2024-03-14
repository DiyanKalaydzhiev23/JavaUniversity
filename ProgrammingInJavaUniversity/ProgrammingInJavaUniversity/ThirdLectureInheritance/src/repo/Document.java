package repo;

public class Document {
    private final double docSize;
    private final String format;
    private final String title;

    public Repo repo;

    public Document(double docSize, String format, String title) {
        this.docSize = docSize;
        this.format = format;
        this.title = title;
        this.repo = null;
    }

    public Repo getRepo() {
        return repo;
    }

    public void setRepo(Repo repo) {
        this.repo = repo;
    }

    public double getDocSize() {
        return this.docSize;
    }

    public String getFormat() {
        return this.format;
    }

    public String getTitle() {
        return this.title;
    }

    @Override
    public String toString() {
        return "Document{" + "docSize=" + docSize + ", format=" + format + ", title=" + title + ", repo=" + repo + '}';
    }
}
