import java.util.*;
import javax.swing.*;
import java.awt.*;

/*
 * PolyDemo.java - Simple driver to test  Polymorphic behavior of the Shape
 *                 Sub classes - Circle, Triangle, Rectangle, ShadedCircles
 *                 and Polygon shapes.
 * 
 * @author Reshma Sivakumar  
 * @version  1.0 11/09/2015
 *
 * Description:   This JFrame class contains a Jpanel class to test the 
 *                 Polymorphic behavior of the Shape
 *                 Sub classes - Circle, Triangle, Rectangle, ShadedCircles
 *                  Polygon shapes.
 *
 *  
 *               
 */

class PolyDemo extends JFrame {
    
    /**
    * Method :          Constructor
    * Purpose :         Default Constructor that creates a new PolyDemo JFrame class
    *                   and adds an instance of the PolyDemoPanel Panel class.
    * @param            None.
    * @preconditions    None.
    * @postconditions   A new PolyDemo JFrame class
    *                   and adds an instance of the PolyDemoPanel Panel class.
    */        
    public PolyDemo()
    {
        getContentPane().add( new PolyDemoPanel() );
        //just some windowing stuff that must happen for all Frames
        setSize( 1000,1800 );
        setVisible( true );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    }
    
    /**
    * Method  :  main driver function
    * Purpose :  Creates an instance for this PolyDemo class.
    */    
    public static void main( String args[] ) 
    {
        PolyDemo myApp = new PolyDemo();
    }
    
    /**
    * Description :     Inner class that is subclass of JPanel
    * Purpose :         Inner class that extends JPanel to instantiate and draw 
    *                   the Shape subclasses and also print its area onto 
    *                   console.
    *  
    */     
    //this is our first "inner" or internal class 
    //the purpose of this class is solely to support the JFrame class above,
    //  and I don't want it
    //  reused in arbitrary contexts, so by nesting this class here
    //I can indicate the intent a bit more clearly that this class "goes with"
    //  the class above it
    //In general, each class is a separate entity that should be contained in 
    // a separate file
    public class PolyDemoPanel extends JPanel
    {     
        Shape[] myShapes= new Shape[20]; //create array of Shape class

        /**
        * Method :          Constructor
        * Purpose :         Default Constructor that  calls the getRandShape
        *                   method to get random instances of the different 
        *                   subclasses of Shapes class and adds it to the 
        *                   Shape superclass array.
        * @param            None.
        * @preconditions    None.
        * @postconditions   Shape class array populated with random instances
        *                   of its subclasses.
        *                   
        */              
        public PolyDemoPanel()
        {
            //Shape a = new Shape( getRandInt(), getRandInt());
            //Shape b = new Circle( getRandInt(), getRandInt(), getRandInt() );
        
            //a = new Square(getRandInt(), getRandInt(),
            //          getRandInt(), getRandInt());
        
            //a = getRandShape();

            //( (Circle) b ).getRadius();
            
     
            /**************************************************************** 
            * when new classes are introduced (only in getRandShape())
            *****************************************************************/
            for( int i = 0; i < 20; i++ ) {
                
                myShapes[i] =  getRandShape();
                System.out.println("Area of " + 
                (myShapes[i].getClass()).toString().substring(6) 
                + " " + myShapes[i].getArea());
            }
        }
        
        /**
        * Method :          paint
        * Purpose :         Code for drawing our shapes doesn't change at all!
        *                   Since we intended to take advantage of polymorphism
        *                   we coded this "in general". 
        *                   with respect to the superclass, and not specific to
        *                   any subclass. 
        * @param            g - Graphics object.
        *  
        */  
        public void paint( Graphics g ) {
            super.paint(g);  //don't remove - required for GUI widgets to draw
                             //correctly
            /************************
             * Late Binding Demo
             ************************/
             //Loop through the Shapes array and call the draw method. Java uses
             //RTTI to determine which subclass draw method needs to be called.
            for( int i = 0; i < myShapes.length; i++ ){
                //which draw method is invoked here? There are many forms of the 
                //method(polymorphic), so which is chosen?
                //Java has RTTI about every object, and uses this info choose 
                //the correct method to invoke!
                myShapes[i].draw( g );  
            }   
        }
            
        /**
        * Method :          getRandInt
        * Purpose :         Returns random integer. 
        * @param            None.
        * @returns :        random integer value.
        *  
        */          
        public int getRandInt() {
            return ( (int) ( Math.random() * 200 ) );   
        }

        /**
        * Method :          getRandShape
        * Purpose :         To randomly instantiate the subclasses of
        *                   the Shape superclass. The Shape subclass 
        *                   chosen randomly will be stored in the Shapes
        *                   array and draw method will be called on the 
        *                   passed subclass object dynamically.     
        * @param            None.
        * @returns :        random Shape subclass object.
        *  
        */          
        public Shape getRandShape() {
            Shape retVal = null;
            final int x = getRandInt();
            final int y = getRandInt();

            /********************************
             * Polymorphic extensibility demo
             *
             *******************************/
            switch( ( int )(Math.random() * 5) ) {
                case 0:     Circle circle = new Circle ( x, y );
                            circle.setRadius(200);
                            retVal = circle;
                            break;
                case 1:     retVal = new Rectangle( x +  1, y + 2, 100+getRandInt(),
                            100+getRandInt());
                            break;
                case 2:     retVal = new Polygon( x,y );
                            break;
                case 3:    retVal = new Triangle( x,y );
                            break;   
                            
                case 4:    retVal = new ShadedCircles( x,y, 100 );
                            break;               
            }
        
            return retVal;
        }
    }      
}










