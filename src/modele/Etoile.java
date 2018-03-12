
package modele;

import java.util.ArrayList;
import javafx.animation.FadeTransition;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.util.Duration;


public class Etoile extends Forme{
    
    private Polygon polygon;

    public Etoile(Double _x, Double _y) {
        super(_x, _y);
        polygon=new Polygon();
        polygon.getPoints().addAll(new Double[]{
            13.0, 0.0,
            4.8, 21.4,
            23.4, 8.4,  
            0.4, 8.2,
            19.4, 21.4
        });
        polygon.setFill(Color.WHITE);
        polygon.setLayoutX(x-13.0);
        polygon.setLayoutY(y-13.0);
        polygon.setId("etoile");
    }
    
    public void initEtoile(ArrayList obs, Group g, int sensRotation, int vitesse){
        obs.add(polygon);
        //this.tourne(polygon, sensRotation, vitesse);
        g.getChildren().add(polygon);
    }
    

    @Override
    public Double getY() {
        return this.y;
    } 
    
}
