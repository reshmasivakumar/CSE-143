import java.util.ArrayList;
/*
 * 
 * MountainCave.java
 *   This class is built for this exercise only, and has some serious
 *   flaws "by design" just so we could traverse the tree directly from our WumpusHunter code
 *   For a better design, we would have separate classes for the tree and internal nodes  
 *   (rather than packing them together here), and we'd never return private aliases for our nodes
 *   And the list goes on...
 * 
 */

/**
 * MountainCave.java -  MountainCave class that represents the rooms in the Wumpus Mountain
 * 
 * Description:  This class represents a Mountain Cave room which is a node in the tree. The node has
 *                parent, name, message and additional properties representing if it is closer to the 
 *                golden scales or has the golden scales. 
 *                
 * @author Reshma Sivakumar  
 * @version  1.0 3/13/2016
 *              
 */

public class MountainCave {
    //node structure pointers
    //parent node which can the root or intermediate node
    private MountainCave parent = null;
    //to store the children of the node
    private ArrayList<MountainCave> children = new ArrayList<MountainCave>();
    //end node
    
    //MountainCave data items
    //message associated with each node/room
    private String caveMessage = null;
    //name of each node/room
    private String caveName = null;
    
    //if node has goldenscales node as child
    private boolean isAdjacentToScales=false;
    //if goldenscales room
    private boolean hasWumpusScales=false;
    //end MountainCave
    
    /**
    * Method :          setParent
    * Purpose :         Set method to set the parent of the MountainCave node
    * 
    * @param            theParent - MountainCave object which represents the parent.
    * @preconditions    None.
    * @postconditions   None.
    * @returns          None.
    */    
    public void setParent(MountainCave theParent) {
        parent = theParent;
        parent.addChild(this);
    }

    /**
    * Method :          getParent
    * Purpose :         Returns the parent of the MountainCave node on which it is called
    * 
    * @param            None.
    * @preconditions    None.
    * @postconditions   None.
    * @returns          MountainCave node that represents the parent of this  node on which it is called.
    */    

    public MountainCave getParent() {
        return parent;
    }

    /**
    * Method :          hasParent
    * Purpose :         Returns if the node on which this is called has parent or not. if no parent then it
    *                   will be root node.
    * 
    * @param            None.
    * @preconditions    None.
    * @postconditions   None.
    * @returns          Boolean value representing
    *                   true- if node has parent (not a root node)
    *                   false - if node has no parent ie its the root node
    */  
    public boolean hasParent() {
        //return (parent == null);
        
        if(parent == null) {
            return false;
        }
        return true;
    }
    
    /**
    * Method :          getCaveName
    * Purpose :         Returns the CaveName associated with this node.
    * 
    * @param            None.
    * @preconditions    None.
    * @postconditions   None.
    * @returns          String value representing the cave name of this node.
    *                    
    */      
    public String getCaveName() {
        return caveName;
    }

    /**
    * Method :          getChildren
    * Purpose :         Returns the children nodes  associated with this node.
    * 
    * @param            None.
    * @preconditions    None.
    * @postconditions   None.
    * @returns          ArrayList  representing the children nodes  associated with this node.
    *                    
    */      
    public ArrayList getChildren() {
        return children;
    }

    /**
    * Method :          addChild
    * Purpose :         Adds the given MountainCave node as child to this node
    * 
    * @param            next - MountainCave node as child to this node.
    * @preconditions    None.
    * @postconditions   None.
    * @returns          None.
    *                    
    */  
    public void addChild(MountainCave next) {
        if( next != null ) {
            children.add(next);
        }
    }

    /**
    * Method :          getCaveMessage
    * Purpose :         Returns the Cave Message associated with this node.
    * 
    * @param            None.
    * @preconditions    None.
    * @postconditions   None.
    * @returns          String value that represents Cave Message associated with this node. .
    *                    
    */  
    public String getCaveMessage() {
        return caveMessage;
    }

    /**
    * Method :          setCaveMessage
    * Purpose :         Sets the Cave Message associated with this node.
    * 
    * @param            caveName- Cave Message associated with this node..
    * @preconditions    None.
    * @postconditions   None.
    * @returns          None. .
    *                    
    */ 
    public void setCaveMessage(String caveName) {
        this.caveName = caveName;
    }
    
    /**
    * Method :          hasScales
    * Purpose :         Returns if the node is the golden scales
    * 
    * @param            None.
    * @preconditions    None.
    * @postconditions   None.
    * @returns          boolean value 
    *                   true - if this node has golden scales
    *                   false - otherwise.
    *                    
    */ 
    public boolean hasScales() {
        return hasWumpusScales;
    }

    /**
    * Method :          setHasScales
    * Purpose :         Sets the node as the golden scales
    * 
    * @param            hasWumpusScales - boolean value representing golden scales node.
    * @preconditions    None.
    * @postconditions   None.
    * @returns          None.
    *                    
    */ 

    public void setHasScales(boolean hasWumpusScales) {
        this.hasWumpusScales = hasWumpusScales;
    }

    /**
    * Method :          isAdjacentToScales
    * Purpose :         Returns if the node is adjacent to the golden scales
    * 
    * @param            None.
    * @preconditions    None.
    * @postconditions   None.
    * @returns          boolean value
    *                   true - if the node is adjacent to the golden scales
    *                   false- otherwise.
    *                    
    */ 


    public boolean isAdjacentToScales() {
        return isAdjacentToScales;
    }

    /**
    * Method :          setAdjacentToScales
    * Purpose :         Sets the node as adjacent to the golden scales
    * 
    * @param            adjacentToScales - boolean value representing if
    *                   the node is near to the golden scales.
    * @preconditions    None.
    * @postconditions   None.
    * @returns          boolean value
    *                   None.
    *                    
    */ 
    public void setAdjacentToScales(boolean adjacentToScales) {
        this.isAdjacentToScales = adjacentToScales;
    }
    
    /**
    * Method :          Overloaded Constructor
    * Purpose :         Creates a MountainCave node with name and no message and parent.
    * 
    * @param            name - name of the MountainCave node.
    * @preconditions    None.
    * @postconditions   A new MountainCave node with name and no message and parent is created.
    *                    
    */ 

    public MountainCave(String name){
        this(name,null);
    }   

    /**
    * Method :          Overloaded Constructor
    * Purpose :         Creates a MountainCave node with name and  message and parent.
    * 
    * @param            theParent - MountainCave object that will be set as parent 
    *                   name - name of the MountainCave node to the new node.
    *                   message - message of the MountainCave node
    * @preconditions    None.
    * @postconditions   A new MountainCave node with given name and  message and parent is created.
    *                    
    */ 
    public MountainCave(MountainCave theParent, String name, String message) {
        this(name, message);
        if( theParent != null) {
            parent = theParent;
            parent.addChild(this);
        }
    }
    /**
    * Method :          Overloaded Constructor 
    * Purpose :         Creates a MountainCave node with name and  message .
    * 
    * @param            name - name of the MountainCave node to the new node.
    *                   message - message of the MountainCave node
    * @preconditions    None.
    * @postconditions   A new MountainCave node with given name and  message is created.
    *                    
    */     
    public MountainCave(String name, String message) {
        caveName = name;
        caveMessage = message;
    }

}