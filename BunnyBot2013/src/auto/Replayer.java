package autonomous;

import utilities.JoyData;
import utilities.FileReader;
import utilities.Vars;
import utilities.MyJoystick;
import edu.wpi.first.wpilibj.Timer;


/**
 * This class reads data from the specified file from the cRio and then 
 * "replays" it.
 * @author fauzi
 */
class Replayer {
  
    // CONSTANTS
    private final double m_dTimeTolerance = .01;
    
    private int m_iMax = 0;
    private int m_iCounter = 0;
    private boolean m_bRepStarted = false;
    private boolean m_bDoneReplay = false;
    private boolean m_bVerboseMode = true;
    private String m_sFileName = "";
    private Timer m_tmReplay = new Timer();
    private JoyData m_joyData = null;
    private JoyData[] m_joyDataList = null;
    private FileReader m_fileReader = null;
    private MyJoystick m_joy;
    
    public Replayer(MyJoystick joy)
    {
        m_joy = joy;
    }
    
    /**
     * Replays data from desired file.
     * @param sFileName
     */
    public void replay(String sFileName)
    {                
        if(!m_bRepStarted)
        {
            if(m_bVerboseMode)
                System.out.println("Replaying!!!");
				
            m_joy.setAutoMode(true);
            m_sFileName = sFileName;
            readAllData();
            m_joyData = m_joyDataList[m_iCounter++];
            m_tmReplay.start();
            m_bRepStarted = true;
        }

        if(!m_bDoneReplay)
        {                    
            if(getNewData())
                m_joyData.setValues(m_joyDataList[m_iCounter++]);
            
            m_joy.setXY(m_joyData.getX(), m_joyData.getY());
            m_joy.setButton(Vars.btShootAllFrisbee, m_joyData.getShoot());
            m_joy.setButton(Vars.btSlow, m_joyData.getSlow());
            
            if(m_bVerboseMode)
                System.out.println("Left: " + m_joyData.getX() + 
                    " - Right: " + m_joyData.getY() + 
                    " - Shooter: " + m_joyData.getShoot()); 

            if(EndOfFile())
                m_bDoneReplay = true;
        }

        else
        {
            m_joy.setXY(0, 0);
            m_joy.setButton(Vars.btShootAllFrisbee, false);
            m_joy.setButton(Vars.btSlow, false);
            m_tmReplay.stop();
            m_tmReplay.reset();
			
            if(m_bVerboseMode)
                System.out.println("Replay Ended");
        }
    }
    
    /**
     * Resets the replayer so it can properly replay next time.
     */
    public void reset()
    {
        if(m_bRepStarted)
        {
            m_joy.setAutoMode(false);
            m_tmReplay.stop();
            m_tmReplay.reset();
            m_sFileName = "";
            m_joyData = null;
            m_joyDataList = null;
            m_iCounter = 0;
            m_iMax = 0;
            m_bDoneReplay = false;
            m_bRepStarted = false;
        }
    }
    
    /**
     * Gets the value of the recording, as in how long it has been replaying.
     * Returns -1 when done, or if it's not replaying
     * @return 
     */
    public double getReplayTime()
    {      
        if(m_tmReplay.get() < m_dTimeTolerance)
            return -1;
        
        return Vars.fnSetPrecision(m_tmReplay.get());
    }
    
    /**
     * Stops replay from replaying.
     */
    public void stop()
    {
        m_bRepStarted = true;
        m_bDoneReplay = true;
    }
    
    /**
     * Reads all the data from the file at once and stores them into an array
     * that we can access.
     */
    private void readAllData()
    {
        m_fileReader = new FileReader(m_sFileName);
        m_iMax = m_fileReader.readInt();
        m_joyDataList = new JoyData[m_iMax];
        
        for(int index = 0; index < m_iMax; index++)
        {
            m_joyDataList[index] = new JoyData();
            m_joyDataList[index].setValues(readData());
        }
        
        m_fileReader.close();
    }

    /**
     * Determines whether we should update our data.
     * @return 
     */
    private boolean getNewData()
    {
        if(m_tmReplay.get() >= m_joyData.getTimer())
            return true;
        
        return false;
    }
    
    /**
     * Determines whether we're at the end of the file.
     * @return 
     */
    private boolean EndOfFile()
    {
        if(m_iCounter > 0 && m_iCounter < m_iMax)
            return false;
        
        return true;
    }
    
    /**
     * Reads one set of data and returns a JoyData containing it.
     * @return 
     */
    private JoyData readData()
    {
        JoyData tempJoyData = new JoyData();
        
        tempJoyData.setValues(m_fileReader.readDouble(), m_fileReader.readDouble(), m_fileReader.readDouble(), m_fileReader.readBoolean(), m_fileReader.readBoolean());
        return tempJoyData;
    }
}