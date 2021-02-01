package gobblets.data;

import java.util.ArrayList;

public class Plateau {
	private ArrayList<Case> plateau;
	private ArrayList<Piece> maisonJoueur1;
	private ArrayList<Piece> maisonJoueur2;
	
	private Plateau() {
		this.plateau = new ArrayList<Case>();
		this.maisonJoueur1 = new ArrayList<Piece>();
		this.maisonJoueur2 = new ArrayList<Piece>();
	}
	
	public static Plateau initPlateau() {
		Plateau p = new Plateau();
		for(int j=0; j<9; j++) {
			p.plateau.add(new Case());
		}
		p.plateau.add(new Case());
		for(int i =0; i<2; i++) {
			p.maisonJoueur1.add(new Piece(Taille.PETIT));
			p.maisonJoueur2.add(new Piece(Taille.PETIT));
			p.maisonJoueur1.add(new Piece(Taille.MOYEN));
			p.maisonJoueur2.add(new Piece(Taille.MOYEN));
			p.maisonJoueur1.add(new Piece(Taille.GRAND));
			p.maisonJoueur2.add(new Piece(Taille.GRAND));
		}
		return p;
	}
	
	public Case[][] getPlateau() {
		Case[][] p = new Case[3][3];
		int ind = 0;
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				p[i][j] = plateau.get(ind);
				ind++;
			}
		}
		return p;
	}
	
	private Case[] getLigne(int ligne) {
		Case[] caseLigne = new Case[3];
		Case[][] p = this.getPlateau();
		for(int i=0; i<3; i++) {
			caseLigne[i]=p[ligne][i];
		}
		return caseLigne;
	}
	
	private Case[] getColonne(int colonne) {
		Case[] caseColonne = new Case[3];
		Case[][] p = this.getPlateau();
		for(int i=0; i<3; i++) {
			caseColonne[i]=p[i][colonne];
		}
		return caseColonne;
	}
	
	private Case[] getDiagonalePrincipale() {
		Case[] caseDiagPrin = new Case[3];
		Case[][] p = this.getPlateau();
		caseDiagPrin[0]=p[0][0];
		caseDiagPrin[1]=p[1][1];
		caseDiagPrin[2]=p[2][2];
		return caseDiagPrin;
	}
	
	private Case[] getDiagonaleSecondaire() {
		Case[] caseDiagSec = new Case[3];
		Case[][] p = this.getPlateau();
		caseDiagSec[0]=p[0][2];
		caseDiagSec[1]=p[1][1];
		caseDiagSec[2]=p[2][0];
		return caseDiagSec;
	}
	
	public ArrayList<Piece> getMaisonJoueur1(){
		return this.maisonJoueur1;
	}
	
	public ArrayList<Piece> getMaisonJoueur2(){
		return this.maisonJoueur2;
	}
	
	public void placePiece(Piece pie, int lign, int col) {
		this.getPlateau()[lign][col].placePiece(pie);
	}
	
	public Piece enlevePiece(int lign, int col) {
		return this.getPlateau()[lign][col].enlevePiece();
	}
	
	public Piece plusGrandePiece(int lign, int col) {
		return this.getPlateau()[lign][col].plusGrandePiece();
	}
	
	public Couleur verifierLigne(int lign) {
		Couleur retour = null;
		if(this.getLigne(lign)[0].plusGrandePiece()!=null&&this.getLigne(lign)[1].plusGrandePiece()!=null&&this.getLigne(lign)[2].plusGrandePiece()!=null){
			if(this.getLigne(lign)[0].plusGrandePiece().getCouleur()==this.getLigne(lign)[1].plusGrandePiece().getCouleur()&&this.getLigne(lign)[0].plusGrandePiece().getCouleur()==this.getLigne(lign)[2].plusGrandePiece().getCouleur()) {
				retour= this.getLigne(lign)[0].plusGrandePiece().getCouleur();
			}
		}
		return retour;
	}
	
	public Couleur verifierColonne(int col) {
		Couleur retour = null;
		if(this.getColonne(col)[0].plusGrandePiece()!=null&&this.getColonne(col)[1].plusGrandePiece()!=null&&this.getColonne(col)[2].plusGrandePiece()!=null){
			if(this.getColonne(col)[0].plusGrandePiece().getCouleur()==this.getColonne(col)[1].plusGrandePiece().getCouleur()&&this.getColonne(col)[0].plusGrandePiece().getCouleur()==this.getColonne(col)[2].plusGrandePiece().getCouleur()) {
				retour = this.getColonne(col)[0].plusGrandePiece().getCouleur();
			}
		}
		return retour;
	}
	
	public Couleur verifierDiagonale(char TypeDiag) {
		Couleur retour = null;
		if(TypeDiag=='p'&&this.getDiagonalePrincipale()[0].plusGrandePiece()!=null&&this.getDiagonalePrincipale()[1].plusGrandePiece()!=null&&this.getDiagonalePrincipale()[2].plusGrandePiece()!=null) {
			if(this.getDiagonalePrincipale()[0].plusGrandePiece().getCouleur()==this.getDiagonalePrincipale()[1].plusGrandePiece().getCouleur()&&this.getDiagonalePrincipale()[0].plusGrandePiece().getCouleur()==this.getDiagonalePrincipale()[2].plusGrandePiece().getCouleur()) {
				retour=this.getDiagonalePrincipale()[0].plusGrandePiece().getCouleur();
			}
		}
		else if(TypeDiag=='s'&&this.getDiagonaleSecondaire()[0].plusGrandePiece()!=null&&this.getDiagonaleSecondaire()[1].plusGrandePiece()!=null&&this.getDiagonaleSecondaire()[2].plusGrandePiece()!=null) {
			if(this.getDiagonaleSecondaire()[0].plusGrandePiece().getCouleur()==this.getDiagonaleSecondaire()[1].plusGrandePiece().getCouleur()&&this.getDiagonaleSecondaire()[0].plusGrandePiece().getCouleur()==this.getDiagonaleSecondaire()[2].plusGrandePiece().getCouleur()) {
				retour=this.getDiagonaleSecondaire()[0].plusGrandePiece().getCouleur();
			}
		}
		return retour;
	}
}
