public class Book {
    private int ISBN;
    private String name;

    public Book(String name, int ISBN) {
    }
    //private date(?) countDays

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
