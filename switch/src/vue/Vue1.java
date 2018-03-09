package vue;


import modele.Rond;
import controleur.ControleurChangeVue;
import java.util.ArrayList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;


public class Vue1 {
    
    Group group;
    Scene scene;
    
    ArrayList<ArrayList<Shape>> obs;
    
    public Vue1(Stage ps){
        
       group=new Group();
       scene=new Scene(group,ps.getMaxWidth(),ps.getMaxHeight());
       scene.setFill(Color.BLACK);
       
       obs=new ArrayList();

       
       
      Image image = new Image("file:src/vue/cw.png");  
      
      ImageView imagev = new ImageView(image); 
      
      imagev.setX(90); 
      imagev.setY(25); 
      
      imagev.setImage(image);
      imagev.setFitWidth(300);
      imagev.setPreserveRatio(true);
      imagev.setSmooth(true);
      imagev.setCache(true);
      
      
      Rond r11=new Rond(200.0,63.0,26,9,90,75);
      Rond r12=new Rond(299.0,63.0,26,9,90,75);
       
       
       
       Polygon polygon = new Polygon();
       polygon.getPoints().addAll(new Double[]{
        225.0, 225.0,
        265.0, 250.0,
        225.0, 275.0 });
       polygon.setFill(Color.WHITE);
       polygon.setId("start");
       
       Circle circle=new Circle();
       circle.setCenterX(235.0);
       circle.setCenterY(250.0);
       circle.setRadius(50.0);
       circle.setFill(Color.BLACK);
       circle.setId("start");
       
       
       Rond r1=new Rond(235.0,250.0,60,9,90,83);
       Rond r2=new Rond(235.0,250.0,70,9,90,83);
       Rond r3=new Rond(235.0,250.0,80,9,90,84);
       
       ControleurChangeVue ccv=new ControleurChangeVue(ps);
       polygon.addEventHandler(MouseEvent.MOUSE_CLICKED, ccv);
       circle.addEventHandler(MouseEvent.MOUSE_CLICKED, ccv);
      
       
       group.getChildren().add(imagev);
       
        ArrayList liste11 = r11.getListeArc();
        for(Object a: liste11){
            r11.tourne((Arc)a,-360,10);
            group.getChildren().add((Arc)a);
        }
        
        ArrayList liste12 = r12.getListeArc();
        for(Object a: liste12){
            r12.tourne((Arc)a,360,10);
            group.getChildren().add((Arc)a);
        }
       
       
       group.getChildren().add(circle);
       group.getChildren().add(polygon);
       
       ArrayList liste1 = r1.getListeArc();
        for(Object a: liste1){
            r1.tourne((Arc)a,-360,5);
            group.getChildren().add((Arc)a);
        }
        
        ArrayList liste2 = r2.getListeArc();
        for(Object a: liste2){
            r2.tourne((Arc)a,360,7);
            group.getChildren().add((Arc)a);
        }
        
        ArrayList liste3 = r3.getListeArc();
        for(Object a: liste3){
            r3.tourne((Arc)a,-360,9);
            group.getChildren().add((Arc)a);
        }

        
        //essai de faire la forme pour quitter l'appli...probleme d'affichage!!
       Polygon poly = new Polygon();
       poly.getPoints().addAll(new Double[]{
        600.0, 200.0,
        600.0, 240.0,
        610.0, 240.0,
        610.0, 210.0,
        660.0, 210.0,
        660.0, 240.0,
        670.0, 240.0,
        670.0, 200.0 });
       poly.setFill(Color.WHITE);
       
       Polygon fleche = new Polygon();
       fleche.getPoints().addAll(new Double[]{
        630.0, 230.0,
        630.0, 260.0,
        620.0, 260.0,
        635.0, 290.0,
        650.0, 260.0,
        640.0, 260.0,
        640.0, 230.0 });
       fleche.setFill(Color.WHITE);
       fleche.setId("quit");
       poly.setId("quit");
       
       group.getChildren().add(poly);
       group.getChildren().add(fleche);
        
        
       ps.setScene(scene);
      
    }
}