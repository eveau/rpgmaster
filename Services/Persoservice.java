package Services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import Applicatif.Menu;
import Applicatif.MenuPerso;
import Entitee.Joueur;
import Entitee.Personnage;

/**
 * Méthodes concernant le Personnage<br/>
 * version Developpement 0.5<br/>
 *
 * @author baboulou
 */
public class Persoservice {
	// propriétés de classe

	// constructeur sans argument
	public Persoservice() {

	}

	// getter and setter

	// methodes de classe
	/**
	 *
	 * @param nom
	 * @param genre
	 * @param classe
	 * @param caracteristiques
	 * @param l'aspect
	 * @param inventaire
	 * @param jListe2persos
	 * @param ecritureFichierPerso
	 *            <br/>
	 *            crée une fiche Personnage<br/>
	 * @author baboulou
	 * @return
	 */
	public static Object creationPerso(Joueur j)
	{
		// à developper
		// 1.demander le nom
		// 2.demander le genre
		// 3.demander la classe
		// 4.demander les caracteristiques
		// 5.demander l'aspect
		// 6.creation d'inventaire par defo

		System.out.println("en cours de dev");
		// nouvel entite Personnage...
		final Personnage p = new Personnage();
		final Joueur tmp = JoueurService.recupTotJoueur();
		if (!j.getIdentifiant().equals(tmp.getIdentifiant()) || (!tmp.isIsidentifie()))
		{
			System.out.println("tu n'es pas authentifié pour cela");
			return MenuPerso.creationPersoMenu(j);
		}
		j = tmp;
		// nouveau perso lié au joueur
		p.setPId(tmp.getJid());
		// 1.demander le nom
		p.setNom(verifNomp());
		// // 2.demander le genre
		p.setGenre(saisieGenre());
		// 3.demander la classe
		p.setClasse(saisieClasse());
		// 4.Mettre les caracteristiques par défaut
		// final HashMap<String, Integer> caracdef = new HashMap<>();
		// caracdef.put("Dexterité", 10);
		// caracdef.put("Intelligence", 10);
		// caracdef.put("Force", 10);
		// caracdef.put("Constitution", 10);
		// caracdef.put("Volonté", 10);
		// caracdef.put("Charisme", 10);
		// p.setCaracteristiques(caracdef);
		// 4.demander les caracteristiques
		creationCarac(j, p);
		System.out.println("fin création perso à caracteristique");
		// // 5.demander l'aspect
		// p.setAspect(saisieAspectCreation());
		// // 6.creation d'inventaire par defo
		// p.setInventaire(invdefo());
		// // creation du fichier de liste de persos
		// final List<Personnage> jListe2persos;
		// j.setjListe2persos.add(p);
		// creerListe2Persos();
		// // écriture des données dans le fichier
		// ecritureFichierPerso(p);
		JoueurService.EcritureFichierJoueur(j);
		// retour vers menu CreationPersoMenu()
		System.out.println("fin création perso retour au menu d'avant");
		return MenuPerso.creationPersoMenu(j);
	}

	/**
	 * verifie si le nom de personnage est orthographiquement valable<br/>
	 *
	 * @author baboulou
	 */
	public static String verifNomp()
	{
		final String ident = Menu.choixTxt("Saisie du nom du Personnage");
		final boolean hasNonAlpha = ident.matches("^.*[^a-zA-Z0-9 ].*$");
		if (hasNonAlpha == true || ident == null || ident.isEmpty() || ident.length() < 3 || ident.length() > 20 || ident.contains(" "))
		{
			System.out.println("erreur de saisie du nom du perso\n ne saisir que des lettres avec chiffres sans espace");
			return verifNomp();
		}
		return ident;
	}

	/**
	 * saisie du genre du personnage<br/>
	 *
	 * @author baboulou
	 */
	public static String saisieGenre()
	{
		switch (Menu.choixTxt("saisir genre: 1.Masculin 2.Feminin 3.Transgenre 4.Agenree 5.autre"))
		{
		case "1":
			return Personnage.M;
		case "2":
			return Personnage.F;
		case "3":
			return Personnage.TS;
		case "4":
			return Personnage.A;
		case "5":
			return Personnage.AA;
		default:
			System.out.println("erreur de saisie, choisir un nombre");
			return saisieGenre();
		}
	}

