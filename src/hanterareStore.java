import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class hanterareStore {

    public static void add(String fornamn, String efternamn, long personnummer, int id) throws IOException {
        User anvandare1 = new User(fornamn, efternamn, personnummer, id);
        System.out.println(anvandare1.getFirstName() + "    " + anvandare1.getLastName() + "    " + anvandare1.getPersonalNumber() + "      " + anvandare1.getId());
        FileWriter fileUser = new FileWriter("src/Users.txt", true);
        try (PrintWriter writeUser = new PrintWriter(fileUser)){
            writeUser.print(id + "," + fornamn+ "," +  efternamn + "," + personnummer);
            writeUser.println();
        }
    }
    public static void addBook(int ISBN, String name) throws IOException {
        Book nyBok = new Book(name, ISBN);
        System.out.println(nyBok.getISBN() + nyBok.getName());
        FileWriter fileBook = new FileWriter("src/Books.txt", true);
        try (PrintWriter writeBook = new PrintWriter(fileBook)){
            writeBook.print(ISBN + "," + name);
            writeBook.println();
        }
    }

}
