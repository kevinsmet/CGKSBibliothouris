package be.cegeka.bibliothouris.domain.book;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by williaam on 25/01/2017.
 */
@Named
public class BookService {

    @Inject
    private BookRepository bookRepository;
    @Inject
    private SearchBook searchBook;

    public List<Book> getAllBooks() {
        return bookRepository.getBooks();
    }

    public void addBook(String isbn, String title, String authorFirstName, String authorLastName) {
        Book book = new Book(isbn, title, authorFirstName, authorLastName);
        bookRepository.addBook(book);
    }

    public String detailBook(String isbn) {
        String output = "";
        for (Book book : getAllBooks()) {
<<<<<<< HEAD
            if (isbn.equals(book.getIsbn())){
                output = "ISBN : "+book.getIsbn() + " \r\n Title : "+book.getTitle();
=======
            if (isbn.equals(book.getIsbn())) {
                output = "ISBN : " + book.getIsbn() + " Title : " + book.getTitle();
<<<<<<< HEAD
>>>>>>> d76ba9c688b5903c31e90dfd2aa76d10de5a216f

=======
>>>>>>> e2ac84ddfdf50243d8a1917559df383e6452973e
            }
        }
        return output;
    }

    public String printSearch(List<Book> resultBooks){
        String result = "";
        if(resultBooks.isEmpty()){
            result= "No books match that search criteria";
        }
        for(Book book : resultBooks){
            result += book.toString();
        }
        return result;
    }

    public String showSearchBookISBN(String number){
        return printSearch(searchBook.searchIsbn(number, getAllBooks()));
    }

    public String   showSearchTitle(String letter){
        return printSearch(searchBook.searchTitle(letter, getAllBooks()));
    }

    public String   showSearchAuthorFirstName(String letter){
        return printSearch(searchBook.searchAuthorFirstName(letter, getAllBooks()));
    }

    public String  showSearchAuthorLastName(String letter){
        return printSearch(searchBook.searchAuthorLastName(letter, getAllBooks()));
    }

}
