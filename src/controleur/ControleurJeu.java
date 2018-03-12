package controleur;

import modele.Jeu;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import vue.Vue2;



public class ControleurJeu implements EventHandler{
    
    private Jeu j;
    private Vue2 v;
    private Stage s;
    private boolean monte;
    private double t;
    
    public ControleurJeu(Jeu _j,Vue2 _v,Stage _s){
        j=_j;
        v=_v;
        s=_s;
        monte=true;
        t=2;
    }
    
    @Override
    public void handle(Event event) {
        
        if(event.getEventType()==MouseEvent.MOUSE_CLICKED){ 
             handleMouse((MouseEvent)event);
        }
        else{
            handleEvent((ActionEvent)event);
        }
    }

    
    private void handleEvent(ActionEvent event) {
        if(t<=0){
        	monte=false;
        }
        
    	if(!monte){
            if(j.getBalleJ().getY()<=600){
                j.getBalleJ().setY(j.getBalleJ().getY()+ 0.5*2*t*t);
                if(j.getBalleJ().getYb()>650){
                    v.stop();
                    j.finDeJeu(s);
                    System.out.println("fin");
                }    
            }
            t+=0.1;
    		
    	}else{
    		if(t<=0)
    			monte=false;
    		j.getBalleJ().setY(j.getBalleJ().getY()- 0.5*2*t*t);
    		t-=0.1;
    	}
    	
    	
    	
        if(/*primaryStage.getMaxHeight()/2*/700.0/2>j.getBalleJ().getYb()){
            j.getRoot().setLayoutY(j.getRoot().getLayoutY()+1);
            j.setLabelScore();
            //v.setPause();
            if(j.getRoot().getLayoutY()%250<=0){
                j.boucleObstacle();
            }                  
        }
    	
                             

        resultat();
    }
    
    private void handleMouse(MouseEvent e){
    	monte=true;
    	t=2;

    }
    
    private void resultat(){
        
        switch(j.verifierCollision()){
            case 0:
                System.out.println("ok");
                break;
            case 1:
                System.out.println("etoile");
                break;
            case 2:
                j.getBalleJ().setRandomCouleur();
                System.out.println("changerCouleur");
                break;
            case 3:
                if(j.getBalleJ().getCouleurBalle()==Color.PURPLE)
                    j.getBalleJ().setCouleurBalle(Color.CYAN);
                else
                    j.getBalleJ().setCouleurBalle(Color.PURPLE);
                System.out.println("croix");
                break;               
            case 4:
                v.stop();
                j.finDeJeu(s);
                System.out.println("boom");
                break;
        } 
        
    }
}
