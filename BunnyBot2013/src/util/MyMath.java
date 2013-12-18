/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 * @author Pedro Custom math functions: round and power.
 */
public class MyMath {

    /**
     * returns num rounded to x digits.
     *
     * @param num
     * @param digits
     * @return
     */
    public static double round(double num, int digits) {
        double scalar = power(10, digits);
        num *= scalar;
        double dec = num - Math.floor(num);
        num = Math.floor(num);

        if (dec >= .5) {
            num++;
        }

        num /= scalar;
        return num;
    }

    /**
     * Returns a to the power of b.
     *
     * @param a
     * @param b
     * @return
     */
    public static double power(double a, double b) {
        double temp = a;

        for (int i = 1; i < b; i++) {
            a *= temp;
        }

        if (b == 0) {
            return 1;
        }

        return a;
    }

    /**
     * Rounds the double to the hundreth's place, ex. 12.345 -> 12.35.
     * @param value Value to be rounded
     * @return 
     */
    public static double round(double value) {
        return Math.floor(value * 100 + 0.5) / 100;
    }
}
