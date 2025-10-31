package flyweight;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ColorTest {

    Color color;

    @BeforeEach
    void setup() {
        color = new Color();
    }

    @Test
    void testGetType() {
        assertEquals("COLOR", color.getType());
    }

    @Test
    void testGetSetProperty() {
        color.setProperty("Red");
        assertEquals("Red", color.getProperty());
    }

}