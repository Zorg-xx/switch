/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author Al
 */

public class Etoile {
    
    private ImageView etoile;
    private boolean visible;

    public Etoile (){
        Image image = new Image("file:src/modele/etoile.png");  
        etoile = new ImageView(image); 
        visible = true;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
    
    public ImageView getEtoile() {
        return etoile;
    }
    
    public void afficherEtoile (double _x, double _y, Group gp){
        etoile.setVisible(visible);
        etoile.setPreserveRatio(true);
        etoile.toBack();
        etoile.setFitHeight(26.0);
        etoile.setFitWidth(26.0);
        etoile.setX(_x);
        etoile.setY(_y); 
        gp.getChildren().add(etoile);
    }    
    
    
    
}
