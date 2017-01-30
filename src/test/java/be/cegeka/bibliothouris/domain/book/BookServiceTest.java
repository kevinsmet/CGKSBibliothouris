package be.cegeka.bibliothouris.domain.book;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.Arrays;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class BookServiceTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    private BookService bookService;

    @Mock
    private BookRepository bookRepository;

    /*  @Before
    public void setup() {
        Book bookTest = new Book("12345", "Harry Potter", "J.K.", "Rowling");
        bookRepository.addBook(bookTest);
    }
*/

    @Test
    public void addBook_ShouldCallUserRepository() throws Exception {
        bookService.addBook("20", "Da VInce Code", "Dan","Brown");
        verify(bookRepository).addBook(new Book("20", "Da VInce Code", "Dan","Brown"));
    }

    @Test
    public void getAllBooks() throws Exception {
        Book book1 = new Book("20", "Da VInce Code 0", "Dan0", "Brown0");
        Book book2 = new Book("30", "Da VInce Code 1", "Dan1", "Brown1");
        Book book3 = new Book("40", "Da VInce Code 2", "Dan2", "Brown2");

        when(bookRepository.getBooks()).thenReturn(Arrays.asList(book1, book2, book3));
        Assertions.assertThat(bookService.getAllBooks()).containsOnly(book1, book2, book3);
    }

    @Test
    public void detailBook_returnsBookDetails() throws Exception {
        when(bookRepository.getBooks()).thenReturn(Arrays.asList((new Book("12345", "Harry Potter", "J.K.", "Rowling"))));
        String expected = "ISBN : 12345 Title : Harry Potter";
        Assertions.assertThat(bookService.detailBook("12345")).isEqualTo(expected);
    }

    //When book repo gets books from getBooks method, make sure that these books are
    // also added to the list in bookService via List method 'getallbooks'
}
