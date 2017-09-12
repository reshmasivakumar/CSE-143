/* Driver.java: Class to test FindFile class methods 
*
* @Description : This class is used to test the FindFile
*                class methods. FindFile class is used to
*                search a specified target file in a directory
*                and its sub directories. 
*                 
* Class Invariants:  File searched and directory searched should
*                   be valid. 
* 
* @author:     Reshma Sivakumar
* @ version:   11/26/2015
*/
public class Driver
{
    
    /**
    * Method :          main
    * Purpose :         This method searches tests the methods of 
    *                   FindFile class. The tests are run with 
    *                   positive and negative test cases to see
    *                   if data is output correctly and exceptions
    *                   are caught.

    * @throws           IllegalArgumentException when the invalid
    *                   values given for target name or directoryname
    * @throws           RuntimeException when  MAX_NUMBER_OF_FILES_TO_FIND
    *                   is reached.
    */

    public static void main( String[] args )
    {
        String targetFile = "";
        
        try
        {
            System.out.println("Searching file which is one occurence");
            FindFile fileSearch = new FindFile( 6 );
            targetFile = "ObjectList.java";
            String dirName = "C:\\Documents";
            System.out.println ( "Searching dir is " + dirName +
                                    " max file is 6");
            fileSearch.directorySearch ( targetFile, dirName);
            System.out.println ( "Number of occurances of " + 
                                    targetFile+
								" is "+ fileSearch.getCount());
                            
            fileSearch.getFiles();
            System.out.println ( "List of matching file locations for: " 
										+ targetFile);
            fileSearch.printMatchingFilePaths();
        
         }
        catch (IllegalArgumentException ie )
        {
            System.out.println(ie.getMessage());
        }catch ( RuntimeException re )
        {
             System.out.println(re.getMessage());
        }
        
        System.out.println();        
        try
        {
            FindFile fileSearch = new FindFile( 6 );
            targetFile = "Fraction.java";
            String dirName = "C:\\Documents";
            System.out.println ( "Searching dir is " + dirName +
                                    " max file is 6");
            fileSearch.directorySearch ( targetFile, dirName);
            System.out.println ( "Number of occurances of " + 
                                    targetFile+
								" is "+ fileSearch.getCount());
                            
            fileSearch.getFiles();
            System.out.println ( "List of matching file locations for: " 
										+ targetFile);
            fileSearch.printMatchingFilePaths();
        
         }
        catch (IllegalArgumentException ie )
        {
            System.out.println(ie.getMessage());
        }catch ( RuntimeException re )
        {
             System.out.println(re.getMessage());
        }
        
        System.out.println();
        try
        {
            FindFile fileSearch = new FindFile( 4 );
            targetFile = "Fraction.java";
            String dirName = "C:\\Documents";
            System.out.println ( "Searching dir is " + dirName +
									" max file is 5");
            fileSearch.directorySearch ( targetFile, dirName);
            System.out.println ( "Number of occurances of " + 
									targetFile+ " is "+
                            fileSearch.getCount());
            fileSearch.getFiles();
            System.out.println ( "List of matching file locations for: "
										+ targetFile);
            fileSearch.printMatchingFilePaths();
            System.out.println();
         }
        catch (IllegalArgumentException ie )
        {
            System.out.println("Exception "+ ie.getMessage());
        }catch ( RuntimeException re )
        {
             System.out.println("Exception "+ re.getMessage());
        }        

        System.out.println();        
        try
        {
            System.out.println("Testing with non existent target file" );
            FindFile fileSearch1 = new FindFile( 50 );
            targetFile = "FileNotThere";
            fileSearch1.directorySearch ( targetFile, "C:\\Documents" );
            System.out.println("Number of occurances of " + targetFile+ 
										" is "+ fileSearch1.getCount());
            fileSearch1.getFiles();
            System.out.println("List of matching file locations for: " 
														+ targetFile);
            fileSearch1.printMatchingFilePaths();
            System.out.println();
        }
        catch (IllegalArgumentException ie )
        {
            System.out.println("Exception "+ ie.getMessage());
        }catch ( RuntimeException re )
        {
             System.out.println("Exception "+ re.getMessage());
        }
       
        System.out.println();
        try
        {
            System.out.println("Testing with null target file" );
            FindFile fileSearch1 = new FindFile( 50 );
            targetFile = null;
            fileSearch1.directorySearch ( targetFile, "C:\\Documents" );
            System.out.println("Number of occurances of " + targetFile+ " is "+
                                                    fileSearch1.getCount());
            fileSearch1.getFiles();
            System.out.println("List of matching file locations for: " 
															+ targetFile);
            fileSearch1.printMatchingFilePaths();
            System.out.println();
        
        }catch (IllegalArgumentException ie )
        {
            System.out.println("Exception "+ ie.getMessage());
        }catch ( RuntimeException re )
        {
             System.out.println("Exception "+ re.getMessage());
        }
        
        System.out.println();
        try
        {
            System.out.println("Testing with non existent directory" );
            FindFile fileSearch2 = new FindFile( 50 );
            targetFile = "Stack.java";
            fileSearch2.directorySearch ( targetFile, "C:\\DirNotThere" );
            System.out.println("Number of occurances of " + targetFile+ " is "
												+ fileSearch2.getCount());
            fileSearch2.getFiles();
            System.out.println("List of matching file locations for: " 
															+ targetFile);
            fileSearch2.printMatchingFilePaths();
             System.out.println();
        }
        catch (IllegalArgumentException ie )
        {
            System.out.println("Exception "+ ie.getMessage());
        }catch ( RuntimeException re )
        {
             System.out.println("Exception "+ re.getMessage());
        }
        
        System.out.println();        
         try
        {
            System.out.println("Testing with null directory" );
            FindFile fileSearch2 = new FindFile( 50 );
            targetFile = "Stack.java";
            fileSearch2.directorySearch ( targetFile, null );
            System.out.println("Number of occurances of " + targetFile+ " is "+ 
													fileSearch2.getCount());
            fileSearch2.getFiles();
            System.out.println("List of matching file locations for: " +
														targetFile);
            fileSearch2.printMatchingFilePaths();

        }
        catch (IllegalArgumentException ie )
        {
            System.out.println( "Exception "+ ie.getMessage());
        }catch ( RuntimeException re )
        {
             System.out.println( "Exception " + re.getMessage());
        }
    }
}
