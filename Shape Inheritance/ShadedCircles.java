
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * ShadedCircles.java - Class respresenting ShadedCircles object.
 * 
 * 
 * Description: This ShadedCircles class is inherited from Circle class which
 *              is subclass of Shape superclass.
 *              The getArea() and draw () methods of Shape class are overriden
 *              with functionality specific to Spray class.
 *        
 * 
 * @author Reshma Sivakumar  
 * @version  1.0 11/9/2015
 *
 *
 */
public class ShadedCircles extends Circle
{
    /**
    * Method :          Constructor
    * Purpose :         Constructor for the ShadedCircles class takes 
    *                   x and y coordinates and radius as parameters and
    *                   calls the parent Shape class constructor.
    *                   to initialize.
    * @param            x - int value. 
    * @param            y - int value.
    * @param            radius - int value.
    * @preconditions    valid parameters.
    * @postconditions   A new ShadedCircles object is created with the x and
    *                   y coordinates and radius initialized to specified values. 
    */     
    public ShadedCircles ( int x, int y, double radius )
    {
       super ( x, y, radius );
    }

    /**
    * Method  :         draw
    * Purpose :         Overridden method of Shape superclass which 
    *                   calls the Graphics2D class methods to set the
    *                   color of the upper half of circle to Black and
    *                   lower to White. The outer circle has a smaller
    *                   inner circle.
    *                       
    * @param            g - Graphics object of Jpanel.
    * @preconditions    None.
    * @postconditions   The ShadedCircles shape is rendered to Graphics context.
    *  
    */    
    @Override
    public void draw ( Graphics g )
    {
        if ( ( g == null) || (!(g instanceof Graphics ) ) )
            throw new RuntimeException ("Invalid Graphics object");
        int radius = (int) getRadius();
        int xOffset = (int) (Math.random()* radius) + 20;
        int yOffset = (int) (Math.random()* radius) + 20 ;
       
       
        g.setColor (Color.BLACK);
        g.fillArc ( 0 + xOffset, 0 + yOffset, radius * 2, radius * 2, 0, 180 );
       
        g.setColor (Color.WHITE);
        g.fillArc ( 0 + xOffset, 0 + yOffset, radius * 2, radius * 2, 0, -180 );
       
        g.setColor (Color.WHITE);
        g.fillArc ( 0 + xOffset, radius / 2 + yOffset, radius, radius, 0, 180 );
        
        g.setColor (Color.BLACK);
        g.fillArc( 0 + xOffset, radius / 2 + yOffset, radius, radius, 0, -180 );
        
        g.setColor (Color.BLACK);
        g.fillArc( 0 + xOffset, radius / 2 + yOffset, radius, radius, 0, -180 );
    }
}
