package vue;

import javafx.scene.Group;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.shape.Shape;


//Utile? revoir avec du css?

/**
 * 
 * effet à appliquer sur les vues.
 */


public abstract class Effet {
    
    protected void effet(Group group){
        
        final Light.Distant light = new Light.Distant();
        light.setAzimuth(-75.0);
        final Lighting lighting = new Lighting();
        lighting.setLight(light);
        lighting.setSurfaceScale(3.0);
        group.setEffect(lighting);
    }
    
    protected void effet(Shape s){
        
        final Light.Distant light = new Light.Distant();
        light.setAzimuth(-75.0);
        final Lighting lighting = new Lighting();
        lighting.setLight(light);
        lighting.setSurfaceScale(3.0);
        s.setEffect(lighting);
        
    }
            
}