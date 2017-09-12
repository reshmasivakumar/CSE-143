
/**
 * BubbleSort.java - Class representing BubbleSort 
 * 
 * @author Reshma Sivakumar  
 * @version  1.0 03/04/2016
 *
 * Description: This subclass extends the parent abstract class Sort. This class
 *              overrides the following methods:-
 *                  - swap () : which swaps the elements in an int array
 *                  - sort () : which sorts the elements in an int array
 *                    using the following BubbleSort algorithm.
 *                      - Do until sorted
 *                      - For every element in the array
 *                          - Is the next element in the array smaller than current element
 *                              - If so, swap the elements
 *                      - loop
 *              
 * Class Invariants:
 *              - int array passed cannot be null or empty.
 *              - Indices passed should be positive.
 *              - first index passed cannot be greater than the second index passed.
 */

public class BubbleSort extends Sort
{
    /**
     * Method:         swap
     * Purpose:        Method that takes in an integer array and two
     *                 indices and swaps the elements in these indices.
     * 
     * @param          data - int array to sort
     *                 idx1 - int value representing an index in the
     *                        input array
     *                 idx2 - int value representing another index in
     *                        the input array.
     *              
     * @preconditions  none.
     * @postconditions elements in the specified indices of the input
     *                 array are swapped
     * @return         void
     */
    @Override
    public void swap ( int[] data, int idx1, int idx2 )
    {
        super.swap (data, idx1, idx2);
    }
    
    /**
     * Method:         sort
     * Purpose:        Overriden method which implements the Bubble sort
     *                 algorithm. 
     *                 - Do until sorted
     *                      - For every element in the array
     *                          - Is the next element in the array smaller than current element
     *                              - If so, swap the elements
     *                 - loop
     * 
     * @param          data - int array to sort
     *                 first - int value representing starting index
     *                 last - int value representing last index.
     *              
     * @preconditions  Unsorted int array.  
     * @postconditions Sorted int array
     * @return         void
     */
    @Override
    public void sort(int[] data, int first, int last)
    {
        if (data == null || data.length == 0)
            throw new NullPointerException("Nothing to sort. Empty array passed");
        
        // first index and last index cannot be less than 0
        // first index should be less than last 
        if ( first < 0 || last < 0 || (first > last) )
            throw new RuntimeException ("Invalid index passed");
        
        if ( first > data.length || last > data.length)
             throw new RuntimeException ("Invalid index passed");
             
        // outer loop for each element in the array    
        for ( int i = 0; i < data.length-1; i++ )
        {
            // inner loop for comparing the adjacent elements and swapping
            for ( int j = 0; j < data.length - 1-i ; j ++ )
            {
                // check if current element is greater than the next element
                if ( data[j] > data [j+1] )
                {
                    // swap elements
                    swap (data, j, j+1 );
                    // increment the comparison counter
                    super.incrementComparisons();
                }
                // This is for the last comparison which became false 
                super.incrementComparisons();    
            }
        }
    }
}
