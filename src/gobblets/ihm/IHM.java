package gobblets.ihm;

import gobblets.data.*;
import gobblets.ihm.langues.Allemand;
import gobblets.ihm.langues.Anglais;
import gobblets.ihm.langues.Francais;


public abstract class IHM {

    private static IHM courante;
    private static Dictionnaire language;

    public IHM() {
        language = null;
        courante = null;
    }

    public static IHM getIHM(){
        return courante;
    }

    public static void setIHM(IHM ihm){
        courante = ihm;
    }
    /**
     *
     * @param langue Prends la langue en paramètre (FR, EN, AL)
     */
    public static void setLanguage(String langue){
        if(langue.contains("FR")){
            language = new Francais();
        } else if(langue.contains("EN")){
            language= new Anglais();
        } else if(langue.contains("DE")){
            language= new Allemand();
        } else {
            language = null;
            System.out.println(erreur(Erreur.ARGUMENTINCORRECTE));
        }
    }

    public static String couleur(Couleur color){
        return language.couleur(color);
    }

    public static String taille(Taille taillePiece){
        return language.taille(taillePiece);
    }

    public static String etat(Etat state){
        return language.etat(state);
    }

    public static String action(ActionType action){
        return language.action(action);
    }

    public static String erreur(Erreur error){
        return language.erreur(error);
    }

    public static String avertissement(Avertissement advert){
        return language.avertissement(advert);
    }

    public static String menu(Menu menu){
        return language.menu(menu);
    }

    public abstract Joueur saisirJoueur(int numero);

    public abstract ActionType saisirAction(Joueur jouer);

    public abstract Taille saisirTaille();

    public abstract int[] saisirCoordonnees(ActionType action);

    public abstract void display(Plateau plat, Joueur j);
}
