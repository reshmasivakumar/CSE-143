
/**
 * ObjectList.java - Class representing list of Objects
 * 
 * @author Reshma Sivakumar  
 * @version  1.0 10/21/2015
 *
 * Description: This class provides the data and methods to create and
 *				process a list of Objects that can grow as required.
 * 				 
 *
 *
 */
public class ObjectList
{
    private Object[] objectList; //can store objects of any type
    private int numElements;	 //count of objects stored
    
	/**
	* Method : 			Default Constructor
	* Purpose : 		Constructs an empty object list with
	*					initial capacity as 100.
	* 
	* @param 			None.
	* @preconditions	None.
	* @postconditions	A new object list is created with object
	* 					array initialized to size as 100 and count to 0.
	*/   
    public ObjectList()
    {
      this.objectList = new Object[100]; 
      this.numElements = 0;
    }
     
	/**
	* Method : 			add
	* Purpose : 		To add the reference to the  specified object to the 
	*					list represented by this object. The list will 
	*					dynamically grow as needed.
	* 
	* @param 			newObj - reference to the specified object.
	* @preconditions	A valid object reference.
	* @postconditions	The specified object will be added to the list 
	*					represented by this object and the count of list
	*					is incremented by 1. If the current capacity of
	*					the list is reached, the object array will be 
	*					dynamically resized.
	*/  
    public void add(Object newObj)
    { 
		//check the capacity of the object array before adding
        if ( numElements < this.objectList.length )
            this.objectList[numElements++] = newObj;
        else
        {
			// resize the object array if current capactiy is reached
			//create another array with double of current capacity
			//copy values from current object array to new object array
			//set the new object array as the data member and add the
			//object passed to the add method
              Object[] tempObj = new Object[numElements * 2];
			  // array cloned to avoid privacy leak
              this.objectList = cloneArray( this.objectList, tempObj );
              this.objectList[numElements++] = newObj;
        }
    }
    

	/**
	* Method : 			size
	* Purpose : 		To return the number of elements in the list.
	* 
	* @param 			None.
	* @preconditions	None.
	* @postconditions	None.
	*/  
    public int size()
    {
        return this.numElements;
    }
    
	/**
	* Method : 			indexOf
	* Purpose : 		To return the index of the specified object in
	*					the list or -1 if not in the list.
	* 
	* @param 			target - the object to search for in the list.
	* @preconditions	None.
	* @postconditions	None.
	* @returns          index of the specified object in the list
	*					-1 if not in the list.
	*/  
    public int indexOf( Fraction target ) 
    {   
       int index = -1; 
       if ( contains ( target ) == true)
       {
          for ( int i = 0; i < this.numElements; i++ ) 
          {
              if (target.equals (get(i).getFraction()))
              {
                 index = i; 
                 break; 
              }
          }
       }
       return index;
    }
   
	/**
	* Method : 			contains
	* Purpose : 		To check if the specified object reference exists in
	*					the list represented by this object.
	* 
	* @param 			target - the object reference to search for in the list.
	* @preconditions	None.
	* @postconditions	None.
	* @returns          true - if specified object exists in the list
	*					false - otherwise
	*/  
    public boolean contains( Fraction target )
    {
      for (int i = 0; i < this.numElements; i++)
      {
          if (target.equals (get(i).getFraction()))
            return true;  
      }        
      return false;
    }
    
	/**
	* Method : 			get
	* Purpose : 		To return the list represented by this object.
	* 
	* @param 			None.
	* @preconditions	None.
	* @postconditions	None.
	* @returns          return the list represented by this object.
	*					
	*/  
    public Object[] get ()
    {
        return this.objectList;
    }

	/**
	* Method : 			get 
	* Purpose : 		To object that is stored in the index of the 
	*					 list represented by this object.
	* 
	* @param 			index of object in the list.
	* @preconditions	None.
	* @postconditions	None.
	* @returns          return the object stored in the specified index.
	*					
	*/  
    public FractionCounter get (int index)
    {
        return (FractionCounter)(this.objectList[index]);
    }
    
	/**
	* Method : 			toString
	* Purpose : 		To return the String representation of the 
	*					object represented by this list for printing.
	* 
	* @param 			None.
	* @preconditions	None.
	* @postconditions	None.
	* @returns			String representation of all the
	*					objects represented by this list.
	*/ 
    public String toString() 
    {
      String retVal = "";
      for(int i = 0; i < numElements; i++) 
      {
          if (objectList[i] != null)
            retVal += objectList[i] + " ";
      }
      return retVal;  
    }
    
	/**
	* Method : 			printList
	* Purpose : 		To print the list of objects 
	*					stored in this list to the console.
	* 
	* @param 			None.
	* @preconditions	None.
	* @postconditions	None.
	*/ 
    public void printList ()
    {
       for (int i = 0; i < this.numElements; i++)
       { 
            System.out.println(objectList[i]);
       }
    }
	
	/**
	* Method : 			cloneArray
	* Purpose : 		Helper methood to deep copy contents of the source array the  
	*					target array.
	* 
	* @param 			source - object array to be copied from.
	* @param 			target - object array to be copied to.	
	* @preconditions	source array should contain valid objects.
	* @postconditions	target array will contain the objects from source array.
	*/ 
    private Object[] cloneArray( Object[] source, Object[] target )
    {
        for ( int i = 0; i < source.length; i++ )
        {
            target[i] = source [i];
        }
        return target;
    }
    
}
