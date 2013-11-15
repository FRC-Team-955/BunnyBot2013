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
    
    boolean firstRun = false;
    Drive drive;
    
    public TimerAuto(Drive drive){
        this.drive = drive;
    }
    
    public void run(){
    
        
    
        if(!firstRun){
            
            runDistance(10, 1, 0,-1);
            firstRun = true;
        
        }
        
        
    }
    
    
     public  void runDistance(int distance, double speed, int angle, int direction){
    
     Timer timer = new Timer();
     
     double time = distance / (speed * Vars.MAX_SPEED);
     
     timer.start();
     
     for(;timer.get() <= time;){
     
          drive.set(1, angle);
     }
         
   }
    
    
    
    
}
