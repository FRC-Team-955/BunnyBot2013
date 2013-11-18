/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 * @author matthew.sundberg
 *
 */
public class Output {

    static int[] toPrint;
    public Output(int[] toPrintInput) {
        toPrint = toPrintInput;
    }

    public static boolean checkToPrint(int idNum) {
        for (int count = 0; count <= toPrint.length - 1; count++) {
            if (idNum == toPrint[count]) {
                return true;
            }
        }/*End of the loop to test if is included in output array.*/

        return false;
    }
    public static void print(int id, String name, int value) {/*Print statement for int*/

        if (checkToPrint(id)) {
            if (name != "") {
                System.out.print(name + ": " + value);
            }
            else {
                System.out.print(value);
            }

        }
    }
    public static void print(int id, String name, boolean value) {/*Print statement for Boolean*/

        if (checkToPrint(id)) {
            if (name != "") {
                System.out.print(name + " is " + value);
            }
            else {
                System.out.print(value);
            }

        }
    }
    public static void print(int id, String name, double value) {/*Print statement for Double*/

        if (checkToPrint(id)) {
            if (name != "") {
                System.out.print(name + ": " + value);
            }
            else {
                System.out.print(value);
            }

        }
    }
    public static void print(int id, String value) {/*Print statement*/

        if (checkToPrint(id)) {
            System.out.print(value);
        }
    }
    public static void println(int id, String name, int value) {/*Println statement for int*/

        if (checkToPrint(id)) {
            if (name != "") {
                System.out.println(name + ": " + value);
            }
            else {
                System.out.println(value);
            }

        }
    }
    public static void println(int id, String name, boolean value) {/*Println statement for Boolean*/

        if (checkToPrint(id)) {
            if (name != "") {
                System.out.println(name + " is " + value);
            }
            else {
                System.out.println(value);
            }

        }
    }
    public static void println(int id, String value) {/*Println statement*/

        if (checkToPrint(id)) {
            System.out.println(value);
        }
    }
    public static void println(int id, String name, double value) {/*Println statement for Double*/

        if (checkToPrint(id)) {
            if (name != "") {
                System.out.println(name + ": " + value);
            }
            else {
                System.out.println(value);
            }

        }
    }
    public static void print(int id, int value) {/*Print statement for int*/

        if (checkToPrint(id)) {
            System.out.print(value);
        }
    }
    public static void print(int id, boolean value) {/*Print statement for Boolean*/

        if (checkToPrint(id)) {
            System.out.print(value);

        }
    }
    public static void print(int id, double value) {/*Print statement for Double*/

        if (checkToPrint(id)) {
            System.out.print(value);
        }
    }
    public static void println(int id, int value) {/*Println statement for int*/

        if (checkToPrint(id)) {
            System.out.println(value);
        }
    }
    public static void println(int id, boolean value) {/*Println statement for Boolean*/

        if (checkToPrint(id)) {
            System.out.println(value);
        }
    }
    public static void println(int id, double value) {/*Println statement for Double*/

        if (checkToPrint(id)) {
            System.out.println(value);
        }
    }

}
