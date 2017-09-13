
/* LinkedListException.java: Custom Exception Class implementation.
 *
 * @Description : This LinkedListException class extends from
 *                Exception class. It has only 2 constructors,
 *                one default which displays a generic message
 *                and the displays the input string.
 *                This class is used for List class and its 
 *                subclasses.
 *              
               
 * 
 * @author:     Reshma Sivakumar
 * @ version:   1  02/22/2016
 */

public class LinkedListException extends Exception
{
    /**
    * Method :          Default Constructor
    * Purpose :         Constructs an LinkedException object which
    *                   displays a generic default message.
    * 
    * @param            None.
    * @preconditions    None.
    * @postconditions   None.
    */   
    public LinkedListException()
    {
        super ("List Exception");
    }

    /**
    * Method :          Constructor
    * Purpose :         Constructs an LinkedException object which
    *                   displays the specified  message.
    * 
    * @param            None.
    * @preconditions    None.
    * @postconditions   None.
    */  
    public LinkedListException(String message)
    {
        super (message);
    }
}
