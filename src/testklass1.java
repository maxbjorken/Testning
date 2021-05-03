import javax.annotation.processing.Filer;
import java.sql.SQLOutput;
import java.util.Scanner;
import java.io.*;
import java.util.Random;





public class testklass1 {


    public static int idrakna(int ett) {
        Random rand1 = new Random();
        int random1 = rand1.nextInt(1000);
        return ett + random1;
    }

    public static void add(String fornamn, String efternamn, long personnummer, int id) throws IOException {
        User anvandare1 = new User(fornamn, efternamn, personnummer, id);
        System.out.println(anvandare1.getFirstName() + "    " + anvandare1.getLastName() + "    " + anvandare1.getPersonalNumber() + "      " + anvandare1.getId());
        FileWriter fileUser = new FileWriter("src/Users.txt", true);
        try (PrintWriter writeUser = new PrintWriter(fileUser)){
            writeUser.print(id + "  " + fornamn+ " " + " " +  efternamn + " " + personnummer);
            writeUser.println();
    }
    }
    public static void addBook(int ISBN, String name) throws IOException {
        Book nyBok = new Book(ISBN, name);
        System.out.println(nyBok.getISBN() + nyBok.getName());
        FileWriter fileBook = new FileWriter("src/Books.txt", true);
        try (PrintWriter writeBook = new PrintWriter(fileBook)){
            writeBook.print(ISBN + "  " + name);
            writeBook.println();
        }
    }


    public static void main(String[] args) throws IOException {
        File Books = new File("src/Books.txt");


        Scanner scan = new Scanner(System.in);
        System.out.println("***********************");
        System.out.println("Välkommen till Hultsfred Stadsbibliotek");
        System.out.println("lol");
        System.out.println("************************");

        System.out.println("Välj ditt val (1 eller 2)");
        System.out.println("1. Låna/Lämna tillbaka bok");
        System.out.println("2. Registrera dig!");
        System.out.println(" ");
        System.out.println("9. Logga in som bibliotekarie");
        System.out.println();
       int val = scan.nextInt();





        switch (val) {

            case 1:
                System.out.println("1. För att låna bok");
                System.out.println("2. För att lämna tillbaka bok");
                int valbok = scan.nextInt();
                switch (valbok){
                    case 1:
                        System.out.println("Vilken bok vill du låna?");
                        Scanner scanBook = new Scanner(Books);
                        scanBook.nextLine();
                    try{
                        BufferedReader br = new BufferedReader(new FileReader("src/Books.txt"));
                        String m;
                        while ((m = br.readLine()) != null){
                            System.out.println(m);
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                        break;
                    case 2:
                        System.out.println("Vilken bok vill du lämna tillbaka?");

                }

            break;

            case 2:
                System.out.println("Registrera");
                System.out.println("Ange ditt Förnamn");
                String firstName = scan.next();

                System.out.println("Ange ditt efternamn");
                String lastName = scan.next();

                System.out.println("Ange ditt personnummer");
                long personalNumber = scan.nextLong();

                System.out.println("Ange din roll:");
                System.out.println("Undergraduate = 1");
                System.out.println("Postgraduate student = 2");
                System.out.println("PhD student = 3");
                System.out.println("Teacher = 4");

                int val1 = scan.nextInt();

                switch (val1) {
                    case 1:
                        int summan = idrakna(1000);
                        System.out.println("Här är ditt ID = " + summan);

                        add(firstName, lastName, personalNumber, summan);


                        break;

                    case 2:

                        int summan1 = idrakna(2000);
                        System.out.println("Här är ditt ID = " + summan1);

                        add(firstName, lastName, personalNumber, summan1);
                        break;

                    case 3:
                        int summan2 = idrakna(3000);
                        System.out.println("Här är ditt ID = " + summan2);

                        add(firstName, lastName, personalNumber, summan2);
                        break;

                    case 4:
                        int summan3 = idrakna(4000);
                        System.out.println("Här är ditt ID = " + summan3);

                        add(firstName, lastName, personalNumber, summan3);
                        break;





                } break;
            case 9:
                String user = "Admin";
                String losen = "123";
                System.out.println("Ange användarnamn");
                String input1 = scan.next();

                System.out.println("Ange ditt lösenord");
                String input2 = scan.next();

                if (input1.equals(user) && input2.equals(losen)) {
                    System.out.println("Du är nu inloggad");
                } else {
                    System.out.println("Fel inloggningsuppgifter, försök igen");
                }
                System.out.println("Gör ditt val:");
                System.out.println("1. För att lägga till bok");
                System.out.println("2. För att se användare");
                int valAdmin = scan.nextInt();
                switch (valAdmin){
                    case 1:
                        System.out.println("Skriv in ISBN");
                        int ISBN = scan.nextInt();
                        System.out.println("Skriv in bokens namn");
                        String name = scan.next();

                        addBook(ISBN, name);




                    break;

                    case 2:

                        break;
                }




                










             /*   User anvandare1 = new User(firstName, lastName, personalNumber, summ);
                System.out.println(anvandare1.getFirstName() + "    " + anvandare1.getLastName() + "    " + anvandare1.getPersonalNumber());
               FileWriter fileUser = new FileWriter("src/Users.txt", true);
               try (PrintWriter writeUser = new PrintWriter(fileUser)){
                   writeUser.print(firstName+ " " + " " +  lastName + " " + personalNumber);
                   writeUser.println();

               } catch (Exception e){System.out.println("Det gick fel");} //skriver fortfarande in i filen??
                System.out.println("Registreringen lyckades");
               //Måste fixa utifall att man gör registreringen fel
                System.out.println("tjaa");


              */
               break;



        }






    }

    private static void addBook() {
    }


}
