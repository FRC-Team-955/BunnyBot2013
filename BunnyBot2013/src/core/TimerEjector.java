/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import edu.wpi.first.wpilibj.DigitalInput;
import util.MyTalon;
import edu.wpi.first.wpilibj.Timer;
import util.Config;
import util.MyJoystick;
import util.Output;
import util.Station;

/**
 * @author Trevor Controls the ejector with a timer
 */
public class TimerEjector {

	protected MyJoystick joy;
	protected MyTalon ejectorTalon = new MyTalon(Config.chnEjector);
	protected DigitalInput limitSwitchClose;
	protected Timer timer = new Timer();
	protected boolean isRetracting;
	protected boolean isRetracted = true;
	protected boolean isExtending;

	public TimerEjector(MyJoystick joy1) {
		joy = joy1;
		limitSwitchClose = new DigitalInput(Config.chnLsClose);
	}

	/**
	 * Starts the ejector and the timer. It has 3 states, isRetracted,
	 * isExtending, and isRetracting
	 */
//	public void run() {
//		//Managing state transitions between 3 states. The three states are Retracted, Extending, and Retracting
//		//If the ejector isRetracted and the button is pushed start it and se isExtending
//		
//		Config.ejectorForwardTime = Station.getAnalogIn(1);
//		Config.ejectorSpeedForward = Station.getAnalogIn(2);
//		Config.ejectorSpeedBack = Station.getAnalogIn(3);
//		Config.ejectorBackTime = Station.getAnalogIn(4);
//		
//		if (isRetracted && joy.getButton(Config.btEjector)) {
//			timer.start();
//			ejectorTalon.set(Config.ejectorSpeedForward);
//			isRetracting = false;
//			isRetracted = false;
//			isExtending = true;
//
//			Output.println(Config.IdEjector, "Ejector Active!" + true);
//		} //If the ejector goes for the set amount of time, have it go back and set isRetracting true
//		else if (isExtending && timer.get() >= Config.ejectorForwardTime) {
//				ejectorTalon.set(-Config.ejectorSpeedBack);
//				isRetracting = true;
//				isRetracted = false;
//				isExtending = false;
//				timer.reset();
//				Output.println(Config.IdEjector, "Ejector Retracting!");
//		} //if the ejector isRetracting, and it has retracted for the set amount of time, then stop the ejector,
//		//reset the timer, and set isRetracted.
//		else if (isRetracting) {
//			if (!limitSwitchClose.get() || timer.get() >= Config.ejectorBackTime) {
//				ejectorTalon.set(0);
//				timer.stop();
//				timer.reset();
//				isRetracted = true;
//				isRetracting = false;
//				isExtending = false;
//				Output.println(Config.IdEjector, "Ejector Retracted!");
//			}
//		} 
////		else {
////			ejectorTalon.set(0);
////			timer.stop();
////			timer.reset();
////			isRetracted = true;
////			isRetracting = false;
////			isExtending = false;
////			Output.println(Config.IdEjector, "Invalid state in TimerEjector");
////		}
//	}
	
	public void reset()
	{
			timer.stop();
			timer.reset();
			isRetracted = true;
			isRetracting = false;
			isExtending = false;
	}
}
