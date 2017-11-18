package pckg;

import java.util.ArrayList;

/**
 * Joueur est la classe qui représente les participants au jeu, qu'ils soient physiques ou virtuels.
 * Il ne sera pas possible de créer un joueur dont le type n'est pas précisé dans le jeu
 * @author Robin
 * @see JoueurVirtuel 
 * @see JoueurPhysique
 */
public abstract class Joueur extends PorteurCarte {
	//**********attributs**************
	private String name ;
	private int classement, numero ; 
	private static int donneurNum = 1;
	
	//**********Constructeur************
/**
 * le Constructeur de Joueur ne doit pas être utilisé directement, il simplifie le code de ses classes filles.
 */
	public Joueur() {
		/*Permet de donner à chaque nouvelle instance de 
		joueur un nouveau numéro */
		this.numero = donneurNum;
		donneurNum++;
	}
	//********** Getter et Setters **********
	/**
	 * Accesseur du classement.
	 * @return la place à laquelle un joueur a fini
	 */
	public int getClassement() {
		return this.classement;
	}
	/**
	 * Accesseur du numéro
	 * @return le numéro du joueur, utilisé par la partie pour déterminer les tours de jeu.
	 * @see Partie
	 */
	public int getNumero() {
		return this.numero;
	}
	/**
	 * Accesseur du nom.
	 * @return le nom d'un joueur.
	 */
	public String getName() {
		return this.name;
	}
	//Pas de setter pour Numero, on ne doit pas pouvoir y toucher une fois instancié
	/**
	 * Mutateur du classement, détermine la place à laquelle un joueur finit.
	 * @param classe
	 */
	public void setName(String name) {
		this.name = name;
	}
	public void setClassement(int classe) {
		this.classement = classe;
	}
	
	
	/**
	 * Le corps même de cette classe, jouerTour permet à un joueur physique ou virtuel de
	 * choisir une carte dans son jeu et la poser sur le talon.
	 * @param P
	 */
	public void jouerTour(Partie p) {
	//1. on vérifie si le joueur peut jouer avec les cartes qu'il a dans la main
		if ( Variante.estPossibleDeJouer(this.cartes, p)) {
	//2.1. Le joueur choisit la carte qu'il désire poser sur le talon.
			System.out.println("Choisissez la carte que vous souhaitez jouer");
			Carte cartePose = choisirCarte();
	//3.1. Si le joueur choisit une carte qu'il ne peut pas jouer, 
		// il rentre dans une boucle jusqu'à ce qu'il choisisse une bonne carte
			while  (! Variante.estCompatible(cartePose, p)) {
				System.out.println("Cette carte ne peut être jouée, choisissez en une autre");
				cartePose = choisirCarte();
			}
	//4.1 Le joueur pose la carte choisie sur le talon.
			p.getTalon().setCarteDessus(cartePose);
	//5.1 Le joueur perd la carte qu'il a posée de sa main
			cartes.remove(cartePose);
		}
	//2.2. Le joueur ne peut jouer aucune carte, donc il pioche.
		else {
			System.out.println("Vous ne pouvez pas jouer, vous piochez.");
			p.getPioche().piocher();
		}
	}
	
	
	public abstract void changerFamille();
	
	public abstract Carte choisirCarte();
	public abstract void DireCarte();
	public abstract void DireContreCarte();
}
	

