package gobblets.interaction;

import gobblets.data.Case;
import gobblets.data.Joueur;
import gobblets.data.Taille;
import gobblets.ihm.Erreur;
import gobblets.logic.CaseBloqueeException;
import gobblets.logic.PiecePasDisponibleException;

public class Placement extends Action {
	private Taille t;
	private Case dest;
	
	public Placement(Taille t, Case dest) {
		super();
		this.t=t;
		this.dest=dest;
	}
	
	public Taille getTaille() {
		return this.t;
	}
	
	public Case getDestination() {
		return this.dest;
	}
	
	public boolean verifier(Joueur j) throws PiecePasDisponibleException, CaseBloqueeException {
		if(!j.aPieceDeTaille(Taille.PETIT)&&!j.aPieceDeTaille(Taille.MOYEN)&&!j.aPieceDeTaille(Taille.GRAND)) {
			throw new PiecePasDisponibleException(Erreur.PASDEPIECEDISPONIBLE);
		}
		else {
			if(!j.aPieceDeTaille(this.t)){
				throw new PiecePasDisponibleException(Erreur.PASDETAILLEDISPONIBLE);
			}
			else {
				if(this.dest.plusGrandePiece()!=null&&!t.recouvre(dest.plusGrandePiece().getTaille())) {
					throw new CaseBloqueeException(Erreur.CASEBLOQUEE);
				}
				else {
					return true;
				}
			}
		}
	}
	
	public void appliquer(Joueur j) {
		dest.placePiece(j.enlevePiece(t));
	}
}
