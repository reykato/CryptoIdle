/*
Tyler Lindsay
Nicholas Saylor
Crypto Idle
2021-11-5
Upgrades class with constructor
 */

import java.lang.Math;
import javax.swing.*;
import java.awt.*;

public class Upgrade {
    private final double mult, basePrice, revenue;
    private int amtOwned;
    private final String name;
    private String costFormat;
    
    
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
        double cost = calcCost(quantity);
        if (balance >= cost){
            amtOwned += quantity;
            updateString();
            return cost;
        }
        return 0;
    }
    
    
    private void updateString(){
        costFormat = String.format("%4.2f", calcCost(0));
    }
    
    // Get methods
    
    public int getQuantity(){
        return amtOwned;
    }
    
    public double getRev(){
        return revenue;
    }  
    
    
    
    // Draw method
    // TODO: Add a way to repaint the panel to update the price
    public JPanel drawUpgrade() {        
        Font f = new Font("Display", Font.BOLD, 20);
        MyPanel p = new MyPanel();
        p.setLayout(null);
        p.setSize(300, 80);
        JLabel nameL, revL, cost;
        
        
        // name label
        nameL = new JLabel(name);
        nameL.setFont(f);
        nameL.setBounds(4, 4, 240, 25);
        
        
        // i am unsure if revenue should be displayed
        /*
        revL = new JLabel(String.valueOf(revenue));
        revL.setHorizontalAlignment(SwingConstants.LEFT);
        revL.setFont(f);
        revL.setBounds(4, 34, 50, 25);
        */
        
        costFormat = String.format("%4.2f", calcCost(0)); // temporarily set the 10x multiplier true for testing
        
        // cost label
        cost = new JLabel(costFormat);
        cost.setFont(f);
        cost.setBounds(4, 34, 240, 25);
        
        p.add(nameL);
        //p.add(revL);
        p.add(cost);
        return p;        
    }

}


class MyPanel extends JPanel { // create custom panel constructor to draw a rectangle to contain the upgrade
    void drawRectangles(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        
        g2d.setStroke(new BasicStroke(2));
        g2d.drawRect(1, 1, 250, 60);
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        drawRectangles(g);
    }
}