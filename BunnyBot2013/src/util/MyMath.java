/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author Ryan
 */
public class MyMath {

    public MyMath() {

    }

    public void vectorAdd(Vector a, Vector b, Vector c) {
        double x = a.getX() + b.getY();
        double y = a.getY() + b.getY();
        c.setComponets(x, y);
    }

    public void vectorSubtract(Vector a, Vector b, Vector c) {
        double x = a.getX() - b.getY();
        double y = a.getY() - b.getY();
        c.setComponets(x, y);
    }

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

}
