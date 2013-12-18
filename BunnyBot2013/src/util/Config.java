/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/*  Short Hand Names
    chn = channel
    enc = encoder
    bt = button
    ls = limit switch
*/
/**
 * @author Everyone 
 All of the configurations.
 */
public class Config 
{
    // PWM Channels (Talons)
    public static final int chnEjector = 4;
    public static final int chnDriveLeft1 = 1;
    public static final int chnDriveLeft2 = 2;
    public static final int chnDriveLeft3 = 3;
    
    public static final int chnDriveRight1 = 5;
    public static final int chnDriveRight2 = 6;
    public static final int chnDriveRight3 = 7;
    
    // Analog Input Channels (Gyros)
    
    // Digital Input Channels (Limit Switches, Encoders)
    public static final int chnLsClose = 1;     // Used for Ejector detection
    public static final int chnLsFar = 3;       // Used for Ejector detection
    
    // Drive Constants
    public static final double rampRate = 0.1;
    public static final double rampScale = .125;
    public static final int driveMaxSpeed = 10;     // Used for Timer Auto (TODO units)
    
    // Ejector Constants
    public static final double ejectorSpeed = 0.76536;
    public static final int ejectorTime = 2;
    
    // Joystick Constants
    public static final int btEjector = 1;
    public static final int btRecord = 9;
    public static final int btAllowEdit = 10;
    public static final int btReplay = 12;
    public static final int buttonsOnJoystick = 13;
    public static final int chnJoystick = 1;    
    
    // DriverStation Digital Input Channels 1-8 available
    public static final int stDigInAutoCenter = 1;
    public static final int stDigInAutoLeft = 2;
    public static final int stDigInAutoRight = 3;
    public static final int stDigInReg = 4;
    public static final int stDigInDrive = 5;
    public static final int stDigInAutonomous = 6;
    public static final int stDigInEjector = 7;
	public static final int stDigInTalon = 8;
    
	// Output Related
    public static final int IdDrive = stDigInDrive;
    public static final int IdEjector = stDigInEjector;
    public static final int IdAutonomous = stDigInAutonomous;
	public static final int IdTalon = stDigInTalon;
    public static final int joystickId = 4;
	
    // Driverstation line 1-6 available
    public static final int stLineFile = 2;
    public static final int stLineAutonomous = 3;
    public static final int stLineEjector = 6;
}
