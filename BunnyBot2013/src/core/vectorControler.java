/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package core;
/**
 *
 * @author Ryan
 */
public class vectorControler {
   public vectorControler(){
        
    }
           public void add(Vector a, Vector b, Vector c){
               double x = a.getX() + b.getY();
               double y = a.getY() + b.getY();
               c.setComponets(x, y);
           }
           
            public void subtratic(Vector a, Vector b, Vector c){
               double x = a.getX() - b.getY();
               double y = a.getY() - b.getY();
               c.setComponets(x, y);
           }
            
            
            
}