	/**
	 * saisie de la classe du personnage<br/>
	 *
	 * @author baboulou
	 */
	private static String saisieClasse()
	{
		switch (Menu.choixTxt("choix du role: 1.Voleur 2.Guerrier 3.Mage 4.Archer 5.Pretre 6.Moine 7.Paladin 8.Sorcier 9.Druide 10.Rodeur 11.Barde"))
		{
		case "1":
			return "Voleur";
		case "2":
			return "Guerrier";
		case "3":
			return "Mage";
		case "4":
			return "Archer";
		case "5":
			return "Pretre";
		case "6":
			return "Moine";
		case "7":
			return "Paladin";
		case "8":
			return "Sorcier";
		case "9":
			return "Druide";
		case "10":
			return "Rodeur";
		case "11":
			return "Barde";
		default:
			System.out.println("erreur de saisie, choisir un nombre\n");
			return saisieClasse();
		}
	}

	/**
	 * Vers Menu de paramétrage des caracteristiques du personnage <br/>
	 *
	 * @param Joueur
	 *            j
	 * @author baboulou
	 * @return
	 */
	private static void creationCarac(Joueur j, Personnage p)
	{
		// intervention du fichier personnage lié à un joueur ou liste de perso liée à un joueur
		// 1 Joueur->1liste de perso
		// liste de persos->plusieurs persos
		// 1.recuperer la liste2persos de l'entite joueur à partir du fichier joueur (voir le cas ou c'est à null)
		// 2.set la variable liste2perso du joueur avec celle provenant du fichier (via un temp)
		// 3.creer une entite perso
		// 4.demander le parametrage pour chaque caracteristique (via un menu)
		// 5.ajouter chaque parametrage de caracteristique dans l'entite perso (via p.setDexterite par exemple)
		// 6.ajouter l'entitee perso crée dans la variable liste2perso du joueur
		// 7.ecrire dans le fichier joueur la liste de perso

		// 1. Joueur List<Personnage> jListe2persos;
		// si joueur connecté et avec le meme identifiant on peut utiliser à partir du fichier

		// Mettre les caracteristiques par défaut
		final HashMap<String, Integer> caracdef = new HashMap<>();
		caracdef.put("Dexterité", 10);
		caracdef.put("Intelligence", 10);
		caracdef.put("Force", 10);
		caracdef.put("Constitution", 10);
		caracdef.put("Volonté", 10);
		caracdef.put("Charisme", 10);
		p.setCaracteristiques(caracdef);
		// 4.menu de parametrage
		p = saisieMenuCaracks(p);
		// enregistre dans joueur en memoire
		// pb npe
		System.out.println("Perso actuelle: " + p.toString());

		if (j.getjListe2persos() != null)
		{

			j.getjListe2persos().add(p);
		}
		else
		{
			final List<Personnage> pl = new ArrayList<>();
			j.setjListe2persos(pl);
			j.setjListe2persos((List<Personnage>) p);

		}
		System.out.println("liste de perso du joueur: " + j.getjListe2persos().toString());
		// écriture, essai sans liste2persos.bin donc ecriture uniquement encapsulée dans fichier joueur

	}

	/**
	 * Menu de paramétrage des caracteristiques du personnage <br/>
	 * version à la création du perso ou les valeurs sont vides et non au passsage de niveau supérieur
	 *
	 * @param Personnage
	 *            p
	 * @author baboulou
	 */
	private static Personnage saisieMenuCaracks(Personnage p)
	{
		switch (Menu.choixTxt("saisir caracteristik: 1.Intelligence 2.Dexterité 3.Force 4.Constitution 5.Volonté 6.Charisme 7.Voir les caracteristiques actuelles 8.Terminer"))
		{
		case "1":
			System.out.println("vers methode setting nb intelligence");
			saisieCarack(p, "Intelligence");
			break;
		case "2":
			System.out.println("vers methode setting nb Dexterité");
			saisieCarack(p, "Dexterité");
			break;
		case "3":
			System.out.println("vers methode setting nb Force");
			saisieCarack(p, "Force");
			break;
		case "4":
			System.out.println("vers methode setting nb Constitution");
			saisieCarack(p, "Constitution");
			break;
		case "5":
			System.out.println("vers methode setting nb Volonté");
			saisieCarack(p, "Volonté");
			break;
		case "6":
			System.out.println("vers methode setting nb Charisme");
			saisieCarack(p, "Charisme");
			break;
		case "7":
			System.out.println("vers methode  visuCaracteristiques(p)");
			visuCarak(p);
			return saisieMenuCaracks(p);
		case "8":
			System.out.println("Terminer, retour vers methode creationPerso()");
			break;
		default:
			System.out.println("erreur de saisie, choisir un nombre");
			return saisieMenuCaracks(p);
		}
		return p;
	}

