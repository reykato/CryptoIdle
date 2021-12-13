/*
Tyler Lindsay
Nicholas Saylor
Crypto Idle
2021-11-5
Upgrades class with constructor
 */

package cryptoidle;

public class Upgrade {
    private final double mult, basePrice, revenue;
    private int amtOwned;
    private final String name;    
    
    public Upgrade(double mult, double basePrice, double revenue, int amtOwned, String name) {
        this.mult = mult;
        this.basePrice = basePrice;
        this.revenue = revenue;
        this.amtOwned = amtOwned;
        this.name = name;
    }
    
    
    // Methods involving increasing costs
    
    public double calcCost(int quantity) {
        double totalCost = basePrice;
        for (int i = 1; i <= quantity; i++){
            totalCost += basePrice * (Math.pow(mult, (amtOwned + i)));
        }
        return totalCost;
    }
    
    public double buy(double balance, int quantity){
        double cost = calcCost(amtOwned + quantity);
        if (balance >= cost){
            amtOwned += quantity;
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
        return calcCost(amtOwned);
    }
    
}