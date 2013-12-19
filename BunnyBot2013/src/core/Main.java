/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package core;

import util.Output;
import edu.wpi.first.wpilibj.IterativeRobot;
import util.Config;
import util.MyJoystick;
import auto.Autonomous;
import auto.TimerAuto;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Main extends IterativeRobot {

    
    Bot bot;
    MyJoystick joy;
    Autonomous auto;
//	TimerAuto tauto;
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() 
	{
		System.out.println("Bunny Bot 2013");
        Output.updateArray();
        joy = new MyJoystick(Config.chnJoystick, Config.buttonsOnJoystick);
        bot = new Bot(joy);
        joy.setAxisChannel(MyJoystick.AxisType.kX, 3);
        joy.setAxisChannel(MyJoystick.AxisType.kY, 2);
        auto = new Autonomous(joy);
//		tauto = new TimerAuto(bot.drive);
	
	
	}

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() 
	{
        Output.updateArray();
        auto.replay();
		bot.botRun();
//		tmrAuto.run();

	
	}

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Output.updateArray();
		joy.updateButtons();
        bot.botRun();
        auto.run();
	}

    /**
     * Called once in m_autonomous
     */
    public void autonomousInit() {
        Output.updateArray();
        auto.setFile();
		//System.out.println("Auto Initiated");
	
	
	}

    /**
     * This function is called once when the robot is disabled
     */
    public void disabledInit() {
        Output.updateArray();

        // Resets the replay to false if it was true before
        auto.resetAutonomous();
    }
}