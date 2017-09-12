
/**
 * ArrayList.java - Class representing ArrayList 
 * 
 * @author Reshma Sivakumar  
 * @version  1.0 10/24/2015
 *
 * Description: This generic implementation of a List using arrays of
 *              Objects.  
 *              This class provides the methods to generic List operations:
 *              Insert an Object at a specified index.
 *              Remove and return the Object at a specified index.
 *              Return the current size of the List.
 *              Return the string representation of the List elements.
 *              Check if List is empty.
 *              Returns the index of an Object in the List.
 *              Check for equality of 2 List Objects.
 *              Return the reference to the Object at the specified index.
 *              
 * Class Invariants:
 *              - List cannot contain null values.
 *              - Index passed for insert should be positive.
 *              - Cannot remove from an Empty List. 
 *              
 */
public class ArrayList
{
    private static final int INITIALCAPACITY = 2;
    private Object[] elements;
    private int numElements;
    
     /**
    * Method :          Default Constructor
    * Purpose :         Constructs an empty ArrayList object with
    *                   Object array initialized to INITIALCAPACITY 
    *                   and numElements initialized to 0.
    * 
    * @param            None.
    * @preconditions    None.
    * @postconditions   A new ArrayList object is created with
    *                   Object array and top initialized.
    */   
    public ArrayList()
    {   
        this.elements = new Object[INITIALCAPACITY];
        this.numElements = 0;
    }

    /**
    * Method :          insert
    * Purpose :         To insert the specified object to the List
    *                   at the specified index. If index specified 
    *                   is far ahead of the lastindex of the array,
    *                   the object will be appended to the list.
    * 
    * @param            obj - Object value.
    * @param            index - a postive integer value.
    * @preconditions    obj should be a valid Object.
    * @postconditions   The numElements of the List will be incremented
    *                   and the specified Object will be saved in
    *                   the index represented by the numElement of the 
    *                   Object array represented by this List. 
    *                   The Object array will be resized if the current 
    *                   capacity of this object array overflows.
    *                 
    * @returns          None.
    * @throws           RuntimeException when a null value is pushed to
    *                   List or when a negative value passed as index.
    */
    public void insert (Object obj, int index)
    {
        if ( obj == null )
            throw new NullPointerException("Cannot insert null Object");
        
        if ( index < 0 )
            throw new RuntimeException("Cannot insert into negative index");
        //If specified index is 8 for eg., and number of elements
        //in the array is only 3, then we adjust the index to append.
        if ( index > this.numElements + 1 )
            index = this.numElements;
        /*Create a new array of type Object with size
          double the original array. Copy the elements 
          from original array to this new array. Push the
          input Object to the new array. Then make the 
          new array as instance variable.
        */
        if ( this.numElements == this.elements.length - 1 )
        {
            Object[] newElements = new Object [ this.elements.length * 2 ];
            cloneElements(this.elements, newElements);
            this.elements = newElements;
            arrayShiftRight(index);
            this.elements[index] = obj;
            this.numElements++;
        }
        else 
        {
            arrayShiftRight(index);
            this.elements[index] = obj;
            this.numElements++;
        }
    }
    
    /**
    * Method :          add
    * Purpose :         To append the specified object to the List
    *                 
    * @param            obj - Object value.
    * @preconditions    obj should be a valid Object.
    * @postconditions   The numElements of the List will be incremented
    *                   and the specified Object appended to this list. 
    *                   The Object array will be resized if the current 
    *                   capacity of this object array overflows.
    *                 
    * @returns          None.
    * @throws           RuntimeException when a null value is pushed to
    *                   List or when a negative value passed as index.
    */
    public void add (Object obj)
    {
        if ( obj == null )
            throw new NullPointerException("Cannot add null Object");
 
        /*Create a new array of type Object with size
          double the original array. Copy the elements 
          from original array to this new array. Push the
          input Object to the new array. Then make the 
          new array as instance variable.
        */
        if ( this.numElements == this.elements.length - 1 )
        {
            Object[] newElements = new Object [ this.elements.length * 2 ];
            cloneElements(this.elements, newElements);
            this.elements = newElements;
            this.elements[this.numElements] = obj;
            this.numElements++;
        }
        else 
        {
            this.elements[numElements] = obj;
            this.numElements++; 
        }
    }
       
    /**     
    * Method :          remove
    * Purpose :         Removes the Object at the specified index of
    *                   this list and returns the reference of that
    *                   Object as the return value.
    * 
    * @param            index - integer representing the position of
    *                   Object in the List.
    * @preconditions    List is not empty.
    * @postconditions   Decrement number of elements by 1.
    * @returns          Returns the reference to the Object at the specified
    *                   index.
    * @throws           RuntimeException when trying to remove from an empty
    *                   List or index specified is negative or index is greater
    *                   than the number of elements in the array .
    */ 
    
    public Object remove ( int index )
    {
       Object retVal = null;
       //Check if index is negative
       if ( index < 0 )
          throw new RuntimeException("Cannot retrieve for negative index");
       //if index is greater than the number of elements in the array   
       if (index > this.numElements)
          throw new NullPointerException("No value exists for this index"); 
     
       if (!(isEmpty()))
       {
           retVal = this.elements[index];
           arrayShiftLeft(index); 
           this.numElements--;
       }
       else
        throw new NullPointerException("Array is empty, nothing to remove");
       return retVal;
    }

