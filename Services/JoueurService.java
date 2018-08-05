package Services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;

import Applicatif.Menu;
import Commun.Constante;
import Entitee.Joueur;

/**
 * @author baboulou
 * @param Service
 *            controleur<br/>
 *            version de Testing<br/>
 */
public class JoueurService {
	// propriétés de classe

	// constructeur sans argument
	public JoueurService() {

	}

	// getter and setter

	// methodes de classe
	public static void creationCompteJoueur()
	{
		// 1.demander le nom
		// 2.demander le mail
		// 3.demander le mot de passe
		// 4.rediriger vers menu pour identification
		final Joueur j = new Joueur();
		j.setIdentifiant(verifIdent());
		j.setMail(verifMail());
		j.setMotDePasse(verifmdp());
		j.setIsidentifie(false);
		// creation du fichier
		creerFichierJoueur();
		// écriture des données dans le fichier
		EcritureFichierJoueur(j);
	}

	public static String verifIdent()
	{
		final String ident = Menu.choixTxt("Saisi du nom de l'identifiant joueur");
		final boolean hasNonAlpha = ident.matches("^.*[^a-zA-Z0-9 ].*$");
		if (hasNonAlpha == true || ident == null || ident.isEmpty() || ident.length() < 3 || ident.length() > 20
				|| ident.contains(" "))
		{
			Constante.LOGJoueurService.info(
					"erreur de saisie prenom\n saisir que des lettres avec chiffres sans espace d'au moins 3 caractères et un max de 20");
			// pour la branche dev
			// System.out.println( "erreur de saisie prenom\n saisir que des
			// lettres avec chiffres sans espace d'au moins 3 caractères et un
			// max de 20");
			verifIdent();
		}
		return ident;

	}

	private static String verifMail()
	{
		final String mail = Menu.choixTxt("Saisir l'email du joueur");
		final boolean isMailValid = mail.matches(
				"^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$");
		if (!isMailValid)
		{
			// branche dev tester le Constante.LOGJoueurService.info("msg")
			System.out.println("erreur de saisie mail\n saisir que des lettres avec chiffres sans espace avec l'@");
			verifMail();
		}
		return mail;
	}

	public static String verifmdp()
	{
		final String mdp = Menu.choixTxt("Saisir le mot de passe du joueur");
		final boolean hasNonAlpha = mdp.matches("^.*[^a-zA-Z0-9 ].*$");
		if (hasNonAlpha == true || mdp == null || mdp.isEmpty() || mdp.length() < 5 || mdp.length() > 20
				|| mdp.contains(" "))
		{
			// branche dev tester le Constante.LOGJoueurService.info("msg")
			System.out.println("erreur de saisie prenom\n saisir que des lettres avec chiffres sans espace");
			verifmdp();
		}
		return mdp;
	}

	private static void creerFichierJoueur()
	{
		try
		{
			new File(Constante.fichierJoueur).createNewFile();
		}
		catch (final IOException e)
		{
			Constante.LOGPersoservice.log(Level.SEVERE, "erreur: " + e.getMessage() + " a cause de: " + e.getCause(),
					e);
		}
	}

	private static void EcritureFichierJoueur(Joueur j)
	{
		try
		{
			final FileOutputStream fos = new FileOutputStream(Constante.fichierJoueur);
			final ObjectOutputStream oos = new ObjectOutputStream(fos);
			// sauvegarde serialization
			oos.writeObject(j);
			System.out.println("Compte Joueur" + j.toString() + " sauvegardé");
			oos.flush();
			oos.close();
			fos.close();
		}
		catch (final FileNotFoundException e)
		{
			// branche dev a confirmer
			Constante.LOGJoueurService.severe("Le fichier " + Constante.fichierJoueur
					+ " n'a pas pu être crée\nerreur: " + e.getMessage() + " a cause de: " + e.getCause());
			System.exit(1);
		}
		catch (final IOException e)
		{
			// branche dev a confirmer
			Constante.LOGJoueurService.severe("La sauvegarde de l'objet " + j.toString()
					+ " compte joueur a échoué\n erreur: " + e.getMessage() + " a cause de: " + e.getCause());
			System.exit(2);
		}

	}

	public static void connection()
	{
		// le fichierJoueur existe t il?
		if (!Constante.isfichierJoueurExist)
		{
			// lancement de creation de compte joueur. Puis on cree le fichier
			// Joueur.
			JoueurService.creationCompteJoueur();
		}
		final Joueur j = new Joueur();
		// login
		JoueurService.login(j);
		Menu.general(j);
		/*
		 * pour dev a verifier le try catch IOException unreachable try {
		 * Menu.general(); } catch (final IOException e) {
		 * Constante.LOGJoueurService.
		 * warning("erreur de chargement du menu general");
		 * Constante.LOGJoueurService.finest(Constante.msge(e)); }
		 */
	}

	public static void login(Joueur j)
	{
		JoueurService.saisieIdentificationJoueur(j);
		JoueurService.isConnexConforme(j);
	}

	private static void saisieIdentificationJoueur(Joueur j)
	{
		j.setIdentifiant(JoueurService.verifIdent());
		j.setMotDePasse(JoueurService.verifmdp());

	}

