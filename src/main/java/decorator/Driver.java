package decorator;

import decorator.foods.*;

public class Driver {

    public static void main(String[] args) {
        Food burger = new Burger();
        burger = new WithCheese(new WithKetchup(burger));
        System.out.println("Cost of burger with ketchup and cheese: " + burger.getPrice());

        Food hotDog = new HotDog();
        hotDog = new WithOnions(new WithKetchup(hotDog));
        System.out.println("Cost of hot dog with ketchup and onions: " + hotDog.getPrice());

        Food fries = new Fries();
        fries = new WithOnions(new WithKetchup(new WithCheese(fries)));
        System.out.println("Cost of fries with all toppings: " + fries.getPrice());

        Order order = new Order();
        order.addToOrder(new WithCheese(new WithKetchup(new Burger())));
        order.addToOrder(new WithOnions(new WithKetchup(new HotDog())));
        order.addToOrder(new WithOnions(new WithKetchup(new WithCheese(new Fries()))));
        System.out.println("My new order: burger with ketchup and cheese, hot dog with ketchup " +
                "and onions, fries with all toppings" );
        System.out.println("Cost: " + order.calculateOrderCost());

        LoyaltyStatus status = new LoyaltyStatus(0.15);
        System.out.println("Cost of order with 15% discount: " + status.applyDiscount(order));
    }

}
