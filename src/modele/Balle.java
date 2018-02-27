package ColorSwitchApp.modele;

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
    
    public void setCouleurBalle(Color c){
        balle.setFill(c);
    }
    
    public Circle getBalle(){
        return balle;
    }
    
}
