/*
Tyler Lindsay
Nicholas Saylor
Crypto Idle
2021-11-5
Main class 
 */

import java.awt.*;
import javax.swing.JFrame;
import java.io.*;
import java.util.*;

public class CryptoIdle {
    public static void main(String[] args) {
        Upgrade[] upgdArr = new Upgrade[6];
        double balance = 1000;
        try{
            SaveHandler load = new SaveHandler();
            upgdArr = load.getUpgrades();
            balance = load.getBalance();
        }
        catch (IOException e){
            upgdArr[0] = new Upgrade(1.07, 10, 1, 0, "Mediocre Mining Rig");
            upgdArr[1] = new Upgrade(1.07, 180, 5, 0, "Basic Mining Rig");
            upgdArr[2] = new Upgrade(1.07, 2600, 15, 0, "Advanced Mining Rig");
            upgdArr[3] = new Upgrade(1.07, 19800, 50, 0, "Mining Apartment");
            upgdArr[4] = new Upgrade(1.07, 69000, 200, 0, "Mining Facility");
            upgdArr[5] = new Upgrade(1.07, 200000, 1000, 0, "Mining Warehouse");
        }
        catch (NumberFormatException e){
            e.printStackTrace();
        }
        
        UIElements a = new UIElements(upgdArr, balance);
    }
}
