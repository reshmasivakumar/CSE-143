/*
 *  Driver File to test the methods in the Queue, Stack and ArrayList Classes.
 
 * ArrayBasedDataStructuresDriver.java  
 * 
 * Descripion: This is a driver class that is used to test the methods of the 
 *              Queue, Stack and ArrayList datastructure implementations. 
 *              This driver tests all the  methods of the above classes for 
 *              both positive and negative test conditions.
 *              Please uncomment the appropriate lines for testing negative 
 *              conditions.
 *              
 * @author Reshma Sivakumar  
 * @version  1.0 10/24/2015
 *
 * 
 */

public class ArrayBasedDataStructuresDriver {

    public static void main(String[] args) {
       stackTests();
       queueTests();
       arrayListTests();
    }

    private static void arrayListTests() {

        System.out.println("***** ArrayList Tests *******");     
        ArrayList aList = new ArrayList();
        ArrayList bList = new ArrayList();
        ArrayList cList = new ArrayList();
        ArrayList dList= new ArrayList();
         
        try 
        {
            System.out.println("Initial Capacity "+ ArrayList.getInitialCapacity());
            System.out.println("Create ArrayList aList");
            aList.insert('B', 0);
            aList.insert('a',0);
            aList.insert('t',1);
            aList.insert('s',1);
            aList.insert('f',8);
            System.out.println("ArrayList aList "+ aList.toString());
      
            System.out.println("Create ArrayList bList");
            bList.insert('B', 0);
            bList.insert('a',0);
            bList.insert('t',1);
            bList.insert('s',1);
            bList.insert('f',8);
            System.out.println("ArrayList bList "+ bList.toString());
            
            System.out.println("Checking if arrayList resize -create cList");
 
            cList.insert('k',0);
            cList.insert('s',1);
            cList.insert('i',1);
            cList.insert('t',2);
            cList.insert('e',3);
            System.out.println("ArrayList cList "+ cList.toString());  
            
            System.out.println("Append to CList");
            cList.add('s');            
            System.out.println("ArrayList cList "+ cList.toString());  
            
            System.out.println("Element at aList(2): "+aList.get (2));
            System.out.println("Element at bList(3): "+bList.get (3));
            
            System.out.println("Index of aList('B'): "+aList.indexOf('B'));
            System.out.println("Index of cList('e'): "+cList.indexOf('e'));
            System.out.println("Index of cList('z'): "+cList.indexOf('z'));
        
            System.out.println("aList equals bList?: "+aList.equals(bList));
            System.out.println("bList equals cList?: "+bList.equals(cList)); 

            System.out.println("cList.get(2) "+cList.get(2)); 
            System.out.println("Size of bList "+bList.size());
            System.out.println("Remove all elements in list");
            while(aList.isEmpty() == false) {
                System.out.println("remove : "+aList.remove(0));
            }
            System.out.println("Remove element in empty list"); 
           
            // Comment each condition to test negative conditions
            System.out.println("Trying to insert null value to list");
            aList.insert(null,-1); 
            System.out.println("Negative index specified");
            aList.insert('t',-1);
            System.out.println("Negative index aList(-1): "+aList.get (-1));
            System.out.println("Index of cList(null): "+cList.indexOf(null));
            System.out.println("Higher index cList.get(12) "+cList.get(12));            
            System.out.println(aList.remove(0));
        }catch (NullPointerException ne)
        {
            System.out.println(ne.getMessage());
        }catch (RuntimeException re)
        {
             System.out.println(re.getMessage());
        }
       System.out.println("***** ArrayList Tests Ends ******* ");
       System.out.println();
       
    }
    
   
    private static void queueTests() {

       System.out.println("***** Queue Tests *******");      
       try
       {
           Queue aQueue = new Queue();
           Queue bQueue = new Queue();
           Stack stack1 = new Stack();
           aQueue.enqueue('B');
           aQueue.enqueue('a');
           aQueue.enqueue('t');
           System.out.println("Printing aQueue");
           System.out.println(aQueue.toString());  
           
           bQueue.enqueue('C');
           bQueue.enqueue('a');
           bQueue.enqueue('t');           
           System.out.println("Printing aQueue");
           System.out.println(bQueue.toString());
           
           System.out.println("size "+aQueue.size());
           System.out.println("aQueue equals bQueue?: " + aQueue.equals(bQueue));
           System.out.println("aQueue equals null?: " + aQueue.equals(null));
           System.out.println("aQueue equals stack1?: " + aQueue.equals(stack1));
           
           System.out.println("dequeue all elements");
           
           while(aQueue.isEmpty() == false) {
               System.out.println("dequeue: "+ aQueue.dequeue());
           }
           
           //Comment each condition to Test negative conditions
           System.out.println("Trying to dequeue empty queue");
           aQueue.dequeue();
           aQueue.enqueue(null);        
           
      } catch (RuntimeException re)
      {
          System.out.println(re.getMessage());
      }
       System.out.println("***** End Queue Tests *******");
       System.out.println();
     }
    
    private static void stackTests() {
 
        System.out.println("***** Stack Tests *******");
        try
        {
            Stack aStack = new Stack();
            Stack bStack = new Stack();
            Stack cStack = new Stack();
            Stack dStack = new Stack();
            Stack eStack = new Stack();
            Stack fStack = new Stack();
            Queue queue1 = new Queue();
 
            aStack.push ('B');
            aStack.push('a');
            aStack.push('t');
        
            bStack.push('B');
            bStack.push('a');
            bStack.push('t');
        
            cStack.push("Fun");
            cStack.push("is");
            cStack.push("Java");
        
            dStack.push(1);
            dStack.push(2);
            dStack.push(3);
        
            System.out.println("Size of aStack:" + aStack.size());
            System.out.println("Stack aStack: "+aStack.toString());
            System.out.println("Stack bStack: "+bStack.toString());  
            System.out.println("Stack cStack: "+cStack.toString());
            System.out.println("Stack dStack: "+dStack.toString());
            System.out.println("Stack eStack: "+eStack.toString());
			
			System.out.println("Check following stack objects equal");
            System.out.println("aStack & bStack?: " + aStack.equals(bStack));
            System.out.println("bStack & cStack?: " + bStack.equals(cStack));
            System.out.println("aStack & cStack?: " + aStack.equals(cStack));
            System.out.println("aStack & eStack?: " + aStack.equals(eStack));
            System.out.println("aStack & null?: " + aStack.equals(null));
            System.out.println("Comparing 2 empty stacks ");
            System.out.println("eStack & fStack equal?: " + eStack.equals(fStack));
            System.out.println("eStack & queue1 equal?: " + eStack.equals(queue1));
            
            System.out.println("Pop all elements in Stack aStack:");
            while(aStack.isEmpty() == false) {
                System.out.println("pop : "+aStack.pop());
            }
            // Comment each condition to test negative conditions
            System.out.println("Trying to pop Stack a when empty "+aStack.pop());
            System.out.println("Trying to insert null value to Stack");
            aStack.push(null); 
            
            
        } catch (RuntimeException re)
        {
            System.out.println(re.getMessage());
        }
        
        
        System.out.println("***** End Stack Tests *******");
        System.out.println();
    }
    

}
