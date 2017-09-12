/* LinearSearch.java: Class to search using Linear search.  
*
* @Description : This class is used to search for target word 
*                from the given longwords.txt. The class 
*                implements a recursive and iterative 
*                searches to accomplish this.
*                The following algorithm is used for
*                Linear seach:-
*                "loop through the words from beginning to end,
*				   comparing the current string with the target
*			       string at each step.
*                 If the target word was not found,
*                 throw an ItemNotFoundException. "
*                 
* Class Invariants: longwords.txt should exist with words
* 
* @author:     Reshma Sivakumar
* @ version:   11/26/2015
*/
public class LinearSearch extends SearchAlgorithm
{
	
   /**
    * Method :          search
    * Purpose :         To iteratively search a specified word
    *                   in the specified words array.The 
    *                   method calls incrementCount()
    *                   of SearchAlgorithm class to record
    *                   the number of comparisons
    *                   made.
    *                   
    * @param            words - String array containing words
    *                   from longwords.txt.
    * @param            wordToFind - String value for word to
    *                   find.
    * @preconditions    words array should not be null 
    * @postconditions   None
    *                 
    * @returns          int - index of the array where  
    *                   the match is found. 
    * @throws           ItemNotFoundException when the wordToFind
    *                   is not found.
    * @throws           NullPointerException when input array
    *                   is null.
    */
 	
   public int search(String[] words, String wordToFind) throws 
										ItemNotFoundException
   {
       if ( words == null )
          throw new NullPointerException ("Input array is null");
       
       int retVal = -1;
       int index = 0;
        
       while ( index <= words.length-1 )
       {
           super.incrementCount();
           if ( ! ( words[index].equals ( wordToFind ) ) )
           {    
               index ++;
           }
           else
           {
               retVal = index;
               break;
           }
       }
       
       if (retVal == -1)
            throw new ItemNotFoundException();
            
       return retVal;
   }

   /**
    * Method :          recSearch
    * Purpose :         To recursively search a specified word
    *                   in the specified words array.The 
    *                   method calls incrementCount()
    *                   of SearchAlgorithm class to record
    *                   the number of comparisons
    *                   made.
    *                   
    * @param            words - String array containing words
    *                   from longwords.txt.
    * @param            wordToFind - String value for word to
    *                   find.
    * @preconditions    words array should not be null 
    * @postconditions   None
    *                 
    * @returns          int - index of the array where  
    *                   the match is found. 
    * @throws           ItemNotFoundException when the wordToFind
    *                   is not found.
    * @throws           NullPointerException when input array
    *                   is null.
    */   
   public int recSearch(String[] words, String wordToFind ) throws
											ItemNotFoundException
   {
       return recSearch(words, wordToFind, 0); 
   }
   
   private int recSearch(String[] words, 
              String wordToFind, int index ) throws 
											ItemNotFoundException
   {
       if ( index >= words.length-1 )
          throw new ItemNotFoundException();
      // System.out.println (index);  
       super.incrementCount();
       if ( ! ( words[index].equals ( wordToFind ) ) )
       {    
              index = index ++;
              return recSearch(words, wordToFind, index); 
       }
       else
       {
           return index;
       }   
       
   }
}
