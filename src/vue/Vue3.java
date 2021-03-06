
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
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import modele.MeilleurScore;
import modele.Rond;

import static javafx.scene.paint.Color.WHITE;
import static vue.Vue1.PLUSBEAU;

/**
 * Vue3 affiche le résultat du score avec le score et le meilleur score
 * 
 * 
 */
public class Vue3 extends Effet{
    
    private Label label;
    private Group root;
    private Scene scene;
    private ArrayList obs;
    private Group rejouerB;
    
    private int scoreFinal;
    private MeilleurScore ms;

    public Vue3(Stage ps, int _score){
    	scoreFinal= _score;
    	
    	obs=new ArrayList();
        root=new Group();
        scene=new Scene(root,ps.getMaxWidth(),ps.getMaxHeight());
        scene.setFill(Color.BLACK);
        
        ps.setScene(scene);
        
        Rond r1=new Rond(0.0,0.0,60,9,90,83);
        r1.initRond(obs, root, -360, 5);
        
        Rond r2=new Rond(500.0,0.0,60,9,90,83);
        r2.initRond(obs, root, 360, 10);
        
        Rond r3=new Rond(500.0,660.0,60,9,90,83);
        r3.initRond(obs, root, -360, 5);
        
        Rond r4=new Rond(0.0,660.0,60,9,90,83);
        r4.initRond(obs, root, 360, 15);


        
        Rond r11=new Rond(200.0,63.0,26,9,90,75);
        r11.initRond(obs, root, -360, 10);
        Rond r12=new Rond(299.0,63.0,26,9,90,75);
        r12.initRond(obs, root, 360, 10);
        
        label=new Label("C   L   R\nSWITCH");
        label.setTextFill(Color.WHITE);
        label.setFont(Font.font("ARIAL", 70));
        label.setLayoutX(110.0);
        label.setLayoutY(20.0);
        label.setTextAlignment(TextAlignment.CENTER);
        
        root.getChildren().add(label);
        
        Rectangle r = new Rectangle();
        r.setY(250.0);
        r.setWidth(500.0);
        r.setHeight(50.0);
        r.setFill(Color.DIMGREY);
        
        root.getChildren().add(r);
        
        Text text = new Text ();
        text.setText("Score");
        text.setFill(Color.WHITE);
        text.setFont(Font.font("Arial",40));
        text.setX(175.0);
        text.setY(285.0);
        
        root.getChildren().add(text);
        
        Text score = new Text ();
        score.setText(""+ scoreFinal);
        score.setFill(Color.WHITE);
        score.setFont(Font.font("Arial",30));
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
        text1.setFont(Font.font("Arial",40));
        text1.setX(115.0);
        text1.setY(385.0);
        
        root.getChildren().add(text1);
/*
        //insertion du meilleur score dans la bd
        ms.intiMS();
        int  meilscor = ms.getMeilleurScore();
        ms.majMeilleurScore(scoreFinal);
        //ms.insert(pseudo, meilscor);
         
        
        Text mscore = new Text ();
        mscore.setText(Integer.toString(ms.majMeilleurScore(scoreFinal)));*/

        
        rejouer();
        ControleurChangeVue ccv=new ControleurChangeVue(ps);
        rejouerB.addEventHandler(MouseEvent.MOUSE_CLICKED, ccv);
        
        
        MeilleurScore ms = new MeilleurScore();
        
        Text msc = new Text();
        msc.setText(ms.getMeilleurScore1(scoreFinal)+"");
        //msc.setText(Integer.toString(maxiScore(this.name)));
        msc.setFill(WHITE);
        msc.setX(210);
        msc.setY(430);
        msc.setCache(false);
        msc.setFont(Font.font("Arial",30));
        root.getChildren().add(msc);

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
        
        if(PLUSBEAU)
            this.effet(root);
    	
    }
    
    public Vue3(Stage ps){
        
        obs=new ArrayList();
        root=new Group();
        scene=new Scene(root,ps.getMaxWidth(),ps.getMaxHeight());
        scene.setFill(Color.BLACK);
        
        ps.setScene(scene);
        
        Rond r1=new Rond(0.0,0.0,60,9,90,83);
        r1.initRond(obs, root, -360, 5);
        
        Rond r2=new Rond(500.0,0.0,60,9,90,83);
        r2.initRond(obs, root, 360, 10);
        
        Rond r3=new Rond(500.0,660.0,60,9,90,83);
        r3.initRond(obs, root, -360, 5);
        
        Rond r4=new Rond(0.0,660.0,60,9,90,83);
        r4.initRond(obs, root, 360, 15);


        
        Rond r11=new Rond(200.0,63.0,26,9,90,75);
        r11.initRond(obs, root, -360, 10);
        Rond r12=new Rond(299.0,63.0,26,9,90,75);
        r12.initRond(obs, root, 360, 10);
        
        label=new Label("C   L   R\nSWITCH");
        label.setTextFill(Color.WHITE);
        label.setFont(Font.font("ARIAL", 70));
        label.setLayoutX(110.0);
        label.setLayoutY(20.0);
        label.setTextAlignment(TextAlignment.CENTER);
        
        root.getChildren().add(label);
        
        Rectangle r = new Rectangle();
        r.setY(250.0);
        r.setWidth(500.0);
        r.setHeight(50.0);
        r.setFill(Color.DIMGREY);
        
        root.getChildren().add(r);
        
        Text text = new Text ();
        text.setText("Score");
        text.setFill(Color.WHITE);
        text.setFont(Font.font("Arial",40));
        text.setX(175.0);
        text.setY(285.0);
        
        root.getChildren().add(text);
        
        Text score = new Text ();
        score.setText(scoreFinal+"");
        score.setFill(Color.WHITE);
        score.setFont(Font.font("Arial",30));
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
        text1.setFont(Font.font("Arial",40));
        text1.setX(115.0);
        text1.setY(385.0);
        
        root.getChildren().add(text1);
/*
        //insertion du meilleur score dans la bd
        ms.intiMS();
        int  meilscor = ms.getMeilleurScore();
        ms.majMeilleurScore(scoreFinal);
        //ms.insert(pseudo, meilscor);
         
        
        Text mscore = new Text ();
        mscore.setText(Integer.toString(ms.majMeilleurScore(scoreFinal)));*/
        Text mscore = new Text ();
        mscore.setFill(Color.WHITE);
        mscore.setFont(Font.font("Arial",30));
        mscore.setX(115.0);
        mscore.setY(500.0);
        
        root.getChildren().add(mscore);
        
        rejouer();
        ControleurChangeVue ccv=new ControleurChangeVue(ps);
        rejouerB.addEventHandler(MouseEvent.MOUSE_CLICKED, ccv);
        

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
        
        if(PLUSBEAU)
            this.effet(root);
    }
    
    public void setScoreFinal(int score){
    	scoreFinal=score;
    	System.out.println("score set");
    }
    /**
     * 
     * création du bouton rejouer
     */
    
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
