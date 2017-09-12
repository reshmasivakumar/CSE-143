import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/*
 * MorseTree.java
 * CSS 162 Binary Search Tree Lab
 * Author: Rob Nash
 * 
 * This class reads in data from a text file ("data.txt") and populates a binary tree with an 
 * ordering constraint.  See the lab readme for more information, but in general, dots go right 
 * and dashes go left when constructing or traversing a morse code tree.  Search for //TODO
 * in the code to see what code you have to implement.
 * 
 * Start with the C'Tor and read each line in from the textfile first, calling add() for each 
 * {letter,morseCodeStr} pair.
 * 
 */

public class MorseTree {
    //TODO: data member called "root" goes here
     private TreeNode root;
     private int size;
    //TODO: Complete constructor
    public MorseTree() {
        //open data.txt, add each line to the tree
        Scanner fin;
        try 
        {
             //for each line in the file, 
             //  get the letter(char) and the morse string
             //  call add() with this data
             //  print out the letter and morse string here for debugging
             fin = new Scanner(new File ("data.txt"));
             while ( fin.hasNext() )
             {
                 
                 char letter = fin. next().charAt(0);
                 String morse = fin.nextLine ().trim();
                // System.out.println("Calling add with morse: " + morse + " letter: " + letter );
                 add (morse, letter);
                 //System.out.println ("Letter: " + letter + " Morse: " + morse );
             }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public void add(String morseStr, char letter) {
        root = insertInSubtree(morseStr, letter, root);
    }
     
    //TODO: recursively complete this function.  It's only a few characters different from findInSubtree()
    private TreeNode<Character> insertInSubtree(String morseStr, Character letter, TreeNode subtree) {
        //base case 1 : subtree is null
        //base case 2 : morseStr is of length 0
        //recursive case 1: the first char in morseStr is a '.', so recursively traverse tree
        //recursive case 2: the first char in the morseStr is a '-', so recurse accordingly
        if ( subtree == null )
        {
          
            return new TreeNode<Character>(letter, null, null);
        }
        if ( morseStr.length() == 0 )
        {
           
          return new TreeNode<Character>(letter , null, null);
        }
        else if (morseStr.charAt(0) == '.')
        {
       
            subtree.rightLink = insertInSubtree(morseStr.substring(1,morseStr.length())  , letter, subtree.rightLink)  ;
         
             return subtree;
        }     
        else if (morseStr.charAt(0) == '-')
        {
           
               //System.out.println("here3 "+ letter);
               
             subtree.leftLink = insertInSubtree(morseStr.substring(1,morseStr.length()) , letter, subtree.leftLink);
           return subtree;
            
        }
        return subtree;  //always the last line, always return the node you are working on
    }
    
    public Character translate(String morseStr) {
        return findInSubtree(morseStr, root);
    }
    
    //TODO: recursively comlpete this function.  Very similar to insertInSubtree()
    private Character findInSubtree(String morseStr, TreeNode subtree) {
        Character retVal = ' ';
        if ( subtree == null )
        {
             return '#'; 
        }
        //base case 2 : morseStr is of length 0
        //recursive case 1: the first char in morseStr is a '.', so recursively traverse tree
        //recursive case 2: the first char in the morseStr is a '-', so recurse accordingly
        else if ( morseStr.length() == 0   )
        {
            
            return (Character)(subtree.data) ;
        }
        else if (morseStr.charAt(0) == '.' )
        {
            
              return findInSubtree(morseStr.substring(1), subtree.rightLink);
        }
        else if (morseStr.charAt(0) == '-')
        {
            
               return  findInSubtree(morseStr.substring(1),  subtree.leftLink);
        }
        return (Character) (subtree.data);
    }
    
    //TODO: Non-recursive function that calls other (recursive) functions
    public String translateString(String tokens) {
        String retVal = "";
        
        TreeNode current = root;
        //build a scanner here using tokens as input
        Scanner line = new Scanner (tokens);
        //iterate over the tokens calling translate on each token (substring separated by a space)
       while (line.hasNext())
            retVal += translate(line.next()) + " ";
        
        
            return retVal;
    }

 
    public String toMorseCode(Character c) {
        //SPOILER ALERT : Solving this problem also solves your wumpus homework, so
        //we *won't* be doing this in class.
        //walk the tree looking for the TreeNode with the char c in it
            //preorder walk?
            //inorder walk?
            //postorder walk?
           
        
        //when you've found the char c, report the path from the root to the node
        //and build the morse code by adding a "." when you go right, "-" when you go left
       return new String("You wish.");
    }
    
    public String toString() {
        return inorderWalk(root);
    }
    private String inorderWalk(TreeNode subtree) {  
        
        //SPOILER ALERT : Solving this problem also solves the problem of mountain printing in wumpus
       String retval = "";
       if (subtree != null)
        {
           
            retval += inorderWalk(subtree.leftLink);
             //System.out.println("here " + subtree.data);
           // System.out.println(subtree.data + " ");
            retval += subtree.data + " ";
             retval +=  inorderWalk(subtree.rightLink);
            

            
        }
       
        return retval;
        
    }
    
    
    
    public static void main(String[] args) {
        MorseTree mt = new MorseTree();  //builds our tree using data from a file
        System.out.println(mt.toString());
       System.out.println(mt.translate("..."));  //prints out S
       System.out.println(mt.translate("---"));  //prints out O
        System.out.println(mt.translate(".......-"));  //prints out null
        
       System.out.println(mt.translateString("... --- ..."));  //SOS
       // System.out.println(mt.toMorseCode('S'));  //find where we are in the tree, remember path to root
    }

    
    //TODO: Build the    private class TreeNode<TBA extends Comparable>  class below as practice for your final
    
    private class TreeNode<TBA extends Comparable> 
   {
       private Object data; 
       private TreeNode leftLink;
       private TreeNode rightLink;
       
       public TreeNode ( Object data, TreeNode left, TreeNode right)
       {
           if ( data == null )
           {
               throw new NullPointerException("Input cannot be null");
            }
           this.data = data;
           this.leftLink = left;
           this.rightLink = right;
       }
   }
}
