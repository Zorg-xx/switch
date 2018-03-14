package modele;

import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import vue.Vue3;


public class Jeu {
    
    
    private ArrayList<Shape> obs;
    private Balle ball;
    private Group root;
    private Double x;
    private Double y;
    private int score =0;
    
    private Label labelScore;
    
    private Boolean godMode;
    
    public Jeu(Group _root){
        
        x=250.0;
        y=400.0;
        
        root=_root;
        obs=new ArrayList();
         
        
        initObstacle(5);

        
        ball=new Balle(root,240,600);
        
        labelScore=new Label("score : "+score);
        labelScore.setTextFill(Color.WHITE);
        labelScore.setFont(Font.font("ARIAL", 25));

        root.getChildren().add(labelScore);
        
        godMode=false;
       

    }
    
    public Boolean getGodMode(){
        return godMode;
    }
    
    public void setGodMode(Boolean _godMode){
        godMode=_godMode;
    }
    
    public Label getLabelScore(){
        
        return labelScore;
    }
    
    public void setLabelScore(){
        
        labelScore.setLayoutY(labelScore.getLayoutY()-1);
    }
    
    public void setScoreplus1(){
    	score+=1;
    	labelScore.setText("score : "+score);
    	System.out.println("po");
    }
    
    
    public Group getRoot(){
        return root;
    }
    
    public ArrayList getObs(){
        return obs;
    }
    
    public Balle getBalleJ(){
        return ball;
    }
    
    private int sensRotation(){
        
        Random rand=new Random();
        int rotation=rand.nextInt(2);
        if(rotation==0)
            return 360;
        else
            return -360;
    }
    
    public final void boucleObstacle(){
        
        Random rand=new Random();
        int nombre=rand.nextInt(4);
        int sensRotation=sensRotation();
        switch(nombre){
            case 0:     
                Rond r=new Rond(x,y,90,10,95,84);
                r.initRond(obs, root, sensRotation, 5);
                Etoile e=new Etoile(x,y);
                e.initEtoile(obs,root, sensRotation, 5);
            break;

            case 1:
                Carre c= new Carre(x,y,10,100);
                c.initCarre(obs, root, sensRotation, 5);  
                Etoile e1=new Etoile(x,y);
                e1.initEtoile(obs,root, sensRotation, 5);
            break;

            case 2:
                BalleChangeante bc=new BalleChangeante(x,y+125.0,"croix");
                bc.initBalleC(obs, root, 0, 0);

                Croix cr= new Croix(175.0,y,10,75);
                cr.initCroix(obs, root, sensRotation, 7);

                Croix cr2= new Croix(325.0,y,10,75);
                cr2.initCroix(obs, root, -(sensRotation), 7);

                Etoile e2=new Etoile(x,y);
                e2.initEtoile(obs,root, sensRotation, 5);
            break;
            
            
            case 3:
                Carre c1= new Carre(x,y,10,100);
                c1.initCarre(obs, root, -(sensRotation), 7);
                
                Rond r1=new Rond(x,y,90,10,95,84);
                r1.initRond(obs, root, sensRotation, 4);
                
                Etoile e3=new Etoile(x,y);
                e3.initEtoile(obs,root, sensRotation, 5);
            break;   

        }
        this.y=y-275.0;
        if(obs.size()>10){
            obs.remove(0);
        }
        Random rand1=new Random();
        int nombre1=rand1.nextInt(2);
        if(nombre1==0){
            BalleChangeante bc1=new BalleChangeante(x,y-150.0,"changerCouleur");
            bc1.initBalleC(obs, root, 0, 0);
        }
    }
    
  
    
    private void initObstacle(int nbr){
        
        for(int i=0;i<nbr;i++){
            Random rand=new Random();
            int nombre=rand.nextInt(4);
            int sensRotation=sensRotation();
            switch(nombre){
                case 0:     
                    Rond r=new Rond(x,y,90,10,95,84);
                    r.initRond(obs, root,sensRotation, 5);

                    Etoile e=new Etoile(x,y);
                    e.initEtoile(obs,root, sensRotation, 5);
                break;
                
                case 1:
                    Carre c= new Carre(x,y,10,100);
                    c.initCarre(obs, root, sensRotation, 5);  

                    Etoile e1=new Etoile(x,y);
                    e1.initEtoile(obs,root, sensRotation, 5);
                break;
                
                case 2:
                    BalleChangeante bc=new BalleChangeante(x,y+125,"croix");
                    bc.initBalleC(obs, root, sensRotation, sensRotation);

                    Croix cr= new Croix(175.0,y,10,75);
                    cr.initCroix(obs, root, sensRotation, 7);

                    Croix cr2= new Croix(325.0,y,10,75);
                    cr2.initCroix(obs, root, -(sensRotation), 7);

                    Etoile e2=new Etoile(x,y);
                    e2.initEtoile(obs,root, sensRotation, 5);
                break;
                
                case 3:
                    Carre c1= new Carre(x,y,10,100);
                    c1.initCarre(obs, root, -(sensRotation), 7);

                    Rond r1=new Rond(x,y,90,10,95,84);
                    r1.initRond(obs, root, sensRotation, 4);

                    Etoile e3=new Etoile(x,y);
                    e3.initEtoile(obs,root, sensRotation, 5);
                break;  
                
            }
            this.y=y-275.0;
            if(i==2){
                BalleChangeante bc=new BalleChangeante(x,y-150,"changerCouleur");
                bc.initBalleC(obs, root, 0, 0);
            }
        }       
    }
    
    public int verifierCollision(){
        int retour=-1;
        for(Shape a: obs){
            Shape s = Shape.intersect(ball.getBalle(),a);
            if(!(s.getLayoutBounds().getHeight()<=5)){
                if(a.isVisible()){
                    System.out.println("balle "+ball.getCouleurBalle());
                    System.out.println("objet "+a.getStroke());
                    if((ball.getCouleurBalle()==a.getStroke())){
                        retour=0;                     
                    }
                    else if(a.getId()!=null){
                        if(a.getId().equalsIgnoreCase("etoile")){
                            retour=1;
                            a.setVisible(false);
                        }
                        if(a.getId().equalsIgnoreCase("changerCouleur")){
                            retour=2;
                            a.setVisible(false);
                        }    
                        if(a.getId().equalsIgnoreCase("croix")){
                            retour=3;
                            a.setVisible(false);    
                        } 
                    }
                    else{
                        if(!(a instanceof Polygon))
                           retour=4;  
                    }
                }
            }  
        }  
        return retour;
    }
    
    
    public void finDeJeu(Stage s){
        
        try {
            Thread.sleep(450);
        } catch (InterruptedException ex) {
            Logger.getLogger(Jeu.class.getName()).log(Level.SEVERE, null, ex);
        }
        Vue3 v3=new Vue3(s);
    }

}
