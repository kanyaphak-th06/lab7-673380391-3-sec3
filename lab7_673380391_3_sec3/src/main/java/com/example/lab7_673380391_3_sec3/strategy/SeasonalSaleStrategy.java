package com.example.lab7_673380391_3_sec3.strategy;

public class SeasonalSaleStrategy implements DiscountStrategy {
    @Override
    public double calculateDiscount(double originalPrice) {
        return originalPrice * 0.80; // ส่วนลด 20%
    }
}
