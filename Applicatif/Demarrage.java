package Applicatif;

import Services.JoueurService;
import Systeme.VerifInstallService;

//normalement c'est celui de la branche dev
//import Service.JoueurService;
//import Service.VerifInstallService;
/**
 * @author baboulou
 * @param Appel
 *            du Menu General. <br/>
 *            Version Developpement<br/>
 *            Demande et saisit l'entrée de l'utilisateur
 */
public class Demarrage {
	// propriétés de classe

	// constructeur sans argument
	public Demarrage() {

	}

	public static void main(String[] args)
	{
		System.out.println("Démarrage, jeu RPG");
		VerifInstallService.verifInitRep();
		JoueurService.connection();

	}

	// getter and setter

	// methodes de classe

	// override

	// tostring
}
