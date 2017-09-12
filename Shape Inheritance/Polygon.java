
import java.awt.geom.Ellipse2D;
import java.awt.*;
import javax.swing.JPanel;
import java.awt.geom.*;

/**
 * Polygon.java - Class respresenting Polygon object.
 * 
 * 
 * Description: This Polygon class is inherited from Shape superclass.
 *              The getArea() and draw () methods of Shape class are overriden
 *              with functionality specific to Polygon class.
 *        
 * 
 * @author Reshma Sivakumar  
 * @version  1.0 11/9/2015
 *
 *
 */
 
public class Polygon extends Shape
{
    /** Instance variables **/
   
    private int[] pentX; //store the Xcordinates
    private int[] pentY; //store the Ycordinates

	/**
    * Method :          Constructor
    * Purpose :         Constructor for the Polygon class takes 
    *                   x and y coordinates as parameters and
    *                   calls the parent Shape class constructor
    *                   to initialize. 
    * @param            x - int value. 
    * @param            y - int value.
    * @preconditions    none.
    * @postconditions   A new Polygon object is created with the x and
    *                   y coordinates initialized to specified values. 
    */    
   
    public  Polygon( int x, int y )
    {
        super ( x, y );   // call super constructor
        pentX = new int[4];  //pentagon with 4 x points
        pentY = new int[4];  //pentagon with 4 y points
      
        //set the 4 coordinate pairs
        pentX[0] = 100;
        pentY[0] = 100;
      
        pentX[1] = 500;
        pentY[1] = 250;
      
        pentX[2] = 100;
        pentY[2] = 250;
      
        pentX[3] = 500;
        pentY[3] = 100;
    }
   
    /** Overriding methods from parent Shape class **/

    /** 
    * Method :          getArea
    * Purpose :         Overriden Accessor method to return the area 
    *                   of this Polygon object. Area is calculated using
    *                   the formula:
    *                   0.5 * abs ( x0y1 + x1y2 + x2y3 - x1y0 - x2y1 - x3y2 )
    *            
    * @param            None.
    * @preconditions    None.
    * @postconditions   None.
    *
    * @returns          double value representing the area of this
    *                   Polygon object.
    *            
    */
    @Override
    public double getArea ()
    {
       double area = 0.0;
       int length =  pentX.length;
       
       area = Math.abs ( pentX[0] * pentY[1] + pentX[1] * pentY[2] 
	          + pentX[2] * pentY[3] - pentX[1] * pentY[0] - pentX[2]
			  * pentY[1] - pentX[3] * pentY[2]);
			  
       return area / 2.0; 
    }

    /**
    * Method  :         draw
    * Purpose :         Overridden method of Shape superclass which 
    *					calls the Graphics2D class methods to set the
	*					color of the Polygon and draw a Polygon filled 
	*					with that onto the Jpanel which calls it.
    *                       
    * @param            g - Graphics object.
    * @preconditions    None
    * @postconditions   The Polygon shape is rendered to the Graphics context.
    * @throws            RuntimeException if invalid Graphics object passed.
    */   
    @Override
    public void draw ( Graphics g )
    {
        if ( ( g == null) || (!(g instanceof Graphics ) ) )
            throw new RuntimeException ("Invalid Graphics object");
		
        Graphics2D g2D = (Graphics2D) g;
        g2D.setColor( Color.PINK );
 
        int x = super.getX(); 
        int y = super.getY();
     
        // create a geometric  path object to create the straight lines 
        GeneralPath polygon = new GeneralPath(
                 GeneralPath.WIND_EVEN_ODD, pentX.length);
                 
        polygon.moveTo(pentX[0],pentY[0]);
        g2D.setColor( Color.BLUE );
        g2D.setPaint( new GradientPaint( super.getX(), super.getY(), Color.RED, 
					super.getX()+ 5, super.getY()+ 5, Color.BLACK, true) );
        int xOffset = 0;
        int yOffset = 0;
        for ( int i = 1; i < pentX.length; i ++)
        {
            xOffset = (int) (Math.random()*100);
            yOffset = (int) (Math.random()*100);
            // call lineTo on path object to draw the lines of polygon
            polygon.lineTo( pentX[i] + xOffset , pentY[i] + yOffset );
          
        }
        //close the path by drawing line back to moveTo to close the polygon
        polygon.closePath();
        //draw the polyon using Graphics draw method
        g2D.draw(polygon);
    }
}
