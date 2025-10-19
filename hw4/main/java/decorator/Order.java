package decorator;

import decorator.foods.Food;

import java.util.*;

public class Order {
    private List<Food> order;

    public Order(List<Food> order) {
        this.order = order;
    }

    public Order() {
        this.order = new ArrayList<>();
    }

    public List<Food> getOrder() {
        return this.order;
    }

    public void addToOrder(Food food) {
        this.getOrder().add(food);
    }

    public double calculateOrderCost() {
        return this.getOrder().stream().map(Food::getPrice).reduce(0.0, Double::sum);
    }
}
