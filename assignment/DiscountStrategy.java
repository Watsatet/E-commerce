package org.assignment;

public interface DiscountStrategy {
    double applyDiscount(double total);
}

class NoDiscountStrategy implements DiscountStrategy {
    @Override
    public double applyDiscount(double total) {
        return total;
    }
}

class PercentageDiscountStrategy implements DiscountStrategy {
    private double percentage;

    public PercentageDiscountStrategy(double percentage) {
        this.percentage = percentage;
    }

    @Override
    public double applyDiscount(double total) {
        return total - (total * percentage / 100);
    }
}

class BuyOneGetOneFreeStrategy implements DiscountStrategy {
    @Override
    public double applyDiscount(double total) {
        return total / 2;
    }
}
