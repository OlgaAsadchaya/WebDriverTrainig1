package parser;

import java.io.File;

import org.junit.jupiter.api.Disabled;
import shop.Cart;
import shop.RealItem;

import static org.junit.jupiter.api.Assertions.*;

class JsonParserTest {
    String testCartName = "anna-cart";
    String testCartFileName = "./src/main/resources/" + this.testCartName + ".json";
    Cart testCart;


    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        testCart = new Cart(testCartName);

        RealItem bag = new RealItem();
        bag.setName("Bag");
        bag.setPrice(22.9);
        bag.setWeight(1.5);

        testCart.addRealItem(bag);
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        File f = new File(testCartFileName);
        if (f.exists())
        {
            f.delete();
        }
        testCart = null;
    }

    @org.junit.jupiter.api.Test
    void writeToFile() {
        Parser parser = new JsonParser();
        parser.writeToFile(testCart);

        File f = new File(testCartFileName);
        assertTrue(f.exists());
    }

    @org.junit.jupiter.api.Test
    void readFromFile() {
        Parser parser = new JsonParser();
        parser.writeToFile(testCart);

        Cart checkedCart = parser.readFromFile(new File(testCartFileName));
        assertEquals(checkedCart.getCartName(), testCart.getCartName());
        assertEquals(checkedCart.getTotalPrice(), testCart.getTotalPrice());
    }
    @Disabled
    @org.junit.jupiter.api.Test
    void readFromFileException() {
        Parser parser = new JsonParser();
        assertThrows(NoSuchFileException.class,
                () -> {
                    Cart checkedCart = parser.readFromFile(new File("wwwwww"));
                }
        );
    }
}