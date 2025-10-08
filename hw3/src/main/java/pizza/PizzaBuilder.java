package pizza;

import java.util.ArrayList;

public abstract class PizzaBuilder {

    private String chain;
    private Size size;
    private ArrayList<Topping> toppings;

    public PizzaBuilder() {
        this.toppings = new ArrayList<>();
    }

    public PizzaBuilder setChain(String chain) {
        this.chain = chain;
        return this;
    }

    public PizzaBuilder setSize(Size size) {
        this.size = size;
        return this;
    }

    public PizzaBuilder addTopping(Topping topping) {
        this.toppings.add(topping);
        return this;
    }

    public PizzaBuilder addToppings(ArrayList<Topping> toppings) {
        this.toppings.addAll(toppings);
        return this;
    }

    public Pizza makePizza() throws Exception {
        if (this.size == null) {
            throw new Exception("Size MUST be set before this pizza can be made.");
        }
        return new Pizza(this.chain, this.size, this.toppings);
    }

}
