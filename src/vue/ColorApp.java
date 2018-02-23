package vue;


import controleur.SceneControleur;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Arc;
import modele.Rond;


/**
 *
 * @author Al
 */
public class ColorApp extends Group {
    private SceneApp scn;
    
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

        //image pour lancer le jeu et son listeneur
        final URL imageURL = getClass().getResource("play.png");  
        final Image imageplay = new Image(imageURL.toExternalForm());
        ImageView imv = new ImageView (imageplay);
        imv.setFitHeight(50);
        imv.setFitWidth(50);
        imv.setLayoutX(200);
        imv.setLayoutY(200);
        imv.setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent event) {
                new Game(scn);
            }
        });

        //image pour quitter le jeu et son listeneur
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
        

        //premier cercle qui tourne autour de l'image pour lancer le jeu
        final Rond rond1 = new Rond(225.0,225.0,30,5,0,90);
        ArrayList liste = rond1.getListeArc();
        for(Object a: liste){
            rond1.tourne((Arc)a,-360,4);
            this.getChildren().add((Arc)a);
        }
        
        //deuxieme cercle qui tourne autour de l'image pour lancer le jeu
        final Rond rond2 = new Rond(225.0,225.0,40,10,0,90);
        ArrayList liste1 = rond2.getListeArc();
        for(Object a: liste1){
            rond2.tourne((Arc)a,360,5);
            this.getChildren().add((Arc)a);
        }
        
        //troisieme cercle qui tourne autour de l'image pour lancer le jeu
        final Rond rond3 = new Rond(225.0,225.0,55,15,0,90);
        ArrayList liste2 = rond3.getListeArc();
        for(Object a: liste2){
            rond3.tourne((Arc)a,-360,3);
            this.getChildren().add((Arc)a);
        }
        
        
        this.getChildren().add(txt);
        this.getChildren().add(imv);
        this.getChildren().add(quit);
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
