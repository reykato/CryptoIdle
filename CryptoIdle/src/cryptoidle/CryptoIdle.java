/*
Tyler Lindsay
Nicholas Saylor
Crypto Idle
2021-11-5
Main class 
 */
package cryptoidle;
import javax.swing.JFrame;

public class CryptoIdle {
    public static void main(String[] args) {
        JFrame frame = new JFrame("test");
        frame.setSize(1000, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        // create new upgrade named
        Upgrade basicMiningRig = new Upgrade(1.07, 100, 5, 0, "Basic Mining Rig");
        
        frame.getContentPane().add(basicMiningRig.drawUpgrade());
        
        frame.setVisible(true);        
    }
}
