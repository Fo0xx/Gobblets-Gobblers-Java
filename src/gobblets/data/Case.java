package gobblets.data;

public class Case {
	private Piece grande;
	private Piece moyenne;
	private Piece petite;
	
	public Case(){
		this.grande= null;
		this.moyenne= null;
		this.petite = null;
	}
	
	public boolean acceptePiece(Taille t){
		Piece p = plusGrandePiece();
		boolean test2=false;
		if(p!=null){
			test2 =t.recouvre(p.getTaille());
		}
		
		return p==null||test2;
	}
	public Piece plusGrandePiece(){
		Piece retour;
		if(this.grande==null&&this.moyenne==null&&this.petite==null){
			retour=null;
		}
		else if(this.grande==null&&this.moyenne==null){
			retour=this.petite;
		}
		else if(this.grande==null){
			retour=this.moyenne;
		}
		else{
			retour=this.grande;
		}
		return retour;
	}
	public Piece enlevePiece(){
		Piece pie = this.plusGrandePiece();
		if(pie.getTaille()==Taille.PETIT){
			this.petite=null;
		}
		else if(pie.getTaille()==Taille.MOYEN){
			this.moyenne=null;
		}
		else if(pie.getTaille()==Taille.GRAND){
			this.grande=null;
		}
		return pie;
	}
	public void placePiece(Piece p){
		boolean test = this.acceptePiece(p.getTaille());
		if(test){
			if(p.getTaille()==Taille.PETIT){
				this.petite=p;
			}
			else if(p.getTaille()==Taille.MOYEN){
				this.moyenne=p;
			}
			else if(p.getTaille()==Taille.GRAND){
				this.grande=p;
			}
		}
	}
	public String toString(){
		String retour = "La case contient ";
		if(this.petite!=null){
			retour=retour+"une petite, ";
		}
		if(this.moyenne!=null){
			retour=retour+"une moyenne, ";
		}
		if(this.grande!=null){
			retour=retour+"une grande";
		}
		if(this.petite==null&&this.moyenne==null&&this.grande==null){
			retour=retour+"rien.";
		}
		return retour;
	}
}
