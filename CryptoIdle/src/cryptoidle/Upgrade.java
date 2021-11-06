/*
Tyler Lindsay
Nicholas Saylor
Crypto Idle
2021-11-5
Upgrades class with constructor
 */
package cryptoidle;
public class Upgrade {
    private double mult, basePrice, revenue;
    private int amtOwned;
    public Upgrade(double mult, double basePrice, double revenue, int amtOwned) {
        this.mult = mult;
        this.basePrice = basePrice;
        this.revenue = revenue;
        this.amtOwned = amtOwned;
    }
    
    public double calcDisp(boolean tenX) {
        double dispBal = basePrice;
        if (tenX) { // if 10x buy multiplier is selected
            for (int y = 0; y < amtOwned + 10; y++) { // calculates the price of the next ten upgrades
                dispBal *= mult;
            }            
        } else { // if 1x buy multiplier is selected
            for (int i = 0; i < amtOwned + 1; i++) { // calculates the price of the next single upgrade
                dispBal *= mult;
            }            
        }
        return dispBal;
    }
    
    
    
    
    
    
    
    
}
