package be.cegeka.bibliothouris.domain.book;

/**
 * Created by williaam on 25/01/2017.
 */
public class Book {

    private String isbn;
    private String title;
    private String authorFirstName;
    private String authorLastName;

    public Book(String isbn, String title, String authorName, String authorLastName) {
        this.isbn = isbn;
        this.title = title;
        this.authorFirstName = authorName;
        this.authorLastName = authorLastName;
    }

    public String getIsbn() {
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

        return isbn != null ? isbn.equals(book.isbn) : book.isbn == null;
    }

    @Override
    public int hashCode() {
        return isbn != null ? isbn.hashCode() : 0;
    }

    //USE stringbuilder or string.format
    // '+' makes a new string not like an append
    public String toString(){
        return "ISBN:" + isbn + "\n" +  "Title:" + title + "\n" + "First Name:" + authorFirstName + "\n" + "Last Name:" + authorLastName+ "\n\n";
    }
}

