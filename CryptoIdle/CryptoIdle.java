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
            System.out.printf("Successfully loaded save!\n");
        }
        catch (IOException e){
            // Default load values
            System.out.printf("No save found, creating new save.\n");
            balance = 1000;
            upgdArr[0] = new Upgrade(1.07, 10, 1, 0, "Mediocre Mining Rig");
            upgdArr[1] = new Upgrade(1.07, 180, 5, 0, "Basic Mining Rig");
            upgdArr[2] = new Upgrade(1.07, 2600, 15, 0, "Advanced Mining Rig");
            upgdArr[3] = new Upgrade(1.07, 19800, 50, 0, "Mining Apartment");
            upgdArr[4] = new Upgrade(1.07, 69000, 200, 0, "Mining Facility");
            upgdArr[5] = new Upgrade(1.07, 200000, 1000, 0, "Mining Warehouse");
        }
        catch (NumberFormatException e){
            // Error in save file
            System.out.printf("Error! Save file corrupted! Please check your save file for correct formatting.\nDeleting the save file will generate a new one for you.\n");
            e.printStackTrace();
        }
        
        
        
        // Takes loaded in values and displays in UI
        UIElements a = new UIElements(upgdArr, balance);
        
        // TODO: Add the following code to a window listener upon close
        try {
            SaveHandler save = new SaveHandler(upgdArr, balance);
            System.out.printf("Successfully implemented save\n");
        }
        catch (Exception e){
            System.out.printf("Error! Save file could not be created! Please make sure that folder is not read-only.\n");
        }
    }
}
