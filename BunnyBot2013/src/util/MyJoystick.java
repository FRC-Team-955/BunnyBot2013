/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import edu.wpi.first.wpilibj.Joystick;

/**
 *
 * @author seraj.bonakdar
 */
public class MyJoystick extends Joystick {

    boolean[] buttonState;
    public MyJoystick(int portNumber) {
        super(portNumber);
        Output.println(7, "Joystick created with port:", portNumber);
        boolean[] buttonState = new boolean[Config.BUTTON_ARRAY];
        for (int i = 0; i < Config.BUTTON_ARRAY; i++) {
            buttonState[i] = false;
        }
    }
    //calls constructor
    public boolean getDebounce(int button) {
        if (buttonState[button] == false && buttonState[button] == !getRawButton(button)) {
            Output.println(7, "Button is Pressed!", true);
            buttonState[button] = getRawButton(button);
            return true;
        }
        // If the the button was unpressed and now is pressed it is pressed
        else {
            buttonState[button] = getRawButton(button);
            return false;
            //If not the button is not pressed    
        }

    }

}
 //omfg war-war no understand gg.
