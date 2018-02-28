
package ColorSwitchApp.modele;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import javafx.scene.Group;
import javafx.scene.shape.Shape;


public class Jeu {
    
    
    private ArrayList<Forme> obs;
    private Balle ball;
    private Group root;
    private Double x;
    private Double y;
    
    public Jeu(Group _root){
        
        x=250.0;
        y=400.0;
        
        root=_root;
        obs=new ArrayList();
        initObstacle(5);
        
        ball=new Balle(root,240,600);
    }
    
    public ArrayList getObs(){
        return obs;
    }
    
    public Balle getBalleJ(){
        return ball;
    }
    
    public void boucleObstacle(){
        
        Random rand=new Random();
        int nombre=rand.nextInt(3);
        switch(nombre){
            case 0:     
            Rond r=new Rond(x,y,90,10,95,84);
            r.initRond(obs, root, -360, 5);
            break;

            case 1:
            Carre c= new Carre(x,y,10,100);
            c.initCarre(obs, root, -360, 5);    
            break;

            case 2:
            Croix cr= new Croix(175.0,y,10,75);
            cr.initCroix(obs, root, 360, 7);

            Croix cr2= new Croix(325.0,y,10,75);
            cr2.initCroix(obs, root, -360, 7);
            break;
        }
        this.y=y-275.0;
        if(obs.size()>9){
            obs.remove(0);
            obs.remove(1);
            obs.remove(2);
            obs.remove(3);
            obs.remove(4);
        }
            
    }
    
  
 
    private void initObstacle(int nbr){
        
        for(int i=0;i<nbr;i++){
            Random rand=new Random();
            int nombre=rand.nextInt(3);
            switch(nombre){
                case 0:     
                Rond r=new Rond(x,y,90,10,95,84);
                r.initRond(obs, root, -360, 5);
                break;
                
                case 1:
                Carre c= new Carre(x,y,10,100);
                c.initCarre(obs, root, -360, 5);    
                break;
                
                case 2:
                Croix cr= new Croix(175.0,y,10,75);
                cr.initCroix(obs, root, 360, 7);
        
                Croix cr2= new Croix(325.0,y,10,75);
                cr2.initCroix(obs, root, -360, 7);
                break;
            }
            this.y=y-275.0;
            
        } 
                
    }
    
    public void verifierCollision(){

        for (Iterator it = obs.iterator(); it.hasNext();) {
            ArrayList<Shape> f = (ArrayList<Shape>) it.next();     
            for(Shape a: f){
                Shape s = Shape.intersect(ball.getBalle(),a);
                if(!(s.getLayoutBounds().getHeight()<=0)){ 
                    if((ball.getCouleurBalle()==a.getStroke())){
                        System.out.println("ok");
                    }
                    else{
                        System.out.println("boom");
                    }
                }  
            }
        }      
    }
    
}
