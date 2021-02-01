package gobblets.ihm.texte;

import gobblets.Gobblets;
import gobblets.data.*;
import gobblets.ihm.Avertissement;
import gobblets.ihm.Erreur;
import gobblets.ihm.IHM;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SaisieConsole extends IHM {

   public final static Scanner sc = new Scanner(System.in, "UTF8");

    public SaisieConsole(){
        super();
        super.setLanguage(Gobblets.getLangue());
    }
    
    public Joueur saisirJoueur(int num) {
    	String nom;
    	String cou;
    	Couleur couleur;
    	boolean valide = false;
    	Joueur jRetour = null;
        System.out.println(super.avertissement(Avertissement.NOMJOUEUR).toString() + " " + num);
        nom = sc.next();
        do {
            System.out.println(super.avertissement(Avertissement.COULEURJOUEUR).toString() + " " + num);
            System.out.println("===="+super.couleur(Couleur.BLEU)+" "+super.couleur(Couleur.JAUNE)+" "+super.couleur(Couleur.VERT)+" "+super.couleur(Couleur.ROUGE)+" "+super.couleur(Couleur.WHITE)+"====");
            
            cou = sc.next();
            cou = cou.toLowerCase();
            if (cou.contains(super.couleur(Couleur.ROUGE))) {
                couleur = Couleur.ROUGE;
                valide = true;
            } else if (cou.contains(super.couleur(Couleur.VERT))) {
                couleur = Couleur.VERT;
                valide = true;
            } else if (cou.contains(super.couleur(Couleur.BLEU))) {
                couleur = Couleur.BLEU;
                valide = true;
            } else if (cou.contains(super.couleur(Couleur.JAUNE))) {
                couleur = Couleur.JAUNE;
                valide = true;
            } else if (cou.contains(super.couleur(Couleur.WHITE))) {
                couleur = Couleur.WHITE;
                valide = true;
            } else {
                couleur = null;
                System.out.println(super.erreur(Erreur.ARGUMENTINCORRECTE));
            }
        }while(valide == false);

        String typeJoueur;
        String typeIA;
        int retour = 0;
        do {
            System.out.println(super.avertissement(Avertissement.CHOIXJOUEURIA));
            typeJoueur = sc.next();
            if (typeJoueur.contains("1")) {
                jRetour = new JoueurHumain(nom, couleur);
                retour = 1;
            } else if (typeJoueur.contains("2")) {
                System.out.println(super.avertissement(Avertissement.DIFFICULTEIA));
                typeIA = sc.next();
                if(typeIA.contains("1")) {
                    jRetour = new JoueurIAFacile(nom, couleur);
                    retour = 1;
                } else if(typeIA.contains("2")){
                    jRetour = new JoueurIADifficile(nom, couleur);
                    retour = 1;
                }
            } else {
                System.out.println(super.erreur(Erreur.ARGUMENTINCORRECTE));
            }
        }while(retour==0);
        return jRetour;
    }

    public ActionType saisirAction(Joueur j){
        String action;
        ActionType actionT;
        boolean valide = false;
        do {
            System.out.println(super.avertissement(Avertissement.CHOIXACTION));
            action = sc.next();
            action = action.toLowerCase();
            if (action.contains(super.action(ActionType.DEPLACER))) {
                actionT = ActionType.DEPLACER;
                valide = true;
            } else if (action.contains(super.action(ActionType.PLACER))) {
                actionT = ActionType.PLACER;
                valide = true;
            } else if (action.contains(super.action(ActionType.QUITTER))) {
                actionT = ActionType.QUITTER;
                valide = true;
            } else {
                actionT = null;
                valide = false;
                System.out.println(super.erreur(Erreur.ARGUMENTINCORRECTE));
            }
        }while(valide == false);
        return actionT;
    }

    public Taille saisirTaille(){
        String taille;
        Taille size = null;
        boolean valide = false;
        do {
            System.out.println(super.avertissement(Avertissement.CHOIXTAILLE));
            System.out.println("===="+super.taille(Taille.PETIT)+" "+super.taille(Taille.MOYEN)+" "+super.taille(Taille.GRAND)+"====");
            taille = sc.next();
            taille = taille.toLowerCase();
            if (taille.contains(super.taille(Taille.PETIT))) {
            	size = Taille.PETIT;
            	valide = true;
            } else if (taille.contains(super.taille(Taille.MOYEN))) {
            	size = Taille.MOYEN;
            	valide = true;
            } else if (taille.contains(super.taille(Taille.GRAND))) {
            	size = Taille.GRAND;
            	valide = true;
            } else {
                size = null;
                System.out.println(super.erreur(Erreur.ARGUMENTINCORRECTE));
            }
        } while(valide == false);
        return size;
    }

    
    public int[] saisirCoordonnees(ActionType action) {
        int tabCoord[] = new int[4];
        boolean valide = false;
        switch(action){
            case PLACER:
                do {
                	System.out.println(super.avertissement(Avertissement.CHOIXDESTINATION));
                	String faux = null;
                    try {
                        System.out.print("x = ");
                        while(!sc.hasNextInt()) {
                        	faux = sc.next();
                        	throw new InputMismatchException();
                        }
                        tabCoord[0] = sc.nextInt()-1;
                        System.out.print("y = ");
                        while(!sc.hasNextInt()) {
                        	faux = sc.next();
                        	throw new InputMismatchException();
                        }
                        tabCoord[1] = sc.nextInt()-1;
                        //Boucle for pour tester si les valeurs saisies sont inf�rieurs � 1 ou sup�rieur � 3
                        for(int i = 0; i <= 1; i++){
                            if(tabCoord[i] > 2 || tabCoord[i] < 0){
                                throw new NumberFormatException();
                            }
                        }
                        valide = true;
                    } catch (NumberFormatException e) {
                        System.out.println(super.erreur(Erreur.PASDEPIECEICI));
                    } catch (InputMismatchException e) {
                    	System.out.println(faux+" : "+super.erreur(Erreur.ARGUMENTINCORRECTE));
                    }
                }while(valide == false);
                break;
            case DEPLACER:
                do {
                	//Veuillez entrer les coords (4 coords � recup -> Origine et Destination)
                    System.out.println(super.avertissement(Avertissement.CHOIXORIGIN));
                	String faux = null;
                    try{
                        System.out.print("x = ");
                        while(!sc.hasNextInt()) {
                        	faux = sc.next();
                        	throw new InputMismatchException();
                        }
                        tabCoord[0] = sc.nextInt()-1;
                        System.out.print("y = ");
                        while(!sc.hasNextInt()) {
                        	faux = sc.next();
                        	throw new InputMismatchException();
                        }
                        tabCoord[1] = sc.nextInt()-1;
                        System.out.println(super.avertissement(Avertissement.CHOIXDESTINATION));
                        System.out.print("x = ");
                        while(!sc.hasNextInt()) {
                        	faux = sc.next();
                        	throw new InputMismatchException();
                        }
                        tabCoord[2] = sc.nextInt()-1;
                        System.out.print("y = ");
                        while(!sc.hasNextInt()) {
                        	faux = sc.next();
                        	throw new InputMismatchException();
                        }
                        tabCoord[3] = sc.nextInt()-1;
                        //Boucle for pour tester si les valeurs saisies sont inf�rieurs � 1 ou sup�rieur � 3
                        for(int i = 0; i <= 3; i++){
                            if(tabCoord[i] > 2 || tabCoord[i] < 0){
                                throw new NumberFormatException();
                            }
                        }
                        valide = true;
                    } catch (NumberFormatException e){
                        System.out.println(super.erreur(Erreur.ARGUMENTINCORRECTE));
                    } catch (InputMismatchException e) {
                    	System.out.println(faux+" : "+super.erreur(Erreur.ARGUMENTINCORRECTE));
                    }
                }while(valide == false);
                break;
            case QUITTER:
                System.out.println(super.action(ActionType.QUITTER));
                return null;
            default:
                return null;
        }
        return tabCoord;
    }

    public void display(gobblets.data.Plateau plat, Joueur j) {
    	gobblets.ihm.texte.Plateau platDisp = new gobblets.ihm.texte.Plateau(plat);
    	for(int i=0; i<9; i++) {
    		if(i%3==0) {
    			if(i!=0) {
    				System.out.printf("\n");
    			}
    			System.out.printf("---------");
    			if(i==0) {
    				System.out.printf("			 " + super.avertissement(Avertissement.MAISONDE) + " " + j.getNom());
    			}
    			if(i==3) {
    		    	int incr = 0;
    				System.out.printf("			");
    				while(incr<j.getPieces().size()) {
    					String[] tablPiece = new gobblets.ihm.texte.Piece(j.getPieces().get(incr)).getRepresentationTextuelle();
    					System.out.printf(tablPiece[0]+tablPiece[1]);
    					incr++;
    				}
    			}
    			System.out.printf("\n");
    		}
    		System.out.printf(platDisp.getRepresentationTextuelle()[i]);
    	}
    	System.out.println("\n---------");
    	
    }

    public void finalize() {
        sc.close();
    }
}
