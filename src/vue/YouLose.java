package vue;

import controleur.SceneControleur;
import java.net.URL;
import vue.ColorApp;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class YouLose extends Group{
	private SceneApp scn;

	private SceneControleur scnCtrl;
	
	public YouLose(SceneApp scn){
            System.out.println("test Balle");
            this.scn=scn;
            scnCtrl = new SceneControleur(null,0,scn);
            this.init();
	}
	
	private void init(){
            Button tryAgain = new Button();
	    Button quitter = new Button();
	    
		/*tryAgain.setText("Try again");
		tryAgain.setOnAction(new GoToPlay());*/
            tryAgain.setLayoutX(200);
            tryAgain.setLayoutY(200);
        

		
            final URL imageURL = getClass().getResource("replay.png");  
            final Image imagereplay = new Image(imageURL.toExternalForm());
            ImageView imv = new ImageView (imagereplay);
            tryAgain.setGraphic(imv);
            tryAgain.setOnAction(new GoToPlay());
    
        
        
        
            /*bouton retour au menu qui ne fontionne pas*/
            Button menu = new Button();
            //menu.setText("Menu");
            //menu.setOnAction();
            menu.setLayoutX(200);
            menu.setLayoutY(300);
            final URL imageURL1 = getClass().getResource("menu.png");  
            final Image imagemenu = new Image(imageURL1.toExternalForm());
            ImageView immenu = new ImageView (imagemenu);
            menu.setGraphic(immenu);
            //menu.setOnAction(new ColorApp(scn));
        
        
            final URL imageURL2 = getClass().getResource("quitter.png");  
            final Image imagequitter = new Image(imageURL2.toExternalForm());
            ImageView quit = new ImageView (imagequitter);
            quitter.setGraphic(quit);
            //quitter.setText("Quitter");
            quitter.setOnAction(new ExitGame());
            quitter.setLayoutX(200);
            quitter.setLayoutY(400);
        
        
            Text txt = new Text();
            txt.setLayoutX(175);
            txt.setLayoutY(100);
            txt.setText("You Lose");
            txt.setTextOrigin(VPos.TOP);
            txt.setFont(Font.font("Comic sans MS",25));
            txt.setFill(Color.RED);
            
            this.getChildren().add(tryAgain);
            this.getChildren().add(txt);
            this.getChildren().add(quitter);
            this.getChildren().add(menu);
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
