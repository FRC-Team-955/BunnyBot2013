/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import util.MyTalon;
import util.Config;
import util.Output;

/**
 * @author trevor.jones
 *
 */
/**
 *
 * Enables the motors to be controlled by the joystick.
 */
public class Drive {
	
	MyTalon leftTalonOne = new MyTalon(Config.chnDriveLeft1);
	MyTalon leftTalonTwo = new MyTalon(Config.chnDriveLeft2);
	MyTalon leftTalonThree = new MyTalon(Config.chnDriveLeft3);
        
	MyTalon rightTalonOne = new MyTalon(Config.chnDriveRight1);
	MyTalon rightTalonTwo = new MyTalon(Config.chnDriveRight2);
	MyTalon rightTalonThree = new MyTalon(Config.chnDriveRight3);

	/**
	 * The function makes two speeds for the motors and calls setLeft and
	 * setRight
	 *
	 * @param x The place on the x axis of the joystick the stick is on.
	 * @param y The place on the y axis of the joystick the stick is on.
	 */
	public void set(double x, double y) {
		double left = y + x;
		double right = (y - x);

		setLeft(left);
		setRight(right);
		
		 Output.println(Config.IdDrive, "Left: " + leftTalonOne.get() + " Right: " + rightTalonOne.get() + "Left2: " + leftTalonTwo.get() + " Right2: " + rightTalonTwo.get());
		 /*
		 double goFaster = 0.50;
		 setLeft(goFaster);
		 setRight(-goFaster);
		 * 
		 * This code exists for testing of talon and Talon sr speeds, especially at low values.
		 * 
		 */

	}

	/**
	 * This function sets double left (the left motor speed) to the left talons.
	 *
	 * @param left The set speed for the left motor.
	 */
	private void setLeft(double left) {
		leftTalonOne.set(left);
		leftTalonTwo.set(left);
		leftTalonThree.set(left);
	}

	/**
	 * This function sets double right (the right motor speed) to the right
	 * talons.
	 *
	 * @param right The set speed for the right motor.
	 */
	private void setRight(double right) {
		rightTalonOne.set(right);
		rightTalonTwo.set(right);
		rightTalonThree.set(right);
	}
}
