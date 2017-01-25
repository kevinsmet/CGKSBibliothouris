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

    public List<Book> getAllBooks(){
        return bookRepository.getBooks();
    }

    public void addBook(int isbn, String title, String authorFirstName, String authorLastName){

        bookRepository.addBook(new Book(isbn, title, authorFirstName, authorLastName));
    }

    public String detailBook (int isbn) {
        String output = "";
        for (Book book : getAllBooks()) {
            if (isbn == book.getIsbn()){
                output = "ISBN : "+book.getIsbn() + " Title : "+book.getTitle();

            }
        }
        return output;
    }

}
