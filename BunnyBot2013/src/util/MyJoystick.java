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
public class MyJoystick extends Joystick 
{
    boolean[] buttonState;
    
    /**
     * Calls and creates a new joystick; the constructor
     * @param portNumber 
     */
    public MyJoystick(int portNumber)
    {
        super(portNumber);
        /*
         * Start of code for Debounce; creates the set of all buttons.
         */  
        boolean [] buttonState  = new boolean [Config.buttonsOnJoystick];
        
        for(int i = 0; i < Config.buttonsOnJoystick; i++)
            buttonState[i] = false;
        /*
         * Sets all values for Debounce to false.
         */
        Output.println(Config.joystickId,"Joystick created with port: " + portNumber);
    }

    /**
     * returns the state of a button
     * @param button
     * @return
     */
    public boolean getDebounce(int button)
    {
        if(buttonState[button] == false && buttonState[button] ==! getRawButton(button))
        {               
            Output.println(Config.joystickId,"Button is Pressed! " + true);
            buttonState[button] = getRawButton(button);
            return true; 
        }  
        
        // If the the button was unpressed and now is pressed it is pressed
        else
        {
            buttonState[button] = getRawButton(button);
            return false;
        //If not the button is not pressed    
        }
    }
}