package service;

import intf.PricingStrategy;

public class IPLDiscountStrategy implements PricingStrategy {
    public double getDiscountedPrice(Double amount) {
        return amount-50;
    }
}
