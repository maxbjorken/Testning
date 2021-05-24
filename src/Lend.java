public class Lend {

    int id;
    int ISBN;
    int uniktid;

    public int getUniktid() {
        return uniktid;
    }

    public void setUniktid(int uniktid) {
        this.uniktid = uniktid;
    }

    public String getNamn() {
        return namn;
    }

    public void setNamn(String namn) {
        this.namn = namn;
    }

    String namn;

    public Lend() {};

    public Lend(int id, int ISBN) {
        this.id = id;
        this.ISBN = ISBN;
    }


    public Lend(int uniktid, int id, int isbn, String namn) {
        this.uniktid=uniktid;
        this.id = id;
        this.ISBN = isbn;
        this.namn=namn;
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
