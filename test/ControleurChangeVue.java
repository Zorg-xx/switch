/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testvue;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 *
 * @author y
 */
public class ControleurChangeVue implements EventHandler{

    Stage ps;
    
    ControleurChangeVue(Stage _ps){
        ps=_ps;
    }
    
    public void handle(Event event) {
                
        Button b=(Button)event.getSource();
             
        if(b.getId().equalsIgnoreCase("bouton1")){
            Vue2 v=new Vue2(ps);
        }
        
        if(b.getId().equalsIgnoreCase("bouton2")){
            Vue1 v=new Vue1(ps);
        }        
    } 
}
