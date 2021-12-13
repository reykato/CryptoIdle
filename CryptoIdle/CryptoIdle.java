/*
Tyler Lindsay
Nicholas Saylor
Crypto Idle
2021-11-5
Main class 
 */

import java.awt.*;
import javax.swing.JFrame;

public class CryptoIdle {
    public static void main(String[] args) {
        double balance = 1000000;
        JFrame frame = new JFrame("test");
        frame.setSize(1000, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new GridLayout(5,5));
        frame.setVisible(true);
        // create new upgrade named
        Upgrade basicMiningRig = new Upgrade(1.07, 100, 5, 1, "Basic Mining Rig");
        
        frame.getContentPane().add(basicMiningRig.drawUpgrade());
        basicMiningRig.buy(balance, 10);
        basicMiningRig.drawUpgrade();
    }
}