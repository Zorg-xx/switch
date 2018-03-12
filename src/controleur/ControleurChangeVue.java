/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



    
package controleur;


import vue.Vue2;
import vue.Vue1;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class ControleurChangeVue implements EventHandler{

    Stage ps;
    
    public ControleurChangeVue(Stage _ps){
        ps=_ps;
    }
    
    public void handle(Event event) {
        
        Object o=event.getSource();
        
        if(o instanceof Circle ){
            if(((Circle) o).getId().equalsIgnoreCase("start")){
                Vue2 v=new Vue2(ps);
            }
            if(((Circle) o).getId().equalsIgnoreCase("restart")){
                Vue2 v=new Vue2(ps);
            }
        }
            
        if(o instanceof Polygon){
            if(((Polygon) o).getId().equalsIgnoreCase("start")){
                Vue2 v=new Vue2(ps);
            }
            if(((Polygon) o).getId().equalsIgnoreCase("quit")){
                System.exit(0);
            }
            if(((Polygon) o).getId().equalsIgnoreCase("restart")){
                Vue2 v=new Vue2(ps);
            }
        }
        
        if (o instanceof Rectangle){
            if(((Rectangle) o).getId().equalsIgnoreCase("quit")){
                System.exit(0);
            }
        }
        
        if (o instanceof Arc){
            if(((Arc) o).getId().equalsIgnoreCase("restart")){
                Vue2 v=new Vue2(ps);
            }
        }
            
        if(o instanceof Button)
            if(((Button) o).getId().equalsIgnoreCase("bouton2")){
                Vue1 v=new Vue1(ps);
            }
        
        /*        
        Button b=(Button)event.getSource();
             
        if(b.getId().equalsIgnoreCase("bouton1")){
            Vue2 v=new Vue2(ps);
        }
        
        if(b.getId().equalsIgnoreCase("bouton2")){
            Vue1 v=new Vue1(ps);
        }   
        */
    } 
}
    

