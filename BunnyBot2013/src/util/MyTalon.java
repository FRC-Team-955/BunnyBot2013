/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import edu.wpi.first.wpilibj.Talon;
import util.Output;
import core.Drive;

/**
 * @author seraj.bonakdar
 Extends talon with ramp function
 */
public class MyTalon extends Talon {

    public MyTalon(int channel) {
        super(channel);                  
        }
    
    /**
     * Checks if the talon is attempting to be set to a positive or a negative
     * number the makes sure it within the allowed distance. 
     * @param speedWanted the speed that the joystick is trying to set the talon to.
     */
    public void Ramp(double speedWanted){         
        if(speedWanted - get() > 0 && speedWanted - get() > Config.rampScale){
            set(get()-Config.rampScale);
        }
        else if(speedWanted - get() < -Config.rampScale){
            set(get()+ Config.rampScale);
        }
        else{
            set(speedWanted);
        }    
    }
}



