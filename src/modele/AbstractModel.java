package modele;

import java.util.ArrayList;

import vue.Observer;

public abstract class AbstractModel implements Observable {

	protected double score=0;
	
	private ArrayList<Observer> listObserver= new ArrayList<Observer>();
	//reset la scene
	public abstract void reset();
	
	//Ajoute des points au score
	public abstract void upScore();
	
	
	public void addObserver(Observer obs){
		this.listObserver.add(obs);	
	}
	
	//notifie les Observers
	public void notifyObserver(){
		
		for(Observer obs : listObserver){
		obs.update();
		}
	}
}
