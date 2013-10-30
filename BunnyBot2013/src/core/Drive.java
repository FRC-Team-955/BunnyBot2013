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
    MyTalon leftTalonOne = new MyTalon();
    MyTalon leftTalonTwo = new MyTalon();
    MyTalon leftTalonThree = new MyTalon();
    
    MyTalon rightTalonOne = new MyTalon();
    MyTalon rightTalonTwo = new MyTalon();
    MyTalon rightTalonThree = new MyTalon();
     
    public void set(double x, double y) {
        double left = y+x;
        double right = y-x;
        
        setLeft(left);
        setRight(right);
    }
    
    private void setLeft(double left) {
        leftTalonOne.set(left);
        leftTalonTwo.set(left);
        leftTalonThree.set(left);
    }
    
    private void setRight(double right) {
        rightTalonOne.set(right);
        rightTalonTwo.set(right);
        rightTalonThree.set(right);
    }
    
    
    
}
