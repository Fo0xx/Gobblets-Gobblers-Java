package gobblets.logic;



import gobblets.data.Etat;
import gobblets.data.Joueur;
import gobblets.data.Plateau;
import gobblets.ihm.Avertissement;
import gobblets.ihm.texte.SaisieConsole;
import gobblets.interaction.Action;
import gobblets.interaction.Deplacement;
import gobblets.interaction.Placement;
import gobblets.interaction.Termination;

public class Jeu {
	private Etat etat;
	private Joueur j1;
	private Joueur j2;
	private Joueur joueurActif;
	private Plateau plateau;
	private SaisieConsole saisie = new SaisieConsole();
	
	public Jeu(){
		this.plateau=Plateau.initPlateau();
		this.etat=Etat.JEUENCOURS;
	}
	
	private Etat unTour(int num) {
		boolean valide=false;
		do {
			System.out.println("n°"+num+" : "+SaisieConsole.avertissement(Avertissement.TONTOUR)+" "+this.joueurActif.getNom());
			saisie.display(this.plateau, this.joueurActif);
			Action action = this.joueurActif.choisirAction(this.plateau);
			try {
				if(action instanceof Placement || action instanceof Deplacement) {
					action.verifier(joueurActif);
					action.appliquer(joueurActif);
				}
				else {
					saisie.finalize();
					this.etat=Etat.JEUQUITTE;
				}
				valide=true;
			} catch (PiecePasDisponibleException e) {
				e = (PiecePasDisponibleException) e;
				System.out.println("-----"+SaisieConsole.erreur(e.getErreur())+"-----");
			} catch (CaseBloqueeException e) {
				e = (CaseBloqueeException) e;
				System.out.println("-----"+SaisieConsole.erreur(e.getErreur())+"-----");
			}
		}while(valide==false);
		
		this.setEtat();
		this.changeJoueur();
		return this.etat;
		
	}
	
	public Etat play() {
		this.j1= saisie.saisirJoueur(1);
		this.j2 = saisie.saisirJoueur(2); //SaisieConsole
		this.j1.setPieces(plateau.getMaisonJoueur1());
		this.j2.setPieces(plateau.getMaisonJoueur2());
		this.joueurActif=j1;
		int num=0;
		Etat etat;
		do {
			etat = this.unTour(num);
			num++;
		}while(this.etat==Etat.JEUENCOURS);
		saisie.display(this.plateau,this.joueurActif);
		return etat;
	}
	
	public Plateau getPlateau() {
		return this.plateau;
	}
	
	public Joueur getJ1() {
		return this.j1;
	}
	
	public Joueur getJ2() {
		return this.j2;
	}
	
	public Joueur getJoueurActif(){
		return this.joueurActif;
	}
	
	public void changeJoueur() {
		if(this.joueurActif==this.j1) {
			this.joueurActif=this.j2;
		}
		else {
			this.joueurActif=this.j1;
		}
	}
	
	//Ajouter condition quand etat=JEUQUITTE
	public void setEtat() {
		Etat etatj1 =null;
		Etat etatj2 = null;
		int i =0;
		while((etatj1==null||etatj2==null)&&i<3) {
			if(plateau.verifierLigne(i)==j1.getCouleur()||plateau.verifierColonne(i)==j1.getCouleur()) {
				etat=Etat.JOUEUR1GAGNE;
				etatj1=etat;
			}
			if(plateau.verifierLigne(i)==j2.getCouleur()||plateau.verifierColonne(i)==j2.getCouleur()) {
				etat=Etat.JOUEUR2GAGNE;
				etatj2=etat;
			}
			if((plateau.verifierDiagonale('p')==j1.getCouleur()||plateau.verifierDiagonale('s')==j1.getCouleur())&&i==0){
				etat=Etat.JOUEUR1GAGNE;
				etatj1=etat;
			}
			if((plateau.verifierDiagonale('p')==j2.getCouleur()||plateau.verifierDiagonale('s')==j2.getCouleur())&&i==0){
				etat=Etat.JOUEUR2GAGNE;
				etatj2=etat;
			}
			i++;
		}
		if(etatj1!=null&&etatj2!=null) {
			etat=Etat.MATCHNUL;
		}
		
		
		if(this.etat==Etat.JEUQUITTE) {
			Termination termOri = new Termination();
			if(termOri.verifier(j1)) {
				etat=Etat.JEUQUITTE;
				termOri.appliquer(j1);
			}
			else if(termOri.verifier(j2)) {
				etat=Etat.JEUQUITTE;
				saisie.finalize();
				termOri.appliquer(j2);
			}
			else {
				etat=Etat.JEUENCOURS;
			}
		}
		
	}
	
	public Etat getEtat(){
		return etat;
	}
	
}
