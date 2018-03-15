
package modele;

import java.util.ArrayList;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.LineBuilder;
import javafx.scene.shape.StrokeLineCap;


public class Carre extends Forme{
    
    private int grosseurTrait;
    private int longueur;
    private ArrayList<Line>listeLigne;
    
    public Carre(double _x,double _y, int _grosseurTrait, int _longueur){
        super(_x,_y);
        grosseurTrait=_grosseurTrait;
        longueur=_longueur;
        double n = longueur/2;
        listeLigne=new ArrayList<Line>();
        creerLigne(grosseurTrait,VIOLET,_x-n,_y+n,_x+n,_y+n);
        creerLigne(grosseurTrait,JAUNE,_x+n,_y+n,_x+n,_y-n);
        creerLigne(grosseurTrait,CYAN,_x+n,_y-n,_x-n,_y-n);
        creerLigne(grosseurTrait,ROSE,_x-n,_y-n,_x-n,_y+n);
    }
    
    
    public void initCarre(ArrayList obs ,Group group, int sensRotation, int vitesseRotation){
        //obs.add(listeLigne);
        for(Object a: listeLigne){
            obs.add(a);
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
    public Double getY() {
        return this.y;
    }


}
