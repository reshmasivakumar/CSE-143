
/*
 * WMDriver
 * 
 * This contains a few lines of code to start things off.  Once you have made a
 * WumpusHunter subclass by extending the WumpusHunter class, you'll need to 
 * change the (currently broken) line of code so that it creates an object of your new
 * class.  
 * 
 * The other interesting thing here is to change the MountainFactory from a Binary Tree
 * to a 3-nary (Tertiary) Tree by commenting out the BinaryMountainFactory line and uncommenting
 * the TertiaryMountainFactory line below.  Note too you can make your own Factories for this exercise!
 * 
 */


/**
 * WMDriver.java - WMDriver class to call the WumpusHunter.
 * 
 * Description:  This class is used to test the WumpusHunter subclass.
 *               This can use the Binary tree/ Tertiary Tree to navigate
 *               the MountainCaveFactory subclass. 
 * 
 *   
 * @author Reshma Sivakumar  
 * @version  1.0 3/13/2016
 *              
 */

public class WMDriver {
    
    /**
    * Method :          main method
    * Purpose :         Main method that used to test the Wumpus Hunter subclass
    *                   using subclass of MountainCaveFactory. 
    * 
    * @param            args - string args.
    * @preconditions    None.
    * @postconditions   None.
    * @returns          None.
    */    
    
    public static void main(String[] args) {
        /*
         * TODO1: Change the one line below to build one of your WumpusHunters
         */     
        WumpusHunter myHunter = new StackBasedV1Hunter();
    
        
        BinaryMountainFactory caveFactory = new BinaryMountainFactory();
        //TertiaryMountainFactory caveFactory = new TertiaryMountainFactory();
        //MyCaveMoutainFactory2 caveFactory = new MyCaveMoutainFactory2();  //only one method to do!
        
        //get the top of the mountain, which is the top of our tree
        MountainCave theBeginning = caveFactory.getMountainTop();
        
        //begin your algorithm by writing the function below for your hunter
        myHunter.startAt(theBeginning);
        
        javax.swing.JOptionPane.showMessageDialog( null, "Hunter's name: " + myHunter.getName() + "\nHunter's report: " + myHunter.report());
        
    }

    
    
    
}