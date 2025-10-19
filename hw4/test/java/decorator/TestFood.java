package decorator;

import decorator.foods.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestFood {
    @Test
    void burgerKetchupCheeseHasCorrectPrice() {
        Food burger = new Burger();
        burger = new WithCheese(new WithKetchup(burger));
        assertEquals(6.17, burger.getPrice(), 0.001);
    }

    @Test
    void hotDogKetchupOnionsHasCorrectPrice() {
        Food hotDog = new HotDog();
        hotDog = new WithOnions(new WithKetchup(hotDog));
        assertEquals(2.17, hotDog.getPrice(), 0.001);
    }

    @Test
    void friesAllToppingsHasCorrectPrice() {
        Food fries = new Fries();
        fries = new WithOnions(new WithKetchup(new WithCheese(fries)));
        assertEquals(5.66, fries.getPrice(), 0.001);
    }
}
