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
    
    public MyJoystick(int portOne, int buttonsOnJoy)
    {
        super(portOne);
        amountOfButtons = buttonsOnJoy;
        buttonLast = new boolean[amountOfButtons];
        buttonSwitch = new boolean[amountOfButtons];
        buttonPressed = new boolean[amountOfButtons];
        
        for(int index = 0; index < amountOfButtons; index++)
            buttonLast[index] = buttonSwitch[index] = buttonPressed[index] = false;
    }

    public double getMyX()
    {
        if(isAuto)
            return xPos;
        
        return xPos = getX();
    }
    
    public double getMyY()
    {
        if(isAuto)
            return yPos;
        
        return yPos = getY();
    }
    
    public void setXY(double newX, double newY)
    {
        xPos = newX;
        yPos = newY;
    }
    
    public void setButton(int chan, boolean newVal)
    {
        buttonPressed[chan-1] = newVal;
    }
    
    public boolean getButton(int chan)
    {
        return buttonPressed[chan-1];
    }
    
    public boolean getSwitch(int chan)
    {
        return buttonSwitch[chan-1];
    }
    
    public void flipSwitch(int chan)
    {
        setSwitch(chan, !getSwitch(chan));
    }
    
    public void setSwitch(int chan, boolean newVal)
    {
        buttonSwitch[chan-1] = newVal;
    }
    
    public void setAutoMode(boolean newVal)
    {
        isAuto = newVal;
    }
    
    public boolean getAutoMode()
    {
        return isAuto;
    }
    
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