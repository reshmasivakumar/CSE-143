import java.io.Serializable;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/*
 * Money.java - Class representing Money object
 * 
 * @author Reshma Sivakumar  
 * @version  1.0 11/01/2015
 *
 * Description:  This class is used to track a USD amount 
 *       consisting of two integers to manage dollars
 *       and cents. 
 *
 *              
 * Class Invariants: All dollars and cents will be positive or 0.
 *           Cents will be between 0 to 99.
 *  
 *               
 */


public class Money implements Comparable, Cloneable, Serializable
{

    /**   Instance Variables **/

    private int dollars; 
    private int cents;

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
    * Purpose :         Creates a copy of the specified Money object  
                        by calling setDollars and setCents method
    * 
    * @param            dollars - int value.
    * @param            cents - int value.
    * @preconditions    None.         
    *          
    * @postconditions   A copy of Money object is created and set to this 
    *                   object with dollars and cents set to the specified
    *                   Money object.
    *                    
    */
   
    public Money ( Money other )
    {
        setDollars(other.dollars);
        setCents(other.cents);
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
    * @preconditions    None.       
    * @postconditions   None.  
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
        
        Money temp = new Money ( other.dollars, other.cents );
        add ( temp.dollars, temp.cents );
    }
    
    /**
    * Method :          equals
    * Purpose :         Compares this object with the specified object to see  
    *                   if they are equal. 
    * 
    * @param            Money   -  Money class object
    * @preconditions    None.       
    * @postconditions   None.  
    * @returns          boolean - true if equals, false otherwise.                         
    *            
    */

    public boolean equals ( Money other )
    {
        if ( other == null )
            return false;
            
        if (!(other instanceof Money ))    
            return false;
        
        Money temp = new Money ( other.dollars, other.cents );
        return this.dollars == temp.dollars &&
               this.cents == temp.cents;
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

    /**
    * Method :          compareTo
    * Purpose :         Compares the dollars and cents of 
    *                   specified object with this object. 
    *                   
    * @param            other - Object of Money class to 
    *                   be compared.
    * @preconditions    None.       
    * @postconditions   None.  
    * @returns          integer - a negative integer, zero, 
    *                   or a positive integer as this object 
    *                   is less than, equal to, or greater
    *                   than the specified object.                          
    *      
    * @throws           NullPointerException - if the specified 
    *                   object is null
    *                   ClassCastException - if the specified 
    *                   object is not of type Money.          
    */
   
    @Override  
    public int compareTo (Object object)
    {
        Money other = (Money) object;
        if ( other == null )
            throw new NullPointerException ("Money object passed is null");
            
        if (!(other instanceof Money ))    
            throw new ClassCastException ("Object passed is not of type Money");
         
        if  (this.dollars  == other.dollars &&  this.cents == other.cents )
               return 0;
               
        if (this.dollars > other.dollars )
                return 1;
                
        if (this.dollars <  other.dollars )
                return -1;
                
        if (this.cents > other.cents)
                return 1;
        else 
                return -1;
    }

    /**
    * Method :          clone
    * Purpose :         Overridden clone method to create
    *                   a copy of this Money object
    * 
    * @param            None.
    * @preconditions    None.       
    * @postconditions   Creates a deep copy of this object to
    *                   a new Money object .  
    * @returns          Object - Newly created Money Object                      
    *            
    */
   
    @Override
    public Object clone()
    {
      return new Money(this);
    }    
    
    /*private void writeObject(ObjectOutputStream out) 
                                   throws IOException 
    {
        out.defaultWriteObject();
        out.writeObject(this.dollars);
        out.writeObject(this.cents);
    }
 
    private void readObject(ObjectInputStream in) throws 
                      IOException,ClassNotFoundException
    {
        in.defaultReadObject();
        this.dollars = (int)in.readObject();
        this.cents = (int)in.readObject();
    }
  
    */
}
