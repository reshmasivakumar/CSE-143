
/**
 * Rectangle.java
 * 
 * @author Reshma Sivakumar
 * @version  11/5/2015
 */
import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
public class Rectangle extends Shape
{
    /** Instance Variables of Circle class. **/
    private double length;
    private double breadth;
    
    /**
    * Method :          Constructor
    * Purpose :         Constructor for the Rectangle class takes 
    *                   x and y coordinates and the length and breadth
    *                   of the Rectangle as parameters. The
    *                   constructor calls the parent Shape class 
    *                   constructor to initialize the coordinates and
    *                   the mutator methods to set length and breadth.
    * @param            x - int value. 
    * @param            y - int value.
    * @param            length - int value
    * @param            breadth - int value
    * @preconditions    length and breadth shouldnt be negative.
    * @postconditions   A new Rectangle object is created with the x and
    *                   y coordinates and length and breadth initialized 
    *                   to specified values. 
    */  
    public Rectangle ( int x, int y, double length, double breadth)
    {
        super (x , y);
        setLength ( length ); 
        setBreadth ( breadth );
    }
    
    /**
    * Method :          Constructor
    * Purpose :         Constructor for the Rectangle class takes 
    *                   the length and breadth of the Rectangle as parameters.
    *                   The constructor the mutator methods to set length and breadth.
    * @param            length - int value
    * @param            breadth - int value
    * @preconditions    length and breadth shouldnt be negative.
    * @postconditions   A new Rectangle object is created length and 
    *                   breadth initialized to specified values. 
    */ 
    public Rectangle (double length, double breadth)
    {
        super (0,0);
        setLength ( length ); 
        setBreadth ( breadth );
    }
    
    /**
    * Method  :         setLength
    * Purpose :         Mutator method for setting this object with 
    *                   specified length in double. 
    *
    * @param            length - double value
    * @preconditions    Valid double value - Cannot be negative.
    * @postconditions   The length is set to specified valid values.
    * @throws           RuntimeException when invalid data specified for
    *                   length. 
    */
    public void setLength ( double length )
    {
        if ( length < 0.0 )
            throw new RuntimeException ("length cannot be negative");
            
        this.length = length;      
    }
    
    /**
    * Method :          getLength
    * Purpose :         Accessor method to return the length value 
    *                   represented by this object.
    *            
    * @param            None.
    * @preconditions    None.
    * @postconditions   None.
    *
    * @returns          double value representing the length of this
    *                   object.
    *            
    */ 
    public double getLength ()
    {
        return this.length;
    }
    
    /**
    * Method  :         setBreadth
    * Purpose :         Mutator method for setting this object with 
    *                   specified breadth in double. 
    *
    * @param            breath - double value
    * @preconditions    Valid double value - Cannot be negative.
    * @postconditions   The breadth is set to specified valid values.
    * @throws           RuntimeException when invalid data specified for
    *                   breadth. 
    */
    public void setBreadth ( double breadth )
    {
        if ( breadth < 0.0 )
            throw new RuntimeException ("Breadth cannot be negative");
            
        this.breadth = breadth;      
    }
    
    /**
    * Method :          getBreadth
    * Purpose :         Accessor method to return the breadth value 
    *                   represented by this object.
    *            
    * @param            None.
    * @preconditions    None.
    * @postconditions   None.
    *
    * @returns          double value representing the breadth of this
    *                   object.
    *            
    */ 
    public double getBreadth ()
    {
        return this.breadth;
    }
    
    /** Overriding methods from parent Shape class **/

    /** 
    * Method :          getArea
    * Purpose :         Overriden Accessor method to return the area 
    *                   of this Rectable object. Area is calculated using
    *                   the formula: length * breadth.
    *            
    * @param            None.
    * @preconditions    None.
    * @postconditions   None.
    *
    * @returns          double value representing the area of this
    *                   Rectangle object.
    *            
    */
    
    @Override 
    public double getArea ()
    {
      return this.length * this.breadth;   
    }
    
    /**
    * Method  :         draw
    * Purpose :         Overridden method of Shape superclass which 
    *					calls the Graphics2D class methods to draw
	*					the Rectangle object.
    *                       
    * @param            g - Graphics object.
    * @preconditions    None
    * @postconditions   The Rectangle 0bject is rendered to specified
                                      Grpahics context
    *.
    *  
    */ 
    @Override
    public void draw( Graphics g) {
        if ( ( g == null) || (!(g instanceof Graphics ) ) )
            throw new RuntimeException ("Invalid Graphics object");
        Graphics2D g2d = (Graphics2D) g;
        
        final int x = getX();
        final int y = getY();
        
        g2d.setColor ( Color.RED );
        g2d.setPaint( new GradientPaint( 0, 0, Color.RED, 100, 0, Color.RED) );
        int  xOffset = (int) (Math.random()*50);
        int  yOffset = (int) (Math.random()*50);
        for( int i = 0; i < 30; i++) 
        {
            g2d.drawRect(x+xOffset+500, y+yOffset+200 , (int) length, (int) breadth);
        }
    }
}
