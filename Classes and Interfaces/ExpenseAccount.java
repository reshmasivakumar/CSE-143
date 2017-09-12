import java.util.Iterator;

/*
 * ExpenseAccount.java - Class representing ExpenseAccount object
 * 
 * @author Reshma Sivakumar  
 * @version  1.0 12/2/2015
 *
 * Description:  This class extends ArrayList generic class which 
 *               implements Iterable Interface. The ArrayList class
 *               takes elements of type Bill class. The class holds
 *               the data about the expense account id, account holder
 *               name and the expense report date which has corresponding
 *               setter and getter methods. The ExpenseAccount
 *               ArrayList is constructed using the addBill() method
 *               and the expense report is printed using the
 *               printExpenseReport method.
 *
 *              
 * Class Invariants: The expense account id, account holder
 *                  name and the expense report date cannot 
 *                  be null.
 *                  Bill object added cannot be null.
 *  
 *               
 */

public class ExpenseAccount extends ArrayList<Bill>
{
    private String expenseAccountId; //account id
    private String accountHolder; //account holder name
    private Date expenseDate; //expense report date

    /**
    * Method :          Constructor
    * Purpose :         Constructs a ExpenseAccount object setting 
    *                   the expenseAccountId, accountHolder and
    *                   expenseDate to the specified values.
    *            
    * 
    * @param            id - String value representing account id.
    * @param            user - String value representing account holder.
    * @param            eDate - Date value representing report date.
    * @preconditions    expenseAccountId, accountHolder and
    *                   expenseDate values cannot be null.
    * @postconditions   A new ExpenseAccount object is created
    * @throws           NullPointerException when any of the specified
    *                   values are null.
    */  
    public ExpenseAccount(String id, String user, Date eDate)
    {
        super();
        setExpenseAccountId(id);
        setAccountHolder(user);
        setExpenseDate(eDate);
    }

    /**
    * Method :          setExpenseAccountId 
    * Purpose :         Mutator method for setting the expenseAccountId
    * @preconditions    expenseAccountId cannot be null.
    * @postconditions   The expenseAccountId of this object will be set 
    *                   to the specified value.
    *
    * @throws           NullPointerException when invalid data specified
    *                   for expenseAccountId
    *           
    */
    public void setExpenseAccountId(String id)
    {
        if (id == null || id == "" )
            throw new NullPointerException 
            ("Expense Account Id cannot be Null");
        this.expenseAccountId = id;
    }
 
   /**
    * Method :          setAccountHolder 
    * Purpose :         Mutator method for setting the accountHolder
    * @preconditions    accountHolder cannot be null.
    * @postconditions   The accountHolder of this object will be set 
    *                   to the specified value.
    *
    * @throws           NullPointerException when invalid data specified
    *                   for accountHolder
    *           
    */    
    public void setAccountHolder(String accountHolder)
    {
        if (accountHolder == null || accountHolder == "" )
            throw new NullPointerException 
            ("Expense Account Holder cannot be Null");
            
        this.accountHolder = accountHolder;
    }

    /**
    * Method :          setExpenseDate 
    * Purpose :         Mutator method for setting the expenseDate
    * @preconditions    expenseDate cannot be null.
    * @postconditions   The expenseDate of this object will be set 
    *                   to the specified value.
    *
    * @throws           NullPointerException when invalid data specified
    *                   for expenseDate
    *           
    */  
    public void setExpenseDate(Date eDate)
    {
       if (eDate == null  )
            throw new NullPointerException 
            ("Expense Account Date cannot be Null");            
      
       this.expenseDate = eDate;
    }    

    /**
    * Method :          getExpenseAccountId
    * Purpose :         Accessor method to return the 
    *                   expenseAccountId 
    *                   represented by this object.
    *            
    * @param            None.
    * @preconditions    None.
    * @postconditions   None.
    *
    * @returns          String value representing the expenseAccountId 
    *                   of this object.
    *                   
    *            
    */
    public String getExpenseAccountId()
    {
        return this.expenseAccountId;
    }
    
    /**
    * Method :          getAccountHolder
    * Purpose :         Accessor method to return the 
    *                   accountHolder 
    *                   represented by this object.
    *            
    * @param            None.
    * @preconditions    None.
    * @postconditions   None.
    *
    * @returns          String value representing the accountHolder 
    *                   of this object.
    *                   
    *            
    */
    public String getAccountHolder()
    {
        return  this.accountHolder;
    }

    /**
    * Method :          getExpenseDate
    * Purpose :         Accessor method to return the 
    *                   expenseDate 
    *                   represented by this object.
    *            
    * @param            None.
    * @preconditions    None.
    * @postconditions   None.
    *
    * @returns          Date value representing the expenseDate 
    *                   of this object.
    *                   
    *            
    */
    
    public Date getExpenseDate()
    {
        return this.expenseDate;
    }
    
   /**
    * Method :          addBill
    * Purpose :         Method to add the Bill object to this
    *                   ExpenseAccount ArrayList.
    *            
    * @param            newBill - Bill object to be added.
    * @preconditions    Bill object cannot be null.
    * @postconditions   None.
    *
    * @throws          NuklPointerException when null Bill 
    *                   object added.
    *                   
    *            
    */    
    public void addBill(Bill newBill)
    {
        super.add(newBill);
    }
 
   /**
    * Method :          printExpenseReport
    * Purpose :         Method to print the Data in this
    *                   ExpenseAccount ArrayList. The Iterator
    *                   method is used to print the Bill list.
    *            
    * @param            None.
    * @preconditions    None.
    * @postconditions   None.
    *
    * @returns          None.
    *                   
    *            
    */        
    public void printExpenseReport()
    {
        Iterator expenses = super.iterator();
        if ( ! expenses.hasNext())
            throw new RuntimeException ("No expenses reported");
        System.out.println("Expense Report on " + getExpenseDate() );
        System.out.println("----------------");
        System.out.println("Account Id "+ getExpenseAccountId());
        System.out.println("Account Holder"+ getAccountHolder());
        System.out.println();
        while (expenses.hasNext())
        {
            System.out.println((expenses.next()).toString());
        }
        
    }
    
   /**
    * Method :          main
    * Purpose :         driver method to test
    *                   
    *            
    */        
    
    public static void main (String[] args)
    {
        System.out.println("Driver for ExpenseAccount Class");
        System.out.println ( );
        Date date1 = new Date (1,30,2015);
        ExpenseAccount expAccount = new ExpenseAccount
		                 ("exp101", "reshma", date1);
        Money money01 = new Money(150 ,20 );
        Bill electricityBill  = new Bill 
					( money01, new Date(10,15,2015), "PUD");
        electricityBill.setPaid(    new Date(10,10,2015) );
        System.out.println
			("Add electricityBill "+ electricityBill.toString());
        expAccount.addBill(electricityBill);
        System.out.println ( );
        Money money02 = new Money(40 ,20 );
        Bill waterBill  = new Bill
							( money02, new Date(12,1,2015), "XYZ");
        System.out.println ("Add waterBill "+ waterBill.toString());
        expAccount.addBill(waterBill);
        System.out.println ( );
        Money money03 = new Money(200 ,60 );
        Bill groceryBill = new Bill ( money03, new Date(12,1,2015), "Safeway");
        System.out.println ("Add groceryBill "+ groceryBill.toString());
        expAccount.addBill(groceryBill);
        System.out.println ( );
        System.out.println ("Printing Expense Report");
        System.out.println ( );
        expAccount.printExpenseReport();
    }
}
