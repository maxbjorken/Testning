import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;


public class hanterareStore {
  /*  public Book[] getAllBooks(Book[] books) throws FileNotFoundException {

       ArrayList<Book> books1= new ArrayList<>();
        File Books = new File("src/Books.txt");
        try (
                Scanner output = new Scanner(Books)) {
            output.useDelimiter(",");
            while (output.hasNextLine()) {
                int uniktid = Integer.parseInt(output.next());
                int isbn = Integer.parseInt(output.next());
                String sort = output.nextLine().replaceFirst(",", "");

                Book bok = new Book(uniktid, sort, isbn);
                books1.add(bok);
                Book[] entries = new Book[0];
                String[] bockerna = new String[0];
int antal = 0;
                for(Book b1: books1) {
                    for (int i = 0; i >= books1.size(); i++) {
                        bockerna[i] += bok.getName();
                        antal++;
                    }

           return bockerna[];
                }



                /* Kod som hämtar tidregistreringar */






    public static void lasaInBocker(ArrayList<Book> lista) throws FileNotFoundException {
        File Books = new File("src/Books.txt");
        try (
                Scanner output = new Scanner(Books)) {
            output.useDelimiter(",");
            while (output.hasNextLine()) {
                int uniktid = Integer.parseInt(output.next());
                int isbn = Integer.parseInt(output.next());
                String sort = output.nextLine().replaceFirst(",", "");

                Book bok = new Book(uniktid, sort, isbn);
                lista.add(bok);
            }
        }
    }

    public static ArrayList<User> lasaInAnvandare(ArrayList<User> lista) throws FileNotFoundException {

        File Users = new File("src/Users.txt");
        try (Scanner output1 = new Scanner(Users)) {
            output1.useDelimiter(",");
            while (output1.hasNextLine()) {
                int id = Integer.parseInt(output1.next());
                String first = output1.next();
                String last = output1.next();
                long pers = Long.parseLong(output1.nextLine().replaceFirst(",", ""));

                User user = new User(id, first, last, pers);
                lista.add(user);

            }
        } return (lista);
    }

    public static ArrayList<Lend> lasaInLan(ArrayList<Lend> lista) throws FileNotFoundException {
        File lana = new File("src/Lana.txt");
        try (Scanner output2 = new Scanner(lana)) {
            output2.useDelimiter(",");
            while (output2.hasNextLine()) {
                int uniktid = Integer.parseInt(output2.next());
                int isbn = Integer.parseInt(output2.next());
                int id = Integer.parseInt(output2.nextLine().replaceFirst(",", ""));

                Lend lend = new Lend(uniktid, id, isbn);
                lista.add(lend);

            }
        } return (lista);

    }

    public static ArrayList<Warnings> lasaInVarning(ArrayList<Warnings> lista) throws FileNotFoundException {
        File varning = new File("src/Warnings.txt");

        try (Scanner output3 = new Scanner(varning)) {
            output3.useDelimiter(",");
            while (output3.hasNextLine()) {
                int antal = Integer.parseInt(output3.next().replaceFirst(",",""));

                Warnings warnings = new Warnings(antal);
                lista.add(warnings);
            }

        } return (lista);
    }

    public static void add(int id, String fornamn, String efternamn, long personnummer) throws IOException {
        User anvandare1 = new User(id, fornamn, efternamn, personnummer);
        System.out.println(anvandare1.getFirstName() + "    " + anvandare1.getLastName() + "    " + anvandare1.getPersonalNumber() + "      " + anvandare1.getId());
        FileWriter fileUser = new FileWriter("src/Users.txt", true);
        try (PrintWriter writeUser = new PrintWriter(fileUser)) {
            writeUser.print(id + "," + fornamn + "," + efternamn + "," + personnummer);
            writeUser.println();
            writeUser.close();
        }
    }

    public static void addBook(int uniktid, int ISBN, String name) throws IOException {
        Book nyBok = new Book(uniktid, name, ISBN);
      //  System.out.println(nyBok.getISBN() + nyBok.getName());
        FileWriter fileBook = new FileWriter("src/Books.txt", true);
        try (PrintWriter writeBook = new PrintWriter(fileBook)) {
            writeBook.print(uniktid + "," + ISBN + "," + name);
            writeBook.println();
            writeBook.close();
        }
    }


    public static void addLoan(int uniktID, int id, int ISBN) throws IOException {
        Lend nyLend = new Lend(id, ISBN);
       // System.out.println(nyLend.id + nyLend.ISBN);
        FileWriter writeLend = new FileWriter("src/Lana.txt", true);
        try (PrintWriter pw = new PrintWriter(writeLend)) {
            pw.print(uniktID + "," + id + "," + ISBN);
            pw.println();
            pw.close();
        }
    }

    public static void addWarning(int id) throws IOException {
        Warnings warnings = new Warnings(id);
        FileWriter writeWarning = new FileWriter("src/Warnings.txt", true);
        try (PrintWriter pw = new PrintWriter(writeWarning)) {
            pw.print(id);
            pw.println();
        }
    }




    public static void taBortAnv(String filepath, int removeTerm, int posOfId, String delimeter) throws IOException {
        int position = posOfId - 1;
        String tempFile = "temp.txt";
        File oldFile = new File(filepath);
        File newFile = new File(tempFile);

        String currentLine;
        String[] data;

        try {

            FileWriter fw = new FileWriter(tempFile, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            FileReader fr = new FileReader(filepath);
            BufferedReader br = new BufferedReader(fr);

            while ((currentLine = br.readLine()) != null) {

                data = currentLine.split(",");
                if (!(data[position].equalsIgnoreCase(String.valueOf(removeTerm)))) {
                    pw.println(currentLine);
                }
            }
            pw.flush();
            pw.close();
            fr.close();
            br.close();
            bw.close();
            fw.close();


            try {
                Files.delete(Paths.get(filepath));
            } catch (IOException e) {
                e.printStackTrace();
            }
            File dump = new File(filepath);
            newFile.renameTo(dump);

        } catch (Exception e) {
            System.out.println("Fel");
        }
    }
}




