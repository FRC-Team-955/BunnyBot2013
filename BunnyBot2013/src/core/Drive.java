/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package core;
import util.Config;
/**
 *
 * @author trevor.jones
 */
public class Drive {
    MyTalon leftTalonOne = new MyTalon(Config.CHAN_DRIVE_LEFT1);
    //MyTalon leftTalonTwo = new MyTalon();
    //MyTalon leftTalonThree = new MyTalon();
    
    MyTalon rightTalonOne = new MyTalon(Config.CHAN_DRIVE_RIGHT1);
    //MyTalon rightTalonTwo = new MyTalon();
    //MyTalon rightTalonThree = new MyTalon();
     
    public void set(double x, double y) {
        System.out.println("Drive Got to #1");
        double left = y+x;
        double right = y-x;
        
        setLeft(left);
        setRight(right);
        System.out.println("Drive Got to #2");
    }
    
    private void setLeft(double left) {
        System.out.println("Drive Got to #3");
        leftTalonOne.set(left);
        System.out.println("Drive Got to #4");
        //leftTalonTwo.set(left);
        //leftTalonThree.set(left);
    }
    
    private void setRight(double right) {
        System.out.println("Drive Got to #5");
        rightTalonOne.set(right);
        System.out.println("Drive Got to #6");
        //rightTalonTwo.set(right);
        //rightTalonThree.set(right);
    }
    
    
    
}
