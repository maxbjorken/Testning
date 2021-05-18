import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

public class hanterareStore {

    public static void add(int id, String fornamn, String efternamn, long personnummer) throws IOException {
        User anvandare1 = new User(id, fornamn, efternamn, personnummer);
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


    public static void addLoan(int id, int ISBN) throws IOException {
        Lend nyLend = new Lend(id, ISBN);
        System.out.println(nyLend.id + nyLend.ISBN);
        FileWriter writeLend = new FileWriter("src/Lana.txt", true);
        try (PrintWriter pw = new PrintWriter(writeLend)){
            pw.print(id + "," + ISBN);
            pw.println();
        }


    }

}
