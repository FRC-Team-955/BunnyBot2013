/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 * Holds data corresponding to the values of the robot.
 *
 * @author Fauzi
 */
public class JoyData {

    private double m_time = 0;
    private double m_x = 0;
    private double m_y = 0;
    private boolean m_push = false;

    /**
     * Sets all the properties
     * @param timer
     * @param x
     * @param y
     * @param ejector 
     */
    private void setValues(double timer, double x, double y, boolean ejector) {
        m_time = timer;
        m_x = x;
        m_y = y;
        m_push = ejector;
    }

    /**
     * Sets all the properties
     * @param time
     * @param joy 
     */
    public void setValues(double time, MyJoystick joy) {
        setValues(time, joy.getMyX(), joy.getMyY(), joy.getButton(Config.btEjector));
    }

    /**
     * Sets all the properties
     * @param emu 
     */
    public void setValues(JoyData emu) {
        setValues(emu.getTimer(), emu.getX(), emu.getY(), emu.getEjector());
    }

    /** 
     * Sets the time stamp of when the data was taken
     * @param timeVal 
     */
    public void setTime(double timeVal) {
        m_time = timeVal;
    }

    /**
     * Sets the x property of the joystick data
     * @param x
     */
    public void setX(double x) {
        m_x = x;
    }

    /**
     * Sets the y property of the joystick data
     * @param y 
     */
    public void setY(double y) {
        m_y = y;
    }

    /**
     * Sets the ejector
     * @param val 
     */
    public void setEjector(boolean val) {
        m_push = val;
    }

    /**
     * Returns time stamp of the data.
     * @return
     */
    public double getTimer() {
        return m_time;
    }

    /**
     * Gets the x value.
     * @return
     */
    public double getX() {
        return m_x;
    }

    /**
     * Gets the y value.
     * @return
     */
    public double getY() {
        return m_y;
    }

    /**
     * Gets the ejector status
     * @return 
     */
    public boolean getEjector() {
        return m_push;
    }
}
