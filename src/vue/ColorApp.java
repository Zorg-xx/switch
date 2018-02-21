package vue;

import static javafx.scene.paint.Color.RED;

import controleur.SceneControleur;
import java.io.File;
import java.net.URL;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;


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
        txt.setLayoutX(175);
        txt.setLayoutY(50);
        txt.setText("Color Switch");
        txt.setTextOrigin(VPos.TOP);
        txt.setFont(Font.font("Comic sans MS",25));
        txt.setFill(Color.RED);

        
        final URL imageURL = getClass().getResource("play.png");  
        final Image imageplay = new Image(imageURL.toExternalForm());
        ImageView imv = new ImageView (imageplay);
	play.setGraphic(imv);
        play.setOnAction(new GoToPlay());
        play.setLayoutX(200);
        play.setLayoutY(200);

        
        final URL imageURL2 = getClass().getResource("quitter.png");  
        final Image imagequitter = new Image(imageURL2.toExternalForm());
        ImageView quit = new ImageView (imagequitter);
	quitter.setGraphic(quit);
        
        quitter.setOnAction(new ExitGame());
        quitter.setLayoutX(200);
        quitter.setLayoutY(300);
        

        this.getChildren().add(txt);
        this.getChildren().add(play);
        //this.getChildren().setAll(play);
        this.getChildren().add(quitter);
        //root.setEffect(ds);
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
