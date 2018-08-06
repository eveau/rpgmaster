package Applicatif;

import Entitee.Joueur;
import Services.JoueurService;
import Services.MenuJoueurServices;

/**
 * Menu Joueur avec accès à ses infos
 */
public class MenuJoueur {
	// propriétés de classe

	// constructeur sans argument
	public MenuJoueur() {
	}

	// getter and setter

	// methodes de classe
	/**
	 * Menu general du joueur
	 *
	 * @param j
	 */
	public static void menuModifduJoueur(Joueur j)
	{
		String a = "logueoupas";
		final boolean identifie = JoueurService.recupInfoCompteJoueur().isIsidentifie();
		if (identifie)
		{
			a = "1.Changer identifiant 2.changer de mail 3.changer de mot de passe 4.retour au menu général 5.Quitter";
			j.setIdentifiant(JoueurService.recupInfoCompteJoueur().getIdentifiant());
			j.setMail(JoueurService.recupInfoCompteJoueur().getMail());
			j.setMotDePasse(JoueurService.recupInfoCompteJoueur().getMotDePasse());
		}
		else
		{
			a = "1.Se loguer 4.retour au menu général 5.Quitter";
		}

		final String c = Menu.choixTxt(a);
		switch (c)
		{
		case "1":
			if (identifie)
			{
				System.out.println("vers changer identifant");
				MenuJoueurServices.changerIdentifiant(j);
				menuModifduJoueur(j);
			}
			else
			{
				JoueurService.connection();
			}
			break;
		case "2":
			if (identifie)
			{
				System.out.println("vers changer de mail");
				MenuJoueurServices.changerMail(j);
			}
			menuModifduJoueur(j);
			break;
		case "3":
			if (identifie)
			{
				System.out.println("vers changer de mot de passe");
				MenuJoueurServices.changerMdp(j);
			}
			menuModifduJoueur(j);
			break;
		case "4":
			Menu.general(j);
			break;
		case "5":
			Menu.quitterJeu(j);
			break;
		default:
			System.out.println("erreur de saisie, choisir un nombre");
			menuModifduJoueur(j);
		}
	}
	// override

	// tostring
}
