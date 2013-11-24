package util;

import java.io.IOException;
import java.io.DataInputStream;
import javax.microedition.io.Connector;
import com.sun.squawk.microedition.io.FileConnection;

/**
 * This class is responsible for opening/closing and reading data from the file.
 * @author Fauzi
 */
public class FileReader {

    private final String m_sFile;
    private FileConnection m_fc;
    private DataInputStream m_reader;
    
    /**
     * Opens the specified file and prepares it for reading data from.
     * @param sFileName 
     */
    public FileReader(String sFileName)
    {
        m_sFile = sFileName;
        
        try
        {
            m_fc = (FileConnection)Connector.open(m_sFile, Connector.READ);
            m_reader = new DataInputStream(m_fc.openInputStream());
        }
        
        catch (IOException e) 
        {
            System.out.println(e.getMessage());
        }
    }
        
    /**
     * Reads an integer value from the file.
     * @return 
     */
    public int readInt()
    {
        try
        {
            return m_reader.readInt();
        }
        
        catch(IOException e)
        {
            return 0;
        }
    }
    
    /**
     * Reads a double value from the file.
     * @return 
     */
    public double readDouble()
    {
        try
        {
            return m_reader.readDouble();
        }
        
        catch(IOException e)
        {
            return 0;
        }
    }
    
    /**
     * Reads a boolean value from the file.
     * @return 
     */
    public boolean readBoolean()
    {
        try
        {
            return m_reader.readBoolean();
        }
        
        catch(IOException e)
        {
            return false;
        }
    }
    /**
     * Closes the file, disabling use of it.
     */
    public void close()
    {
        try
        {
            m_reader.close();
            m_fc.close();
        }
        
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
}