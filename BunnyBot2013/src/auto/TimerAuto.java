/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package auto;

import core.Drive;
import util.Config;
import edu.wpi.first.wpilibj.Timer;
import util.Vars;
/**
 *
 * @author aditya.sriram
 */
public class TimerAuto {
    
    Drive drive;
    
    public TimerAuto(Drive drive){
        this.drive = drive;
    }
    
    public void run(){
    
    
        runDistance(10, 1, 0);
    
        
    }
    
    
     public  void runDistance(int distance, double speed, int angle){
    
     Timer timer = new Timer();
     
     double time = distance / (speed * Vars.MAX_SPEED);
     
     timer.start();
     
     if(timer.get() <= time){
     
          drive.set(1, angle);
     
     }
         
   }
    
    
    
    
}
