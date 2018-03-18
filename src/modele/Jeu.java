package modele;

import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Group;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;
import static vue.Vue1.DIFFICULTE;

/*
*
*initObs et boucleObs à revoir. Code redondant
*
*/

/**
 * Classe Jeu contient les paramètres du jeu. 
 * création des formes de départ, génération aléatoire des formes
 * gère la collision des formes et de la balle
 * 
 * 
 */


public class Jeu {
    
    private ArrayList<Shape> obs;
    private Balle ball;
    private Group root;
    private Double x;
    private Double y;
    private int score = 0;
    private Boolean godMode;
    private String difficulte;
    
    
    
    public Jeu(Group _root){
        
        x=250.0;
        y=400.0;
        
        root=_root;
        obs=new ArrayList();
      
        initObstacle(5);
        ball=new Balle(root,240,600);
        godMode=false;
        difficulte=DIFFICULTE;
       

    }
    
    public String getDifficulte(){
        return difficulte;
    }
    
    public Boolean getGodMode(){
        return godMode;
    }
    
    public void setGodMode(Boolean _godMode){
        godMode=_godMode;
    }
    
    public int getScore(){
        return score;
    }
    /**
     * modifie le score en fonction de la difficulté
     */
    public void setScore(){
        if(difficulte.equalsIgnoreCase("facile"))
            score=score+1;
        else if(difficulte.equals("normale"))
            score=score+2;
        else
            score=score+3;
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
    
    /**
     * pour determiner un sens horaire ou anti-horaire de rotation aux formes
     * @return int 360 ou -360
     */
    private int sensRotation(){
        
        Random rand=new Random();
        int rotation=rand.nextInt(2);
        if(rotation==0)
            return 360;
        else
            return -360;
    }
    /**
     * 
     * génère une forme aléatoire
     * 
     */
    
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
               
            /*pas d'aléatoire sur le changement de couleur de la balle.
            *une balle placée systématiquement avant chaque croix
            *seules couleurs possibles: cyan ou violet
            */
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
        //l'ordonnée de positionnement de la forme est modifié pour la prochaine forme.
        this.y=y-275.0;
        //vidange de la liste de Shape.
        if(obs.size()>10){
            obs.remove(0);
        }
        //une balle pour changer de couleur est placée aléatoirement 1 chance sur 2
        //dès qu'un obstacle est placée aléatoirement
        Random rand1=new Random();
        int nombre1=rand1.nextInt(2);
        if(nombre1==0){
            BalleChangeante bc1=new BalleChangeante(x,y-150.0,"changerCouleur");
            bc1.initBalleC(obs, root, 0, 0);
        }
    }
    
    /**
     * crée un nombre d'obstacles au départ du jeu
     * 
     * @param nbr nombres d'obstacles à placer au départ du jeu
     * 
     * @return void
     */
    
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
    
    /**
     * gère la collision entre la balle et la liste de Shape obs
     * 
     * @return int pour le controleur
     * -1 retour par défaut. Pas utilisé
     * 0 pour collision sur une couleur identique de la balle
     * 1 pour collision sur une étoile( score )
     * 2 pour collision sur balle pour changer de couleur
     * 3 pour collision sur balle pour changer de couleur avant une croix
     * 4 pour collision sur tout le reste
     */
    
    public int verifierCollision(){
        int retour=-1;
        for(Shape a: obs){
            //création d'une Shape si la balle intersecte avec une Shape contenu dans obs
            Shape s = Shape.intersect(ball.getBalle(),a);
            //determine la hitbox de s. Incluse entre 0 et 10. Plus c'est élevé, plus c'est permissif.
            if(!(s.getLayoutBounds().getHeight()<=5)){
                //test de la Shape a sur son affichage visible ou non
                if(a.isVisible()){
                    System.out.println("balle "+ball.getCouleurBalle());
                    System.out.println("objet "+a.getStroke());
                    //test de la couleur de la balle et de la Shape a pour le franchissement des obstacles
                    if((ball.getCouleurBalle()==a.getStroke())){
                        retour=0;                     
                    }
                    /*
                    *sinon test pour les autres formes n'étant pas des obstacles
                    *id etoile pour la forme étoile lié au score
                    *id changerCouleur pour la balle servant à changer de couleur
                    *id croix pour la balle servant à changer de couleur placé avant une croix
                    *toutes ces formes sont rendus non-visibles une fois touchée.
                    *cf test ci-dessus pour éviter de nouveau le test
                    */
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
                    //sinon toutes les autres Shape qui n'ont pas d'id ou une couleur différente sont testées ici.
                    else{
                        if(!(a instanceof Polygon))
                           retour=4;  
                    }
                }
            }  
        }  
        return retour;
    }
    /**
     * permet de marquer une courte pause à la fin du jeu
     * 
     */
    public void finDeJeu(){
        
        try {
            Thread.sleep(450);
        } catch (InterruptedException ex) {
            Logger.getLogger(Jeu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}
