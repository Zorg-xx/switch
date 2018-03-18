
package modele;

import java.util.ArrayList;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcBuilder;
import javafx.scene.shape.ArcType;


/* exemple d'utilisation
Rond r=new Rond(250,250,50,10,95,80);
//rond de base
//radius 50
//grosseur trait 10
//angleDepart 95, 185, 275, 365
//longueurArc 80

exemple d'utilisation
r.initRond(obs, root, -360, 8);
obs=liste d'ostacle à remplir
root=layout pour l'affichage
sens rotation 360 ou -360
vitesse rotation plus l'entier est élevé, plus la vitesse est lente
*/

/**
 * Rond permet de construire un cercle en 4 arcs de couleurs différentes.
 * 
 */

public class Rond extends Forme{
    
    private int radius;
    private int grosseurTrait;
    private int angleDepart;
    private int longueurArc;
    private ArrayList<Arc>listeArc;
    
    public Rond(Double _x,Double _y, int _radius,int _grosseurTrait, int _angleDepart, int _longueurArc){
        super(_x,_y);
        radius=_radius;
        grosseurTrait=_grosseurTrait;
        angleDepart=_angleDepart;
        longueurArc=_longueurArc;
        listeArc=new ArrayList<Arc>();
        creerArc(radius,grosseurTrait,VIOLET,angleDepart,longueurArc);
        creerArc(radius,grosseurTrait,JAUNE,angleDepart+90,longueurArc);
        creerArc(radius,grosseurTrait,CYAN,angleDepart+(90*2),longueurArc);
        creerArc(radius,grosseurTrait,ROSE,angleDepart+(90*3),longueurArc);
    }
    /**
     * permet d'initialiser un cercle dans la fenêtre de jeu et de le faire tourner.
     * 
     * @param obs correspond à la liste d'obstacles du jeu. L'arc est inséré directement
     * @param group correspond au layout de la scène pour l'affichage des arcs.
     * La fenêtre étant fixe, toutes les formes ont une position fixe.
     * @param sensRotation renseigne le sens de rotation pour la méthode tourne de Forme.
     * @param vitesseRotation renseigne la vitesse de rotation pour la méthode tourne de Forme.
     */
    
    public void initRond(ArrayList obs ,Group group, int sensRotation, int vitesseRotation){
        //obs.add(listeArc);
        for(Object a: listeArc){
            obs.add(a);
            this.tourne((Arc)a, sensRotation,vitesseRotation);
            group.getChildren().add((Arc)a);
        }
    }
    /**
     * permet de crééer un arc de cercle avec une couleur précise.
     * 
     * @param radius
     * @param grosseurTrait
     * @param couleur
     * @param angleDepart
     * @param longueurArc
     * @return un arc de cercle.
     */
    
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
    
    /**
     * Utile pour le placement des arcs dans la fenêtre de jeu.
     * @return la valeur Double y. 
     */

    @Override
    public Double getY() {
        return this.y;
    }
   

}
