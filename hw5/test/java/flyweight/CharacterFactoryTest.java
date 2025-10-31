package flyweight;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharacterFactoryTest {

    CharacterFactory factory;

    @BeforeEach
    void setUp() {
        factory = new CharacterFactory();
    }

    @Test
    void testGetPropertyFont() {
        assertTrue(factory.getPropertyMap().isEmpty());
        Property p = factory.getProperty(0);
        assertInstanceOf(Font.class, p);
        assertTrue(factory.getPropertyMap().containsValue(p));
    }

    @Test
    void testGetPropertyColor() {
        assertTrue(factory.getPropertyMap().isEmpty());
        Property p = factory.getProperty(1);
        assertInstanceOf(Color.class, p);
        assertTrue(factory.getPropertyMap().containsValue(p));
    }

    @Test
    void testGetPropertySize() {
        assertTrue(factory.getPropertyMap().isEmpty());
        Property p = factory.getProperty(2);
        assertInstanceOf(Size.class, p);
        assertTrue(factory.getPropertyMap().containsValue(p));
    }
}