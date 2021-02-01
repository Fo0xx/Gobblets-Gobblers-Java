package gobblets.data;

import java.util.Random;

import gobblets.interaction.Action;
import gobblets.interaction.Deplacement;
import gobblets.interaction.Placement;

/**
 * La classe <b>JoueurIA Difficile</b> est une classe
 * qui hérite des propriétés de Joueur.
 * Cette classe étant la version Difficile du JoueurIA.
 * Cette classe n'est pas complète.
 * 
 * @author Léo Lefebvre, Valentin Huard
 * @version 1.0
 * @see gobblets.data.JoueurIADifficile
 *
 */

public class JoueurIADifficile extends Joueur {

	
	/**
	 * - t : instancie une taille qui va servir lors de la recherche du plateau.
	 */
    private Taille t;
    
    /**
	 * - random : instancie une variable de classe random pour de futurs utilisations.
	 */
    private Random random = new Random(System.currentTimeMillis());
    
    /**
     * -coinVer : Attribut qui servira à vérifier 
     * si oui ou non il y a une pièce du joueurIA dans un coin.
     */
    private boolean coinVer;
    
    /**
     * Constructeur : Initialise un joueurIA de type Difficile.
     * @param nom le nom du joueur
     * @param cou la couleur du joueur
     */
    public JoueurIADifficile(String nom, Couleur cou){
        super(nom, cou);
        t = null;
    }
    
    /**
	 * Méthode : permettant de déterminer l'action
	 * @param p le plateau du jeu
	 * @return retourne l'action du joueurIA
	 */
    public Action choisirAction(Plateau p) {
        int[] coord = new int[3];
        Action actio = null;
        coord = recherchePhase(p);
        if(t != null){
            actio = new Placement(t,p.getPlateau()[coord[0]][coord[1]]);
        } else {
            actio = new Deplacement(p.getPlateau()[coord[0]][coord[1]],p.getPlateau()[coord[2]][coord[3]]);
        }
        return actio;
    }
    
    /**
     * Méthode : permettant au bot de faire une recherche sur le plateau.
     * @param p plateau du jeu actuel
     * @return les coordonnées générées
     */
    public int[] recherchePhase(Plateau p){
        this.coinVer=false;
        int tab[] = new int[4];
        int[] coin = this.coinVerif(p);
        
        if(p.getPlateau()[1][1].plusGrandePiece()==null||p.getPlateau()[1][1].plusGrandePiece().getTaille()!=Taille.GRAND
        		&&!this.aPiece(p.getPlateau()[1][1].plusGrandePiece())){
			tab = this.phase1a();
		}
		else {
			tab = this.phase1b(p);
		}
        
        if(coinVer&&this.aPiece(p.getPlateau()[1][1].plusGrandePiece())) {
        	tab = this.phase2a(coin, p);
        }
        if(tab==null) {
        	tab = this.phase1b(p);
        }
        //Sinon c'est gagné en diagonale.
        
        
        return tab;
    }
    
    /**
     * Méthode : permettant au bot de vérifier et récupérer
     * si une piece du bot est dans un coin
     * @param p plateau du jeu actuel
     * @return les coordonnées d'une piece trouvée si il y en a une
     */
    public int[] coinVerif(Plateau p) {
    	int coin[] = new int[2];
        
        int i =0;
        int j =0;
        while(i<3&&!coinVer) {
        	j=0;
        	while(j<3&&!coinVer) {
        		if(i%2==0&&j%2==0) {
        			coinVer=this.aPiece(p.getPlateau()[i][j].plusGrandePiece());
        			coin[0]=i;
        			coin[1]=j;
        		}
        		j++;
        	}
        	i++;
        }
        return coin;
    }
    
    /**
     * Méthode : première partie de la phase 1.
     * Si il n'y a pas de pièce au centre, on en place une.
     * @return les coordonnées de la piece a placer au milieu
     */
    public int[] phase1a() {
    	int tab[] = new int[4];
    	tab[0] = 1;
        tab[1] = 1;
        this.t = Taille.GRAND;
        return tab;
    }
    /**
     * Méthode : deuxième partie de la phase 1.
     * Si il y a un centre où il est impossible de poser une piece,
     * on ajoute une piece dans un des quatres coins du plateau aléatoirement.
     * @param p le plateau du jeu actuel
     * @return les coordonnées de la pièce à poser.
     */
    public int[] phase1b(Plateau p) {
    	 int tab[] = new int[4];
    	 int nb = 1 + random.nextInt(5-1);
    	 Piece pieceVerif1 = p.getPlateau()[0][0].plusGrandePiece();
    	 Piece pieceVerif2 = p.getPlateau()[0][2].plusGrandePiece();
    	 Piece pieceVerif3 = p.getPlateau()[2][0].plusGrandePiece();
    	 Piece pieceVerif4 = p.getPlateau()[2][2].plusGrandePiece();
         if(nb==1&&pieceVerif1==null) {
         	tab[0] = 0;
         	tab[1] = 0;
         	this.randomPetiteMoyen();
         }
         else if(nb==2&&pieceVerif2==null){
         	tab[0] = 0;
         	tab[1] = 2;
         	this.randomPetiteMoyen();
         }
         else if(nb==3&&pieceVerif3==null) {
         	tab[0] = 2;
         	tab[1] = 0;
         	this.randomPetiteMoyen();
         }
         else if(nb==4&&pieceVerif4==null) {
         	tab[0] = 2;
         	tab[0] = 2;
         	this.randomPetiteMoyen();
         }
         else {
        	 tab=null;
         }
         return tab;
    }
    
    /**
     * Méthode : première partie de la phase 2.
     * Si il y a 2 pièces liés en diagonales,
     * tentative de poser une piece à la troisième case pour compléter une diagonale.
     * @param tableau le tableau lorsqu'on a vérifier les coins
     * @param p plateau du jeu actuel
     * @return les coordonnées de la pièce à poser.
     */
    public int[] phase2a(int[] tableau, Plateau p) {
    	int tab[] = new int[4];
    	boolean valide;
    	if(tableau[0]==tableau[1]) {
    		if(tableau[0]==0) {
    			tab[0]=2;
    			tab[1]=2;
    		}
    		else {
    			tab[0]=0;
    			tab[1]=0;
    		}
    	}
    	else {
    		if(tableau[0]==0) {
    			tab[0]=2;
    			tab[1]=0;
    		}
    		else {
    			tab[0]=0;
    			tab[1]=2;
    		}
    	}
    	valide = this.aPiece(p.getPlateau()[tab[0]][tab[1]].plusGrandePiece());
    	if(!valide) {
    		tab=null;
    	}
    	return tab;
    }
    

    /**
     * Méthode : Permettant de générer aléatoirement
     * soit une pièce petite, soit une pièce grande.
     */
    public void randomPetiteMoyen() {
    	int choix = 1 + random.nextInt(3-1);
    	if(choix == 1) {
    		this.t=Taille.PETIT;
    	}
    	else {
    		this.t=Taille.MOYEN;
    	}
    }
}
