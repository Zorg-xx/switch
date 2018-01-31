/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transitionrotate;

import java.util.ArrayList;
import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcBuilder;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Shape;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

/**
 *
 * @author y
 */

/* exemple d'utilisation
Rond r=new Rond(x,y);

ArrayList liste = r.getListeArc();
for(Object a: liste){
    r.tourne((Arc)a);
    root.getChildren().add((Arc)a);
    }
*/
public class Rond extends Arc{
    
    Double x;
    Double y;
    ArrayList<Arc>listeArc;
    
    Rond(Double _x,Double _y){
        
        x=_x;
        y=_y;
        listeArc=new ArrayList<Arc>();
        creerArc1();
        creerArc2();
        creerArc3();
        creerArc4();
    }
    
    public ArrayList getListeArc(){
        return listeArc;
    }
    
    private Arc creerArc1(){
        Arc a = ArcBuilder.create()
            .type(ArcType.OPEN)
            .centerX(x)
            .centerY(y)
            .radiusX(50)
            .radiusY(50)
            .startAngle(95)
            .length(80)
            .fill(null)
            .stroke(Color.RED)
            .strokeWidth(10)
            .build();
        listeArc.add(a);
        return a;
    }
    private Arc creerArc2(){
        Arc b = ArcBuilder.create()
            .type(ArcType.OPEN)
            .centerX(x)
            .centerY(y)
            .radiusX(50)
            .radiusY(50)
            .startAngle(185)
            .length(80)
            .fill(null)
            .stroke(Color.YELLOW)
            .strokeWidth(10)
            .build();
        listeArc.add(b);
        return b;
    }
    private Arc creerArc3(){        
        Arc c = ArcBuilder.create()
            .type(ArcType.OPEN)
            .centerX(x)
            .centerY(y)
            .radiusX(50)
            .radiusY(50)
            .startAngle(275)
            .length(80)
            .fill(null)
            .stroke(Color.GREEN)
            .strokeWidth(10)
            .build();
        listeArc.add(c);
        return c;
    }   
    private Arc creerArc4(){
        Arc d = ArcBuilder.create()
            .type(ArcType.OPEN)
            .centerX(x)
            .centerY(y)
            .radiusX(50)
            .radiusY(50)
            .startAngle(365)
            .length(80)
            .fill(null)
            .stroke(Color.PURPLE)
            .strokeWidth(10)
            .build();
        listeArc.add(d);
        return d;
    }
    public void tourne(Shape p){
        final Rotate rotationTransform = new Rotate(0, x, y);
        p.getTransforms().add(rotationTransform);
        final Timeline rotationAnimation = new Timeline();
        rotationAnimation.getKeyFrames().add(new KeyFrame(Duration.seconds(5)
                ,new KeyValue(rotationTransform.angleProperty()
                ,360
                ,Interpolator.LINEAR)));
        rotationAnimation.setCycleCount(Animation.INDEFINITE);
        rotationAnimation.setAutoReverse(false);
        rotationAnimation.play();
        
    }
}
