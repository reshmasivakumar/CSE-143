/*
 * MountainFactory
 *   This class provides a uniform way to obtain "mountains", which are really just
 *   trees (and the one function below returns the root of the tree)
 */

/**
 * MountainFactory.java -MountainFactory Superclass that will be extended to implement a MountainCave
 *                       tree that the Wumpus Hunter will navigate
 * 
 * Description: This abstract class provides a uniform way to obtain "mountains", which are really just
 *               trees (and the one function below returns the root of the tree). This class can
 *               be extended to implement a Binary or Tertiary Tree
 * 
 *   
 * @author Reshma Sivakumar  
 * @version  1.0 3/13/2016
 *              
 */
public abstract class MountainFactory {
    
    /**
    * Method :          getMountainTop 
    * Purpose :         Abstract class that will be implemented to return the root node of the 
    *                   tree(starting room of the MountainCave) 
    * 
    * @param            None.
    * @preconditions    None.
    * @postconditions   None.
    * @returns          MountainCave object that represents the root node of the subclass.
    */    

    public abstract MountainCave getMountainTop();
}