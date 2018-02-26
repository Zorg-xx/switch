/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import modele.Balle;
import modele.Carre;
import modele.Croix;
import modele.Rond;
import java.util.ArrayList;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import javafx.util.Duration;


public class Vue2 {
    
    Group root;
    Scene scene;
    
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
    
    Balle ball;
    
    Vue2(Stage ps){
        
        root=new Group();
        scene=new Scene(root,ps.getMaxWidth(),ps.getMaxHeight());
        scene.setFill(Color.BLACK);
       
       
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
        
        ball=new Balle(root,240,600);
        
        final Rond r=new Rond(x,y,90,10,95,84);
        r.initRond(obs, root, -360, 5);
               
        final Rond r1=new Rond(xx,yy,90,10,95,84);  
        r1.initRond(obs, root, 360, 5);       
        
        final Croix c= new Croix(xxx,yyy,10,75);
        c.initCroix(obs, root, 360, 7);
        
        final Croix c2= new Croix(xxxxx,yyyyy,10,75);
        c2.initCroix(obs, root, -360, 7);
        
        final Carre c1= new Carre(xxxx,yyyy,10,100);
        c1.initCarre(obs, root, -360, 5);

                          
        EventHandler<MouseEvent> eventHandler;
      
        eventHandler = new EventHandler<MouseEvent>() { 
            @Override
            public void handle(MouseEvent e) {
                ball.setY(ball.getY()-35);
                verifierCollision();   
            }  
        };
      
        scene.addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler); 

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(20),new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {                
                
                if(ball.getY()<=600){
                    ball.setY(ball.getY()+1);
                }                                
                if(/*primaryStage.getMaxHeight()/2*/700.0/2>ball.getYb()){
                    
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
                Shape s = Shape.intersect(ball.getBalle(),a);
                if(!(s.getLayoutBounds().getHeight()<=0)){ 
                    if((ball.getCouleurBalle()==a.getStroke())){
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
