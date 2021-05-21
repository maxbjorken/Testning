public class Lend {

    int id;
    int ISBN;
    int uniktid;

    public Lend() {};

    public Lend(int id, int ISBN) {
        this.id = id;
        this.ISBN = ISBN;
    }


    public Lend(int uniktid, int id, int isbn) {
        this.uniktid=uniktid;
        this.id = id;
        this.ISBN = isbn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

}
