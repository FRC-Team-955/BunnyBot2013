/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package core;
import util.MyJoystick ;
/**
 * 
 *
 * @author seraj.bonakdar & troy.jameson
 * 
 * 
 */
public class Bot {
    MyJoystick joy;
    Ejector eject = new Ejector();
    Drive drive = new Drive();
    
    public void Bot(MyJoystick joy){
        this.joy = joy;   
    }
    
    public void botRun(){
        eject.run();
        drive.set(joy.getX(), joy.getY());
    }


}





//public static void HAHA_MAY{
// int mayGradeInLife = -100;
//if( mayGradeInLife > -101){
//       System.out.println("HAHA MAY"); }
//else(){
//       System.out.println("gj chen"); }
//}

