
/* Queue.java: Class Queue implementation using List.
 *
 * @Description : This class provides the implementation of the Queue by 
 *                inheriting from a List class. The Queue operations like
 *                enqeue and deqeue are implemented by calling the List methods
 *                - insert and remove. The List is not an abstract 
 *                super class but the inherited "copies" of insert, append,
 *                remove and delete methods are overriden with versions that  
 *                call the Queue's enqueue and dequeue methods. This ensures   
 *                that Queue objects use only enqueue and dequeue methods to 
 *                insert and remove objects in the Stack.
 *
 *
 * Class Invariants: 
 *              - Cannot dequeue from empty Queue.               
 * *                  
 * 
 * @author:     Reshma
 * @ version:   11/16/2105
 */
 
public class Queue extends List
{
    /** No Instance variables - only inherited instance variables**/

    /**
    * Method :          enqueue
    * Purpose :         This method is called to insert an Object into  
    *                   the Queue. The method calls the insert method
    *                   of the List super class. The First Node of Queue 
    *                   is assumed to be frontndex of Queue.
    * 
    * @param            item - Object type
    * @preconditions    None.
    * @postconditions   The specified object will be inserted to the Queue
    *                   at position size() of the List and will be the  
    *                   lastIndex of the Queue.
    * 
    */     
    
    public void enqueue ( Object item )  throws LinkedListException
    { 
       super.insert ( item, super.size () );
    }

    /**
    * Method :          dequeue
    * Purpose :         This method is called to remove an Object from  
    *                   the Queue. The method calls the remove method
    *                   of the List super class. The Last Node of Queue 
    *                   is assumed to be backIndex of Queue.
    * 
    * @return           The object that was contained in the First Node 
    *                   of the List.
    * @preconditions    None.
    * @postconditions   The first Node( position 0) of the list will be 
    *                   removed.
    * 
    */      
    public Object dequeue ()  throws LinkedListException
    { 
       Object retVal = super.remove ( 0 );
       return retVal;
    }
    
    /** Overriden List super class methods **/

    /**
    * Method :          insert
    * Purpose :         Overriden List super class method which calls the 
    *                   enqueue method of this Queue class. The index 
    *                   will be ignored.
    * 
    * @param            item - Object type
    * @param            index - int
    * @preconditions    None.
    * @postconditions   The specified object will be inserted to the Queue
    *                   at position size() of the List and will be the  
    *                   lastIndex of the Queue.
    * 
    */  
     @Override
    public void insert(Object item, int index)  throws LinkedListException
    {
       enqueue ( item );
    }

    /**
    * Method :          append
    * Purpose :         Overriden List super class method which calls the 
    *                   enqueue method of this Queue class. The index 
    *                   will be ignored.
    * 
    * @param            item - Object type
    * @param            index - int
    * @preconditions    None.
    * @postconditions   The specified object will be inserted to the Queue
    *                   at position size() of the List and will be the  
    *                   lastIndex of the Queue.
    * 
    */  
   
    @Override 
    public void append ( Object item ) throws LinkedListException
    {
       enqueue ( item );
    }

    /**
    * Method :          remove
    * Purpose :         Overriden List super class method which calls the 
    *                   dequeue method of this Queue class. The index 
    *                   will be ignored.
    * 
    * @return           The object that was contained in the First Node 
    *                   of the List.
    * @preconditions    None.
    * @postconditions   The first Node( position 0) of the list will be 
    *                   removed.
    * 
    */          
    @Override
    public Object remove ( int index )  throws LinkedListException
    {
       return dequeue();
    }

    /**
    * Method :          delete
    * Purpose :         Overriden List super class method which calls the 
    *                   dequeue method of this Queue class. The index 
    *                   will be ignored.
    * 
    * @return           The object that was contained in the First Node 
    *                   of the List.
    * @preconditions    None.
    * @postconditions   The first Node( position 0) of the list will be 
    *                   removed.
    * 
    */              
    @Override
    public Object delete ( int index )  throws LinkedListException
    {
       return dequeue ();
    }
   

    /**
    * Method :          main 
    * Purpose :         This method  to test the method calls in this class.
    * @param            args - array of String.
    * 
    */     
    public static void main(String[] args) {

       System.out.println("***** Queue Tests *******");      
       try
       {
            Queue aQueue = new Queue();
            Queue bQueue = new Queue();
            Queue cQueue = new Queue();
            Queue dQueue = new Queue();
            Queue eQueue = new Queue();
            Queue fQueue = new Queue();
             
            System.out.println("Enqueue elements to aQueue");
            aQueue.enqueue ('B');
            aQueue.enqueue('a');
            aQueue.enqueue('t');
            System.out.println
			("After Enqueue elements to aQueue: "+aQueue.toString());
            
            System.out.println("Append elements to bQueue");        
            bQueue.append('B');
            bQueue.append('a');
            bQueue.append('t');
            System.out.println("After append bQueue: "+bQueue.toString());
            
            System.out.println("Insert elements to cQueue");  
            cQueue.insert("Fun", 0);
            cQueue.insert("is" , 1);
            cQueue.insert("Java", 2);
            System.out.println("Queue cQueue: "+ cQueue.toString());
      
            System.out.println("Enqueue elements to dQueue");              
            dQueue.enqueue(1);
            dQueue.enqueue(2);
            dQueue.enqueue(3);
            System.out.println("Queue dQueue: "+ dQueue.toString());
            System.out.println();
            System.out.println("Empty Queue eQueue: "+ eQueue.toString());
            System.out.println("Empty Queue fQueue: "+ fQueue.toString());           
            System.out.println();
            System.out.println("Size of aQueue: " + aQueue.size());
            System.out.println("Check if aQueue isEmpty: " + aQueue.isEmpty());
            System.out.println("Check if aQueue isEmpty: " + aQueue.isEmpty());
            System.out.println();
            System.out.println("Check following Queue objects equal");
            System.out.println("aQueue & bQueue?: " + aQueue.equals(bQueue));
            System.out.println("bQueue & cQueue?: " + bQueue.equals(cQueue));
            System.out.println("aQueue & cQueue?: " + aQueue.equals(cQueue));
            System.out.println("aQueue & eQueue?: " + aQueue.equals(eQueue));
            System.out.println("aQueue & null?: " + aQueue.equals(null));
            System.out.println("Comparing 2 empty Queues ");
            System.out.println("eQueue &  fQueue ?" + eQueue.equals(fQueue));
            System.out.println();
           
            System.out.println
				("Remove element from bQueue " + bQueue.remove(3));
            System.out.println 
				("Delete element from bQueue " + bQueue.delete(3));  
            System.out.println();
            System.out.println("Pop all elements in Queue aQueue:");
            while(aQueue.isEmpty() == false) {
                System.out.println("Item dequeued : "+aQueue.dequeue());
            }
            try
            {
                System.out.println("Dequeue an empty Queue - aQueue ");
                aQueue.dequeue();
            } catch (LinkedListException le)
            {
                System.out.println("Exception "+ le.getMessage());
            }
            System.out.println();
            System.out.println("Size of empty Queue : "+ aQueue.size());
           System.out.println("Check if aQueue is empty: "+ aQueue.isEmpty());     
           
      } catch (LinkedListException le)
      {
          System.out.println("Exception "+ le.getMessage());
      }
       System.out.println("***** End Queue Tests *******");
       System.out.println();
     }
}
