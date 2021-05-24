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



    void test() {
        hanterareStoreStub stub = new hanterareStoreStub();
        hanterare cut = new hanterare(stub);

        stub.bocker.add(new Book(2324, "Open", 454533));
        stub.bocker.add(new Book(2524, "Not Open", 4545233));

    }
}