//package cryptoidle;
import java.awt.GridLayout;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;
import javax.swing.JPanel;
import java.awt.*;
import javax.swing.JLabel;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.SwingUtilities;


public class UIElements extends JFrame {
    // Array of upgrades that all math is done on
    Upgrade[] upgdArr = new Upgrade[6];
    // Balance of player
    double balance, CPS = 0;
    // Tweaked interval to a value that felt good
    private final int INTERVAL = 40;
    private final int TPS = 1000 / INTERVAL;
    Font dispFont = new Font("Arial", Font.BOLD, 30);
    Font subFont = new Font("Arial", Font.BOLD, 20);
    
    public UIElements(Upgrade[] upgdArr, double balance) {
        // Initialize window and get all variables in place
        super();
        this.upgdArr = upgdArr;
        this.balance = balance;
        run();
    }
    
    public void run() {
        // Frame attributes
        JFrame frame = new JFrame("CryptoIdle");
        frame.setSize(366, 760);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new GridLayout(8,0));
        frame.setVisible(true);
        
        
        // Balance label
        JLabel bal = new JLabel(String.format("%.2f", this.balance));
        bal.setFont(dispFont);
        bal.setHorizontalAlignment(JLabel.CENTER);
        frame.add(bal);
        
        JLabel cps = new JLabel(String.format("%.2f", this.CPS));
        cps.setFont(subFont);
        cps.setHorizontalAlignment(JLabel.CENTER);
        frame.add(cps);
        
        // Upgrade UI elements
        for (var upgrade : upgdArr) {
            frame.getContentPane().add(drawUpgrade(upgrade));
        }
        
        // Tick handler
        ActionListener taskPerformer = new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent e) {
                    // Find new balance for the tick
                    calculateBalance();
                    balance *= 100;
                    balance = Math.round(balance);
                    balance /= 100.0;
                    
                    // Reset balance label
                    JLabel bal = new JLabel(String.format("%.2f", getBalance()));
                    bal.setFont(dispFont);
                    bal.setHorizontalAlignment(JLabel.CENTER);
                    // Clear frame
                    frame.getContentPane().removeAll();
                    // Add all content panes again
                    frame.add(bal);
                    JLabel cps = new JLabel(String.format("Per second: $%.2f", CPS*TPS));
                    cps.setFont(subFont);
                    cps.setHorizontalAlignment(JLabel.CENTER);
                    frame.add(cps);
                    for (var upgrade : upgdArr) {
                        frame.getContentPane().add(drawUpgrade(upgrade));
                    }
                    // Refresh view
                    frame.getContentPane().revalidate();
                    frame.getContentPane().repaint();
            }
        };
        // Run the tick handler again after INTERVAL milliseconds
        new Timer(INTERVAL, taskPerformer).start();
    }
    
    // Adds the revenue from most recent tick
    public void calculateBalance() {
        double totalRev = 0;
        for (Upgrade item : upgdArr) {
            totalRev += item.getRev();
        }
        CPS = totalRev / (double)TPS;
        balance += CPS;
    }
    
    // Get methods
    
    public Upgrade[] getUpgradeArray() {
        return upgdArr;
    }
    
    public double getBalance() {
        return balance;
    }
        
    
    
    // Creates Panels for each upgrade
    public JPanel drawUpgrade(Upgrade upgrade) {    
        // Panel boilerplate
        Font display = new Font("Display", Font.BOLD, 20);
        Font rev = new Font("Display", Font.PLAIN, 16);
        MyPanel p = new MyPanel();
        p.setLayout(null);
        p.setSize(300, 100);
        // Values and buttons
        JLabel nameL, revL, cost;
        JButton buyButton;
        
        // Name label
        nameL = new JLabel(upgrade.getName());
        nameL.setFont(display);
        nameL.setBounds(84, 4, 240, 25);
        
        // Buy button functionality
        buyButton = new JButton("Buy");
        buyButton.setBounds(4, 4, 70, 56);
        buyButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                balance -= upgrade.buy(balance);
                // Rounding hack (2 decimal places)
                balance *= 100;
                balance = Math.round(balance);
                balance /= 100.0;
            }
        });
        
        // Cost label
        cost = new JLabel(String.format("(%d)  %.2f", upgrade.getQuantity(), upgrade.getCost()));
        cost.setFont(display);
        cost.setBounds(84, 32, 240, 25);
        
        revL = new JLabel(String.format("+$%.2f/sec", upgrade.getBaseRev()));
        revL.setFont(rev);
        revL.setBounds(4, 60, 240, 25);
        // Add to panel
        
        p.add(buyButton);
        p.add(nameL);
        p.add(cost);
        p.add(revL);
        return p;        
    }
}


class MyPanel extends JPanel { // create custom panel constructor to draw a rectangle to contain the upgrade
    void drawRectangles(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        
        g2d.setStroke(new BasicStroke(2));
        g2d.drawRect(1, 1, 300, 86);
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        drawRectangles(g);
    }
}