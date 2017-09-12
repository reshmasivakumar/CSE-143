import java.awt.geom.Ellipse2D;
import java.awt.*;
import javax.swing.JPanel;
import java.awt.geom.*;

/**
 * Triangle.java - Class respresenting Triangle object.
 * 
 * 
 * Description: This Triangle class is inherited from  Shape superclass.
 *              The getArea() and draw () methods of Shape class are overriden
 *              with functionality specific to Triangle class.
 *        
 * 
 * @author Reshma Sivakumar  
 * @version  1.0 11/9/2015
 *
 *
 */
public class Triangle extends Shape
{
    /** Instance Variables of Circle class. **/
   
    private int[] pentX; //store the Xcordinates of the intersection
    private int[] pentY; //store the Ycordinates of the intersection
   
    /**
    * Method :          Constructor
    * Purpose :         Constructor for the Triangle class takes 
    *                   x and y coordinates as parameters and
    *                   calls the parent Shape class constructor
    *                   to initialize. 
    * @param            x - int value. 
    * @param            y - int value.
    * @preconditions    none.
    * @postconditions   A new Triangle object is created with the x and
    *                   y coordinates initialized to specified values. 
    */    

    public Triangle( int x, int y)
    {
        super ( x, y ); //call super constructor
      
        pentX = new int[3];
        pentY = new int[3];
      
        // define values for the 3 intersection points of triangle
        pentX[0] = 250;
        pentY[0] = 100;
      
        pentX[1] = 500;
        pentY[1] = 500;
      
        pentX[2] = 100;
        pentY[2] = 500;
      
    }
   
 
    /** Overriding methods from parent Shape class **/

    /** 
    * Method :          getArea
    * Purpose :         Overriden Accessor method to return the area 
    *                   of this Triangle object. Area is calculated using
    *                   the formula:
    *                    1/2 * abs(x0*y1 + x1*y2 - x1*y0 - x2*y1)
    * @param            None.
    * @preconditions    None.
    * @postconditions   None.
    *
    * @returns          double value representing the area of this
    *                   Triangle object.
    *            
    */
  
    @Override
    public double getArea ()
    {
        double area = 0.0;
        area = Math.abs ( pentX[0]*pentY[1] + pentX[1]*pentY[2]
                            - pentX[1]*pentY[0] - pentX[2]*pentY[1]);
        return area / 2.0; 
    }

    /**
    * Method  :         draw
    * Purpose :         Overridden method of Shape superclass which 
    *                   calls the Graphics2D class methods to set the
    *                   color of the Polygon and draw a Polygon filled 
    *                   with that onto the Jpanel which calls it.
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
        g2D.setColor( Color.BLUE );
 
        int x = super.getX();
        int y = super.getY();
    
        // create a geometric  path object to create the straight lines 
        GeneralPath polygon = new GeneralPath(
                 GeneralPath.WIND_EVEN_ODD, pentX.length);
      
        //Position the first point of the path
        polygon.moveTo(pentX[0],pentY[0]);
        // set color to Blue
        g2D.setColor( Color.BLUE );
        // set the Gradient color of the Triangle to fill
        g2D.setPaint( new GradientPaint( super.getX(), super.getY(),
        Color.BLUE, super.getX()+ 5, super.getY()+ 5, Color.BLACK, true) );
        int xOffset = 0;
        int yOffset = 0;
        // Set the 3 points of the Triangle
        for ( int i = 1; i < pentX.length; i ++)
        {
            xOffset = (int) (Math.random() * 50);
            yOffset = (int) (Math.random() * 50);
            //draw the lines to the points
            polygon.lineTo( pentX[i] + xOffset + 50, pentY[i] + yOffset + 200);
          
        }
        //close the path by drawing line back to moveTo to close the polygon      
        polygon.closePath();
        //draw the polyon using Graphics draw method    
        g2D.fill(polygon);
        // g2D.drawString("Triangle ", x, y);
    } 
}

