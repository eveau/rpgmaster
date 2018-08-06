package Applicatif;

import Entitee.Joueur;
import Services.Persoservice;

/**
 * @author baboulou
 * @param Menus
 *            du perso <br/>
 *            version Developpement 0.5<br/>
 */
public class MenuPerso {
	// propriétés de classe

	// constructeur sans argument
	public MenuPerso() {

	}

	// getter and setter

	// methodes de classe
	/**
	 * Menu de Creation de Personnage
	 */
	public static void creationPersoMenu(Joueur j)
	{
		final String c = Menu.choixTxt("1.Création d'un perso  2.Charger un perso 3.Modifier un perso 4.Sauvegarder le perso 5.Lancer la partie 6. Quitter le jeu  7.retour menu general");
		switch (c)
		{
		case "1":
			Persoservice.creationPerso(j);
			break;
		case "2":
			System.out.println("vers PersoService.charger1Perso ();");
			creationPersoMenu(j);
			break;
		case "3":
			System.out.println("vers PersoService.modifier1Perso ();");
			creationPersoMenu(j);
			break;
		case "4":
			System.out.println("vers PersoService.save1Perso ();");
			creationPersoMenu(j);
			break;
		case "5":
			System.out.println("vers PartieService.lancerPartie()");
			creationPersoMenu(j);
			break;
		case "6":
			Menu.quitterJeu(j);
			break;
		case "7":
			Menu.general(j);
			break;
		default:
			System.out.println("erreur de saisie, choisir un nombre");
			creationPersoMenu(j);
		}
	}
	// override

	// tostring
}
