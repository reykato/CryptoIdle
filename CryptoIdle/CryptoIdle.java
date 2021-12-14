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
        double oldBalance = 0, balance = 0;
        boolean isNewSave = false;
        
        // Load save
        try{
            SaveHandler load = new SaveHandler();
            upgdArr = load.getUpgrades();
            oldBalance = load.getBalance();
            double offlineRevenue = 0;
            long currentTime = System.currentTimeMillis();
            for (Upgrade item : upgdArr) {
                offlineRevenue += (item.getRev() * (int)((currentTime - load.getTimeStamp()) / 1000.0));
            }
            balance = oldBalance;
            balance += offlineRevenue;
            System.out.printf("Successfully loaded save!\n");
        }
        catch (IOException e){
            // Default load values
            System.out.printf("No save found, creating new save.\n");
            isNewSave = true;
            balance = 10;
            upgdArr[0] = new Upgrade(1.07, 10, 1, 0, "Mediocre Mining Rig");
            upgdArr[1] = new Upgrade(1.07, 180, 5.50, 0, "Basic Mining Rig");
            upgdArr[2] = new Upgrade(1.07, 2600, 25.65, 0, "Advanced Mining Rig");
            upgdArr[3] = new Upgrade(1.07, 19800, 67.70, 0, "Mining Apartment");
            upgdArr[4] = new Upgrade(1.07, 69000, 207.85, 0, "Mining Facility");
            upgdArr[5] = new Upgrade(1.07, 200000, 769.95, 0, "Mining Warehouse");
        }
        catch (NumberFormatException e){
            // Error in save file
            System.out.printf("Error! Save file corrupted! Please check your save file for correct formatting.\nDeleting the save file will generate a new one for you.\n");
            e.printStackTrace();
        }        
        
        // Takes loaded in values and displays in UI
        UIElements a = new UIElements(upgdArr, oldBalance, balance, isNewSave);
    }
}
