
/**
 * Fraction.java - Class representing Fraction object
 * 
 * @author Reshma Sivakumar  
 * @version  2.0 10/21/2015
 *
 * Description: This class provides the data and methods to store and process
 *               a Fraction object. A Fraction object consists of two integers
 *               to represent the numerator and denominator. Eg., 3/5
 * 				 A valid Fraction should not have a denominator of Zero.
 *
 *
 */
 
public class Fraction
{
	
    private int numerator;   //store numerator of fraction
    private int denominator; //store denominator of fraction
    
	   
  /**
   * Method : 			Default Constructor
   * Purpose : 			Constructs an empty Fraction object with
   *					numerator and denominator initialized to 0.
   * 
   * @param 			None.
   * @preconditions		None.
   * @postconditions	 A new Fraction object is created with numerator
   * 					and denominator initialized to 0.
   */   
    public Fraction ()
    {
        this.numerator = 0;
		this.denominator = 0;
    }
    
     
  /**
   * Method : 			Constructor with  arguments numerator and denominator.
   * Purpose : 			Constructs a new Fraction object containing the 
   *					numerator and denominator set to the specified inputs.
   * 
   * @param 			numerator - integer value.
   * @param				denominator - integer value.
   * @preconditions		denominator should not be 0.
   * @postconditions	 A new Fraction object is created with numerator
   * 					and denominator initialized to parameters passed.
   * @returns		    A new Fraction object.
   * @throw 			IllegalArgumentException -When denominator passed as 0.
   */   
    public Fraction (int numerator, int denominator)
    {
        if( denominator != 0 )  
			this.denominator = denominator; 
		else
            throw new IllegalArgumentException("Invalid fraction read! Denominator cannot be zero.");
        this.numerator = numerator;
        reduceFraction ();
    }
    
 
	/**
	* Method : 			SetNumerator
	* Purpose : 		Set the value for numerator member variable.
	* 
	* @param 			numerator - integer value.
	* @preconditions	None.
	* @postconditions	The value of numerator will be set to numerator
						member variable.
	* @returns		    None.
	*/
    public void setNumerator ( int numerator )
    {
        this.numerator = numerator; 
    }
    
	/**
	* Method : 			setDenominator
	* Purpose : 		Set the value for denominator member variable.
	* 
	* @param 			denominator - integer value.
	* @preconditions	None.
	* @postconditions	The value of denominator will be set to denominator
						member variable.
	* @returns		    None.
	* @throw		    IllegalArgumentException -When denominator passed as 0.	
	*/
	public void setDenominator ( int denominator )
    {
        if ( denominator != 0 )
            this.denominator = denominator;
        else 
        {
             String msg = "Invalid fraction read! Denominator cannot be zero.";
             throw new IllegalArgumentException(msg);
        }
    }
    
	/**
	* Method : 			getNumerator
	* Purpose : 		Return the value for numerator member variable.
	* 
	* @param 			None.
	* @preconditions	None.
	* @postconditions	None.
	* @returns		    Integer data stored in numerator member variable.
	*/
    public int getNumerator ()
    {
        return this.numerator; 
    }
  
	/**
	* Method : 			getDenominator
	* Purpose : 		Return the value for denominator member variable.
	* 
	* @param 			None.
	* @preconditions	None.
	* @postconditions	None.
	* @returns		    Integer data stored in denominator member variable.
	*/
    public int getDenominator ()
    {
       return this.denominator;
    }
    

 	/**
	* Method : 			toString
	* Purpose : 		Return the internal representation of Fraction Object
	*					in numerator/denominator form as String for printing.
	* 
	* @param 			None.
	* @preconditions	None.
	* @postconditions	None.
	* @returns		    A String representation of the fraction object.
	*/
    public String toString()
    {
       return getNumerator() + "/" + getDenominator ();  
    }
    
	/**
	* Method : 			equals
	* Purpose : 		To compare if the input Fraction object is equal to 
	*					the internal Fraction object
	* 
	* @param 			that - another Fraction object to be compared to.
	* @preconditions	None.
	* @postconditions	None.
	* @returns		    true - if the input Fraction object is equal
	*					false - otherwise
	*/
    public boolean equals ( Fraction that )
    {
        if ( that == null ) 
            return false;
            
        if (! ( that instanceof Fraction ) ) 
            return false;

        return numerator * that.denominator == denominator * that.numerator;
    }    
	
	/**
	* Method : 			gcd
	* Purpose : 		To find the Greatest Common Divisor of the numerator 
	*					and denominator used to reduce the fraction.
	* 
	* @param 			numerator - integer value.
	* @param 			denominator - integer value.
	* @preconditions	numerator and denominator should contain valid data.
	* @postconditions	None.
	* @returns		    The Greatest Common Divisor of the numerator and
	* 					denominator.
	*/
    private int gcd ( int numerator, int denominator )
    {
        while ( denominator != 0 )
        {
                int temp = denominator;
                denominator = numerator % denominator;
                numerator = temp;
        }
        return numerator;
    }
    
	
 	/**
	* Method : 			reduceFraction
	* Purpose : 		To convert the internal Fraction to its lowest 
	*					terms using the gcd value of its numerator and
	*					denominator.
	* 
	* @param 			None.
	* @preconditions	numerator and denominator should contain valid data.
	* @postconditions	None.
	* @returns		    The Greatest Common Divisor of the numerator and
	* 					denominator.
	*/
    private void reduceFraction ()
    {
        int gcdVal = gcd (this.numerator, this.denominator);
        if (this.numerator > 0 ) 
            this.numerator = this.numerator / gcdVal;
        this.denominator = this.denominator / gcdVal;
    }

}

