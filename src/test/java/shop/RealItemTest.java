package shop;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RealItemTest {
    RealItem realItem;
    final double itemWeight = 55.7;

    @BeforeEach
    void setUp() {
        realItem = new RealItem();
        realItem.setWeight(itemWeight);
    }

    @AfterEach
    void tearDown() {
        realItem = null;
    }

    @Test
    void toStr() {
        assertEquals(realItem.toString(),
                "%s; Weight: %s".format(
                        ((Item)realItem).toString(), realItem.getWeight())
        );

    }
}