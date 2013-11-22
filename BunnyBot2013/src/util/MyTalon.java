/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;
import edu.wpi.first.wpilibj.Talon;
import util.Output;

/**
 * @aditya.sriram
 * Extends talon with ramp function
 */
public class MyTalon extends Talon  
{
    public MyTalon(int channel)
    {
        super(channel);
    }
}
