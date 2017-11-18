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

	public Carte choisirCarte() {
		System.out.println("Quelle carte voulez-vous poser?");
		Carte carte = null;
		
		return carte;
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
