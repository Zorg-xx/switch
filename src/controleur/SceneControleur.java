package controleur;


import java.util.ArrayList;

import javafx.animation.Timeline;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import vue.SceneApp;
import vue.YouLose;

public class SceneControleur {
	private final int SAUT = 35;
	private double limite;
	private Timeline tl;
	private SceneApp scn;
	
	private Stage primaryStage;
	
	public SceneControleur(Stage ps, double limite, SceneApp scn){
		this.primaryStage=ps;
		this.limite= limite;
		this.scn=scn;
	}
	
	
	public void stopApp(){
		System.exit(0);
	}
	
	
	public void move(Shape ball, ArrayList<Shape> other, boolean saut){
		if(saut){
			
			if(ball.getLayoutY()- SAUT<=350){
				
				for(Shape shp : other){
					shp.setLayoutY(shp.getLayoutY()+ ball.getLayoutY()+ SAUT- 350);
					if(shp.getLayoutY()>500){
						shp.setLayoutY(-100.0);
					}
				}
				ball.setLayoutY(350.0);
			}else {
				ball.setLayoutY(ball.getLayoutY()- SAUT);
			}
		} else {
			if(ball.getLayoutY()<=limite){
				ball.setLayoutY(ball.getLayoutY()+1.0);
			}else{
				tl.stop();
				new YouLose(scn);
			}
		}
		
		for(Shape shp : other){
			if(collisionDetect(ball,shp)){
				if(ball.getFill().equals(shp.getStroke())){
					System.out.println("----------------------------");
				} else{
					tl.stop();
					new YouLose(scn);
				}
			}
		}
	}
	
	public void initTimeLine(Timeline tl){
		this.tl=tl;
	}
	

	
	private boolean collisionDetect(Shape ball, Shape other){
		Shape intersect = Shape.intersect(ball, other);
        if (intersect.getBoundsInLocal().getWidth() != -1) {
          return  true;
        } else
        	return false;
	}
	
}
