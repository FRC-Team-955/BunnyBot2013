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
import auto.TimerAuto;
import edu.wpi.first.wpilibj.Encoder;

/**
 *
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Main extends IterativeRobot {

    
    Bot bot;
    MyJoystick joy;
	Encoder enca;
	Encoder encb;
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
		enca = new Encoder(1,2);
		encb = new Encoder(3,4);
		enca.start();
		encb.start();
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
		//System.out.println("Running Auto");
//		tmrAuto.run();

	
	}

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Output.updateArray();
		joy.updateButtons();
        bot.botRun();
		System.out.println(encb.get()+"   "+ enca.get());
        auto.run();
	}

    /**
     * Called once in m_autonomous, tells m_autonomous which file to play based
     * on the value of "iFileType"
     */
    public void autonomousInit() {
        Output.updateArray();
        auto.setFile();
		//System.out.println("Auto Initiated");
	
	
	}

    public void disabledInit() {
        Output.updateArray();

        // Resets the replay to false if it was true before
        auto.resetAutonomous();
    }
}
