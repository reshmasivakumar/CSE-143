import java.io.*;

/*
 * BillMoneyDateDriver.java - Simple driver to test Money, Date, Bill 
                              and ExpenseAccount classes.
 * 
 * @author Reshma Sivakumar  
 * @version  2.0 11/01/2015
 *
 * Description:   This class contains the test cases to test the
 *                constructors and the methods in Money, Date and 
 *                Bill classes. The test methods for each class
 *                is designed to run the positive cases (valid data)
 *                for all methods and then the negative cases. In
 *                case of negative tests, the class throws exceptions 
 *                which are caught and displayed to user.
 *                Test drivers for Homework 8 is for testing 
 *                Comparable, Cloneable and Serializable
 *                interface implementation.
 *               
 */

public class BillMoneyDateDriver
{
    /**
    * Method :          main driver function
    * Purpose :         To tests all the methods of Money,
    *                   Date and Bill classes. Calls the 
    *                   test method calls for the classes.
    * @preconditions    None.       
    * @postconditions   Exercises the methods in Bill, Money, and Date.
    */
 
    public static void main(String[] args)
    {
        BillMoneyDateDriver driver = new BillMoneyDateDriver();
        
        System.out.println(" Driver methods to test HW3 ");
        driver.testMoney(); //driver for Money class
        driver.testDate(); //driver for Date class
        driver.testBill(); //driver for Bill class
        
        System.out.println(" Driver methods to test HW8 ");
        driver.testMoneyHW8();
        driver.testDateHW8();
        driver.testBillHW8();
        driver.testExpenseAccountHW8();
         
          //Construct some bills
         /* try
        {
            Money amount = new Money(20);
            Date dueDate = new Date(4, 30, 2007);
            Bill bill1 = new Bill(amount, dueDate, "The phone company");
            
            Bill bill2 = new Bill(bill1);
            bill2.setDueDate(new Date(5, 30, 2007));
            amount.setMoney(31, 99);
            dueDate.setDay(29);
            Bill bill3 = new Bill(amount, dueDate, "The record company");
            
            System.out.println("Bill objects output:");
            System.out.println(bill1);
            System.out.println(bill2);
            System.out.println(bill3);
        }catch ( RuntimeException re )
        {
            System.out.println(re.getMessage());
            System.exit(0);
        }
              */
        
    }
 
    /**
    * Method :          log 
    * Purpose :         Helper method to print the messages
    *                   to console.
    * @preconditions    None.       
    * @postconditions   None.
    */
   
    private void log(String msg)
    {
        if (msg.equals(null))
            System.out.println();
        else
            System.out.println(msg);
     }

    /**
    * Method :          log 
    * Purpose :         Helper method to print the blank line
    *                   to console.
    * @preconditions    None.       
    * @postconditions   None.
    */
   
    private void log()
    {
        System.out.println();
    }

    /**
    * Method :          testBill 
    * Purpose :         Method to excercise methods on Bill
    *                   class. First the Positive tests are
    *                   run and then the negative tests.
    *                   All the exceptions thrown by the negative
    *                   conditions are caught and printed to
    *                   Console.
    * @preconditions    None.       
    * @postconditions   None.
    */
   
