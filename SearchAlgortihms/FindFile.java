import java.io.File;
    
/* FindFile.java: Class to search for a target file.  
*
* @Description : This class will recursively search a specified directory 
*                and all its subdirectories for a specified target file 
*                name. The constructor takes the maximum number of 
*                locations for that target file. 
*                The class has the following methods:
*                - getCount(): Returns the number of mathcing files found
*                - getFiles(): Returns array of matching file locations 
*                             upto maxFiles in size.
*                - printMatchingFilePaths(): Prints the matching file
*                                            locations.
*                   
* 
* Class Invariants:
*              - Cannot specify null values for target file name and
*                starting directory name.
*              - Valid directory name should be specified               
*                    
* 
* @author:     Reshma Sivakumar
* @ version:   11/26/2015
*/
    
public class FindFile
{
    /** Instance Variables **/
    
    // Maximum number of matching file locations
    private final int MAX_NUMBER_FILES_TO_FIND; 
    // Directory name
    private File path;
    // Number of matching files found
    private int fileCount;
    //Arraylist that contains matching files and count
    private ArrayList fileList;
    //Array to store matched files
    private String[] matchedFiles;
    
    /**
    * Method :          Constructor
    * Purpose :         Constructs that creates a FindFile object
    *                   and takes maximum number of files to find
    *                   as input parameter and initializes the 
    *                   instance variables.
    *                   
    * @param            maxFiles - int value
    * @preconditions    maxFiles should be greater than 0
    * @postconditions   A new FindFile object is created with
    *                   MAX_NUMBER_FILES_TO_FIND initialized 
    *                   to maxFiles and other instance 
    *                   variables initialized.
    *@throws            IllegalArgumentException if maxFiles is
    *                   not greater than zero.
    */ 
    public FindFile(int maxFiles)
    {
        if ( maxFiles <= 0 )
            throw new IllegalArgumentException ("Invalid input for maxFiles"); 
        this.MAX_NUMBER_FILES_TO_FIND = maxFiles;
        this.path = null;
        this.fileCount = 0;
        this.fileList = null;
        // Matched files array is created with size set to
        // MAX_NUMBER_FILES_TO_FIND
        this.matchedFiles = new String [ MAX_NUMBER_FILES_TO_FIND ];
    }
    
    /**
    * Method :          directorySearch
    * Purpose :         To recursively search a specified directory and
    *                   its subdirectories for a specified target file.
    *                   If it is a sub directory, it is recursively
    *                   searched. If it is a file, we check if the name
    *                   matches the specified target file name. If a 
    *                   match is found, the absolute path of the
    *                   matched location is added to an array. The 
    *                   method only searches for the target file upto
    *                   MAX_NUMBER_FILES_TO_FIND. The method stores 
    *                   the number of matches found in fileCount
    *                   instance variable.
    * 
    * @param            target - String value for file name
    * @param            dirName - String value for directory
    * @preconditions    target and dirName should not be null and
    *                   dirName should be a valid directory.
    * @postconditions   An array is created with the matched file
    *                   locations and the number of matched files
    *                   is recorded in filCount.
    *                 
    * @returns          None.
    * @throws           IllegalArgumentException when a null value 
    *                   is passed as directory or file name and when
    *                   directory name is not valid.
    *@throws            RuntimeException when Max number of files 
    *                   reached.                 
    */
    public void directorySearch ( String target, String dirName )
    {
        if ( target == null || dirName == null )
            throw new IllegalArgumentException
                      ("Null values cannot be specified as input");
        
        this.path =  new File("\\" + dirName + "\\");
      
        if ( ! ( path.isDirectory()))
            throw new  IllegalArgumentException
                      ("Invalid Directory");

        File[] files = this.path.listFiles();
        
        if ( files != null )
        {
          //System.out.println("Searching..."+this.path.getName());        
          for ( File current : files )
          {

                  if ( current.isDirectory () )
                  {
                      directorySearch ( target, current.getAbsolutePath() );
                  }
                  else
                  {
                      if ( (current.getName()).equals ( target ))
                      {
                          this.matchedFiles[fileCount] =
                             current.getAbsolutePath() ;
                          fileCount++;
                      }
                  }
                  if ( fileCount >=  MAX_NUMBER_FILES_TO_FIND )
                   throw new RuntimeException( "Max number of files reached!");
          }
        }
        else
            System.out.println(dirName + " is an empty directory");
    }
 
    /**
    * Method :          getCount
    * Purpose :         Return the number of matched files found
    * 
    * @param            None.
    * @preconditions    None.
    * @postconditions   None.
    * @returns          int value representing the number of 
    *                   matched files found. 
    */                   
    public int getCount ()
    {
        if ( this.fileCount <= 0 )
            System.out.println 
            ("The file being searched was not found in the system.");
        return this.fileCount;
    }
    
    /**
    * Method :          getFiles
    * Purpose :         Return String array of matched files
    * 
    * @param            None.
    * @preconditions    None.
    * @postconditions   None.
    * @returns          String array representing the locations
    *                   of matched files found. 
    *@throws            NullPointerException if no matched files
    *                   were found. 
    *                  
    */   
    public String[] getFiles()
    {
        if ( this.matchedFiles == null )
            throw new NullPointerException
			("Directory contains no matching files searched.");
            
        this.fileList = new ArrayList ( this.matchedFiles );
        return this.matchedFiles;
    }
    
    /**
    * Method :          printMatchingFilePaths
    * Purpose :         Prints matched file locations.
    * 
    * @param            None.
    * @preconditions    None.
    * @postconditions   None.
    * @returns          None.
    *                  
    */ 
    public void printMatchingFilePaths ()
    {
        System.out.println ( this.fileList.toString());
    }
}
