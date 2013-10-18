/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package core;
import edu.wpi.first.wpilibj.Solenoid;
/**
 *
 * @author Troy-Jameson(Trevor)
 */
public class Piston extends Solenoid {
    
    Solenoid solenoidOne;
    Solenoid solenoidTwo;
    
    public Piston(int portOne, int portTwo, int portThree, int portFour) {
        super(portOne, portTwo);
        
        solenoidOne = new Solenoid(portOne, portTwo);
        solenoidTwo = new Solenoid(portThree, portFour);
    }
    public void solenoidSwitch(){
        if (solenoidOne.get()) {
            solenoidOne.set(false);
            
        }
        if (solenoidTwo.get()) {
            solenoidTwo.set(false);
        }
    }   
    public void on() {
        solenoidOne.set(true);
        solenoidTwo.set(false);
    }
    public void off() {
        solenoidOne.set(false);
        solenoidTwo.set(true);
    }
}
