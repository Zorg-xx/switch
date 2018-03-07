
package vue;

import controleur.ControleurChangeVue;
import java.util.ArrayList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import modele.Rond;


public class Vue3 {
    
    private Label labelFin;
    private Group root;
    private Scene scene;
    private ArrayList obs;
    private Group rejouerB;
    
    public Vue3(Stage ps){
        
        obs=new ArrayList();
        root=new Group();
        scene=new Scene(root,ps.getMaxWidth(),ps.getMaxHeight());
        scene.setFill(Color.BLACK);
        
        ps.setScene(scene);
        
        labelFin=new Label("Game over");
        labelFin.setTextFill(Color.WHITE);
        labelFin.setFont(Font.font("ARIAL", 25));
        labelFin.setLayoutX(185.0);
        labelFin.setLayoutY(200.0);

        root.getChildren().add(labelFin);
        
        Rond r1=new Rond(0.0,0.0,60,9,90,83);
        r1.initRond(obs, root, -360, 5);
        
        Rond r2=new Rond(500.0,0.0,60,9,90,83);
        r2.initRond(obs, root, 360, 10);
        
        Rond r3=new Rond(500.0,660.0,60,9,90,83);
        r3.initRond(obs, root, -360, 5);
        
        Rond r4=new Rond(0.0,660.0,60,9,90,83);
        r4.initRond(obs, root, 360, 15);
        

        rejouer();
        
        ControleurChangeVue ccv=new ControleurChangeVue(ps);
        rejouerB.addEventHandler(MouseEvent.MOUSE_CLICKED, ccv);
        
        
    }
    
    private void rejouer(){
        
        rejouerB=new Group();
        Circle pause=new Circle();
        pause.setRadius(40);
        pause.setStroke(Color.GRAY);
        pause.setFill(Color.GRAY);
        pause.setStrokeWidth(3);
        
        Arc arc = new Arc();
        arc.setCenterX(0);
        arc.setCenterY(0);
        arc.setRadiusX(25);
        arc.setRadiusY(25);
        arc.setStartAngle(0);
        arc.setLength(300);
        arc.setType(ArcType.OPEN);
        arc.setStroke(Color.WHITE);
        arc.setFill(null);
        arc.setStrokeWidth(4);
        
        Polygon p=new Polygon();
        p.getPoints().addAll(new Double[]{
            0.0, 0.0,
            15.0, 0.0,
            7.5,7.5
        });
        p.setLayoutX(17);
        p.setStrokeWidth(2);
        p.setFill(Color.WHITE);
        
        
        rejouerB.setLayoutX(250.0);
        rejouerB.setLayoutY(400.0);
        rejouerB.getChildren().add(pause);
        rejouerB.getChildren().add(arc);
        rejouerB.getChildren().add(p);
        rejouerB.setId("rejouer");
        
        root.getChildren().add(rejouerB);
    }
    
}
