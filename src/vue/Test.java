package vue;


import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;

public class Test extends Group {
	Scene scn;
	public Test(Scene scn){
		this.scn=scn;
		Button b = new Button();
		b.setLayoutX(50.0);
		b.setText("ko");
		this.getChildren().add(new Button("ok"));
		this.getChildren().add(b);
		scn.setRoot(this);
	}
	
}
