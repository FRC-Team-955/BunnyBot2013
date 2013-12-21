/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import util.MyTalon;
import util.Config;
import util.MyJoystick;
import util.Output;

/**
 * @author trevor.jones
 * Enables the motors to be controlled by the joystick.
 */
public class Drive {
	
	MyTalon leftTalonOne = new MyTalon(Config.chnDriveLeft1);
	MyTalon leftTalonTwo = new MyTalon(Config.chnDriveLeft2);
	MyTalon leftTalonThree = new MyTalon(Config.chnDriveLeft3);
	MyTalon rightTalonOne = new MyTalon(Config.chnDriveRight1);
	MyTalon rightTalonTwo = new MyTalon(Config.chnDriveRight2);
	MyTalon rightTalonThree = new MyTalon(Config.chnDriveRight3);
    MyJoystick joy;
                
        public Drive(MyJoystick stick)
        {
            joy = stick;
        }
        
	/** 
         * This function runs the drive base based on the joysticks x and y
         */
	public void run() {
		double y = joy.getMyY();
		double x = joy.getMyX();
        y *= Math.abs(y);
        x *= Math.abs(x);
		double left = y + x;
		double right = (y - x);
		
		left = -left;	// Have to flip the left side so both sides go forward
		left *= Config.speedConst;
		right *= Config.speedConst;
		set(left, right);
                
		Output.println(Config.IdDrive, "Left 1: " + leftTalonOne.get() + " Right 1: " + rightTalonOne.get());
        Output.println(Config.IdDrive, "Left 2: " + leftTalonTwo.get() + " Right 2: " + rightTalonTwo.get());
        Output.println(Config.IdDrive, "Left 3: " + leftTalonThree.get() + " Right 3: " + rightTalonThree.get());
	}
        
        /**
         * Sets the talons of the drive base to left and right
         * @param left
         * @param right 
         */
        private void set(double left, double right)
        {
            leftTalonOne.ramp(left);
            leftTalonTwo.ramp(left);
            leftTalonThree.ramp(left);
            
            rightTalonOne.ramp(right);
            rightTalonTwo.ramp(right);
            rightTalonThree.ramp(right);
        }
}