    private void testBill()
    {
        try 
        {
            log ("****Running Positive tests for Bill class- start ****");
            log();
            log ("** Constructors - start ** ");
            log();
            log ( "Create bill1 with Money(10,20), Date(10,1,2015), ABC Corp");    
            Money money01 = new Money(10 ,20 );
            Bill bill1  = new Bill ( money01, new Date(10,1,2015), "ABC Corp");
            log (bill1.toString());

            log ( "Create copyBill1 cloning  bill1");
            Bill copyBill1 = (Bill)bill1.clone();
            log(copyBill1.toString());
            log();
            log ("** Constructors - end ** ");
            log();  
            
            log ("** Mutators- start ** ");
            log();
            log ("Set bill1 Paid on 9,2,2015");
            bill1.setPaid(new Date(9,2,2015)); 
            log("bill1 " + bill1.toString());
            
            log ("Set bill1 duedate as 11,1,2015");
            bill1.setDueDate(new Date( 11,1,2015 ));
            log("bill1 " + bill1.toString());
            
            log("Setting bill1 shouldnot change copyBill1");
            log("copyBill1 " + copyBill1.toString()); 
            
            log ("Set bill1 to unpaid");
            bill1.setUnpaid();
            log("bill1 " + bill1.toString());
            
            log ("Set bill1 duedate as 11,1,2015");
            bill1.setDueDate(new Date( 11,1,2015 ));
            log("bill1 " + bill1.toString());
            
            log ("Set bill1 amount as 200");
            bill1.setAmount(new Money(200,0));
            log("bill1 " + bill1.toString());
            
            log("Setting bill1 shouldnot change copyBill1 amount ");
            log("copyBill1 " + copyBill1.toString()); 
            
            log ("Set bill1 originator as BCD Corp");
            bill1.setOriginator("BCD Corp");
            log("bill1 " + bill1.toString());
            log();
            log ("** Mutators- end ** ");      
            log();
            log("** Accessors - start **");
            log();
            log("Get amount of bill1");
            System.out.println(bill1.getAmount ());;
            log("Get due date of bill1");
            System.out.println( bill1.getDueDate( ));
            log("Get originator of bill1");
            System.out.println( bill1.getOriginator());
            log("Get Paid date of bill1");
            System.out.println( bill1.getPaidDate() );
            log("Check if bill1 paid");
            System.out.println( bill1.isPaid() );
            log ("Set bill1 Paid on 9,2,2015");
            bill1.setPaid(new Date(9,2,2015)); 
            log("bill1 " + bill1.toString());
            log("Check now if bill1 paid");
            System.out.println( bill1.isPaid() );
            
            log("** Accessors - end**");
            log();
            log("** Bill equals method test **");
            log();    
            log ("bill1 " + bill1);
            log ( "Create bill2 with Money(10,20), Date(11,1,2015), AC1 Corp"); 
            Money money111 = new Money(10,20);
            Bill bill2  = new Bill(money111, new Date(11,1,2015), "AC1 Corp");
            log ("bill2 "+ bill2.toString());
            Bill copybill2 = new Bill(bill2);
            log("copybill2 "+ copybill2);
            log("** Check bill1 equals bill2");           
            if (bill1.equals ( bill2 ))
                log ("bill1 and bill2 are equal ");
            else
                log ("bill1 and bill2 are not equal ");
            
            log("** Check bill2 equals copybill2 ");           
            if (bill2.equals ( copybill2 ))
                log ("bill2 and copybill2 are equal ");
            else
                log ("bill12 and copybill2 are not equal ");
            log();
            log ("****End Positive tests for Bill class ****");
            log();
            log ("****Running Negative for Bill class ****");
            log();
            log ("** Constructors - start ** ");
            log();
            
            try
            {   
                log ( "Create bill12 with null, Date(10,1,2015), ABC Corp");    
                Bill bill12  = new Bill(null, new Date(10,1,2015), "ABC Corp");
            } catch (RuntimeException re)
            {
                log (re.getMessage());
            }    
            
            try
            {
                log ( "Create bill12 with Amount(20,10), null, ABC Corp");    
                Bill bill12  = new Bill (new Money(20,10), null, "ABC Corp");
            } catch (RuntimeException re)
            {
                log (re.getMessage());
            }    
            
            try
            {
                log ( "Create bill12 as Amount(20,10),Date(10,1,2015), null");   
                Money money12 = new Money(20,10);
                Bill bill12  = new Bill (money12, new Date(10,1,2015), null);
            } catch (RuntimeException re)
            {
                log (re.getMessage());
            }    
              
            log();
            log ("** Constructors - end ** ");
            log();
            log ("** Mutators- start ** ");
            log();
            
            try
            {
                log ("Set bill1 Paid on null");
                bill1.setPaid(null); 
            } catch (RuntimeException re)
            {
                log (re.getMessage());
            }          
           
            try
            {
                log ("Get bill1 dueDate");
                System.out.println(bill1.getDueDate());
                log ("Set bill1 PaidDateDate to (9,2,2016)");
                bill1.setPaid(new Date(9,2,2016)); 
            } catch (RuntimeException re)
            {
                log (re.getMessage());
            }  
            
            try
            {
                log ("Set bill1 duedate Date( 8,2,2015 )");
                bill1.setDueDate(new Date( 8,2,2015 ));
            } catch (RuntimeException re)
            {
                log (re.getMessage());
            }    
            
            try
            {
                log ("Set bill1 duedate as null");
                bill1.setDueDate(null);
            } catch (RuntimeException re)
            {
                log (re.getMessage());
            }          
            
            try
            {
                log ("Set bill1 amount as null");
                bill1.setAmount(null);
            } catch (RuntimeException re)
            {
                log (re.getMessage());
            }    
            
            try
            {
                log ("Set bill1 amount as Money(-100,0)");
                bill1.setAmount(new Money(-100,0));
            } catch (RuntimeException re)
            {
                log (re.getMessage());
            }    
            
            try
            {   
                log ("Set bill1 originator as null");
                bill1.setOriginator(null);
            } catch (RuntimeException re)
            {
                log (re.getMessage());
            }    
            
            log();
            log ("** Mutators- end ** ");      
            log();
            log ("** Compare Bills for equality ** ");      
            log();
            log ("bill1 " + bill1);
            
            try
            {
                log("Check bill1 equals null");           
                if (bill1.equals ( null ))
                    log ("Error: bill1 shows as equals null ");
                else
                    log ("Not equal ");
            } catch (RuntimeException re)
            {
                log ("Error: "+re.getMessage());
            }              
    
            log ("****End Negative tests for Bill class ****");
            log();
            //TODO: do more functional exercises with the money class
  
        }catch ( RuntimeException re )
        {
            System.out.println(re.getMessage());
            System.exit(0);
        }
    }

