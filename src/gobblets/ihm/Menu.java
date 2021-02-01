package gobblets.ihm;

/**
 * La classe <b>Menu</b> est une classe enum servant
 * à l'énumération des différents messages du menu.
 * 
 * @author Léo Lefebvre, Valentin Huard
 * @version 1.0
 * @see gobblets.ihm.Avertissement
 */

public enum Menu {
	/**
	 * Servant à l'affichage de "Fichier"
	 */
    MENU_FICHIER(),
    /**
     * Servant à l'affichage de "Ouvrir"
     */
    MENU_OUVRIR(),
    /**
     * Servant à l'affichage de "Enregistrer"
     */
    MENU_ENREGISTRER(),
    /**
     * Servant à l'affichage de "Nouveau"
     */
    MENU_NOUVEAU(),
    /**
     * Servant à l'affichage de "Quitter"
     */
    MENU_QUITTER(),
    /**
     * Servant à l'affichage de "Aide"
     */
    MENU_AIDE(),
    /**
     * Servant à l'affichage de "A propos"
     */
    MENU_APROPOS(),
    /**
     * Servant à l'affichage de "Langue"
     */
    MENU_LANGUE(),
    /**
     * Servant à l'affichage de "Retour"
     */
    MENU_RETOUR();

    private Menu(){
        
    }
}
