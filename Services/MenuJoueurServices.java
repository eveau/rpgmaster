package Services;

import Entitee.Joueur;

public class MenuJoueurServices {
	// propriétés de classe

	// constructeur sans argument
	public MenuJoueurServices() {

	}

	// getter and setter

	// methodes de classe
	/**
	 * change le mail du joueur
	 *
	 * @param j
	 */
	public static void changerMail(Joueur j)
	{

		final Joueur tmp = JoueurService.recupTotJoueur();
		System.out.println("vérification avant modif");
		final String a = JoueurService.verifmdp((short) 1);
		if (tmp.getIdentifiant().equals(j.getIdentifiant()) && tmp.getMotDePasse().equals(a))
		{
			tmp.setMail(JoueurService.verifMail());
			JoueurService.EcritureFichierJoueur(tmp);
			System.out.println("Mail modifié");
		}
		else
		{
			System.out.println("tu n'es pas correctement authentifié pour cela");
		}
	}

	/**
	 * change l'identifiant du joueur
	 *
	 * @param j
	 */
	public static void changerIdentifiant(Joueur j)
	{
		final Joueur tmp = JoueurService.recupTotJoueur();
		System.out.println("vérification avant modif");
		final String a = JoueurService.verifmdp((short) 1);
		if (tmp.getMotDePasse().equals(a) && tmp.getIdentifiant().equals(j.getIdentifiant()))
		{
			tmp.setIdentifiant(JoueurService.verifIdent());
			JoueurService.EcritureFichierJoueur(tmp);
			System.out.println("Identifiant modifié");
		}
		else
		{
			System.out.println("ne correspond pas au mot de passe");
		}
	}

	/**
	 * change le mot de passe du joueur
	 *
	 * @param j
	 */
	public static void changerMdp(Joueur j)
	{
		final Joueur tmp = JoueurService.recupTotJoueur();
		System.out.println("vérification avant modif");
		String a = JoueurService.verifmdp((short) 2);
		if (tmp.getMotDePasse().equals(a) && tmp.getIdentifiant().equals(j.getIdentifiant()))
		{
			a = JoueurService.verifmdp((short) 3);
			tmp.setMotDePasse(a);
			JoueurService.EcritureFichierJoueur(tmp);
			System.out.println("Mot de passe modifié");
		}
		else
		{
			System.out.println("ne correspond pas à l'ancien mot de passe");
		}
	}
	// override
	// tostring
}
