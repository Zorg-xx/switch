package controleur;


import vue.Vue2;
import vue.Vue1;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;
import static vue.Vue1.PLUSBEAU;


public class ControleurChangeVue implements EventHandler{

    Stage ps;
    
    private TextField tf;
    private String pseudo;
    /**
     * Constructueur 
     * @param _ps primary stage
     */
    public ControleurChangeVue(Stage _ps){
        ps=_ps;
    }
    
    public void setTf(TextField _tf){
    	this.tf= _tf;
    }
    /**
     * Verifie sur quel boutton on appuie
     * @param event evenement associé
     * 
     * 
     */
    @Override
    public void handle(Event event) {
        
        Object o=event.getSource();
        
        if(o instanceof Circle )
            if(((Circle) o).getId().equalsIgnoreCase("start")){
                Vue2 v=new Vue2(ps);
            }
        if(o instanceof Polygon){
            if(((Polygon) o).getId().equalsIgnoreCase("start")){
                Vue2 v=new Vue2(ps);
            }
            if(((Polygon) o).getId().equalsIgnoreCase("home")){
                Vue1 v=new Vue1(ps);
            }
        }
        if(o instanceof Group)
            if(((Group) o).getId().equalsIgnoreCase("rejouer")){
                Vue2 v=new Vue2(ps);
            }
        if(o instanceof Button){
            if(((Button)o).getId().equalsIgnoreCase("3d")){
                if(PLUSBEAU)
                    PLUSBEAU=false;
                else
                    PLUSBEAU=true;
                Vue1 v=new Vue1(ps);
            }
        }    
    }     
}
