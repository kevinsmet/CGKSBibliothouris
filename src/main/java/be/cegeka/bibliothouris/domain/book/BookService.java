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
        List<Book> books = searchBook.searchIsbn(isbn,getAllBooks());
        if (books.size()>0)
        {
            //book.get(0) should be extracted in another method
            return "ISBN : " + books.get(0).getIsbn() + " \r\n Title : " + books.get(0).getTitle();
        }
        return "";
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

    //should be in repo
    public String showSearchBookISBN(String number){
        return printSearch(searchBook.searchIsbn(number, getAllBooks()));
    }

    public String showSearchTitle(String letter){
        return printSearch(searchBook.searchTitle(letter, getAllBooks()));
    }

    public String showSearchAuthorFirstName(String letter){
        return printSearch(searchBook.searchAuthorFirstName(letter, getAllBooks()));
    }

    public String showSearchAuthorLastName(String letter){
        return printSearch(searchBook.searchAuthorLastName(letter, getAllBooks()));
    }

}
