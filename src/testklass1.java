import java.util.Scanner;

public class testklass1 {
    public static void main(String[] args) {

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

                User anvandare1 = new User(firstName, lastName, personalNumber);
                System.out.println(anvandare1.getFirstName() + " " + anvandare1.getLastName() + " " + anvandare1.getPersonalNumber());

                break;

        }




    }
}

