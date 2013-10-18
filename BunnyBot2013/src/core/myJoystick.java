/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package core;
import edu.wpi.first.wpilibj.Joystick;

/**
 *
 * @author seraj.bonakdar
 */
public class myJoystick extends Joystick {
    public myJoystick(int portNumber){
        super(portNumber);
        System.out.println("myJoystick created with port:"+ portNumber);
        
    }
    
    public boolean getDebounce(int button){
           boolean lastState = getRawButton(button);
            
           if (lastState === getRawButton)  
                       
        
    }
    
    
    
}
