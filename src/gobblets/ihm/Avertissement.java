package gobblets.ihm;

/**
 * La classe <b>Avertissement</b> est une classe enum servant
 * à l'énumération des différents messages d'avertissement.
 * 
 * @author Léo Lefebvre, Valentin Huard
 * @version 1.0
 * @see gobblets.ihm.Avertissement
 *
 */

public enum Avertissement {
	/**
	 * équivalent à "c'est à toi de jouer"
	 */
    TONTOUR(),
    /**
     * équivalent à "Voulez vous deplacer, placer ou quitter"
     */
    CHOIXACTION(),
    /**
     * équivalent à "Choisissez votre taille"
     */
    CHOIXTAILLE(),
    /**
     * équivalent à "Entrer le nom du joueur"
     */
    NOMJOUEUR(),
    /**
     * équivalent à "Entrer la couleur du joueur"
     */
    COULEURJOUEUR(),
    /**
     * équivalent à "Entrer les coordonnées d'origine de la pièce"
     */
    CHOIXORIGIN(),
    /**
     * équivalent à "Entrer les coordonnées de destination de la pièce"
     */
    CHOIXDESTINATION(),
    /**
     * équivalent à "Quel type de joueur ? IA ou humain ?"
     */
    CHOIXJOUEURIA(),
    /**
     * équivalent à "Maison de..."
     */
    MAISONDE(),
    /**
     * équivalent à "Quelle difficulté pour l'IA ?"
     */
    DIFFICULTEIA(),
    /**
     * Message d'explication du jeu pour le joueur
     */
    AIDE(),
    /**
     * Message des informations concernant le code
     */
    APROPOS(),
    /**
     * Message de bienvenue
     */
    BIENVENUE();

    private Avertissement(){
        
    }

}
