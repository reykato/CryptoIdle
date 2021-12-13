/*
Tyler Lindsay
Nicholas Saylor
Crypto Idle
2021-11-5
Upgrades class with constructor
 */

import java.util.*;

public class Upgrade {
    private final double mult, revenue;
    private double basePrice;
    private int amtOwned;
    private final String name;    
    
    public Upgrade(double mult, double basePrice, double revenue, int amtOwned, String name) {
        this.mult = mult;
        this.basePrice = basePrice;
        this.revenue = revenue;
        this.amtOwned = amtOwned;
        this.name = name;
    }

    
    public double buy(double balance){
        double cost = basePrice;
        if (balance >= cost){
            amtOwned++;
            basePrice *= mult;
            // Rounding hack (2 decimal places)
            basePrice *= 100;
            basePrice = Math.round(basePrice);
            basePrice /= 100.0;
            return cost;
        }
        return 0;
    }
    public int getQuantity(){
        return amtOwned;
    }
    
    public double getRev(){
        return revenue;
    }  
    public String getName() {
        return name;
    }
    public double getCost() {
        return basePrice;
    }
    
}