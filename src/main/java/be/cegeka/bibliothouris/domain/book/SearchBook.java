package be.cegeka.bibliothouris.domain.book;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Named
public class SearchBook extends BookService {
    List<Book> bookList;

   /* public SearchBook(){
        bookList  = getAllBooks();
    }*/

    public String searchIsbn(String number) {
        bookList  = super.getAllBooks();
        List<Book> result = new ArrayList<>();
        Stream<Book> stream = bookList.stream();
        Pattern p = Pattern.compile(number);
        result = stream.filter(book -> p.matcher(book.getIsbn()).matches()).collect(Collectors.toList());
        return result.toString();
    }



    public List<Book> searchTitle(String letter) {
        List<Book> result = new ArrayList<>();
        Stream<Book> stream = bookList.stream();
        Pattern p = Pattern.compile(letter);
        result = stream.filter(book -> p.matcher(book.getTitle()).matches()).collect(Collectors.toList());
        return result;
    }


    public List<Book> searchAuthorLastName(String letter) {
        List<Book> result = new ArrayList<>();
        Stream<Book> stream = bookList.stream();
        Pattern p = Pattern.compile(letter);
        result = stream.filter(book -> p.matcher(book.getAuthorLastName()).matches()).collect(Collectors.toList());
        return result;
    }

    public List<Book> searchAuthorFirstName(String letter) {
        List<Book> result = new ArrayList<>();
        Stream<Book> stream = bookList.stream();
        Pattern p = Pattern.compile(letter);
        result = stream.filter(book -> p.matcher(book.getAuthorFirstName()).matches()).collect(Collectors.toList());
        return result;
    }

}
/*List<String>results =
         stream.filter(s -> pattern.matcher(s).matches())
               .collect(Collectors.toList());  // No side-effects!
 */

/* public static void main(String[] args) {
19         NumberAddition add = new NumberAddition(new ArrayList<Integer>());
20

21         add.addNumbers(number -> number>0) ;}
22

23     public void addNumbers(IntPredicate predicate) {
24         for (Integer number1 : number) {
25             if (predicate.test(number1)) {
26                 number.add(number1);
27             }
28         }
29

30     }
31

*/

