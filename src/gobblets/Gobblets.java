package gobblets;

import java.util.Scanner;
import gobblets.data.Etat;
import gobblets.ihm.Avertissement;
import gobblets.ihm.IHM;
import gobblets.ihm.Menu;
import gobblets.logic.Jeu;


/**
 * La classe <b>Gobblets</b> est une classe servant
 * au lancement du menu et de ses fonctionnalités.
 * 
 * @author Léo Lefebvre, Valentin Huard
 * @version 1.0
 * @see gobblets.Gobblets
 *
 */
public class Gobblets {
	
	/**
	 * - langue : variable static qui instance la langue de notre jeu.
	 */
	private static String langue;
	
	/**
	 * Méthode : permettant le choix de la langue et la sauvegarde dans l'attribut langue.
	 */
	public static void choixLangue() {
		Scanner scanLangue = new Scanner(System.in); 
		do {
			System.out.println("FR/EN/DE ?");
			langue = scanLangue.next();
		}while(!langue.contains("FR")&&!langue.contains("EN")&&!langue.contains("DE"));
		IHM.setLanguage(langue);
		menu();
		scanLangue.close();
	}
	
	/**
	 * Un getter de langue.
	 * @return l'attribut langue
	 */
	public static String getLangue() {
		return langue;
	}
	
	/**
	 * Méthode : permettant l'affichage du menu et des fonctionnalités.
	 */
	public static void menu() {
		String choix = null;
		Etat etatJeu;
		Scanner choixSc = new Scanner(System.in);
		System.out.println(IHM.avertissement(Avertissement.BIENVENUE));
		do {
			System.out.println("----------------------------");
			System.out.println("1."+IHM.menu(Menu.MENU_NOUVEAU));
			System.out.println("2."+IHM.menu(Menu.MENU_AIDE));
			System.out.println("3."+IHM.menu(Menu.MENU_APROPOS));
			System.out.println("4."+IHM.menu(Menu.MENU_LANGUE));
			System.out.println("5."+IHM.menu(Menu.MENU_QUITTER));
			System.out.println("----------------------------");
			choix = choixSc.next();
			if(choix.contains("1")) {
				Jeu jeu = new Jeu();
				etatJeu = jeu.play();
				if(etatJeu !=null) {
					System.out.println(IHM.etat(etatJeu));
				}
				else {
					System.out.println("Error");
				}
			}
			else if(choix.contains("2")){
				do {
					System.out.println(IHM.avertissement(Avertissement.AIDE));
					System.out.println("6."+IHM.menu(Menu.MENU_RETOUR));
				}while(!choixSc.next().contains("6"));
			}
			else if(choix.contains("3")) {
				do {
					System.out.println(IHM.avertissement(Avertissement.APROPOS));
					System.out.println("6."+IHM.menu(Menu.MENU_RETOUR));
				}while(!choixSc.next().contains("6"));
			}
			else if(choix.contains("4")){
				choixLangue();
			}
			else if(choix.contains("5")) {
				choixSc.close();
				System.exit(0);
			}
		}while(true);
	}
	
	public static void main(String[] args){
		Gobblets.choixLangue();
	}
}

