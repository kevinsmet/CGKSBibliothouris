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

    public List<Book> getAllBooks(){
        return bookRepository.getBooks();
    }


    public void addBook(String isbn, String title, String authorFirstName, String authorLastName){
        Book book = new Book(isbn, title, authorFirstName, authorLastName);
        bookRepository.addBook(book);
    }

    public String detailBook (String isbn) {
        String output = "";
        for (Book book : getAllBooks()) {
            if (isbn.equals(book.getIsbn())){
                output = "ISBN : "+book.getIsbn() + " Title : "+book.getTitle();

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

    public String showSearchIsbn(String isbn) {
        return searchBook.searchIsbn(isbn);
    }







}
