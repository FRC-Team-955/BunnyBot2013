package util;
import edu.wpi.first.wpilibj.Joystick;

/**
 *
 * @author Merfoo
 */
public class MyJoystick extends Joystick
{
    private boolean[] buttonLast = null;
    private boolean[] buttonSwitch = null;
    private boolean[] buttonPressed = null;
    private boolean isAuto = false;
    private double xPos = 0;
    private double yPos = 0;
    private final double dpadTolerance = 0.2;
    private final int chanVert = 6;
    private final int chanHorz = 5;
    private final int amountOfButtons;
    boolean [] buttonState;
    
    public MyJoystick(int portOne, int buttonsOnJoy)
    {
        super(portOne);
        amountOfButtons = buttonsOnJoy;
        buttonLast = new boolean[amountOfButtons];
        buttonSwitch = new boolean[amountOfButtons];
        buttonPressed = new boolean[amountOfButtons];
        
        for(int index = 0; index < amountOfButtons; index++)
            buttonLast[index] = buttonSwitch[index] = buttonPressed[index] = false;
         buttonState = new boolean[Config.buttonsOnJoystick];
        
        for (int i = 0; i < Config.buttonsOnJoystick; i++) {
            buttonState[i] = buttonLast[i] = buttonSwitch[i] = buttonPressed[i] = false;
        }
    }
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
    /** 
     * Gets the value of X
     * 
     * @return 
     */
    public double getMyX()
    {
        if(isAuto)
            return xPos;
        
        return xPos = getX();
    }
    
    /** 
     * Gets the value of Y
     * 
     * @return 
     */
    public double getMyY()
    {
        if(isAuto)
            return yPos;
        
        return yPos = getY();
    }
    
    /**
     * Sets X and Y
     * @param newX
     * @param newY 
     */
    public void setXY(double newX, double newY)
    {
        xPos = newX;
        yPos = newY;
    }
    
    /**
     * Sets the button
     * @param chan
     * @param newVal 
     */
    public void setButton(int chan, boolean newVal)
    {
        buttonPressed[chan-1] = newVal;
    }
    
    /**
     * Gets the pushed button
     * @param chan
     * @return 
     */
    public boolean getButton(int chan)
    {
        return buttonPressed[chan-1];
    }
    
    /**
     * Sets the switch
     * @param chan
     * @return 
     */
    public boolean getSwitch(int chan)
    {
        return buttonSwitch[chan-1];
    }
    
    /**
     * Flips the switch
     * @param chan 
     */
    public void flipSwitch(int chan)
    {
        setSwitch(chan, !getSwitch(chan));
    }
    
    /**
     * Sets the switch
     * @param chan
     * @param newVal 
     */
    public void setSwitch(int chan, boolean newVal)
    {
        buttonSwitch[chan-1] = newVal;
    }
    
    /**
     * Sets auto
     * @param newVal 
     */
    public void setAutoMode(boolean newVal)
    {
        isAuto = newVal;
    }
    
    /**
     * Checks if auto is active
     * @return 
     */
    public boolean getAutoMode()
    {
        return isAuto;
    }
    
    /**
     * Updates the buttons
     */
    public void updateButtons()
    {
        if(!isAuto)
        {
            for(int index = 1; index <= amountOfButtons; index++)
            {
                if(index != Config.btReplay && index != Config.btRecord)
                {
                    buttonPressed[index-1] = (!buttonLast[index-1] && getRawButton(index));
                    buttonLast[index-1] = getRawButton(index);
                }
            }
        }
        
        // We always want to see whether the autonomous buttons have been pressed
        // so that we know when to exit out of it.
        buttonPressed[Config.btReplay-1] = (!buttonLast[Config.btReplay-1] && getRawButton(Config.btReplay));
        buttonPressed[Config.btRecord-1] = (!buttonLast[Config.btRecord-1] && getRawButton(Config.btRecord));
        buttonLast[Config.btReplay-1] = getRawButton(Config.btReplay);
        buttonLast[Config.btRecord-1] = getRawButton(Config.btRecord);
    }
    
    /**
     * Gets the value of the dPad up
     * @return 
     */
    public boolean getDpadUp()
    {
        return (getRawAxis(chanVert) > dpadTolerance);
    }
     
    /**
     * Gets the value of the dPad right
     * @return 
     */
    public boolean getDpadRight()
    {
        return (getRawAxis(chanHorz) > dpadTolerance);
    }
    
    /**
     * Gets the value of the dPad down
     * @return 
     */
    public boolean getDpadDown()
    {
        return (getRawAxis(chanVert) < -dpadTolerance);
    }
        
    /**
     * Gets the value of the dPad left
     * @return 
     */
    public boolean getDpadLeft()
    {
        return (getRawAxis(chanHorz) < -dpadTolerance);
    }
}