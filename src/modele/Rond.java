/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.ArrayList;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcBuilder;
import javafx.scene.shape.ArcType;

/**
 *
 * @author y
 */

/* exemple d'utilisation
Rond r=new Rond(250,250,50,10,95,80);

ArrayList liste = r.getListeArc();
for(Object a: liste){
    r.tourne((Arc)a,360,5);
    root.getChildren().add((Arc)a);
    }
*/
//rond de base
//radius 50
//grosseur trait 10
//angleDepart 95, 185, 275, 365
//longueurArc 80
public class Rond extends Forme{
    
    int radius;
    int grosseurTrait;
    int angleDepart;
    int longueurArc;
    ArrayList<Arc>listeArc;
    
    public Rond(Double _x,Double _y, int _radius,int _grosseurTrait, int _angleDepart, int _longueurArc){
        super(_x,_y);
        radius=_radius;
        grosseurTrait=_grosseurTrait;
        angleDepart=_angleDepart;
        longueurArc=_longueurArc;
        listeArc=new ArrayList<Arc>();
        creerArc(radius,grosseurTrait,violet,angleDepart,longueurArc);
        creerArc(radius,grosseurTrait,jaune,angleDepart+90,longueurArc);
        creerArc(radius,grosseurTrait,vert,angleDepart+(90*2),longueurArc);
        creerArc(radius,grosseurTrait,rouge,angleDepart+(90*3),longueurArc);
    }
    
    public ArrayList getListeArc(){
        return listeArc;
    }
    
    private Arc creerArc(int radius,int grosseurTrait,Color couleur,int angleDepart,int longueurArc){
        Arc a = ArcBuilder.create()
            .type(ArcType.OPEN)
            .centerX(x)
            .centerY(y)
            .radiusX(radius)
            .radiusY(radius)
            .startAngle(angleDepart)
            .length(longueurArc)
            .fill(null)
            .stroke(couleur)
            .strokeWidth(grosseurTrait)
            .build();
        listeArc.add(a);
        return a;
    }
}
