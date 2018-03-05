/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import com.sun.javafx.geom.Shape;
import java.util.ArrayList;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import static javafx.scene.paint.Color.WHITE;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;

/**
 *
 * @author Al
 */

public class Etoile extends Forme{

    private Polygon etoile;
    
    public Etoile(Double _x, Double _y) {
        super(_x, _y);
        etoile = new Polygon();
        etoile.getPoints().addAll(new Double[]{
            13.0, 0.0,
            4.8, 21.4,    
            23.4, 8.4,
            0.4, 8.2,
            19.4, 21.4 });
        etoile.setFill(WHITE);
        etoile.setLayoutX(_x-13);
        etoile.setLayoutY(_y-13);
    }

    public void initEtoile (Group group, int sensRotation, int vitesseRotation){
        //this.tourne(etoile, sensRotation, vitesseRotation);
        group.getChildren().add(etoile);
    }
    
    
    @Override
    public Double getY() {
        return this.y;
    }

    @Override
    public Shape impl_configShape() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
}
