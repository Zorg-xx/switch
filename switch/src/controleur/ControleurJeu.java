/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controleur;

import modele.Jeu;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;



public class ControleurJeu implements EventHandler{
    
    private Jeu j;
    
    public ControleurJeu(Jeu _j){
        j=_j;
    }
    
    @Override
    public void handle(Event event) {
        
        if(event.getEventType()==MouseEvent.MOUSE_CLICKED){
            handleMouse((MouseEvent) event);
        }
        else{
            handleEvent((ActionEvent)event);
        }
    }

    
    private void handleEvent(ActionEvent event) {
        
        if(j.getBalleJ().getY()<=600){
            j.getBalleJ().setY(j.getBalleJ().getY()+1);
        }                                
        if(/*primaryStage.getMaxHeight()/2*/700.0/2>j.getBalleJ().getYb()){
            j.getRoot().setLayoutY(j.getRoot().getLayoutY()+1);
            if(j.getRoot().getLayoutY()%250<=0){
                j.boucleObstacle();
            }                  
        }
        j.verifierCollision();
    }
    
    private void handleMouse(MouseEvent e){
        
        j.getBalleJ().setY(j.getBalleJ().getY()-35);
        j.verifierCollision();  
    }
}