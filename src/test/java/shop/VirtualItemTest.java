package shop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VirtualItemTest {
    VirtualItem virtualItem;
    final double sizeOnDisk = 789.34;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        virtualItem = new VirtualItem();
        virtualItem.setSizeOnDisk(sizeOnDisk);
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        virtualItem = null;
    }

    @Test
    void getSizeOnDisk() {
        assertEquals(virtualItem.getSizeOnDisk(), sizeOnDisk);
    }

    @Test
    void toStr() {
        assertEquals(virtualItem.toString(),
                "%s; Size on disk: %s".format(
                        ((Item)virtualItem).toString(), virtualItem.getSizeOnDisk())
        );
    }
}