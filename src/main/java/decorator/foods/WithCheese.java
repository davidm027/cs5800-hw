package decorator.foods;

public class WithCheese implements Food {

    private final Food decoratedFood;

    public WithCheese(Food food) {
        this.decoratedFood = food;
    }

    @Override
    public double getPrice() {
        return 0.99 + this.decoratedFood.getPrice();
    }
}
