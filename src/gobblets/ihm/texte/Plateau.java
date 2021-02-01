package gobblets.ihm.texte;

import java.util.ArrayList;

public class Plateau {
	private gobblets.data.Plateau plateau;
	private ArrayList<gobblets.ihm.texte.Case> plateauAffichable;
	
	public Plateau(gobblets.data.Plateau pla){
		this.plateau = pla;
		this.plateauAffichable = new ArrayList<gobblets.ihm.texte.Case>();
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				Case cas = new gobblets.ihm.texte.Case(plateau.getPlateau()[i][j]);
				plateauAffichable.add(cas);
			}
		}
	}
	
	public String[] getRepresentationTextuelle() {
		String[] tabPla = new String[9];
		
		for(int i=0; i<9; i++) {
			gobblets.ihm.texte.Case plateauAffich = plateauAffichable.get(i);
			tabPla[i] = plateauAffich.getRepresentationTextuelle()[0]+plateauAffich.getRepresentationTextuelle()[1]+plateauAffich.getRepresentationTextuelle()[2];
		}
		
		return tabPla;
	}
	
	
}