	private static void isConnexConforme(Joueur j)
	{
		if (recupInfoCompteJoueur().getIdentifiant().equals(j.getIdentifiant())
				&& recupInfoCompteJoueur().getMotDePasse().equals(j.getMotDePasse()))
		{
			System.out.println("identification réussie");
			j.setIsidentifie(true);
			// solved
			// ecriture a ce moment de l'etat identifie ? oui car on se base sur
			// le fichier
			// methode ecriture du statut identifie dans le fichier a developper
			saveisIdentfileJ(j);

			// modifPourIsidentifie(j);
			// modifCompteJoueur(j);
			// EcritureFichierJoueur(j);
		}
		else
		{
			System.out.println("identification échouée");
			final short c = Menu.choixNb("se loguer plus tard? 1.oui 2.non");
			switch (c)
			{
			case 1:
				j.setIsidentifie(false);
				// pour dev a verifier le try catch IOException unreachable try
				Menu.general(j);
				break;
			case 2:
				login(j);
				break;
			default:
				System.out.println("saisir un nombre: 1 ou 2");
				login(j);
			}
		}

	}

	/**
	 * Déconnection du joueur
	 */
	public static void logoff(Joueur j)
	{
		// dev a verifier en conformite
		// utilité de recupInfoCompteJoueur()?
		j.setIsidentifie(false);
		saveisIdentfileJ(j);
		// solved
		// utilité ? uniquement si le joueur le demande explicitement
		// modifCompteJoueur(j);
		// oui enregistre l'etat isidentifie dans le fichier joueur
	}

	/**
	 * extrait à partir du fichier le joueur versun objet tmp
	 */
	public static final Joueur recupInfoCompteJoueur()
	{
		Joueur jRestored = new Joueur();
		try
		{
			final FileInputStream fis = new FileInputStream(Constante.fichierJoueur);
			final ObjectInputStream ois = new ObjectInputStream(fis);
			jRestored = (Joueur) ois.readObject();
			ois.close();
			fis.close();
			Constante.LOGJoueurService.info("Récup Info du joueur : \n" + jRestored.toString());
		}
		catch (final FileNotFoundException e)
		{

			Constante.LOGJoueurService.severe(
					"Le fichier " + Constante.fichierJoueur + " n'a pas pu etre trouve ou est inexistant\nerreur: "
							+ e.getMessage() + " a cause de: " + e.getCause());
		}
		catch (final IOException e)
		{
			Constante.LOGJoueurService.severe(
					"La restauration de l'objet a echoue\nerreur: " + e.getMessage() + " a cause de: " + e.getCause());
		}
		catch (final ClassNotFoundException e)
		{
			Constante.LOGJoueurService.severe("erreur: " + e.getMessage() + " a cause de: " + e.getCause());
		}
		return jRestored;
	}

	/**
	 * Enregistrer l'etat is identifié Joueur dans le fichier bin
	 *
	 * @param j
	 */
	private static void saveisIdentfileJ(Joueur j)
	{
		final Joueur tmp = recupTotJoueur();
		tmp.setIsidentifie(j.isIsidentifie());
		if (tmp.getIdentifiant().equals(j.getIdentifiant()) && tmp.getMotDePasse().equals(j.getMotDePasse()))
		{
			EcritureFichierJoueur(tmp);
		}
		// solved
		// a dev verifier si ca ne change pa le mdp ou nom autrement par faille,
		// oui ca bug, on ne doit ecrire que le statut identifie et uniquement
		// s'il existe dans le fichier
		// 1. recupérer les data du fichier joueur
		// 2. comparer si le nom du fichier correspond a celui en memeoire
		// active de j
		// 3. si ok on ecrit dans le fichier
		// 4. si non on ne fait rien et on quitte le logoff.
		// EcritureFichierJoueur(j);
		System.out.println("pb a l'ecriture du fichier pour sauvegarder saveisIdentfileJ");

	}

	// Pour dev: il y a 3 versions de la méthode modifCompteJoueur()
	/**
	 * Modifier le compte Joueur à la demande du joueur normalement
	 *
	 * @param j
	 */
	public static void modifCompteJoueur(Joueur j)
	{
		// creer un menu qui demande de modifier les elements
		// j.setIdentifiant("nouvel identifiant fourni");
		// j.setMail("nouveau mail fourni");
		// j.setMotDePasse("nouveau mdp fourni");
		// j.setIsidentifie("? a decider");
		// puis enregistrer avec EcritureFichierJoueur(j);

		final Joueur tmp = recupTotJoueur();

		if (!j.getIdentifiant().equals(tmp.getIdentifiant()))
		{
			tmp.setIdentifiant(j.getIdentifiant());
		}
		// pour dev if (!j.getMail().equalsIgnoreCase(tmp.getMail()))
		// ->pointernull
		if (j.getMail() != tmp.getMail())
		{
			tmp.setMail(j.getMail());
		}
		if (!j.getMotDePasse().equals(tmp.getMotDePasse()))
		{
			tmp.setMotDePasse(j.getMotDePasse());
		}
		if (j.isIsidentifie() != tmp.isIsidentifie())
		{
			tmp.setIsidentifie(j.isIsidentifie());
		}
		EcritureFichierJoueur(tmp);
	}

	/**
	 * Récuperation des données du Joueur à partir du fichier
	 */
	public static Joueur recupTotJoueur()
	{
		final Joueur tmp = new Joueur();
		tmp.setIdentifiant((recupInfoCompteJoueur().getIdentifiant()));
		tmp.setMail(recupInfoCompteJoueur().getMail());
		tmp.setMotDePasse(recupInfoCompteJoueur().getMotDePasse());
		tmp.setIsidentifie(recupInfoCompteJoueur().isIsidentifie());
		return tmp;
	}
	// override

	// tostring
}
