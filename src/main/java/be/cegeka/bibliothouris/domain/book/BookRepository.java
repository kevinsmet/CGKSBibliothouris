package be.cegeka.bibliothouris.domain.book;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
public class BookRepository {

    private List<Book> books = new ArrayList<>();

    public List<Book> getBooks() {
        return books;
    }

    public void addBook(Book book) {
        books.add(book);
    }


}
