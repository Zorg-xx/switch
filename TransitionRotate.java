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
package transitionrotate;




import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.RotateTransitionBuilder;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import static javafx.scene.paint.Color.color;
import static javafx.scene.paint.Color.color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcTo;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurveTo;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;
import javafx.util.Duration;
import static javafx.util.Duration.INDEFINITE;

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



public class TransitionRotate extends Application {

    private RotateTransition rotateTransition;
    private RotateTransition rotateTransitionb;
    private RotateTransition rotateTransitionc;
    private RotateTransition rotateTransitiond;
    
    private RotateTransition rotateTransitionl;
    private RotateTransition rotateTransitionlb;
    private RotateTransition rotateTransitionlc;
    private RotateTransition rotateTransitionld;

    private void init(Stage primaryStage) {
        Group root = new Group();
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root, 500,500,Color.BLACK));
        
        /*
        Rectangle rect = new Rectangle(20, 20, 100, 100);
        rect.setArcHeight(20);
        rect.setArcWidth(20);
        rect.setFill(Color.ORANGE);
        root.getChildren().add(rect);
        */
        
        /*
        //Creating an object of the class Path  
        Path path = new Path(); 
        path.setStroke(Color.BLUE);
        path.setStrokeWidth(20);
        //Moving to the starting point 
        MoveTo move = new MoveTo(); 
        move.setX(250);//250.0); 
        move.setY(110);//110.0); 
        //Instantiating the arcTo class 
        ArcTo arc = new ArcTo(); 
        //setting properties of the path element arc  
        arc.setX(250.0); 
        arc.setY(350.0); 
        arc.setRadiusX(10.0); 
        arc.setRadiusY(10.0); 
        //Adding the path elements to Observable list of the Path class 
        path.getElements().add(move); 
        path.getElements().add(arc); 
        
        */
        Double x=250.0;
        Double y=450.0;

        
        Arc arc = new Arc();
        arc.setStroke(Color.BLUE);
        arc.setStrokeWidth(10);
        arc.setCenterX(x); 
        arc.setCenterY(y); 
        arc.setRadiusX(50.0f); 
        arc.setRadiusY(50.0f); 
        arc.setStartAngle(0.0f); 
        arc.setLength(90.0f); 
        arc.setType(ArcType.OPEN);
        arc.setFill(Color.BLACK);
        
        movePivot(arc, -25, 25);
        
        Arc arc1 = new Arc();
        arc1.setStroke(Color.YELLOW);
        arc1.setStrokeWidth(10);
        arc1.setCenterX(x); 
        arc1.setCenterY(y); 
        arc1.setRadiusX(50.0f); 
        arc1.setRadiusY(50.0f); 
        arc1.setStartAngle(90.0f); 
        arc1.setLength(90.0f); 
        arc1.setType(ArcType.OPEN);
        arc1.setFill(Color.BLACK);
        
        movePivot(arc1, 25, 25);
        
        Arc arc2 = new Arc();
        arc2.setStroke(Color.RED);
        arc2.setStrokeWidth(10);
        arc2.setCenterX(x); 
        arc2.setCenterY(y); 
        arc2.setRadiusX(50.0f); 
        arc2.setRadiusY(50.0f); 
        arc2.setStartAngle(180.0f); 
        arc2.setLength(90.0f); 
        arc2.setType(ArcType.OPEN);
        arc2.setFill(Color.BLACK);
        
        movePivot(arc2, 25, -25);
        
        Arc arc3 = new Arc();
        arc3.setStroke(Color.GREEN);
        arc3.setStrokeWidth(10);
        arc3.setCenterX(x); 
        arc3.setCenterY(y); 
        arc3.setRadiusX(50.0f); 
        arc3.setRadiusY(50.0f); 
        arc3.setStartAngle(270.0f); 
        arc3.setLength(90.0f); 
        arc3.setType(ArcType.OPEN);
        arc3.setFill(Color.BLACK);
        
        movePivot(arc3, -25, -25);

        
        root.getChildren().add(arc);
        root.getChildren().add(arc1);
        root.getChildren().add(arc2);
        root.getChildren().add(arc3);

        
        /*
        Path path1 =new Path();
        path1.setStroke(Color.BLUE);
        path1.setStrokeWidth(10);
        MoveTo move1=new MoveTo();
        move1.setX(x);
        move1.setY(y);
        ArcTo arc1=new ArcTo();
        arc1.setX(x-50.0);//240.0);
        arc1.setY(y+50.0);//300.0);
        arc1.setRadiusX(50.0);
        arc1.setRadiusY(50.0);
        path1.getElements().add(move1); 
        path1.getElements().add(arc1);
        
        
        Path path2 =new Path();
        path2.setStroke(Color.BLUE);
        path2.setStrokeWidth(10);
        MoveTo move2=new MoveTo();
        move2.setX(x);
        move2.setY(y);
        ArcTo arc2=new ArcTo();
        arc2.setX(x);//290.0);
        arc2.setY(y+100.0);//350.0);
        arc2.setRadiusX(50.0);
        arc2.setRadiusY(50.0);
        path2.getElements().add(move2); 
        path2.getElements().add(arc2);
        
        Path path3 =new Path();
        path3.setStroke(Color.BLUE);
        path3.setStrokeWidth(10);
        MoveTo move3=new MoveTo();
        move3.setX(x);
        move3.setY(y);
        ArcTo arc3=new ArcTo();
        arc3.setX(x+50.0);//340.0);
        arc3.setY(y+50.0);//300.0);
        arc3.setRadiusX(50.0);
        arc3.setRadiusY(50.0);
        path3.getElements().add(move3); 
        path3.getElements().add(arc3);
        
        /*
        path.getElements().add(move); 
        //path.getElements().add(l1); 
        path.getElements().add(arc1);
        path.getElements().add(arc2);
        path.getElements().add(arc3);
        */
        
        /*
        root.getChildren().add(path1);
        root.getChildren().add(path2);
        root.getChildren().add(path3);
        */
        rotateTransition = RotateTransitionBuilder.create()
                .node(arc)
                .duration(Duration.seconds(5))
                .fromAngle(0)
                .toAngle(360)
                .cycleCount(Timeline.INDEFINITE)
                .interpolator(Interpolator.LINEAR)
                .autoReverse(false)
                .build();
        
        rotateTransitionb = RotateTransitionBuilder.create()
                .node(arc1)
                .duration(Duration.seconds(5))
                .fromAngle(0)
                .toAngle(360)
                .cycleCount(Timeline.INDEFINITE)
                .interpolator(Interpolator.LINEAR)
                .autoReverse(false)
                .build();
        
        rotateTransitionc = RotateTransitionBuilder.create()
                .node(arc2)
                .duration(Duration.seconds(5))
                .fromAngle(0)
                .toAngle(360)
                .cycleCount(Timeline.INDEFINITE)
                .interpolator(Interpolator.LINEAR)
                .autoReverse(false)
                .build();
        
        rotateTransitiond = RotateTransitionBuilder.create()
                .node(arc3)
                .duration(Duration.seconds(5))
                .fromAngle(0)
                .toAngle(360)
                .cycleCount(Timeline.INDEFINITE)
                .interpolator(Interpolator.LINEAR)
                .autoReverse(false)
                .build();
     
        
        //essai carrée
        Line l =new Line();
        l.setStartX(200);
        l.setStartY(200);
        l.setEndX(300);
        l.setEndY(200);
        l.setStroke(Color.YELLOW);
        l.setStrokeWidth(10);
        
        Line l1 =new Line();
        l1.setStartX(300);
        l1.setStartY(200);
        l1.setEndX(300);
        l1.setEndY(300);
        l1.setStroke(Color.BLUE);
        l1.setStrokeWidth(10);
        
        Line l2 =new Line();
        l2.setStartX(300);
        l2.setStartY(300);
        l2.setEndX(200);
        l2.setEndY(300);
        l2.setStroke(Color.GREEN);
        l2.setStrokeWidth(10);
        
        Line l3 =new Line();
        l3.setStartX(200);
        l3.setStartY(300);
        l3.setEndX(200);
        l3.setEndY(200);
        l3.setStroke(Color.RED);
        l3.setStrokeWidth(10);
        
        //rotation carrée 
        movePivot(l, 0, 50);
        movePivot(l1, -50, 0);
        movePivot(l2, 0, -50);
        movePivot(l3, 50, 0);
        
        root.getChildren().addAll(l,l1,l2,l3);
        
        rotateTransitionl = RotateTransitionBuilder.create()
                .node(l)
                .duration(Duration.seconds(5))
                .fromAngle(0)
                .toAngle(360)
                .cycleCount(Timeline.INDEFINITE)
                .interpolator(Interpolator.LINEAR)
                .autoReverse(false)
                .build();
        
        rotateTransitionlb = RotateTransitionBuilder.create()
                .node(l1)
                .duration(Duration.seconds(5))
                .fromAngle(0)
                .toAngle(360)
                .cycleCount(Timeline.INDEFINITE)
                .interpolator(Interpolator.LINEAR)
                .autoReverse(false)
                .build();
        
        rotateTransitionlc = RotateTransitionBuilder.create()
                .node(l2)
                .duration(Duration.seconds(5))
                .fromAngle(0)
                .toAngle(360)
                .cycleCount(Timeline.INDEFINITE)
                .interpolator(Interpolator.LINEAR)
                .autoReverse(false)
                .build();
        
        rotateTransitionld = RotateTransitionBuilder.create()
                .node(l3)
                .duration(Duration.seconds(5))
                .fromAngle(0)
                .toAngle(360)
                .cycleCount(Timeline.INDEFINITE)
                .interpolator(Interpolator.LINEAR)
                .autoReverse(false)
                .build();
        
    }
        
    public void play() {
        rotateTransition.play();
        rotateTransitionb.play();
        rotateTransitionc.play();
        rotateTransitiond.play();
        
        rotateTransitionl.play();
        rotateTransitionlb.play();
        rotateTransitionlc.play();
        rotateTransitionld.play();
    }

    @Override public void stop() {
        rotateTransition.stop();
        rotateTransitionb.stop();
        rotateTransitionc.stop();
        rotateTransitiond.stop();
        
        rotateTransitionl.stop();
        rotateTransitionlb.stop();
        rotateTransitionlc.stop();
        rotateTransitionld.stop();
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

    private void movePivot(Node node, int x, int y) {
        node.getTransforms().add(new Translate(-x,-y));
        node.setTranslateX(x);
        node.setTranslateY(y);
    }
    
    private void movePivot(Line l, int x, int y) {
        l.getTransforms().add(new Translate(-x,-y));
        l.setTranslateX(x);
        l.setTranslateY(y);
    }
}

