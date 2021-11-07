/*
Tyler Lindsay
Nicholas Saylor
Crypto Idle
2021-11-5
Upgrades class with constructor
 */
package cryptoidle;
import javax.swing.*;
import java.awt.*;
public class Upgrade {
    private final double mult, basePrice, revenue;
    private final int amtOwned;
    private final String name;
    public Upgrade(double mult, double basePrice, double revenue, int amtOwned, String name) {
        this.mult = mult;
        this.basePrice = basePrice;
        this.revenue = revenue;
        this.amtOwned = amtOwned;
        this.name = name;
        
        
    }
    
    public double calcDisp(boolean tenX) { // tenX is true if the next ten upgrades should be calculated, false if only the next upgrade should be calculated
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
    
    
    public JPanel drawUpgrade () {        
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
        
        String costFormat = String.format("%d", Math.round(calcDisp(true))); // temporarily set the 10x multiplier true for testing
        
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