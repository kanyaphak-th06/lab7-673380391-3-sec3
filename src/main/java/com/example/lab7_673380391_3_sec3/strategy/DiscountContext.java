package com.example.lab7_673380391_3_sec3.strategy;

public class DiscountContext {
    public static double getNetPrice(String type, double price) {
        DiscountStrategy strategy;
        
        if (type == null) {
            type = "NONE";
        }
        
        switch (type.toUpperCase()) {
            case "STUDENT":
                strategy = new StudentDiscountStrategy();
                break;
            case "SEASONAL":
                strategy = new SeasonalSaleStrategy();
                break;
            default:
                strategy = new NoDiscountStrategy();
                break;
        }
        
        return strategy.multiply(price);
    }
}
