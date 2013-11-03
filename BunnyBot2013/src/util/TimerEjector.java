/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import core.MyTalon;
import edu.wpi.first.wpilibj.Timer;
import util.MyJoystick;
/**
 *
 * @author trevor.jones
 */
public class TimerEjector {
    MyJoystick joy;
    int time = Vars.EJECTOR_TIME;// in milliseconds
    double speed = Vars.EJECTOR_SPEED;
    MyTalon ejectorTalon = new MyTalon(Vars.EJECTOR_CHANNEL);
    Timer timer = new Timer();

    public TimerEjector(MyJoystick joy1){   
        joy = joy1;
    }
   
            
    public void run() {
        if(joy.getDebounce(Vars.EJECTOR_BUTTON)) {       //PUT THE RIGHT BUTTON HERE
            timer.start();
            ejectorTalon.set(speed);
            if(timer.get() < time){
                ejectorTalon.set(speed);
            }
            else if(timer.get() >= time && timer.get() < time * 2) {
                ejectorTalon.set(-speed);
            }
        }
    }
}
