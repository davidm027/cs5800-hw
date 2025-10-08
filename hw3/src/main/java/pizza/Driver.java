package pizza;

import java.util.ArrayList;
import java.util.Arrays;

public class Driver {
    public static void main(String[] args) throws Exception {
        // part 1
        System.out.println("*** PART 1");
        Pizza small =
                new PizzaHut().setSize(Size.SMALL).addTopping(Topping.BACON).addTopping(Topping.MUSHROOMS).addTopping(Topping.OLIVES).makePizza();
        ArrayList<Topping> medToppings = new ArrayList<>(Arrays.asList(Topping.BACON, Topping.CHICKEN, Topping.PEPPERS, Topping.HAM,
                Topping.TOMATO_AND_BASIL, Topping.BEEF));
        ArrayList<Topping> largeToppings = new ArrayList<>(Arrays.asList(Topping.BACON, Topping.CHICKEN, Topping.PEPPERS, Topping.HAM,
                Topping.ONIONS, Topping.BEEF, Topping.PEPPERONI, Topping.SPICY_PORK,
                Topping.PESTO));
        Pizza medium =
                new PizzaHut().setSize(Size.MEDIUM).addToppings(medToppings).makePizza();
        Pizza large =
                new PizzaHut().setSize(Size.LARGE).addToppings(largeToppings).makePizza();

        small.eat();
        medium.eat();
        large.eat();

        System.out.println();
        // part 2
        System.out.println("*** PART 2");
        Pizza pHutLarge =
                new PizzaHut().setSize(Size.LARGE).addTopping(Topping.PEPPERONI).addTopping(Topping.SAUSAGE).addTopping(Topping.HAM).makePizza();
        Pizza pHutSmall =
                new PizzaHut().setSize(Size.SMALL).addTopping(Topping.MUSHROOMS).addTopping(Topping.OLIVES).makePizza();
        pHutLarge.eat();
        pHutSmall.eat();

        ArrayList<Topping> lcMedToppings = new ArrayList<>(Arrays.asList(Topping.BACON, Topping.CHICKEN, Topping.PEPPERS, Topping.HAM,
                Topping.ONIONS, Topping.BEEF, Topping.PEPPERONI, Topping.SPICY_PORK));
        ArrayList<Topping> lcSmallToppings = new ArrayList<>(Arrays.asList(Topping.BACON, Topping.CHICKEN, Topping.PEPPERS, Topping.HAM,
                Topping.TOMATO_AND_BASIL, Topping.BEEF));
        Pizza lcMedium =
                new LittleCaesars().setSize(Size.MEDIUM).addToppings(lcMedToppings).makePizza();
        Pizza lcSmall =
                new LittleCaesars().setSize(Size.SMALL).addToppings(lcSmallToppings).makePizza();
        lcMedium.eat();
        lcSmall.eat();

        Pizza dominosSmall =
                new Dominos().setSize(Size.SMALL).addTopping(Topping.EXTRA_CHEESE).makePizza();
        Pizza dominosMedium =
                new Dominos().setSize(Size.MEDIUM).addTopping(Topping.HAM_AND_PINEAPPLE).addTopping(Topping.PEPPERS).addTopping(Topping.ONIONS).makePizza();
        dominosSmall.eat();
        dominosMedium.eat();
    }
}