    /**
    * Method :          testMoney 
    * Purpose :         Method to excercise methods on Money
    *                   class. First the Positive tests are
    *                   run and then the negative tests.
    *                   All the exceptions thrown by the negative
    *                   conditions are caught and printed to
    *                   Console.
    * @preconditions    None.       
    * @postconditions   None.
    */
    private void testMoney()
    {
        try 
        {
            //TODO: do more functional exercises with the money class
    
            log ("****Running Positive tests for Money class - start ****");
            log ();
            log ("** Constructors - start ** ");
            log();
            log ( "Create money1 with dollars 10");    
            Money money1 = new Money(10);
            log (money1.toString());
            log ( "Create money2 with dollars=210 and cents=80");
            Money money2 = new Money(210,80);
            log(money2.toString());
            log ( "Calling Clone with money2");
            Money copyMoney2 = (Money)money2.clone();
            log(copyMoney2.toString());
            log();
            log ("** Constructors - end ** ");
            log();
            
            log ("** Mutators- start ** ");
            log();
            log ("Set money1 dollars=50");
            money1.setDollars(50);
            log(money1.toString());
            log ("Set money1 cents=30");
            money1.setCents (30);
            log(money1.toString());
            log ("Set money1 dollars=30, cents=50");
            money1.setMoney(30,75);
            log(money1.toString());
            log ("** Mutators- end ** ");              
            log();
            log("** Accessors - start **");
            log();
            log("Call to getMoney() of money1");
            System.out.println(money1.getMoney ());
            log();
            log("** Accessors - end **");
            log();
            log ( "** Add methods -start  ** ");
            log();
            log("Add 20 dollars to money1");
            money1.add(20);
            log (money1.toString()); 
            log ("Add dollars=30, cents=20 to money1");
            money1.add(30, 20);
            log(money1.toString());
            log("money1= "+money1);
            log("money2= "+money2);
            money1.add ( money2 );
            log ("Add money2 to money1 "+money1.toString());
            log ();
            log ( "** Add methods -end  ** ");
            log();          
            log(" *** Check equals method ***");   
            log("money1 "+ money1);
            log("money2 "+ money2);
            log("copyMoney2  "+ copyMoney2);
            if (money1.equals ( money2 ))
               log ("money1 and money2 are equal ");
            else
               log ("money1 and money2 are not equal ");
              
            if (money2.equals ( copyMoney2 ))
                log ("money2 and copyMoney2 are equal ");
            else
                log ("money2 and copyMoney2 are not equal ");
            log();
            log ("**** End Positive tests for Money class ****");
            log();
            log ("****Running Negative tests for Money class ****");
            log();
            log ("** Constructors - start ** ");
            log();
            try
            {       
                log ( "Create money1 with dollars -10");    
                Money money11 = new Money(-10);
            } catch (RuntimeException re)
            {
                log (re.getMessage());
            }
            
            try
            {
                log ( "Create money2 with cents > 99");
                Money money12 = new Money(40,180);
            } catch (RuntimeException re)
            {
                log (re.getMessage());
            }
    
            try
            {
                log ( "Create money2 with cents < 0");
                Money money12 = new Money(40,-10);
            } catch (RuntimeException re)
            {
                log (re.getMessage());
            }
        
            log();
            log ("** Constructors - end ** ");
            log();      
            log ("** Mutators- start ** ");
            log();
                 
            try
            {
                log("money1= "+money1);
                log ("Set money1 dollars to -50");
                money1.setDollars(-50);
            } catch (RuntimeException re)
            {
                log (re.getMessage());
            }     
            
            try
            {
                log("money1= "+money1);
                log ("Set money1 cents to 130");
                money1.setCents (130);
            } catch (RuntimeException re)
            {
                log (re.getMessage());
            }     
            
            try
            {       
                log("money1= "+money1);
                log ("Set money1 dollars to 30, cents to 150");
                money1.setMoney(30,150);
            } catch (RuntimeException re)
            {
                log (re.getMessage());
            }     
            
            log ("** Mutators- end ** ");      
            log();        
            log ( "** Add methods -start  ** ");
            log();
            
            try
            {   
                log("Add -20 dollars to money1");
                money1.add(-20);
            } catch (RuntimeException re)
            {
                log(re.getMessage());
            }     
            
            try
            {   
                log("Add dollars=30, cents=199 to money1");
                money1.add(30,199);
            } catch (RuntimeException re)
            {
                log (re.getMessage());
            }     
            
            try
            {   
                log("Add null to money1");
                money1.add(null);
            } catch (RuntimeException re)
            {
                log (re.getMessage());
            }     
            
            try
            {   
                log("Add object with invalid data to money1");
                money1.add(new Money(-10,90));
            } catch (RuntimeException re)
            {
                log (re.getMessage());
            }     
            log ();
            log ( "** Add methods -end  ** ");
            log();          
            log ("** check equals **");
            log();
            log ("money1= "+money1);
            log("Comparing money1 equals null");           
            if (money1.equals ( null))
              log("Error: money1 and null shows equal");
            else
              log("Error: money1 and null not equal");
            if (money1.equals ( new Date(1,1,2015)))
              log("Error: money1 and Date object shows equal");
            else
              log("Error: money1 and Date object not equal");
            log();  
            log ("****End Negative tests for Money class ****");
        }catch ( RuntimeException re )
        {
            System.out.println(re.getMessage());
            System.exit(0);
        }
    }
     
