/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import util.MyTalon;
import util.Config;
import util.MyJoystick;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Timer;
import util.Output;
import util.Station;

/**
 * @author Warren Controls the ejector using limit switches.
 */
public class LimitEjector {

	private MyJoystick joy;
	private MyTalon ejectorMotor;
	private DigitalInput limitSwitchFar;
	private DigitalInput limitSwitchClose;
	private boolean isExtending = false;
	private boolean isRetracting = false;
	private String statusPrefix = "Ejec: ";
	private String status = "Retracted";
	private Timer timer;

	/**
	 * Constructor takes a joystick while creating the limit switches.
	 *
	 * @param joystick
	 */
	public LimitEjector(MyJoystick joystick) {
		limitSwitchFar = new DigitalInput(Config.chnLsFar);
		limitSwitchClose = new DigitalInput(Config.chnLsClose);
		ejectorMotor = new MyTalon(Config.chnEjector);
                timer = new Timer();
		joy = joystick;
	}

	/**
	 * Extends and retracts the ejector when a button is pressed.
	 */
	public void run() {
		
		Config.ejectorSpeedForward = Station.getAnalogIn(1);
		Config.ejectorSpeedBack = Station.getAnalogIn(2);
                Config.ejectorTimeBack = Station.getAnalogIn(3);
		
		if (joy.getButton(Config.btEjector))
		{
			ejectorMotor.set(Config.ejectorSpeedForward);
			isExtending = true;
			isRetracting = false;
			status = "Extending";
		}
		
		if (limitSwitchFar.get() && isExtending) 
		{
			ejectorMotor.set(-Config.ejectorSpeedBack);
                        timer.reset();
                        timer.start();
			isExtending = false;
			isRetracting = true;
			status = "Retracting";
		}

		if (!limitSwitchClose.get() && isRetracting || timer.get() >= Config.ejectorTimeBack) 
		{
			ejectorMotor.set(0);
                        timer.stop();
                        timer.reset();
			isExtending = false;
			isRetracting = false;
			status = "Retracted";
		}
                
		Output.println(Config.IdEjector, "Close: " + limitSwitchClose.get() + ", Far: " + limitSwitchFar.get() + "Ejec Speed: " + ejectorMotor.getDescription());
		Station.print(Config.stLineEjector, statusPrefix + status);
	}
}