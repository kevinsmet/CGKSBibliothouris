package be.cegeka.bibliothouris.domain.book;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Named

public class SearchBook  {

<<<<<<< HEAD


    public List<Book> searchIsbn(String number, List<Book> books) {
=======
    public List<Book>  searchIsbn(String number, List<Book> books) {
>>>>>>> e61e59704264f5177ae9d26e8ae6f78b24e8bbfd
        List<Book> result = new ArrayList<>();
        Stream<Book> stream = books.stream();
        Pattern p = Pattern.compile(".*"+number+".*");
        result = stream.filter(book -> p.matcher(book.getIsbn()).matches()).collect(Collectors.toList());
        return result;
    }

    public List<Book> searchTitle(String letter, List<Book> books) {
        List<Book> result = new ArrayList<>();
        Stream<Book> stream = books.stream();
        Pattern p = Pattern.compile(".*"+letter+".*");
        result = stream.filter(book -> p.matcher(book.getTitle()).matches()).collect(Collectors.toList());
        return result;
    }

    public List<Book> searchAuthorLastName(String letter, List<Book> books) {
        List<Book> result = new ArrayList<>();
        Stream<Book> stream = books.stream();
        Pattern p = Pattern.compile(".*"+letter+".*");
        result = stream.filter(book -> p.matcher(book.getAuthorLastName()).matches()).collect(Collectors.toList());
        return result;
    }

    public List<Book> searchAuthorFirstName(String letter, List<Book> books) {
        List<Book> result = new ArrayList<>();
        Stream<Book> stream = books.stream();
        Pattern p = Pattern.compile(".*"+letter+".*");
        result = stream.filter(book -> p.matcher(book.getAuthorFirstName()).matches()).collect(Collectors.toList());
        return result;
    }

}

