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
 * Méthodes liées au compte du joueur ou à ses données<br/>
 * version Developpement 0.5<br/>
 *
 * @author baboulou
 */
public class JoueurService {
	// propriétés de classe

	// constructeur sans argument
	public JoueurService() {

	}

	// getter and setter

	// methodes de classe
	/**
	 * @param j.set
	 * @param creerFichierJoueur
	 * @param EcritureFichierJoueur
	 *            <br/>
	 *            crée le compte du joueur
	 * @author baboulou
	 */
	public static void creationCompteJoueur()
	{
		// 1.demander le nom
		// 2.demander le mail
		// 3.demander le mot de passe
		// 4.rediriger vers menu pour identification
		final Joueur j = new Joueur();
		j.setIdentifiant(verifIdent());
		j.setMail(verifMail());
		j.setMotDePasse(verifmdp((short) 1));
		// pb si first time
		j.setIsidentifie(false);
		// creation du fichier
		creerFichierJoueur();
		Menu.ifechier();
		// écriture des données dans le fichier
		EcritureFichierJoueur(j);
		Menu.ifechier();
	}

	public static String verifIdent()
	{
		final String ident = Menu.choixTxt("Saisi du nom de l'identifiant joueur");
		final boolean hasNonAlpha = ident.matches("^.*[^a-zA-Z0-9 ].*$");
		if (hasNonAlpha == true || ident == null || ident.isEmpty() || ident.length() < 3 || ident.length() > 20 || ident.contains(" "))
		{
			Constante.LOGJoueurService.info("erreur de saisie prenom\n saisir que des lettres avec chiffres sans espace d'au moins 3 caractères et un max de 20");
			// pour la branche dev
			// System.out.println( "erreur de saisie prenom\n saisir que des
			// lettres avec chiffres sans espace d'au moins 3 caractères et un
			// max de 20");
			return verifIdent();
		}
		return ident;

	}

	public static String verifMail()
	{
		final String mail;
		mail = Menu.choixTxt("Saisir l'email du joueur");
		final boolean isMailValid = mail.matches("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$");
		if (!isMailValid)
		{
			System.out.println("erreur de saisie mail\n saisir que des lettres avec chiffres sans espace avec l'@");
			return verifMail();
		}
		return mail;
	}

	public static String verifmdp(short n)
	{
		String mdp = "                   ";
		switch (n)
		{
		case 1:
			mdp = Menu.choixTxt("Saisir le mot de passe du joueur");
			break;
		case 2:
			mdp = Menu.choixTxt("Saisir l'ancien mot de passe du joueur");
			break;
		case 3:
			mdp = Menu.choixTxt("Saisir le  nouveau de passe du joueur");
			break;
		default:
			Constante.LOGJoueurService.warning("n est null ou n'a pas de valeur normal ce qui ne devrait jamais arrivé");
			break;
		}
		final boolean hasNonAlpha = mdp.matches("^.*[^a-zA-Z0-9 ].*$");
		if (hasNonAlpha == true || mdp == null || mdp.isEmpty() || mdp.length() < 3 || mdp.length() > 20 || mdp.contains(" "))
		{
			System.out.println("erreur de saisie de mot de passe\n saisir que des lettres avec chiffres sans espace");
			return verifmdp(n);
		}
		return mdp;
	}

	/**
	 * @author baboulou créer le fichier joueur bin
	 */
	private static void creerFichierJoueur()
	{
		try
		{
			new File(Constante.fichierJoueur).createNewFile();
			Menu.ifechier();
		}
		catch (final IOException e)
		{
			Constante.LOGPersoservice.log(Level.SEVERE, "erreur: " + e.getMessage() + " a cause de: " + e.getCause(), e);
		}
	}

	/**
	 * @param FileOutputStream,
	 * @param ObjectOutputStream
	 *            <br/>
	 *            écrit des données dans le fichier joueur bin 0.5<br/>
	 * @author baboulou
	 */
	public static void EcritureFichierJoueur(Joueur j)
	{
		try
		{
			Menu.ifechier();
			System.out.println("creerFichierJoueur()\tEcritureFichierJoueur: " + new File(Constante.fichierJoueur).exists());
			final FileOutputStream fos = new FileOutputStream(Constante.fichierJoueur);
			final ObjectOutputStream oos = new ObjectOutputStream(fos);
			// sauvegarde serialization
			oos.writeObject(j);
			Menu.ifechier();
			System.out.println("Compte Joueur" + j.toString() + " sauvegardé");
			oos.flush();
			oos.close();
			fos.close();
		}
		catch (final FileNotFoundException e)
		{
			// branche dev a confirmer
			Constante.LOGJoueurService.severe("Le fichier " + Constante.fichierJoueur + " n'a pas pu être crée\nerreur: " + e.getMessage() + " a cause de: " + e.getCause());
			System.exit(1);
		}
		catch (final IOException e)
		{
			// branche dev a confirmer
			Constante.LOGJoueurService.severe("La sauvegarde de l'objet " + j.toString() + " compte joueur a échoué\n erreur: " + e.getMessage() + " a cause de: " + e.getCause());
			System.exit(2);
		}

	}

