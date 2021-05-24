import java.util.ArrayList;
import java.util.Date;

public class hanterareStoreStub extends hanterareStore{

    ArrayList<Book> bocker = null;

    hanterareStoreStub(){
        bocker = new ArrayList<Book>();
    }


    public void addBook(int uniktID, String name, int isbn)  {
        Book b = new Book(uniktID, name, isbn);
       bocker.add(b);
    }


    @Override
    public Book[] getAllBooks() {
        Book[] bookArr = new Book[bocker.size()];
        return bocker.toArray(bookArr);
    }

}
