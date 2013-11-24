/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import edu.wpi.first.wpilibj.Joystick;

/**
 *
 * @author seraj.bonakdar Extends the Joystick with a debounce function
 */
public class MyJoystick extends Joystick {

    boolean[] buttonState;

    /**
     * Calls and creates a new joystick; the constructor.
     *
     * @param portNumber
     */
    public MyJoystick(int portNumber) {
        super(portNumber);
        /*
         * Start of code for Debounce; creates the set of all buttons.
         */
        buttonState = new boolean[Config.buttonsOnJoystick];
        
        for (int i = 0; i < Config.buttonsOnJoystick; i++) {
            buttonState[i] = buttonLast[i] = buttonSwitch[i] = buttonPressed[i] = false;
        }
        /*
         * Sets all values for Debounce to false.
         */
        Output.println(Config.joystickId, "Joystick created with port: " + portNumber);
    }

    /**
     * Returns the state of a button
     *
     * @param button
     * @return
     */
    public boolean getDebounce(int button) {
        if (buttonState[button] == false && buttonState[button] == !getRawButton(button)) {
            Output.println(Config.joystickId, "Button is Pressed! " + true);
            buttonState[button] = getRawButton(button);
            return true;
        } // If the the button was unpressed and now is pressed it is pressed
        else {
            buttonState[button] = getRawButton(button);
            return false;
            //If not the button is not pressed    
        }
    }
    /*This is the start of all of the code from fauzi. Go through it please.*/
    private boolean[] buttonLast = new boolean[Config.buttonsOnJoystick];
    private boolean[] buttonSwitch = new boolean[Config.buttonsOnJoystick];
    private boolean[] buttonPressed = new boolean[Config.buttonsOnJoystick];
    
    private boolean isAuto = false;
    private double xPos = 0;
    private double yPos = 0;
    private final double dpadTolerance = 0.2;
    private final int chanVert = 6;
    private final int chanHorz = 5;

    public double getMyX() {
        if (isAuto) {
            return xPos;
        }

        return xPos = getX();
    }

    public double getMyY() {
        if (isAuto) {
            return yPos;
        }

        return yPos = getY();
    }

    public void setXY(double newX, double newY) {
        xPos = newX;
        yPos = newY;
    }

    public void setButton(int chan, boolean newVal) {
        buttonPressed[chan - 1] = newVal;
    }

    public boolean gotPressed(int chan) {
        return buttonPressed[chan - 1];
    }

    public boolean getSwitch(int chan) {
        return buttonSwitch[chan - 1];
    }

    public void flipSwitch(int chan) {
        setSwitch(chan, !getSwitch(chan));
    }

    public void setSwitch(int chan, boolean newVal) {
        buttonSwitch[chan - 1] = newVal;
    }

    public void setAutoMode(boolean newVal) {
        isAuto = newVal;
    }

    public boolean getAutoMode() {
        return isAuto;
    }

    public void updateButtons() {
        if (!isAuto) {
            for (int index = 1; index <= Config.buttonsOnJoystick; index++) {
                if (index != Config.btReplay && index != Config.btRecord) {
                    buttonPressed[index - 1] = (!buttonLast[index - 1] && getRawButton(index));
                    buttonLast[index - 1] = getRawButton(index);
                }
            }
        }

        // We always want to see whether the autonomous buttons have been pressed
        // so that we know when to exit out of it.
        buttonPressed[Config.btReplay - 1] = (!buttonLast[Config.btReplay - 1] && getRawButton(Config.btReplay));
        buttonPressed[Config.btRecord - 1] = (!buttonLast[Config.btRecord - 1] && getRawButton(Config.btRecord));
        buttonLast[Config.btReplay - 1] = getRawButton(Config.btReplay);
        buttonLast[Config.btRecord - 1] = getRawButton(Config.btRecord);
    }

    /**
     * Gets the value of the dPad up
     *
     * @return
     */
    public boolean getDpadUp() {
        return (getRawAxis(chanVert) > dpadTolerance);
    }

    /**
     * Gets the value of the dPad right
     *
     * @return
     */
    public boolean getDpadRight() {
        return (getRawAxis(chanHorz) > dpadTolerance);
    }

    /**
     * Gets the value of the dPad down
     *
     * @return
     */
    public boolean getDpadDown() {
        return (getRawAxis(chanVert) < -dpadTolerance);
    }

    /**
     * Gets the value of the dPad left
     *
     * @return
     */
    public boolean getDpadLeft() {
        return (getRawAxis(chanHorz) < -dpadTolerance);
    }
}
