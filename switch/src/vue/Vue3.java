/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcBuilder;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Al
 */
public class Vue3 { //vue quand on a perdu qui affiche le score actuel, le meilleur score, qui propose de rejouer, de quitter ou de revenir au menu
    
    Group group;
    Scene scene;
    
    public Vue3(Stage ps){
        
        group=new Group();
        scene=new Scene(group,ps.getMaxWidth(),ps.getMaxHeight());
        scene.setFill(Color.BLACK);
    
        
        Image image = new Image("file:src/vue/cw.png");  
      
        ImageView imagev = new ImageView(image); 
      
        imagev.setX(90); 
        imagev.setY(25); 
      
        imagev.setImage(image);
        imagev.setFitWidth(300);
        imagev.setPreserveRatio(true);
        imagev.setSmooth(true);
        imagev.setCache(true);
        
        
        Rectangle r = new Rectangle();
        r.setY(250.0);
        r.setWidth(500.0);
        r.setHeight(50.0);
        r.setFill(Color.DIMGREY);
        
        Text text = new Text ();
        text.setText("Score");
        text.setFill(Color.WHITE);
        text.setFont(Font.font("Comic sans MS",40));
        text.setX(175.0);
        text.setY(285.0);
        
        Text score = new Text ();
        score.setText(Integer.toString(25)); //il faut le changer par le score au moment ou le joueur a perdu
        score.setFill(Color.WHITE);
        score.setFont(Font.font("Comic sans MS",30));
        score.setX(210.0);
        score.setY(332.0);
        
        Rectangle r1 = new Rectangle();
        r1.setY(350.0);
        r1.setWidth(500.0);
        r1.setHeight(50.0);
        r1.setFill(Color.DARKGOLDENROD);
        
        Text text1 = new Text ();
        text1.setText("Meilleur Score");
        text1.setFill(Color.WHITE);
        text1.setFont(Font.font("Comic sans MS",40));
        text1.setX(115.0);
        text1.setY(385.0);
        
        Text mscore = new Text ();
        mscore.setText(Integer.toString(25)); //il faut le changer par le meilleur score du joueur
        mscore.setFill(Color.WHITE);
        mscore.setFont(Font.font("Comic sans MS",30));
        mscore.setX(210.0);
        mscore.setY(435.0);
        
        Arc a = ArcBuilder.create()
            .type(ArcType.OPEN)
            .centerX(230.0)
            .centerY(500.0)
            .radiusX(15)
            .radiusY(15)
            .startAngle(50)
            .length(250.0)
            .fill(null)
            .stroke(Color.WHITE)
            .strokeWidth(5)
            .build();
        a.setId("restart");
        
        Polygon t = new Polygon();
        t.getPoints().addAll(new Double[]{
            245.0, 485.0,
            245.0, 495.0,
            235.0, 495.0 });
        t.setFill(Color.WHITE);
        t.setId("restart");
        
        
        
        group.getChildren().addAll(r,r1,text,text1,imagev,score,mscore,a,t);
        
        ps.setScene(scene);
    }
    
}
