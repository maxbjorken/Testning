import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.SecureRandom;
import java.util.concurrent.TimeUnit;

public class hanterareStore {

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
        System.out.println(nyBok.getISBN() + nyBok.getName());
        FileWriter fileBook = new FileWriter("src/Books.txt", true);
        try (PrintWriter writeBook = new PrintWriter(fileBook)) {
            writeBook.print(uniktid + "," + ISBN + "," + name);
            writeBook.println();
            writeBook.close();
        }
    }


    public static void addLoan(int id, int ISBN) throws IOException {
        Lend nyLend = new Lend(id, ISBN);
        System.out.println(nyLend.id + nyLend.ISBN);
        FileWriter writeLend = new FileWriter("src/Lana.txt", true);
        try (PrintWriter pw = new PrintWriter(writeLend)) {
            pw.print(id + "," + ISBN);
            pw.println();
            pw.close();
        }


    }

    public static void taBort(Path path) {

    }


    public static void taBortAnv(String filepath, String removeTerm, int posOfId, String delimeter) throws IOException {
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




/*
        File inputFile = new File("Users.txt");
        File tempFile = new File("src/temp.txt");

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        String currentLine;

        while((currentLine = reader.readLine()) != null)
        {
            //trim newline when comparing with lineToRemove
            String trimmedLine = currentLine.trim();
            if(!trimmedLine.startsWith(removeTerm))
            {
                // if current line not start with lineToRemove then write to file
                writer.write(String.format("%s%n",currentLine));

            }
        }
        writer.close();
        reader.close();


        if(!inputFile.delete())
        {
            boolean success = tempFile.renameTo(inputFile);

            return;
        }
        if(!tempFile.renameTo(inputFile)){
            System.out.println("Could not rename file");
        }


        int position = posOfId - 1;
        String tempFile = "src/temp.txt";
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

            File dump = new File(filepath);
            boolean success = newFile.renameTo(dump);

            String fileName = "C:\\Users\\46723\\IdeaProjects\\Testning\\src\\Users.txt";
            try {
                Files.deleteIfExists(Paths.get(filepath));
            } catch (IOException e) {
                e.printStackTrace();
            }


            if(oldFile.delete())                      //returns Boolean value
            {
                System.out.println(oldFile.getName() + " deleted");   //getting and printing the file name
            }
            else
            {
                System.out.println("failed");
            }




        } catch (Exception e) {
            System.out.println("Fel");

        }
    }

 */



