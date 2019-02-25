package shop;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RealItemTestNG {
    RealItem realItem;
    final double itemWeight = 55.7;

    @BeforeMethod
    public void setUp() {
        realItem = new RealItem();
        realItem.setWeight(itemWeight);
    }

    @AfterMethod
    public void tearDown() {
        realItem = null;
    }

    @Test
    public void testToString() {
        assertEquals(realItem.toString(),
                "%s; Weight: %s".format(
                        ((Item)realItem).toString(), realItem.getWeight())
        );
    }
}