/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package auto;

import core.Drive;
import util.Config;
import edu.wpi.first.wpilibj.Timer;

/**
 *
 * @author aditya.sriram
 */
public class TimerAuto {

    boolean one = true;
    boolean two = false;
    boolean three;

    Drive drive;
    Timer timer = new Timer();

    public
            TimerAuto(Drive drive) {
        this.drive = drive;
    }

    public
            void run() {

        if (one) {

            double time = 10 / (1 *     Config.MAX_SPEED);

            timer.start();

            if (timer.get() <= time) {

                drive.set(1, 0);

            }
            else {

                two = true;
                timer.stop();
                timer.reset();

            }
        }

        if (two) {

            double time = 10 / (1 * Config.MAX_SPEED);

            timer.start();

            if (timer.get() <= time) {

                drive.set(1, 1);

            }
            else {

                three = true;
                timer.stop();
                timer.reset();

            }

        }
        if (three) {

            double time = 10 / (1 * Config.MAX_SPEED);

            timer.start();

            if (timer.get() <= time) {

                drive.set(1, 0);

            }
            else {

                three = true;
                timer.stop();
                timer.reset();

            }

        }
    }

}
