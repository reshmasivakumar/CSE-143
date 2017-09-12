/*
 * Date.java - Class representing Date object
 * 
 * @author Reshma Sivakumar  
 * @version 
 *  
 * Description:  This class represents a Date object which internally
 *		 stores the month, day and year as integer values. The
 *		 class allows you to specify the month as String which will
 *       internally be converted into integer. This class doesnot
 *		 store the time information.
 *              
 * Class Invariants: The class validates the following 
 *		     - day between 1 to 31. 
 *		     - month between 1 to 12 or January to December
 *		     - Year between 2014 to 2024
 *	
 *               
 */

public class Date
{

    /** Instance Variables **/

    private int month; //integer month value of Date object
    private int day; //integer day value of Date object
    private int year; //integer year value of Date object

    /**
    * Method :          Default Constructor
    * Purpose :         Constructs Date object with the month, day
                        and year members initialized to 0.
    * @param            None.
    * @preconditions    None.
    * @postconditions   A new Dateobject is created with the month, day
                        and year members initialized to 0.
    * 
    */  
       
  
    public Date ()
    {
        this.month = 0;
        this.day = 0;
        this.year = 0;
    }
    

    /**
    * Method :          Constructor
    * Purpose :         Overloaded constructor that takes day and year as  
    *                   int values and month as String.
    *                   For eg., Date("January", 1, 2015). 
    * @param            month - String value (case insensitive)
    * @param            day - int value
    * @param            year - int value
    * @preconditions    Valid month values - January to December.
    *                   Valid day values - 1 to 31
    *                   valid year values - 2014 to 2024
    * @postconditions   A new Dateobject is created with the month, day
    *                   and year members initialized to specified values.
    *
    * @throws           RuntimeException when invalid data specified for
    *                   month, day and year. 
    */  
       
    public Date (String month, int day, int year)
    {
        setDate ( month, day, year );        
    }
    

    /**
    * Method :          Constructor
    * Purpose :         Overloaded constructor that takes day and year as  
    *                   and month as int values
    *                   For eg., Date(1, 1, 2015). 
    * @param            month - int value
    * @param            day - int value
    * @param            year - int value
    * @preconditions    Valid month values - 1 to 12.
    *                   Valid day values - 1 to 31
    *                   valid year values - 2014 to 2024
    * @postconditions   A new Dateobject is created with the month, day
    *                   and year members initialized to specified values.
    * @throws           RuntimeException when invalid data specified for
    *                   month, day and year.
    * 
    */   
       
    public Date (int month, int day, int year)
    {
        setDate ( month, day, year );        
    }

    /**
    * Method :          Copy Constructor
    * Purpose :         Constructs a copy of the Date Object specified 
    *                   to this object.
    * @param            Date - a Date object. 
    * @preconditions    A valid Date object should be passed.
    * @postconditions   A new Dateobject is created with the month, day
    *           and year members copied from the specified Date object.
    * 
    */   
    
    public Date ( Date that )
    {
        if ( that == null )
            throw new NullPointerException("Error:Cannot construct from null");
        
		// create new Date object with passedin Date object to avoid privacy leaks
        Date temp = new Date ( that.month, that.day, that.year);
		// assign the new object values to the instance variables of this object
        this.month = temp.month;
        this.day = temp.day;
        this.year = temp.year;
    }

    /**
    * Method :          setDate 
    * Purpose :         Mutator method for setting this object with 
    *                   specified month, day and year values.The month
    *                   specified here is in String. 
    *                   setDate("January", 1, 2015)  
    *
    * @param            month - String value (case insensitive)
    * @param            day - int value
    * @param            year - int value
    * @preconditions    Valid month values - January to December.
    *                   Valid day values - 1 to 31
    *                   valid year values - 2014 to 2024
    *
    * @postconditions   The month, day and year of this object is 
    *           set to specified valid values.
    *
    * @throws       RuntimeException when invalid data specified for
    *           month, day and year. 
    */
    
    public void setDate ( String month, int day, int year)
    {
        setMonth(month);
        setDay(day);    
        setYear(year);
 
    }

    /**
    * Method :          setDate 
    * Purpose :         Mutator method for setting this object with 
    *                   specified month, day and year values.The month
    *                   specified here is in String. 
    *                   setDate(1, 1, 2015)  
    *
    * @param            month - int value  
    * @param            day - int value
    * @param            year - int value
    * @preconditions    Valid month values - 1 to 12.
    *                   Valid day values - 1 to 31
    *                   valid year values - 2014 to 2024
    *
    * @postconditions   The month, day and year of this object is 
    *                   set to specified valid values.
    *
    * @throws           RuntimeException when invalid data specified for
    *                   month, day and year. 
    */
    
    
    public void setDate (int month, int day, int year)
    {
        setMonth(month);
        setDay(day);
        setYear(year);
    }

