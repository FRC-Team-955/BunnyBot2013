/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import edu.wpi.first.wpilibj.Talon;
import util.Output;

/**
 *
 * @author aditya.sriram
 */
public class MyTalon extends Talon {

    public
            MyTalon(int channel) {
        super(channel);
        Output.println(6, "MyTalon Got to", 1);
    }

}
