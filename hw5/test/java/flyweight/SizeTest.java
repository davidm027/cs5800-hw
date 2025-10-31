package flyweight;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SizeTest {

    Size size;

    @BeforeEach
    void setup() {
        size = new Size();
    }

    @Test
    void testGetType() {
        assertEquals("SIZE", size.getType());
    }

    @Test
    void testGetSetProperty() {
        size.setProperty("12");
        assertEquals("12", size.getProperty());
    }

}