    /**
    * Method :          testDate 
    * Purpose :         Method to excercise methods on Date
    *                   class. First the Positive tests are
    *                   run and then the negative tests.
    *                   All the exceptions thrown by the negative
    *                   conditions are caught and printed to
    *                   Console.
    * @preconditions    None.       
    * @postconditions   None.
    */
    private void testDate()
    {
        log ("****Running Positive tests for Date class ****");
        log();
        log ("** Constructors - start ** ");
        log();
        
        log ( "Create date1 as March, 26, 2015");    
        Date date1 = new Date ("March", 26, 2015);
        log (date1.toString());     
        
        log ( "Create date2 as 3, 26, 2015");  
        Date date2  = new Date (3, 26, 2015);
        log (date2.toString());
        
        log ("Copy date2 to date3 using Clone");
        Date date3 =  (Date) date2.clone();
        log (date3.toString());
        
        log ();
        log ("** Constructors - end ** ");
        log ();
 
        
        log ("** Mutators- start ** ");
        log ();
        
        log ("Set date1 as April, 3, 2015");
        date1.setDate  ("April", 3, 2015);
        log ("date1 after set: "+date1);
        
        log ("Set date2 as 5, 3, 2015");
        date2.setDate (5, 3, 2015);
        log ("date2 after set: "+date1); 
        
        log ();
        log ("** Mutators- - end ** ");
        log ();
        
        log ("** Accessors - start ** ");
        log ();
        log ("Get date1 month");
        System.out.println(date1.getMonth());
        
        log ("Get date1 day");
        System.out.println(date1.getDay());
        
        log ("Get date1 year");
        System.out.println(date1.getYear());

        log ("Get date1 object as Date");
        System.out.println(date1.getDate());
        log ();
        log ("** Accessors - end ** ");      
        log ();
        log ("** Date Comparisons - start ** ");      
        log ();
        log ("date1 "+ date1);
        log ("date2 "+ date2);
        Date date4 = new Date (date1);
        log("date4 "+ date4);
 
        log ("date1 precedes date2 ?");
        if (date1.precedes ( date2 ))
            log ("Date "+ date1.toString() + " precedes "+ date2.toString());
        else
            log ( "Date "+ date1.toString() + " later "+ date2.toString());
        log ("date2 precedes date1?");
        if (date2.precedes ( date1 ))
            log ("Date "+ date2.toString() + " precedes "+ date1.toString());
        else
            log ( "Date "+ date2.toString() + " succeeds "+ date1.toString());
        log ();
        log ("Check date1 equals date2");
        if ( date1.equals ( date2 ) )
            log ( date1.toString() +" and "+ date2.toString() + " are equal" );
        else
            log( date1.toString() +" and "+ date2.toString() + " not equal" );
        log ("Check date1 equals date3");
        if ( date1.equals ( date4 ) )
            log ( date1.toString() +" and "+ date4.toString() + " are equal" );
        else
            log( date1.toString() +" and "+ date4.toString() + " not equal" );   
        
        log("Comparing date1 to new Date as April, 3, 2015");
        if ( date1.equals (  new Date ("April", 3, 2015) ) )
            log ( "dates are equal" );
        else
            log( "dates are not equal" );          
        log();
        log ("**** End Positive tests for Date class ****");
        log(); 
        
        log ("****Running Negative tests for Date class ****");
        log();
        log ("** Constructors - start ** ");
        log();
        
        try
        {
            log ( "Create date11 as null, 26, 2015");    
            Date date11 = new Date (null, 26, 2015);
            log (date11.toString());     
        } catch (NullPointerException re)
        {
            log(re.getMessage());
        }
         
        try
        {
            log ( "Create date12 as 3, 65, 2015");  
            Date date12  = new Date (3, 65, 2015);
            log (date12.toString());
        } catch (RuntimeException re)
        {
            log(re.getMessage());
        }
        
        try
        {
            log ( "Create date12 as 3, 5, 2999");  
            Date date12  = new Date (3, 5, 2999);
            log (date12.toString());
        } catch (RuntimeException re)
        {
            log(re.getMessage());
        }       
        
        try
        {
            log ( "Create date12 as 73, 2, 2015");  
            Date date12  = new Date (73, 2, 2015);
            log (date12.toString());
        } catch (RuntimeException re)
        {
            log(re.getMessage());
        }       
        
        try
        {
            log ( "Create date12 as Jaaary, 2, 2015");  
            Date date12  = new Date ("Jaaary", 2, 2015);
            log (date12.toString());
        } catch (RuntimeException re)
        {
            log(re.getMessage());
        }   
        log ();
        log ("** Constructors - end ** ");
        log ();
        log ("** Mutators- start ** ");
        log ();
        try
        {            
            log ("Set date1 as null, 3, 2015");
            date1.setDate  (null, 3, 2015);
 
        } catch (RuntimeException re)
        {
            log(re.getMessage());
        }
        
        try
        {            
            log ("Set date2 as 5, 53, 2015");
            date2.setDate (5, 3, 2015);

        } catch (RuntimeException re)
        {
            log(re.getMessage());
        }
        
        log ();
        log ("** Mutators- - end ** ");
        log ();
 
        log ("** Date Comparisons - start ** ");      
        log ();
        log ("date1 "+ date1);
        log ("date2 "+ date2);
 
        try
        {
            log ("Compare date1 to null");
            if (date1.precedes ( null ))
                log ("Date "+ date1.toString() + " precedes "+ date2.toString());
            else
                log ( "Date "+ date1.toString() + " later "+ date2.toString());

        } catch (RuntimeException re)
        {
            log(re.getMessage());
        }                
                
          try
        {
            log ("Compare date1 to Money");
            if (date1.equals ( new Money(10,20)))
                log("Error: date1 and money shows equal");
            else
                log("date1 and money not equal");            

        } catch (RuntimeException re)
        {
            log(re.getMessage());
        }                
        log();
        log ("**** End Negative tests for Date class ****");
        log(); 
    }
 
 
    /**
    * Method:           testMoneyHW8 
    * Purpose:          To test the methods in Money class
    *                   that implements Comparable, 
    *                   Cloneable and Serializable
    *                   interface implementation.
    * 
    * @preconditions    None.       
    * @postconditions   None.
    */
   
