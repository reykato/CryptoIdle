import java.io.*;
import java.util.*;


public class SaveHandler{
    // Change this to be equal to the number of upgrades + 2 (time and balance)
    private final int TOTAL_TERMS = 8;
    // For calculating offline progress
    private long timeInMillis;
    private double balance;
    // Array of upgrades
    private Upgrade upgrades[] = new Upgrade[(TOTAL_TERMS-2)];
    // Standard save file
    private File save = new File("save.txt");
    
    // Save functionality
    public SaveHandler(Upgrade upgrades[], double balance) throws FileNotFoundException{
       this.upgrades = upgrades;
       this.balance = balance;
       PrintWriter output = new PrintWriter(save);
       output.printf("%d\n", System.currentTimeMillis());
       output.printf("%.2f\n", balance);
       for (Upgrade item : upgrades){
           output.printf("%s\n", item);
       }
       System.out.printf("Successfully saved file!\n");
       output.close();
    }
    
    // Load functionality
    public SaveHandler() throws IOException, NumberFormatException{
        // Reader for save file
        BufferedReader input = new BufferedReader(new FileReader(save));
        // For chunking data into lines
        String terms[] = new String[TOTAL_TERMS];
        // Reach each line into an array
        for (int i = 0; i < TOTAL_TERMS; i++){
           terms[i] = input.readLine(); 
        }
        // Parse timestamp
        timeInMillis = Long.parseLong(terms[0]);
        // Parse balance
        balance = Double.parseDouble(terms[1]);
        // Parse upgrades
        for (int i = 2; i < TOTAL_TERMS; i++){
            upgrades[i-2] = parseUpgrade(terms[i]);
            System.out.printf("Upgrade %d: %s\n", (i-2), upgrades[i-2]);
        }
    }
    
    
    private Upgrade parseUpgrade(String saveFormat){
        // Variables for each upgrade
        double mult, price, revenue;
        int amtOwned;
        String name;
        // Save file attributes are delimited by a comma
        String numbers[] = saveFormat.split(",");
        // Parse upgrade attributes
        mult = Double.parseDouble(numbers[0]);
        price = Double.parseDouble(numbers[1]);
        revenue = Double.parseDouble(numbers[2]);
        amtOwned = (int)Double.parseDouble(numbers[3]);
        name = numbers[4];
        // Return the upgrade represented by this string
        return new Upgrade(mult, price, revenue, amtOwned, name);
    }
    
    
    // Get methods for loading into UI
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