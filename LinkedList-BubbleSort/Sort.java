import java.util.Arrays;
/*
 * Sort Class - abstract parent class which defines the minimum requirements
 * to be a sort.  Subclasses must inherit from and implement the abstract methods below. 
 * Look in the main driver for example usage for your sorts.  Start by building a 
 * Bubble Sort, and comment out other Quick Sort code below to test your
 * first sort class independently before moving on to the more complex
 * Quick Sort subclass.
 * 
 * Author: Rob Nash
 * Updated by: Reshma Sivakumar
 * Date: 03/04/2016
 */

public abstract class Sort {
    
    //TODO: you override this method with a concrete (ie, not abstract) sort mechanism
    /**
     * Method:         sort
     * Purpose:        Abstract method which will be overridden
     *                 in sub-classes.This method is used to sort 
     *                 an int array in ascending order.
     * 
     * @param          data - int array to sort
     *                 first - int value representing starting index
     *                 last - int value representing last index.
     *              
     * @preconditions  Unsorted int array.  
     * @postconditions Sorted int array
     * @return         void
     */
    public abstract void sort(int[] data, int first, int last);  //[first,...,last]
    
    //TODO: override this method with a concrete (ie, not abstract) swap mechanism
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
    public void swap(int[] data, int idx1, int idx2)
    {
        int temp = data[idx1];
        data[idx1] = data[idx2];
        data[idx2] = temp;
    }
    
    /**
     * Method:         main
     * Purpose:        Main method to test the BubbleSort and
     *                 QuickSort for different int arrays.
     * 
     * @param          args - String array 
     *              
     * @preconditions  none.
     * @postconditions none
     * @return         void
     */  
    public static void main(String[] args) {
        /* Choose your data set below */
        System.out.println ("Positive Test Cases");
        System.out.println ("-------------------");
        System.out.println();
        int[] input = {3,1,5,18,23,25,4,14};
        int[] input2 = {1,5,2,4,3,6,9,7,8,2};
        int[] input3 = {13,1,60,59,52,23,31};     
        int[] input4 = {1};
        int[] input5 = {3,1,5,18,23,25,4,0};
        int[] input6 = {3,1,5,18,23,25,4,0,-1};
        /* add or comment/uncomment your sort below */
        displaySortResults(new QuickSort(), input);
        displaySortResults(new BubbleSort(), input2);
        displaySortResults(new QuickSort(), input3);
        displaySortResults(new BubbleSort(), input4);
        displaySortResults(new QuickSort(), input5);
        displaySortResults(new BubbleSort(), input6);
        System.out.println();
        System.out.println ("Negative Test Cases");
        System.out.println ("-------------------");
        System.out.println();
        try
        {
           System.out.println("Passing null array for QuickSort");  
           int[] nullArray = null;
           displaySortResults(new QuickSort(), nullArray);
        } catch ( NullPointerException ne )
        {
            System.out.println(ne.getMessage());
        }
        
        try
        {
           System.out.println("Passing null array for BubbleSort");  
           int[] nullArray = null;
           displaySortResults(new BubbleSort(), nullArray);
        } catch ( NullPointerException ne )
        {
            System.out.println(ne.getMessage());
        }
        
        try
        {
           System.out.println("Passing empty array for QuickSort");  
           int[] emptyArray = {};
           displaySortResults(new QuickSort(), emptyArray);
        } catch ( NullPointerException ne )
        {
            System.out.println(ne.getMessage());
        }
        
        try
        {
           System.out.println("Passing empty array for BubbleSort");  
           int[] emptyArray = {};
           displaySortResults(new BubbleSort(), emptyArray);
        } catch ( NullPointerException ne )
        {
            System.out.println(ne.getMessage());
        }
        
        try
        {
            System.out.println("Calling sort method with invaid index in QuickSort");
            int[] negArray = { 3, 76, 8, 50};
            QuickSort qs = new QuickSort();
            qs.sort (negArray, -1, 3);
        } catch ( RuntimeException re )
        {
             System.out.println(re.getMessage());
        }
    }
    
    /**
     * Method:         displaySortResults
     * Purpose:        Method is used to keep display the input unsorted
     *                 integer array in sorted ascending order. The sort 
     *                 method that will be used for sorting will depend 
     *                 on the sort class passed in as input. The input
     *                 sort class is a super class and therefore any 
     *                 subclass of this Sort super class can be passed 
     *                 as input. This demonstrates the polymorphic nature
     *                 of this method. This method will also output the
     *                 total number of operations (comparisons) executed
     *                 by the sort algorithm passed.
     * 
     * @param          sorter - Subclass object of Sort super class.
     *                 data - int array to sort.
     *                 
     * @preconditions  Array is not null and is an unsorted int array.
     * @postconditions sorted array displayed
     * @return         void
     */
    
    public static void displaySortResults(Sort sorter, int[] data) 
    {
        // check if input values are valid.
        if (data == null || data.length == 0 || sorter == null)
            throw new NullPointerException("Nothing to sort. Empty array passed");
        
        sorter.resetComparisons(); // reset comparison counter to 0.
        
        // Print the unsorted array using the Java in-built Array class
        System.out.println(Arrays.toString(data));             
        
        // Calling the sort method of the input Sort class. Depending on 
        // the sort object passed, the corresponding class's sort method
        // will be called. This shows late binding or polymorphism
        sorter.sort(data, 0, data.length-1);
        
        // Print the`sorted array using the Java in-built Array class
        System.out.println(Arrays.toString(data));
        // Display the name of the Sort subclass being called.
        System.out.print(sorter.getClass().toString());
        // Display the total number of operations (comparisons) execute
        // by the sort algorithm passed.
        System.out.println(",Comparisons: " + sorter.getComparisons()+"\n\n");
    }

    //Don't make changes to the code below.  What does the final modifier do?
    
    private int comparisons=0;
    
    // final modifier will prevent the method from being overriden.
     /**
     * Method:         getComparisons
     * Purpose:        Final method that returns the total number of 
     *                 operations (comparisons) execute by the sort
     *                 algorithm called. 
     * 
     * @param          none. 
     *              
     * @preconditions  none.
     * @postconditions none.
     * @return         int value representing the total number of 
     *                 operations (comparisons) execute by the sort
     *                 algorithm called. 
     */  
    public final int getComparisons() {
        return comparisons;
    }
    
     /**
     * Method:         resetComparisons
     * Purpose:        Final method that initializes the comparisons
     *                 counter to 0.
     * 
     * @param          none. 
     *              
     * @preconditions  none.
     * @postconditions none.
     * @return         void.
     */ 
    public final void resetComparisons() {
        comparisons = 0;
    }
    
    /**
     * Method:         incrementComparisons
     * Purpose:        Final method that increments the comparisons
     *                 counter.
     * 
     * @param          none. 
     *              
     * @preconditions  none.
     * @postconditions none.
     * @return         void.
     */ 
    public final void incrementComparisons() {
        comparisons++;
    }
}