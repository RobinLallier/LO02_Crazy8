package pckg;

public class JoueurVirtuel extends Joueur{

	//*********Constructeur**********
	public JoueurVirtuel() {
		super();
		setName("Joueur" + getNumero());
	}
	
	
	public void changerFamille() {
		// TODO Auto-generated method stub
		
	}

	
	public Carte choisirCarte() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void DireCarte() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void DireContreCarte() {
		// TODO Auto-generated method stub
		
	}

	/*public void main(String[] args) {
		JoueurVirtuel joueur = new JoueurVirtuel();
		System.out.println(joueur.getName());
	}*/
}
