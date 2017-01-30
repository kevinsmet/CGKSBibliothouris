package be.cegeka.bibliothouris.application;

import be.cegeka.bibliothouris.domain.book.Book;
import be.cegeka.bibliothouris.domain.book.BookRepository;
import be.cegeka.bibliothouris.domain.book.BookService;
import be.cegeka.bibliothouris.domain.book.SearchBook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by williaam on 25/01/2017.
 */
@Controller


public class BookController {


    @Inject
    private BookService bookService;

    @Inject
     private BookRepository bookRepository;

    @RequestMapping(value = "/book", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Book> getBook() {
        return bookService.getAllBooks();
    }

    @RequestMapping(value = "/book", method = RequestMethod.POST)
    public
    @ResponseBody
    void addBook(@RequestParam(value = "titel", required = true) String title,
                 @RequestParam(value = "firstName", required = true) String firstName,
                 @RequestParam(value = "lastName", required = true) String lastName,
                 @RequestParam(value = "isbn", required = true) String isbn) {
        bookService.addBook(isbn, title, firstName, lastName);
    }

    @RequestMapping(value = "/bookdetail", method = RequestMethod.GET)
    public
    @ResponseBody
    String detailBook(@RequestParam(value = "isbn", required = true) String isbn) {
        return bookService.detailBook(isbn);
    }


    @RequestMapping(value = "/booksearch/isbn", method = RequestMethod.GET)
    public
    @ResponseBody
    String  searchIsbn(@RequestParam(value = "isbn", required = true) String isbn) {
        return bookRepository.showSearchBookISBN(isbn);
    }

    @RequestMapping(path = "/booksearch/title", method = RequestMethod.GET)
    public
    @ResponseBody
    String   searchTitle(@RequestParam(value = "title", required = true) String letter) {
        return bookRepository.showSearchTitle(letter);
    }

    @RequestMapping(path = "/booksearch/lastName", method = RequestMethod.GET)
    public
    @ResponseBody
    String  searchAuthorLastName(@RequestParam(value = "lastName", required = true) String letter) {
        return bookRepository.showSearchAuthorLastName(letter);
    }

    @RequestMapping(path = "/booksearch/firstName", method = RequestMethod.GET)
    public
    @ResponseBody
    String  searchAuthorFirstName(@RequestParam(value = "firstName", required = true) String letter) {
        return bookRepository.showSearchAuthorFirstName(letter);

    }

}



