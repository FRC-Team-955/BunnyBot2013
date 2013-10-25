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
    public MyJoystick(int portNumber){
        super(portNumber);
        System.out.println("myJoystick created with port:"+ portNumber);
        
    }
    
    public boolean getDebounce(int button){
           boolean lastState = getRawButton(button);
            
           if (lastState == false && lastState == !getRawButton(button)){
               return true;  
           }  
           else{
               return false;
               
           }
                       
        
    }
    
    
    
}
