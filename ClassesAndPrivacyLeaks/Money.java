/*
 * Money.java - Class representing Money object
 * 
 * @author Reshma Sivakumar  
 * @version  
 *
 * Description:  This class is used to track a USD amount 
 *		 consisting of two integers to manage dollars
 *		 and cents. 
 *
 *              
 * Class Invariants: All dollars and cents will be positive or 0.
 *		     Cents will be between 0 to 99.
 *	
 *               
 */

public class Money
{

    /**   Instance Variables **/

    private int dollars; //dollar value 
    private int cents; //cent value

    /**
    * Method :          Constructor
    * Purpose :         Constructs a Money object setting the dollars to
                        the specified dollar value and cents to 0.
    * 
    * @param            None.
    * @preconditions    Specified dollars value should not be negative.
    * @postconditions   A new Money object is created with dollars instance
    *                   variable set to specified value and cents will be 
    *                   set to 0. 
    * 
    * @throws           RuntimeException when specified dollar value is
    *                   negative.
    */  
   
    public Money ( int dollars )
    {
        setMoney(dollars, 0);
    }
    
    /**
    * Method :          Constructor
    * Purpose :         Constructs a Money object setting the dollars and 
                        cents to the specified dollars and cents value.
    * 
    * @param            dollars - int value.
    * @preconditions    Specified dollars value should not be negative and 
    *                   specified cents value should be between 0 - 99.            
    *          
    * @postconditions   A new Money object is created with dollars instance
    *                   variable set to specified value and cents will be 
    *                   set to 0. 
    *
    * @throws           RuntimeException when specified dollar value is
    *                   negative and cents value not between 0 - 99.
    */
   
    public Money ( int dollars, int cents ) 
    {
        setMoney ( dollars, cents );
    }

    /**
    * Method :          Copy Constructor
    * Purpose :         Creates a copy of the specified Money object.  
             
    * 
    * @param            dollars - int value.
    * @param            cents - int value.
    * @preconditions    Specified Money object cannot be null.         
    *          
    * @postconditions   A copy of Money object is created and set to this 
    *                   object with dollars and cents set to the specified
    *                   Money object.
    *                    
    *  @throws          NullPointerException when specified dollar value is
    *                   null.
    */
    
    public Money ( Money other )
    {
        if ( other == null )
        {
           throw new NullPointerException("Cannot copy from null refrence");
        }
		
		//create new Money object with specified values and set the instance 
		// variables of this object to the new object to avoid privacy leak
        Money temp = new Money(other.dollars, other.cents);
        setDollars(temp.dollars);
        setCents(temp.cents);
    }

    /**
    * Method :          setDollars
    * Purpose :         Mutator method for setting dollar amount in this
    *                   money object.  
    *            
    * 
    * @param            dollars - int value.
    * @preconditions    Specified dollars value should not be negative. 
    * @postconditions   The dollars value of this object will be set to 
    *                   the specified value.
    *                    
    * @returns          None.                          
    * 
    * @throws           RuntimeException when specified dollar value is
    *                   negative.
    */
    
    public void setDollars(int dollars)
    {
        if ( dollars < 0 )
        {
	    String msg = "Error in set: Provide a positive value for dollars";
            throw new RuntimeException(msg);
        }
        else 
        {
            this.dollars = dollars; //set instance variable using dollars input
        }
    }
    
    /**
    * Method :          setCents
    * Purpose :         Mutator method for setting cents value in this
    *                   money object.  
    *            
    * 
    * @param            cents - int value.
    * @preconditions    Specified cents value should be between 0 to 99.     
    * @postconditions   The cents value of this object will be set to 
    *                   the specified value.                   
    * @returns          None.                          
    * 
    * @throws           RuntimeException when specified cents value is
    *                   not between 0 to 99.
    */
    public void setCents ( int cents )
    {
       if ( cents < 0 || cents > 99 )
        {
			String msg = "Error in set: Cents should be between 0 and 99.";
            throw new RuntimeException(msg);
        }
        else 
        {
            this.cents = cents; //set instance variable using cents input
        } 
    }

    /**
    * Method :          setMoney
    * Purpose :         Mutator method for setting dollars and cents amount in 
    *                   this money object.  
    *            
    * 
    * @param            dollars - int value.
    * @param            cents - int value.
    * @preconditions    Specified dollars value should not be negative. 
    *                   Specified cents value should be between 0 to 99.          
    *          
    * @postconditions   The dollars and cents value of this object will be  
    *                   set to the specified values.               
    * @returns          None.                          
    * 
    * @throws           RuntimeException when specified dollar value is
    *                   negative or cents value is not between 0 to 99.
    */
    
