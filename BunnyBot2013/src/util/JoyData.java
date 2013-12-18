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

    private void setValues(double timer, double x, double y, boolean ejector) {
        m_time = timer;
        m_x = x;
        m_y = y;
        m_push = ejector;
    }

    /**
     * Sets the values.
     */
    public void setValues(double time, MyJoystick joy) {
        setValues(time, joy.getMyX(), joy.getMyY(), joy.getButton(Config.btEjector));
    }

    public void setValues(JoyData emu) {
        setValues(emu.getTimer(), emu.getX(), emu.getY(), emu.getEjector());
    }

    public void setTime(double timeVal) {
        m_time = timeVal;
    }

    public void setX(double x) {
        m_x = x;
    }

    public void setY(double y) {
        m_y = y;
    }

    public void setPush(boolean val) {
        m_push = val;
    }

    /**
     * Returns time stamp of the data.
     *
     * @return
     */
    public double getTimer() {
        return m_time;
    }

    /**
     * Gets the x value.
     *
     * @return
     */
    public double getX() {
        return m_x;
    }

    /**
     * Gets the y value.
     *
     * @return
     */
    public double getY() {
        return m_y;
    }

    public boolean getEjector() {
        return m_push;
    }
}
