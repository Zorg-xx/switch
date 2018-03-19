
package modele;

import java.util.ArrayList;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.LineBuilder;
import javafx.scene.shape.StrokeLineCap;


/**
 * création d'un carré composé de 4 lignes de couleurs différentes.
 */

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
     /**
     * permet d'initialiser un carré dans la fenêtre de jeu et de le faire tourner.
     * 
     * @param obs correspond à la liste d'obstacles du jeu. La ligne est inséré directement
     * @param group correspond au layout de la scène pour l'affichage des lignes.
     * La fenêtre étant fixe, toutes les formes ont une position fixe.
     * @param sensRotation renseigne le sens de rotation pour la méthode tourne de Forme.
     * @param vitesseRotation renseigne la vitesse de rotation pour la méthode tourne de Forme.
     */
    public void initCarre(ArrayList obs ,Group group, int sensRotation, int vitesseRotation){
        //obs.add(listeLigne);
        for(Object a: listeLigne){
            obs.add(a);
            this.tourne((Line)a, sensRotation,vitesseRotation);
            group.getChildren().add((Line)a);
        }
    }
     /**
     * permet de crééer une ligne avec une couleur précise.
     * 
     * @return une ligne.
     */
    
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
    
     /**
     * Utile pour le placement du carré dans la fenêtre de jeu.
     * @return la valeur Double y. 
     */
    @Override
    public Double getY() {
        return this.y;
    }


}
