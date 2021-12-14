/*
Tyler Lindsay
Nicholas Saylor
Crypto Idle
2021-11-5
Upgrades class with constructor
 */

import java.util.*;

public class Upgrade {
    // Mult is the multiplier for calculating cost of next unit
    // Revenue is $/sec per unit
    private final double mult, revenue;
    // Current price of next unit
    private double price;
    // Total units owned
    private int amtOwned;
    // Name for UI
    private final String name;    
    
    // Assign all values to instance variables
    public Upgrade(double mult, double price, double revenue, int amtOwned, String name) {
        this.mult = mult;
        this.price = price;
        this.revenue = revenue;
        this.amtOwned = amtOwned;
        this.name = name;
    }

    
    // Calculates if the user can buy an upgrade (returns amount to subtract from balance)
    public double buy(double balance){
        if (balance >= price){
            amtOwned++;
            double cost = price;
            price *= mult;
            // Rounding hack (2 decimal places)
            price *= 100;
            price = Math.round(price);
            price /= 100.0;
            // Subtract price from balance
            return cost;
        }
        // No purchase made
        return 0;
    }
    
    
    // Get methods
    
    public double getCost() {
        return price;
    }
    
    // Represents total revenue of all units
    public double getRev(){
        return (revenue * amtOwned);
    }
    
    public int getQuantity(){
        return amtOwned;
    }
    
    public String getName() {
        return name;
    }
    
    @Override
    public String toString(){
        return String.format("%.2f,%.2f,%.2f,%d,%s", mult, price, revenue, amtOwned, name);
    }
    
}