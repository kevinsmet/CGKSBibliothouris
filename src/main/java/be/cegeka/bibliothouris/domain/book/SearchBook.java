package be.cegeka.bibliothouris.domain.book;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Named
public class SearchBook {

    public List<Book> searchIsbn(String isbnNumber, List<Book> books) {
        //Pattern pattern = getPattern(number);
        //book -> p.matcher(book.getIsbn()).matches() == Predicate
        return filter(books, book -> getPattern(isbnNumber).matcher(book.getIsbn()).matches());
    }

    private Pattern getPattern(String unformattedRegEx) {
        unformattedRegEx = unformattedRegEx.replaceAll("\\*", ".*");
        return Pattern.compile(".*" + unformattedRegEx + ".*");
    }

    private List<Book> filter(List<Book> books, Predicate<Book> bookPredicate) {
        return books.stream().filter(bookPredicate).collect(Collectors.toList());
    }

    //Rename the variables to better names
    //check above
    public List<Book> searchTitle(String letter, List<Book> books) {
        List<Book> result = new ArrayList<>();
        letter = letter.replaceAll("\\*", ".*");
        Stream<Book> stream = books.stream();
        Pattern p = Pattern.compile(".*" + letter + ".*");
        result = stream.filter(book -> p.matcher(book.getTitle()).matches()).collect(Collectors.toList());
        return result;
    }
    //check above
    public List<Book> searchAuthorLastName(String letter, List<Book> books) {
        List<Book> result = new ArrayList<>();
        letter = letter.replaceAll("\\*", ".*");
        Stream<Book> stream = books.stream();
        Pattern p = Pattern.compile(".*" + letter + ".*");
        result = stream.filter(book -> p.matcher(book.getAuthorLastName()).matches()).collect(Collectors.toList());
        return result;
    }
    //check above
    public List<Book> searchAuthorFirstName(String letter, List<Book> books) {
        List<Book> result = new ArrayList<>();
        letter = letter.replaceAll("\\*", ".*");
        Stream<Book> stream = books.stream();
        Pattern p = Pattern.compile(".*" + letter + ".*");
        result = stream.filter(book -> p.matcher(book.getAuthorFirstName()).matches()).collect(Collectors.toList());
        return result;
    }

}

