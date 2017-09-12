/**
 * FractionV2.java - Driver Class
 * 
 * @author Reshma Sivakumar  
 * @version  1.0 10/21/2015
 *
 * Description: This is a driver class that will provide methods for reading 
 *              any input text file of any size that contains fractions. The 
 *              fractions read will be added to list of FractionCounter objects
 *              The list will contain only unique fractions and the count of 
 *              each fraction in the file. The fractions will be reported in
 *               its reduced form. 
 *
 *
 */
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class FractionV2 
{
    /**
    * Method :          main
    * Purpose :         Call methods to get the input file name from user and 
    *                   contruct the unique fractionCounter object list and 
    *                   print the fraction in reduced form with the count of 
    *                   occurence in the file.
    * 
    */  
    public static void main ( String[] args )
    {
        ObjectList objectList = new ObjectList(); 
        //Get name of file
        Scanner keyboard = new Scanner(System.in);
        String inputFileName = "";
      
        // Loop till user inputs a file name
        while ( inputFileName.length() <= 0 )
        {
            //Prompting file name from user
            System.out.println("Enter input file name with fractions");
            //Read the file name from console
            inputFileName = keyboard.next();
        }
        System.out.println();
        createList (inputFileName, objectList); 
        objectList.printList ();
    }
    
    /**
    * Method :          createList
    * Purpose :         Reads the input file and create the list of 
    *                   fractionCounter objects.
    * 
    * @param            inputFileName - text file name that contains the
    *                   fractions.
    * @preconditions    None.
    * @postconditions   The contents in input file will be read using scanner
    *                   and the numerator and denomintaor of the read fraction
    *                   will be used to create the Fraction object. The new
    *                   fraction object will be stored in the reduced form. The 
    *                   fraction object will be added to the FractionCounter
    *                    object list only if it is not already added. 
    * @throws           NumberFormatException -  fractions with large values
    *                   IllegalArgumentException - fractions with denominator 0
    *                   
    */  
    public static void createList(String inputFileName, ObjectList objectList)
    {    
        Scanner inputFile = null;
        int numerator = 0;
        int denominator = 0;
        // Create Scanner object for the input file to read the fractions
        try 
        {
            inputFile = new Scanner(new FileInputStream (inputFileName) );
        } catch ( FileNotFoundException e ) 
        {
              System.out.println("Error opening File!");
              System.exit(0);
        }
       
        if (!inputFile.hasNextLine())
        {
            System.out.println("File is empty!");
            System.exit(0);
        }
        // Read each fraction as a line and split
        // to get the numerator and denominator
        while ( inputFile.hasNextLine() ) 
        {
            try 
            {
                String line = inputFile.nextLine();
                String str = new String(line).trim();
                String[] strSplit = str.split("/");
                int splitLength = str.length();
                // Convert String numerator to int and store in numerator 
                if (splitLength > 0 )
                {
                  numerator = Integer.parseInt(strSplit[0]); 
                  if (splitLength > 1 ) 
                  {
                    // Convert String denominator to int
                    // and store in denominator
                    denominator = Integer.parseInt(strSplit[1]);
                   }
                   else
                    denominator = 1; 
                   //create fraction object with numerator and denomintor read
                   Fraction f1 = new Fraction(numerator,denominator);
                   FractionCounter fc1 = new FractionCounter(f1);
                   //check if objectlist already contains the fraction read
                   //if not add it to list.
                  if (!objectList.contains(f1) )
                  {
                    objectList.add(fc1);
                  }
                  else
                  {    
                    // If exists, get the object from the object list array
                    // and compare and increment the counter of that object
                    int index = objectList.indexOf(f1);
                    FractionCounter temp = null;
                    temp = (FractionCounter)(objectList.get(index));
                    if (index > -1) 
                        temp.compareAndIncrement(f1);
                  } 
                 }
          
            } catch (NumberFormatException ne)
            {
                //Fractions read with large values will be skipped
                System.out.println("Skipping fraction too large to handle!");
            }
             
            catch (IllegalArgumentException e)
            {
                //Fractions read with denominator 0 will be skipped
                System.out.println("Skipping fraction with denominator 0!");
            }
        }
        inputFile.close();
    }
}
   