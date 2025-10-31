package flyweight;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FontTest {

    Font font;

    @BeforeEach
    void setup() {
        font = new Font();
    }

    @Test
    void testGetType() {
        assertEquals("FONT", font.getType());
    }

    @Test
    void testGetSetProperty() {
        font.setProperty("Arial");
        assertEquals("Arial", font.getProperty());
    }

}