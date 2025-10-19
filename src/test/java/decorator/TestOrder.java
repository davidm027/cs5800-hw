package decorator;

import decorator.foods.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestOrder {

    @Test
    public void orderCostIsCorrect() {
        Order order = new Order();
        order.addToOrder(new WithCheese(new WithKetchup(new Burger())));
        order.addToOrder(new WithOnions(new WithKetchup(new HotDog())));
        order.addToOrder(new WithOnions(new WithKetchup(new WithCheese(new Fries()))));

        assertEquals(14.00, order.calculateOrderCost(), 0.001);
    }
}
