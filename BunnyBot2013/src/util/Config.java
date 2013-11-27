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
 * @author Everyone All of the configurations.
 */
public class Config {

    // Drive Related
    public static final double rampRate = 0.1;
    public static final int driveMaxSpeed = 10;     // Used for Timer Auto (TODO units)
    public static final int chnDriveLeft1 = 5;
    public static final int chnDriveRight1 = 8;
    public static final int chnDriveRight2 = 7;
    public static final int chnDriveLeft2 = 6;
    public static final double rampScale = .125;
    // Ejector Related
    public static final double ejectorSpeed = 0.76536;
    public static final int ejectorTime = 2;
    public static final int chnLsClose = 7;
    public static final int chnLsFar = 6;
    public static final int chnEjector = 1;
    // Joystick Related
    public static final int chnJoystick = 1;
    public static final int buttonsOnJoystick = 13;
    public static final int btEjector = 1;
    // Recorder Autonomous Related
    public static final int btRecord = 9;
    public static final int btAllowEdit = 10;
    public static final int btReplay = 12;
    // Output Related
    public static final int driveId = 1;
    public static final int ejectorId = 2;
    public static final int joystickId = 3;
    public static final int talonId = 4;
    public static final int autonomousId = 5;
    public static final int recorderId = 6;
    public static final int replayerId = 7;
    private static int[] outputArray = {driveId, ejectorId, joystickId, talonId, replayerId, recorderId, autonomousId};

    public static int[] getOutputArray() {
        System.out.println("outputArray " + outputArray.length);
        return outputArray;
    }

    // DriverStation Digital Input Channels 1-8 available
    public static final int stDigInAutoCenter = 1;
    public static final int stDigInAutoLeft = 2;
    public static final int stDigInAutoRight = 3;
    public static final int stDigInReg = 4;
    public static final int stDigInDrive = 5;
    public static final int stDigInAutonomous = 6;
    public static final int stDigInRecorder = 7;
    public static final int stDigInReplayer = 8;
    // Driverstation line
    public static final int stLineFile = 2;
    public static final int stLineAutonomous = 3;
}
