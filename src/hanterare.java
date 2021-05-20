import javax.annotation.processing.Filer;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.util.Random;





public class hanterare {

    public static void add(int id, String fornamn, String efternamn, long personnummer) throws IOException {
        hanterareStore.add(id, fornamn, efternamn, personnummer);
    }

    public static void addBook(int uniktid, int ISBN, String name) throws IOException {
        hanterareStore.addBook(uniktid, ISBN, name);
    }

    public static void addLoan(int id, int isbn) throws IOException {
        hanterareStore.addLoan(id, isbn);
    }


    public static int idrakna(int ett) {
        Random rand1 = new Random();
        int random1 = rand1.nextInt(1000);
        return ett + random1;
    }

    public static void taBortAnv(String filepath, int removeTerm, int posOfId, String delimeter) throws IOException {
        hanterareStore.taBortAnv(filepath, removeTerm, posOfId, ",");
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
                int uniktid = Integer.parseInt(output.next());
                int isbn = Integer.parseInt(output.next());
                String sort = output.nextLine().replaceFirst(",", "");

                Book bok = new Book(uniktid, sort, isbn);
                boklista.add(bok);

            }
            output.close();
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
        }


        try (Scanner output2 = new Scanner(lana)) {
            output2.useDelimiter(",");
            while (output2.hasNextLine()) {
                int isbn = Integer.parseInt(output2.next());
                int id = Integer.parseInt(output2.nextLine().replaceFirst(",", ""));

                Lend lend = new Lend(id, isbn);
                lendlista.add(lend);

            }
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
                String inlogg = "User";
                String loseninlogg = "123";
                System.out.println("Ange dina inloggningsuppgifter");
                System.out.println("Ange ditt användarnamn");
                String inloggAnv = scan.next();
                System.out.println("Ange ditt lösenord");
                String losenAnv = scan.next();


                if (inloggAnv.equals(inlogg) && losenAnv.equals(loseninlogg)) {
                    System.out.println("Du är nu inloggad");
                } else {
                    System.out.println("Fel inloggningsuppgifter, försök igen");
                    break;
                }

                System.out.println("1. För att låna bok");
                System.out.println("2. För att lämna tillbaka bok");
                System.out.println("3. För att ta bort dig själv som användare");
                int valbok = scan.nextInt();
                switch (valbok) {
                    case 1:
                        int rakning = 0;
                        try {
                            for (Book b : boklista) {
                                System.out.println("Namn: " + b.getName() + "   ISBN: " + b.getISBN() + " Bok-id: " + b.getUniktid());
                            }
                            while (rakning == 0) {
                                System.out.println(" ");
                                System.out.println("Vilken bok vill du låna? Ange Bok-id. Skriv 0 för att avbryta");
                                int valet = scan.nextInt();
                                int rakna = 0;

                                if (valet == 0) {
                                    rakning++;
                                } else {
                                    for (Book b : boklista) {
                                        if (b.getUniktid() == valet) {
                                            for (Book bok : boklista) {
                                                if (b.getISBN() == bok.getISBN()) {
                                                    System.out.println("Skriv ditt ID");
                                                    int id1 = scan.nextInt();
                                                    for(Lend l : lendlista){
                                                        if (l.getId() == id1) {
                                                            rakna++;
                                                        }
                                                        if (id1 > 999 && id1 < 2000){
                                                            if (rakna >= 3){
                                                                System.out.println("Du har för många lån");
                                                                System.exit(0);
                                                            }
                                                        }else if (id1 > 1999 && id1 < 3000) {
                                                            if (rakna >= 5) {
                                                                System.out.println("Du har för många lån");
                                                                System.exit(0);
                                                            }
                                                        }else if (id1 > 2999 && id1 < 4000) {
                                                            if (rakna >= 7) {
                                                                System.out.println("Du har för många lån");
                                                                System.exit(0);
                                                            }
                                                        }else if (id1 > 3999 && id1 < 5000) {
                                                            if (rakna >= 5) {
                                                                System.out.println("Du har för många lån");
                                                                System.exit(0);
                                                            }
                                                        }



                                                    }

                                                    addLoan(b.getISBN(), id1);
                                                    rakning++;
                                                }
                                            }


                                            // int nyIsbn = Integer.parseInt(String.valueOf(valet));


                                        }


                                    }

                                }
                                if (rakning == 0) {
                                    System.out.println("Boken finns inte eller så har du skrivit fel! Försök igen");
                                }
                            }

                        } catch (Exception e) {
                            e.printStackTrace();

                        }


                        break;
                    case 2:
                        System.out.println("Vilket är ditt ID?");
                        int valavbok = scan.nextInt();
                        for (Lend b : lendlista) {
                            if (b.getId() == valavbok) {
                                for (Book bo : boklista) {
                                    if (bo.getISBN() == b.getISBN())
                                        System.out.println("Namn: " + bo.getName() + "   ISBN: " + b.getISBN());
                                }
                            }
                        }

                        System.out.println("Vilken bok vill du lämna tillbaka?");
                        int lamnatillbakabok = scan.nextInt();

                    case 3:
                        System.out.println("Ange ditt ID för att radera din profil");
                        int valavID = scan.nextInt();
                        taBortAnv("src\\Users.txt", valavID, 1, ",");


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

                for (User l : userlista){
                    if (l.getFirstName().equals(firstName) && l.getLastName().equals(lastName) && l.getPersonalNumber() == personalNumber){
                        System.out.println("Denna användare är redan registrerad");
                        System.out.println("Kontakta administratör");
                        System.exit(0);
                    }
                }

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

                for (User u : userlista) {
                    System.out.println("Namn: " + u.getFirstName() + " " + u.getLastName() + " Personnummer: " +
                            u.getPersonalNumber() + " ID: " + u.getId());
                }

                String absolute = Users.getAbsolutePath();

                // Display the file path of the file object
                // and also the file path of absolute file
                System.out.println("Original  path: "
                        + Users.getPath());
                System.out.println("Absolute  path: "
                        + absolute);


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
                    break;
                }
                System.out.println("Gör ditt val:");
                System.out.println("1. För att lägga till bok");
                System.out.println("2. För att se alla böcker");
                System.out.println("3. För att se alla användare");
                System.out.println("4. Lägg till ny användare");
                System.out.println("5. För att ta bort en användare");
                int valAdmin = scan.nextInt();
                switch (valAdmin) {
                    case 1:
                        System.out.println("Skriv in ISBN");
                        int ISBN = scan.nextInt();
                        System.out.println("Skriv in bokens namn");
                        scan.nextLine();
                        String name = scan.nextLine();
                        Random random = new Random();

                        int uniktid = idrakna(1000);
                        for (Book b : boklista) {
                            while (b.getUniktid() == uniktid) {
                                uniktid = 0;
                                uniktid = idrakna(1000);
                            }
                        }
                        addBook(uniktid, ISBN, name);
                        break;

                    case 2:
                        for (Book b : boklista) {
                            System.out.println("Namn: " + b.getName() + "   ISBN: " + b.getISBN() + " id: " + b.getUniktid());
                        }
                        break;

                    case 3:
                        for (User u : userlista) {
                            System.out.println("Namn: " + u.getFirstName() + "      Efternamn: " + u.getLastName() + "      Personnummer: " + u.getPersonalNumber() + "      id: " + u.getId());
                        }
                        break;

                    case 4:

                        System.out.println("Vad är personens förnamn?");
                        String firstName1 = scan.next();
                        System.out.println("Vad heter personen i efternamn?");
                        String lastName1 = scan.next();
                        System.out.println("Vad har personen för personnummer?");
                        long personalNumber1 = scan.nextLong();


                        System.out.println("Vilken roll har den nya användaren?: ");
                        System.out.println(" ");
                        System.out.println("Undergraduate = 1");
                        System.out.println("Postgraduate student = 2");
                        System.out.println("PhD student = 3");
                        System.out.println("Teacher = 4");


                        int regval1 = scan.nextInt();
                        switch (regval1) {
                            case 1:
                                int summan = idrakna(1000);
                                System.out.println("Här är ditt ID = " + summan);

                                add(summan, firstName1, lastName1, personalNumber1);

                                break;

                            case 2:

                                int summan1 = idrakna(2000);
                                System.out.println("Här är ditt ID = " + summan1);

                                add(summan1, firstName1, lastName1, personalNumber1);

                                break;

                            case 3:
                                int summan2 = idrakna(3000);
                                System.out.println("Här är ditt ID = " + summan2);

                                add(summan2, firstName1, lastName1, personalNumber1);
                                break;

                            case 4:
                                int summan3 = idrakna(4000);
                                System.out.println("Här är ditt ID = " + summan3);

                                add(summan3, firstName1, lastName1, personalNumber1);
                                break;
                        }


                    case 5:
                        for (User u : userlista) {
                            System.out.println("Namn: " + u.getFirstName() + " " + u.getLastName() + " Personnummer: " +
                                    u.getPersonalNumber() + " ID: " + u.getId()); }
                            System.out.println("Skriv in ID på den personen du vill ta bort");
                            int valavID = scan.nextInt();
                            taBortAnv("src\\Users.txt", valavID, 1, ",");


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


