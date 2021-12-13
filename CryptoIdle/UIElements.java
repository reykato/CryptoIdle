/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package cryptoidle;
import java.awt.GridLayout;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.JPanel;
import java.awt.*;
import javax.swing.JLabel;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.SwingUtilities;


public class UIElements extends JFrame {
    Upgrade[] upgdArr = new Upgrade[6];
    double balance;
    
    public UIElements(Upgrade[] upgdArr, double balance) {
        super();
        this.upgdArr = upgdArr;
        this.balance = balance;
        run();
    }
    
    public void run() {
        JFrame frame = new JFrame("test");
        frame.setSize(330, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new GridLayout(7,0));
        frame.setVisible(true);
        
        
        Font dispFont = new Font("Arial", Font.BOLD, 30);
        JLabel bal = new JLabel(Double.toString(this.balance));
        bal.setFont(dispFont);
        bal.setHorizontalAlignment(JLabel.CENTER);
        frame.add(bal);
        
        for (var upgrade : upgdArr) {
            frame.getContentPane().add(drawUpgrade(upgrade));
        }
        
        ActionListener taskPerformer = new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent e) {
                    JLabel bal = new JLabel(Double.toString(getBalance()));
                    Font dispFont = new Font("Arial", Font.BOLD, 30);
                    bal.setFont(dispFont);
                    bal.setHorizontalAlignment(JLabel.CENTER);
                    frame.getContentPane().removeAll();
                    frame.add(bal);
                    for (var upgrade : upgdArr) {
                        frame.getContentPane().add(drawUpgrade(upgrade));
                    }
                    frame.getContentPane().revalidate();
                    frame.getContentPane().repaint();
                    System.out.println("updated");
            }
        };
        new Timer(500, taskPerformer).start();
    }
    
    public double getBalance() {
        return balance;
    }
    
    public void setBalance(double in) {
        balance = in;
    }
        
    public Upgrade[] getUpgradeArray() {
        return upgdArr;
    }
    public JPanel drawUpgrade(Upgrade upgrade) {        
        Font f = new Font("Display", Font.BOLD, 20);
        MyPanel p = new MyPanel();
        p.setLayout(null);
        p.setSize(300, 80);
        JLabel nameL, revL, cost;
        JButton buyButton;
        
        // name label
        nameL = new JLabel(upgrade.getName());
        nameL.setFont(f);
        nameL.setBounds(84, 4, 240, 25);
        
        buyButton = new JButton("Buy");
        buyButton.setBounds(4, 4, 70, 56);
        buyButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                System.out.println("button pressed");
                
                balance -= upgrade.buy(balance);
                // Rounding hack (2 decimal places)
                balance *= 100;
                balance = Math.round(balance);
                balance /= 100.0;
                System.out.println(balance);
                System.out.println(upgrade.getCost());
            }
        });
        
        
        // i am unsure if revenue should be displayed
        /*
        revL = new JLabel(String.valueOf(revenue));
        revL.setHorizontalAlignment(SwingConstants.LEFT);
        revL.setFont(f);
        revL.setBounds(4, 34, 50, 25);
        */
        // cost label
        cost = new JLabel("(" + upgrade.getQuantity() +")  "+Double.toString(upgrade.getCost()));
        cost.setFont(f);
        cost.setBounds(84, 34, 240, 25);
        
        p.add(buyButton);
        p.add(nameL);
        //p.add(revL);
        p.add(cost);
        return p;        
    }

    public void calculateBalance() {
        //askjdflajskdlfs
    }
}


class MyPanel extends JPanel { // create custom panel constructor to draw a rectangle to contain the upgrade
    void drawRectangles(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        
        g2d.setStroke(new BasicStroke(2));
        g2d.drawRect(1, 1, 300, 60);
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        drawRectangles(g);
    }
}