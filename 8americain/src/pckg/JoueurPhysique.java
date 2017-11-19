package pckg;
import java.util.Scanner;

public class JoueurPhysique extends Joueur {
	Scanner sc = new Scanner(System.in);
	// ********** Conctructeur ***********
	public JoueurPhysique() {
		super();
		
		System.out.println("Entrez votre nom svp : ");
		String nom = sc.nextLine();
	}

	public int choisirCarte() { // doit renvoyer un int et non une Carte car sinon on crée une nouvelle carte, et on ne peut plus utiliser remove(cartePose) dans jouerTour
		
		//System.out.println("Quelle carte voulez-vous poser?");
		System.out.println("Carte du talon :"+ Partie.getPartie().getTalon().getCarteDessus());
		System.out.println("Vos cartes :");
		int i;
		for(i=0;i<this.cartes.size();i++) {
			System.out.println(this.cartes.get(i));	
		}
		System.out.println("Numéro de la carte choisie ?");
		int numero =sc.nextInt()-1;
		
		
		return numero;
	}

	public void changerFamille() {
		// TODO 
	}

	@Override
	public void DireCarte() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void DireContreCarte() {
		// TODO Auto-generated method stub
		
	}
}
