public class Lend {

    int id;
    int ISBN;

    public Lend() {};

    public Lend(int id, int ISBN) {
        this.id = id;
        this.ISBN = ISBN;
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
