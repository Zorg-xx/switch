/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ColorSwitchApp.modele;

import com.sun.javafx.geom.Shape;
import java.util.ArrayList;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.LineBuilder;
import javafx.scene.shape.StrokeLineCap;

public class Croix extends Forme{
    
    int grosseurTrait;
    int largeur;
    double decalage;
    ArrayList<Line>listeLigneC;
    
    public Croix(double _x,double _y, int _grosseurTrait, int _longueur){
        super(_x,_y);
        grosseurTrait=_grosseurTrait;
        largeur=_longueur;
        listeLigneC=new ArrayList<Line>();
        creerLigneC(grosseurTrait,VIOLET,_x,_y,_x,_y+largeur);
        creerLigneC(grosseurTrait,JAUNE,_x,_y,_x+largeur,_y);
        creerLigneC(grosseurTrait,CYAN,_x,_y,_x,_y-largeur);
        creerLigneC(grosseurTrait,ROSE,_x,_y,_x-largeur,_y);
    }
    
    public ArrayList getListeLigneC(){ 
        return listeLigneC;
    }
    
    public void initCroix(ArrayList obs ,Group group, int sensRotation, int vitesseRotation){
        obs.add(listeLigneC);
        for(Object a: listeLigneC){
            this.tourne((Line)a, sensRotation,vitesseRotation);
            group.getChildren().add((Line)a);
        }
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

    @Override
    public Shape impl_configShape() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Double getY() {
        return this.y;
    }
}