    /**
    * Method :          getInitialCapacity
    * Purpose :         To return the initial capacity of this List.
    * 
    * @param            None.
    * @preconditions    None.
    * @postconditions   None.
    * @returns          Integer value representing the intial capacity 
    *                   of this List.
    */
    public static int getInitialCapacity()
    {
        return INITIALCAPACITY;
    }

    /**
    * Method :          isEmpty
    * Purpose :         To check if ArrayList is empty.
    * 
    * @param            None.
    * @preconditions    None
    * @postconditions   None.
    * @returns          true- if ArrayList is empty.
    *                   false- otherwise.
    */
    public boolean isEmpty()
    {
        if ( this.numElements <= 0  )
            return true;
        else
            return false;
    }
    
    /**
    * Method :          size
    * Purpose :         Return the current length of the elements
    *                   in this List.
    * 
    * @param            None.
    * @preconditions    None.
    * @postconditions   None.
    * @returns          int value representing current length of elements.
    */    
    public int size()
    {
       return this.numElements; 
    }

    /**
    * Method :          get
    * Purpose :         Return the reference to the current Object in this
    *                   List.
    * 
    * @param            index - integer representing the position of
    *                   Object in the List.
    * @preconditions    None.
    * @postconditions   None.
    * @returns          int value representing current length of elements.
    * @throws           RuntimeException when specified index is negative.
    * @throws           NullPointerException when no value exists at the
    *                   specified index.
    */    
    public Object get (int index)
    {
        if (index < 0 )
            throw new RuntimeException("Cannot retrieve for negative index");
        if (index > this.numElements)
            throw new NullPointerException(
            "No value exists for this index");
        return this.elements[index];
    }
 
    /**
    * Method :          indexOf
    * Purpose :         Return the index in the List where the current Object 
    *                   is stored.
    * 
    * @param            obj - reference to the Object to be searched.
    * @preconditions    None.
    * @postconditions   None.
    * @returns          int value representing position of the specified
    *                   Object in the List.
    * @throws           NullPointerException when null reference is passed.
    */    
    public int indexOf (Object obj)
    {
        if ( obj == null )
            throw new NullPointerException("Cannot get index of null Object");
        if ( contains(obj) )
        {
            for ( int i = 0; i < this.numElements; i++ )
            {
                if (get(i).equals(obj))
                    return i;    
            }
        }
        return -1;
    }
   
    /**
    * Method :          toString
    * Purpose :         To return the String representation of the 
    *                   object represented by this list for printing.
    * 
    * @param            None.
    * @preconditions    None.
    * @postconditions   None.
    * @returns          String representation of all the
    *                   objects represented by this list.
    */ 
    public String toString()
    {
        String retVal = "[ ";
        for ( int i = 0 ; i < this.numElements; i++)
        {
            retVal += this.elements[i] + " ";                         
        }
        retVal += "]";
        return retVal;
    }
    
    /**
    * Method :          equals
    * Purpose :         To compare if the input List object is equal to 
    *                   the internal List object
    * 
    * @param            that - another List object to be compared to.
    * @preconditions    None.
    * @postconditions   None.
    * @returns          true - if the input List object is equal
    *                   false - otherwise
    */
    public boolean equals ( ArrayList that )
    {

        if ( that == null ) 
            return false;
            
        if (! ( that instanceof ArrayList ) ) 
            return false;
       
        //if both stack are empty return true    
        if ( this.isEmpty() && that.isEmpty() )    
            return true;
        
        //if either stack is empty return false
        if (this.isEmpty() || that.isEmpty())   
            return false;
       
        //compare this stack with the input stack
        for ( int i = 0; i < this.numElements; i++)
        {
            if ( !( this.elements[i].equals(that.elements[i]) ) )
                return false;    
        }
        return true;
    }
    
    /**
    * Method :          cloneElements
    * Purpose :         Helper methood to deep copy contents of the source 
    *                    array the target array.
    * 
    * @param            source - object array to be copied from.
    * @param            target - object array to be copied to.  
    * @preconditions    source array should contain valid objects.
    * @postconditions   target array will contain the objects from source array
    */ 
    private void cloneElements(Object[] source, Object[] target)
    {
        for (int i = 0; i < source.length; i++)
        {
            target[i] = source[i];
        }
    }
   
    /**
    * Method :          contains
    * Purpose :         Helper methood to check if an object exists in this 
    *                   List.
    * 
    * @param            target - reference to object to be searched.  
    */
    private boolean contains ( Object target )
    {
        for (int i = 0; i < this.numElements; i++)
        {   
            if (target.equals(get(i)))
                return true;
        }
        return false;
    }
    
    /**
    * Method :          arrayShiftLeft
    * Purpose :         Helper methood to shift all elements of this 
    *                   List to left during remove operation.
    * 
    * @param            index - integer value where the object needs to be 
    *                   removed.
    */   
    private void arrayShiftLeft(int index)
    {
        for ( int i = 0; i < this.elements.length-1; i++ )
        {
            this.elements[i] = this.elements[i+1];
        }
    }

    /**
    * Method :          arrayShiftRight
    * Purpose :         Helper methood to shift all elements of this 
    *                   List to right during insert operation.
    * 
    * @param            index - integer value where the object needs to be 
    *                   inserted
    */   
    private void arrayShiftRight(int index)
    {
        for ( int i = this.elements.length-1; i > index; i-- )
        {
            this.elements[i] = this.elements[i-1];  
        }
    }
    
}
