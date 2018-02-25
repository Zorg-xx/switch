/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import modele.Rond;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Path;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;
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

       
       /*
       
       bouton=new Button();
       bouton.setId("bouton1");
       bouton.setLayoutX(250);
       bouton.setLayoutY(250);
       bouton.setText("Vers vue2");
       //bouton.setOnAction( e->{ Vue2 v=new Vue2(ps);});
       
       */
       
      Image image = new Image("file:test/cw.png");  
      
      ImageView imagev = new ImageView(image); 
      
      imagev.setX(90); 
      imagev.setY(25); 
      
      imagev.setImage(image);
      imagev.setFitWidth(300);
      imagev.setPreserveRatio(true);
      imagev.setSmooth(true);
      imagev.setCache(true);
      
      
      Rond r11=new Rond(200.0,63.0,26,9,90,75);
      Rond r12=new Rond(299.0,63.0,26,9,90,75);
       
       
       
       Polygon polygon = new Polygon();
       polygon.getPoints().addAll(new Double[]{
        225.0, 225.0,
        265.0, 250.0,
        225.0, 275.0 });
       polygon.setFill(Color.WHITE);
       polygon.setId("start");
       
       Circle circle=new Circle();
       circle.setCenterX(235.0);
       circle.setCenterY(250.0);
       circle.setRadius(50.0);
       circle.setFill(Color.BLACK);
       circle.setId("start");
       
       
       Rond r1=new Rond(235.0,250.0,60,9,90,83);
       Rond r2=new Rond(235.0,250.0,70,9,90,83);
       Rond r3=new Rond(235.0,250.0,80,9,90,84);
       
       ControleurChangeVue ccv=new ControleurChangeVue(ps);
       //bouton.addEventHandler(MouseEvent.MOUSE_CLICKED, ccv);
       polygon.addEventHandler(MouseEvent.MOUSE_CLICKED, ccv);
       circle.addEventHandler(MouseEvent.MOUSE_CLICKED, ccv);
      

       //group.getChildren().add(bouton);
       
       group.getChildren().add(imagev);
       
        ArrayList liste11 = r11.getListeArc();
        for(Object a: liste11){
            r11.tourne((Arc)a,-360,10);
            group.getChildren().add((Arc)a);
        }
        
        ArrayList liste12 = r12.getListeArc();
        for(Object a: liste12){
            r12.tourne((Arc)a,360,10);
            group.getChildren().add((Arc)a);
        }
       
       
       
       group.getChildren().add(circle);
       group.getChildren().add(polygon);
       
       ArrayList liste1 = r1.getListeArc();
        for(Object a: liste1){
            r1.tourne((Arc)a,-360,5);
            group.getChildren().add((Arc)a);
        }
        
        ArrayList liste2 = r2.getListeArc();
        for(Object a: liste2){
            r2.tourne((Arc)a,360,6);
            group.getChildren().add((Arc)a);
        }
        
        ArrayList liste3 = r3.getListeArc();
        for(Object a: liste3){
            r3.tourne((Arc)a,-360,7);
            group.getChildren().add((Arc)a);
        }

        

       ps.setScene(scene);
      
    }
}
