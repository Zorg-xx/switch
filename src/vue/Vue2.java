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


public class Vue2 {
    
    Group root;
    Scene scene;
    Jeu j;
    Timeline timeline;
       
    public Vue2(Stage ps){
        
        root=new Group();
        scene=new Scene(root,ps.getMaxWidth(),ps.getMaxHeight());
        scene.setFill(Color.BLACK);
       
        j=new Jeu(root);
       
        ps.setScene(scene);
       
        
        ControleurJeu cj=new ControleurJeu(j);
        
        scene.addEventHandler(MouseEvent.MOUSE_CLICKED, cj); 

        timeline = new Timeline(new KeyFrame(Duration.millis(20),cj));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();        
    }
    
    
    
     
}
