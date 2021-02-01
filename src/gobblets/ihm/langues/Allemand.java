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

public class Allemand implements Dictionnaire {

    HashMap<Couleur, String> couleurs = new HashMap<Couleur, String>();
    HashMap<Taille, String> tailles = new HashMap<Taille, String>();
    HashMap<Etat, String> etats = new HashMap<Etat, String>();
    HashMap<ActionType, String> actions = new HashMap<ActionType, String>();
    HashMap<Erreur, String> erreurs = new HashMap<Erreur, String>();

    public Allemand(){
        couleurs.put(Couleur.ROUGE,"rot");
        couleurs.put(Couleur.VERT,"grün");
        couleurs.put(Couleur.BLEU,"blau");
        couleurs.put(Couleur.JAUNE,"gelb");
        couleurs.put(Couleur.WHITE,"weiß");
        //----------------------------------
        tailles.put(Taille.GRAND,"groß");
        tailles.put(Taille.MOYEN,"mittel");
        tailles.put(Taille.PETIT,"klein");
        //----------------------------------
        etats.put(Etat.JEUENCOURS,"Spiel läuft...");
        etats.put(Etat.JEUQUITTE,"Spiel übrig");
        etats.put(Etat.JOUEUR1GAGNE,"Spieler 1 hat gewonnen");
        etats.put(Etat.JOUEUR2GAGNE,"Spieler 2 hat gewonnen");
        etats.put(Etat.MATCHNUL,"Zeichnen");
        //----------------------------------
        actions.put(ActionType.DEPLACER,"verschieben");
        actions.put(ActionType.PLACER,"ort");
        actions.put(ActionType.QUITTER,"verlassen");
        //----------------------------------
        erreurs.put(Erreur.ARGUMENTINCORRECTE,"Falsches Argument");
        erreurs.put(Erreur.CASEBLOQUEE,"Blockierte Box");
        erreurs.put(Erreur.DIAGONALEINCORRECTE,"Falsche Diagonale");
        erreurs.put(Erreur.ORIGINEVIDE,"Leerer Ursprung");
        erreurs.put(Erreur.PASDEPIECEDISPONIBLE,"Keine Teile verfügbar");
        erreurs.put(Erreur.PASDEPIECEICI,"Keine Teile hier");
        erreurs.put(Erreur.PASDETAILLEDISPONIBLE,"Keine Größe verfügbar");
        erreurs.put(Erreur.PASTAPIECE,"Nicht dein Zimmer");
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
                avertissement = "Jetzt sind Sie dran !";
                break;
            case CHOIXACTION:
                avertissement = "Wollen Sie Verschieben, Ort oder Verlassen ?";
                break;
            case CHOIXTAILLE:
                avertissement = "Wählen Sie die Größe des Pfänders";
                break;
            case NOMJOUEUR:
                avertissement = "Wählen Sie einen Namen für den Spieler";
                break;
            case COULEURJOUEUR:
                avertissement = "Wählen Sie eine Farbe für die Spielsteine des Spielers";
                break;
            case CHOIXORIGIN:
                avertissement = "Geben Sie die Koordinaten des zu bewegenden Bauern ein";
                break;
            case CHOIXDESTINATION:
                avertissement = "Geben Sie die Koordinaten für die Platzierung des Bauern ein";
                break;
            case CHOIXJOUEURIA:
                avertissement = "Wollen Sie, dass dieser Spieler ein Spieler (1) oder eine KI (2) ist ?";
                break;
            case MAISONDE:
                avertissement = "Haus der";
                break;
            case DIFFICULTEIA:
                avertissement = "Spielen Sie gegen eine leichte (1) oder harte (2) KI?";
                break;
            case AIDE:
                avertissement = "\n" +
                        "Regeln des Spiels: \n" +
                        "Das Spiel wird von zwei Spielern auf einem Brett von drei mal drei Feldern gespielt,\n" +
                        "obwohl die Varianten auf größeren Brettern gespielt werden können.\n" +
                        "Jede einzelne ist z.B. an der Form oder Farbe des Stücks erkennbar.\n" +
                        "Die Spielsteine sind von drei verschiedenen Größen (groß, mittel, klein), wobei jeder Spieler zwei von jeder Größe hat.\n" +
                        "\n" +
                        "Im Laufe der Partie machen die Spieler abwechselnd einen Zug bestehend aus\n" +
                        "In beiden Fällen:\n" +
                        "- dem Gemälde ein Stück aus ihrer Sammlung hinzufügen.\n" +
                        "- eine seiner sichtbaren Figuren, die sich bereits auf dem Brett befinden, auf ein anderes Feld ziehen.\n" +
                        "\n" +
                        "Eine Figur kann entweder auf ein leeres Feld oder auf ein nicht leeres Feld gesetzt werden,\n" +
                        "oder auf einem Quadrat, das nur kleinere Stücke enthält,\n" +
                        "unabhängig davon, wem der Raum gehört.\n" +
                        "Im letzteren Fall verdeckt und versteckt der Teil die kleineren Teile.\n" +
                        "Wenn eine Figur, die auf andere Figuren gelegt wird, um ein Feld bewegt wird,\n" +
                        "das größte abgedeckte Stück wird aufgedeckt und kann später gespielt werden.\n" +
                        "\n" +
                        "Das Spiel gewinnt der erste Spieler, dem es gelingt, eine sichtbare Linie von\n" +
                        "seine Figuren durch den Tisch auf einer Zeile, einer Spalte,\n" +
                        "oder eine Diagonale, wie in Tic-Tac-Toe.\n";
                break;
            case APROPOS:
                avertissement = "-----------------------------------------\n" +
                        "Programm durchgeführt von : Léo Lefebvre und Valentin Huard\n" +
                        "Sektion: IT, Gruppe : TP1.2.A\n" +
                        "Akademisches Jahr : 2019-2020\n" +
                        "Name des Lehrers : Herr Zimmermann\n" +
                        "Projekt : Gobblet-Gobblers-Spiel\n" +
                        "-----------------------------------------\n\n";
                break;
            case BIENVENUE:
                avertissement = "Willkommen beim Gobblet-Gobblers-Spiel !";
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
                men = "Datei";
                break;
            case MENU_OUVRIR:
                men = "Öffnen Sie";
                break;
            case MENU_ENREGISTRER:
                men = "Registrieren";
                break;
            case MENU_NOUVEAU:
                men = "Neu";
                break;
            case MENU_QUITTER:
                men = "Verlassen";
                break;
            case MENU_AIDE:
                men = "Hilfe";
                break;
            case MENU_APROPOS:
                men = "Über uns";
                break;
            case MENU_LANGUE:
                men = "Sprache";
                break;
            case MENU_RETOUR:
            	men = "Zurück";
            	break;
            default:
                men = null;
                break;
        }
        return men;
    }
}
