/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package core;
import util.MyJoystick ;
import util.Output;
/**
 * 
 *
 * @author seraj.bonakdar & troy.jameson
 * 
 * 
 */
public class Bot 
{
    /**
     * 
     */
    MyJoystick joy;
    TimerEjector eject;
    Drive drive;
    
    public Bot(MyJoystick joystick)
    {
        joy = joystick;   
        eject = new TimerEjector(joy);
        drive = new Drive();
    }
    
    public void botRun()
    {
        eject.run();
        drive.set(joy.getX(), joy.getY());
    }
}