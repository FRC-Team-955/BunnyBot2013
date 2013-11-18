/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import com.sun.squawk.util.MathUtils;

/**
 *
 * @author Ryan
 */
public class Vector {

    private double x;
    private double y;

    /**
     * Makes a vector
     *
     * @param direction
     * @param angle
     */
    public Vector(double direction, double angle) {
        x = direction * Math.cos(angle);
        y = direction * Math.sin(angle);
    }

    /**
     * Sets the vector
     *
     * @param direction
     * @param angle
     */
    public void set(double direction, double angle) {
        x = direction * Math.cos(angle);
        y = direction * Math.sin(angle);
    }

    /**
     * Gets the x component of the vector
     *
     * @return
     */
    public double getX() {
        return x;
    }

    /**
     * Gets the Y component of the vector
     *
     * @return
     */
    public double getY() {
        return y;
    }

    /**
     * Sets the vector based on components
     *
     * @param a
     * @param b
     */
    public void setComponets(double a, double b) {
        x = a;
        y = b;
    }

    /**
     * Gets the angle
     *
     * @return
     */
    public double getAngle() {
        return MathUtils.atan2(y, x);
    }

    /**
     * gets the mangitude
     *
     * @return
     */
    public double getMangitude() {
        double tempX = x * x;
        double tempY = y * y;
        return Math.sqrt(tempX + tempY);
    }
    public void toArray(double array[]) {
        array[0] = getMangitude();
        array[1] = getAngle();
    }

    public void toArrayComponets(double array[]) {
        array[0] = x;
        array[1] = y;
    }

}
