package shop;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VirtualItemTestNG {
    VirtualItem virtualItem;
    final double sizeOnDisk = 789.34;

    @BeforeMethod
    public void setUp() {
        virtualItem = new VirtualItem();
        virtualItem.setSizeOnDisk(sizeOnDisk);
    }

    @AfterMethod
    public void tearDown() {
        virtualItem = null;
    }

    @Test
    public void testToString() {
        assertEquals(virtualItem.toString(),
                "%s; Size on disk: %s".format(
                        ((Item)virtualItem).toString(), virtualItem.getSizeOnDisk())
        );
    }
}