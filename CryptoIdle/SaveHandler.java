

import java.io.*;


public class SaveHandler{
    
    
    private long timeInSeconds;
    private Upgrade upgrades[];
    private double balance;
    private File save = new File("save.txt");
    
    
    public SaveHandler(Upgrade upgrades[], double balance){
       this.upgrades = upgrades;
       timeInSeconds = System.currentTimeMillis();
    }
    
    public SaveHandler() throws IOException{
        BufferedReader input = new BufferedReader(new FileReader(save));
        
    }
    
    
}