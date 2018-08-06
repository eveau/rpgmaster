package Applicatif;

import Services.JoueurService;
import Systeme.VerifInstallService;

//normalement c'est celui de la branche dev
//import Service.JoueurService;
//import Service.VerifInstallService;
/**
 * Appel du Menu General. <br/>
 * version Developpement 0.5<br/>
 * Demande et saisit l'entrée de l'utilisateur
 * 
 * @author baboulou
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
