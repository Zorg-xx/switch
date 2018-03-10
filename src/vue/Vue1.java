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
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;


public class Vue1 extends Effet{
    
    Group group;
    Scene scene;
    
    ArrayList<Shape> obs;
    
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
      
      group.getChildren().add(imagev);
      
       Polygon polygon = new Polygon();
       polygon.getPoints().addAll(new Double[]{
        225.0, 240.0,
        265.0, 265.0,
        225.0, 290.0 });
       polygon.setFill(Color.WHITE);
       polygon.setId("start");
       
   
       Circle circle=new Circle();
       circle.setCenterX(235.0);
       circle.setCenterY(265.0);
       circle.setRadius(50.0);
       circle.setFill(Color.BLACK);
       circle.setId("start");
   
       Rond r1=new Rond(235.0,265.0,60,9,90,83);
       r1.initRond(obs, group, -360, 5);
       Rond r2=new Rond(235.0,265.0,70,9,90,83);
       r2.initRond(obs, group, 360, 7);
       Rond r3=new Rond(235.0,265.0,80,9,90,84);
       r3.initRond(obs, group, -360, 10);
       
       ControleurChangeVue ccv=new ControleurChangeVue(ps);
       polygon.addEventHandler(MouseEvent.MOUSE_CLICKED, ccv);
       circle.addEventHandler(MouseEvent.MOUSE_CLICKED, ccv);
 
       Rond r11=new Rond(200.0,63.0,26,9,90,75);
       r11.initRond(obs, group, -360, 10);
       Rond r12=new Rond(299.0,63.0,26,9,90,75);
       r12.initRond(obs, group, 360, 10);
              
       group.getChildren().add(circle);
       group.getChildren().add(polygon);
         
       ps.setScene(scene);
      
    }
}
