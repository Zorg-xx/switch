package vue;


import modele.Jeu;
import controleur.ControleurJeu;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;


public class Vue2 extends Effet{
    
    private Group root;
    private Scene scene;
    private Jeu j;
    private Timeline timeline;
    //private Group pauseB;
    
       
    public Vue2(Stage ps){
        
        root=new Group();
        scene=new Scene(root,ps.getMaxWidth(),ps.getMaxHeight());
        scene.setFill(Color.BLACK);
       
        j=new Jeu(root);
        
        ps.setScene(scene);
        
        //creerPause();
     
        ControleurJeu cj=new ControleurJeu(j,this,ps);
        
        scene.addEventHandler(MouseEvent.MOUSE_CLICKED, cj); 

        timeline = new Timeline(new KeyFrame(Duration.millis(20),cj));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
        
        this.effet(root);
        
    }
    public void stop(){
        timeline.stop();
    }
    /*
    public void pause(){
        if(timeline.getStatus()==STOPPED){
            timeline.play();
        }
        else{
            timeline.pause();
        }
    }
    public void setPause(){
        
        pauseB.setLayoutY(pauseB.getLayoutY()-1);
    }
    
    private void creerPause(){
        
        pauseB=new Group();
        Circle pause=new Circle();
        pause.setRadius(20);
        pause.setStroke(Color.WHITE);
        pause.setStrokeWidth(3);
        
        Line un=new Line(6,6,6,14);
        un.setStroke(Color.WHITE);
        un.setLayoutX(-12);
        un.setLayoutY(-10);
        un.setStrokeWidth(3);
        Line deux=new Line(6,6,6,14);
        deux.setStroke(Color.WHITE);
        deux.setLayoutY(-10);
        deux.setStrokeWidth(3);
        
        pauseB.setLayoutX(465);
        pauseB.setLayoutY(25);
        pauseB.getChildren().addAll(pause,un,deux);
        pauseB.setId("pause");
        
        root.getChildren().add(pauseB);
        
    }    
        */
}
