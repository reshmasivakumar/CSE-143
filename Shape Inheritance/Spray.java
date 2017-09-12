import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;

/**
 * Spray.java - Class respresenting Spray object.
 * 
 * 
 * Description: This Spray class is inherited from it's parent class Shape.
 *              The draw () method of Shape class are overriden with 
 *              functionality specific to Spray class.
 *         
 * 
 */
class Spray extends Shape {
    /** Instance variables **/
    private final int RADIUS = 20;
    private final int DENSITY = 10;
    
    /**
    * Method :          Constructor
    * Purpose :         Constructor for the Spray class takes 
    *                   a and b coordinates as parameters and
    *                   calls the parent Shape class constructor
    *                   to initialize.
    * @param            a - int value. 
    * @param            b - int value.
    * @preconditions    none.
    * @postconditions   A new Spray object is created with the x and
    *                   y coordinates initialized to specified values. 
    */      
    public Spray( int a, int b ) {
        super( a, b);   //we explicitly call a superclass constructor 
                        //that takes 2 ints
    }
    
    /**
    * Method  :         draw
    * Purpose :         Overridden method of Shape superclass which 
    *                   calls the Graphics2D class methods to draw
    *                   the Spray object.
    *                       
    * @param            g - Graphics object.
    * @preconditions    None
    * @postconditions   The Spray 0bject is rendered to specifed Graphics
    *                   context.
    *  
    */  
    public void draw( Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        
        final int x = getX();
        final int y = getY();
        
        g2d.setColor( Color.GREEN );
        g2d.setPaint( new GradientPaint( x, y, Color.GREEN, x + RADIUS/4,
                      y + RADIUS/4, Color.BLACK, true) );
        
        int xOffset = 0;
        int yOffset = 0;
        
        for( int i = 0; i < DENSITY; i++) 
        {
            xOffset = (int) (Math.random()*RADIUS);
            yOffset = (int) (Math.random()*RADIUS);
            g2d.draw( new Ellipse2D.Double( x + xOffset, y + yOffset, 
                      x + xOffset+3, y + yOffset+3) );
        }
    }
}