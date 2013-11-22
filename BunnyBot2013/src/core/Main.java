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

/**
 * 
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Main extends IterativeRobot 
{
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    Bot bot;
    MyJoystick joy;    
	Output print;
	
    public void robotInit() 
    {
        print = new Output(Config.getOutputArray());
		joy = new MyJoystick(Config.chnJoystick); 
        bot = new Bot(joy);

    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() 
    {
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() 
    {
       bot.botRun();
    }
    
    public void disabledInit() 
    {
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic()
    {
    
    }
}
