package gobblets.data;

public enum Couleur {
	ROUGE(255, 0, 0, "FF0000"){
		@Override
		public String toString(){
			return "rouge";
		}
	},
	VERT(0,255,0, "00FF00"){
		@Override
		public String toString(){
			return "vert";
		}
		
	},
	BLEU(0,0,255, "0000FF"){
		@Override
		public String toString(){
			return "bleu";
		}
	},
	JAUNE(255,255,0, "FFFF00"){
		@Override
		public String toString(){
			return "jaune";
		}
		
	},
	WHITE(255,255,255, "FFFFFF"){
		@Override
		public String toString(){
			return "blanc";
		}
		
	};
	
	private final int r;
	private final int g;
	private final int b;
	private final String code;
	
	private Couleur(int r, int g, int b, String code){
		this.r=r;
		this.g=g;
		this.b=b;
		this.code=code;
	}
	
	public int getR(){
		return this.r;
	}
	public int getG(){
		return this.g;
	}
	public int getB(){
		return this.b;
	}
	public String getCode(){
		return this.code;
	}
	
	
}
