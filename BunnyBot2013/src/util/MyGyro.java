/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util;
import edu.wpi.first.wpilibj.Gyro;
/**
 *
 * @author coders
 */
public class MyGyro extends Gyro {
    public MyGyro(int channel) {
        super(channel);
    }
    public double getRoundedAngle(int digits) {
        return MyMath.round(this.getAngle(),digits);
    }
}
