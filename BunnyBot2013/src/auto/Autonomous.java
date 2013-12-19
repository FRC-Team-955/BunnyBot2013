package auto;

import util.Config;
import util.MyJoystick;
import util.Station;

/**
 * Class to record/replay robots movements.
 * @author fauzi
 */
public class Autonomous {
    
    // CONSTANTS
    private static final String m_sRegOutput = "file:///regVal.txt";
    private static final String m_sAutoCenter = "file:///autoval.txt";
    private static final String m_sAutoLeft = "file:///autoLeft.txt";
    private static final String m_sAutoRight = "file:///autoRight.txt";
    private static final double m_dMaxAutoTime = 14.75;
     
    private String m_sFileName = m_sRegOutput;   
    private String m_sAutonmousStatus = "Doing Nothing";
    private String m_sFileTypeStat = "Reg: ";
    private String m_sEditInfoStat = "NON-EDIT MODE";
    private Recorder m_recorder;
    private Replayer m_replayer; 
    private MyJoystick m_joy;

    /**
     * Class used for autonomous.
     * @param joystick
     */
    public Autonomous(MyJoystick joystick)
    {
        m_joy = joystick;
        m_recorder = new Recorder(m_joy);
        m_replayer = new Replayer(m_joy);
    }
    
    /**
     * Allows autonomous to run.
     */
    public void run()
    {
        if(m_joy.getButton(Config.btReplay))
            if(!m_joy.getSwitch(Config.btRecord))
                m_joy.flipSwitch(Config.btReplay);
                
        if(m_joy.getButton(Config.btRecord))
            if(!m_joy.getSwitch(Config.btReplay))
                m_joy.flipSwitch(Config.btRecord);
                        
        if(!m_joy.getSwitch(Config.btReplay) && !m_joy.getSwitch(Config.btRecord))
        {
            // Changes the ability for the user to edit the autonomous
            if(m_joy.getButton(Config.btAllowEdit))
            {
                m_joy.flipSwitch(Config.btAllowEdit);

                if(m_joy.getSwitch(Config.btAllowEdit))
                    m_sEditInfoStat = "WARNING EDIT MODE";

                else
                    m_sEditInfoStat = "NON-EDIT MODE";
            }
            
            // Changes the autonomous files
            if(m_joy.getDpadUp())
                changeFile(Config.stDigInReg);
        
            else if(m_joy.getDpadRight())
                changeFile(Config.stDigInAutoRight);

            else if(m_joy.getDpadDown())
                changeFile(Config.stDigInAutoCenter);

            else if(m_joy.getDpadLeft())
                changeFile(Config.stDigInAutoLeft);
        }
        
        if(m_joy.getSwitch(Config.btRecord))   
            record();		

        else if(m_joy.getSwitch(Config.btReplay))
            replay();
        
        else
            resetAutonomous();
        
        Station.print(Config.stLineFile, m_sEditInfoStat);
        Station.print(Config.stLineAutonomous, m_sFileTypeStat + m_sAutonmousStatus);
    }
    
    /**
     * Replays previous bot movements from specified file.
     */
    public void replay()
    {
        m_replayer.replay(m_sFileName);
        
        if(!m_replayer.isDone() && !overTimeLimit(m_replayer.getReplayTime()))
            m_sAutonmousStatus = "Rep: " + m_replayer.getReplayTime();
        
        else 
        {
            m_replayer.stop();
            m_joy.setSwitch(Config.btReplay, false);
            m_sAutonmousStatus = "Replay Finished";
        }
    }
    
    /**
     * Records bots movements to specified file, if allowed.
     */
    private void record()
    {        
        if(m_sFileName.equals(m_sRegOutput) || (m_joy.getSwitch(Config.btAllowEdit) && !overTimeLimit(m_recorder.getRecordTime())))
        {
            m_recorder.record(m_sFileName);
            m_sAutonmousStatus = "Rec: " + m_recorder.getRecordTime();
        }
        
        else
        {
            m_recorder.stop();
            m_joy.setSwitch(Config.btRecord, false);
            m_sAutonmousStatus = "Recording Stopped";
        }
    }
    
    /**
     * Resets the autonomous so we can use it again properly next time.
     */
    public void resetAutonomous()   
    {
        m_sAutonmousStatus = "Nothing";
        m_joy.setSwitch(Config.btReplay, false);
        m_joy.setSwitch(Config.btRecord, false);
        m_replayer.reset();
        m_recorder.reset();
    }
    
    /**
     * Chooses the ;autonomous from the driverstation, for use right before 
     * the actual autonomous begins.
     */
    public void setFile()
    {
        int iFileType = Config.stDigInReg;
        
        if(Station.getDitigalIn(Config.stDigInAutoCenter))
            iFileType = Config.stDigInAutoCenter;
        
        else if(Station.getDitigalIn(Config.stDigInAutoLeft))
            iFileType = Config.stDigInAutoLeft;
        
        else if(Station.getDitigalIn(Config.stDigInAutoRight))
            iFileType = Config.stDigInAutoRight;
        
        changeFile(iFileType);
    }
    
    /**
     * Changes file based on number thats passed in, only 1 to 4 are valid.
     * @param iFileType 
     */
    private void changeFile(int iFileType)
    {
        switch (iFileType)
        {
            case Config.stDigInAutoCenter:   // 1
            {
                m_sFileTypeStat = "AutoC: ";
                m_sFileName = m_sAutoCenter; 
                break;
            } 

            case Config.stDigInAutoLeft:   // 2
            {
                m_sFileTypeStat = "AutoL: ";
                m_sFileName = m_sAutoLeft;
                break;
            }

            case Config.stDigInAutoRight:  // 3
            {
                m_sFileTypeStat = "AutoR: ";
                m_sFileName = m_sAutoRight; 
                break;
            }
                
            case Config.stDigInReg:   // 4
            {
                m_sFileTypeStat = "Reg: ";
                m_sFileName = m_sRegOutput;
                break;
            }
                
            default:
            {
                m_sFileTypeStat = "AutoC: ";
                m_sFileName = m_sAutoCenter; 
                break;
            }
        }
    }
    
    /**
     * Determines whether we're over the 15 sec time limit for
     * FRC Autonomous mode.
     * @return 
     */
    private boolean overTimeLimit(double dTime)
    {
        if(dTime >= m_dMaxAutoTime && !m_sFileName.equalsIgnoreCase(m_sRegOutput))
            return true;
        
        return false;
    }
}