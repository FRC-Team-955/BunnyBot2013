/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package core;

import util.MyGyro;
import util.Output;
import edu.wpi.first.wpilibj.IterativeRobot;
import util.Config;
import util.MyJoystick;
import auto.Autonomous;

/**
 *
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Main extends IterativeRobot {

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    Bot bot;
    MyJoystick joy;
    Output print;
    Autonomous auto;

    public void robotInit() {
        print = new Output(Config.getOutputArray());
        joy = new MyJoystick(Config.chnJoystick);
        bot = new Bot(joy);
        Output.updateArray();
        joy.setAxisChannel(MyJoystick.AxisType.kX, 3);
        joy.setAxisChannel(MyJoystick.AxisType.kY, 2);
        auto = new Autonomous(joy);
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Output.updateArray();
        auto.replay();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        bot.botRun();
        Output.updateArray();
        joy.updateButtons();
        auto.run();
    }

    /**
     * Called once in m_autonomous, tells m_autonomous which file to play based
     * on the value of "iFileType"
     */
    public void autonomousInit() {
        Output.updateArray();
        auto.setFile();
    }

    public void disabledInit() {
        Output.updateArray();

        // Resets the replay to false if it was true before
        auto.resetAutonomous();
    }

    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    }
}
