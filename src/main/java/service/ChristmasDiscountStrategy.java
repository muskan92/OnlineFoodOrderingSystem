package service;

import intf.PricingStrategy;

public class ChristmasDiscountStrategy implements PricingStrategy {
    public double getDiscountedPrice(Double amount) {
        return amount/2;
    }
}
