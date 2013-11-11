/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package core;
import util.MyJoystick ;
import util.Output;
import util.TimerEjector;
/**
 * 
 *
 * @author seraj.bonakdar & troy.jameson
 * 
 * 
 */
public class Bot {
    MyJoystick joy;
    TimerEjector eject;
    Drive drive;
    
    public Bot(MyJoystick joy){
        Output.println(3,"Bot Got to",1);
        this.joy = joy;   
        eject = new TimerEjector(joy);
		drive = new Drive();
    }
    
    public void botRun(){
        //System.out.println("Bot Got to #2");
        eject.run();
        Output.println(3,"Bot Got to",2);
        drive.set(joy.getX(), joy.getY());
        Output.println(3,"Bot Got to",3);
    }


}





//public static void HAHA_MAY{
// int mayGradeInLife = -100;
//if( mayGradeInLife > -101){
//       System.out.println("HAHA MAY"); }
//else(){
//       System.out.println("gj chen"); }
//}

