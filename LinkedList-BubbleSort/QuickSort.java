/**
 * QuickSort.java - Class representing QuickSort 
 * 
 * @author Reshma Sivakumar  
 * @version  1.0 03/04/2016
 *
 * Description: This subclass extends the parent abstract class Sort. This class
 *              overrides the following methods:-
 *                  - swap () : which swaps the elements in an int array
 *                  - sort () : which sorts the elements in an int array
 *                    using the following QuickSort algorithm.
 *                      - Pick an element, called a pivot, from the array.
 *                      - Partitioning: reorder the array so that all elements
 *                        with values less than the pivot come before the pivot, 
 *                        while all elements with values greater than the pivot
 *                        come after it (equal values can go either way). After 
 *                        this partitioning, the pivot is in its final position.
 *                      - Recursively apply the 
 *                        above steps to the sub-array of elements with smaller values
 *                        and separately to the sub-array of elements with greater values.
 *              
 * Class Invariants:
 *              - int array passed cannot be null or empty.
 *              - Indices passed should be positive.
 *              - first index passed cannot be greater than the second index passed.
 */
public class QuickSort extends Sort
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
        super.swap(data, idx1, idx2);
    }
   
     /**
     * Method:         sort
     * Purpose:        Overriden method which implements the Quick sort
     *                 algorithm. 
     *                 - Pick an element, called a pivot, from the array.
     *                 - Partitioning: reorder the array so that all elements
     *                   with values less than the pivot come before the pivot, 
     *                   while all elements with values greater than the pivot
     *                   come after it (equal values can go either way). After 
     *                   this partitioning, the pivot is in its final position.
     *                 - Recursively apply the 
     *                   above steps to the sub-array of elements with smaller values
     *                   and separately to the sub-array of elements with greater values.
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
        if ( first < 0 || last < 0 )
            throw new RuntimeException ("Invalid index passed");    
            
        if ( first > data.length || last > data.length)
            throw new RuntimeException ("Invalid index passed");
             
        if ((last-first) >= 1 )
        {
            int pivot = partition (data, first, last);
            sort (data, first, pivot);
            sort (data, pivot + 1, last);
        }
    }
    
    /**
     * Method:         partition
     * Purpose:        This method is used to partition the input array as below:-
     *                 - Partitioning: reorder the array so that all elements
     *                   with values less than the pivot come before the pivot, 
     *                   while all elements with values greater than the pivot
     *                   come after it (equal values can go either way). After 
     *                   this partitioning, the pivot is in its final position.
     *              
     * @param          data - int array to sort
     *                 first - int value representing starting index
     *                 last - int value representing last index.
     *              
     * @preconditions  Unsorted int array
     * @postconditions Sorted int array
     * @return         void
     */
    private int partition(int[] data, int start, int end) 
    {
        int i = start;
        int j = end+1;
        // set the pivot element
        int median = ( end) /2;
        int pivot = data[start];
        while (true) 
        {
            // scan the left item until data[i] < pivot to swap
            
            while (data[++i] < pivot) 
            {
                super.incrementComparisons();
                if (i == end) // 
                   break; 
            }
            super.incrementComparisons();
                
            //scan item on right of pivot to swap

            while (pivot < data[--j]) 
            {
               super.incrementComparisons();
               if (j == start)
                   break;
            }
            super.incrementComparisons();

            if (i >= j)  
                break; 

            swap(data, i, j); 
        }
        swap(data, start, j);
        return j;
    } 
}

