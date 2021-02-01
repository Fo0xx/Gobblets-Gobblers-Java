package gobblets.logic;

import gobblets.ihm.Erreur;

public class CaseBloqueeException extends Exception {
	
private static final long serialVersionUID = 123L;
	
	private Erreur erreur;
	
	public CaseBloqueeException(){
		super("Case bloquée");
	}
	
	public CaseBloqueeException(String texte) {
		super(texte);
	}
	
	public CaseBloqueeException(Throwable thro) {
		super(thro);
	}
	
	public CaseBloqueeException(String texte, Throwable thro) {
		super(texte, thro);
	}
	
	public CaseBloqueeException(String texte, Throwable thro, boolean bol1, boolean bol2) {
		super(texte, thro, bol1, bol2);
	}
	
	public CaseBloqueeException(Erreur erreur) {
		this.erreur=erreur;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public Erreur getErreur() {
		return this.erreur;
	}
}
