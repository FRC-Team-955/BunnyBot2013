package auto;

import util.JoyData;
import util.FileReader;
import util.Config;
import util.MyJoystick;
import edu.wpi.first.wpilibj.Timer;
import util.MyMath;
import util.Output;


/**
 * This class reads data from the specified file from the cRio and then 
 * "replays" it.
 * @author fauzi
 */
class Replayer 
{
    private int m_iMax = 0;
    private int m_iCounter = 0;
    private boolean m_bRepStarted = false;
    private boolean m_bDoneReplay = false;
    private String m_sFileName = "";
    private Timer m_tmReplay = new Timer();
    private JoyData m_joyCurrentData = null;
    private JoyData[] m_joyDataList = null;
    private FileReader m_fileReader = null;
    private MyJoystick m_joy = null;
    
    public Replayer(MyJoystick joy)
    {
        m_joy = joy;
    }
    
    /**
     * Replays data from desired file.
     * @param sFileName
     */
    public boolean replay(String sFileName)
    {                
        if(!m_bRepStarted)
        {
            Output.println(Config.IdAutonomous, "Replay Initiated");
            m_joy.setAutoMode(true);
            m_sFileName = sFileName;
            m_joyDataList = readAllData();
            m_joyCurrentData = m_joyDataList[m_iCounter++];
            m_tmReplay.start();
            m_bRepStarted = true;
        }

        if(!m_bDoneReplay)
        {            
            if(m_tmReplay.get() >= m_joyCurrentData.getTimer())    // If true it means we want new data
                m_joyCurrentData.setValues(m_joyDataList[m_iCounter++]);
            
            m_joy.setXY(m_joyCurrentData.getX(), m_joyCurrentData.getY());
            m_joy.setButton(Config.btEjector, m_joyCurrentData.getEjector());

            if(m_iCounter < 0 || m_iCounter >= m_iMax)   // If true it means we've read all data from file
                m_bDoneReplay = true;
            
            Output.println(Config.IdAutonomous, "Left: " + m_joyCurrentData.getX() + ", Right: " + m_joyCurrentData.getY() + " Ejector: " + m_joy.getButton(Config.btEjector)); 
        }

        else
        {
            m_joy.setXY(0, 0);
            m_tmReplay.stop();
            m_tmReplay.reset();
            Output.println(Config.IdAutonomous, "Replay Ended");
        }
        
        return m_bDoneReplay;
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
            m_joyCurrentData = null;
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
        return MyMath.SetDoublePrecision(m_tmReplay.get());
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
    private JoyData[] readAllData()
    {
        m_fileReader = new FileReader(m_sFileName);
        m_iMax = m_fileReader.readInt();
        JoyData joyData[] = new JoyData[m_iMax];
        
        for(int index = 0; index < m_iMax; index++)
        {
            joyData[index] = new JoyData();
            joyData[index].setTime(m_fileReader.readDouble());
            joyData[index].setX(m_fileReader.readDouble());
            joyData[index].setY(m_fileReader.readDouble());
            joyData[index].setPush(m_fileReader.readBoolean());
        }
        
        m_fileReader.close();
        return joyData;
    }
}