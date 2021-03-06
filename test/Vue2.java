


import ColorSwitchApp.modele.Jeu;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;


public class Vue2 {
    
    Group root;
    Scene scene;
    
    Jeu j;
       
    Vue2(Stage ps){
        
        root=new Group();
        scene=new Scene(root,ps.getMaxWidth(),ps.getMaxHeight());
        scene.setFill(Color.BLACK);
       
        j=new Jeu(root);
       
        ps.setScene(scene);
       
                          
        EventHandler<MouseEvent> eventHandler;
      
        eventHandler = new EventHandler<MouseEvent>() { 
            @Override
            public void handle(MouseEvent e) {
                j.getBalleJ().setY(j.getBalleJ().getY()-35);
                j.verifierCollision();   
            }  
        };
      
        scene.addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler); 

        Timeline timeline;
        timeline = new Timeline(new KeyFrame(Duration.millis(20),new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {                
                
                if(j.getBalleJ().getY()<=600){
                    j.getBalleJ().setY(j.getBalleJ().getY()+1);
                }                                
                if(/*primaryStage.getMaxHeight()/2*/700.0/2>j.getBalleJ().getYb()){
                    root.setLayoutY(root.getLayoutY()+1);
                    if(root.getLayoutY()%250<=0){
                        j.boucleObstacle();
                    }                  
                }
                j.verifierCollision();
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();        
    }
    
    
    
     
}
