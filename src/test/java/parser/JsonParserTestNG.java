package parser;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import shop.Cart;
import shop.RealItem;

import java.io.File;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class JsonParserTestNG {
    final String testCartName = "anna-cart";
    final String testCartFileName = "./src/main/resources/" + this.testCartName + ".json";
    Cart testCart;


    @BeforeMethod
    public void setUp() {
        testCart = new Cart(testCartName);

        RealItem bag = new RealItem();
        bag.setName("Bag");
        bag.setPrice(22.9);
        bag.setWeight(1.5);

        testCart.addRealItem(bag);
    }

    @AfterMethod
    public void tearDown() {
        File f = new File(testCartFileName);
        if (f.exists())
        {
            f.delete();
        }
        testCart = null;
    }

    @Test
    public void testWriteToFile() {
        Parser parser = new JsonParser();
        parser.writeToFile(testCart);

        File f = new File(testCartFileName);
        assertTrue(f.exists(), "file %s doesn't exists".format(testCartFileName));
    }

    @Test
    public void testReadFromFile() {
        Parser parser = new JsonParser();
        parser.writeToFile(testCart);

        Cart checkedCart = parser.readFromFile(new File(testCartFileName));
        assertEquals(checkedCart.getCartName(), testCart.getCartName());
        assertEquals(checkedCart.getTotalPrice(), testCart.getTotalPrice());
    }

    @DataProvider
    public Object[][] fileNames() {
        return new Object[][] {
                {"test"},
                {"12345"},
                {"@#$%^"},
                {"test@test.com"},
        };
    }

    @Test(dataProvider = "fileNames", expectedExceptions = NoSuchFileException.class)
    void readFromFileException(String fileName) {
        Parser parser = new JsonParser();
        Cart checkedCart = parser.readFromFile(new File(fileName));
    }
}