package pckg;

import pckg.comportement.AucunEffet;
import pckg.comportement.Effet;

/**
 * 
 */

/**
 * @author Robin et Charlène
 *
 */
public class Carte {

	//***********Accesseurs***********
	private Effet effet = new AucunEffet();
	private String symbole;
	private String valeur;
	
	
	//**********Constructeurs********
	public Carte(String valeur, String symbole) {
		this.symbole=symbole;
		this.valeur=valeur;
	}	
	//**********Méthodes***********
public void appliquerEffet() {
		//On va appeler la fonction effet qui est associée à l'interface effet, 
		//et dont le comportement diffèrera en fonction de la carte
		effet.effet();
	}
	/**
	 * @return the carteSpeciale
	 */
	/*public boolean isCarteSpeciale(Partie P) {
		
		int i;
		for (i=0;i<P.getVariantePartie().getCarteSpeciale().length;i++) {
			if (this==P.getVariantePartie().getCarteSpeciale()[i]) {
				this.setCarteSpeciale(true);
				return this.carteSpeciale;
			}
		}
		this.setCarteSpeciale(false);
		return this.carteSpeciale;
			}
	
	
	public void setCarteSpeciale(boolean carteSpeciale) {
		this.carteSpeciale = carteSpeciale;
	}
	*/
	
	/**
	 * @return the symbole
	 */
	public String getSymbole() {
		return this.symbole;
	}

	/**
	 * @param symbole the symbole to set
	 */
	public void setSymbole(String symbole) {
		this.symbole = symbole;
	}

	/**
	 * @return the valeur
	 */
	public String getValeur() {
		return this.valeur;
	}

	/**
	 * @param valeur the valeur to set
	 */
	public void setValeur(String valeur) {
		this.valeur = valeur;
	}

	public String toString () {
	return valeur + " de " + symbole;
	
	}

}
