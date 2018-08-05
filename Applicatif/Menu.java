package Applicatif;

import java.io.File;
import java.util.InputMismatchException;
import java.util.Scanner;

import Commun.Constante;
import Entitee.Joueur;
import Services.JoueurService;

/**
 * @author baboulou
 * @param Menus
 *            du jeu<br/>
 *            version de Testing<br/>
 */
public class Menu {
	// propriétés de classe

	// constructeur sans argument
	public Menu() {

	}

	// getter and setter

	// methodes de classe
	/**
	 * Accès au Menu d'accueil générale
	 */
	public static void general(Joueur j)
	{
		// DEV a confirmer Pour le nouveau menu à jour
		/*
		 * final String a = JoueurService.recupInfoCompteJoueur().isIsidentifie() ? "1.Se deloguer 2.Modifier son compte Joueur 3.lancer le jeu 4.Quitter" :
		 * "1.Se loguer  4.Quitter";
		 */
		// final Joueur j = new Joueur();
		String a = "logueoupas";
		if (JoueurService.recupInfoCompteJoueur().isIsidentifie())
		{
			// a dev - le joueur est logué
			a = "1.Se deloguer 2.Modifier son compte Joueur 3.lancer le jeu 4.Quitter 5.isfichierJoueurExist";

			j.setIdentifiant(JoueurService.recupInfoCompteJoueur().getIdentifiant());
			j.setMail(JoueurService.recupInfoCompteJoueur().getMail());
			j.setMotDePasse(JoueurService.recupInfoCompteJoueur().getMotDePasse());
		}
		else
		{
			a = "1.Se loguer  4.Quitter 5.isfichierJoueurExist";
		}

		final short c = choixNb(a);
		switch (c)
		{
		case 1:
			if (JoueurService.recupInfoCompteJoueur().isIsidentifie())
			{
				JoueurService.logoff(j);
				general(j);
			}
			else
			{
				JoueurService.connection();
			}
			break;
		case 2:
			System.out.println("vers Modifier son compte Joueur");
			general(j);
			break;
		case 3:
			lancerJeu(j);
			break;
		case 4:
			quitterJeu(j);
			break;
		case 5:
			ifechier();
			break;
		default:
			System.out.println("erreur de saisie, choisir un nombre");
			general(j);
		}
	}

	/**
	 * Lancer le jeu
	 */
	public static void lancerJeu(Joueur j)
	{
		final short c = choixNb("1.Nouvelle partie 2.Continuer 3.Charger partie 4.Sauvegarder 5.quitter Partie 6. Quitter le jeu  7.retour menu general");
		switch (c)
		{
		case 1:
			nouvellePartie(j);
			break;
		case 2:
			System.out.println("vers PartieService.continuerPartie();");
			lancerJeu(j);
			break;
		case 3:
			System.out.println("vers PartieService.chargerPartie()");
			lancerJeu(j);
			break;
		case 4:
			System.out.println("vers PartieService.sauvegarderPartie()");
			lancerJeu(j);
			break;
		case 5:
			System.out.println("vers PartieService.quitterPartie()");
			lancerJeu(j);
			break;
		case 6:
			quitterJeu(j);
			break;
		case 7:
			general(j);
			break;
		default:
			System.out.println("erreur de saisie, choisir un nombre");
			lancerJeu(j);
		}
	}

	/**
	 * Nouvelle Partie,Creation de Perso +création de fichier partie
	 */
	public static void nouvellePartie(Joueur j)
	{
		final short c = choixNb("1.Création d'un perso  2.???  5.Lancer la partie 6. Quitter le jeu  7.retour menu general");
		switch (c)
		{
		case 1:
			MenuPerso.creationPersoMenu(j);
			break;
		case 2:
			System.out.println("vers ???");
			nouvellePartie(j);
			break;
		case 5:
			System.out.println("vers PartieService.lancerPartie()");
			nouvellePartie(j);
			break;
		case 6:
			quitterJeu(j);
			break;
		case 7:
			general(j);
			break;
		default:
			System.out.println("erreur de saisie, choisir un nombre");
			nouvellePartie(j);
		}
	}

	/**
	 * Saisie d'un texte
	 */
	public static String choixTxt(String txt)
	{
		// dev voir ce qui allege le mieux pour sc.close
		final Scanner sc = new Scanner(System.in);
		System.out.println(txt);
		// pour dev tester un return sc.nextLine();
		String choix2 = "aé";
		choix2 = sc.nextLine();
		return choix2;
	}

	/**
	 * Saisie d'un nombre
	 */
	public static short choixNb(String txt)
	{
		// bug si saisie non numérique solved , ne forcer que du String in fine ?
		final Scanner sc = new Scanner(System.in);
		System.out.println(txt);
		short choix = -10;
		// choix = (Integer.toString(choix).matches("^.*[^0-9 ].*$")) ? choix :-6;
		// final boolean isNumero = (Integer.toString(choix).matches("^.*[^0-9].*$"));
		// if (!isNumero)
		// {
		// Constante.LOGJoueurService.info("erreur de saisie \t saisir que des
		// chiffres lié au menu");
		// choix = -6;
		// }
		try
		{
			choix = sc.nextShort();
		}
		catch (final InputMismatchException e)
		{
			Constante.LOGJoueurService.warning("erreur de saisie \t saisir que des chiffres liés au menu");
		}
		return choix;
	}

	/**
	 * Sortie du programme
	 */
	public static void quitterJeu(Joueur j)
	{
		if (j.isIsidentifie())
		{
			JoueurService.logoff(j);
		}
		System.out.println("Sortie de jeu, aurevoir");
		// sc.close();
		System.exit(0);
	}

	public static void ifechier()
	{
		final String msg = System.getProperty("user.dir") + "\\jeu\\compteJoueur.bin";

		System.out.println("new File(msg).exists() :" + new File(msg).exists());
		System.out.println("Constante.isfichierJoueurExist: " + new File(Constante.fichierJoueur).exists());
	}

	// override

	// tostring
}
