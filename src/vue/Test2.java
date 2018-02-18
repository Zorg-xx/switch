package vue;


import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;

public class Test2 extends Group {
	Scene scn;
	public Test2(Scene scn){
		this.scn=scn;
		Button b = new Button();
		b.setLayoutX(100.0);
		b.setText("toto");
		this.getChildren().add(b);
		scn.setRoot(this);
	}
	
}
