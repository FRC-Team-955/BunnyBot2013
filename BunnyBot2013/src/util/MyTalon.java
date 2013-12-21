/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import edu.wpi.first.wpilibj.Talon;

/**
 * @author seraj.bonakdar
 * Extends talon with ramp function
 */
public class MyTalon extends Talon {

    public MyTalon(int channel) {
        super(channel);                  
        }
    
    /**
     * Checks if the talon is attempting to be set to a positive or a negative
     * number the makes sure it within the allowed distance. 
     * @param want the speed that the joystick is trying to set the talon to.
     */
    public void ramp(double want)
    {
        double cur = get(); // cur = current speed
        
        if(Math.abs(want - cur) > Config.rampRate)
            want = cur + (Config.rampRate * (want > cur ? 1: -1));
        
        set(want);
    }
}