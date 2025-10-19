package decorator;

import decorator.foods.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestLoyaltyStatus {

    @Test
    public void loyaltyStatusIsCorrectlyApplied() {
        Order order = new Order();
        order.addToOrder(new WithCheese(new WithKetchup(new Burger())));
        order.addToOrder(new WithOnions(new WithKetchup(new HotDog())));
        order.addToOrder(new WithOnions(new WithKetchup(new WithCheese(new Fries()))));

        LoyaltyStatus status = new LoyaltyStatus(0.15);

        assertEquals(11.90, status.applyDiscount(order), 0.001);
    }
}
