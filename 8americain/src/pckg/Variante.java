package pckg;

import java.util.ArrayList;

/**
 * @author charlene
 *
 */
public abstract class Variante {

	/**
	 * @param args
	 */
	protected Carte[] carteSpeciale;
	protected int nbCartes;
	/**
	 * @return the nbCartes
	 */
	public int getNbCartes() {
		return nbCartes;
	}

	/**
	 * @param nbCartes the nbCartes to set
	 */
	public void setNbCartes(int nbCartes) {
		this.nbCartes = nbCartes;
	}

	public abstract String effetCarte(Carte carte); 
	
	public static boolean estCompatible(Carte carte, Partie P) {
	Carte carteDessusTalon;
	Talon talon = P.getTalon();
	carteDessusTalon = talon.getCarteDessus();
	String carteSymbole= carte.getSymbole();
	String carteDessusTalonSymbole=carteDessusTalon.getSymbole();
	String carteValeur= carte.getValeur();
	String carteDessusTalonValeur=carteDessusTalon.getValeur();
	
	if(carteSymbole==carteDessusTalonSymbole ||carteValeur==carteDessusTalonValeur ) {
		return true;
	}
	else {
		return false;
	}
		
	}

	
	/**
	 * @return the carteSpeciale
	 */
	public Carte[] getCarteSpeciale() {
		return carteSpeciale;
	}

	/**
	 * @param carteSpeciale the carteSpeciale to set
	 */
	public void setCarteSpeciale(Carte[] carteSpeciale) {
		this.carteSpeciale = carteSpeciale;
	}

	public static void main(String[] args) {
		

	}

	public static boolean estPossibleDeJouer(ArrayList<Carte> cartes, Partie p) {
		// TODO Auto-generated method stub
		return false;
	}

}

