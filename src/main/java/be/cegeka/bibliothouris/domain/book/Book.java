package be.cegeka.bibliothouris.domain.book;

/**
 * Created by williaam on 25/01/2017.
 */
public class Book {

    private int isbn;
    private String title;
    private String authorFirstName;
    private String authorLastName;

    public Book(int isbn, String title, String authorName, String authorLastName) {
        this.isbn = isbn;
        this.title = title;
        this.authorFirstName = authorName;
        this.authorLastName = authorLastName;
    }

    public int getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthorFirstName() {
        return authorFirstName;
    }

    public String getAuthorLastName() {
        return authorLastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        return isbn == book.isbn;
    }

    @Override
    public int hashCode() {
        return isbn;
    }
}
