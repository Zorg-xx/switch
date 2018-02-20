package vue;

import controleur.SceneControleur;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.control.Button;
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
	    
		tryAgain.setText("Try again");
		tryAgain.setOnAction(new GoToPlay());
		tryAgain.setLayoutX(200);
        tryAgain.setLayoutY(200);
        
        quitter.setText("Quitter");
        quitter.setOnAction(new ExitGame());
        quitter.setLayoutX(200);
        quitter.setLayoutY(300);
				
		Text txt = new Text();
        txt.setLayoutX(150);
        txt.setLayoutY(100);
        txt.setText("You Lose");
        txt.setTextOrigin(VPos.TOP);
        txt.setFont(Font.font("Comic sans MS",25));
        txt.setFill(Color.RED);
		
		this.getChildren().add(tryAgain);
		this.getChildren().add(txt);
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
