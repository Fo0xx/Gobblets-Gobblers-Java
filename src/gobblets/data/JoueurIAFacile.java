package gobblets.data;

import gobblets.interaction.Action;
import gobblets.interaction.Deplacement;
import gobblets.interaction.Placement;

import java.util.Random;

/**
 * La classe <b>JoueurIA Facile</b> est une classe
 * qui hérite des propriétés de Joueur.
 * Cette classe étant la version Facile du JoueurIA.
 * 
 * @author Léo Lefebvre, Valentin Huard
 * @version 1.0
 * @see gobblets.data.JoueurIAFacile
 *
 */

public class JoueurIAFacile extends Joueur {
	
	/**
	 * - random : instancie une variable de classe random pour de futurs utilisations.
	 */
	private Random random = new Random(System.currentTimeMillis());
	
	/**
	 * Constructeur : Initialise un joueurIA de type facile.
	 * @param nom le nom du joueur
	 * @param cou la couleur du joueur
	 */
	public JoueurIAFacile(String nom, Couleur cou) {
		super(nom, cou);
	}

	/**
	 * Méthode : permettant de déterminer l'action
	 * @param p le plateau du jeu
	 * @return retourne l'action du joueurIA
	 */
	public Action choisirAction(Plateau p){
		int[] coord = new int[3];
		boolean valide = false;
		ActionType actionT = randomActionT();
		Action actio = null;
		int i = 0;
		if(actionT == ActionType.PLACER){
			coord = randomCoord(ActionType.PLACER);
			do{
					actio = new Placement(randomTaille(), p.getPlateau()[coord[0]][coord[1]]);
					valide = true;
			}while(valide == false || i == 12);
		} else if(actionT == ActionType.DEPLACER){
			coord = randomCoord(ActionType.DEPLACER);
			do{
				actio = new Deplacement(p.getPlateau()[coord[0]][coord[1]],p.getPlateau()[coord[2]][coord[3]]);
				valide = true;
			}while(valide == false);
		}
		return actio;
	}
	
	
	/**
	 * Méthode : génère aléatoirement une action du bot entre placer ou déplacer.
	 * @return l'action type générée aléatoirement
	 */
	public ActionType randomActionT(){
		int nb;
		nb = 1+random.nextInt(3-1);
		if(nb == 1){
			return ActionType.PLACER;
		} else {
			return ActionType.DEPLACER;
		}
	}

	/**
	 * Méthode : génère aléatoirement taille qui va servir lorsque l'IA pose une pièce.
	 * @return la taille générée aléatoirement.
	 */
	public Taille randomTaille(){
		int nb;
		Taille size;
		nb = 1 + random.nextInt(4-1);
		if(nb == 1){
			size = Taille.PETIT;
		} else if(nb == 2){
			size = Taille.MOYEN;
		} else {
			size = Taille.GRAND;
		}
		return size;
	}
	
	/**
	 * Méthode : génère aléatoirement les coordonnées en fonction d'un placement ou déplacement. 
	 * @param actionT l'action Type retournée précédement par la méthode randomActionT().
	 * @return les coordonnées générées.
	 */
	public int[] randomCoord(ActionType actionT){
		int[] coord = new int[4];
		if(actionT == ActionType.PLACER){
			for(int i = 0;i <=1; i++){
				coord[i] = random.nextInt(4-1);
			}
		} else if(actionT == ActionType.DEPLACER){
			for(int i = 0;i <=3; i++){
				coord[i] = random.nextInt(4-1);
			}
		}
		return coord;
	}
}