	/**
	 * @param isfichierjoueurexist
	 *            verifie si le fichier joueur existe<br/>
	 * @param creationCompteJoueur
	 *            crée le compte joueur sinon<br/>
	 * @param Login
	 *            si ok puis accès au menu général
	 * @author baboulou
	 */
	public static void connection()
	{
		// le fichierJoueur existe t il?
		final boolean isfichierjoueurexist = new File(Constante.fichierJoueur).exists();
		if (!isfichierjoueurexist)
		{
			// lancement de creation de compte joueur. Puis on cree le fichier Joueur.
			JoueurService.creationCompteJoueur();
		}
		final Joueur j = new Joueur();
		// login, delogue avant si perte de connection qui a laisssé identifé à true
		JoueurService.logoff(j);
		JoueurService.login(j);
		Menu.general(j);
	}

	/**
	 * @param saisieIdentificationJoueur
	 *            <br/>
	 * @param isConnexConforme
	 *            est-ce que le joueur a une connection autorisée<br/>
	 * @author baboulou
	 */
	public static void login(Joueur j)
	{
		JoueurService.saisieIdentificationJoueur(j);
		JoueurService.isConnexConforme(j);
	}

	/**
	 * @param verifIdent
	 *            <br/>
	 * @param verifmdp
	 *            <br/>
	 * @author baboulou
	 */
	private static void saisieIdentificationJoueur(Joueur j)
	{
		j.setIdentifiant(JoueurService.verifIdent());
		j.setMotDePasse(JoueurService.verifmdp((short) 1));

	}

	/**
	 * @param verifie
	 *            que le joueur a une connection autorisée<br/>
	 * @author baboulou
	 */
	private static void isConnexConforme(Joueur j)
	{
		if (recupInfoCompteJoueur().getIdentifiant().equals(j.getIdentifiant()) && recupInfoCompteJoueur().getMotDePasse().equals(j.getMotDePasse()))
		{
			System.out.println("identification réussie");
			j.setIsidentifie(true);
			// methode ecriture du statut identifie dans le fichier a developper
			saveisIdentfileJ(j);
			// modifPourIsidentifie(j);
			// modifCompteJoueur(j);
			// EcritureFichierJoueur(j);
		}
		else
		{
			System.out.println("identification échouée");
			final String c = Menu.choixTxt("se loguer plus tard? 1.oui 2.non");
			switch (c)
			{
			case "1":
				j.setIsidentifie(false);
				Menu.general(j);
				break;
			case "2":
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
		final Joueur tmp = recupTotJoueur();
		tmp.setIsidentifie(false);
		EcritureFichierJoueur(tmp);
		// saveisIdentfileJ(j);
	}

	/**
	 * extrait à partir du fichier le joueur vers un objet tmp
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

			Constante.LOGJoueurService.severe("Le fichier " + Constante.fichierJoueur + " n'a pas pu etre trouve ou est inexistant\nerreur: " + e.getMessage() + " a cause de: " + e.getCause());
		}
		catch (final IOException e)
		{
			Constante.LOGJoueurService.severe("La restauration de l'objet a echoue\nerreur: " + e.getMessage() + " a cause de: " + e.getCause());
		}
		catch (final ClassNotFoundException e)
		{
			Constante.LOGJoueurService.severe("erreur: " + e.getMessage() + " a cause de: " + e.getCause());
		}
		return jRestored;
	}

	/**
	 * @author baboulou
	 * @param recupTotJoueur
	 *            <br/>
	 * @param EcritureFichierJoueur
	 * @param isIsidentifie
	 *            Enregistre l'état is identifié Joueur dans le fichier bin en vérifiant s'il y a un compte associé<br/>
	 *            recupére les data du fichier joueur<br/>
	 *            compare si le nom du fichier correspond à celui en memoire active du @param j
	 */
	public static void saveisIdentfileJ(Joueur j)
	{
		final Joueur tmp = recupTotJoueur();
		tmp.setIsidentifie(j.isIsidentifie());
		if (tmp.getIdentifiant().equals(j.getIdentifiant()) && tmp.getMotDePasse().equals(j.getMotDePasse()))
		{
			EcritureFichierJoueur(tmp);
		}
	}

	// Pour dev: il y a 3 versions de la méthode modifCompteJoueur()
	/**
	 * @param recupTotJoueur
	 * @param j.set__
	 * @param EcritureFichierJoueur
	 *            Inscrit les modifications dans le fichier joueur<br/>
	 *            Normalement, on devrait modifier le compte Joueur uniquement à la demande du joueur
	 * @param j
	 */
	public static void modifFichierCpteJoueur(Joueur j)
	{
		// a dev creer un menu qui demande de modifier les elements
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
		// pour dev if (!j.getMail().equalsIgnoreCase(tmp.getMail())) donne une pointernull
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
	 * Récuperation des données du Joueur à partir du fichier joueur bin
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

	public static void modifCpteJoueur()
	{

	}
	// override

	// tostring
}
