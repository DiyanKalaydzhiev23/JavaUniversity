import repo.Author;
import repo.Book;
import repo.Document;
import repo.Repo;


public class Main {
    public static void repo(String[] args) {
        Repo repo1 = new Repo(20);
        Repo repo2 = new Repo(30, 5, 12);

        System.out.println(repo1);
        System.out.println(repo2);

        Document document1 = new Document(5, "txt", "Doc 1");
        Document document2 = new Document(8, "txt", "Doc 2");

        System.out.println(document1);
        System.out.println(document2);

        Author author1 = new Author("Ivanov");

        System.out.println(author1);

        Book book1 = new Book(10, "pdf", "Book 1", author1, "12231");
        System.out.println(book1);

        System.out.println(repo1.uploadDocument(document2));
        System.out.println(repo1.uploadDocument(document2));
        System.out.println(repo1.uploadDocument(document2));
        System.out.println(repo1);

        Document docRef = document2;
        System.out.println(docRef);

        docRef = book1; // late connection
        System.out.println(docRef);
    }

    public static void main(String[] args) {

    }
}