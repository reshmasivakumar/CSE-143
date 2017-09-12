
/* ItemNotFoundException.java: Custom Exception Class implementation.
 *
 * @Description : This ItemNotFoundException class extends from
 *                Exception class. It has only 2 constructors,
 *                one default which displays a generic message
 *                and the displays the input string.
 *                This class is used in BinarySearch and 
 *                LinearSearch classes to report an exception
 *                when item is not found.
 *                       
 * 
 * @author:     Reshma Sivakumar
 * @ version:   11/26/2105
 */
public class ItemNotFoundException extends Exception
{
    /**
    * Method :          Default Constructor
    * Purpose :         Constructs an ItemNotFoundException object 
    *                   which displays a generic default message.
    * 
    * @param            None.
    * @preconditions    None.
    * @postconditions   None.
    */   
    public ItemNotFoundException()
    {
      super("Item Not Found Exception");
    }
    
    /**
    * Method :          Constructor
    * Purpose :         Constructs an ItemNotFoundException
    *                   object which
    *                   displays the specified  message.
    * 
    * @param            None.
    * @preconditions    None.
    * @postconditions   None.
    */ 
    public ItemNotFoundException(String message)
    {
      super(message);
    }
}
