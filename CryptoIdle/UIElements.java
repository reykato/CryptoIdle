/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptoidle;

import java.awt.GridLayout;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.JPanel;
import java.awt.*;
import javax.swing.JLabel;
import java.awt.event.*;


public class UIElements extends JFrame {
    Upgrade[] upgdArr = new Upgrade[6];
    double balance;
    
    public UIElements(Upgrade[] upgdArr, double balance) {
        super();
        this.upgdArr = upgdArr;
        this.balance = balance;
        JFrame frame = new JFrame("test");
        frame.setSize(400, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new GridLayout(7,0));
        frame.setVisible(true);
        
        
        Font dispFont = new Font("Arial", Font.BOLD, 30);
        JLabel bal = new JLabel(Double.toString(this.balance));
        bal.setFont(dispFont);
        bal.setHorizontalAlignment(JLabel.CENTER);
        frame.add(bal);
        
        for (var upgrade : upgdArr) {
            frame.getContentPane().add(upgrade.drawUpgrade());
        }
        ActionListener taskPerformer = new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent e) {
                    repaint();
                    System.out.println("updated");
            }
        };
        new Timer(500, taskPerformer).start();
    }
        
    public Upgrade[] getUpgradeArray() {
        return upgdArr;
    }
}
