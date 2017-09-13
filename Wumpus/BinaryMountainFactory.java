/*
 * BinaryMoutainFactory
 *  Offers a small tree with 0-2 children per node.
 *  This should be where you start testing your WumpusHunter solution
 * 
 */

/**
 * BinaryMoutainFactory.java - BinaryMoutainFactory class that extends MountainFactory
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

public class BinaryMountainFactory extends MountainFactory {


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
        MountainCave r1 = new MountainCave( root,"Clover Cove", "This cave has huge rocks covered in multi-leaf clovers");      //leaf
        MountainCave l1 = new MountainCave( root,"Crooked Way", "This small passage makes it difficult to see ahead");      
        MountainCave l1r = new MountainCave( l1,"Hidden Nook", "The ground can't be far from here");
        MountainCave l1l = new MountainCave( l1,"Snake Room", "It would seem snakes have inhabited this room in the past");     //leaf
        MountainCave l1r2l = new MountainCave( l1r,"Treasure Room", "The golden scales are here!"); //leaf
        
        //set the adjacent node indicator
        l1r.setAdjacentToScales(true);
        //set the node that has golden scales
        l1r2l.setHasScales(true);
        
        return root;
        
    }
    

}