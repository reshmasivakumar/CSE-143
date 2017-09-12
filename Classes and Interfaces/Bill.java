import java.io.Serializable;

/*
 * Bill.java - Class representing Bill object
 * 
 * @author Reshma Sivakumar  
 * @version  1.0 11/01/2015
 *
 * Description:  This class is used to represent a
 *           Bill object that contains data related
 *               to  an outstanding or paid bill of a 
 *       specific amount of money. 
 *       The Bill object consists of 
 *       - Money object to represent Amount
 *           - Date object to represent DueDate
 *       - Date object to represent PaidDate
 *       - Boolean to represent paid status
 *       - String to representing the company or
 *         institution who issued the bill.
 *
 *              
 * Class Invariants: This class validates the following
 *           - If Bill is not yet paid, the PaidDate 
 *          will be null. 
 *                   - Amount has to be positive value
 *           - Due Date cannot be null
 *           - Due Date cannot lesser than Paid Date
 *           - Paid Date cannot be greater than Due Date
 *           - Originator cannot be null.
 *
 *  
 *               
 */

public class Bill implements Comparable, Cloneable
{

    /** Instance variables **/
    private Money amount;
    private Date dueDate;
    private Date paidDate;
    private String originator;
    private boolean paid;



    /**
    * Method :          Constructor
    * Purpose :         Constructs a Bill object initializing the amount,
    *                   dueDate and originator to  the specified values 
    *                   and paidDate to null and paid to false.
    * 
    * @param            amount - Money object.
    * @param            dueDate - Date object.
    * @param            originator - String.
    * @preconditions    Valid values to be provided for amount, dueDate and 
    *                   originator.
    * @postconditions   A new Bill object is created with specified values.
    * @throws           RuntimeException when invalid data passed.
    */ 
    
    public Bill ( Money amount, Date dueDate, String originator)
    {
        setAmount ( amount );
        setDueDate ( dueDate);
        setOriginator (originator );
        this.paidDate = null;
        this.paid = false;
    }   
    
    /**
    * Method :          Constructor
    * Purpose :         Copy Constructor that takes a Bill object 
    *                   and creates a copy and set its values to this 
    *                   object by calling the clone methods of Money
    *                   and Date class.
    * @param            Bill - Bill object to copy.
    * @preconditions    Valid Bill object to copy.
    * @postconditions   A new Bill object created as a copy of specified.
    * @throws           RuntimeException when null object passed.
    */ 
    
    /*  public Bill ( Bill toCopy )
    {
        if ( toCopy == null )
    {
        String  msg = "Error: Cannot copy from null reference";
            throw new NullPointerException(msg);
    }
         
        setAmount (new Money (toCopy.getAmount())); 
        setDueDate (new Date (toCopy.getDueDate()));
        this.paid = toCopy.paid;
        this.originator = toCopy.getOriginator();
    }
    */

    public Bill ( Bill toCopy )
    {
        this.amount = (Money)(toCopy.getAmount()).clone(); 
        this.dueDate =  (Date)(toCopy.getDueDate()).clone() ;
        this.paid = toCopy.paid;
        this.originator = toCopy.getOriginator();
    }

    /**
    * Method :          getAmount
    * Purpose :         Accessor method to return the Amount of this Bill.
    * @param            None.
    * @preconditions    None.
    * @postconditions   None.
    * @returns          Money object  representing Amount of this Bill.
    */ 
    
    public Money getAmount ()
    {
        return new Money ( this.amount );
    }

    /**
    * Method :          getDueDate
    * Purpose :         Accessor method to return the DueDate of this Bill.
    * @param            None.
    * @preconditions    None.
    * @postconditions   None.
    * @returns          Date object  representing  DueDate of this Bill.
    */ 
    
    public Date getDueDate ()
    {
        return new Date ( this.dueDate );
    }

    /**
    * Method :          getOriginator
    * Purpose :         Accessor method to return the originator of this Bill.
    * @param            None.
    * @preconditions    None.
    * @postconditions   None.
    * @returns          String value representing originator of this Bill.
    */ 
     
