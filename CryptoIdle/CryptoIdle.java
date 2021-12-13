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
        // Variables for loading in from save file
        Upgrade[] upgdArr = new Upgrade[6];
        double balance = 0;
        
        // Load save
        try{
            SaveHandler load = new SaveHandler();
            upgdArr = load.getUpgrades();
            balance = load.getBalance();
        }
        catch (IOException e){
            // Default load values
            balance = 1000;
            upgdArr[0] = new Upgrade(1.07, 10, 1, 0, "Mediocre Mining Rig");
            upgdArr[1] = new Upgrade(1.07, 200, 5, 0, "Basic Mining Rig");
            upgdArr[2] = new Upgrade(1.07, 5000, 25, 0, "Advanced Mining Rig");
            upgdArr[3] = new Upgrade(1.07, 50000, 100, 0, "Mining Apartment");
            upgdArr[4] = new Upgrade(1.07, 100000, 250, 0, "Mining Facility");
            upgdArr[5] = new Upgrade(1.07, 500000, 1000, 0, "Mining Warehouse");
        }
        catch (NumberFormatException e){
            // Error in save file
            System.out.printf("Error! Save file corrupted! Please check your save file for correct formatting.\nDeleting the save file will generate a new one for you.\n");
            e.printStackTrace();
        }
        
        // Takes loaded in values and displays in UI
        UIElements a = new UIElements(upgdArr, balance);
    }
}
