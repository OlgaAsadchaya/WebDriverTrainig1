package shop;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CartTestNG {

    Cart cart;
    final String cartName = "test cart";

    @BeforeMethod
    public void setUp() {
        cart = new Cart(cartName);
    }

    @AfterMethod
    public void tearDown() {
        cart = null;
    }

    @Test
    public void testGetCartName() {
        assertEquals(cart.getCartName(), cartName);
    }
}
