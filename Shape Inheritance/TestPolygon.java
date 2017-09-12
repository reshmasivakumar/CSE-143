import java.util.*;
import javax.swing.*;
import java.awt.*;
 
/*
 * TestPolygon.java - Simple driver to test Polygon class.
 * 
 * @author Reshma Sivakumar  
 * @version  1.0 11/09/2015
 *
 * Description:   This JFrame subclass contains the methods to test 
 *                 the Polygon shape class.
 *
 *  
 *               
 */

class TestPolygon extends JFrame {
    /**
    * Method :          Constructor
    * Purpose :         Default Constructor that creates a new TestPolygon JFrame class
    *                   and adds an instance of the TestPolygonPanel Panel class.
    * @param            None.
    * @preconditions    None.
    * @postconditions   A new TestPolygon JFrame class
    *                   and adds an instance of the TestPolygonPanel Panel class.
    */     
    public TestPolygon()
    {
        getContentPane().add( new TestPolygonPanel() );
        setSize( 600,600 );
        setVisible( true );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    }
    
    /**
    * Method  :  main driver function
    * Purpose :  Creates an instance for this TestPolygon class.
    */    
    public static void main( String args[] ) 
    {
        TestPolygon myApp = new TestPolygon();
    }
    
    /**
    * Method :          Inner class that is subclass of JPanel
    * Purpose :         Inner class that extends JPanel to instantiate and draw 
    *                   the Polygon Shape and also print its area onto console.
    *  
    */     
    public class TestPolygonPanel extends JPanel 
    {     
        private Polygon poly; 
        
        public TestPolygonPanel() {
            this.poly = new Polygon (50, 100);    
            System.out.println("Area of "+(poly.getClass()).toString().substring(6) 
                                + " " + poly.getArea());     
           
        }
    
        /**
        * Method :      paint
        * Purpose :     Override paint method of JPanel class to draw the Polygon
        *  
        */             
        public void paint( Graphics g )
        {
            super.paint(g);  //don't remove - required for GUI widgets to draw correctly
            poly.draw( g );  
        }
    }   
}










