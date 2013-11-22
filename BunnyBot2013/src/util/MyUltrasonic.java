/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import edu.wpi.first.wpilibj.AnalogChannel;

/**
 *
 * @author RaiderPC
 */
public class MyUltrasonic extends AnalogChannel
{
	private final double scalar = (1000 / 0.997) / 25.4 / 12; // 0.997 mV/mm
	
	public MyUltrasonic(int channel)
	{
		super(channel);
	}
	
	public double getDistanceFeet()
	{
		return getVoltage() * scalar;
	}
}
