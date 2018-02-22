/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.ArrayList;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.LineBuilder;
import javafx.scene.shape.StrokeLineCap;

public class Croix extends Forme{
    
    int grosseurTrait;
    int largeur;
    double decalage;
    ArrayList<Line>listeLigneC;
    
    public Croix(double _x,double _y, int _grosseurTrait, int _largeur, int _decalage){
        super(_x,_y);
        grosseurTrait=_grosseurTrait;
        largeur=_largeur;
        decalage=_decalage;
        listeLigneC=new ArrayList<Line>();
        creerLigneC(grosseurTrait,violet,_x,_y,_x,_y+largeur);
        creerLigneC(grosseurTrait,jaune,_x,_y,_x+largeur,_y);
        creerLigneC(grosseurTrait,vert,_x,_y,_x,_y-largeur);
        creerLigneC(grosseurTrait,rouge,_x,_y,_x-largeur,_y);
    }
    
    public ArrayList getListeLigneC(){ 
        return listeLigneC;
    }
    
    private Line creerLigneC(int grosseurTrait,Color couleur, double _departX,double _departY, double _finX, double _finY){
        Line l = LineBuilder.create()
            .startX(_departX)
            .startY(_departY)
            .endX(_finX)
            .endY(_finY)
            .fill(null)
            .stroke(couleur)
            .strokeWidth(grosseurTrait)
            .strokeLineCap(StrokeLineCap.ROUND)    
            .build();
        listeLigneC.add(l);
        return l;
    }
}