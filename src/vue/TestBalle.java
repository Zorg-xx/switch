package vue;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;


/**
 * A sample in which a node rotates around its center over a given time.
 *
 * @related animation/transitions/FadeTransition
 * @related animation/transitions/FillTransition
 * @related animation/transitions/ParallelTransition
 * @related animation/transitions/PathTransition
 * @related animation/transitions/PauseTransition
 * @related animation/transitions/ScaleTransition
 * @related animation/transitions/SequentialTransition
 * @related animation/transitions/StrokeTransition
 * @related animation/transitions/TranslateTransition
 * @see javafx.animation.RotateTransition
 * @see javafx.animation.RotateTransitionBuilder
 * @see javafx.animation.Transition
 */



public class TestBalle extends Group{
 
    Double x;
    Double y;

    Double tailleBall;
    private SceneApp scn;
    
    public TestBalle(SceneApp scn){
    	System.out.println("test Balle");
    	this.scn=scn;
    	init();
    }

    public void init() {
        
        x=250.0;
        y=350.0;
        tailleBall=10.0;
        
        final Circle ball = new Circle(tailleBall, Color.PURPLE);
        ball.relocate(x-tailleBall, y+100);
        
       /* 
        final Rond r=new Rond(x,y,50,10,95,80);

        ArrayList liste = r.getListeArc();
        for(Object a: liste){
            r.tourne((Arc)a,-360,5);
            root.getChildren().add((Arc)a);
        }
        
         //essai carree
        final Carree c = new Carree(x,y-300,10,100);
        ArrayList ll = c.getListeLigne();
        for(Object l: ll){
            c.tourne((Line)l,360,5);
            root.getChildren().add((Line)l);
        }
      
        //essai croix
        final Croix cx = new Croix(x,y-150,10,75,-75);
        ArrayList llx = cx.getListeLigneC();
        for(Object lx: llx){
            cx.tourne((Line)lx,360,5);
            root.getChildren().add((Line)lx);
        }
        

        
        
        EventHandler<MouseEvent> eventHandler;
        eventHandler = new EventHandler<MouseEvent>() { 
            @Override
            public void handle(MouseEvent e) {
                Double saut=35.0;
                ball.setLayoutY(ball.getLayoutY()-saut);
               // ArrayList<Shape> liste = r.getListeArc();
                
                for(Shape a: liste){     
                    Shape s = Shape.intersect(ball, a);
                    if(s.getLayoutBounds().getHeight()<=0 || s.getLayoutBounds().getWidth()<=0) {
                        System.out.println("Non");
                    }
                    else {
                        System.out.println("oui");
                        if((ball.getFill()==a.getStroke())){
                            System.out.println("ok");
                            System.out.println(ball.getFill());
                            System.out.println(a.getStroke());
                        }  
                    }  
                }
            }  
        };

        scene.addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler); 
      
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(20),new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                Double gravite=1.0;
                if(ball.getLayoutY()<=y+tailleBall+100){
                    ball.setLayoutY(ball.getLayoutY()+gravite);
                }
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();    */  
        this.getChildren().add(ball);
        scn.setRoot(this);
    }
}
