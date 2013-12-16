/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import util.MyTalon;
import util.Config;
import util.MyJoystick;
import edu.wpi.first.wpilibj.DigitalInput;
import util.Output;

/**
 * @author Warren Controls the ejector using limit switches.
 */
public class LimitEjector {

	MyJoystick joy;
	MyTalon ejectorMotor;
	DigitalInput limitSwitchFar;
	DigitalInput limitSwitchClose;
	double speed;

	/**
	 * Constructor takes a joystick while creating the limit switches.
	 *
	 * @param joystick
	 */
	public LimitEjector(MyJoystick joystick) {
		limitSwitchFar = new DigitalInput(Config.chnLsFar);
		limitSwitchClose = new DigitalInput(Config.chnLsClose);
		ejectorMotor = new MyTalon(Config.chnEjector);
		joy = joystick;
	}

	/**
	 * Extends and retracts the ejector when a button is pressed.
	 */
	public void run() {
		if (joy.getButton(Config.btEjector)) //TODO get button
		{
			ejectorMotor.set(speed);
			Output.println(Config.IdEjector, "Tri pressed, speed set");
		}
		if (limitSwitchFar.get()) {
			Output.println(Config.IdEjector, "Retracting...");
			ejectorMotor.set(-speed);
			
		}

		if (!limitSwitchClose.get()) {
			ejectorMotor.set(0);
			Output.println(Config.IdEjector, "Closed. Finished.");
		}
	}
}