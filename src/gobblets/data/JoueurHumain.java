package gobblets.data;

import gobblets.ihm.texte.SaisieConsole;
import gobblets.interaction.Action;
import gobblets.interaction.Deplacement;
import gobblets.interaction.Placement;
import gobblets.interaction.Termination;

public class JoueurHumain extends Joueur{
	private SaisieConsole saisie;
	
	public JoueurHumain(String nom, Couleur cou){
		super(nom, cou);
		saisie = new SaisieConsole();
	}
	
	///Les affichages consoles a ajouter
	public Action choisirAction(Plateau p){
		int[] Coord;
		Taille tail = null;
		ActionType actionT;
		//Recensement Action
		actionT = saisie.saisirAction(this);
		if(actionT==ActionType.PLACER) {
			//Recensement Coordonnees
			Coord = saisie.saisirCoordonnees(ActionType.PLACER);
			//Recensement Taille
			tail = saisie.saisirTaille();
			if(tail != null) {
				return new Placement(tail, p.getPlateau()[Coord[0]][Coord[1]]);
			}
			else {
				return null;
			}
			
		}
		else if(actionT==ActionType.DEPLACER) {
			//Recensement Coordonnees
			Coord = saisie.saisirCoordonnees(ActionType.DEPLACER);
			return new Deplacement(p.getPlateau()[Coord[0]][Coord[1]], p.getPlateau()[Coord[2]][Coord[3]]);
		}
		else if(actionT==ActionType.QUITTER) {
			return (new Termination());
		}
		
		else {
			return null;
		}
	}
}
