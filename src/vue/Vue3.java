
package vue;

import controleur.ControleurChangeVue;
import java.util.ArrayList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import modele.Rond;
import static vue.Vue1.PLUSBEAU;


public class Vue3 extends Effet{
    
    private Label labelFin;
    private Group root;
    private Scene scene;
    private ArrayList obs;
    private Group rejouerB;
    private Button bu;
    
    public Vue3(Stage ps){
        
        obs=new ArrayList();
        root=new Group();
        scene=new Scene(root,ps.getMaxWidth(),ps.getMaxHeight());
        scene.setFill(Color.BLACK);
        
        ps.setScene(scene);
        
        /*labelFin=new Label("Game over");
        labelFin.setTextFill(Color.WHITE);
        labelFin.setFont(Font.font("ARIAL", 25));
        labelFin.setLayoutX(185.0);
        labelFin.setLayoutY(200.0);

        root.getChildren().add(labelFin);*/
        
        Rond r1=new Rond(0.0,0.0,60,9,90,83);
        r1.initRond(obs, root, -360, 5);
        
        Rond r2=new Rond(500.0,0.0,60,9,90,83);
        r2.initRond(obs, root, 360, 10);
        
        Rond r3=new Rond(500.0,660.0,60,9,90,83);
        r3.initRond(obs, root, -360, 5);
        
        Rond r4=new Rond(0.0,660.0,60,9,90,83);
        r4.initRond(obs, root, 360, 15);
        
        
        rejouer();
        
        Image image = new Image("file:src/vue/cw.png");  
        ImageView imagev = new ImageView(image); 
        imagev.setX(90); 
        imagev.setY(75);     
        imagev.setImage(image);
        imagev.setFitWidth(300);
        imagev.setPreserveRatio(true);
        imagev.setSmooth(true);
        imagev.setCache(true);
        
        root.getChildren().add(imagev);
        
        Rectangle r = new Rectangle();
        r.setY(250.0);
        r.setWidth(500.0);
        r.setHeight(50.0);
        r.setFill(Color.DIMGREY);
        
        root.getChildren().add(r);
        
        Text text = new Text ();
        text.setText("Score");
        text.setFill(Color.WHITE);
        text.setFont(Font.font("Comic sans MS",40));
        text.setX(175.0);
        text.setY(285.0);
        
        root.getChildren().add(text);
        
        Text score = new Text ();
        score.setText(Integer.toString(25)); //il faut le changer par le score au moment ou le joueur a perdu
        score.setFill(Color.WHITE);
        score.setFont(Font.font("Comic sans MS",30));
        score.setX(210.0);
        score.setY(332.0);
        
        root.getChildren().add(score);
        
        Rectangle rec = new Rectangle();
        rec.setY(350.0);
        rec.setWidth(500.0);
        rec.setHeight(50.0);
        rec.setFill(Color.DARKGOLDENROD);
        
        root.getChildren().add(rec);
        
        Text text1 = new Text ();
        text1.setText("Meilleur Score");
        text1.setFill(Color.WHITE);
        text1.setFont(Font.font("Comic sans MS",40));
        text1.setX(115.0);
        text1.setY(385.0);
        
        root.getChildren().add(text1);
        
        Text mscore = new Text ();
        mscore.setText(Integer.toString(25)); //il faut le changer par le meilleur score du joueur
        mscore.setFill(Color.WHITE);
        mscore.setFont(Font.font("Comic sans MS",30));
        mscore.setX(210.0);
        mscore.setY(435.0);
        
        root.getChildren().add(mscore);
        
        ControleurChangeVue ccv=new ControleurChangeVue(ps);
        rejouerB.addEventHandler(MouseEvent.MOUSE_CLICKED, ccv);
        
        if(PLUSBEAU)
            this.effet(root);
        
        
        /*Rectangle rectangle = new Rectangle ();
        rectangle.setX(50);
        rectangle.setY(450);
        rectangle.setWidth(90);
        rectangle.setHeight(80);
        rectangle.addEventHandler(MouseEvent.MOUSE_CLICKED, ccv);*/
        
        Polygon home = new Polygon();
        home.getPoints().addAll(new Double[]{
            90.0,  450.0,
            100.0, 460.0,
            100.0, 450.0,
            110.0, 450.0,
            110.0, 470.0,
            130.0, 490.0,
            120.0, 490.0,
            120.0, 530.0,
            100.0, 530.0,
            100.0, 500.0,
            80.0,  500.0,
            80.0,  530.0,
            60.0,  530.0,
            60.0,  490.0,
            50.0,  490.0
        });
        home.setFill(Color.WHITE);
        home.setId("home");
        home.addEventHandler(MouseEvent.MOUSE_CLICKED, ccv);
        root.getChildren().add(home);
        
        /*bu=new Button();
        bu.setLayoutX(50);
        bu.setLayoutY(500);
        bu.setText("retour vue1");
        bu.setId("retourVue1");*/
        bu.addEventHandler(MouseEvent.MOUSE_CLICKED, ccv);
       
        root.getChildren().add(bu);
        
        
        
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
        
        
        rejouerB.setLayoutX(235.0);
        rejouerB.setLayoutY(500.0);
        rejouerB.getChildren().add(pause);
        rejouerB.getChildren().add(arc);
        rejouerB.getChildren().add(p);
        rejouerB.setId("rejouer");
        
        root.getChildren().add(rejouerB);
        
        if(PLUSBEAU)
            this.effet(root);
    }
    
    
}
