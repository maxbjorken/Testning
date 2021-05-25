import java.util.ArrayList;
import java.util.Date;

public class hanterareStoreStub extends hanterareStore{

    ArrayList<Book> bocker = null;
    ArrayList<Lend> lends = null;
    ArrayList<User> users = null;



    hanterareStoreStub(){
        bocker = new ArrayList<Book>();
        lends = new ArrayList<Lend>();
        users = new ArrayList<User>();
    }


   /* public void addBook(int uniktID, String name, int isbn)  {
        Book b = new Book(uniktID, name, isbn);
       bocker.add(b);
    }


   /* public void addLoan(int uniktID, int id, int ISBN, String namn) {
    Lend l = new Lend(uniktID,id,ISBN,namn);
    lends.add(l);
    }

    */



    public Book[] getAllBooks() {
        Book[] bookArr = new Book[bocker.size()];
        return bocker.toArray(bookArr);
    }


    public Lend[] getAllLoans() {
        Lend[] lendArr = new Lend[lends.size()];
        return lends.toArray(lendArr);
    }


    public User[] getAllUsers() {
        User[] userArr = new User[users.size()];
        return users.toArray(userArr);
    }

}
