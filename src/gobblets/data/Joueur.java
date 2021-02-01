package gobblets.data;

import java.util.ArrayList;

import gobblets.interaction.Action;

public abstract class Joueur {
	private final String nom;
	private Couleur cou;
	private ArrayList<Piece> pieces;
	
	public Joueur(String nom, Couleur cou) {
		this.nom=nom;
		this.cou=cou;
		this.pieces = new ArrayList<Piece>();
	}
	
	public ArrayList<Piece> getPieces(){
		return this.pieces;
	}
	
	public void setPieces(ArrayList<Piece> maison) {
		for(int i=0; i<maison.size(); i++) {
			maison.get(i).setCouleur(this.getCouleur());
		}
		this.pieces=maison;
	}
	
	public void ajoutePiece(Piece pie) {
		if(this.aPiece(pie)) {
			pieces.add(pie);
		}
	}
	
	public boolean aPiece(Piece pie) {
		if(pie==null) {
			return false;
		}
		else {
			return pie.getCouleur()==this.getCouleur();
		}
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public Couleur getCouleur() {
		return this.cou;
	}
	
	abstract public Action choisirAction(Plateau p);
	
	public Piece enlevePiece(Taille t) {
		int i=0;
		boolean stop = false;
		Piece pie = null;
		while(!stop&&i<this.pieces.size()) {
			if(this.pieces.get(i).getTaille()==t) {
				pie=this.pieces.get(i);
				this.pieces.remove(i);
				stop = true;
			}
			i++;
		}
		return pie;
	}
	
	public boolean aPieceDeTaille(Taille t) {
		boolean retour=false;
		int i=0;
		while(retour==false&&i<this.pieces.size()) {
			if(this.pieces.get(i).getTaille()==t) {
				retour=true;
			}
			i++;
		}
		return retour;
	}
}
