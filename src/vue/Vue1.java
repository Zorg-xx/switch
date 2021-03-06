package vue;


import modele.Rond;
import controleur.ControleurChangeVue;
import java.util.ArrayList;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;


/*
*listener du spinner choixDifficulte à revoir. A mettre dans le controleur?
*
*/

/**
 * La classe Vue1 affiche le menu de départ de l'application.
 * 
 */

public class Vue1 extends Effet{
    
    Group group;
    Scene scene;
    ArrayList<Shape> obs;
    Button bu;
    public static boolean PLUSBEAU=false;
    private Label label;
    private Spinner<String> choixDifficulte;
    public static String DIFFICULTE="normale";
    private TextField pseudo;
    
    public Vue1(Stage ps){
        
        group=new Group();
        scene=new Scene(group,ps.getMaxWidth(),ps.getMaxHeight());
        scene.setFill(Color.BLACK);
        
        ps.setScene(scene);
       
        obs=new ArrayList();
        
        //création du texte+2 cercles qui tournent
        Rond r11=new Rond(200.0,63.0,26,9,90,75);
        r11.initRond(obs, group, -360, 10);
        Rond r12=new Rond(299.0,63.0,26,9,90,75);
        r12.initRond(obs, group, 360, 10);
       
        label=new Label("C   L   R\nSWITCH");
        label.setTextFill(Color.WHITE);
        label.setFont(Font.font("ARIAL", 70));
        label.setLayoutX(110.0);
        label.setLayoutY(20.0);
        label.setTextAlignment(TextAlignment.CENTER);
        
        group.getChildren().add(label);

        //saisie du pseudonyme
        pseudo= new TextField("John Doe");
        pseudo.setPrefWidth(100);
        pseudo.setLayoutX(ps.getMaxWidth()/2-60);
        pseudo.setStyle("-fx-text-inner-color: white;-fx-background-color: grey;-fx-alignment: center ;");
        pseudo.setLayoutY(350);
        System.out.println(pseudo.getPrefWidth());
        //group.getChildren().add(pseudo);
   
        //création du triangle pour simuler la forme d'un bouton start
        Polygon polygon = new Polygon();
        polygon.getPoints().addAll(new Double[]{
            225.0, 240.0,
            265.0, 265.0,
            225.0, 290.0 });
        polygon.setFill(Color.WHITE);
        polygon.setId("start");
       
        //création d'un cercle pour simuler la forme d'un bouton start
        Circle circle=new Circle();
        circle.setCenterX(235.0);
        circle.setCenterY(265.0);
        circle.setRadius(50.0);
        circle.setFill(Color.BLACK);
        circle.setId("start");
        
        group.getChildren().add(circle);
        group.getChildren().add(polygon);
   
        //création des ronds entourant le bouton start
        Rond r1=new Rond(235.0,265.0,60,9,90,83);
        r1.initRond(obs, group, -360, 5);
        Rond r2=new Rond(235.0,265.0,70,9,90,83);
        r2.initRond(obs, group, 360, 7);
        Rond r3=new Rond(235.0,265.0,80,9,90,84);
        r3.initRond(obs, group, -360, 10);
       
        //mise en place du controleur sur le bouton start. changement de vue vers la Vue2
        ControleurChangeVue ccv=new ControleurChangeVue(ps);
        polygon.addEventHandler(MouseEvent.MOUSE_CLICKED, ccv);
        circle.addEventHandler(MouseEvent.MOUSE_CLICKED, ccv);

        //création du bouton pour le changement graphique
        bu=new Button();
        bu.setLayoutX(50);
        bu.setLayoutY(500);
        if(PLUSBEAU)
            bu.setText("effet de base");
        else
            bu.setText("Effet cheapos");
        bu.setId("3D");
        bu.addEventHandler(MouseEvent.MOUSE_CLICKED, ccv);
        bu.setStyle("-fx-text-fill: white;-fx-background-color: grey");
        group.getChildren().add(bu);

        //création du spinner pour le choix de la difficulté
        ObservableList<String> choix = FXCollections.observableArrayList(
            "facile",
            "normale",
            "difficile"
        );
        choixDifficulte=new Spinner<String>();
        choixDifficulte.setStyle("-fx-text-inner-color: white;-fx-control-inner-background: grey;");
        
        SpinnerValueFactory<String> vf = new SpinnerValueFactory.ListSpinnerValueFactory<String>(choix);
        vf.setValue(DIFFICULTE);
        choixDifficulte.setValueFactory(vf);
        choixDifficulte.setLayoutX(250);
        choixDifficulte.setLayoutY(500);
        choixDifficulte.getStyleClass().add(Spinner.STYLE_CLASS_SPLIT_ARROWS_HORIZONTAL);
        choixDifficulte.setEditable(false);
        
        //listener pour valider le choix de la difficulté
        choixDifficulte.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                DIFFICULTE=newValue;
                System.out.println(DIFFICULTE);
            }
        });
        group.getChildren().add(choixDifficulte);
        
        //si bu est actif
        if(PLUSBEAU){
           this.effet(group);
           this.effet(polygon);
        }
    }
}    
        
       
       
    
    
            

