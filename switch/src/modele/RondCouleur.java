package modele;

import java.util.ArrayList;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcBuilder;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Polygon;

public class RondCouleur extends Rond{
    
    private int radius;
    private final int EPAIS = radius+2;
    private ArrayList<Polygon> listePoly;
    private ArrayList<Arc>listeArc;
    
    public RondCouleur(Double _x, Double _y, int _radius, int _grosseurTrait, int _angleDepart, int _longueurArc) {
        super(_x, _y, _radius, _grosseurTrait, _angleDepart, _longueurArc);
        
    }
    
    public int getRadius() {
        return radius;
    }

    public ArrayList<Polygon> getListePoly() {
        return listePoly;
    }

    @Override
    public ArrayList<Arc> getListeArc() {
        return listeArc;
    }
    
    public void initRondC (double _x, double _y, Group gp){
        Arc a = creerArc (10,6,ROSE,90,85);
        Arc a1 = creerArc (10,6,CYAN,90,85);
        Arc a2 = creerArc (10,6,JAUNE,90,85);
        Arc a3 = creerArc (10,6,VIOLET,90,85);
        gp.getChildren().addAll(a,a1,a2,a3);
        creerPoly(_x,_y);
        for (Object o : listePoly){
            gp.getChildren().add((Polygon)o);
        }
    }
    
    private void creerPoly(double _x, double _y) {
        Polygon p = new Polygon () ;
        p.getPoints().addAll(new Double[]{
            _x, _y,
            _x+EPAIS, _y,
            _x, _y-EPAIS });
        p.setFill(ROSE);
        listePoly.add(p);
        
        Polygon p1 = new Polygon () ;
        p1.getPoints().addAll(new Double[]{
            _x, _y,
            _x-EPAIS, _y,
            _x, _y-EPAIS });
        p1.setFill(CYAN);    
        listePoly.add(p1);     
        
        Polygon p2 = new Polygon () ;
        p2.getPoints().addAll(new Double[]{
            _x, _y,
            _x-EPAIS, _y,
            _x, _y+EPAIS });
        p2.setFill(JAUNE);
        listePoly.add(p2);
        
        Polygon p3 = new Polygon () ;
        p3.getPoints().addAll(new Double[]{
            _x, _y,
            _x+EPAIS, _y,
            _x, _y+EPAIS });
        p3.setFill(VIOLET);
        listePoly.add(p3);
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