    public String getOriginator ()
    {
        return this.originator;
    }

    /**
    * Method :          getPaidDate
    * Purpose :         Accessor method to return the PaidDate of this Bill.
    * @param            None.
    * @preconditions    None.
    * @postconditions   None.
    * @returns          Date value representing PaidDate of this Bill.
    */ 
   
    public Date getPaidDate()
    {
        if ( this.paidDate == null )
            return null;
        else
            return new Date ( this.paidDate);   
    }

    /**
    * Method :          getPaidDate
    * Purpose :         Accessor method to return the paid status of this Bill.
    * @param            None.
    * @preconditions    None.
    * @postconditions   None.
    * @returns          boolean - true if this Bill is paid, false otherwise.
    */ 
   
    public boolean isPaid ()
    {
        return this.paid;
    }

    /**
    * Method :          setPaid
    * Purpose :         Mutator method to set the paid status of this Bill 
    *                   to true and set the PaidDate to the specified date.
    * @param            onDay - Date object representing PaidDate.
    * @preconditions    PaidDate cannot be null and cannot be greater than
    *                   dueDate of this Bill.
    * @postconditions   Paid status of this Bill is set to true and 
    *                   PaidDate of this Bill is set to specified date.
    * @returns          None.
    * @throws           NullPointerException when specified date is null
    * @throws           RuntimeException when specified date greater than
    *                   dueDate of this Bill
    */ 
   
    public void setPaid ( Date onDay )
    {
        if ( onDay == null )
        {
            String msg = "Error in set: Paid date cannot be null!";
            throw new NullPointerException (msg);
        }
        //check if onDay is less than the dueDate else fail.
        if ( this.dueDate.precedes( onDay))
        {
            String msg = "Error in set: PaidDate cannot be greater to dueDate";
            throw new RuntimeException(msg);
        }
            
        this.paidDate = new Date ( onDay );
        this.paid = true;
    }
    
    /**
    * Method :          setUnpaid
    * Purpose :         Mutator method to set the paid status of this Bill 
    *                   to false and set the PaidDate to null.
    * @param            None.
    * @preconditions    None.
    * @postconditions   Paid status of this Bill is set to false and 
    *                   PaidDate of this Bill is set to null.
    */     
    public void setUnpaid ()
    {
        this.paid = false;
        this.paidDate = null;
    }

    /**
    * Method :          setDueDate
    * Purpose :         Mutator method to set the DueDate of this Bill 
    *                   to specified date.
    * @param            nextDate - Date object representing DueDate.
    * @preconditions    DueDate cannot be null and cannot be lesser than
    *                   PaidDate of this Bill.
    * @postconditions   DueDate of this Bill is set to specified date.    
    * @returns          None.
    * @throws           NullPointerException when specified date is null
    * @throws           RuntimeException when specified date lesser than
    *                   PaidDate of this Bill
    */ 
   
    public void setDueDate ( Date nextDate )
    {
        if ( nextDate == null )
        {
            String msg = "Error in set: Due date cannot be null!";
            throw new NullPointerException (msg);
        }
        
        if ( this.paidDate != null && nextDate.precedes(this.paidDate) )
        {
            String msg = "Error in set: Duedate cannot be earlier to paidDate";
            throw new RuntimeException(msg);
        }
        
        this.dueDate = new Date ( nextDate );
    }

    /**
    * Method :          setAmount
    * Purpose :         Mutator method to set the Amount of this Bill 
    *                   to specified amount.
    * @param            amount - Money object representing Dollars and Cents.
    * @preconditions    Amount cannot be null.
    * @postconditions   Amunt of this Bill is set to specified value.    
    * @returns          None.
    * @throws           NullPointerException when specified amount is null
    */ 
    public void setAmount ( Money amount )
    {
       if ( amount == null )
       {
           String msg = "Error in set: Amount cannot be null!";
           throw new NullPointerException (msg);
       }
          
       this.amount = new Money ( amount ); 
    }

