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

public class Anglais implements Dictionnaire {

    HashMap<Couleur, String> couleurs = new HashMap<Couleur, String>();
    HashMap<Taille, String> tailles = new HashMap<Taille, String>();
    HashMap<Etat, String> etats = new HashMap<Etat, String>();
    HashMap<ActionType, String> actions = new HashMap<ActionType, String>();
    HashMap<Erreur, String> erreurs = new HashMap<Erreur, String>();

    public Anglais(){
        couleurs.put(Couleur.ROUGE,"red");
        couleurs.put(Couleur.VERT,"green");
        couleurs.put(Couleur.BLEU,"blue");
        couleurs.put(Couleur.JAUNE,"yellow");
        couleurs.put(Couleur.WHITE,"white");
        //----------------------------------
        tailles.put(Taille.GRAND,"tall");
        tailles.put(Taille.MOYEN,"medium");
        tailles.put(Taille.PETIT,"small");
        //----------------------------------
        etats.put(Etat.JEUENCOURS,"Game in progress...");
        etats.put(Etat.JEUQUITTE,"Game Leaved");
        etats.put(Etat.JOUEUR1GAGNE,"Player 1 Won");
        etats.put(Etat.JOUEUR2GAGNE,"Player 2 Won");
        etats.put(Etat.MATCHNUL,"Draw");
        //----------------------------------
        actions.put(ActionType.DEPLACER,"move");
        actions.put(ActionType.PLACER,"place");
        actions.put(ActionType.QUITTER,"leave");
        //----------------------------------
        erreurs.put(Erreur.ARGUMENTINCORRECTE,"Incorrect argument");
        erreurs.put(Erreur.CASEBLOQUEE,"Blocked box");
        erreurs.put(Erreur.DIAGONALEINCORRECTE,"Incorrect Diagonal");
        erreurs.put(Erreur.ORIGINEVIDE,"Empty origin");
        erreurs.put(Erreur.PASDEPIECEDISPONIBLE,"No pieces available");
        erreurs.put(Erreur.PASDEPIECEICI,"No piece here");
        erreurs.put(Erreur.PASDETAILLEDISPONIBLE,"No size available");
        erreurs.put(Erreur.PASTAPIECE,"Not your pieces");
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
                avertissement = "It's your turn !";
                break;
            case CHOIXACTION:
                avertissement = "Do you want to move, place or leave?";
                break;
            case CHOIXTAILLE:
                avertissement = "Choose the size of the pawn";
                break;
            case NOMJOUEUR:
                avertissement = "Choose a name for the player";
                break;
            case COULEURJOUEUR:
                avertissement = "Choose a color for the pawns of player";
                break;
            case CHOIXORIGIN:
                avertissement = "Enter the coordinates of the pawn to be moved";
                break;
            case CHOIXDESTINATION:
                avertissement = "Enter the coordinates for the placement of the pawn";
                break;
            case CHOIXJOUEURIA:
                avertissement = "Do you want this player to be a player (1) or an AI (2) ?";
                break;
            case MAISONDE:
                avertissement = "House of";
                break;
            case DIFFICULTEIA:
                avertissement = "Playing against an Easy (1) or Difficult (2) AI?";
                break;
            case AIDE:
                avertissement = "\n" +
                        "Rules of the games : \n" +
                        "The game is played by two players on a board of three by three squares,\n" +
                        "although the variants can be played on larger boards.\n" +
                        "Each identifiable, for example, by the shape or colour of the part.\n" +
                        "The pieces are of three different sizes (large, medium, small), each player having two of each size.\n" +
                        "\n" +
                        "During the course of the game, players alternately make a move consisting of\n" +
                        "In both cases:\n" +
                        "- add a piece of their collection to the board.\n" +
                        "- move one of his visible pieces already on the board to another square.\n" +
                        "\n" +
                        "A piece can be placed either on an empty square or on a square that is not empty,\n" +
                        "or on a square containing only smaller pieces,\n" +
                        "regardless of who owns the room.\n" +
                        "In the latter case, the part covers and hides the smaller parts.\n" +
                        "When a piece placed on top of other pieces is moved by one square,\n" +
                        "the largest covered piece is revealed and can be played at a later date.\n" +
                        "\n" +
                        "The game is won by the first player who manages to make a visible line of\n" +
                        "his pieces through the table on one line, one column,\n" +
                        "or a diagonal, like in Tic-Tac-Toe.\n";
                break;
            case APROPOS:
                avertissement = "-----------------------------------------\n" +
                        "Program carried out by : Léo Lefebvre et Valentin Huard\n" +
                        "Section: Informatics, Group : TP1.2.A\n" +
                        "Academic year : 2019-2020\n" +
                        "Teacher's name : Mister Zimmermann\n" +
                        "Project: Gobblet-Gobblers game\n" +
                        "-----------------------------------------\n\n";
                break;
            case BIENVENUE:
                avertissement = "Welcome to the Gobblet-Gobblers Game !";
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
                men = "Folder";
                break;
            case MENU_OUVRIR:
                men = "Open";
                break;
            case MENU_ENREGISTRER:
                men = "Save";
                break;
            case MENU_NOUVEAU:
                men = "New";
                break;
            case MENU_QUITTER:
                men = "Quit";
                break;
            case MENU_AIDE:
                men = "Help";
                break;
            case MENU_APROPOS:
                men = "About us";
                break;
            case MENU_LANGUE:
                men = "Language";
                break;
            case MENU_RETOUR:
            	men = "Return";
            	break;
            default:
                men = null;
                break;
        }
        return men;
    }
}
