

/* Stack.java: Class Stack implementation using List.
 *
 * @Description : This class provides a LIFO implementation of the Stack by 
 *                inheriting from a List class. The Stack operations like
 *                push and pop are implemented by calling the List methods,
 *                insert and remove. The List is not an abstract 
 *                super class but the inherited "copies" of insert ,append
 *                remove and delete methods are overriden with versions that
 *                call the Stack push and pop methods. This ensures that Stack
 *                objects use only push and pop methods to insert and remove
 *                objects in the Stack.
 *              
 * Class Invariants:
 *              - Cannot pop from empty stack.               
 * 
 * @author:     Reshma Sivakumar
 * @ version:   1 02/22/2016
 */

public class Stack extends List
{
   /** No Instance variables - only inherited instance variables**/

    /**
    * Method :          push
    * Purpose :         This method is called to push an Object into  
    *                   the Stack. The method calls the insert method
    *                   of the List super class.   Stack top is assumed
    *                   to be at the end position of the list.
    * 
    * @param            item - Object type
    * @preconditions    None.
    * @postconditions   The specified object will be pushed to the Stack
    *                   at position size() of the List and will be the  
    *                   top element of the Stack.
    * 
    */     
   public void push ( Object item ) throws LinkedListException
   {
       // Stack top is assumed to be at the size() position list
       super.insert ( item, super.size () );
   }
   

    /**
    * Method :          pop
    * Purpose :         This method is called to pop an Object from  
    *                   the Stack. The method calls the remove method
    *                   of the List super class.   Stack top is assumed
    *                   to be at the end position of the list.
    * 
    * @param            None.
    * @returns          Returns the item object that is being popped.
    * @preconditions    None.
    * @postconditions   The specified object will be popped from the Stack
    *                   at position size() of the List. The next Mode 
    *                   in the List of the popped Node will be considered
    *                     as top element of Stack.
    * @throws           LinkedListExecption -  WHen trying to pop from
    *                   empty stack.
    * 
    */         
    public Object pop () throws LinkedListException 
   {
       Object retObj = super.remove ( super.size()-1);
       return retObj;
   }

   /** Overriden List Super class methods **/
   
    /**
    * Method :          insert
    * Purpose :         Overriden List class method which calls the push  
    *                   operation on the Stack.
    * 
    * @param            item - Object type
    * @param            index - int
    * @preconditions    None.
    * @postconditions   The specified object will be pushed to the Stack
    *                   at position size() of the List and will be the  
    *                   top element of the Stack.
    * 
    */     
   @Override
   public void insert(Object item, int index) throws LinkedListException
   {
       push ( item );
   }

   
    /**
    * Method :          append
    * Purpose :         Overriden List class method which calls the push  
    *                   operation on the Stack.
    * 
    * @param            item - Object type
    * @preconditions    None.
    * @postconditions   The specified object will be pushed to the Stack
    *                   at position size() of the List and will be the  
    *                   top element of the Stack.
    * 
    */     
    @Override 
    public void append ( Object item ) throws LinkedListException
    {
       push ( item );
    }

    /**
    * Method :          remove
    * Purpose :         Overriden List class method which calls the pop  
    *                   operation on the Stack.
    * 
    * @param            index - int.
    * @returns          Returns the item object that is being popped.
    * @preconditions    None.
    * @postconditions   The specified object will be popped from the Stack
    *                   at position size() of the List. The next Mode 
    *                   in the List of the popped Node will be considered
    *                     as top element of Stack.
    * @throws           LinkedListExecption -  WHen trying to pop from
    *                   empty stack.
    * 
    */            
   @Override
   public Object remove ( int index ) throws LinkedListException
   {
       return pop();
   }

    /**
    * Method :          delete
    * Purpose :         Overriden List class method which calls the pop  
    *                   operation on the Stack.
    * 
    * @param            index - int.
    * @returns          Returns the item object that is being popped.
    * @preconditions    None.
    * @postconditions   The specified object will be popped from the Stack
    *                   at position size() of the List. The next Mode 
    *                   in the List of the popped Node will be considered
    *                     as top element of Stack.
    * @throws           LinkedListExecption -  When trying to pop from
    *                   empty stack.
    * 
    */            
   @Override
   public Object delete ( int index ) throws LinkedListException
   {
       return pop();
   }
   
   /**
    * Method :          main 
    * Purpose :         This method  to test the method calls in this class.
    * @param            args - array of String.
    * 
    */       
   public static void main ( String[] args )
   {
       
        System.out.println("***** Stack Tests *******");
        try
        {
            Stack aStack = new Stack();
            Stack bStack = new Stack();
            Stack cStack = new Stack();
            Stack dStack = new Stack();
            Stack eStack = new Stack();
            Stack fStack = new Stack();
            
            System.out.println("Push elements to aStack");
            aStack.push ('B');
            aStack.push('a');
            aStack.push('t');
            System.out.println("After push aStack: "+aStack.toString());
            
            System.out.println("Append elements to bStack");        
            bStack.append('B');
            bStack.append('a');
            bStack.append('t');
            System.out.println("After append bStack: "+bStack.toString());
            
            System.out.println("Insert elements to cStack");  
            cStack.insert("Fun", 0);
            cStack.insert("is" , 1);
            cStack.insert("Java", 2);
            System.out.println("Stack cStack: "+cStack.toString());
            
            System.out.println("Push elements to dStack");              
            dStack.push(1);
            dStack.push(2);
            dStack.push(3);
            System.out.println("Stack dStack: "+dStack.toString());
            System.out.println();
            System.out.println("Empty Stack eStack: "+eStack.toString());
            System.out.println("Empty Stack fStack: "+fStack.toString());           
            System.out.println();
            System.out.println("Size of aStack: " + aStack.size());
            System.out.println("Check if aStack isEmpty: " + aStack.isEmpty());
            System.out.println("Check if fStack isEmpty: " + fStack.isEmpty());
            System.out.println();
            System.out.println("Check following stack objects equal");
            System.out.println("aStack "+aStack.toString());
            System.out.println("bStack "+bStack.toString());
            System.out.println("cStack "+cStack.toString());
            System.out.println("eStack "+eStack.toString());
            System.out.println("fStack "+fStack.toString());
            System.out.println("aStack & bStack?: " + aStack.equals(bStack));
            System.out.println("bStack & cStack?: " + bStack.equals(cStack));
            System.out.println("aStack & cStack?: " + aStack.equals(cStack));
            System.out.println("aStack & eStack?: " + aStack.equals(eStack));
            System.out.println("aStack & null?: " + aStack.equals(null));
            System.out.println("Comparing 2 empty stacks ");
            
            System.out.println("eStack & fStack ?" + eStack.equals(fStack));
            System.out.println();
           
            System.out.println
				("Remove element from bStack at index 3" + bStack.remove(3));
            System.out.println
				("Delete element from bStack at index 3" + bStack.delete(3));  
            System.out.println();
            System.out.println("Pop all elements in Stack aStack:");
            while(aStack.isEmpty() == false) {
                System.out.println("Item popped : "+aStack.pop());
            }
            try
            {
                System.out.println("Pop an empty Stack - aStack ");
                aStack.pop();
            } catch (LinkedListException le)
            {
                System.out.println(le.getMessage());
            }
            System.out.println();
            System.out.println("Size of empty aStack : "+ aStack.size());
           System.out.println("Check if aStack is empty: "+ aStack.isEmpty());   


        } catch (LinkedListException le)
        {
            System.out.println(le.getMessage());
        }
        
        
        System.out.println("***** End Stack Tests *******");
        System.out.println();
    }
       
   }
   
   

