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
    public static void Output(int[] toPrintInput){
        toPrint = toPrintInput;
    }
    public static boolean checkToPrint(int idNum){
        for(int count=0; count<=toPrint.length; count++){
            if(idNum==toPrint[count]){
                return true;
            }
        }/*End of the loop to test if is included in output array.*/
        return false;
    }
    public static void Print(int id, String name, int value){/*Print statement for int*/
        if(checkToPrint(id)){
            if(name!=""&&name!=null){
                System.out.print(name+": "+value);
            }
            else {
                System.out.print(value);
            }
            
        }
    }
    public static void Print(int id, String name, boolean value){/*Print statement for Boolean*/
        if(checkToPrint(id)){
            if(name!=""&&name!=null){
                System.out.print(name+" is "+value);
            }
            else {
                System.out.print(value);
            }
            
        }
    }
    public static void Print(int id, String name, double value){/*Print statement for Double*/
        if(checkToPrint(id)){
            if(name!=""&&name!=null){
                System.out.print(name+": "+value);
            }
            else {
                System.out.print(value);
            }
            
        }
    }
    public static void Println(int id, String name, int value){/*Println statement for int*/
        if(checkToPrint(id)){
            if(name!=""&&name!=null){
                System.out.println(name+": "+value);
            }
            else {
                System.out.println(value);
            }
            
        }
    }
    public static void Println(int id, String name, boolean value){/*Println statement for Boolean*/
        if(checkToPrint(id)){
            if(name!=""&&name!=null){
                System.out.println(name+" is "+value);
            }
            else {
                System.out.println(value);
            }
            
        }
    }
    public static void Println(int id, String name, double value){/*Println statement for Double*/
        if(checkToPrint(id)){
            if(name!=""&&name!=null){
                System.out.println(name+": "+value);
            }
            else {
                System.out.println(value);
            }
            
        }
    }
    public static void Print(int id, int value){/*Print statement for int*/
        if(checkToPrint(id)){
            System.out.print(value);
        }
    }
    public static void Print(int id, boolean value){/*Print statement for Boolean*/
        if(checkToPrint(id)){
            System.out.print(value);
            
        }
    }
    public static void Print(int id, double value){/*Print statement for Double*/
        if(checkToPrint(id)){
            System.out.print(value);
        }
    }
    public static void Println(int id, int value){/*Println statement for int*/
        if(checkToPrint(id)){
            System.out.println(value);
        }
    }
    public static void Println(int id, boolean value){/*Println statement for Boolean*/
        if(checkToPrint(id)){
            System.out.println(value);
        }
    }
    public static void Println(int id, double value){/*Println statement for Double*/
        if(checkToPrint(id)){
            System.out.println(value);
        }
    }
}
