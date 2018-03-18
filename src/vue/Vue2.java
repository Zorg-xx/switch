package vue;


import modele.Jeu;
import controleur.ControleurJeu;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;
import static vue.Vue1.PLUSBEAU;


/*
*MVC pas trop respecté. A revoir la timeline et la pause.
*
*/


/**
 * création de la Vue2; écran principal du jeu
 */


public class Vue2 extends Effet{
    
    private Group root;
    private Scene scene;
    private Jeu j;
    private Timeline timeline;
    private Group pauseB;
    private Boolean pause;
    private Label labelScore;
    private int vitesse;
       
    public Vue2(Stage ps){
        
        root=new Group();
        scene=new Scene(root,ps.getMaxWidth(),ps.getMaxHeight());
        scene.setFill(Color.BLACK);
        ps.setScene(scene);
             
        j=new Jeu(root);
        
        ControleurJeu cj=new ControleurJeu(j,this,ps);
        scene.addEventHandler(MouseEvent.MOUSE_CLICKED, cj); 
        scene.addEventHandler(KeyEvent.KEY_PRESSED, cj);
        
        
        if(j.getDifficulte().equalsIgnoreCase("facile"))
            vitesse=40;
        else if(j.getDifficulte().equalsIgnoreCase("normale"))
            vitesse=30;
        else
            vitesse=20;

        timeline = new Timeline(new KeyFrame(Duration.millis(vitesse),cj));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
        
        pause=false;
        creerPause();
        pauseB.setVisible(false);
        
        labelScore=new Label("score : 0");
        labelScore.setTextFill(Color.WHITE);
        labelScore.setFont(Font.font("ARIAL", 25));
        root.getChildren().add(labelScore);
        
        if(PLUSBEAU)
            this.effet(root);
        
    }
    
    public Label getLabelScore(){
        
        return labelScore;
    }
    
    public void setLabelScore(){
        
        labelScore.setLayoutY(labelScore.getLayoutY()-1);
    }
    
    public void setScore(int score){
        
    	labelScore.setText("score : "+score);
    	System.out.println("po");
    }
    
    public Boolean getPause(){
        return pause;
    }
    
    public void setPause(Boolean _pause){
        pause=_pause;
    }
    
    public void stop(){
        timeline.stop();
    }
    
    public void pause(){
        timeline.pause();
        pauseB.setVisible(true);
    }
    
    public void resume(){
        timeline.play();
        pauseB.setVisible(false);
    }
    
    public void setPauseB(){
        
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
        
}
