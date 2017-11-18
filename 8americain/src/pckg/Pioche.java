package pckg;

/**
 * 
 */

/**
 * @author charl
 *
 */

//import java.util.ArrayList;
import java.util.Random;


public class Pioche extends PorteurCarte {
	
	/**
	 * 
	 */
	public Pioche(Partie P) {
		//int i=0;
		//nb cartes definie dans la variante
		this.nbCartes=P.getVariantePartie().getNbCartes();
	    //this.cartes=new Carte[this.nbCartes];
	    String[] symboles=new String[]{"TREFLE","COEUR","CARREAU","PIQUE"};
		String[] valeurs=new String[]{"1","2","3","4","5","6","7","8","9","10","VALET","DAME","ROI"};

			for(String symbole : symboles) {
				
				for(String valeur : valeurs){
					Carte carte = new Carte(valeur,symbole);
					this.cartes.add(carte); // on crée un jeu de cartes dont le nombre de cartes dépend de la variante
					//i++;
					}
			}
		
		}

	public void piocher() {
		
	}
	
	public void melanger() {
		
		int place;
		int i,j;
		
		for (j=0;j<5;j++) { // on répète 5 fois pour un meilleur melange
			for (i=0;i<this.nbCartes;i++) {
		
				Random r = new Random();
				place = 0 + r.nextInt(this.nbCartes - 1);// on choisit une place aleatoirement dans le paquet 
				// on échange les cartes
				Carte c=this.cartes.get(place); // on met dans la référence c la carte qui est la place "place"
				this.cartes.set(place, this.cartes.get(i)); // on met à la position "place" la carte qui est à la position i
				this.cartes.set(i,c);// on met à la position "i" la carte qui est reférencée par c
		
			
			}
		}
		
		
	}
	
	public void distribuer(Partie P) {
		int nbJoueurs= P.getNbJoueursVirtuels()+1;
		int tour=0;
		int i;
		while (tour<8) // on distribue 8 cartes chacuns
		{
			for (i=0;i<nbJoueurs;i++) {
				
			P.getJoueur()[i].getCartes().add(P.getPioche().getCartes().get(P.getPioche().getNbCartes()-1)); // on ajoute une carte dans le jeu du joueur i : celle qui est au dessus de la pioche
			P.getJoueur()[i].setNbCartes(P.getJoueur()[i].getNbCartes()+1); // on enleve une carte à la pioche

			
			P.getPioche().getCartes().remove(P.getPioche().getNbCartes()-1); // on supprime cette carte de la pioche

			// la carte du dessus de la pioche va dans le jeu de carte du joueur "i" au tour numéro "tour"
			P.getPioche().setNbCartes(P.getPioche().getNbCartes()-1); // on enleve une carte à la pioche
			
			}
			tour ++;
			
			
		}
		System.out.println(P.getJoueur()[0].getCartes().get(0));		//TEST
		System.out.println(P.getJoueur()[0].getNbCartes());		//TEST

		System.out.println(P.getPioche().getNbCartes());		//TEST

		
	}

}
