package decorator.foods;

public class WithKetchup implements Food {

    private final Food decoratedFood;

    public WithKetchup(Food food) {
        this.decoratedFood = food;
    }

    @Override
    public double getPrice() {
        return 0.19 + this.decoratedFood.getPrice();
    }
}
