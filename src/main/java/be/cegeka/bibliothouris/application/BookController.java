package be.cegeka.bibliothouris.application;

import be.cegeka.bibliothouris.domain.book.Book;
import be.cegeka.bibliothouris.domain.book.BookService;
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

    @RequestMapping(value = "/book", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Book> getUsers() {
        return bookService.getAllBooks();
    }

    @RequestMapping(value = "/book", method = RequestMethod.POST)
    public
    @ResponseBody
    void addUser(@RequestParam(value = "titel", required = true) String title, @RequestParam(value = "firstName", required = true) String firstName, @RequestParam(value = "lastName", required = true) String lastName, @RequestParam(value = "isbn", required = true) String isbn) {
        bookService.addBook(isbn, title, firstName, lastName);
    }

    @RequestMapping(value = "/bookdetail", method = RequestMethod.GET)
    public
    @ResponseBody
    String detailBook(@RequestParam(value = "isbn", required = true) String isbn) {
        return bookService.detailBook(isbn);
    }

}



