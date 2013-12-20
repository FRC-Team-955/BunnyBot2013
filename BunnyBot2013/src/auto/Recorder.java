package auto;

import util.FileWriter;
import util.Config;
import util.MyJoystick;
import util.JoyData;
import java.util.Vector;
import edu.wpi.first.wpilibj.Timer;
import util.MyMath;
import util.Output;

/**
 * This class is responsible for writing the bots activities to the specified 
 * file on the cRio.
 * @author Fauzi
 */
class Recorder {

    private int m_index = 0;
    private boolean m_bRecStarted = false;
    private boolean m_bRecDone = false;
    private String m_sFile = "";
    private Timer m_tmRecorder = new Timer();
    private Vector m_list = new Vector();
    private JoyData m_joyData = null;
    private FileWriter m_fileWriter = null;
    private MyJoystick m_joy;
    
    public Recorder(MyJoystick joy)
    {
       m_joy = joy;
    }
    
    /**
     * Records bots movements to specified file.
     * @param sFileName 
     */
    public void record(String sFileName)
    {        
        if(!m_bRecStarted)
        {
            Output.println(Config.IdAutonomous, "Recording!!!");	
            m_sFile = sFileName;
            m_tmRecorder.start();
            m_bRecStarted = true;
        }
        
        if(!m_bRecDone)
        {
            m_index++;
            m_joyData = new JoyData();  // Have to reinit it to prevent changing previous ones		
            m_joyData.setValues(m_tmRecorder.get(), m_joy);
            m_list.addElement(m_joyData);
        }
        
        else
        {
            m_joy.setAutoMode(true);
            m_joy.setXY(0, 0);
            m_tmRecorder.stop();
        }
    }
    
    /**
     * Resets the recorder so we can record properly next time.
     */
    public void reset()
    {
        if(m_bRecStarted)
        {
            writeDataToFile();
            m_joy.setAutoMode(false);
            m_list.removeAllElements();
            m_index = 0;
            m_tmRecorder.stop();
            m_tmRecorder.reset();
            m_sFile = "";
            m_joyData = null;
            m_bRecDone = false;
            m_bRecStarted = false;
        }
    }
    
    /**
     * Stops recording, also enters auto mode and disables user input and 
	 * puts the robot to a halt.
     */
    public void stop()
    {
        m_bRecStarted = true;
        m_bRecDone = true;
		m_joy.setAutoMode(true);
		m_joy.setXY(0, 0);
    }
    
    /** 
     * Gets the time value of the recording, as in how long it has been 
     * replaying
     * @return 
     */
    public double getRecordTime()
    {
        return MyMath.round(m_tmRecorder.get());
    }
    
    /**
     * Actually writes the data to file.
     */
    private void writeDataToFile()
    {
        if(m_index > 0)
        {
            m_fileWriter = new FileWriter(m_sFile);
            m_fileWriter.writeInt(m_index);

            for(int iPos = 0; iPos < m_index; iPos++)
            {
                m_joyData.setValues((JoyData) m_list.elementAt(iPos));
                Output.println(Config.IdAutonomous, "X: " + m_joyData.getX()+ ", Y: " + m_joyData.getY());	
                m_fileWriter.writeDouble(m_joyData.getTimer());
                m_fileWriter.writeDouble(m_joyData.getX());
                m_fileWriter.writeDouble(m_joyData.getY());
                m_fileWriter.writeBoolean(m_joyData.getEjector());
            }

            m_fileWriter.close();
        }
    }
}