    private void testMoneyHW8()
    {
        try 
        {
            log ("****Running tests for Money class HW8 - start ****");
            log ();
            log();
            log ( "Create money1 with dollars 10");    
            Money money1 = new Money(10);
            log (money1.toString());
            log ( "Create money2 with dollars=210 and cents=80");
            Money money2 = new Money(210,80);
            log(money2.toString());
            
            log("Calling compareTo on money1 and money2");
            if (money1.compareTo(money2) < 0)
                log("money1 is less than money2");
            else if (money1.compareTo(money2) > 0)
                log("money1 is greater than money2");
            else
                log("money1 is equal to money2");
                
            log();
            log ( "Create money3 with dollars=500 and cents=10");
            Money money3 =  new Money (500,10);
            log(money3.toString());
            
            log("Calling compareTo on money2 and money3");
            if (money2.compareTo(money3) < 0)
                log("money2 is less than money3");
            else if (money2.compareTo(money3) > 0)
                log("money2 is greater than money3");
            else
                log("money2 is equal to money3");
            
            log();
            log("Clone money3 to money4");
            Money money4 = (Money)money3.clone();
            log(money4.toString());     
            if (money3.compareTo(money4) == 0)
                log("money3 was cloned successfully");
                
            log();
            try
            {
                log("Test Serializable methods for Money class");
                log("Writing serialized money1 object to MoneyTest.txt");
                File f = new File ("c:\\temp\\MoneyTest.txt");
                FileOutputStream outFile = new FileOutputStream(f);
                ObjectOutputStream outStream = new ObjectOutputStream(outFile);
                outStream.writeObject(money1);
                outStream.flush();
                outStream.close();    
                
                log();
                log("Reading serialized money object from MoneyTest.txt");
                FileInputStream inFile = new FileInputStream(f);
                ObjectInputStream inStream = new ObjectInputStream(inFile);
                Money newMoney = (Money)inStream.readObject();
                log ( "Printing serialized money1 object read from file" );
                log ( newMoney.toString() );
                
                
            } catch (IOException ioe)
            {
               log (ioe.getMessage());
            }   
            catch (ClassNotFoundException cne)
            {
                log (cne.getMessage());
            }
                
        } catch (RuntimeException re)
        {
            log(re.getMessage());
        }                

        log();
        log ("**** End tests for Money class HW8 - End****");
        log();     
    }        

