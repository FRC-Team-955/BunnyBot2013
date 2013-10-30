/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import util.Piston;
import util.MyJoystick;
import edu.wpi.first.wpilibj.Solenoid;

/**
 *
 * @author warren.elwood
 */
public class Ejector 
{
    private Piston sol;
    public Ejector(MyJoystick joy, int port1, int port2, int port3)// Joy will come later
    {
         sol = new Piston( port1,port2, port3);  
    }
    
    public void run() 
    {
        //if (/*TODO*/)// replace with code that gets the joystick button state
        {
            sol.solenoidSwitch();
        }
    }
}

