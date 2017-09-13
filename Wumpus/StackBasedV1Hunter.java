import java.util.ArrayList;

/**
 * StackBasedV1Hunter.java - WumpusHunter subclass.
 * 
 * Description:  This subclass extends WumpusHunter abstract superclass and represents a Wumpus Hunter. 
 *               The goal of this subclass is  to traverse a Tree in search of the Golden Scales 
 *               and report the  path from the root of the tree to the golden scales.
 *               A Wumpus Hunter may walk to any room (a node) in our Mountain (a Tree) and look for gold, 
 *               as well as smell for a nearby Wumpus and therefore this Wumpus Hunter class will report 
 *               when it is closer to the scales and when it finds the scales.
 *               This subclass will traverse a Binary or a Tertiary tree using Depth First Algorithm (DFS)
 *               using Stack data structure.
 *               stack.push(root)
 *               
 *               Start with root node
 *               push root node to stack
 *               while !stack.isEmpty() do
 *               node = stack.pop()
 *               check if node has scales
 *                  report found and print path
 *                  return
 *               for each node.children do
 *               stack.push(children)
 *               endfor
 *               endwhile
 *               
 * 
 *   
 * @author Reshma Sivakumar  
 * @version  1.0 3/13/2016
 *              
 */

public class StackBasedV1Hunter extends WumpusHunter
{
    
    /**
    * Method :          getName
    * Purpose :         Overriden method that would return the name 
    *                   of this WumpusHunter Sub Class
    * 
    * @param            None.
    * @preconditions    None.
    * @postconditions   None.
    * @returns          String value that represents the name of this WumpusHunter subclass
    */

    @Override
    public  String getName()
    {
        
        return this.getClass().getName();
    }
    
    
    /**
    * Method :          startAt
    * Purpose :         Overridden method that will navigate the Mountain Cave (tree)
    *                   to search the golden Wumpus scales left behind by all baby Wumpus hatchlings.
    *                   There is no risk of death and no shooting arrows in this version of the Wumpus World.
    *                   The Mountain Cave can navigate a Binary or Tertiary Tree using Depth First Algortihm 
    *                   and records the path that Wumpus Hunter traverses (tree nodes) to get to the scales.
    *                   The Stack datastructure is used to navigate the tree.
    * 
    * @param            root - MountainCave object that represents the top node of the tree.
    * @preconditions    None.
    * @postconditions   None.
    * @returns          String value that represents the name of the WumpusHunter subclass
    */    
    @Override
    public  void startAt(MountainCave root) 
    {
      MountainCave node;
           
    try
    {
         //check if invalid root passed
         if( root  == null ) {
            throw new NullPointerException ("Root node is null");
        }
        
        if (root.hasScales()) //root node itself contains golden scales
        {  
            actionLog +=  "We've found the scales!\n";
            actionLog += "\n";
            actionLog += "....The path is ....\n";
            actionLog += "Entering the" +root.getCaveName() + "\n";
            return;
        }
        //Stack datastructure variable to navigate tree.
        Stack stack = new Stack();
        // Stack variable to store the actual path to the golden scales
        Stack path = new Stack();
        //push root node to start search
        stack.push(root);
        node =root;
       
        //navigate tree till all nodes are searched 
         while(!stack.isEmpty())
         {
             //enter the room (tree node)
             node = (MountainCave)stack.pop();
             //record the room entered
             actionLog += "Entering the" +node.getCaveName() + "\n";
             //Smell to see if the scales are closer
             if (node.isAdjacentToScales())
             {
                 //if so record 
                 actionLog += "We've neared the scales!\n";
            }
            //check if hunter reached golden scales. 
            else if (node.hasScales())
            {
         
                 actionLog +=  "We've found the scales!\n";
                 actionLog += "\n";
                 actionLog += "....The path is ....\n";
                  
                 //navigate the tree backwards to the parent to store the
                 //actual path from the root to the golden scales
                 //currently node represents the golden scales leafnode at 
                 //this point
                 while (!(node.getCaveName().equals(root.getCaveName())))
                 {
                     //push the node to path stack
                     path.push("and then visit the "+ node.getCaveName());
                     //traverse backwards
                     node = node.getParent();
                     
                 }
                 //get the root node
                 path.push("Start at the "+node.getCaveName() );
                  
                 //Record the actual path by pooping the stack
                 while (!(path.isEmpty()))
                 {
                   actionLog += path.pop() + "\n" ;
                 }
               
              return;
            } 
           
           //Get the children of the current node
           ArrayList<MountainCave> children = node.getChildren();
           
           //push the children to stack to navigate
           for (int i = 0; i < children.size();  i++)
           {
               stack.push(children.get(i));
               
           }    
        }
    }catch (LinkedListException le)
    {
        System.out.println("Wumpus Hunter Exception"+le.getMessage());
    }
    
}
     
}


   

