import java.io.File;
import java.util.Scanner;
import java.io.*;
import java.util.Random;

public class testklass1 {
    public static void main(String[] args) throws IOException {

        Random rand = new Random();

        Scanner scan = new Scanner(System.in);
        System.out.println("***********************");
        System.out.println("Välkommen till Hultsfred Stadsbibliotek");
        System.out.println("************************");

        System.out.println("Välj ditt val (1 eller 2)");
        System.out.println("1. Låna/Lämna tillbaka bok");
        System.out.println("2. Registrera dig!");
        System.out.println();
       int val = scan.nextInt();



        switch (val) {

            case 1:
            System.out.println("Lämna tillbaka boken eller låna?");
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

                        int id = 1000;
                        int random1 = rand.nextInt(1000);

                        int totid = id + random1;

                        System.out.println("Här är dittt ID = " + totid);

                        break;


                    case 2:
                        int id2 = 2000;
                        int random2 = rand.nextInt(1000);

                        int totid2 = id2 + random2;

                        System.out.println("Här är dittt ID = " + totid2);
                        break;

                    case 3:
                        int id3 = 3000;
                        int random3 = rand.nextInt(1000);

                        int totid3 = id3 + random3;

                        System.out.println("Här är dittt ID = " + totid3);
                        break;

                    case 4:
                        int id4 = 4000;
                        int random4 = rand.nextInt(1000);

                        int totid4 = id4 + random4;

                        System.out.println("Här är dittt ID = " + totid4);
                        break;

                }


                










                User anvandare1 = new User(firstName, lastName, personalNumber);
                System.out.println(anvandare1.getFirstName() + "    " + anvandare1.getLastName() + "    " + anvandare1.getPersonalNumber());
               FileWriter fileUser = new FileWriter("Users.txt", true);
               try (PrintWriter writeUser = new PrintWriter(fileUser)){
                   writeUser.print(firstName+ " " + " " +  lastName + " " + personalNumber);
                   writeUser.println();

               } catch (Exception e){System.out.println("Det gick fel");} //skriver fortfarande in i filen??
                System.out.println("Registreringen lyckades");
               //Måste fixa utifall att man gör registreringen fel
                System.out.println("tjaa");

               break;



        }






    }
}
