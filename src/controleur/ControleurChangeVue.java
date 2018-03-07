package controleur;


import vue.Vue2;
import vue.Vue1;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;


public class ControleurChangeVue implements EventHandler{

    Stage ps;
    
    public ControleurChangeVue(Stage _ps){
        ps=_ps;
    }
    
    @Override
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
        if(o instanceof Group)
            if(((Group) o).getId().equalsIgnoreCase("rejouer")){
                Vue2 v=new Vue2(ps);
            }

    } 
}
