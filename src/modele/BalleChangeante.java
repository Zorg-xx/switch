
package modele;

 
import java.util.ArrayList;
import javafx.scene.Group;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import static modele.Forme.VIOLET;

public class BalleChangeante extends Forme{
    
    private Circle bouleC;
    private Stop[]listeCouleur;
    private LinearGradient lg;
    

    public BalleChangeante(Double _x, Double _y,String id) {
        
        super(_x, _y);
        listeCouleur=new Stop[]{ new Stop(0,VIOLET), new Stop(1,CYAN), new Stop(2,JAUNE), new Stop(3,ROSE)};
        lg=new LinearGradient(0,0,0,1,true,CycleMethod.NO_CYCLE,listeCouleur);
        bouleC=new Circle(10,lg);
        bouleC.relocate(_x-12, _y);
        bouleC.setId(id);
        
        
    }
    
    public void initBalleC(ArrayList obs ,Group group, int sensRotation, int vitesseRotation){
        
        obs.add(bouleC);
        //this.tourne(bouleC, sensRotation, vitesseRotation);
        group.getChildren().add(bouleC);
    }
        
    @Override
    public Double getY() {
        return this.y; 
    }   
}
