package shop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RealItemTest {
    RealItem realItem;
    final double itemWeight = 55.7;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        realItem = new RealItem();
        realItem.setWeight(itemWeight);
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        realItem = null;
    }

    @Test
    void getWeight() {
        assertEquals(realItem.getWeight(), itemWeight);
    }

    @Test
    void toStr() {
        assertEquals(realItem.toString(),
                "%s; Weight: %s".format(
                        ((Item)realItem).toString(), realItem.getWeight())
        );

    }
}