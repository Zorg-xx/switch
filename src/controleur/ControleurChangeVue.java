package controleur;


import vue.Vue2;
import vue.Vue1;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;


public class ControleurChangeVue implements EventHandler{

    Stage ps;
    
    public ControleurChangeVue(Stage _ps){
        ps=_ps;
    }
    
    public void handle(Event event) {
        
        Object o=event.getSource();
        
        if(o instanceof Circle )
            if(((Circle) o).getId().equalsIgnoreCase("start")){
                Vue2 v=new Vue2(ps);
            }
        if(o instanceof Polygon)
            if(((Polygon) o).getId().equalsIgnoreCase("start")){
                Vue2 v=new Vue2(ps);
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
