/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package core;


import util.Vector;
import util.VectorController;
import util.Output;
import edu.wpi.first.wpilibj.IterativeRobot;
import util.MyJoystick;

/**
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
    Vector a = new Vector (1,0);
        Vector b = new Vector (1,Math.PI/2);
        Vector c = new Vector (0,0);
        VectorController vect = new VectorController();
        double[] array = new double[2];
        Output output = new Output();

    public void robotInit() {
	   joy = new MyJoystick(1); 
	   bot = new Bot(joy);
       System.out.println("Main Got to #1");
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
System.out.println("Main Got to #2");
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
	   bot.botRun();
       vect.add(a,b,c);
       c.toArray(array);
       System.out.print(array[0]);
       System.out.print(array[1]);

    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    
}
