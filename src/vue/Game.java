package vue;

import java.util.ArrayList;

import controleur.SceneControleur;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.util.Duration;
import modele.Rond;

public class Game extends Group
{

    Double x;
    Double y;

    Double tailleBall;
    private SceneApp scn;
    
    private SceneControleur scnCtrl;
    
    public Game(SceneApp scn){
    	System.out.println("test Balle");
    	this.scn=scn;
    	scnCtrl = new SceneControleur(null);
    	init();
    }
    
    private void init(){
    	 x=250.0;
         y=350.0;
         tailleBall=10.0;
         
         final Circle ball = new Circle(tailleBall, Color.PURPLE);
         ball.relocate(x-tailleBall, y+100);
         
         final Rond r=new Rond(x,y,50,10,95,80);

         ArrayList liste = r.getListeArc();
         for(Object a: liste){
             r.tourne((Arc)a,-360,5);
             this.getChildren().add((Arc)a);
         }
         
         
         EventHandler<MouseEvent> eventHandler;
         eventHandler = new EventHandler<MouseEvent>() { 
             @Override
             public void handle(MouseEvent e) {
                 System.out.println("click");
                 scnCtrl.move(ball, r);
             }  
         };
         scn.addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler); 
         
         
         
         this.getChildren().add(ball);
         scn.setRoot(this);
    }
}
