/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import util.MyTalon;
import edu.wpi.first.wpilibj.Timer;
import util.Config;
import util.MyJoystick;
import util.MyJoystick;
import util.Output;
/**
 *
 * @author trevor.jones
 */
public class TimerEjector {
    protected MyJoystick joy;
    protected int time = Config.EJECTOR_TIME;// in milliseconds
    protected double speed = Config.EJECTOR_SPEED;
    protected MyTalon ejectorTalon = new MyTalon(Config.EJECTOR_CHANNEL);
    protected Timer timer = new Timer();
	protected boolean isRetracting;
	protected boolean isRetracted = true;
	protected boolean isExtending;

    public TimerEjector(MyJoystick joy1){   
        joy = joy1;
    }
   
            
    public void run() {	
		//Managing state transitions between 3 states. The three states are Retracted, Extending, and Retracting
		if(isRetracted) {
			//if(joy.getDebounce(Config.EJECTOR_BUTTON) ) {       //PUT THE RIGHT BUTTON HERE
				timer.start();
				ejectorTalon.set(speed);  
				Output.println(8,"Ejector Active!", true);
				isRetracting = false;
				isRetracted = false;
				isExtending = true;
			//}
		}
		else if(isExtending) {
			if(timer.get() >= time) {
				ejectorTalon.set(-speed);
				Output.println(8,"Ejector Retracting!", true);
				isRetracting = true;
				isRetracted = false;
				isExtending = false;
			}
		}
		else if(isRetracting) {
			if (timer.get() >= time * 2) {
				Output.println(8,"Ejector Retracted!", true);
				ejectorTalon.set(0);
				timer.stop();
				timer.reset();
				isRetracted = true;
				isRetracting = false;
				isExtending = false;
			}
		}
		else {
			ejectorTalon.set(0);
			timer.stop();
			timer.reset();
			isRetracted = true;
			isRetracting = false;
			isExtending = false;
			Output.println(8,"Invalid state in TimerEjector",true);
		}
    }
}
