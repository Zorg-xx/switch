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
import javafx.scene.input.MouseEvent;
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
            
            Text txt = new Text();
            txt.setLayoutX(175);
            txt.setLayoutY(100);
            txt.setText("You Lose");
            txt.setTextOrigin(VPos.TOP);
            txt.setFont(Font.font("Comic sans MS",25));
            txt.setFill(Color.RED);
            
            
            /*image pour pouvoir rejouer et son listeneur*/
            final URL imageURL = getClass().getResource("replay.png");  
            final Image imagereplay = new Image(imageURL.toExternalForm());
            ImageView imv = new ImageView (imagereplay);
            imv.setFitHeight(50);
            imv.setFitWidth(50);
            imv.setLayoutX(200);
            imv.setLayoutY(200);
            imv.setOnMouseClicked(new EventHandler<MouseEvent>(){
                public void handle(MouseEvent event) {
                    new Game(scn);
                }
            });
        
        
            /*image retour au menu et son listeneur*/
            final URL imageURL1 = getClass().getResource("menu.png");  
            final Image imagemenu = new Image(imageURL1.toExternalForm());
            ImageView immenu = new ImageView (imagemenu);
            immenu.setFitHeight(50);
            immenu.setFitWidth(50);
            immenu.setLayoutX(200);
            immenu.setLayoutY(300);
            immenu.setOnMouseClicked(new EventHandler<MouseEvent>(){
                public void handle(MouseEvent event) {
                    new ColorApp(scn);
                }
            });
            
            
            
            /*image quitter et son listeneur*/
            final URL imageURL2 = getClass().getResource("quitter.png");  
            final Image imagequitter = new Image(imageURL2.toExternalForm());
            ImageView quit = new ImageView (imagequitter);
            quit.setFitHeight(50);
            quit.setFitWidth(50);
            quit.setLayoutX(200);
            quit.setLayoutY(400);
            quit.setOnMouseClicked(new EventHandler<MouseEvent>(){
                public void handle(MouseEvent event) {
                    scnCtrl.stopApp();
                }
            });
        
            
            this.getChildren().add(quit);
            this.getChildren().add(txt);
            this.getChildren().add(imv);
            this.getChildren().add(immenu);
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
