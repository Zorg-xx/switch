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






import modele.Rond;
import java.util.ArrayList;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import javafx.util.Duration;


/**
 * A sample in which a node rotates around its center over a given time.
 *
 * @related animation/transitions/FadeTransition
 * @related animation/transitions/FillTransition
 * @related animation/transitions/ParallelTransition
 * @related animation/transitions/PathTransition
 * @related animation/transitions/PauseTransition
 * @related animation/transitions/ScaleTransition
 * @related animation/transitions/SequentialTransition
 * @related animation/transitions/StrokeTransition
 * @related animation/transitions/TranslateTransition
 * @see javafx.animation.RotateTransition
 * @see javafx.animation.RotateTransitionBuilder
 * @see javafx.animation.Transition
 */



public class TestBall extends Application {
 
    Double x;
    Double y;

    Double tailleBall;

    private void init(Stage primaryStage) {
        Group root = new Group();
        primaryStage.setResizable(false);
        Scene scene = new Scene(root, 500, 500);
        scene.setFill(Color.BLACK);
        primaryStage.setScene(scene);
        
        x=250.0;
        y=350.0;
        tailleBall=10.0;
        
        final Rond r=new Rond(x,y,50,10,95,80);

        ArrayList liste = r.getListeArc();
        for(Object a: liste){
            r.tourne((Arc)a,-360,5);
            root.getChildren().add((Arc)a);
        }
        
      
        final Circle ball = new Circle(tailleBall, Color.PURPLE);
        ball.relocate(x-tailleBall, y+100);
        root.getChildren().add(ball);
        
        
        EventHandler<MouseEvent> eventHandler;
        eventHandler = new EventHandler<MouseEvent>() { 
            @Override
            public void handle(MouseEvent e) {
                Double saut=35.0;
                ball.setLayoutY(ball.getLayoutY()-saut);
                ArrayList<Shape> liste = r.getListeArc();
                
                for(Shape a: liste){     
                    Shape s = Shape.intersect(ball, a);
                    if(s.getLayoutBounds().getHeight()<=0 || s.getLayoutBounds().getWidth()<=0) {
                        System.out.println("Non");
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
        };

        scene.addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler); 
      
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(20),new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                Double gravite=1.0;
                if(ball.getLayoutY()<=y+tailleBall+100){
                    ball.setLayoutY(ball.getLayoutY()+gravite);
                }
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();      
    }

    @Override public void start(Stage primaryStage) throws Exception {
        init(primaryStage);
        primaryStage.show();
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

