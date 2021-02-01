package gobblets.ihm;

import gobblets.data.ActionType;
import gobblets.data.Couleur;
import gobblets.data.Etat;
import gobblets.data.Taille;

public interface Dictionnaire {

    String couleur(Couleur coul);

    String taille(Taille size);

    String etat(Etat state);

    String action(ActionType action);

    String erreur(Erreur error);

    String avertissement(Avertissement advert);

    String menu(Menu menu);

}
