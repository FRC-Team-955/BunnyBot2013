/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

/**
 *
 * @author trevor.jones
 */
public class Drive {
    myTalon leftTalonOne = new myTalon();
    myTalon leftTalonTwo = new myTalon();
    myTalon leftTalonThree = new myTalon();
    
    myTalon rightTalonOne = new myTalon();
    myTalon rightTalonTwo = new myTalon();
    myTalon rightTalonThree = new myTalon();
     
    public static void set(double x, double y) {
        double left = y+x;
        double right = y-x;
        
        setLeft(left);
        setRight(right);
    }
    
    private static void setLeft(double left) {
        leftTalonOne.set(left);
        leftTalonTwo.set(left);
        leftTalonThree.set(left);
    }
    
    private static void setRight(double right) {
        rightTalonOne.set(right);
        rightTalonTwo.set(right);
        rightTalonThree.set(right);
    }
    
    
    
}
