import java.util.*;
import javax.swing.*;
import java.awt.*;
 
/*
 * TestShadedCircles.java - Simple driver to test ShadedCircles class.
 * 
 * @author Reshma Sivakumar  
 * @version  1.0 11/09/2015
 *
 * Description:   This JFrame subclass contains the methods to test 
 *                 the ShadedCircles shape class.
 *
 *  
 *               
 */
 
class TestShadedCircles extends JFrame {
    /**
    * Method :          Constructor
    * Purpose :         Default Constructor that creates a new TestShadedCircles JFrame class
    *                   and adds an instance of the TestShadedCirclesPanel Panel class.
    * @param            None.
    * @preconditions    None.
    * @postconditions   A new TestShadedCircles JFrame class
    *                   and adds an instance of the TestShadedCirclesPanel Panel class.
    */      
    public TestShadedCircles() {
        getContentPane().add( new TestShadedCirclesPanel() );
        setSize( 600,600 );
        setVisible( true );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    }
    
    /**
    * Method  :  main driver function
    * Purpose :  Creates an instance for this TestShadedCircles class.
    */      
    public static void main( String args[] ) {
        TestShadedCircles   myApp = new TestShadedCircles();
    }
    
    /**
    * Method :          Inner class that is subclass of JPanel
    * Purpose :         Inner class that extends JPanel to instantiate and draw 
    *                   the ShadedCircles Shape and also print its area onto console.
    *  
    */     
    public class TestShadedCirclesPanel extends JPanel {     
        private ShadedCircles circles; 
        
        public TestShadedCirclesPanel() 
        {
            this.circles = new ShadedCircles (50, 100, 100);    
            System.out.println("Area of "+(circles.getClass()).toString().substring(6) 
                                + " " + circles.getArea());     
        }
        
        /**
        * Method :          paint
        * Purpose :         Override paint method of JPanel class to draw the ShadedCircle
        *  
        */             
        public void paint( Graphics g )
        {
            super.paint(g); 
            circles.draw( g );         
        }
   }   
}










