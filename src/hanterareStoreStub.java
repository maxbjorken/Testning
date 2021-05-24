import java.util.ArrayList;

public class hanterareStoreStub extends hanterareStore{

    ArrayList<Book> bocker = null;

    hanterareStoreStub(){
        bocker = new ArrayList<Book>();
    }



    @Override
    public Book[] getAllBooks(Book[] books) {
        Book[] bookArr = new Book[bocker.size()];
        return bocker.toArray(bookArr);
    }

}
