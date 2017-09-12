
/**
 * FractionCounter.java - Class representing Fraction Counter object
 * 
 * @author Reshma Sivakumar  
 * @version  1.0 10/21/2015
 *
 * Description: This class provides the data and methods to store and process
 *               a FractionCounter object. A FractionCounter object consists
 *				 of a Fraction object and an integer that represents the 
 *               count of the Fraction represented by the Fraction Object.
 *				 Eg., 3/5 in Fraction object with count of 2.
 * 				 
 *
 *
 */
 
public class FractionCounter
{
    private Fraction fraction; //store the fraction object
    private int counter = 1;   //store the count of the fraction object

	/**
	* Method : 			Constructor
	* Purpose : 		Constructs a new FractionCounter object and creates a
	*					Fraction object with the numerator and denominator in
	*					the specified Fraction Object.
	* 
	* @param 			Fraction - fraction object.
	* @preconditions	Input fraction object should have valid numerator and
	*					 denominator.
	* @postconditions	A new Fraction object is created with numerator
	* 					and denominator initialized to input Fraction object.
	*/  
    public FractionCounter( Fraction theFraction )
    {
       int numerator = theFraction.getNumerator();
       int denominator = theFraction.getDenominator();
       this.fraction = new Fraction(numerator, denominator );
    }


	/**
	* Method : 			compareAndIncrement
	* Purpose : 		Compares the specified Fraction object with the Fraction
	*					object represented by this FractionCounter object.
	* 
	* @param 			Fraction - fraction object.
	* @preconditions	Input fraction object should have valid numerator and
	*					denominator.
	* @postconditions	None.
	* @returns			true - if specifed Fraction object matches the Fraction
	*					represented by this FractionCounter object.
	*					false - otherwise.
	*/  
    public boolean compareAndIncrement ( Fraction newFraction )
    {
        boolean isFound = false;
        if ( (this.fraction).equals ( newFraction ) )
        {
            this.counter ++;
            isFound = true;
        }                                                        
        return isFound;
    }
    
	/**
	* Method : 			getFraction
	* Purpose : 		Returns the Fraction
	*					object represented by this FractionCounter object.
	* 
	* @param 			None.
	* @preconditions	None.
	* @postconditions	None.
	* @returns			Fraction object represented by this 
	*					FractionCounter object.
	*					
	*/ 
    public Fraction getFraction ()
    {
        return this.fraction;
    }
    
	/**
	* Method : 			toString
	* Purpose : 		To return the String representation of the Fraction
	*					object represented by this FractionCounter object
	*					and the count of its occurance for printing.
	* 
	* @param 			None.
	* @preconditions	None.
	* @postconditions	None.
	* @returns			String representation of the Fraction
	*					object represented by this FractionCounter object
	*					and the count of its occurance.
	*					
	*/ 
    public String toString ()
    {
        return getFraction ().toString() + " has a count of " + this.counter;
    }
}
