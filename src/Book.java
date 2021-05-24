public class Book {
    private int ISBN;
    private String name;
    private int uniktid;

    public int getUniktid() {
        return uniktid;
    }

    public void setUniktid(int uniktid) {
        this.uniktid = uniktid;
    }



    public Book(int uniktid, String name, int ISBN) {
        this.ISBN=ISBN;
        this.name=name;
        this.uniktid=uniktid;
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
