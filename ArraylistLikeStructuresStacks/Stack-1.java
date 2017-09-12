/*
 * Stack.java - Class representing Stack object
 * 
 * @author Reshma Sivakumar  
 * @version  1.0 10/24/2015
 *
 * Description: A generic implementation of Last-In-First-Out (LIFO)
 *              representation Stack class using arrays of Objects.
 *              This class doesnot allow null values to be stored in the 
 *              Stack.
 *              
 *              This class provides the methods to Stack operations such as:
 *              Push an Object to Stack
 *              Pop an Object to Stack
 *              Check if Stack is empty
 *              Check for equality of 2 Stack Objects
 *              Return current size of Stack
 *              Return String representation of Stack elements
 *              
 *              > In the Last-In-First-Out(LIFO) implementation
 *              of a Abstract Data Type(ADT) or datastructure,
 *              the last element added to the ADT will be the first one to
 *              be removed. Elements to this type of ADT will be added to 
 *              the top and removed from the top. Basically, if a new 
 *              element is added, that new element will be removed the 
 *              elements that were added before it.Stack is an ADT which
 *              implements LIFO principle.  Insertion in a Stack will 
 *              happen at top(push) and removal of item (pop) will also
 *              happen at top
 *              
 * Class Invariants:
 *              - Cannot push null objects to Stack.
 *              - Cannot pop from an Empty Stack. 
 */

public class Stack
{
    //set initial capacity 
    private static final int INITIALCAPACITY = 2;
    //elements of Stack
    private Object[] elements;
    //top index of Stack, points to the last index of array
    private int top;
    
    /**
    * Method :          Default Constructor
    * Purpose :         Constructs an empty Stack object with
    *                   Object array initialized to this Stack object
    *                   INITIALCAPACITY and top initialized to -1.
    * 
    * @param            None.
    * @preconditions    None.
    * @postconditions   A new Stack object is created with
    *                   Object array initialized to this Stack object
    *                   INITIALCAPACITY and top initialized to -1.
    * 
    */   
    public Stack()
    {   
        this.elements = new Object[INITIALCAPACITY];
        this.top = -1;
    }

    /**
    * Method :          getInitialCapacity
    * Purpose :         To return the initial capacity of this Stack.
    * 
    * @param            None.
    * @preconditions    None.
    * @postconditions   None.
    * @returns          Integer value representing the intial capacity 
    *                   of this Stack.
    */
    public int getInitialCapacity()
    {
        return INITIALCAPACITY;
    }

    /**
    * Method :          push
    * Purpose :         To push the specified object to the top
    *                   of this Stack.
    * 
    * @param            obj - Object value.
    * @preconditions    obj should be a valid Object.
    * @postconditions   The top of this Stack will be incremented
    *                   and the specified Object will be saved in
    *                   the top index of the Object array represented
    *                   by this Stack. The Object array will be 
    *                   resized if the current capacity of this object
    *                   array overflows.
    * @returns          None.
    * @throws           RuntimeException when a null value is pushed to
    *                   Stack.
    */
    public void push(Object obj)
    {
        if (obj == null)
            throw new RuntimeException ("Cannot push null value to Stack!");
        //if Stack is empty, set top index to 0 and add object
        if (this.isEmpty())
        {
            this.top = 0;
            this.elements[top] = obj;
        }
        //if the capacity of the Stack is reached
        else if ( this.size() == this.elements.length )
        {
            /*Create a new array of type Object with size
            double the original array. Copy the elements 
            from original array to this new array. Push the
            input Object to the new array. Then make the 
            new array as instance variable.
            */
            Object[] newElements = new Object [this.size() * 2];
            cloneElements(this.elements, newElements);
            this.elements = newElements;
            this.top++;
            this.elements[top] = obj;
        }
        //otherwise increment top index and add object
        else
        {
            this.top++;
            this.elements[top] = obj;
        }
    }
    
    /**     
    * Method :          pop
    * Purpose :         Removes the Object at the top of this Stack
    *                   and returns the reference of that Object as the
    *                   return value.
    * 
    * @param            None.
    * @preconditions    Stack is not empty.
    * @postconditions   Decrement the top by 1.
    * @returns          Returns the reference to the Object at the top
    *                   of this Stack.
    * @throws           RuntimeException when trying to pop an empty Stack.
    */
    public Object pop()
    {
        Object retVal = null;
        //check if Stack is empty
        if ( this.isEmpty() )
        {
            throw new RuntimeException("Cannot pop element from empty Stack!");
        } 
        //if only object in Stack, return object and set top index -1
        else if (this.top == 0)
        {
            retVal = this.elements[this.top];
            this.top = -1;
        }
        else 
        {
           //return top object and decrement top index by 1
            retVal = this.elements[this.top];
            this.top--;
        }
        return retVal;
    }
    
    /**
    * Method :          size
    * Purpose :         Return the current length of the elements
    *                   in this Stack.
    * 
    * @param            None.
    * @preconditions    None.
    * @postconditions   None.
    * @returns          int value representing current length of elements.
    */
    public int size()
    {
        //size of stack is value in top index + 1
        return this.top + 1;
    }
    
    /**
    * Method :          isEmpty
    * Purpose :         To check if Stack is empty.
    * 
    * @param            None.
    * @preconditions    None
    * @postconditions   None.
    * @returns          true- if Stack is empty.
    *                   false- otherwise.
    */
    public boolean isEmpty()
    {
        if ( this.top < 0  )
            return true;
        else
            return false;
    }
    
    /**
    * Method :          toString
    * Purpose :         To return the String representation of the 
    *                   Stack in the LIFO order for printing.
    * 
    * @param            None.
    * @preconditions    None.
    * @postconditions   None.
    * @returns          String representation of the Stack 
    *                   in the Last In First Out Orde.
    */ 
    public String toString()
    {
        String retVal = null;
        retVal = "[ ";
        for ( int i = this.top ; i >= 0; i--)
        {
            retVal += this.elements[i] + " ";                         
        }
       
        retVal += "]";
        return retVal;
    }
    
    /**
    * Method :          equals
    * Purpose :         To compare if the input Stack object is equal to 
    *                   the internal Stack object
    * 
    * @param            that - another Stack object to be compared to.
    * @preconditions    None.
    * @postconditions   None.
    * @returns          true - if the input Stack object is equal
    *                   false - otherwise
    */
    public boolean equals ( Stack that )
    {

        if ( that == null ) 
            return false;
            
        if (! ( that instanceof Stack ) ) 
            return false;
       
        //if both stack are empty return true    
        if ( this.isEmpty() && that.isEmpty() )    
            return true;
        
        //if either stack is empty return false
        if (this.isEmpty() || that.isEmpty())   
            return false;
       
        //compare this stack with the input stack
        for ( int i = 0; i < this.top; i++)
        {
            if ( !( this.elements[i].equals(that.elements[i]) ) )
                return false;    
        }
        return true;
    }
    
    /**
    * Method :          cloneElements
    * Purpose :         Helper methood to deep copy contents of the source  
    *                   to the target array.
    * 
    * @param            source - object array to be copied from.
    * @param            target - object array to be copied to.  
    * @preconditions    source array should contain valid objects.
    * @postconditions   target array will contain the objects from source array
    */ 
    private void cloneElements(Object[] source, Object[] target)
    {
        for ( int i = 0; i < source.length; i++)
        {
            target[i] = source[i];
        }
    }  
}
