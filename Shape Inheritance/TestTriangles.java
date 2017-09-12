import java.util.*;
import javax.swing.*;
import java.awt.*;
 
  
/*
 * TestTriangles.java - Simple driver to test Triangle class.
 * 
 * @author Reshma Sivakumar  
 * @version  1.0 11/09/2015
 *
 * Description:   This JFrame subclass contains the methods to test 
 *                 the Triangle shape class.      
 */

class TestTriangles extends JFrame {
    /**
    * Method :          Constructor
    * Purpose :         Default Constructor that creates a new TestTriangles JFrame class
    *                   and adds an instance of the TestTrianglesPanel Panel class.
    * @param            None.
    * @preconditions    None.
    * @postconditions   A new TestTriangles JFrame class
    *                   and adds an instance of the TestTrianglesPanel Panel class.
    */           
    public TestTriangles() 
    {
        getContentPane().add( new TestTrianglesPanel() );
        setSize( 600,600 );
        setVisible( true );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    }
    
    /**
    * Method  :  main driver function
    * Purpose :  Creates an instance for this TestShadedCircles class.
    */       
    public static void main( String args[] )
    {
        TestTriangles myApp = new TestTriangles();
    }
    
    /**
    * Method :          Inner class that is subclass of JPanel
    * Purpose :         Inner class that extends JPanel to instantiate and draw 
    *                   the Triangle Shape and also print its area onto console.
    *  
    */      
    public class TestTrianglesPanel extends JPanel 
    {     
        private Triangle triangle; 
        
        public TestTrianglesPanel()
        {
            this.triangle = new Triangle (50, 100);    
            System.out.println("Area of "+(triangle.getClass()).toString().substring(6) 
                                + " " + triangle.getArea());     
        }

        /**
        * Method :          paint
        * Purpose :         Override paint method of JPanel class to draw the Triangle
        *  
        */              
        public void paint( Graphics g )
        {
            super.paint(g);  //don't remove - required for GUI widgets to draw correctly
            triangle.draw( g );  
        }
    }   
}










