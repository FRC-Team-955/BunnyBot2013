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

    private double m_dTime = 0;
    private double m_dX = 0;
    private double m_dY = 0;
    private boolean m_bPush = false;

    private void setValues(double dTimer, double dX, double dY, boolean bPush) {
        m_dTime = dTimer;
        m_dX = dX;
        m_dY = dY;
        m_bPush = bPush;
    }

    /**
     * Sets the values.
     */
    public void setValues(double dTime, MyJoystick joy) {
        setValues(dTime, joy.getMyX(), joy.getMyY(), joy.gotPressed(Config.btEjector));
    }

    public void setValues(JoyData emu) {
        setValues(emu.getTimer(), emu.getX(), emu.getY(), emu.getEjector());
    }

    public void setTime(double timeVal) {
        m_dTime = timeVal;
    }

    public void setX(double x) {
        m_dX = x;
    }

    public void setY(double y) {
        m_dY = y;
    }

    public void setPush(boolean val) {
        m_bPush = val;
    }

    /**
     * Returns time stamp of the data.
     *
     * @return
     */
    public double getTimer() {
        return m_dTime;
    }

    /**
     * Gets the x value.
     *
     * @return
     */
    public double getX() {
        return m_dX;
    }

    /**
     * Gets the y value.
     *
     * @return
     */
    public double getY() {
        return m_dY;
    }

    public boolean getEjector() {
        return m_bPush;
    }
}
