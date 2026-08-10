package com.example.lab7_673380391_3_sec3.strategy;

public class NoDiscountStrategy implements DiscountStrategy {
    @Override
    public double multiply(double price) {
        return price; // ราคาปกติ ไม่หักส่วนลด
    }
}