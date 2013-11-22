/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import edu.wpi.first.wpilibj.Gyro;

/**
 * @author Pedro Extends gyro with a rounded angle
 */
public class MyGyro extends Gyro {

	/**
	 * Creates a new gyro.
	 *
	 * @param channel
	 */
	public MyGyro(int channel) {
		super(channel);
	}

	/**
	 * Takes the angle and rounds it to x digits. Returns the value.
	 *
	 * @param digits
	 * @return
	 */
	public double getRoundedAngle(int digits) {
		return MyMath.round(this.getAngle(), digits);
	}
}
