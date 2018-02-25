/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import ColorSwitchApp.modele.Carre;
import ColorSwitchApp.modele.Croix;
import ColorSwitchApp.modele.Rond;
import java.util.ArrayList;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;

import javafx.stage.Stage;
import javafx.util.Duration;


/**
 *
 * @author y
 */
public class Vue2 {
    
    Group root;
    Scene scene;
    Button bouton;
    
    Double x;
    Double xx;
    
    Double y;
    Double yy;
    
    
    Double xxx;
    Double yyy;
    
    Double xxxx;
    Double yyyy;
    
    Double xxxxx;
    Double yyyyy;
    
    
    ArrayList<ArrayList<Shape>> obs;
    
    Circle ball;
    
    
    Vue2(Stage ps){
        
       root=new Group();
       scene=new Scene(root,ps.getMaxWidth(),ps.getMaxHeight());
       scene.setFill(Color.BLACK);
       
       /*
       bouton=new Button();
       bouton.setId("bouton2");
       bouton.setLayoutX(150);
       bouton.setLayoutY(250);
       bouton.setText("Vers vue1");
       
       ControleurChangeVue ccv=new ControleurChangeVue(ps);
       bouton.addEventHandler(MouseEvent.MOUSE_CLICKED, ccv);
       
       */
       //bouton.setOnAction(e->{Vue1 v=new Vue1(ps);});
       
       //group.getChildren().add(bouton);
       
       ps.setScene(scene);
       
       x=250.0;
        y=50.0;

        xx=250.0;
        yy=400.0;
        
        xxx=175.0;
        yyy=-250.0;
        
        xxxx=250.0;
        yyyy=-550.0;
        
        xxxxx=325.0;
        yyyyy=-250.0;
       
        obs=new ArrayList();
        
        final Rond r=new Rond(x,y,90,10,95,84);
        ArrayList liste = r.getListeArc();
        obs.add(liste);
        for(Object a: liste){
            r.tourne((Arc)a,-360,5);
            root.getChildren().add((Arc)a);
        }
        
        
        final Rond r1=new Rond(xx,yy,90,10,95,84);      
        ArrayList liste1 = r1.getListeArc();
        obs.add(liste1);
        for(Object a: liste1){
            r1.tourne((Arc)a,360,5);
            root.getChildren().add((Arc)a);
        }
        
        final Croix c= new Croix(xxx,yyy,10,75);
        ArrayList liste3=c.getListeLigneC();
        obs.add(liste3);
        for(Object a: liste3){
            c.tourne((Line)a,360,7);
            root.getChildren().add((Line)a);
        }
        
        final Croix c2= new Croix(xxxxx,yyyyy,10,75);
        ArrayList liste333=c2.getListeLigneC();
        obs.add(liste333);
        for(Object a: liste333){
            c2.tourne((Line)a,-360,7);
            root.getChildren().add((Line)a);
        }
        
        final Carre c1= new Carre(xxxx,yyyy,10,100);
        ArrayList liste33=c1.getListeLigne();
        obs.add(liste33);
        for(Object a: liste33){
            c1.tourne((Line)a,-360,5);
            root.getChildren().add((Line)a);
        }
        
        
        
      
        ball = new Circle(10, Color.PURPLE);
        ball.relocate(240, 600);
        root.getChildren().add(ball);
        
         
        EventHandler<MouseEvent> eventHandler;
      
        eventHandler = new EventHandler<MouseEvent>() { 
            @Override
            public void handle(MouseEvent e) {
                ball.setLayoutY(ball.getLayoutY()-35);
                verifierCollision();   
            }  
        };
      
        
        scene.addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler); 

      
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(20),new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                if(ball.getLayoutY()<=600){
                    ball.setLayoutY(ball.getLayoutY()+1);
                }
                
                Bounds b=ball.localToScene(ball.getBoundsInLocal());
                if(/*primaryStage.getMaxHeight()/2*/700.0/2>b.getMinY()){
                    
                   root.setLayoutY(root.getLayoutY()+1);
                }
                verifierCollision();
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        
    }
    
    
    public void verifierCollision(){
        for(ArrayList<Shape> f: obs){      
            for(Shape a: f){     
                Shape s = Shape.intersect(ball, a);
                if(s.getLayoutBounds().getHeight()<=0 || s.getLayoutBounds().getWidth()<=0) {
                    //System.out.println("Non");
                }
                else {
                    if((ball.getFill()==a.getStroke())){
                        System.out.println("ok");
                    }
                    else{
                        System.out.println("boom");
                    }
                }  
            }
        }      
    } 
  
}
