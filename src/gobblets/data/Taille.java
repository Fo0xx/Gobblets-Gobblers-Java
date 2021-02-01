package gobblets.data;

public enum Taille {
	PETIT('1'){
		@Override
		public boolean recouvre(Taille t){
			boolean retour=false;
			if((int)t.getSymbole()-48<1){
				retour=true;
			}
			return retour;
		}
	},
	MOYEN('2'){
		@Override
		public boolean recouvre(Taille t){
			boolean retour=false;
			if((int)t.getSymbole()-48<2){
				retour=true;
			}
			return retour;
		}
	},
	GRAND('3'){
		@Override
		public boolean recouvre(Taille t){
			boolean retour=false;
			if((int)t.getSymbole()-48<3){
				retour=true;
			}
			return retour;
		}
	};
	
	private final char taille;
	public abstract boolean recouvre(Taille t);
	private Taille(char taille){
		this.taille=taille;
	}
	public char getSymbole(){
		return this.taille;
	}
	public boolean recouvre(Piece p){
		return (int)this.getSymbole()>(int)p.getTaille().getSymbole();
	}
}
