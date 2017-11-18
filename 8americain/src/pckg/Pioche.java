package pckg;

import java.util.ArrayList;
import java.util.Random;

/**
 * Pioche est la classe qui représente la pioche. Elle permet de mélanger le paquet de cartes, 
 * de distribuer des cartes aléatoirement aux joueurs, et aux joueurs de piocher. 
 * Elle hérite de PorteurCarte qui définit les collections de cartes.
 * @author Robin & Charlène
 * @see PorteurCarte
 */
public class Pioche extends PorteurCarte {
	
	/**
	 * Constructeur de la classe Pioche, il permet de créer le paquet de cartes. Chaque carte appartient à une famille et a une valeur,
	 * et chaque carte est unique.
	 * @see Variante
	 */
	public Pioche(Partie P) {
		//nb cartes definie dans la variante
		this.nbCartes=P.getVariantePartie().getNbCartes();
	    //this.cartes=new Carte[this.nbCartes];
	    String[] symboles=new String[]{"TREFLE","COEUR","CARREAU","PIQUE"};
		String[] valeurs=new String[]{"1","2","3","4","5","6","7","8","9","10","VALET","DAME","ROI"};

			for(String symbole : symboles) {
				
				for(String valeur : valeurs){
					Carte carte = new Carte(valeur,symbole);
					this.cartes.add(carte); // on crée un jeu de cartes dont le nombre de cartes dépend de la variante
					}
			}
		
		}

	/**
	 * Méthode permettant à un joueur de piocher une carte dans la pioche. 
	 * @param cartes donne la main du joueur, pour y ajouter une carte
	 * @param nombrePioche indique combien de cartes le joueur doit piocher
	 * @see Joueur
	 */
	public void piocher(ArrayList<Carte> cartes, int nombrePioche) {
		//la boucle tourne autant de fois que le joueur doit piocher
		for (int i=0;i<=nombrePioche;i++) {
			//Ajoute aux cartes du joueur la dernière carte de la pioche
			cartes.add(this.cartes.get(this.cartes.size()));
			//Retire cette carte de la pioche
			this.cartes.remove(this.cartes.size());
		}
		System.out.println("Le joueur a pioché");
	}
	
	public void melanger() {
		
		int place;
		int i,j;
		
		for (j=0;j<5;j++) { // on répète 5 fois pour un meilleur melange
			//je suis pas sûr que ça soit nécessaire, ici c'est fait au hasard!
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
