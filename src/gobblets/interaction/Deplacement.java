package gobblets.interaction;

import gobblets.data.Case;
import gobblets.data.Joueur;
import gobblets.ihm.Erreur;
import gobblets.logic.CaseBloqueeException;
import gobblets.logic.PiecePasDisponibleException;

public class Deplacement extends Action {
	private Case origin;
	private Case destination;
	
	public Deplacement(Case case1, Case case2) {
		super();
		this.origin=case1;
		this.destination=case2;
	}
	
	public Case getOrigin(){
		return this.origin;
	}
	
	public Case getDestination() {
		return this.destination;
	}
	
	public boolean verifier(Joueur j) throws PiecePasDisponibleException, CaseBloqueeException {
		if(origin.plusGrandePiece()==null) {
			throw new PiecePasDisponibleException(Erreur.ORIGINEVIDE);
		}
		else {
			if(!origin.plusGrandePiece().appartienA(j)) {
				throw new PiecePasDisponibleException(Erreur.PASTAPIECE);
			}
			else {
				if(destination.plusGrandePiece()!=null&&!origin.plusGrandePiece().getTaille().recouvre(destination.plusGrandePiece())) {
					throw new CaseBloqueeException(Erreur.CASEBLOQUEE);
				}
				else {
					return true;
				}
			}
		}
	}
	
	public void appliquer(Joueur j) {
		destination.placePiece(origin.enlevePiece());
	}
	
	public String toString() {
		return "Deplacement de la pi�ce\n La case origine : "+this.getOrigin().toString()+"\n et la case Destination : "+this.getDestination().toString();
	}
}
