package application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This class represents student test cases for a Property object.
 *
 * @author Your Name
 * @version Date
 */
class PropertyTestStudent {
    Property propertyOne;

    @BeforeEach
    void setUp() throws Exception {
        propertyOne = new Property("Property XYZ", "Silver Spring", 2000.0, "Bank of America");
    }

    @AfterEach
    void tearDown() throws Exception {
        propertyOne = null;
    }

    @Test
    void testGetPropertyName() {
        assertEquals("Property XYZ", propertyOne.getPropertyName());
    }

    @Test
    void testGetRentAmount() {
        assertEquals(2000.0, propertyOne.getRentAmount());
    }

    @Test
    void testGetPlot() {
        assertEquals(0, propertyOne.getPlot().getX());
        assertEquals(0, propertyOne.getPlot().getY());
        assertEquals(1, propertyOne.getPlot().getWidth());
        assertEquals(1, propertyOne.getPlot().getDepth());
    }

    @Test
    void testToString() {
        assertEquals("Property XYZ,Silver Spring,Bank of America,2000.0", propertyOne.toString());
    }

    // Add additional test cases based on the methods in your Property class
}
