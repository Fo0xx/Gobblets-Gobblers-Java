package gobblets.data;

public class Piece {
	private Taille tail;
	private Couleur cou;
	public Piece(Taille tail){
		this.tail=tail;
	}
	public Taille getTaille(){
		return this.tail;
	}
	public Couleur getCouleur(){
		return this.cou;
	}
	public void setCouleur(Couleur cou){
		this.cou=cou;
	}
	public boolean appartienA(Joueur j){
		return j.getCouleur()==this.cou;
	}
}
