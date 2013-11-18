/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import util.MyTalon;
import util.Config;
import util.MyJoystick;
import edu.wpi.first.wpilibj.DigitalInput;
import util.Output;

/**
 *
 * @author warren.elwood
 */
public class Ejector {

    double speed;
    MyJoystick joy;
    MyTalon ejectorMotor;
    DigitalInput limitSwitchFar;
    DigitalInput limitSwitchClose;
    boolean retractMode = false;

    public
            Ejector(MyJoystick joy) {
        limitSwitchFar = new DigitalInput(Config.LIMIT_SWITCH_FAR_CHAN);
        limitSwitchClose = new DigitalInput(Config.LIMIT_SWITCH_CLOSE_CHAN);
        ejectorMotor = new MyTalon(Config.EJECTOR_CHANNEL);
        Output.println(5, "Ejector Got to", 1);
        this.joy = joy;
        Output.println(5, "Ejector Got to", 2);
    }

    public
            void run() {
        Output.println(5, "Ejector Got to", 3);
        if (joy.getDebounce(1)) {      //TODO get button
            ejectorMotor.set(speed);
            Output.println(5, "Ejector Got to", 4);
        }
        Output.println(5, "Ejector Got to", 5);
        if (retractMode == false && limitSwitchFar.get()) {
            ejectorMotor.set(-speed);
            retractMode = true;
            Output.println(5, "Ejector Got to", 6);
        }
        if (limitSwitchClose.get()) {
            ejectorMotor.set(0);
            retractMode = false;
            Output.println(5, "Ejector Got to", 7);
        }
        Output.println(5, "Ejector Got to", 8);
    }

}
