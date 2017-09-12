import java.util.*;
/**
 * Write a description of class Stack here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public  class   LLStack 
{
    private Node head;
    
    
      /**
    * Method :          size
    * Purpose :         Return the current length of the Nodes
    *                   in this List.
      */          
    /*public int size ()
    {
        int sizeCount = 0;
        
        //if not empty, traverse List to count all Nodes
        if (! (isEmpty()) )
        { 
            //start from head
            Node current = head;
            // traverse till last node in link
            while ( current != null )
            {
                sizeCount++;
                //set current to next node
                current = current.next;
            }
            
        }
        //if empty, size is 0, else returns number of links in node
        return sizeCount;
    }
    */
    /**
    * Method :          isEmpty
    * Purpose :         To check if List is empty.
    * 
    */        
    public boolean isEmpty ()
    {
        if ( this.head == null )
            return true;
        else
            return false;
    }
    
    
   /*  public String toString() {
        String retVal = "";
        Node current = head;
        while(current != null) {
            retVal += current.data.toString() + " ";
            current = current.next;
        }
        return retVal;
    } */

    public void push ( Object data ) 
   {
             Node newNode;
        //Check if empty. If true, create newNode and make it as head node
        if ( isEmpty () )
        {
  
            head = new Node (data, head);
        }
  
        else 
        {
                //insert at head
                newNode = new Node ( data, null );
                newNode.next = head;
                head = newNode;
 
        }
  
   }

     /**
    * Method :          pop
    * Purpose :         This method is called to pop an Object from  
    *                   the Stack. The method calls the remove method
    *                   of the List super class.   Stack top is assumed
    *                   to be at the end position of the list.

    */         
    public Object pop () 
   {
         Object retVal = null;
        
        if ( isEmpty() )
            throw new RuntimeException ("Exception: List is empty");
        
 
        if ( size() == 1 )
        {
            retVal = this.head.data;
            this.head = null;
        }
        else
        {
        
                retVal = this.head.data;
                head  = head.next;
            
   
            
        }
        return retVal;
   }

    /**
    * Class :           Node
    * @Description :    This private Node class holds an object item and
    *                   a reference link. This List is composed of one or
    *                   more Node elements.
    * 
    * 
    */
    private class Node 
    {
        private Object data;
        private Node next;
    
        
        /**
        * Method :          Constructor
        * Purpose :         Constructs a Node object with item and 
        *                   link set to specified item and link.
        * 
          */      
       public Node ( Object item, Node link )
       {
       
           this.data = item;
           this.next = link;
       }
       
    }
    
    
    // RECURSIVE toString
    public String toString()
    {
        return toString ( head );
    }
    
    public String toString ( Node node )
    {
        if ( node == null )
            return "";
        return node.data + " " + toString ( node.next);
    }
    
    public int size()
    {
        return size ( this.head );
    }
    
    public int size ( Node node )
    {
        if ( node == null )
            return 0;
        return 1 + size ( node.next );
    }
    
        public static void main(String[] args) {
            //Stack<Character> a = new Stack<Character>();
            LLStack a = new LLStack();
            a.push('R');
            a.push('a');
            a.push('c');
            a.push('e');
            //a.push('c');
            //a.push('a');
            a.push('r');
            System.out.println("Size : " + a.size());
            while(!a.isEmpty()) {
                System.out.println(a.pop());
            }
        }

}
