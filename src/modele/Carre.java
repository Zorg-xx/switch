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


public class Carre extends Forme{
    
    int grosseurTrait;
    int largeur;
    ArrayList<Line>listeLigne;
    
    public Carre(double _x,double _y, int _grosseurTrait, int _longueur){
        super(_x,_y);
        grosseurTrait=_grosseurTrait;
        largeur=_longueur;
        double n = largeur/2;
        listeLigne=new ArrayList<Line>();
        creerLigne(grosseurTrait,VIOLET,_x-n,_y+n,_x+n,_y+n);
        creerLigne(grosseurTrait,JAUNE,_x+n,_y+n,_x+n,_y-n);
        creerLigne(grosseurTrait,CYAN,_x+n,_y-n,_x-n,_y-n);
        creerLigne(grosseurTrait,ROSE,_x-n,_y-n,_x-n,_y+n);
    }
    
    public ArrayList getListeLigne(){ 
        return listeLigne;
    }
    
    public void initCarre(ArrayList obs ,Group group, int sensRotation, int vitesseRotation){
        obs.add(listeLigne);
        for(Object a: listeLigne){
            this.tourne((Line)a, sensRotation,vitesseRotation);
            group.getChildren().add((Line)a);
        }
    }
    
    private Line creerLigne(int grosseurTrait,Color couleur, double _departX,double _departY, double _finX, double _finY){
        Line l;
        l = LineBuilder.create()
                .startX(_departX)
                .startY(_departY)
                .endX(_finX)
                .endY(_finY)
                .fill(null)
                .stroke(couleur)
                .strokeWidth(grosseurTrait)
                .strokeLineCap(StrokeLineCap.ROUND)
                .build();
        listeLigne.add(l);
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
