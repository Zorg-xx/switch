/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author y
 */
public class Vue2 {
    
    Group group;
    Scene scene;
    Button bouton;
    
    Vue2(Stage ps){
        
       group=new Group();
       scene=new Scene(group,ps.getMaxWidth(),ps.getMaxHeight());
       scene.setFill(Color.BLACK);
       
       bouton=new Button();
       bouton.setId("bouton2");
       bouton.setLayoutX(150);
       bouton.setLayoutY(250);
       bouton.setText("Vers vue1");
       
       ControleurChangeVue ccv=new ControleurChangeVue(ps);
       bouton.addEventHandler(MouseEvent.MOUSE_CLICKED, ccv);
       
       //bouton.setOnAction(e->{Vue1 v=new Vue1(ps);});
       
       group.getChildren().add(bouton);
       
       ps.setScene(scene);
        
        
    }
    
}
