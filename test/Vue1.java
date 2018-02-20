/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testvue;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 *
 * @author y
 */
public class Vue1 {
    
    Group group;
    Scene scene;
    Button bouton;
    
    Vue1(Stage ps){
        
       group=new Group();
       scene=new Scene(group,ps.getMaxWidth(),ps.getMaxHeight());
       scene.setFill(Color.BLACK);

       bouton=new Button();
       bouton.setId("bouton1");
       bouton.setLayoutX(250);
       bouton.setLayoutY(250);
       bouton.setText("Vers vue2");
       //bouton.setOnAction( e->{ Vue2 v=new Vue2(ps);});
       
       

       
       
       
       ControleurChangeVue ccv=new ControleurChangeVue(ps);
       bouton.addEventHandler(MouseEvent.MOUSE_CLICKED, ccv);
        

       group.getChildren().add(bouton);

       ps.setScene(scene);
      
    }
}
