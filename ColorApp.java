/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ColorApp;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Background;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import static javafx.scene.paint.Color.RED;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


/**
 *
 * @author Al
 */
public class ColorApp extends Application {
    
    @Override
    public void start(final Stage primaryStage) {
        Button play = new Button();
        play.setText("Jouer");
        play.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                //appel au jeux
            }
        });
        Button quitter = new Button();
        quitter.setText("Quitter");
        quitter.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                primaryStage.hide();
            }
        });
       //placement des boutons
        play.setLayoutX(200);
        play.setLayoutY(200);
        quitter.setLayoutX(200);
        quitter.setLayoutY(300);
        
        //zone de texte
        Text txt = new Text();
        txt.setLayoutX(150);
        txt.setLayoutY(100);
        txt.setText("Color Inifinity");
        txt.setTextOrigin(VPos.TOP);
        txt.setFont(Font.font("Comic sans MS",25));
        txt.setFill(Color.RED);
        
        
        //effets
        DropShadow ds = new DropShadow();
        ds.setRadius(3);
        ds.setOffsetX(3);
        ds.setOffsetY(3);
        ds.setColor(RED);
        
        Group root = new Group();
        Scene scene = new Scene(root,500,500,Color.BLACK);
        root.getChildren().add(txt);
        root.getChildren().add(play);
        root.getChildren().add(quitter);
        //root.setEffect(ds);
        
        primaryStage.setTitle("Bienvenue");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
