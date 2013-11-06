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
     System.out.println("Ejector Got to #1");
     this.joy = joy;   
     System.out.println("Ejector Got to #2");
            }

public void run(){
       System.out.println("Ejector Got to #3");
    if(joy.getDebounce(1)){      //TODO get button
        ejectorMotor.set(speed);
        System.out.println("Ejector Got to #4");
        }
    System.out.println("Ejector Got to #5");
    if(limitSwitchFar.get()){
        ejectorMotor.set(-speed);
        System.out.println("Ejector Got to #6");
     }
    if(limitSwitchClose.get()){
        ejectorMotor.set(0);
        System.out.println("Ejector Got to #7");
    }
    System.out.println("Ejector Got to #8");
}
}
         
         



