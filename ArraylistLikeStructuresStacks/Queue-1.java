/*
 * Queue.java - Class representing Queue object
 * 
 * @author Reshma Sivakumar  
 * @version  1.0 10/24/2015
 *
 * Description: A generic implementation of First-In-First-Out (FIFO)
 *              representation Queue class using arrays of Objects. This
 *              class doesnot allow to store null objects in the Queue.The 
 *              front of Queue is represented by the 0th index of the array.
 *              This class provides the methods to Queue operations such as:
 *              Enqueue an Object into Queue
 *              Dequeue an Object from Queue
 *              Return the current size of Queue
 *              Return the string representation of Queue
 *              Check if Queue is empty
 *              Check for equality of Queue Objects
 *              >> In the First-In-First-Out(FIFO) implementation of a Abstract
 *              Data Type(ADT) or datastructure, the first element added to the
 *              ADT will be the first one to be removed. Elements to this type 
 *              of ADT will be added to the rear and removed from the front. 
 *              Basically, if a new element is added, all the elements added 
 *              before that element should be removed before this new element
 *              can be removed. Queue is an ADT which implements FIFO principle.
 *              Insertion in a Queue will happen at rear (enqueue) and removal
 *              of item (dequeue) will happen at front.
 *              
 * Class Invariants:
 *              - Queue cannot contain null values.
 *              - Cannot Dequeue from an Empty Queue. 
 *              
 */

public class Queue
{
    //set Initial capacity for the Queue
    private static final int INITIALCAPACITY = 100;
    // Queue elements
    private Object[] elements; 
    //front of Queue will point to the 0th elt in array
    private int frontIndex; 
    //rear of Queue will point to the last non-empty array element
    private int backIndex;
    
    /**
    * Method :          Default Constructor
    * Purpose :         Constructs an empty Queue object with
    *                   Object array initialized to the INITIALCAPACITY  
    *                   The frontIndex and backIndex initialized to -1.
    * 
    * @param            None.
    * @preconditions    None.
    * @postconditions   A new Queue object initialized to the INITIALCAPACITY  
    *                   The frontIndex and backIndex initialized to -1.
    */   
    public Queue()
    {   
        this.elements = new Object[INITIALCAPACITY];
        this.frontIndex = -1;
        this.backIndex = -1;
    }

    /**
    * Method :          enqueue
    * Purpose :         To add a new object to the Queue.
    * 
    * @param            obj - Object value.
    * @preconditions    obj should be a valid Object.
    * @postconditions   The frontIndex will be set to the first added
    *                   element of the Queue and the backIndex will
    *                   be set to the last added element of the Queue
    *                   and the specified Object will be added to the
    *                   Queue. The Object array will be resized if the
    *                   current capacity of of this Queue overflows.
    *                                     
    * @returns          None.
    * @throws           RuntimeException when object value being added 
    *                   is null.
    */
    public void enqueue(Object obj)
    {
        if (obj == null)
            throw new RuntimeException("Cannot pass null value to Queue");
        //If Queue is empty, set front and back indices to 0
        //add data to backIndex
        if ( isEmpty() )    
        {
            this.frontIndex = 0;
            this.backIndex = 0;
            this.elements[this.backIndex] = obj;
        }
        //if capacity of Queue overflows, resize and add
        else if (this.size() == this.elements.length )
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
            this.backIndex++;
            this.elements[this.backIndex] = obj;
        } 
        //otherwise, increment backIndex and add object
        else 
        {
            this.backIndex++;
            this.elements[this.backIndex] = obj;
        }
    }
    
    /**
    * Method :          dequeue
    * Purpose :         Returns the Object at the front of this Queue.
    *                   If only one Object exists in this Queue,
    *                   return the reference to that Object and set front 
    *                   and back indices to -1.
    * 
    * @param            None.
    * @preconditions    Queue is not empty.
    * @postconditions   The frontIndex is incremented by 1.
    *                   If only one element in queue, front and back 
    *                   Indices are set to -1.
    * @returns          Returns the reference to the Object at the front
    *                   of this Queue.
    * @throws           RuntimeException when trying to dequeue an 
    *                   Object from an empty Queue.
    */
    public Object dequeue()
    {
        Object retVal = null;
        //Check if queue is empty
        if ( this.isEmpty() )
        {
            throw new RuntimeException("Cannot Dequeue Empty Queue");
        }   
        //Check if there is only one element
        else if (this.frontIndex == this.backIndex )
        {
            //return the only element
            retVal = this.elements[this.backIndex];
            //set front and back index to -1
            this.frontIndex = -1;
            this.backIndex = -1;
        }
        //return the element in the front and increment front
        else 
        {
            retVal = this.elements[this.frontIndex];
            this.frontIndex++;
        }
        return retVal;
    }

    /**
    * Method :          getInitialCapacity
    * Purpose :         To return the initial capacity of this Queue.
    * 
    * @param            None.
    * @preconditions    None.
    * @postconditions   None.
    * @returns          Integer value representing the intial capacity 
    *                   of this Queue.
    */
    public int getInitialCapacity()
    {
        return INITIALCAPACITY;
    }

    /**
    * Method :          size
    * Purpose :         Return the current length of the elements
    *                   in this Queue.
    * 
    * @param            None.
    * @preconditions    None.
    * @postconditions   None.
    * @returns          int value representing current length of elements,
    */
    public int size()
    {
        return (this.backIndex - this.frontIndex) + 1;
    }
    
    /**
    * Method :          isEmpty
    * Purpose :         To check if this Queue is empty.
    * 
    * @param            None.
    * @preconditions    None
    * @postconditions   None.
    * @returns          true- if this Queue is empty.
    *                   false- otherwise.
    */
    public boolean isEmpty()
    {
        if ( this.backIndex < 0 )
            return true;
        else
            return false;
    }
    
    /**
    * Method :          toString
    * Purpose :         To return the String representation of this 
    *                   Queue in First-in-First-Out order for printing.
    * 
    * @param            None.
    * @preconditions    None.
    * @postconditions   None.
    * @returns          String representation this Queue elements in
    *                   First-in-First-Out order.
    */ 
    public String toString()
    {
        String retVal = "[ ";
        // print only the elements from the frontIndex to the backIndex
        for ( int i = this.frontIndex ; i <= this.backIndex; i++ )
        {
            retVal += this.elements[i] + " ";                         
        }
        retVal += "]";
        return retVal;
    }
    
    /**
    * Method :          equals
    * Purpose :         To compare if the input Queue object is equal to 
    *                   the internal Queue object
    * 
    * @param            that - another Queue object to be compared to.
    * @preconditions    None.
    * @postconditions   None.
    * @returns          true - if the input Queue object is equal
    *                   false - otherwise
    */
    public boolean equals ( Queue that )
    {
        if ( that == null ) 
            return false;
            
        if (! ( that instanceof Queue ) ) 
            return false;
       
        //if both Queues are empty return true
        if ( this.isEmpty() && that.isEmpty() )    
            return true;
        
        // if either is empty return false
        if (this.isEmpty() || that.isEmpty())   
            return false;
       
        //compare elements in both Queue starting from 
        //element in frontIndex to backIndex.
        for ( int i = this.frontIndex; i < this.backIndex; i++)
        {
            if ( !( this.elements[i].equals(that.elements[i]) ) )
                return false;    
        }
        return true;
    }
    
    /**
    * Method :          cloneElements
    * Purpose :         Helper methood to deep copy contents of the source   
    *                   array the target array.
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
