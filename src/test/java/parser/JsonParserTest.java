package parser;

import java.io.File;

import org.junit.jupiter.api.Disabled;
import shop.Cart;
import shop.RealItem;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class JsonParserTest {
    final String testCartName = "anna-cart";
    final String testCartFileName = "./src/main/resources/" + this.testCartName + ".json";
    Cart testCart;


    @BeforeEach
    void setUp() {
        testCart = new Cart(testCartName);

        RealItem bag = new RealItem();
        bag.setName("Bag");
        bag.setPrice(22.9);
        bag.setWeight(1.5);

        testCart.addRealItem(bag);
    }

    @AfterEach
    void tearDown() {
        File f = new File(testCartFileName);
        if (f.exists()) {
            f.delete();
        }
        testCart = null;
    }

    @Test
    void writeToFile() {
        Parser parser = new JsonParser();
        parser.writeToFile(testCart);

        File f = new File(testCartFileName);
        assertTrue(f.exists(), "file %s doesn't exists".format(testCartFileName));
    }

    @Disabled
    @Test
    void readFromFile() {
        Parser parser = new JsonParser();
        parser.writeToFile(testCart);

        Cart checkedCart = parser.readFromFile(new File(testCartFileName));
        assertEquals(checkedCart.getCartName(), testCart.getCartName());
        assertEquals(checkedCart.getTotalPrice(), testCart.getTotalPrice());
    }
    @ParameterizedTest
    @ValueSource(strings = { "test", "12345",
            "@#$%^", "    ", "test@test.com"})
    void readFromFileException(String fileName) {
        Parser parser = new JsonParser();
        assertThrows(NoSuchFileException.class,
                () -> {
                    Cart checkedCart = parser.readFromFile(new File(fileName));
                }
        );
    }
}