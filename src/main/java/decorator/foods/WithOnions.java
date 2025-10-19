package decorator.foods;

public class WithOnions implements Food {

    private final Food decoratedFood;

    public WithOnions(Food food) {
        this.decoratedFood = food;
    }

    @Override
    public double getPrice() {
        return 0.49 + this.decoratedFood.getPrice();
    }
}
