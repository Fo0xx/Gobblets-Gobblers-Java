package gobblets.logic;

import gobblets.ihm.Erreur;

public class PiecePasDisponibleException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Erreur erreur;
	
	public PiecePasDisponibleException(){
		super("piece non disponible");
	}
	
	public PiecePasDisponibleException(String texte) {
		super(texte);
	}
	
	public PiecePasDisponibleException(Throwable thro) {
		super(thro);
	}
	
	public PiecePasDisponibleException(String texte, Throwable thro) {
		super(texte, thro);
	}
	
	public PiecePasDisponibleException(String texte, Throwable thro, boolean bol1, boolean bol2) {
		super(texte, thro, bol1, bol2);
	}
	
	public PiecePasDisponibleException(Erreur erreur) {
		this.erreur=erreur;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public Erreur getErreur() {
		return this.erreur;
	}
	
}
