CryptoIdle by Nicholas Saylor, Tyler Lindsay, and Riggie Lin

Deliverables:
1. Source Code and Assets
2. Packaged .jar File
3. README File

The .jar file represents a production release of the game. It requires JRE 17 to run.
Running the file is as simple as double clicking the program or using the following command:
java -jar CryptoIdle.jar

This version does not include a save file and will generate a save file for you.
It is meant to represent a new player opening the game for the first time. Once the game is run and closed, it will save the game state.



The source code version shows the entirety of the game broken into source code. It can be compiled with javac normally.
Included is a save file that has seen normal progress. Upon opening the game, progress will be shown in a dialog window.
This version allows for viewing of source code and editting of the save files and assets.
All asset files are required for normal output. Omitting the font will default to a normal font. However, removing the icon is untested.
Removing the save file will simply make a new one.

HOW TO PLAY:
Use your money to purchase better equipment to mine cryptocurrency. The equipment will help you produce money faster
to buy better upgrades. Continue buying upgrades until you reach a number high enough to satisfy you.



IMPORTANT DISCLAIMER:
The save file requires a strict format.
This format is as follows:



UNIX Timestamp (stored as a long)
Balance (stores as a double)
Upgrade Data (cost multiplier (double),current cost (double),revenue (double), amount owned (integer),name (string))



Only the first 6 upgrades will be read into the game, and any further upgrades will be lost after closing the game
However, the game can easily be scaled up to include more upgrades

An example save file would include:

1639529633376                              (UNIX Timestamp)
100.00                                     (Balance)
1.07,10.00,1.00,0,Mediocre Mining Rig      (Upgrade 1)
1.07,200.00,5.50,0,Basic Mining Rig        (Upgrade 2)
1.07,1000.00,25.65,0,Advanced Mining Rig   (Upgrade 3)
1.07,10000.00,67.70,0,Mining Apartment     (Upgrade 4)
1.07,50000.00,207.85,0,Mining Facility     (Upgrade 5)
1.07,200000.00,769.95,0,Mining Warehouse   (Upgrade 6)