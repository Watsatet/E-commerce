package org.assignment;

public class MainSystem {
    public static void main(String[] args) throws CloneNotSupportedException {
        // Create products
        Product laptop = new Laptop("Laptop", 1000, true);
        Product headphones = new Headphones("Headphones", 50, true);

        // Display products
        System.out.println("Available Products:");
        System.out.println(laptop.getName() + " : $" + laptop.getPrice());
        System.out.println(headphones.getName() + " : $" + headphones.getPrice());

        // Create a cart and add products
        Cart cart = new Cart();
        
        cart.addProduct(laptop);
        cart.addProduct(headphones);

        // Update quantity
        cart.updateQuantity(laptop, 2);

        // Display cart items
        cart.displayCartItems();

        // Calculate and display total bill
        double total = cart.calculateTotal();
        System.out.println("Total Bill: $" + total);

        // Apply discounts
        DiscountStrategy noDiscount = new NoDiscountStrategy();
        DiscountStrategy percentageDiscount = new PercentageDiscountStrategy(10);
        DiscountStrategy bogoDiscount = new BuyOneGetOneFreeStrategy();

        double noDiscountTotal = noDiscount.applyDiscount(total);
        double percentageDiscountTotal = percentageDiscount.applyDiscount(total);
        double bogoDiscountTotal = bogoDiscount.applyDiscount(total);

        System.out.println("Total Bill (No Discount): $" + noDiscountTotal);
        System.out.println("Total Bill (10% Discount): $" + percentageDiscountTotal);
        System.out.println("Total Bill (Buy One Get One Free): $" + bogoDiscountTotal);
    }
}
