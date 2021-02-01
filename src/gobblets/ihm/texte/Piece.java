package gobblets.ihm.texte;

public class Piece {
	protected gobblets.data.Piece contenu;
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_WHITE = "\u001B[37m";
	
	public Piece(gobblets.data.Piece piece) {
		this.contenu=piece;
	}
	
	public String[] getRepresentationTextuelle() {
		String[] pieceTab = new String[2];
		
		if(contenu == null) {
			pieceTab[0] = "";
			pieceTab[1] = " ";
			return pieceTab;
		}
		else {
			switch(contenu.getCouleur()) {
				case WHITE : 
					pieceTab[0] = ANSI_WHITE;
					break;
				case ROUGE :
					pieceTab[0] = ANSI_RED;
					break;
				case BLEU  :
					pieceTab[0] = ANSI_BLUE;
					break;
				case JAUNE  :
					pieceTab[0] = ANSI_YELLOW;
					break;
				case VERT :
					pieceTab[0] = ANSI_GREEN;
					break;
				default :
					pieceTab[0] = ANSI_WHITE;
			}
			
			switch(contenu.getTaille()) {
				case PETIT : 
					pieceTab[1] = "."+ANSI_RESET;
					break;
				case MOYEN :
					pieceTab[1] = "o"+ANSI_RESET;
					break;
				case GRAND :
					pieceTab[1] = "O"+ANSI_RESET;
					break;
				default :
					pieceTab[1] = " "+ANSI_RESET;
			}
			return pieceTab;
		}
	}
}
