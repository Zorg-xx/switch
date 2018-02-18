package controleur;


import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import modele.Forme;

public class SceneControleur {
	private final int SAUT = 35;
	
	private Stage primaryStage;
	public SceneControleur(Stage ps){
		this.primaryStage=ps;
	}
	
	
	public void stopApp(){
		System.exit(0);
	}
	
	
	public void move(Shape ball, Forme other){
		//clickMove(ball, other);
	}
	
	private void clickMove(Shape ball, Shape other){
		//ball.setLayoutY(ball.getLayoutY()+ SAUT);
		if(collisionDetect(ball,other)){
			System.out.println("boom boom tam tam");
		}
	}
	
	private void naturalMove(Shape ball,Shape other){
		
	}
	
	private boolean collisionDetect(Shape ball, Shape other){
		Shape intersect = Shape.intersect(ball, other);
        if (intersect.getBoundsInLocal().getWidth() != -1) {
          return  true;
        } else
        	return false;
	}
	
}
