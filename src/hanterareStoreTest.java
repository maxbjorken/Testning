import org.junit.jupiter.api.Test;
import org.mockito.configuration.IMockitoConfiguration;

import java.io.IOException;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

class hanterareStoreTest {

    @Test
    void TestaddBook_usingMockito() throws IOException {
        hanterareStore trs = mock(hanterareStore.class);
        hanterare cut = new hanterare(trs);
    }

    @Test
    void addBook() {
    }


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





}