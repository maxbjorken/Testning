import javax.annotation.processing.Filer;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.io.*;
import java.util.Random;
//import java.util.logging.Logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class hanterare {

    private static Logger logger = LogManager.getLogger(hanterare.class.getName());

    hanterareStore store = null;
    final double HoursPerMonth = 160.0;

    public hanterare(hanterareStore trs) {
        store = trs;
    }


    public int returnIDifExists(int id) {
        int nyttID = 0;
        Book[] entities = store.getAllBooks();

        for (Book b : entities) {
            if (id == b.getUniktid()) {
                nyttID = b.getUniktid();
            }
        }
        return nyttID;
    }

    public int returnIfLendExists(int id) {
        int nyttID = 0;
        Lend[] entities = store.getAllLoans();

        for (Lend l : entities) {
            if (id == l.getUniktid()) {
                nyttID = l.getUniktid();
            }
        }
        return nyttID;
    }

    public long returnIfUserExists(long id) {
        int nyttID = 0;
        User[] entities = store.getAllUsers();

        for (User u : entities) {
            if (id == u.getId()) {
                nyttID = u.getId();
            }
        }
        return nyttID;

    }


    public static void add(int id, String fornamn, String efternamn, long personnummer) throws IOException {
        hanterareStore.add(id, fornamn, efternamn, personnummer);
    }

    public static void addBook(int uniktid, int ISBN, String name) throws IOException {
        hanterareStore.addBook(uniktid, ISBN, name);
    }

    public static void addLoan(int uniktID, int id, int isbn, String namn) throws IOException {
        hanterareStore.addLoan(uniktID, id, isbn, namn);
    }


    public static int idrakna(int ett) {
        Random rand1 = new Random();
        int random1 = rand1.nextInt(1000);
        return ett + random1;
    }

    public static void taBortAnv(String filepath, int removeTerm, int posOfId, String delimeter) throws IOException {
        hanterareStore.taBortAnv(filepath, removeTerm, posOfId, ",");
    }

    public static void addWarning(int id) throws IOException {
        hanterareStore.addWarning(id);
    }


    public static void main(String[] args) throws IOException {

        ArrayList<Book> boklista = new ArrayList<>();
        ArrayList<User> userlista = new ArrayList<>();
        ArrayList<Lend> lendlista = new ArrayList<>();
        ArrayList<Warnings> varningslista = new ArrayList<>();

        Scanner scan = new Scanner(System.in);
        hanterareStore.lasaInBocker(boklista);
        hanterareStore.lasaInAnvandare(userlista);
        hanterareStore.lasaInLan(lendlista);
        hanterareStore.lasaInVarning(varningslista);




        System.out.println("**************************************");
        System.out.println("V??lkommen till Hultsfred Stadsbibliotek");
        System.out.println("**************************************");


        System.out.println("V??lj ditt val (1 eller 2)");
        System.out.println("1. L??na/L??mna tillbaka bok");
        System.out.println("2. Registrera dig!");
        System.out.println("3  Visa b??cker");
        System.out.println(" ");
        System.out.println("9. Logga in som bibliotekarie");

        System.out.println();
        int val = scan.nextInt();

        int count1 = 0;
            switch (val) {

                case 1:
                    logger.info("Inlogging i system ");
                    System.out.println("Vad ??r ditt anv??ndar-ID?");
                    int inloggAnv = scan.nextInt();
                    logger.debug(String.format("Anvandarnamn = %s", inloggAnv));
                    for (User u : userlista) {
                        if (u.getId() == inloggAnv) {
                            count1++;
                        }
                    }

                    if (count1 < 1) {
                        System.out.println("Fel inloggning, f??rs??k igen");
                        logger.info("Avslut inloggning i systemet (Fel inloggningsuppgifter)");
                        System.exit(1337);

                    }
                    logger.info("Avslut inloggning i systemet");


                    System.out.println("1. F??r att l??na bok");
                    System.out.println("2. F??r att l??mna tillbaka bok");
                    System.out.println("3. F??r att ta bort dig sj??lv som anv??ndare");
                    System.out.println("0. F??r att avsluta systemet");
                    int valbok = scan.nextInt();
                    switch (valbok) {


                        case 1:
                            int rakning = 0;
                            try {
                                System.out.println("B??cker som ??r tillg??ngliga:");
                                for (Book b : boklista) {

                                    System.out.println("Namn: " + b.getName() + "   ISBN: " + b.getISBN() + " Bok-id: " + b.getUniktid());

                                }

                                System.out.println();
                                System.out.println("B??cker som ??r utl??nade:");
                                for(Lend l: lendlista) {
                                    System.out.println("Namn: " + l.getNamn() + "   ISBN: " + l.getISBN() + " Bok-id: " + l.getUniktid());
                                }
                                System.out.println();

                                System.out.println(" ");
                                System.out.println("Vilken bok vill du l??na? Ange Bok-id. Skriv 0 f??r att avbryta");
                                logger.info("Starting");
                                int valet = scan.nextInt();
                                logger.debug(String.format("L??N: Bok-ID = %d", valet));
                                int rakna = 0;


                                for (Book b : boklista) {
                                    if (b.getUniktid() == valet) {
                                        for (Book bok : boklista) {
                                            if (b.getISBN() == bok.getISBN()) {


                                                System.out.println("Skriv ditt ID");
                                                int id1 = scan.nextInt();
                                                for (User u : userlista) {
                                                    if (u.getId() == id1) {
                                                        rakna++;
                                                    }
                                                }

                                                if (rakna > 0) {
                                                    logger.debug(String.format("L??ntagares ID = %d", id1));
                                                    for (Lend l : lendlista) {
                                                        if (l.getId() == id1) {
                                                            rakna++;
                                                        }
                                                        if (id1 > 999 && id1 < 2000) {
                                                            if (rakna >= 3) {
                                                                System.out.println("Du har f??r m??nga l??n");
                                                                logger.error("F??r m??nga l??n");
                                                                System.exit(0);
                                                            }
                                                        } else if (id1 > 1999 && id1 < 3000) {
                                                            if (rakna >= 5) {
                                                                System.out.println("Du har f??r m??nga l??n");
                                                                logger.error("F??r m??nga l??n");
                                                                System.exit(0);
                                                            }
                                                        } else if (id1 > 2999 && id1 < 4000) {
                                                            if (rakna >= 7) {
                                                                System.out.println("Du har f??r m??nga l??n");
                                                                logger.error("F??r m??nga l??n");
                                                                System.exit(0);
                                                            }
                                                        } else if (id1 > 3999 && id1 < 5000) {
                                                            if (rakna >= 5) {
                                                                System.out.println("Du har f??r m??nga l??n");
                                                                logger.error("F??r m??nga l??n");
                                                                System.exit(0);
                                                            }
                                                        }

                                                    }
                                                    addLoan(b.getUniktid(), b.getISBN(), id1, b.getName());
                                                    rakning++;

                                                    taBortAnv("src\\Books.txt", b.getUniktid(), 1, ",");
                                                } else {
                                                    System.out.println("Du finns inte med i systemet, skapa anv??ndare f??rst!");
                                                }
                                            }
                                        }
                                    }
                                }


                                logger.info("Ended");
                            } catch (Exception e) {
                                e.printStackTrace();
                            }


                            break;
                        case 2:
                            int var1 = 0;
                            String var2 = null;
                            logger.info("Start: L??mna tillbaka bok");
                            System.out.println("Vilket ??r ditt ID?");

                            int dittID = scan.nextInt();
                            logger.debug(String.format("L??mnatillbaka bok: L??ntagares ID = %d", dittID));
                            for (Lend b : lendlista) {
                                if (b.getId() == dittID) {
                                    System.out.println("Namn: " + b.getNamn() + "   ISBN: " + b.getISBN() + " Bok-ID: " + b.getUniktid());
                                    var1 = b.getISBN();
                                    var2 = b.getNamn();
                                }
                            }

                            System.out.println("Vilken bok vill du l??mna tillbaka? Ange Bok-ID");
                            int lamnatillbakabok = scan.nextInt();
                            logger.debug(String.format("L??mnatillbaka bok: Bokens ID = %d", lamnatillbakabok));
                            System.out.println("Hur m??nga dagar sen var det du l??nade boken?  ");
                            int antalDagar = scan.nextInt();
                            logger.debug(String.format("L??mnatillbaka bok: Antal dagar utl??nad = %d", antalDagar));

                            int war1 = 0;
                            for (Warnings w : varningslista) {
                                if (w.getAntal() == dittID && antalDagar > 15) {
                                    war1 = w.getAntal();
                                    taBortAnv("src\\Users.txt", dittID, 1, ",");
                                    taBortAnv("src\\Warnings.txt", dittID, 1, ",");
                                } else {
                                    addWarning(dittID);
                                }


                            }

                            addBook(lamnatillbakabok, var1, var2);

                            taBortAnv("src\\Lana.txt", lamnatillbakabok, 1, ",");
                            logger.info("Slut: L??mna tillbaka bok");


                            break;


                        case 3:
                            System.out.println("Ange ditt ID f??r att radera din profil");
                            int valavID = scan.nextInt();
                            taBortAnv("src\\Users.txt", valavID, 1, ",");

                    }

                    break;


                case 2:
                    logger.info("Start: Registrera anv??ndare");
                    System.out.println("Registrera");
                    System.out.println("Ange ditt F??rnamn");
                    String firstName = scan.next();
                    logger.debug(String.format("Registrera anv??ndare. F??rnamn = %s", firstName));

                    System.out.println("Ange ditt efternamn");
                    String lastName = scan.next();
                    logger.debug(String.format("Registrera anv??ndare. Efternamn = %s", lastName));


                    System.out.println("Ange ditt personnummer");
                    long personalNumber = scan.nextLong();
                    logger.debug(String.format("Registrera anv??ndare. Personnummer = %d", personalNumber));

                    for (User l : userlista) {
                        if (l.getFirstName().equals(firstName) && l.getLastName().equals(lastName) && l.getPersonalNumber() == personalNumber) {
                            System.out.println("Denna anv??ndare ??r redan registrerad");
                            System.out.println("Kontakta administrat??r");
                            System.exit(0);
                        }
                    }

                    System.out.println("Ange din roll:");
                    System.out.println("Undergraduate = 1");
                    System.out.println("Postgraduate student = 2");
                    System.out.println("PhD student = 3");
                    System.out.println("Teacher = 4");


                    int val1 = scan.nextInt();
                    logger.debug(String.format("Registrera anv??ndare. Roll = %s", val1));

                    switch (val1) {

                        case 1:
                            int summan = idrakna(1000);
                            System.out.println("H??r ??r ditt ID = " + summan);

                            add(summan, firstName, lastName, personalNumber);

                            break;

                        case 2:

                            int summan1 = idrakna(2000);
                            System.out.println("H??r ??r ditt ID = " + summan1);

                            add(summan1, firstName, lastName, personalNumber);

                            break;

                        case 3:
                            int summan2 = idrakna(3000);
                            System.out.println("H??r ??r ditt ID = " + summan2);

                            add(summan2, firstName, lastName, personalNumber);
                            break;

                        case 4:
                            int summan3 = idrakna(4000);
                            System.out.println("H??r ??r ditt ID = " + summan3);

                            add(summan3, firstName, lastName, personalNumber);
                            break;

                    }
                    logger.info("Slut: Registrera anv??ndare");
                    break;

                case 3:

                    for (Book b : boklista) {
                        System.out.println("Namn : " + b.getName() + "   ISBN: " + b.getISBN());
                    }

               /* for (User u : userlista) {
                    System.out.println("Namn: " + u.getFirstName() + " " + u.getLastName() + " Personnummer: " +
                        u.getPersonalNumber() + " ID: " + u.getId());
                }
                */


                    break;
                case 9:
                    String user = "Admin";
                    String losen = "123";
                    System.out.println("Ange anv??ndarnamn");
                    String input1 = scan.next();

                    System.out.println("Ange ditt l??senord");
                    String input2 = scan.next();

                    if (input1.equals(user) && input2.equals(losen)) {
                        System.out.println("Du ??r nu inloggad");
                    } else {
                        System.out.println("Fel inloggningsuppgifter, f??rs??k igen");
                        break;
                    }
                    System.out.println("G??r ditt val:");
                    System.out.println("1. F??r att l??gga till bok");
                    System.out.println("2. F??r att se alla b??cker");
                    System.out.println("3. F??r att se alla anv??ndare");
                    System.out.println("4. L??gg till ny anv??ndare");
                    System.out.println("5. F??r att ta bort en anv??ndare");
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
                            System.out.println("B??cker som ??r tillg??ngliga:");
                            for (Book b : boklista) {

                                System.out.println("Namn: " + b.getName() + "   ISBN: " + b.getISBN() + " Bok-id: " + b.getUniktid());

                            }

                            System.out.println();
                            System.out.println("B??cker som ??r utl??nade:");
                            for(Lend l: lendlista) {
                                System.out.println("Namn: " + l.getNamn() + "   ISBN: " + l.getISBN() + " Bok-id: " + l.getUniktid());
                            }
                            break;

                        case 3:
                            for (User u : userlista) {
                                System.out.println("Namn: " + u.getFirstName() + "      Efternamn: " + u.getLastName() + "      Personnummer: " + u.getPersonalNumber() + "      id: " + u.getId());
                            }
                            break;

                        case 4:

                            System.out.println("Vad ??r personens f??rnamn?");
                            String firstName1 = scan.next();
                            System.out.println("Vad heter personen i efternamn?");
                            String lastName1 = scan.next();
                            System.out.println("Vad har personen f??r personnummer?");
                            long personalNumber1 = scan.nextLong();


                            System.out.println("Vilken roll har den nya anv??ndaren?: ");
                            System.out.println(" ");
                            System.out.println("Undergraduate = 1");
                            System.out.println("Postgraduate student = 2");
                            System.out.println("PhD student = 3");
                            System.out.println("Teacher = 4");


                            int regval1 = scan.nextInt();
                            switch (regval1) {
                                case 1:
                                    int summan = idrakna(1000);
                                    System.out.println("H??r ??r ditt ID = " + summan);

                                    add(summan, firstName1, lastName1, personalNumber1);

                                    break;

                                case 2:

                                    int summan1 = idrakna(2000);
                                    System.out.println("H??r ??r ditt ID = " + summan1);

                                    add(summan1, firstName1, lastName1, personalNumber1);

                                    break;

                                case 3:
                                    int summan2 = idrakna(3000);
                                    System.out.println("H??r ??r ditt ID = " + summan2);

                                    add(summan2, firstName1, lastName1, personalNumber1);
                                    break;

                                case 4:
                                    int summan3 = idrakna(4000);
                                    System.out.println("H??r ??r ditt ID = " + summan3);

                                    add(summan3, firstName1, lastName1, personalNumber1);
                                    break;
                            }


                        case 5:
                            for (User u : userlista) {
                                System.out.println("Namn: " + u.getFirstName() + " " + u.getLastName() + " Personnummer: " +
                                        u.getPersonalNumber() + " ID: " + u.getId());
                            }
                            System.out.println("Skriv in ID p?? den personen du vill ta bort");
                            int valavID = scan.nextInt();
                            taBortAnv("src\\Users.txt", valavID, 1, ",");


                    }
            }

    }
}


