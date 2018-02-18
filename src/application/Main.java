package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import vue.ColorApp;
import vue.SceneApp;
import vue.Test;
import vue.Test2;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("ColorApp");
		SceneApp scene = new SceneApp(new Group(), 500, 500);
		primaryStage.setScene(scene);
		primaryStage.show();
		ColorApp mainframe= new ColorApp(scene);

	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
