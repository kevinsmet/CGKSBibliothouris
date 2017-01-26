package be.cegeka.bibliothouris.domain.book;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by williaam on 25/01/2017.
 */
@Named
public class BookRepository {
    @Inject
    private SearchBook searchBook;

    private List<Book> books = new ArrayList<>();

    public List<Book> getBooks() {
        return books;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book>  showSearchBookISBN(String nummer){
        return searchBook.searchIsbn(nummer, books);
    }
    public List<Book>  showSearchTitle(String letter){
        return searchBook.searchTitle(letter, books);
    }
    public List<Book>  showSearchAuthorFirstName(String letter){
        return searchBook.searchAuthorFirstName(letter, books);
    }
    public List<Book>  showSearchAuthorLastName(String letter){
        return searchBook.searchAuthorLastName(letter, books);
    }


}
