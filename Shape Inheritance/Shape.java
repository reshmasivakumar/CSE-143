import java.awt.*;
/**
 * Shape.java - Class respresenting the Super class in the Shape Heirarchy.
 * 
 * @author Reshma Sivakumar
 * @version 1 11/09/2015
 * 
 * Description: This class is inherited from it's parent class Shape.
 *              The getArea () and draw () methods of Shape class are
 *              abstract and will be overriden by subclass with functionality
 *              specific to subclass.
 *              
 */
 
//the superclass in our inheritance hierarchy
//all "common" features, functions and data should go here
//for example, all shapes in Java2D have a x,y that declares their position
//and many of the shapes exposed have a width and a height (but not all, so we
// didn't put width and height here)
//note that this class is mostly empty, as there is no algorithm generic enough
// to guess an arbitrary shape's area(future subclasses must override getArea()
// to provide something reasonable)
//also, the draw method is empty too, as we don't know what shape to draw here! 
//(again, our subclasses will need to replace this method with one that 
// actually draws things)

class Shape extends Object {
	
	/** super class instance variables **/
	private int x = 0;
	private int y = 0;
	
	/**
    * Method :          Constructor
    * Purpose :         Constructor for the Shape class and sets the x and 
	*					y coordinates to the specified values.
    *                   to initialize.
    * @param            a - int value representing x. 
    * @param            b - int value representing y.
    * @preconditions    None.
    * @postconditions   None. 
    */  	
	public Shape( int a, int b ) {
		x=a;
		y=b;
	}

	/**
    * Method :          getArea
    * Purpose :         Abstract method for returning the area of the shape.
    * @param            None.
    * @returns          -1.
    * @preconditions    None.
    * @postconditions   None. 
    */  		
	public double getArea(){ return -1; }

	/**
    * Method :          draw
    * Purpose :         Abstract method for rendering the shape to Graphics context
    * @param            g- Graphics object.
    * @returns          None.
    * @preconditions    None.
    * @postconditions   None. 
    */	
	public void draw( Graphics g ){}
	
	/**
    * Method :          getX
    * Purpose :         Accesor method for to return x value of this object
    * @param            None.
    * @returns          int value representing x.
    * @preconditions    None.
    * @postconditions   None. 
    */		
	public int getX() { return x; }
	
	/**
    * Method :          getY
    * Purpose :         Accesor method for to return y value of this object
    * @param            None.
    * @returns          int value representing x.
    * @preconditions    None.
    * @postconditions   None. 
    */		
	public int getY() { return y; }
}