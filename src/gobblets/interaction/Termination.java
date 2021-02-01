package gobblets.interaction;

import gobblets.data.Joueur;

public class Termination extends Action {
	//Termination est l'action qui correspond � la décision du joueur de quitter le jeu.
	public Termination() {
		super();
	}
	
	
	public boolean verifier(Joueur j) {
		return j.getNom()!=null||j.getCouleur()!=null;
	}
	
	public void appliquer(Joueur j) {
		System.exit(0);
	}
}
