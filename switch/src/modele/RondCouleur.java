/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import com.sun.javafx.geom.Shape;
import java.util.ArrayList;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcBuilder;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Polygon;

/**
 *
 * @author Al
 */
public class RondCouleur extends Forme{
    
    protected final int RAYON = 10;
    private final int EPAIS = RAYON+3;
    
    public RondCouleur (double _x, double _y){
        super(_x,_y);
    }

    private Arc creerArc (double _x, double _y, int angleDepart, double longueur, Color couleur){
        Arc a = ArcBuilder.create()
            .type(ArcType.OPEN)
            .centerX(_x)
            .centerY(_y)
            .radiusX(RAYON)
            .radiusY(RAYON)
            .startAngle(angleDepart)
            .length(longueur)
            .fill(null)
            .stroke(couleur)
            .strokeWidth(5)
            .build();
        return a;
    }
     
    
    public void initRondC (Group gp, double _x, double _y){
        Arc a = creerArc (_x,_y,0,65.0,ROSE);
        Arc a1 = creerArc (_x,_y,90,65.0,CYAN);
        Arc a2 = creerArc (_x,_y,180,65.0,JAUNE);
        Arc a3 = creerArc (_x,_y,270,65.0,VIOLET);
        
        gp.getChildren().addAll(a,a1,a2,a3);
        creerPoly (gp,_x,_y);
    }
    
    private void creerPoly(Group gp,double _x, double _y) {
        
        Polygon p = new Polygon () ;
        p.getPoints().addAll(new Double[]{
            _x, _y,
            _x+EPAIS, _y,
            _x, _y-EPAIS });
        p.setFill(ROSE);

        Polygon p1 = new Polygon () ;
        p1.getPoints().addAll(new Double[]{
            _x, _y,
            _x-EPAIS, _y,
            _x, _y-EPAIS });
        p1.setFill(CYAN);    
              
        Polygon p2 = new Polygon () ;
        p2.getPoints().addAll(new Double[]{
            _x, _y,
            _x-EPAIS, _y,
            _x, _y+EPAIS });
        p2.setFill(JAUNE);

        Polygon p3 = new Polygon () ;
        p3.getPoints().addAll(new Double[]{
            _x, _y,
            _x+EPAIS, _y,
            _x, _y+EPAIS });
        p3.setFill(VIOLET);
        gp.getChildren().addAll(p,p1,p2,p3);
    }

    @Override
    public Double getY() {
        return this.y;
    }

    @Override
    public Shape impl_configShape() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