    /**
    * Method  :         setMonth 
    * Purpose :         Mutator method for setting this object with 
    *                   specified month in String. 
    *                   eg., setDate("January" )  
    *
    * @param            month - String value (case insensitive)
    * @preconditions    Valid month values - January to December.
    * @postconditions   The month of this object will be set to the 
	*					corresponding integer value (1 - 12) for the
	*					specified month string specified.
	*					
    * @throws           RuntimeException when invalid data specified for
    *                   month ie any value other than case insensitive 
	*					January to December.
    */
    
    public void setMonth ( String month )
    {
        if ( month == null)
            throw new NullPointerException ("Error: Month cannot be null.");
		
		//check  if month string passed is valid month values between
		//January to December.
        if (!(isMonthStringValid(month)))
        {
            throw new RuntimeException ("Error: Invalid month provided");
        }
        else 
		{	
			//get integer value of the month string between 1-12 and 
			// assign to this object.
            this.month = getMonthInt(month); 
		}
    }

    
    /**
    * Method  :         setMonth 
    * Purpose :         Mutator method for setting this object with 
    *                   specified month as int value. 
    * @param            month - int value 
    * @preconditions    Valid month values - 1 to 12.
    * @postconditions   The month is set to specified valid value.
    * @throws           RuntimeException when invalid data specified for
    *                   month. 
    */
    
    public void setMonth (int month )
    {
		//check if month passed is valid between 1- 12
        if (!(isMonthValid(month)))
        {
            throw new RuntimeException ("Error: Invalid month provided");
        }
        else 
            this.month = month;
    }

   /**
    * Method  :         setDay 
    * Purpose :         Mutator method for setting this object with 
    *                   specified day as int value.  The method will
	*					check if passed day is valid for the given month
	*					for eg, April cannot have 31 days.
    * @param            day - int value.
    * @preconditions    Valid days 1 to 31.
    * @postconditions   The day is set to specified valid value.
    * @throws           RuntimeException when invalid data specified for
    *                   day. 
    */
    
    public void setDay (int day )
    {
		//check if day passed is valid for the months
        if  (! (isDayValid (this.month, day )))
        {
           throw new RuntimeException("Error: Invalid day");
        }
        else 
            this.day = day;  
    }    
    

   /**
    * Method  :         setYear
    * Purpose :         Mutator method for setting this object with 
    *                   specified year as int value. 
    * @param            year - int value.
    * @preconditions    Valid year - 2014 to 2024.
    * @postconditions   The day is set to specified valid value.
    * @throws           RuntimeException when invalid data specified for
    *                   day. 
    */
    
    public void setYear (int year )
    {
		//check if year is valid between 2014 to 2024
        if (! (isYearValid ( year ) ))
        {
             throw new RuntimeException("Error: Invalid year");
        }
        else 
            this.year = year;  
    }
  
 
    
    /**
    * Method :          getMonth
    * Purpose :         Accessor method to return the month value 
    *                   represented by this object.
    *            
    * @param            None.
    * @preconditions    None.
    * @postconditions   None.
    *
    * @returns          int value representing the month of this
    *                   object.
    *            
    */

    
    public int getMonth()
    {
        return this.month;
    }
    

    /**
    * Method :          getDay
    * Purpose :         Accessor method to return the day value 
    *                   represented by this object.
    *            
    * @param            None.
    * @preconditions    None.
    * @postconditions   None.
    *
    * @returns          int value representing the day of this
    *                   year.
    *            
    */

    public int getDay()
    {
        return this.day;
    }
    

    /**
    * Method :          getYear
    * Purpose :         Accessor method to return the year value 
    *                   represented by this object.
    *            
    * @param            None.
    * @preconditions    None.
    * @postconditions   None.
    *
    * @returns          int value representing the year of this
    *                   object.
    *            
    */
    public int getYear()
    {
        return this.year;
    }

    /**
    * Method :          getDate
    * Purpose :         Accessor method to return this  
    *                   Date object 
    *            
    * @param            None.
    * @preconditions    None.
    * @postconditions   None.
    *
    * @returns          Date - this object   
    *            
    */
    public Date getDate()
    {
        return new Date(this.month, this.day, this.year);
    }    

    /**
    * Method :          precedes
    * Purpose :         Checks if the date represented by this  
    *                   object precedes the specified object.
    *            
    * @param            other - Date object
    * @preconditions    None.
    * @postconditions   None.
    *
    * @returns          boolean - true if this date object precedes 
    *                   specified object, false otherwise.
    *@throws            NullPointerException when null object specified.
    *        
    */

    public boolean precedes ( Date other )
    {
        if ( other == null )
            throw new NullPointerException("Error: Date cannot be null");
        
        return ((this.year < other.getYear()) || (this.year == other.getYear() 
             && this.month < other.getMonth()) || (this.year == other.getYear() 
             && this.month == other.getMonth() && this.day < other.getDay()));
        
    }
 

    /**
    * Method :          equals 
    * Purpose :         Checks if the date represented by this  
    *                   object is equal to the specified object.
    *            
    * @param            other - Date object
    * @preconditions    None.
    * @postconditions   None.
    *
    * @returns          boolean - true if this date object is equal
    *                   to specified object, false otherwise
    *        
    */   
    public boolean equals ( Date other )
    {
        if ( other == null)
        {
            return false;
        }
        
        if ( ! ( other instanceof Date ))
            return false;
        
        return this.month == other.month &&
               this.day == other.day &&
               this.year == other.year;
    }

