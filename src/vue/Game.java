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
    Double limite;
    private  Double tailleBall ;
    private SceneApp scn;
    boolean start ;
    private SceneControleur scnCtrl;
    
    public Game(SceneApp scn){
    	System.out.println("test Balle");
    	this.scn=scn;
    	init();
    }
    
    private void init(){
    	 x=250.0;
         y=250.0;
         tailleBall=10.0;
         start=false;
         scnCtrl = new SceneControleur(null, y+tailleBall+200, scn);
     	
         final Circle ball = new Circle(tailleBall, Color.PURPLE);
         ball.relocate(x-tailleBall, y+200);
         
         final Rond r=new Rond(x,100.0,100,10,95,85);

         ArrayList liste = r.getListeArc();
         for(Object a: liste){
             r.tourne((Arc)a,-360,5);
             this.getChildren().add((Arc)a);
         }
         
         final Timeline timeline = new Timeline(new KeyFrame(Duration.millis(10),new EventHandler<ActionEvent>() {
             @Override
             public void handle(ActionEvent t) {
                 scnCtrl.move(ball, r.getListeArc(), false);
             }
         }));
         timeline.setCycleCount(Timeline.INDEFINITE);
         
         scnCtrl.initTimeLine(timeline);
         
         EventHandler<MouseEvent> eventHandler;
         eventHandler = new EventHandler<MouseEvent>() { 
             @Override
             public void handle(MouseEvent e) {
                 scnCtrl.move(ball, r.getListeArc(), true);
                 if(!start){
                	 timeline.play();
                	 start = true;
                 }
             }  
         };
         scn.addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler); 

         this.getChildren().add(ball);
         scn.setRoot(this);
    }
}
