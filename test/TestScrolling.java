/*
 * Copyright (c) 2008, 2012 Oracle and/or its affiliates.
 * All rights reserved. Use is subject to license terms.
 *
 * This file is available and licensed under the following license:
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  - Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *  - Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the distribution.
 *  - Neither the name of Oracle Corporation nor the names of its
 *    contributors may be used to endorse or promote products derived
 *    from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

import ColorSwitchApp.modele.Rond;
import java.util.ArrayList;
import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;





public class TestScrolling extends Application {
 
    Double x;
    Double xx;
    
    Double y;
    Double yy;
    
    ArrayList<ArrayList<Shape>> obs;
    
    Circle ball;

    private void init(final Stage primaryStage) {
        Group root = new Group();
        //primaryStage.setResizable(false);

        
        primaryStage.setMaxHeight(500);
        primaryStage.setMaxWidth(500);
        
        Scene scene = new Scene(root, 500,700);
        scene.setFill(Color.BLACK);
        primaryStage.setScene(scene);
        //primaryStage.setScene(new Scene(root, 500,500,Color.BLACK));
        
        final PerspectiveCamera pc=new PerspectiveCamera();
        //pc.setLayoutY(1250.0);
        scene.setCamera(pc);
        
        
        
        x=250.0;
        y=50.0;

        xx=250.0;
        yy=300.0;
        
       
        obs=new ArrayList();
        
        final Rond r=new Rond(x,y,50,10,95,80);

        ArrayList liste = r.getListeArc();
        obs.add(liste);
        for(Object a: liste){
            r.tourne((Arc)a,-360,5);
            root.getChildren().add((Arc)a);
        }
        
        
        final Rond r1=new Rond(xx,yy,50,10,95,80);
        
        ArrayList liste1 = r1.getListeArc();
        obs.add(liste1);
        for(Object a: liste1){
            r1.tourne((Arc)a,-360,5);
            root.getChildren().add((Arc)a);

        }


        
        ball = new Circle(10, Color.PURPLE);
        ball.relocate(240, 430);
        root.getChildren().add(ball);
        
        

         
        EventHandler<MouseEvent> eventHandler;
      
        eventHandler = new EventHandler<MouseEvent>() { 
            @Override
            public void handle(MouseEvent e) {
                ball.setLayoutY(ball.getLayoutY()-35);
                //ArrayList<Shape> liste = r.getListeArc();
                
                System.out.println(primaryStage.getMaxHeight()/2);
                if(primaryStage.getMaxHeight()/2>ball.getLayoutY()){
                        pc.setLayoutY(pc.getLayoutY()-5);
                    }
             
                //pc.setLayoutY(pc.getLayoutY()-5);
                
                verifierCollision();
                    
            }  
        };
      
        
       scene.addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler); 

      
      Timeline timeline = new Timeline(new KeyFrame(Duration.millis(20),new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                if(ball.getLayoutY()<=450){
                    ball.setLayoutY(ball.getLayoutY()+1);
                    
                    
                    //pc.setLayoutY(pc.getLayoutY()+1);

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
                    System.out.println("oui");
                    if((ball.getFill()==a.getStroke())){
                        System.out.println("ok");
                        System.out.println(ball.getFill());
                        System.out.println(a.getStroke());
                    }  
                }  
            }
        }      
    }
    
    
      
    public void play() {
        
    }

    @Override public void stop() {

    }
    
    @Override public void start(Stage primaryStage) throws Exception {
        init(primaryStage);
        primaryStage.show();
        play();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX 
     * application. main() serves only as fallback in case the 
     * application can not be launched through deployment artifacts,
     * e.g., in IDEs with limited FX support. NetBeans ignores main().
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }


}
