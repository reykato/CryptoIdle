

import java.io.*;
import java.util.*;


public class SaveHandler{
    private final int TOTAL_TERMS = 8;
    
    private long timeInMillis;
    private Upgrade upgrades[] = new Upgrade[(TOTAL_TERMS-2)];
    private double balance;
    private File save = new File("save.txt");
    
    
    public SaveHandler(Upgrade upgrades[], double balance){
       this.upgrades = upgrades;
    }
    
    public SaveHandler() throws IOException, NumberFormatException{
        BufferedReader input = new BufferedReader(new FileReader(save));
        String terms[] = new String[TOTAL_TERMS];
        for (int i = 0; i < TOTAL_TERMS; i++){
           terms[i] = input.readLine(); 
        }
        timeInMillis = Long.parseLong(terms[0]);
        balance = Double.parseDouble(terms[1]);
        for (int i = 2; i < TOTAL_TERMS; i++){
            upgrades[i-2] = parseUpgrade(terms[i]);
        }
    }
    
    
    private Upgrade parseUpgrade(String saveFormat){
        double mult, basePrice, revenue;
        int amtOwned;
        String name;
        String numbers[] = saveFormat.split(",");
        
        mult = Double.parseDouble(numbers[0]);
        basePrice = Double.parseDouble(numbers[1]);
        revenue = Double.parseDouble(numbers[2]);
        amtOwned = (int)Double.parseDouble(numbers[3]);
        name = numbers[4];
        return new Upgrade(mult, basePrice, revenue, amtOwned, name);
    }
    
    
    
    public double getBalance(){
        return balance;
    }
    
    public long getTimeStamp(){
        return timeInMillis;
    }
    
    public Upgrade[] getUpgrades(){
        return upgrades;
    }
}