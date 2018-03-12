package modele;

import java.util.Random;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


public class Balle{
    
    private Circle balle;
    private Color couleur;
    
    public Balle(Group group,int _x,int _y){
    
        couleur=Color.PURPLE;
        balle=new Circle(10,couleur);
        balle.relocate(_x, _y);
        
        this.setRandomCouleur();

        
        group.getChildren().add(balle);
    }
    
    public double getY(){
        return balle.getLayoutY();
    }
    
    public void setY( Double y){
        balle.setLayoutY(y);
    }
    public Double getYb(){
        Bounds b=balle.localToScene(balle.getBoundsInLocal());
        return b.getMinY();
    }
    
    public Color getCouleurBalle(){
        return couleur;
    }
    
    public void setRandomCouleur(){
        Random rand=new Random();
        int i=rand.nextInt(4);
        switch(i){
            case(0):
                couleur=Color.PURPLE;
                balle.setFill(Color.PURPLE);
                break;
            case(1):
                couleur=Color.CYAN;
                balle.setFill(Color.CYAN);
                break;
            case(2):
                couleur=Color.DEEPPINK;
                balle.setFill(Color.DEEPPINK);
                break;
            case(3):
                couleur=Color.YELLOW;
                balle.setFill(Color.YELLOW);   
                break;
        }
    }
    
    public void setCouleurBalle(Color c){
        couleur=c;
        balle.setFill(c);
    }
    
    public Circle getBalle(){
        return balle;
    }
    
}
