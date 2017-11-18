package pckg;

public class VarianteMinimale extends Variante {

	@Override
	public String effetCarte(Carte carte) {
		String carteValeur=carte.getValeur();
		if (carteValeur=="10") {
			return "ObligeRejouer";}
		else if (carteValeur=="8") {
			return "ChangerCouleur";
		}
		else return  "PasEffet";
		
		
	}

	@Override
	public boolean estPossibleDeJouer(Carte[] carte, Partie P) {
		int i;
		for (i=0;i<carte.length;i++)
		{
			if (carte[i].getSymbole()==P.getTalon().getCarteDessus().getSymbole() || carte[i].getValeur()==P.getTalon().getCarteDessus().getValeur() ||carte[i].getValeur()=="8") 
			//Si une des cartes a le meme symbole que le talon ou la meme valeur , ou si cette carte est un 8
			{
				return true; // le joueur peut jouer
			}
			}
		return false; // le joueur ne peut pas jouer
	}

	@Override
	public boolean estCompatible(Carte carte, Partie P) {
		Carte carteDessusTalon;
		Talon talon = P.getTalon();
		carteDessusTalon = talon.getCarteDessus();
		String carteSymbole= carte.getSymbole();
		String carteDessusTalonSymbole=carteDessusTalon.getSymbole();
		String carteValeur= carte.getValeur();
		String carteDessusTalonValeur=carteDessusTalon.getValeur();
		
		if(carteSymbole==carteDessusTalonSymbole ||carteValeur==carteDessusTalonValeur|| carteValeur=="8" ) {
			return true; // la carte choisie par le joueur est compatible
		}
		else {
			return false;
		}
	}

	/**
	 * 
	 */
	public VarianteMinimale(Partie P) {
		this.carteSpeciale = new Carte[8];
		//this.carteSpeciale[0]=Carte
		this.nbCartes=52;
	}
	
}
