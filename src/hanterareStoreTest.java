import org.junit.jupiter.api.Test;
import org.mockito.configuration.IMockitoConfiguration;

import java.io.IOException;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

class hanterareStoreTest {


@Test
    void testAddBooks() {
        hanterareStoreStub stub = new hanterareStoreStub();
        hanterare cut = new hanterare(stub);

        stub.bocker.add(new Book(2324, "Open", 454533));
        stub.bocker.add(new Book(3242, "Not Really Open", 4545233));
        stub.bocker.add(new Book(1235, "Not Even Open", 4545233));
        stub.bocker.add(new Book(9843, "Not Right Open", 4545233));
        stub.bocker.add(new Book(1122, "Not Slightly Open", 4545233));
        stub.bocker.add(new Book(8934, "Not Even close Open", 4545233));

        assertEquals(9843, cut.returnIDifExists(9843));

    }

    @Test
    void testAddLoan() {
        hanterareStoreStub stub = new hanterareStoreStub();
        hanterare cut = new hanterare(stub);

        stub.lends.add(new Lend(2321, 3110, 9434234, "Sagan Om Ringen"));
        stub.lends.add(new Lend(2912, 3112, 3239239,"History of Europe"));
        stub.lends.add(new Lend(9833, 3021, 393943, "Service Innovation"));
        stub.lends.add(new Lend(1423, 4214, 294214,"Växjö"));

        assertEquals(1423, cut.returnIfLendExists(1423));

    }
        @Test
    void testAddUser() {
            hanterareStoreStub stub = new hanterareStoreStub();
            hanterare cut = new hanterare(stub);

            stub.users.add(new User(2929, "Max", "Björk", 13371337));
            stub.users.add(new User(4089, "Lukas", "Örnros", 902201493));
            stub.users.add(new User(2319, "Anton", "Johansson", 872342435));
            stub.users.add(new User(1919, "Tobias", "Johansson", 1234677));


            assertEquals(1919, cut.returnIfUserExists(1919));


        }


}