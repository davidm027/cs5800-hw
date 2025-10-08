package pizza;

import java.util.ArrayList;

public class Pizza {

    private String chain;
    private Size size;
    private ArrayList<Topping> toppings;

    public Pizza(String chain, Size size, ArrayList<Topping> toppings) {
        this.chain = chain;
        this.size = size;
        this.toppings = toppings;
    }

    public void eat() {
        StringBuilder sb = new StringBuilder();
        sb.append("Chain: " + this.chain + ", size: " + this.size.toString().toLowerCase() + ", toppings: ");
        for (Topping t : this.toppings) {
            String topping = t.toString().toLowerCase().replace("_", " ");
            if (!(t == this.toppings.getLast())) {
                topping += ", ";
            }
            sb.append(topping);
        }

        System.out.println(sb);
    }

}
