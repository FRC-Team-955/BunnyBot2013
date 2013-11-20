/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 * @author matthew.sundberg
 *
 */
public class Output 
{
    private static int[] idArray;
    
    public static void setIdArray(int[] newIdArray)
    {
        idArray = newIdArray;
    }
    
    public static boolean checkToPrint(int id)
    {
        for(int index = 0; index < idArray.length; index++)
            if(id == idArray[index])
                return true;
        
        return false;
    }
    
    public static void println(int id, String value)
    {
        if(checkToPrint(id))
            System.out.println(value);
    }
    
    public static void addId(int id)
    {
        if(checkToPrint(id))
            return;
        
        int[] newIdArray = new int[idArray.length + 1];
        
        for(int index = 0; index < newIdArray.length; index++)
        {
            if((index + 1) == newIdArray.length)
                newIdArray[index] = id;
            
            else
                newIdArray[index] = idArray[index];
        }
        
        setIdArray(newIdArray);
    }
    
    public static void removeId(int id)
    {
        if(!checkToPrint(id))
            return;
        
        int[] newIdArray = new int[idArray.length - 1];
        
        for(int currentIndex = 0, newIndex = 0; currentIndex < idArray.length; currentIndex++)
        {
            if(idArray[currentIndex] == id)
                continue;
            
            newIdArray[newIndex++] = idArray[currentIndex];
        }
        
        setIdArray(newIdArray);
    }
    
    public static void printArray()
    {
        for(int i = 0; i < idArray.length; i++)
            System.out.println(idArray[i]);
    }
}
