package shop;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VirtualItemTest {
    VirtualItem virtualItem;
    final double sizeOnDisk = 789.34;

    @BeforeEach
    void setUp() {
        virtualItem = new VirtualItem();
        virtualItem.setSizeOnDisk(sizeOnDisk);
    }

    @AfterEach
    void tearDown() {
        virtualItem = null;
    }

    @Test
    void toStr() {
        assertEquals(virtualItem.toString(),
                "%s; Size on disk: %s".format(
                        ((Item)virtualItem).toString(), virtualItem.getSizeOnDisk())
        );
    }
}