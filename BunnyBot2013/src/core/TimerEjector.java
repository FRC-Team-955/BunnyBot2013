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
public class TimerEjector 
{
    protected MyJoystick joy;
    protected int time = Config.ejectorTime;// in milliseconds
    protected double speed = Config.ejectorSpeed;
    protected MyTalon ejectorTalon = new MyTalon(Config.chnEjector);
    protected Timer timer = new Timer();
    protected boolean isRetracting;
    protected boolean isRetracted = true;
    protected boolean isExtending;

    public TimerEjector(MyJoystick joy1)
    {   
        joy = joy1;
    }
   
            
    public void run() 
    {	
        //Managing state transitions between 3 states. The three states are Retracted, Extending, and Retracting
        if(isRetracted && joy.getDebounce(Config.btEjector)) 
        {
            timer.start();
            ejectorTalon.set(speed);  
            isRetracting = false;
            isRetracted = false;
            isExtending = true;
            
            Output.println(Config.ejectorId,"Ejector Active!" + true);
        }
        
        else if(isExtending)
        {
            if(timer.get() >= time) 
            {
                ejectorTalon.set(-speed);
                isRetracting = true;
                isRetracted = false;
                isExtending = false;
                Output.println(Config.ejectorId, "Ejector Retracting!");
            }
        }
        
        else if(isRetracting) 
        {
            if (timer.get() >= time * 2) 
            {
                ejectorTalon.set(0);
                timer.stop();
                timer.reset();
                isRetracted = true;
                isRetracting = false;
                isExtending = false;
                Output.println(Config.ejectorId, "Ejector Retracted!");
            }
        }
        
        else 
        {
            ejectorTalon.set(0);
            timer.stop();
            timer.reset();
            isRetracted = true;
            isRetracting = false;
            isExtending = false;
            Output.println(Config.ejectorId, "Invalid state in TimerEjector");
        }
    }
}
