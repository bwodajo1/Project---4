package application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This class represents student test cases for a Plot object.
 */
class PlotTestStudent {
    Plot plotOne;

    @BeforeEach
    void setUp() throws Exception {
        plotOne = new Plot(1, 2, 5, 6);
    }

    @AfterEach
    void tearDown() throws Exception {
        plotOne = null;
    }

    @Test
    void testSetX() {
        plotOne.setX(3);
        assertEquals(3, plotOne.getX());
    }

    @Test
    void testSetY() {
        plotOne.setY(4);
        assertEquals(4, plotOne.getY());
    }

    @Test
    void testSetWidth() {
        plotOne.setWidth(7);
        assertEquals(7, plotOne.getWidth());
    }

    @Test
    void testSetDepth() {
        plotOne.setDepth(8);
        assertEquals(8, plotOne.getDepth());
    }

    @Test
    void testEncompasses() {
        Plot plotTwo = new Plot(2, 3, 4, 5);
        assertTrue(plotOne.encompasses(plotTwo));
    }

    @Test
    void testOverlaps() {
        Plot plotTwo = new Plot(3, 4, 6, 7);
        assertTrue(plotOne.overlaps(plotTwo));
    }

    @Test
    void testToString() {
        assertEquals("1,2,5,6", plotOne.toString());
    }

    @Test
    void testConstructor() {
        Plot plotTwo = new Plot();
        assertEquals(0, plotTwo.getX());
        assertEquals(0, plotTwo.getY());
        assertEquals(1, plotTwo.getWidth());
        assertEquals(1, plotTwo.getDepth());
    }
}
