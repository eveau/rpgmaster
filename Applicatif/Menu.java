package Applicatif;

import java.io.File;
import java.util.InputMismatchException;
import java.util.Scanner;

import Commun.Constante;
import Entitee.Joueur;
import Services.JoueurService;
import Testing.MenuTest01;

/**
 * Menus du jeu<br/>
 * version Developpement 0.5<br/>
 * 
 * @author baboulou
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
		// final Joueur j = new Joueur();
		String a = "logueoupas";
		if (JoueurService.recupInfoCompteJoueur().isIsidentifie())
		{
			// a dev - le joueur est logué
			a = "1.Se deloguer 2.Modifier son compte Joueur 3.lancer le jeu 4.Quitter";
			j.setIdentifiant(JoueurService.recupInfoCompteJoueur().getIdentifiant());
			j.setMail(JoueurService.recupInfoCompteJoueur().getMail());
			j.setMotDePasse(JoueurService.recupInfoCompteJoueur().getMotDePasse());
		}
		else
		{
			a = "1.Se loguer 6.menuTest 4.Quitter";
		}

		final String c = choixTxt(a);
		switch (c)
		{
		case "1":
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
		case "2":
			System.out.println("vers Modifier son compte Joueur");
			MenuJoueur.menuModifduJoueur(j);
			break;
		case "3":
			lancerJeu(j);
			break;
		case "4":
			quitterJeu(j);
			break;
		case "6":
			MenuTest01.testLogger(j);
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
		final String c = choixTxt("1.Nouvelle partie 2.Continuer 3.Charger partie 4.Sauvegarder 5.quitter Partie 6. Quitter le jeu  7.retour menu general");
		switch (c)
		{
		case "1":
			nouvellePartie(j);
			break;
		case "2":
			System.out.println("vers PartieService.continuerPartie();");
			lancerJeu(j);
			break;
		case "3":
			System.out.println("vers PartieService.chargerPartie()");
			lancerJeu(j);
			break;
		case "4":
			System.out.println("vers PartieService.sauvegarderPartie()");
			lancerJeu(j);
			break;
		case "5":
			System.out.println("vers PartieService.quitterPartie()");
			lancerJeu(j);
			break;
		case "6":
			quitterJeu(j);
			break;
		case "7":
			general(j);
			break;
		default:
			System.out.println("erreur de saisie, choisir un nombre");
			lancerJeu(j);
		}
	}

	/**
	 * Nouvelle Partie, création de Perso +création de fichier partie
	 */
	public static void nouvellePartie(Joueur j)
	{
		final String c = choixTxt("1.Création d'un perso  2.???  5.Lancer la partie 6. Quitter le jeu  7.retour menu general");
		switch (c)
		{
		case "1":
			MenuPerso.creationPersoMenu(j);
			break;
		case "2":
			System.out.println("vers ???");
			nouvellePartie(j);
			break;
		case "5":
			System.out.println("vers PartieService.lancerPartie()");
			nouvellePartie(j);
			break;
		case "6":
			quitterJeu(j);
			break;
		case "7":
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
		// saisie plus safe en String
		// dev voir ce qui allege le mieux pour sc.close
		final Scanner sc = new Scanner(System.in);
		System.out.println(txt);
		// pour dev tester un return sc.nextLine();
		// final String choix2 = sc.nextLine();
		return sc.nextLine();
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
		System.out.println("j.isIsidentifie(): " + j.isIsidentifie());
		if (j.isIsidentifie())
		{
			JoueurService.logoff(j);
		}
		System.out.println("Sortie de jeu, aurevoir");
		// sc.close();
		System.exit(0);
	}

	// a retirer a la fin
	public static void ifechier()
	{
		final String msg = System.getProperty("user.dir") + "\\jeu\\compteJoueur.bin";

		System.out.println("new File(msg).exists() :" + new File(msg).exists());
		System.out.println("Constante.isfichierJoueurExist: " + new File(Constante.fichierJoueur).exists());
	}

	// override

	// tostring
}
