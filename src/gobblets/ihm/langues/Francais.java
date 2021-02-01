package gobblets.ihm.langues;

import gobblets.data.ActionType;
import gobblets.data.Couleur;
import gobblets.data.Etat;
import gobblets.data.Taille;
import gobblets.ihm.Avertissement;
import gobblets.ihm.Dictionnaire;
import gobblets.ihm.Erreur;
import gobblets.ihm.Menu;

import java.util.HashMap;

public class Francais implements Dictionnaire {

    private HashMap<Couleur, String> couleurs = new HashMap<Couleur, String>();
    private HashMap<Taille, String> tailles = new HashMap<Taille, String>();
    private HashMap<Etat, String> etats = new HashMap<Etat, String>();
    private HashMap<ActionType, String> actions = new HashMap<ActionType, String>();
    private HashMap<Erreur, String> erreurs = new HashMap<Erreur, String>();

    public Francais(){
        couleurs.put(Couleur.ROUGE,"rouge");
        couleurs.put(Couleur.VERT,"vert");
        couleurs.put(Couleur.BLEU,"bleu");
        couleurs.put(Couleur.JAUNE,"jaune");
        couleurs.put(Couleur.WHITE,"blanc");
        //----------------------------------
        tailles.put(Taille.GRAND,"grand");
        tailles.put(Taille.MOYEN,"moyen");
        tailles.put(Taille.PETIT,"petit");
        //----------------------------------
        etats.put(Etat.JEUENCOURS,"Jeu en cours");
        etats.put(Etat.JEUQUITTE,"Jeu quittee");
        etats.put(Etat.JOUEUR1GAGNE,"Joueur 1 a gagnee");
        etats.put(Etat.JOUEUR2GAGNE,"Joueur 2 a gagnee");
        etats.put(Etat.MATCHNUL,"Match nul");
        //----------------------------------
        actions.put(ActionType.DEPLACER,"deplacer");
        actions.put(ActionType.PLACER,"placer");
        actions.put(ActionType.QUITTER,"quitter");
        //----------------------------------
        erreurs.put(Erreur.ARGUMENTINCORRECTE,"Argument incorrect");
        erreurs.put(Erreur.CASEBLOQUEE,"Case bloquee");
        erreurs.put(Erreur.DIAGONALEINCORRECTE,"Diagonale incorrecte");
        erreurs.put(Erreur.ORIGINEVIDE,"Origine vide");
        erreurs.put(Erreur.PASDEPIECEDISPONIBLE,"Pas de piece disponible");
        erreurs.put(Erreur.PASDEPIECEICI,"Pas de piece ici");
        erreurs.put(Erreur.PASDETAILLEDISPONIBLE,"Pas de taille disponible");
        erreurs.put(Erreur.PASTAPIECE,"Pas votre piece");
    }

    @Override
    public String couleur(Couleur coul) {
        return couleurs.get(coul);
    }

    @Override
    public String taille(Taille size) {
        return tailles.get(size);
    }

    @Override
    public String etat(Etat state) {
        return etats.get(state);
    }

    @Override
    public String action(ActionType action) {
        return actions.get(action);
    }

    @Override
    public String erreur(Erreur error) {
        return erreurs.get(error);
    }

    @Override
    public String avertissement(Avertissement advert) {
        String avertissement;
        switch (advert){
            case TONTOUR:
                avertissement = "C'est votre tour !";
                break;
            case CHOIXACTION:
                avertissement = "Voulez-vous vous deplacer, placer ou quitter ?";
                break;
            case CHOIXTAILLE:
                avertissement = "Choisissez la taille de la piece";
                break;
            case NOMJOUEUR:
                avertissement = "Choisissez un nom pour le joueur";
                break;
            case COULEURJOUEUR:
                avertissement = "Choisissez une couleur pour les pions du joueur";
                break;
            case CHOIXORIGIN:
                avertissement = "Saisissez les coordonnées du pion à déplacer";
                break;
            case CHOIXDESTINATION:
                avertissement = "Saisissez les coordonnées pour le placement du pion";
                break;
            case CHOIXJOUEURIA:
                avertissement = "Voulez-vous que ce joueur soit un joueur (1) ou une IA (2) ?";
                break;
            case MAISONDE:
                avertissement = "Maison de";
                break;
            case DIFFICULTEIA:
                avertissement = "Jouer contre une IA Facile (1) ou Difficile (2) ?";
                break;
            case AIDE:
                avertissement = "\n" +
                        "Règles du jeu : \n" +
                        "Le jeu est joué par deux joueurs sur un plateau de trois par trois carrés,\n" +
                        "bien que les variantes puissent être jouées sur de plus grandes planches.\n" +
                        "Chaque identifiable, par exemple par la forme ou la couleur de la pièce.\n" +
                        "Les pièces sont de trois différentes tailles (grand, moyen, petit), chaque joueur ayant deux de chaque taille.\n" +
                        "\n" +
                        "Au cours du jeu, les joueurs font alternativement un mouvement consistant à\n" +
                        "Dans les deux cas:\n" +
                        "- ajouter un morceau de leur collection au tableau.\n" +
                        "- déplacer une de ses pièces visibles déjà sur le tableau vers une autre case.\n" +
                        "\n" +
                        "Un morceau peut être placé soit sur une case vide,\n" +
                        "ou sur un carré ne contenant que des morceaux plus petits,\n" +
                        "indépendamment de qui possède la pièce.\n" +
                        "Dans ce dernier cas, la pièce recouvre et cache les plus petites pièces.\n" +
                        "Quand un morceau placé sur d'autres morceaux est déplacé d'un carré,\n" +
                        "la plus grande pièce couverte est révélée et peut être jouée ultérieurement.\n" +
                        "\n" +
                        "Le jeu est remporté par le premier joueur qui réussit à faire une ligne visible de\n" +
                        "ses pièces à travers le tableau sur une ligne, une colonne,\n" +
                        "ou une diagonale, comme pour Tic-Tac-Toe.\n";
                break;
            case APROPOS:
                avertissement = "-----------------------------------------\n" +
                        "Programme réalisée par : Léo Lefebvre et Valentin Huard\n" +
                        "Section : Informatique Groupe : TP1.2.A\n" +
                        "Année académique : 2019-2020\n" +
                        "Nom de l'enseignant : Monsieur Zimmermann\n" +
                        "Projet : Jeu Gobblet-Gobblers\n" +
                        "-----------------------------------------\n\n";
                break;
            case BIENVENUE:
                avertissement = "Bienvenue sur le Jeu Gobblet-Gobblers !";
                break;
            default:
            	avertissement=null;
                break;
        }
        return avertissement;
    }

    @Override
    public String menu(Menu menu) {
        String men;
        switch (menu){
            case MENU_FICHIER:
                men = "Fichier";
                break;
            case MENU_OUVRIR:
                men = "Ouvrir";
                break;
            case MENU_ENREGISTRER:
                men = "Enregistrer";
                break;
            case MENU_NOUVEAU:
                men = "Nouveau";
                break;
            case MENU_QUITTER:
                men = "Quitter";
                break;
            case MENU_AIDE:
                men = "Aide";
                break;
            case MENU_APROPOS:
                men = "A propos";
                break;
            case MENU_LANGUE:
                men = "Langue";
                break;
            case MENU_RETOUR:
            	men = "Retour";
            	break;
            default:
                men = null;
                break;
        }
        return men;
    }
}
