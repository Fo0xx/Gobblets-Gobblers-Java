package gobblets.ihm.texte;

public class Case {
	protected gobblets.data.Case contenu;
	
	public Case(gobblets.data.Case contenu) {
		this.contenu=contenu;
	}
	
	public String[] getRepresentationTextuelle() {
		String[] tabCase = new String[3];
		gobblets.ihm.texte.Piece pieceRep = new gobblets.ihm.texte.Piece(contenu.plusGrandePiece());
		
		tabCase[0] = "|";
		tabCase[1] = pieceRep.getRepresentationTextuelle()[0]+pieceRep.getRepresentationTextuelle()[1];
		tabCase[2] = "|";
		
		return tabCase;
	}

}
