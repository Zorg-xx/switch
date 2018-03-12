
package modele;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

/**
 * Forme permet de fixer le pivot à toutes les formes du jeu
 * ainsi que les couleurs de base.
 * 
 */


public abstract class Forme {
    
    protected final static Color VIOLET=Color.PURPLE;
    protected final static Color JAUNE=Color.YELLOW;
    protected final static Color CYAN=Color.CYAN;
    protected final static Color ROSE=Color.DEEPPINK;
    
    protected Double x;
    protected Double y;
    
    public Forme(Double _x,Double _y){
        x=_x;
        y=_y;
    }
    
    /**
     * @return la valeur Double Y. Utile pour le placement vertical des formes
     * lors du scrolling
     */
    
    public abstract Double getY();
   
    
    /**
     * tourne permet la rotation des formes.
     * 
     * @param p de type Shape est la forme à faire tourner.
     * @param sensRotation détermine le sens de rotation
     * 360 pour un sens horaire et -360 pour un sens anti-horaire
     * @param vitesse détermine la vitesse de rotation. Plus la valeur est grande, 
     * plus c'est lent.
     */
    public void tourne(Shape p, int sensRotation, int vitesse){
        final Rotate rotationTransform = new Rotate(0, x, y);
        p.getTransforms().add(rotationTransform);
        final Timeline rotationAnimation = new Timeline();
        rotationAnimation.getKeyFrames().add(new KeyFrame(Duration.seconds(vitesse)
                ,new KeyValue(rotationTransform.angleProperty()
                ,sensRotation
                ,Interpolator.LINEAR)));
        rotationAnimation.setCycleCount(Animation.INDEFINITE);
        rotationAnimation.setAutoReverse(false);
        rotationAnimation.play();
    }
    
    
}
