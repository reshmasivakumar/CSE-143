    
    /* LinList.java: Class implementating a List.
    *
    * @Description : This class is generic implementation of a List of Objects.
    *                The List is represented as a series of Node class which are
    *                linked to one another in a linear fashion. The Node class 
    *                is implemented as  private inner class in this List class. 
    *                This class provides the methods to generic List operations
    *                - Insert an Object at a specified index.
    *                - Append an Object to the List.
    *                - Remove and return the Object at a specified index.
    *                - Delete an return the Object at a specified index.
    *                - Return the current size of the List.
    *                - Return the string representation of the List elements.
    *                - Check if List is empty.
    *                - Returns the index of an Object in the List.
    *                - Check for equality of 2 List Objects.
    *                - Return the reference to the Object at the specified 
    *                   index.
    * 
    * Class Invariants:
    *              - Cannot specify negative index for insert or remove.
    *              - Cannot specify index beyond the size of the List.
    *              - Cannot remove from empty List.                 
    *                    
    * 
    * @author:     Reshma Sivakumar
    * @ version:   2 3/13/2016
    */
    
    
    public class List
    {
    
    /** Instance Variables **/
    
    private Node head;
    
    /**
    * Method :          Default Constructor
    * Purpose :         Constructs an empty List object with
    *                   head Node initialized to null.
    * 
    * @param            None.
    * @preconditions    None.
    * @postconditions   A new List object is created with
    *                   head Node initialized to null.
    */   
    
    public List ()
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
    *                   its data. This Node will be added to this List
    *                   in the position specified by the index. 
    *                 
    * @returns          None.
    * @throws           LinkedListException 
    *                   - when a negative value passed as index.
    *                   - If index specified is greater than the size of 
    *                   the List.
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
                ("Exception: Cannot insert, List is Empty, specify index 0");
            head = new Node (item, head);
        }
        //Check if linked List has only one element
        else if ( size() == 1 ) 
        {
            //throw exception if index is not 0 or 1
            if ( index != 0 && index != 1 )
            {
                throw new LinkedListException 
                ("Exception: Cannot insert, List has only one item, specify index 0 or 1");
            }
            // Check if insert is before head
            if ( index == 0 )
            {
                               
                newNode = new Node ( item, head );
                head = newNode;
            }
            //check if index is after head
            else if ( index == 1 )
            {
                newNode = new Node ( item, null );
                head.link = newNode;
            }
        }
        //insert into List with size > 1
        else
        { 
            // index is negative or index is greater than size
            if ( index < 0 || index > size () )
                throw new LinkedListException 
                ("Exception: Cannot insert, Index out of bounds");
            
            // if index ==0 , then head needs to be adjusted to this new node
             if ( index == 0 )
            {          
                newNode = new Node ( item, head );
                head = newNode;
            }
    
            else
            {
                //if index is > 0 , navigate through the List till the position 
                //matching the index is reached in the List 
                Node previous = head; // to point to the Node before the index
                Node current = head;  // to point to the Node at the index
                
                for(int i = 0; i < index; i++){
                    //set previous to current node
                    previous = current;
                    //sets the current to reference the next node
                    current = current.link; 
                }
                // create new node and set the previous node to point to the
                // new node, new node to point to current.
                newNode = new Node (item, current);
                previous.link = newNode;
               
            }
            
        }
    }
    
    
    /**
    * Method :          append
    * Purpose :         To append the specified object to the end
    *                   of the List. 
    * 
    * @param            obj - Object value.
    * @preconditions    None.
    * @postconditions   A new Node will be created with the item as
    *                   its data. This Node will be added to the end 
    *                   of this List. 
    *                 
    * @returns          None.
    *                   
    */
    public void append ( Object item )  throws LinkedListException
    {
        Node newNode;
        
        // if List is empty, create new node and set this as head
        if ( isEmpty() )
        {
            head = new Node (item, head);
           
        }
        //if only one element in List, create new node and set the head
        // to point to this new node
        else if ( size() == 1 )
        {
           newNode = new Node ( item, null );
           head.link = newNode;
        }
        // if size of List > 1
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
    *                   this List and returns the reference of that
    *                   Object as the return value.
    * 
    * @param            index - integer representing the position of
    *                   Object in the List.
    * @preconditions    List is not empty and index is non-negatove and
    *                   less that  size of List.
    * @postconditions   The Node at the specified index will be removed and
    *                   the links will be adjusted.
    * @returns          Returns the reference to the Object at the specified
    *                   index.
    * @throws           LinkedListException 
    *                   - when trying to remove from an empty List.
    *                   - index specified is negative.
    *                   - index is greater than the size of the List.
    */ 
    
    
    public Object remove ( int index ) throws LinkedListException
    {
        Object retVal = null;
        //check if list is empty
        if ( isEmpty() )
            throw new LinkedListException ("Exception: Cannot remove, List is empty");
        
        //check if index is outside the range. eg list has only 2 elements but
        //index specified >=2
        if ( index < 0 || index >= size() )
            throw new LinkedListException
            ("Exception: Cannot remove, List index out of bounds");
        
       
        if ( size() == 1 ) //list has only 1 element
        {
            retVal = this.head.item; //return head item
            this.head = null; //set head to null as list is empty now
        }
        else
        {
            //traverse list till index of item to be removed is reached
            Node current = head; 
            Node previous = head;
            
            //if item to be removed is first element
            if ( index == 0 )
            {
                //return value is first item
                retVal = current.item;
                //head points to 2nd element in list
                this.head = current.link;
            }
            else
            {
                int count = 0;
                //traverse till index of element to be removed
                //is found
                while ( current != null )
                {   
                    if ( count == index )
                    { //index found
                        //return value is item at index
                        retVal = current.item;
                        //remove the element by linking previous node
                        //next pointer to the pointer of current item 
                        //removed
                        previous.link = current.link;
                        //break loop when found
                        break;
                    }
                    count++;
                    previous = current;
                    current = current.link;
                }
            }
        }
        return retVal; //return item removed
    }
    
    /**     
    * Method :          delete
    * Purpose :         Removes the Object at the specified index of
    *                   this List and returns the reference of that
    *                   Object as the return value.
    * 
    * @param            index - integer representing the position of
    *                   Object in the List.
    * @preconditions    List is not empty and index is non-negatove and
    *                   less that  size of List.
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
                current = current.link;
            }
            
        }
        //if empty, size is 0, else returns number of links in node
        return sizeCount;
    }
    
    /**
    * Method :          indexOf
    * Purpose :         Return the index in the List where the current Object 
    *                   is stored.
    * 
    * @param            obj - reference to the Object to be searched.
    * @preconditions    List is not empty.
    * @postconditions   None.
    * @returns          int value representing position of the specified
    *                   Object in the List.
    * @throws           LinkedListException -  when List is empty.
    */          
    
    public int indexOf ( Object target ) throws LinkedListException
    {
        Node current = this.head;
        int count = 0;
        int retVal = -1;
        
        if ( isEmpty() )
            throw new LinkedListException ("Exception in indexOf: List is Empty");
        
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
    * Purpose :         To check if List is empty.
    * 
    * @param            None.
    * @preconditions    None
    * @postconditions   None.
    * @returns          true- if List is empty.
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
    *                   object represented by this List for printing.
    * 
    * @param            None.
    * @preconditions    None.
    * @postconditions   None.
    * @returns          String representation of all the
    *                   objects represented by this List.
    */         
    public String toString ()
    {
        String retVal = "[ ";
        if ( isEmpty() )
            retVal += "List is empty";
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
    
    /**
    * Method :          getHead
    * Purpose :         Get the reference to head node
    * @param            None.
    * @preconditions    None.
    * @postconditions   None.
    * @returns          returns reference to head node
    */

    public Node getHead ()
    {
        return this.head;
    }
    
    /**
    * Method :          equals
    * Purpose :         To compare if the input List object is equal to 
    *                   the internal List object
    * 
    * @param            other - another List object to be compared to.
    * @preconditions    None.
    * @postconditions   None.
    * @returns          true - if the input List object is equal
    *                   false - otherwise
    */
    public boolean equals ( Object other1 )
    {
        //check if object passed is null
        if ( other1 == null )
            return false;
        
        //check if object passed is same type 
        if ( this.getClass() != other1.getClass() )
             return false;
        
        List other = (List) other1;
        //check if size of object passed is different
        if ( this.size() != other.size() )
            return false;
        
        Node current = this.head;
        Node that = other.head;
        
        // traverse both Lists starting from head and check if item 
        //in the current node equals item in the other node
        while ( current != null )
        {
          //check if items in both list are equal. If one item 
          //doesnot match return false
          
          if (that.item!=null && !(current.item).equals( that.item ))
            return false;    
           
          //get next node in this list  
          current =  current.link;
          //get next node in that list
          that = that.link;
        }
        return true; //all node items match
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
        private Object item; //data of list
        private Node link; //next pointer
    
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
           // Assume this List can store null values 
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
        System.out.println("***** Start List Tests *******");
        System.out.println();
        System.out.println("Create Lists-  empty, one, two, multiple"); 
        List empty = new List();
        List one = new List();
        List one1 = new List();
        List two = new List();
        List multiple = new List();
        List multiple2 = new List();
        
        System.out.println("append(5) to one: ");
        one.append(5);
        System.out.println("one:" + one.toString());
        System.out.println();
        System.out.println("append(5) to one1: ");
        one1.append(5);
        System.out.println("one1:" + one1.toString());
        System.out.println();
        
        System.out.println("append(10) to multiple: ");
        multiple.append(10);
        System.out.println("append(20) to multiple: ");
        multiple.append(20);
        System.out.println("append(30) to multiple: ");
        multiple.append(30);
        System.out.println("multiple after append: " + multiple.toString());
        System.out.println();
        
        System.out.println("empty:" + empty);
        // Print size of empty List
        System.out.println("Size of empty: " + empty.size());
        System.out.println();
        
        //Insert node into multiple2 at index 0
        System.out.println("insert 300 at position 0 to multiple2: ");
        multiple2.insert ( 300, 0);
        System.out.println("Size of one "+ multiple2.size());
        System.out.println("multiple2 after insert(300,0):"+ multiple2);
        multiple2.insert ( null,0);
        System.out.println("multiple2 after insert(null,0):"+ multiple2);
        System.out.println("Size of multiple2: "+ multiple2.size());
        multiple2.insert ( 9800,1);
        System.out.println("multiple2 after insert(9800,1):"+ multiple2);
        System.out.println("Size of multiple2 "+ multiple2.size());
        
        multiple2.remove(1);
        System.out.println("multiple2 after remove1):"+ multiple2);
        
        multiple2.remove(0);
         System.out.println("multiple2 after remove(0):"+ multiple2);
         
        multiple2.insert ( 600,0);
        System.out.println("multiple2 after insert(600,0):"+ multiple2);
        System.out.println("Size of multiple2 "+ multiple2.size());
        System.out.println();
     
        System.out.println ("Index of 600 in multiple2: " + multiple2.indexOf (600));
        System.out.println ("Index of null in multiple2: " + multiple2.indexOf (null));
        System.out.println ("Index of 500 in multiple2: " + multiple2.indexOf (500));
        System.out.println ("Index of 98777 in multiple2: " + multiple2.indexOf (98777));
        System.out.println();
        
        System.out.println ("Check if two is empty "+ two.isEmpty());
        System.out.println("append 300,500  to two ");
        two.append ( 300);
        two.append ( 500);
        System.out.println();
        System.out.println("Check following List objects are equal");
        System.out.println("mutiple & multiple2?: " + multiple.equals(multiple2));        
        System.out.println();
        System.out.println("Check following List objects are equal");
        System.out.println("one & one1?: " + one.equals(one1));        
        System.out.println();        
        System.out.println("two after append:" + two);
        System.out.println ("Check again if two is empty "+ two.isEmpty());
        System.out.println("Size of two: " + two.size());
        System.out.println();
        System.out.println("Insert 600 to two");
        two.insert ( 600 , 2);
        System.out.println("two after insert(600,2) :"+two);
        System.out.println("Size of two: "+two.size()); 
        System.out.println ("element returned for two.remove(2): "+two.remove(2));
        System.out.println ("two after remove: " + two );
         
        System.out.println("multiple2:"+multiple2);
        System.out.println("Multiple:"+ multiple);  
        
        multiple2.delete(0);
        multiple.delete(1);
        System.out.println("multiple2 (upon delete(0):"+multiple2);
        System.out.println("Multiple (upon delete(1):"+ multiple);
        
        System.out.println("Insert 600 at 1 in multiple2"); 
        multiple2.insert(600, 1);
        System.out.println("Insert 400 at 2 in multiple"); 
        multiple.insert(400, 2);
        System.out.println("multiple2 (on insert):"+multiple2);
        System.out.println("Multiple(on insert):"+ multiple);
        System.out.println();       
        
        System.out.println("Remove all elements from multiple2 :");
        while(multiple2.isEmpty() == false) {
            System.out.println("Item removed : "+multiple2.remove(0));
        }
        System.out.println();
        try
        {
            System.out.println("Remove from an empty List - multiple2 ");
            multiple2.remove(0);
        } catch (LinkedListException le)
        {
            System.out.println( le.getMessage());
        }
        
        try
        {
            System.out.println("Remove item at position 100 in multiple ");
            multiple.remove(100);
        } catch (LinkedListException le)
        {
            System.out.println( le.getMessage());
        }            
        System.out.println();
        System.out.println("Size of empty List : "+ multiple2.size());
        System.out.println("Check if List is empty: "+ multiple2.isEmpty());   
        System.out.println();
        System.out.println("***** End List Tests *******");
        System.out.println();
                
    }
    
            
    }
