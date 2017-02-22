package be.cegeka.bibliothouris.domain.book;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
public class BookRepository {

    //Repo should have the methods to search books by cedrtains parameters
    @Inject
    private SearchBook searchBook;

    //Bookrepo should not know bookservice
    @Inject
    private BookService bookService;

    private List<Book> books = new ArrayList<>();

    public List<Book> getBooks() {
        return books;
    }

    public void addBook(Book book) {
        books.add(book);
    }

}
