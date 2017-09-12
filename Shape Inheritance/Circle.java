/**
 * Circle.java - Class respresenting Circle object.
 * 
 * @author Reshma Sivakumar
 * @version (a version number or a date)
 * 
 * Description: This class is inherited from it's parent class Shape.
 *              The getArea () and draw () methods of Shape class are
 *              overriden with functionality specific to Circle class.
 *              
 */

import java.awt.geom.Ellipse2D;
import java.awt.*;
import javax.swing.JPanel;

public class Circle extends Shape
{
    /** Instance Variables of Circle class. **/
    private double radius; // radius of the circle which determines
							// the size of the circle.
    
    /**
    * Method :          Constructor
    * Purpose :         Constructor for the Circle class takes 
    *                   x and y coordinates as parameters and
    *                   calls the parent Shape class constructor.
    *                   to initialize.
    * @param            x - int value. 
    * @param            y - int value.
    * @preconditions    none.
    * @postconditions   A new Circle object is created with the x and
    *                   y coordinates initialized to specified values. 
    */  
    public Circle ( int x, int y )
    {
        super ( x, y );
        setRadius (0.0);
    }  
    
    /**
    * Method :          Constructor
    * Purpose :         Constructor for the Circle class takes 
    *                   x and y coordinates and radius as parameters
    *                   calls the parent Shape class constructor.
    *                   to initialize.
    * @param            x - int value. 
    * @param            y - int value.
    * @param            radius - double value.
    * @preconditions    none.
    * @postconditions   A new Circle object is created with the x and
    *                   y coordinates initialized to specified values. 
    */  
    public Circle ( int x, int y, double radius )
    {
        super ( x, y );
        setRadius (radius);
    }  
    
    /**
    * Method  :         setRadius
    * Purpose :         Mutator method for setting this object with 
    *                   specified radius in double. 
    *
    * @param            radius - double value
    * @preconditions    Valid double value - Cannot be negative.
    * @postconditions   The radius is set to specified valid values.
    * @throws           RuntimeException when invalid data specified for
    *                   radius. 
    */
    public void setRadius ( double radius )
    {
        if ( radius < 0 )
            throw new RuntimeException (" Cannot set negative value for radius");
        
        this.radius = radius;
    }
    
    /**
    * Method :          getRadius
    * Purpose :         Accessor method to return the radius value 
    *                   represented by this object.
    *            
    * @param            None.
    * @preconditions    None.
    * @postconditions   None.
    *
    * @returns          double value representing the radius of this
    *                   object.
    *            
    */ 
    public double getRadius()
    {
        return this.radius;
    }
    
    /** Overriding methods from parent Shape class **/

    /** 
    * Method :          getArea
    * Purpose :         Overriden Accessor method to return the area 
    *                   of this Circle object. Area is calculated using
    *                   the formula: pi* radius^2
    *            
    * @param            None.
    * @preconditions    None.
    * @postconditions   None.
    *
    * @returns          double value representing the area of this
    *                   Circle object.
    *            
    */
    @Override
    public double getArea ()
    {
        double area = Math.PI * ( this.radius * this.radius );
        return area;
    }
    
    /**
    * Method  :         draw
    * Purpose :         Overridden method of Shape superclass which 
    *					calls the Graphics2D class methods to set the
	*					color of the Circle and draw a Circle filled 
	*					with that onto the Jpanel which calls it.
    *                       
    * @param            g - Graphics object of Jpanel.
    * @preconditions    None
    * @postconditions   The Circle shape is rendered to Jpanel.
    *  
    */
    @Override
    public void draw ( Graphics g )
    {
 	
        Graphics2D g2D = (Graphics2D) g;
        g2D.setColor( Color.GREEN );
 
        g2D.setPaint( new GradientPaint( super.getX(), super.getY(), 
				    Color.BLACK, super.getX()+ (int)this.getRadius()/4,
				    super.getY()+ (int)this.getRadius()/4, Color.GREEN, true) );
        
    
        for( int i = 0; i < 30; i++) {
             int  xOffset = (int) (Math.random()*50)  ;
             int  yOffset = (int) (Math.random()*50)  ;
             g2D.fill (new Ellipse2D.Double ( super.getX() + 800 + xOffset,
				      super.getY()+yOffset, 1.25 * this.getRadius(),
				      1.50 * this.getRadius() ));
        }
     }
    }