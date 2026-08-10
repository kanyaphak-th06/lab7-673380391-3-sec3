package com.example.lab7_673380391_3_sec3.strategy;

public class SeasonalSaleStrategy implements DiscountStrategy {
    @Override
    public double multiply(double price) {
        return price * 0.80; // หักส่วนลด 20% (จ่าย 80%)
    }
}
