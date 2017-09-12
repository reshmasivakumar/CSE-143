import java.util.LinkedList;
import java.util.Iterator;
import java.util.Queue;

/* CSS 162
 * 
 * UsingStacksSuitorsLab
 * 
 * This class is mostly a driver for plaing with Strings as palindromes, 
 * both iteratively and recursively.  The UsingStacksSuitorsLab class itself is
 * a runnable object, so it can be passed to a thread in our Queue demo
 * 
 * 
 */

public class UsingStacksSuitorsLab   {
    private static int threadCount = 0;
    private String name;
    
    public UsingStacksSuitorsLab() {
        name = "#" + threadCount++ + "Thread";
    }
    
    public static void main(String[] args) {
        String s1 = "food";     //not a palindrome
        String s2 = "racecar";  //a palindrome
            
        System.out.println("String1 is \"" + s1 + "\"");
        System.out.println("String2 is \"" + s2 + "\"");
        
        System.out.println(s1 + " reversed is: ");
        printReverse(s1);
        System.out.println(s2 + " reversed is: ");
        printReverse(s2);
        System.out.println(s1 + " recursive reversed is: ");
        recPrintReverse(s1);
        System.out.println();
        System.out.println(s2 + " recursive reversed is: ");
        recPrintReverse(s2);
        System.out.println();
         
        System.out.println(s1 + " is a palindrome: " + isPalindrome(s1));
        System.out.println(s2 + " is a palindrome: " + isPalindrome(s2));
         
        System.out.println(s1 + " is a palindrome(recursively): " + isPalindromeRec(s1));
        System.out.println(s2 + " is a palindrome(recursively): " + isPalindromeRec(s2));   
       
        /*System.out.println("Did we build a Queue of Threads and start them? " + buildThreadQueue());
        int n = 6;
        System.out.println("For " + n + " suitors, stand in place:" + findPlaceToStand(n));
        n = 10;
        System.out.println("For " + n + " suitors, stand in place:" + findPlaceToStand(n));
        */
    }
    
        
    
    
     
    public static void printReverse(String target) {
        LLStack stack = new LLStack();
        char[] str = target.toCharArray();
        for (int i=0; i<str.length; i++)
        {
            stack.push(str[i]);
        }
        for (int i=0; i<str.length; i++)
        {
            System.out.print(stack.pop());
        }        
        System.out.println();
    }

   private  static void reverseString (LLStack obj )
   {
       if (obj.isEmpty())
        System.out.println ();
      
       else
       {
           System.out.print(obj.pop());
           reverseString(obj);
        }
       
    }
    
    
    public static void recPrintReverse(String target) {
        LLStack stack = new LLStack();
        char[] str = target.toCharArray();
       for (int i=0; i<str.length; i++)
        {
            stack.push(str[i]);
        }
        reverseString ( stack );
    }
     
    public static boolean isPalindrome(String input) {
        LLStack stack = new LLStack();
        char[] str = input.toCharArray();
        String reverseStr = "";
        for (int i=0; i<str.length; i++)
        {
            stack.push(str[i]);
        }
        for (int i=0; i<str.length; i++)
        {
            reverseStr += stack.pop();
        }     
        if (input.equals(reverseStr))
            return true;
        else
            return false;
    }

     public static boolean  isPalindromeRec(String sentence) {
        LLStack tempStack = new LLStack();
        LLStack origStack = new LLStack();
        LLStack reverseStack = new LLStack();
        char[] str = sentence.toCharArray();
       String reverseStr = "";
        for (int i=0; i<str.length; i++)
        {
            tempStack.push(str[i]);
            origStack.push(str[i]);
        }
   
        for (int i=0; i<str.length; i++)
        {
            
            reverseStack.push(tempStack.pop());
            
        }     
         
  
        
        return  isPalindromeRec(origStack, reverseStack);
    }
     
   public static boolean isPalindromeRec(LLStack origStack ,LLStack reverseStack ){
        if(origStack.size() == 0 || reverseStack.size() == 1)
             return true; 
        else
           5if (origStack.pop() == reverseStack.pop())
        
            return isPalindromeRec(origStack, reverseStack);

    
        return false;
    }
    
     
  

     
}
