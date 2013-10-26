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
        System.out.println("Joystick created with port:"+ portNumber);
        //calls constuctor
    }
    
    public boolean getDebounce(int button){
           boolean lastState = getRawButton(button);
            
           if(lastState == false && lastState ==! getRawButton(button)){
               return true;  
           }  
           // If the the button was unpressed and now is pressed it is pressed
           else{
               return false;
               
           }
                       
        
    }
    
    //False,False,False,True,True,True,True,False,False
   
    
}
