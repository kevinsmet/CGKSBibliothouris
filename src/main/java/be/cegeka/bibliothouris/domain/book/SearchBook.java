package be.cegeka.bibliothouris.domain.book;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * Created by kevinsm on 25/01/2017.
 */
public class SearchBook {
    List<Book> bookList = new BookService().getAllBooks();

    public List<Book> searchIsbn(String number) {
        List<Book> result = new ArrayList<>();
        Stream<Book> stream = bookList.stream();
        Pattern p = Pattern.compile(number);
        result = stream.filter(book -> p.matcher(book.getIsbn()).matches()).collect(Collectors.toList());
        return result;
    }
}