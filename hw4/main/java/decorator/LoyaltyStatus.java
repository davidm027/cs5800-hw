package decorator;

public class LoyaltyStatus {
    private final double discountPercent;

    public LoyaltyStatus(Double discountPercent) {
        if (discountPercent < 0 || discountPercent > 1.00) {
            throw new IllegalArgumentException("Discount out of bounds");
        }
        this.discountPercent = discountPercent;
    }

    public double getDiscount() {
        return this.discountPercent;
    }

    public double applyDiscount(Order order) {
        return order.calculateOrderCost() * (1 - this.getDiscount());
    }
}
