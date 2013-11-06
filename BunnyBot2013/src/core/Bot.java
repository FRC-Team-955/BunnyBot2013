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
        System.out.println("Bot Got to #1");
        this.joy = joy;   
        System.out.println("Bot Got to #2");
    }
    
    public void botRun(){
        System.out.println("Bot Got to #3");
        eject.run();
        System.out.println("Bot Got to #4");
        drive.set(joy.getX(), joy.getY());
        System.out.println("Bot Got to #5");
    }


}





//public static void HAHA_MAY{
// int mayGradeInLife = -100;
//if( mayGradeInLife > -101){
//       System.out.println("HAHA MAY"); }
//else(){
//       System.out.println("gj chen"); }
//}