    /**
    * Method:           testDateHW8 
    * Purpose:          To test the methods in Date class
    *                   that implements Comparable, 
    *                   Cloneable and Serializable
    *                   interface implementation.
    * 
    * @preconditions    None.       
    * @postconditions   None.
    */
   
    private void testDateHW8()
    {
        try 
        {
            log ("****Running tests for Date class HW8 - start ****");
            log ();
            log ("** Constructors - start ** ");
            log();
            
            log ( "Create date1 as March, 26, 2015");    
            Date date1 = new Date ("March", 26, 2015);
            log (date1.toString());     
            
            log ( "Create date2 as 3, 26, 2015");  
            Date date2  = new Date (3, 26, 2015);
            log (date2.toString());
                 
            log("Calling compareTo on date1 and date2");
            if (date1.compareTo(date2) < 0)
                log("date1 is less than money2");
            else if (date1.compareTo(date2) > 0)
                log("date1 is greater than date2");
            else
                log("date1 is equal to date2");
                
            log();
            log ( "Create date3 as 8, 26, 2015");
            Date date3 =  new Date (8, 26, 2015);
            log(date3.toString());
            
            log("Calling compareTo on date2 and date3");
            if (date2.compareTo(date3) < 0)
                log("date2 is less than date3");
            else if (date2.compareTo(date3) > 0)
                log("date2 is greater than date3");
            else
                log("date2 is equal to date3");
            
            log();
            log("Clone date3 to date4");
            Date date4 = (Date)date3.clone();
            log(date4.toString());     
            if (date3.compareTo(date4) == 0)
                log("date3 was cloned successfully");
                
            log();
            try
            {
                log("Test Serializable methods for Date class");
                log("Writing serialized date1 object to DateTest.txt");
                File f = new File ("c:\\temp\\DateTest.txt");
                FileOutputStream outFile = new FileOutputStream(f);
                ObjectOutputStream outStream = new ObjectOutputStream(outFile);
                outStream.writeObject(date1);
                outStream.flush();
                outStream.close();    
                
                log();
                log("Reading serialized date object from DateTest.txt");
                FileInputStream inFile = new FileInputStream(f);
                ObjectInputStream inStream = new ObjectInputStream(inFile);
                Date newDate = (Date)inStream.readObject();
                log ( "Printing serialized date1 object read from file" );
                log ( newDate.toString() );
                
                
            } catch (IOException ioe)
            {
               log (ioe.getMessage());
            }   
            catch (ClassNotFoundException cne)
            {
                log (cne.getMessage());
            }
                
        } catch (RuntimeException re)
        {
            log(re.getMessage());
        }                

        log();
        log ("**** End tests for Date class HW8 - End****");
        log();     
    }  
    
