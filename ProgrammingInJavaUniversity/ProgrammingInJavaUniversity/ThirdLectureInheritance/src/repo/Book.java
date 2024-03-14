package repo;

public class Book extends Document {
    // композиция - запълнен ромб най-тясна - единия обект е в другия окект - двигателя е в колата
    // асоцияция - аз имам кола имам компютър - показва се със стрелка

    private Author author;  // асоцияция
    private String isbn;


    public Book(double docSize, String format, String title, Author author, String isbn) {
        super(docSize, format, title);
        this.author = author;
        this.isbn = isbn;
    }

    public Author getAuthor() {
        return this.author;
    }

    public String getIsbn() {
        return this.isbn;
    }

    @Override
    public String toString() {
        return "Book{" +
                "docSize=" + super.getDocSize() +
                ", format=" + super.getFormat() +
                ", title=" + super.getTitle() +
                ", author=" + author +
                ", isbn=" + isbn +
                '}';
    }

}
