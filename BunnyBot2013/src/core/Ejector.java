/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import util.MyJoystick;
import edu.wpi.first.wpilibj.DigitalInput;




/**
 *
 * @author warren.elwood
 */
public class Ejector 
{
 double speed;
 MyJoystick joy;
 MyTalon ejectorMotor;
 DigitalInput limitSwitchFar;
 DigitalInput limitSwitchClose;
 public void Ejector(MyJoystick joy){
     this.joy = joy;   
            }

public void run(){
       
    if(joy.getDebounce(1)){      //TODO get button
        ejectorMotor.set(speed);
        
        }
    
    if(limitSwitchFar.get()){
        ejectorMotor.set(-speed);
     }
    if(limitSwitchClose.get()){
        ejectorMotor.set(0);
    }
}
}
         
         



