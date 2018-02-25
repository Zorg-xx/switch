/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 *
 * @author y
 */
public class Forme {
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
    //360 rotation horaire, -360 rotation anti-horaire
    //vitesse 5
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
