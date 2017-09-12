    
    /* List.java: Class implementating a List.
    *
    * @Description : This class is generic implementation of a List3 of Objects.
    *                The List3 is represented as a series of Node class which are
    *                linked to one another in a linear fashion. The Node class 
    *                is implemented as  private inner class in this List3 class. 
    *                This class provides the methods to generic List3 operations
    *                - Insert an Object at a specified index.
    *                - Append an Object to the List.
    *                - Remove and return the Object at a specified index.
    *                - Delete an return the Object at a specified index.
    *                - Return the current size of the List.
    *                - Return the string representation of the List3 elements.
    *                - Check if List3 is empty.
    *                - Returns the index of an Object in the List.
    *                - Check for equality of 2 List3 Objects.
    *                - Return the reference to the Object at the specified 
    *                   index.
    * 
    * Class Invariants:
    *              - Cannot specify negative index for insert or remove.
    *              - Cannot specify index beyond the size of the List.
    *              - Cannot remove from empty List.                 
    *                    
    * 
    * @author:     Reshma
    * @ version:   1 2/22/2016
    */
    
    
    public class List3 
    {
    
    /** Instance Variables **/
    
    private Node head;
    
    /**
    * Method :          Default Constructor
    * Purpose :         Constructs an empty List3 object with
    *                   head Node initialized to null.
    * 
    * @param            None.
    * @preconditions    None.
    * @postconditions   A new List3 object is created with
    *                   head Node initialized to null.
    */   
    
    public List3 ()
    {
        this.head = null;
    }
    
    /**
    * Method :          insert
    * Purpose :         To insert the specified object to the List
    *                   at the specified index. 
    * 
    * @param            obj - Object value.
    * @param            index - a postive integer value.
    * @preconditions    obj should be a valid Object.
    * @postconditions   A new Node will be created with the item as
    *                   its data. This Node will be added to this list
    *                   in the position specified by the index. 
    *                 
    * @returns          None.
    * @throws           LinkedListException 
    *                   - when a negative value passed as index.
    *                   - If index specified is greater than the size of 
    *                   the list.
    *                   
    */
    
    public void insert(Object item, int index) throws LinkedListException
    {
        Node newNode;
        //Check if empty. If true, create newNode and make it as head node
        if ( isEmpty () )
        {
            if ( index != 0 )
                throw new LinkedListException 
                ("Exception: List3 is Empty, specify index 0");
            head = new Node (item, head);
        }
        //Check if linked List3 has only one element
        else if ( size() == 1 ) 
        {
            //throw exception if index is not 0 or 1
            if ( index != 0 && index != 1 )
            {
                throw new LinkedListException 
                ("Exception: List3 has only one item, specify index 0 or 1");
            }
            // Check if insert is before head
            if ( index == 0 )
            {
                               
                newNode = new Node ( item, null );
                newNode.link = head;
                head = newNode;
            }
            //check if index is after head
            else if ( index == 1 )
            {
                newNode = new Node ( item, null );
                head.link = newNode;
            }
        }
        //insert into List3 with size > 1
        else
        { 
            // index is negative or index is greater than size
            if ( index < 0 || index > size () )
                throw new LinkedListException 
                ("Exception: Index out of bounds");
            
            // if index ==0 , then head needs to be adjusted to this new node
             if ( index == 0 )
            {          
                newNode = new Node ( item, null );
                newNode.link = head;
                head = newNode;
            }
    
            else
            {
                //if index is > 0 , navigate through the List3 till the position 
                //matching the index is reached in the List3 
                Node previous = head; // to point to the Node before the index
                Node current = head;  // to point to the Node at the index
                int counter = 0;
                for(int i = 0; i < index; i++){
                    //set previous to current node
                    previous = current;
                    //sets the current to reference the next node
                    current = current.link; 
                }
                // create new node and set the previous node to point to the
                // new node, new node to point to current.
                newNode = new Node (item, null);
                previous.link = newNode;
                newNode.link=current;
            }
            
        }
    }
    
    
    /**
    * Method :          append
    * Purpose :         To append the specified object to the end
    *                   of the list. 
    * 
    * @param            obj - Object value.
    * @preconditions    None.
    * @postconditions   A new Node will be created with the item as
    *                   its data. This Node will be added to the end 
    *                   of this list. 
    *                 
    * @returns          None.
    *                   
    */
    public void append ( Object item )  throws LinkedListException
    {
        Node newNode;
        
        // if List3 is empty, create new node and set this as head
        if ( isEmpty() )
        {
            head = new Node (item, head);
            //this.head = newNode;
        }
        //if only one element in list, create new node and set the head
        // to point to this new node
        else if ( size() == 1 )
        {
           newNode = new Node ( item, null );
           head.link = newNode;
        }
        // if size of List3 > 1
        else
        {
           
            Node current = head;
            // Traverse to get the last node
            while ( current.link != null )
            {
                current = current.link;
            }
            //add new node as last node. Set the previous
            //last node to point to new node.
            newNode = new Node ( item, null );
            current.link = newNode;
                 
        }
    }
    
    /**     
    * Method :          remove
    * Purpose :         Removes the Object at the specified index of
    *                   this List3 and returns the reference of that
    *                   Object as the return value.
    * 
    * @param            index - integer representing the position of
    *                   Object in the List.
    * @preconditions    List3 is not empty and index is non-negatove and
    *                   less that  size of list.
    * @postconditions   The Node at the specified index will be removed and
    *                   the links will be adjusted.
    * @returns          Returns the reference to the Object at the specified
    *                   index.
    * @throws           LinkedListException 
    *                   - when trying to remove from an empty List.
    *                   - index specified is negative.
    *                   - index is greater than the size of the List.
    */ 
    
    
  /*  public Object remove ( int index ) throws LinkedListException
    {
        Object retVal = null;
        
        if ( isEmpty() )
            throw new LinkedListException ("Exception: List3 is empty");
        
        if ( index < 0 || index >= size() )
            throw new LinkedListException
            ("Exception: List3 index out of bounds");
        
        if ( size() == 1 )
        {
            retVal = this.head.item;
            this.head = null;
        }
        else
        {
            Node current = head;
            Node previous = head;
        
            if ( index == 0 )
            {
                retVal = current.item;
                this.head = current.link;
            }
            else
            {
                int count = 0;
                while ( current != null )
                {
                    if ( count == index )
                    {
                        retVal = current.item;
                        previous.link = current.link;
                        break;
                    }
                    count++;
                    previous = current;
                    current = current.link;
                }
            }
        }
        return retVal;
    }
    */
 
   public Object remove ( int index ) throws LinkedListException
    {
        return removeR(head, head, index,0);
    }
     public Object removeR (Node previous, Node current,int index, int count ) throws LinkedListException
    {
        Object retVal = null;
         
        if ( isEmpty() )
            throw new LinkedListException ("Exception: List3 is empty");
        
        if ( index < 0 || index >= size() )
            throw new LinkedListException
            ("Exception: List3 index out of bounds");
        
        if ( size() == 1 )
        {
            retVal = this.head.item;
            this.head = null;
        }
        else if ( index == 0 )
        {
                retVal = current.item;
                this.head = current.link;
            }
        else if (count == index)
        {
            retVal = current.item;
            previous.link = current.link;
        }
    
        else
        {
            removeR(current, current.link, index, ++count);
           
        }
        return retVal;
    }
    /**     
    * Method :          delete
    * Purpose :         Removes the Object at the specified index of
    *                   this List3 and returns the reference of that
    *                   Object as the return value.
    * 
    * @param            index - integer representing the position of
    *                   Object in the List.
    * @preconditions    List3 is not empty and index is non-negatove and
    *                   less that  size of list.
    * @postconditions   The Node at the specified index will be removed and
    *                   the links will be adjusted.
    * @returns          Returns the reference to the Object at the specified
    *                   index.
    * @throws           LinkedListException 
    *                   - when trying to remove from an empty List.
    *                   - index specified is negative.
    *                   - index is greater than the size of the List.
    */ 
            
    public Object delete ( int index ) throws LinkedListException
    {
       return remove ( index );
    }
    
    /**
    * Method :          size
    * Purpose :         Return the current length of the Nodes
    *                   in this List.
    * 
    * @param            None.
    * @preconditions    None.
    * @postconditions   None.
    * @returns          int value representing current length of Nodes in
    *                   this List.
    */          
    public int size ()
    {
        int sizeCount = 0;
        
        //if not empty, traverse List3 to count all Nodes
        if (! (isEmpty()) )
        { 
            //start from head
            Node current = head;
            // traverse till last node in link
            while ( current != null )
            {
                sizeCount++;
                //set current to next node
                current = current.link;
            }
            
        }
        //if empty, size is 0, else returns number of links in node
        return sizeCount;
    }
    
    /**
    * Method :          indexOf
    * Purpose :         Return the index in the List3 where the current Object 
    *                   is stored.
    * 
    * @param            obj - reference to the Object to be searched.
    * @preconditions    List3 is not empty.
    * @postconditions   None.
    * @returns          int value representing position of the specified
    *                   Object in the List.
    * @throws           LinkedListException -  when List3 is empty.
    */          
    
    public int indexOf ( Object target ) throws LinkedListException
    {
        Node current = this.head;
        int count = 0;
        int retVal = -1;
        
        if ( isEmpty() )
            throw new LinkedListException ("Exception: List3 is Empty");
        
        while ( current != null )
        {
            //when indexof of null object
            if (current.item == null && target == null)
            {
                retVal = count;
                break;  
            }
            //check if current item equals target
            else if ( current.item != null && (current.item).equals ( target ))
            {
                retVal = count;
                break;
            }
            //increment and navigate to next node
            count ++;
            current = current.link;
        }
        
        // indexOf = -1 if not found, else retVal
        return retVal;
    }
    
    /**
    * Method :          isEmpty
    * Purpose :         To check if List3 is empty.
    * 
    * @param            None.
    * @preconditions    None
    * @postconditions   None.
    * @returns          true- if List3 is empty.
    *                   false- otherwise.
    */        
    public boolean isEmpty ()
    {
        if ( this.head == null )
            return true;
        else
            return false;
    }
    
    /**
    * Method :          toString
    * Purpose :         To return the String representation of the 
    *                   object represented by this List3 for printing.
    * 
    * @param            None.
    * @preconditions    None.
    * @postconditions   None.
    * @returns          String representation of all the
    *                   objects represented by this list.
    */         
    public String toString ()
    {
        String retVal = "[ ";
        if ( isEmpty() )
            retVal += "List3 is empty";
       else if ( size() == 1 )
        {
            retVal += head.item;
        }
        else 
        { 
            Node current = head;
            if (current == null)
            {
                retVal += current.item;
                
            }
            while ( current != null )
            {
                retVal += current.item + " ";
                current = current.link;
            }
        }
        retVal += " ]";
        
        return retVal;
    }
    
    
    public Node getHead ()
    {
        return this.head;
    }
    
    /**
    * Method :          equals
    * Purpose :         To compare if the input List3 object is equal to 
    *                   the internal List3 object
    * 
    * @param            that - another List3 object to be compared to.
    * @preconditions    None.
    * @postconditions   None.
    * @returns          true - if the input List3 object is equal
    *                   false - otherwise
    */
    public boolean equals ( Object  that )
    {
       List3 other = (List3) that;
       if ( this.getClass() != other.getClass() )
             return false;
       else if ( this.size() != other.size() )
            return false;
       else 
          return equalsR(this.head,other.head);
    }
    
    private boolean equalsR(Node current, Node other)
    {
        if ( other == null && current == null )
            return true;
         
        else if (other.item!=null && !(current.item).equals( other.item ))
            return false;    
        else
           return equalsR(current.link, other.link);
            
    }
    
    public static boolean equalsStr(String current, String other)
    {
        return equalsStrR( current, other );
    }
    
       private static boolean equalsStrR(String current, String other )
       {
           int idx=0;
     
        if ( other.length() == 0 && current.length() == 0 )
            return true;
         
        else if ((current.charAt(0))!=( other.charAt(0) ))
            return false;    
        else
        {
            ++idx; //goto next char
           return equalsStrR(current.substring(idx ,current.length()) ,other.substring(idx,other.length()) );
        }
            
    }
    
    public static  boolean isPalindrome(String input) {
        return  isPalindromeR ( input, 0, input.length() - 1);
    }
    
    private static boolean isPalindromeR (String input, int startIdx, int lastIdx)
    {
     
    if (lastIdx - startIdx <= 1)
        return true;
    
    //check if first and last is equals and recursively
    //check  from beginning and end decreasing index
    return (input.charAt(startIdx) == input.charAt(lastIdx)) &&
           isPalindromeR(input, startIdx + 1, lastIdx - 1);
}


   
   public static String reverseStringR(String str){
        String retVal = "";
        if(str.length() == 1){
            return str;
        } else {
            retVal += str.charAt(str.length()-1)
                    +reverseStringR(str.substring(0,str.length()-1));
            return retVal;
        }
    }
 
    
    /**
    * Class :           Node
    * @Description :    This private Node class holds an object item and
    *                   a reference link. This List3 is composed of one or
    *                   more Node elements.
    * 
    * 
    */
    private class Node 
    {
        private Object item;
        private Node link;
    
        /**
        * Method :          Default Constructor
        * Purpose :         Constructs an empty Node object with
        *                   item and link set to null.
        * 
        * @param            None.
        * @preconditions    None.
        * @postconditions   A new Node object is created with
        *                   item and link set to null.
        */      
       
       public Node ()
       {
           this.item = null;
           this.link = null;
       }
        
        /**
        * Method :          Constructor
        * Purpose :         Constructs a Node object with item and 
        *                   link set to specified item and link.
        * 
        * @param            item - Object.
        * @param            link - Node.
        * @preconditions    None.
        * @postconditions   A new Node object is created with
        *                   item and link set to null.
        */      
       public Node ( Object item, Node link )
       {
           // Assume this List3 can store null values 
           this.item = item;
           this.link = link;
       }
       
    }
    
    /**
    * Method :          main 
    * Purpose :         This method  to test the method calls in this class.
    * @param            args - array of String.
    * 
    */             
    public static void main(String[] args) throws LinkedListException
    {
        System.out.println();
        System.out.println("***** Start List3 Tests *******");
        System.out.println();
        System.out.println("Create lists-  empty, one, two, multiple"); 
        List3  empty = new List3();
        List3 one = new List3();
        List3 two = new List3();
        List3 multiple = new List3();
        
        
        System.out.println("append(5) to one: ");
        one.append(5);
        System.out.println("one:" + one.toString());
        System.out.println();
        
        System.out.println("append(10) to multiple: ");
        multiple.append(10);
        System.out.println("append(20) to multiple: ");
        multiple.append(20);
        System.out.println("append(30) to multiple: ");
        multiple.append(30);
        System.out.println("multiple after append: " + multiple.toString());
        System.out.println();
        one.remove(0);
          System.out.println("one after remove: " + one.toString());
         multiple.remove(3);
         
         System.out.println("multiple after remove: " + multiple.toString());
        System.out.println("empty:" + empty);
        // Print size of empty list
        System.out.println("Size of empty: " + empty.size());
        System.out.println();
        two.append(5);
        System.out.println("one "+one);
        System.out.println("two "+two);
        if (one.equals(multiple))
         System.out.println("Euals");
        else
        System.out.println("Not equals");
        if ( equalsStr("reshma","reshma"))    
         System.out.println("Euals");
        else
        System.out.println("Not equals");
        
        if (isPalindrome("malayalam"))
        System.out.println("is palin");
        else
            System.out.println("is not palin");
            
            System.out.println(reverseStringR("geetha"));
        
    }
    
            
    }
