package shop;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

class CartTest {

    Cart cart;
    final String cartName = "test cart";


    @BeforeEach
    void setUp() {
        cart = new Cart(cartName);
    }

    @AfterEach
    void tearDown() {
        cart = null;
    }

    @Test
    void getCartName() {
        assertEquals(cart.getCartName(), cartName);
    }
}