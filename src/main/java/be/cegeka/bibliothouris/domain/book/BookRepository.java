package be.cegeka.bibliothouris.domain.book;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
public class BookRepository {
    @Inject
    private SearchBook searchBook;

    @Inject
    private BookService bookService;

    private List<Book> books = new ArrayList<>();

    public List<Book> getBooks() {
        return books;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public String showSearchBookISBN(String nummer){
        return bookService.printSearch(searchBook.searchIsbn(nummer, books));
    }
<<<<<<< HEAD
    public String showSearchTitle(String letter){
        return bookService.printSearch(searchBook.searchTitle(letter, books));
    }
    public String showSearchAuthorFirstName(String letter){
        return bookService.printSearch(searchBook.searchAuthorFirstName(letter, books));
    }
    public String showSearchAuthorLastName(String letter){
=======

    public String   showSearchTitle(String letter){
        return bookService.printSearch(searchBook.searchTitle(letter, books));
    }

    public String   showSearchAuthorFirstName(String letter){
        return bookService.printSearch(searchBook.searchAuthorFirstName(letter, books));
    }

    public String  showSearchAuthorLastName(String letter){
>>>>>>> e61e59704264f5177ae9d26e8ae6f78b24e8bbfd
        return bookService.printSearch(searchBook.searchAuthorLastName(letter, books));
    }


}
