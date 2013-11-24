/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStationLCD;

/**
 *
 * @author Merfoo
 */
public class Station 
{
    /**
     * Gets the button status from the driverstation, 1 - 8 available.
     * @param iChan
     * @return 
     */
    public static boolean getDitigalIn(int iChan)
    {
        return DriverStation.getInstance().getDigitalIn(iChan);
    }
    
    /**
     * Prints specified message to the driver station on the corresponding line
     * 1-6 are available.
     */
    public static void print(int iLine, String sMessage)
    {
        DriverStationLCD.Line line = null;
        
        switch(iLine)
        {
            case 1:
            {
                line = DriverStationLCD.Line.kUser1;
                break;
            }
            
            case 2:
            {
                line = DriverStationLCD.Line.kUser2;
                break;
            }
                
            case 3:
            {
                line = DriverStationLCD.Line.kUser3;
                break;
            }
                
            case 4:
            {
                line = DriverStationLCD.Line.kUser4;
                break;
            }
                
            case 5:
            {
                line = DriverStationLCD.Line.kUser5;
                break;
            }
                
            case 6:
            {
                line = DriverStationLCD.Line.kUser6;
                break;
            }
        }
        
        DriverStationLCD.getInstance().println(line, 1, sMessage);
        DriverStationLCD.getInstance().updateLCD(); 
    }
}