	/**
	 * Saisie et vérification des paramétres de caracteristiques du personnage <br/>
	 *
	 * @param Personnage
	 *            p
	 * @param String
	 *            carac
	 * @author baboulou
	 */
	private static Object saisieCarack(Personnage p, String carac)
	{
		visuCarak(p);
		final int somme = p.getCaracteristiques().get("Intelligence") + p.getCaracteristiques().get("Dexterité") + p.getCaracteristiques().get("Force") + p.getCaracteristiques().get("Constitution")
				+ p.getCaracteristiques().get("Volonté") + p.getCaracteristiques().get("Charisme");
		final String d = Menu.choixTxt("saisir la valeur pour la " + carac + " (au minimum de 3 et la somme de tous les caracteristiques à 72");
		final int c = Integer.parseInt(d);
		final int b = 72 - ((c - p.getCaracteristiques().get(carac)) + somme);
		if ((c < 3) || (c > 18) || (somme > 72) || (b < 0))
		{
			System.out.println("tu as entré: " + c + "\tLa " + carac + " doit être au minimum de 3 et la somme de tous les caracteristiques à 72 maximum");
			return saisieCarack(p, carac);
		}
		else
		{
			System.out.println("entrée validée pour " + c + "\tpoints restant: " + b + " sur 72");
			p.getCaracteristiques().put(carac, c);
		}
		System.out.println("fin du prog saisieCaracGenerik()");
		return saisieMenuCaracks(p);
	}

	/**
	 * Visualisation des caracteristiques du personnage <br/>
	 *
	 * @param Personnage
	 *            p
	 * @author baboulou
	 */
	private static void visuCarak(Personnage p)
	{
		System.out.println("Quelles sont les caracteristiques actuelles ?");
		final Set<?> valeur = p.getCaracteristiques().keySet();
		for (final Object cle : valeur)
		{
			System.out.println("Caracteristique " + cle + " attribué à: " + p.getCaracteristiques().get(cle));
		}
	}

	public static Object visuPerso(Joueur j)
	{
		System.out.println(" liste actuelle des persos: " + j.getjListe2persos().toString());

		return MenuPerso.creationPersoMenu(j);
	}

	public static Object effacePerso(Joueur j)
	{
		// visuPerso(j);
		// à optimiser pour la saisie du perso à supprimer
		System.out.println("quelle perso effacer ?");
		final int totalperso = j.getjListe2persos().size();
		int i;
		for (i = 0; i < totalperso; i++)
		{
			System.out.println(i + "." + " nom: " + j.getjListe2persos().get(i).getNom() + " classe: " + j.getjListe2persos().get(i).getClasse() + " level: " + j.getjListe2persos().get(i).getPointdeVie());
		}
		final String ab = Menu.choixTxt("tape le nom correspondant au perso");
		final boolean hasNonAlpha = ab.matches("^.*[^a-zA-Z0-9 ].*$");
		if (hasNonAlpha || ab == null || ab.isEmpty() || ab.contains(" "))
		{
			System.out.println("erreur de saisie, saisir correctement le nom du perso");
			return effacePerso(j);
		}
		else
		{
			// methode fort bouclée
			for (int i2 = 0; i2 < totalperso; i2++)
			{
				if (ab.equals(j.getjListe2persos().get(i2).getNom()))
				{
					final String tx = Menu.choixTxt("etes vous sur de supprimer " + j.getjListe2persos().get(i2).getNom());
					if (tx.equals("1") || tx.equals("oui"))
					{
						System.out.println("suppression de " + j.getjListe2persos().get(i2).getNom());
					}
					else
					{
						System.out.println("perso " + j.getjListe2persos().get(i2).getNom() + " sauvegardé");
					}
					return MenuPerso.creationPersoMenu(j);
				}
			}
			System.out.println("aucun perso trouvé avec: " + ab);
		}
		return MenuPerso.creationPersoMenu(j);

	}// fin de effacePerso()

	// override
	// tostring
}
