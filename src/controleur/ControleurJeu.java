package controleur;

import modele.Jeu;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import vue.Vue2;



public class ControleurJeu implements EventHandler{
    
    private Jeu j;
    private Vue2 v;
    private Stage s;
    private boolean monte;
    private double temps;
    
    public ControleurJeu(Jeu _j,Vue2 _v,Stage _s){
        j=_j;
        v=_v;
        s=_s;
        monte=true;
        temps=2.5;
    }
    
    @Override
    public void handle(Event event) {
        
        if(event.getEventType()==MouseEvent.MOUSE_CLICKED){ 
            handleMouse((MouseEvent)event);
        }
        else if(event.getEventType()==KeyEvent.KEY_PRESSED){
            handleKey((KeyEvent)event);
        }
        else{
            handleEvent((ActionEvent)event);
        }
    }
    
    private void handleKey(KeyEvent event){
        if(event.getCode()==KeyCode.G){
            if(j.getGodMode()){
                j.setGodMode(false);
                System.out.println("God mode OFF");
            }    
            else{
                j.setGodMode(true);
                System.out.println("God mode ON");
            }    
        }
        if(event.getCode()==KeyCode.SPACE){
            monteeBalle();
        }
        if(event.getCode()==KeyCode.P){
            if(v.getPause()){
                v.setPause(false);
                v.resume();
                System.out.println("pause OFF");
            }
            else{
                v.setPause(true);
                v.pause();
                System.out.println("pause ON");
            }
        }
    }

    private void handleEvent(ActionEvent event) {
        if(temps<=0.5){
        	monte=false;
        }
    	if(!monte){
            if(j.getBalleJ().getY()<=600){
                j.getBalleJ().setY(j.getBalleJ().getY()+ 0.5*2*temps*temps);
                if(j.getBalleJ().getYb()>650){
                    v.stop();
                    j.finDeJeu(s);
                    System.out.println("fin");
                }    
            }
            temps+=0.15;
    	}else{
    		if(temps<=0)
    			monte=false;
    		j.getBalleJ().setY(j.getBalleJ().getY()- 0.5*2*temps*temps);
    		temps-=0.15;
    	}
        if(/*primaryStage.getMaxHeight()/2*/700.0/2>j.getBalleJ().getYb()){
            j.getRoot().setLayoutY(j.getRoot().getLayoutY()+1);
            j.setLabelScore();
            v.setPauseB();
            if(j.getRoot().getLayoutY()%250<=0){
                j.boucleObstacle();
            }                  
        }
        resultat();
    }
    
    private void handleMouse(MouseEvent e){

        monteeBalle();
    }
    
        
    private void monteeBalle(){
        monte=true;
    	temps=2.5;
    }
    
    private void resultat(){
        
        switch(j.verifierCollision()){
            case 0:
                System.out.println("ok");
                break;
            case 1:
                System.out.println("etoile");
                j.setScoreplus1();
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
                if(!j.getGodMode()){
                    v.stop();
                    j.finDeJeu(s);
                }
                System.out.println("boom");
                break;
        } 
        
    }
}
