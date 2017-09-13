/*
 * MyCaveMoutainFactory
 *  Offers a small tree with 0-2 children per node.
 *  This should be where you start testing your WumpusHunter solution
 * 
 */
/**
 * MyCaveMoutainFactory.java - MyCaveMoutainFactory class that extends MountainFactory
 * 
 * Description:  This MountainFactory subclass that represents MountainCave rooms which is represented
 *               as Binary tree (0-2 children per node). The WumpusHunter subclass will navigate this 
 *               tree class.
 * 
 *   
 * @author Reshma Sivakumar  
 * @version  1.0 3/13/2016
 *              
 */

public class MyCaveMoutainFactory extends MountainFactory {


    /**
    * Method :          getMountainTop 
    * Purpose :         Returns the root node of the tree(starting room of the MountainCave) 
    * 
    * @param            None.
    * @preconditions    None.
    * @postconditions   None.
    * @returns          MountainCave object that represents the root node of the tree.
    */    
    
    public  MountainCave getMountainTop() {
        return getSmallStaticMountainTop();
    }
    
    /**
    * Method :          getSmallStaticMountainTop 
    * Purpose :         This method is where the Wumpus MountainCave is constructed as a Binary Tree.
    * 
    * @param            None.
    * @preconditions    None.
    * @postconditions   None.
    * @returns          MountainCave object that represents the root node of the tree.
    */        
    
    //top is the "root" of the tree, in this case
    public  MountainCave getSmallStaticMountainTop() {
        MountainCave root = new MountainCave("Mountain Top","The air density here seems to indicate you're not far from the base of the mountain");
        MountainCave r1 = new MountainCave( root,"Spider Cove", "This cave has huge rocks covered in spiders");      
        MountainCave l1 = new MountainCave( root,"Crooked Way", "This small passage makes it difficult to see ahead");      
        MountainCave l11 = new MountainCave( l1,"Fox Den", "This narrow passage is on the path of the fox den");
        MountainCave l12 = new MountainCave( l1,"Sword Room", "It would seem swords waiting to drop");  //leaf    
        MountainCave r11 = new MountainCave(r1,"Dragon's Alley", "This cave has huge dragon's");  //leaf      
        MountainCave l111 = new MountainCave(l11, "Craggy Cliff", "This small passage makes it difficult to see ahead");    //leaf 
        MountainCave l112 = new MountainCave(l11,"Thief's Pass", "This cave has thieves hiding");        
        
        MountainCave l1111 = new MountainCave( l112,"Treasure Room", "The golden scales are here!"); //leaf
        //set the adjacent node indicator
        l112.setAdjacentToScales(true);
        //set the node that has golden scales
        l1111.setHasScales(true);
        
        return root;
        
    }
    

}