    public void setMoney( int dollars, int cents )
    {
       setDollars ( dollars );
       setCents ( cents );
 
    }

    /**
    * Method :          getMoney
    * Purpose :         Accessor method for getting dollars and cents value 
    *                   represented by this money object.  
    *            
    * 
    * @param            None.
    * @preconditions    None.       
    * @postconditions   None.  
    * @returns          double value representation of this Money object.                          
    *                   For eg. if dollars value is 35 and cents is 75
    *                   getMoney() will return 35.75
    * @throws           RuntimeException when specified dollar value is
    *                   negative or cents value is not between 0 to 99.
    */
    
    public double getMoney ()
    {
        double money = 0.0;
		//divide cents by 100.00 to get money value in dollar and cents
        money = this.dollars +  this.cents / 100.00 ;
        return money;
    }
    
    /**
    * Method :          add
    * Purpose :         Increments the value of the dollars stored in 
    *                   this object with the specified dollar value.  
    *            
    * 
    * @param            dollars - int value.
    * @preconditions    None.       
    * @postconditions   None.  
    * @returns          None.                          
    *            
    * @throws           RuntimeException when specified dollar value is
    *                   negative.
    */
   
    public void add(int dollars)
    {
        if ( dollars < 0 )
	{
	    String msg = "Error in add: Provide a positive value for dollars";
            throw new RuntimeException(msg);
	}
        
        this.dollars += dollars;
    }
    
    /**
    * Method :          add
    * Purpose :         Increments the value of the dollars and cents stored in 
    *                   this object with the specified dollars value and
    *                   cents value.  
    *            
    * 
    * @param            dollars - int value.
    * @param            cents   - int value.
    * @preconditions    None.       
    * @postconditions   None.  
    * @returns          None.                          
    *            
    * @throws           RuntimeException when specified dollar value is
    *                   negative and cents value not between 0 to 99.
    */

    public void add(int dollars, int cents)
    {
        if  ((cents < 0 ) || ( cents > 99 ))
           throw new RuntimeException("Error in add: Cents should be 0 to 99");

        add ( dollars );
        this.cents += cents;
		//if cents is greater than 99 then convert to dollar value
		// eg if  current money value of this object is 10.99, adding
		// 2 dollars and 20 cents will increment the dollar amount 
		// to 13 and cent to 19
       if ( this.cents > 99 )
        {
            double centToDollars = this.cents / 100.00;
            this.dollars += centToDollars;
            int remainingCents = this.cents % 100;
            this.cents = remainingCents;
        } 
    }
    

    /**
    * Method :          add
    * Purpose :         Increments the value of the dollars and cents stored in 
    *                   this object with the values represented by the specified
    *                   object.  
    *            
    * 
    * @param            Money   -  Money class object
    * @preconditions    Valid Money object.       
    * @postconditions   The dollar and cent value of the specified object will be
	*					added to the existing values of this object.  
    * @returns          None.                          
    *            
    * @throws           RuntimeException when specified object has dollar value
    *                   negative and cents value not between 0 to 99.
    */

    public void add ( Money other )
    {
        if ( other == null )
		{
			String msg = "Error in add: Cannot add from null refrence";
            throw new NullPointerException(msg);
		}
        
		// create new money object with the specified object 
		// to avoid privacy leak 
        Money temp = new Money ( other.dollars, other.cents );
		// add the specified dollars and cents of the new object
		// to this object.
        add ( temp.dollars, temp.cents );
    }
    

    /**
    * Method :          equals
    * Purpose :         Compares this object with the specified object to see  
    *                   if they are equal. 
    * 
    * @param            Money   -  Money class object
    * @preconditions    Valid Money object.       
    * @postconditions   None.  
    * @returns          boolean - true if equals, 
	*							  false when not equal
	*							  false when object compared is null
	*							  false when object passed is not Money Type
    *            
    */

    public boolean equals ( Money other )
    {
        if ( other == null )
            return false;
        
		//check if object passed is Money type
        if (!(other instanceof Money ))    
            return false;

        return this.dollars == other.dollars &&
               this.cents == other.cents;
    }
    
    /**
    * Method :          toString
    * Purpose :         Returns the String representation of this object  
    *                   for printing in dollars and cents. 
    * 
    * @param            None.
    * @preconditions    None.       
    * @postconditions   None.  
    * @returns          String representation of this object  
    *                   for printing in dollars and cents.  .                          
    *            
    */

    public String toString()
    {
        String retVal = "";
 
        if ( this.cents < 10 )
            retVal = "$" + this.dollars + "." + "0" + this.cents;
        else
            retVal = "$" + this.dollars + "." + this.cents;
        
        return retVal;
    }


    
}