    /**
    * Method :          setOriginator
    * Purpose :         Mutator method to set the Originator of this Bill 
    *                   to specified value.
    * @param            originator - String representing originator of this
    *                   Bill.
    * @preconditions    Originator cannot be null.
    * @postconditions   Originator of this Bill is set to specified value.    
    * @returns          None.
    * @throws           NullPointerException when specified Originator is null
    */ 
    public void setOriginator ( String originator )
    {
        if ( originator == null )
        {
            String msg = "Error in set: Originator cannot be null!";
            throw new NullPointerException (msg);
        }
        
        if ( originator.trim().length() <= 0 )
        {
            String msg = "Error in set: Originator value is blank";
            throw new RuntimeException (msg);
        }
                  
        this.originator = originator;     
    }

        
    /**
    * Method :          toString
    * Purpose :         Returns the String representation of this object  
    *                   for printing in format. For eg,   
    *                   $200.00 due on 11/1/2015 to BCD Corp paid on 9/2/2015
    * 
    * @param            None.
    * @preconditions    None.       
    * @postconditions   None.  
    * @returns          String representation of this object  
    *                   for printing.                     
    *            
    */

    public String toString ()
    {
        //Build a String that reports amount, when it's due, to whom, whether 
        //paid and if paid, the date paid. 
        
        String report = "";
        report = this.amount.toString()+" due on " + this.dueDate.toString();
        report += " to " + this.originator + " ";
        if ( isPaid() )
        {
            report += "paid on " + this.paidDate;
        }
        else 
            report += "not paid yet.";
            
        return report;    
    }

    /**
    * Method :          equals
    * Purpose :         Compares this object with the specified object to see  
    *                   if they are equal. 
    * 
    * @param            other   -  Bill class object
    * @preconditions    None.       
    * @postconditions   None.  
    * @returns          boolean - true if equals, false otherwise.                         
    *            
    */

    public boolean equals ( Bill other )
    {
        if ( other == null)
        {
            return false;
        }
        
        if ( ! ( other instanceof Bill ))
            return false;
        
        Bill temp = new Bill ( other );
        if ( (this.paidDate == null ) &&  (other.getPaidDate() == null)) 
        {

             return this.amount.equals(temp.getAmount()) &&
               this.dueDate.equals(temp.getDueDate()) &&
               this.originator.equals(temp.originator) &&
               this.paid == temp.paid;
            
        }
        else
        {
 
            return this.amount.equals(temp.getAmount()) &&
                   this.dueDate.equals(temp.getDueDate()) &&
                   this.paidDate.equals(temp.getPaidDate()) &&
                   this.originator.equals(temp.originator) &&
                   this.paid == temp.paid;
         }
    }
    

    /**
    * Method:           compareTo
    * Purpose:          Compares the amount of the specified object
    *                   with the amount of this object.
    * 
    * @param            other - Object of Bill class to be compared.
    * @preconditions    None.       
    * @postconditions   None.  
    * @returns          integer - a negative integer, zero, or a 
    *                   positive integer as this object is less
    *                   than, equal to, or greater than the 
    *                   specified object.                          
    *      
    * @throws           NullPointerException - if the specified 
    *                   object is null
    * @throws           ClassCastException - if the specified
    *                   object is not of type Bill.    
    *      
    */
   
    @Override
    public int compareTo ( Object object) 
    {
       if ( object == null )
           throw new NullPointerException 
                    ("Cannot compare to null reference");
                    
       if ( ! ( object instanceof Bill ))
           throw new ClassCastException 
                    ("Pass a Bill object to compare");

       Bill other = (Bill)object;
       return this.amount.compareTo (other.getAmount()); 
    }
    
    /**
    * Method :          clone
    * Purpose :         Overridden clone method to create
    *                   a copy of this Bill object
    * 
    * @param            None.
    * @preconditions    None.       
    * @postconditions   Creates a deep copy of this object to
    *                   a new Bill object .  
    * @returns          Object - Newly created Bill Object                      
    *            
    */
   
    @Override
    public Object clone()
    {
        return new Bill(this);
    }
}
