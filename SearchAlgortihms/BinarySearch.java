/* BinarySearch.java: Class to search using Binary search.  
*
* @Description : This class is used to search for target word 
*                from the given longwords.txt. The class 
*                implements a recursive and iterative 
*                searches to accomplish this.
*                The following algorithm is used for
*                Binary seach:-
*                "LowIndex = 0
*                 HighIndex = arraySize – 1
*                 While LowIndex is less than or equal to HighIndex.
*                 Set MidIndex to be equal to half way between the 
*                 low and high index.
*                 If the target word matches the word at MidIndex, 
*                 return MidIndex (first case).
*                 If the target word is before the word at MidIndex, 
*                 then set HighIndex to MidIndex - 1.
*                 If the target word is after the word at MidIndex, 
*                 then set LowIndex to MidIndex + 1.
*                 If the target word was not found,
*                 throw an ItemNotFoundException. "
*                 
* Class Invariants: longwords.txt should exist with words
* 
* @author:     Reshma Sivakumar
* @ version:   11/26/2015
*/
public class BinarySearch extends SearchAlgorithm
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
                
       int lowIndex = 0;
       int highIndex = words.length - 1;
       int midIndex = 0;
       int retVal = -1;

       while ( lowIndex <= highIndex )
       {
           super.incrementCount();
           midIndex = ( ( highIndex + lowIndex ) / 2 );
           if ( wordToFind.equals ( words[midIndex] ) )
           {
               retVal = midIndex;
               break;
           }
           else if ( wordToFind.compareTo ( words[midIndex]) > 0 ) //if greater
           {
               lowIndex = midIndex + 1;
           }
           else
           {
               highIndex = midIndex - 1;
           }
       }
      
       if ( retVal == -1 )
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
       return recSearch(words, wordToFind, 0, words.length-1);
   }
   
   private int recSearch(String[] words, String wordToFind, int lowIndex, 
							int highIndex) throws ItemNotFoundException
   {
       int midIndex =  ( ( highIndex + lowIndex ) / 2 );  
       
       if ( lowIndex > highIndex )
            throw new ItemNotFoundException();
       
       if ( wordToFind.equals ( words[midIndex] ) )
       {
          super.incrementCount();
          return midIndex;
       }
       else if ( wordToFind.compareTo ( words[midIndex]) > 0 ) // if greater
       {
          
            super.incrementCount();
           lowIndex = midIndex + 1;
           return  recSearch ( words, wordToFind, lowIndex, highIndex );
       }
       else
       {

            super.incrementCount();
           highIndex = midIndex - 1;
           return  recSearch ( words, wordToFind, lowIndex, highIndex );
       }
   }
}
