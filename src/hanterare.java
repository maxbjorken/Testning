import javax.annotation.processing.Filer;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.util.Random;





public class hanterare {

    public static void add(int id, String fornamn, String efternamn, long personnummer) throws IOException {
        hanterareStore.add(id, fornamn, efternamn, personnummer);
    }

    public static void addBook(int ISBN, String name) throws IOException {
        hanterareStore.addBook(ISBN, name);
    }


    public static int idrakna(int ett) {
        Random rand1 = new Random();
        int random1 = rand1.nextInt(1000);
        return ett + random1;
    }


    public static void main(String[] args) throws IOException {
        File Books = new File("src/Books.txt");
        File Users = new File("src/Users.txt");
        File lana = new File("src/Lana.txt");
        ArrayList<Book> boklista = new ArrayList<>();
        ArrayList<User> userlista = new ArrayList<>();
        ArrayList<Lend> lendlista = new ArrayList<>();

        try (Scanner output = new Scanner(Books)) {
            output.useDelimiter(",");
            while (output.hasNextLine()) {
                int isbn = Integer.parseInt(output.next());
                String sort = output.nextLine().replaceFirst(",", "");

                Book bok = new Book(sort, isbn);
                boklista.add(bok);

            }
        }

        try (Scanner output1 = new Scanner(Users)) {
            output1.useDelimiter(",");
            while (output1.hasNextLine()) {
                int id = Integer.parseInt(output1.next());
                String first = output1.next();
                String last = output1.next();
                long pers = Long.parseLong(output1.nextLine().replaceFirst(",", ""));

                User user = new User(id, first, last, pers);
                userlista.add(user);

            }


            Scanner scan = new Scanner(System.in);
            System.out.println("**************************************");
            System.out.println("Välkommen till Hultsfred Stadsbibliotek");
            System.out.println("**************************************");

            System.out.println("Välj ditt val (1 eller 2)");
            System.out.println("1. Låna/Lämna tillbaka bok");
            System.out.println("2. Registrera dig!");
            System.out.println("3  visa böcker");
            System.out.println(" ");
            System.out.println("9. Logga in som bibliotekarie");
            System.out.println();
            int val = scan.nextInt();


            switch (val) {

                case 1:
                    System.out.println("1. För att låna bok");
                    System.out.println("2. För att lämna tillbaka bok");
                    int valbok = scan.nextInt();
                    switch (valbok) {
                        case 1:

                            try {
                                for (Book b : boklista) {
                                    System.out.println("Namn: " + b.getName() + "   ISBN: " + b.getISBN());
                                }
                                System.out.println("Vilken bok vill du låna? Ange ISBN. Skriv 0 för att avbryta");
                                int valet = scan.nextInt();




                            } catch (Exception e) {
                                e.printStackTrace();

                            }


                        /*BufferedReader br = new BufferedReader(new FileReader("src/Books.txt"));

                        String m;
                        while ((m = br.readLine()) != null) {
                            System.out.println(m);
                            System.out.println("Vilken bok vill du låna?");
                        }
                        String ny = scan.next();
                        while ((m = br.readLine()) != null) {
                            if (ny.equals(m)) {
                                System.out.println(m);
                            }
                        }

                         */







                            /*
                            try (Scanner output = new Scanner(nyFil)) {
            output.useDelimiter(",");
            while (output.hasNextLine()) {
                String sort = output.next();
                if (sort.equals("D")) {
                    String namn = output.next();
                    String latinsktnamn = output.next();
                    double vikt = Double.parseDouble(output.next());
                    String palsfarg = output.next();
                    boolean vinter = output.nextBoolean();
                    String late = output.nextLine().replaceFirst(",", "");

                    Daggdjur daggeman = new Daggdjur(namn, latinsktnamn, vikt, palsfarg, vinter, late);
                    djur.add(daggeman);
                             */


                            break;
                        case 2:
                            System.out.println("Vilken bok vill du lämna tillbaka?");
                            System.out.println("magge");

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

                            add(summan, firstName, lastName, personalNumber);

                            break;

                        case 2:

                            int summan1 = idrakna(2000);
                            System.out.println("Här är ditt ID = " + summan1);

                            add(summan1, firstName, lastName, personalNumber);

                            break;

                        case 3:
                            int summan2 = idrakna(3000);
                            System.out.println("Här är ditt ID = " + summan2);

                            add(summan2, firstName, lastName, personalNumber);
                            break;

                        case 4:
                            int summan3 = idrakna(4000);
                            System.out.println("Här är ditt ID = " + summan3);

                            add(summan3, firstName, lastName, personalNumber);
                            break;

                    }
                    break;

                case 3:

                    for (Book b : boklista) {
                        System.out.println("Namn: " + b.getName() + "   ISBN: " + b.getISBN());
                    }

                    for (User u: userlista) {
                        System.out.println("Namn: " + u.getFirstName() +" "+u.getLastName() + " Personnummer: " +
                                u.getPersonalNumber() + " ID: " + u.getId());
                    }


                    break;
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
                    switch (valAdmin) {
                        case 1:
                            System.out.println("Skriv in ISBN");
                            int ISBN = scan.nextInt();
                            System.out.println("Skriv in bokens namn");
                            scan.nextLine();
                            String name = scan.nextLine();

                            addBook(ISBN, name);


                            break;

                        case 2:
                            for (Book b : boklista) {
                                System.out.println("Namn: " + b.getName() + "   ISBN: " + b.getISBN());





                










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


            }
        }
    }
}


                      /*  try{
                            BufferedReader br = new BufferedReader(new FileReader("src/Users.txt"));
                            String m;

                            while ((m = br.readLine()) != null){
                                System.out.println(m);

                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        break;
                }

                       */

