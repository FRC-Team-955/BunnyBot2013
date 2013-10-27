/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package auto;

/**
 *
 * @author aditya.sriram
 */
public class TimerAuto {
    
    Driver driver;
    
    public TimerAuto(Driver driver){
        this.driver = driver
    }
    
    public void run(){
    
    int i;
    double k;
    
    driver.goForward(this.getTime(i=26, k=.7),k=.7);
    driver.turnRight(i=90);
       driver.goForward(this.getTime(i=3, k=.7),k=.7);
    
    
    }
    
    
     public int getTime(int distance, double speed){
    
      int time = (distance * (speed * Vars.MAX_SPEED))/1000; // TODO find units
    
     return time;
   }
    
    
    
    
}
