/**
 * WumpusHunter.java - Abstract Super class that will be subclassed.
 * 
 * Description: This abstract class describes the two methods that you'll need to provide in your
 *   subclass - getName() and startAt().  Note that getName should be one line of code, 
 *   and that all of your functionality for traversing the mountain should go in the
 *   startAt()function, which is where 98% of your code will go for this project.
 * 
 *  In your subclass, when you visit caves, add this to the actionLog string, which
 *   your subclass will have direct access to.  Then, when your hunter is done exploring
 *   you can see the list of places he/she has been, and also you can embed the solution 
 *   in the actionLog if you like.
 *              
 */

public abstract class WumpusHunter {
    
    //use this to build a string of where your hunter has been
    protected String actionLog = "\n";
    
    
    /**
    * Method :          getName
    * Purpose :         Abstract method that would be overriden to return the name 
    *                   of the WumpusHunter Sub Class
    * 
    * @param            None.
    * @preconditions    None.
    * @postconditions   None.
    * @returns          String value that represents the name of the WumpusHunter subclass
    */
    
    public abstract String getName();
    
    /**
    * Method :          startAt
    * Purpose :         Abstract method that would be overriden to navigate the Mountain Cave (tree)
    *                   to search the golden Wumpus scales left behind by all baby Wumpus hatchlings.
    *                   There is no risk of death and no shooting arrows in this version of the Wumpus World.
    * 
    * @param            root - MountainCave object that represents the top node of the tree.
    * @preconditions    None.
    * @postconditions   None.
    * @returns          String value that represents the name of the WumpusHunter subclass
    */
    public abstract void startAt(MountainCave root); 

    
    /**
    * Method :          report
    * Purpose :         Reports the path the Wumpus Hunter navigates to reach the golden scales. 
    * 
    * @param            None.
    * @preconditions    None.
    * @postconditions   None.
    * @returns          String value that represents the path the Wumpus Hunter navigates to reach
    *                   the golden scales.
    */    
    public String report() {
        
        return actionLog;
    }

}