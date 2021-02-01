package gobblets.interaction;

import gobblets.data.Joueur;
import gobblets.logic.CaseBloqueeException;
import gobblets.logic.PiecePasDisponibleException;

public abstract class Action {
	
	public Action() {
		
	}
	
	abstract public boolean verifier(Joueur j) throws PiecePasDisponibleException, CaseBloqueeException;
	
	abstract public void appliquer(Joueur j);
	
}
