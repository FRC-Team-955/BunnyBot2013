/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author matthew.sundberg
 * 
 * !!!!!!!!!!!!!!!!!!!!!!! 
 * In var file include the following: 
 * int[] toBePrinted = {1,2,3,4,5,6,7,8};
 * Have the 1 be for Timer, 2 for piston, etc.
 * set the printing to off for it by replacing the #, in the same position, with
 * a 0
 * Ex:
 * the things assigned to 2, 6, and 8 will not print
 * int[] toBePrinted = {1,0,3,4,5,0,7,0};
 * 
 */
public class Print {
    public void Print(int id, String nameOfVar, int value){
        if(id==toBePrinted[id-1]){
        System.out.print(nameOfVar+": "+value);
        }
    }
    public void Print(int id, String nameOfVar, double value, int roundPoint){//TODO fix this so can be blank or round
        if(roundPoint != Null&&roundPoint != 0){
            if(id==toBePrinted[id-1]){
                double roundedValue = 
                System.out.print(nameOfVar+": "+roundedValue);
            }
        }
    }
    public void Print(int id, String nameOfVar, boolean value){
        if(id==toBePrinted[id-1]){
        System.out.print(nameOfVar+" is "+value);
        }
    }
    
    public void Println(int id, String nameOfVar, /*Random input*/ x value){
        if(id==toBePrinted[id-1]){
        System.out.println(nameOfVar+": "+value);
        }
    }
}