    /**
    * Method:           testBillHW8 
    * Purpose:          To test the methods in Bill class
    *                   that implements Comparable, 
    *                   Cloneable and Serializable
    *                   interface implementation.
    * 
    * @preconditions    None.       
    * @postconditions   None.
    */
   
    private void testBillHW8()
    {
        try 
        {
            log ("****Running tests for Bill class HW8 - start ****");
            log ();  
            log ( "Create bill1 with Money(50,20), Date(10,1,2015), ABC Corp");    
            Money money01 = new Money(50 ,20 );
            Bill bill1  = new Bill ( money01, new Date(10,1,2015), "ABC Corp");
             
            log ("bill1 "+ bill1.toString());
            log ( "Create bill2 with Money(10,20), Date(11,1,2015), AC1 Corp");   
            Money money111 = new Money(10,20);
            Bill bill2  = new Bill(money111, new Date(11,1,2015), "AC1 Corp");
            log ("bill2 "+ bill2.toString());
            log();
            log("Calling compareTo on bill1 and bill2");
            if (bill1.compareTo(bill2) < 0)
                log("bill1 amount is less than bill2");
            else if (bill1.compareTo(bill2) > 0)
                log("bill1 is greater than bill2");
            else
                log("bill1 is equal to bill2");
                
            log();
            log ( "Create bill3 with Money(60,20), Date(10,1,2015), AC1 Corp");   
            Money money112 = new Money(60,20);
            Bill bill3  = new Bill(money112, new Date(10,1,2015), "AC1 Corp");
            log ("bill3 "+ bill3.toString());
            log(); 
            log("Calling compareTo on bill2 and bill3");
            if (bill2.compareTo(bill3) < 0)
                log("bill2 is less than bill3");
            else if (bill2.compareTo(bill3) > 0)
                log("bill2 is greater than bill3");
            else
                log("bill2 is equal to bill3");
            
            log();
            log("Clone bill3 to bill4");
            Bill bill4 = (Bill)bill3.clone();
            log("bill4 "+ bill4.toString());     
            if (bill3.compareTo(bill4) == 0)
                log("bill3 was cloned successfully");
                
            log();
            try
            {
                log("Test Serializable methods for Bill class");
                log("Writing serialized bill1 object to BillTest.txt");
                File f = new File ("c:\\temp\\BillTest.txt");
                FileOutputStream outFile = new FileOutputStream(f);
                ObjectOutputStream outStream = new ObjectOutputStream(outFile);
                outStream.writeObject(bill1);
                outStream.flush();
                outStream.close();    
                
                log();
                log("Reading serialized Bill object from BillTest.txt");
                FileInputStream inFile = new FileInputStream(f);
                ObjectInputStream inStream = new ObjectInputStream(inFile);
                Bill newBill = (Bill)inStream.readObject();
                log ( "Printing serialized bill1 object read from file" );
                log ( newBill.toString() );
              
            } catch (IOException ioe)
            {
               log (ioe.getMessage());
            }   
            catch (ClassNotFoundException cne)
            {
                log (cne.getMessage());
            }    
        } catch (RuntimeException re)
        {
            log(re.getMessage());
        }                

        log();
        log ("**** End tests for Bill class HW8 - End****");
        log();     
    }        

    /**
    * Method:           testExpenseAccountHW8 
    * Purpose:          To test the methods in ExpenseAccount
    *                   class which extends ArrayList 
    *                   class which implements Iterable 
    *                   interface.  
    * 
    * @preconditions    None.       
    * @postconditions   None.
    */
   
    private void testExpenseAccountHW8()
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
