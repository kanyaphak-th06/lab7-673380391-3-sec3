package com.example.lab7_673380391_3_sec3.strategy;

public class StudentDiscountStrategy implements DiscountStrategy {
    @Override
    public double multiply(double price) {
        return price * 0.90; // หักส่วนลด 10% (จ่าย 90%)
    }
}