    /**
    * Method :          toString
    * Purpose :         Returns the String representation of this object  
    *                   for printing in mm/dd/yyyy format. 
    * 
    * @param            None.
    * @preconditions    None.       
    * @postconditions   None.  
    * @returns          String representation of this object  
    *                   for printing in mm/dd/yyyy format.                             
    *            
    */
    
    public String toString()
    {
        return this.month + "/"+this.day+"/"+this.year;
    }

    /** private helper methods **/
	
    /**
    * Method :          isLeapYear 
    * Purpose :         Validates if the year specified    
    *                   is a leap year. 
    * 
    * @param            year - int value
    * @preconditions    valid year.       
    * @postconditions   none.  
    * @returns          boolean - true if year  is leap, 
    *                   false otherwise                            
    *            
    */
	private boolean isLeapYear (int year)
    {
		if ((year % 400 == 0) || ((year % 4 == 0) && 
								(year % 100 != 0)))
		{
			return true;
		}
		else{
			return false;
		}
		 
	}
 
	
    /**
    * Method :          isDayValid 
    * Purpose :         Validates the day specified    
    *                   for the month of this object. 
    * 
    * @param            month - int value
    * @param            day - int value
    * @preconditions    valid month and day.       
    * @postconditions   None.  
    * @returns          boolean - true if day is valid, 
    *                   false otherwise                            
    *            
    */
    
    private boolean isDayValid (int month, int day )
    {
        boolean retVal = false;
        if ( month == 2 )
         {
           retVal =  (day >=1 && day <= 28);     
          }
        
        else if ( month == 1 ||  month == 3  ||  month == 5  ||
            month == 7 || month == 8 || month == 10 ||
            month == 12 )
       
            retVal =(day >=1 && day <= 31);            
        
        else if ( month == 4  ||  month == 6  || month == 9 || 
            month == 11 )
       
            retVal =(day >=1 && day <= 30);     
        
        return retVal;
    }
    
 
    /**
    * Method :          getMonthInt
    * Purpose :         Returns the numeric representation    
    *                   of the month in String format. 
    * @preconditions    valid month string (January to December).       
    * @postconditions   None.  
    * 
    * @param            month - String value
    * @returns          int value of given month string 
    *            
    */
    private int getMonthInt(String month)
    {
        int retMonth = 0;
        
        if (!( isMonthStringValid(month) ) )
            throw new RuntimeException("Invalid month");
        
        switch ( month.toLowerCase() )
        {
            case "january": retMonth = 1;
                            break;
            case "february": retMonth = 2;
                            break;                
            case "march": retMonth = 3;
                            break;
            case "april": retMonth = 4;
                            break;
            case "may": retMonth = 5;
                            break;
            case "june": retMonth = 6;
                            break;
            case "july": retMonth = 7;
                            break;
            case "august": retMonth = 8;
                            break;
            case "september": retMonth = 9;
                            break;
            case "october": retMonth = 10;
                            break;
            case "november": retMonth = 11;
                            break;
            case "december": retMonth = 12;
                            break;  
            default : throw new RuntimeException("Error: Invalid month");
        }
        return retMonth;
    }
    
    /**
    * Method :          isMonthStringValid 
    * Purpose :         Validates the specified month    
    * 
    * @param            month - String value
    * @preconditions    valid month String (January to December).       
    * @postconditions   None.  
    * @returns          boolean - true if month string
    *                   specified is valid, false otherwise.
    *            
    */

    private boolean isMonthStringValid (String month)
    {
        return (month.equalsIgnoreCase ("January" ) || 
                month.equalsIgnoreCase("February") || 
                month.equalsIgnoreCase("March") || 
                month.equalsIgnoreCase("April") ||
                month.equalsIgnoreCase("May") ||
                month.equalsIgnoreCase("June") ||
                month.equalsIgnoreCase("July") ||
                month.equalsIgnoreCase("August") ||
                month.equalsIgnoreCase("September") ||
                month.equalsIgnoreCase("October") ||
                month.equalsIgnoreCase("November") ||
                month.equalsIgnoreCase("December") );
    }


    /**
    * Method :          isMonthValid 
    * Purpose :         Validates the specified month    
    * 
    * @param            month - int value
    * @preconditions    valid month integer (1 -12).       
    * @postconditions   None.  
    * @returns          boolean - true if month 
    *                   specified is valid, false otherwise.
    *            
    */

    
    private boolean isMonthValid (int month)
    {
        if ( month <= 0 || month > 12 )
            return false;
        else
            return true;
    }


    /**
    * Method :          isYearValid 
    * Purpose :         Validates the specified year
    * 
    * @param            month - int value
    * @preconditions    valid year integer.       
    * @postconditions   None.  
    * @returns          boolean - true if year 
    *                   specified is valid, false otherwise.
    *            
    */
    
    private boolean isYearValid ( int year )
    {
        return ( year >= 2014 && year <= 2024 );
    }
    

   
}
