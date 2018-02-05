/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.util.ArrayList;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.LineBuilder;

public class Carree extends Forme{
    
    int grosseurTrait;
    int largeur;
    ArrayList<Line>listeLigne;
    
    public Carree(double _x,double _y, int _grosseurTrait, int _largeur){
        super(_x,_y);
        grosseurTrait=_grosseurTrait;
        largeur=_largeur;
        double n = largeur/2;
        listeLigne=new ArrayList<Line>();
        creerLigne(grosseurTrait,violet,_x-n,_y+n,_x+n,_y+n);
        creerLigne(grosseurTrait,jaune,_x+n,_y+n,_x+n,_y-n);
        creerLigne(grosseurTrait,vert,_x+n,_y-n,_x-n,_y-n);
        creerLigne(grosseurTrait,rouge,_x-n,_y-n,_x-n,_y+n);
    }
    
    public ArrayList getListeLigne(){ 
        return listeLigne;
    }
    
    private Line creerLigne(int grosseurTrait,Color couleur, double _departX,double _departY, double _finX, double _finY){
        Line l = LineBuilder.create()
            .startX(_departX)
            .startY(_departY)
            .endX(_finX)
            .endY(_finY)
            .fill(null)
            .stroke(couleur)
            .strokeWidth(grosseurTrait)
            .build();
        listeLigne.add(l);
        return l;
    }
}
