package vue;

import static javafx.scene.paint.Color.RED;

import controleur.SceneControleur;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


/**
 *
 * @author Al
 */
public class ColorApp extends Group {
    private SceneApp scn;
    private Button play = new Button();
    private Button quitter = new Button();
    
    private SceneControleur scnCtrl;
    
    public ColorApp(SceneApp scn){
    	System.out.println("colorApp");
    	this.scn=scn;
    	scnCtrl = new SceneControleur(null,0, scn);
    	this.init();
    }
    
    private void init(){
    	
        //zone de texte
        Text txt = new Text();
        txt.setLayoutX(150);
        txt.setLayoutY(100);
        txt.setText("Color Inifinity");
        txt.setTextOrigin(VPos.TOP);
        txt.setFont(Font.font("Comic sans MS",25));
        txt.setFill(Color.RED);
        
        
        //effets
        DropShadow ds = new DropShadow();
        ds.setRadius(3);
        ds.setOffsetX(3);
        ds.setOffsetY(3);
        ds.setColor(RED);
    	
        this.getChildren().add(txt);
        this.getChildren().add(play);
        this.getChildren().add(quitter);
        //root.setEffect(ds);
    	
        
    	
        play.setText("Jouer");
        play.setOnAction(new GoToPlay());
        //placement des boutons
        play.setLayoutX(200);
        play.setLayoutY(200);
        
        quitter.setText("Quitter");
        quitter.setOnAction(new ExitGame());
        quitter.setLayoutX(200);
        quitter.setLayoutY(300);
        
        scn.setRoot(this);
        

    }
    
    private class ExitGame implements EventHandler<ActionEvent>{
		@Override
		public void handle(ActionEvent event) {
			scnCtrl.stopApp();			
		}
    	
    }
    
    private class GoToPlay implements EventHandler<ActionEvent>{

		@Override
		public void handle(ActionEvent event) {
			// TODO Auto-generated method stub
			new Game(scn);
		}
    	
    }
        
}
