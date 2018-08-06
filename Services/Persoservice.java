package Services;

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
	 */
	public static void creationPerso(Joueur j)
	{
		// à developper
		// 1.demander le nom
		// 2.demander le genre
		// 3.demander la classe
		// 4.demander les caracteristiques
		// 5.demander l'aspect
		// 6.creation d'inventaire par defo

		// a dev
		System.out.println("en cours de dev");
		// nouvel entite Personnage...
		final Personnage p = new Personnage();
		// ...à lier à une entite joueur
		// p.setJId(j);
		// // 1.demander le nom
		// p.setNom(verifNomp());
		// // 2.demander le genre
		// p.setGenre(saisieGenre());
		// // 3.demander la classe
		// p.setClasse(saisieClasse());
		// // 4.Mettre les caracteristiques par défaut
		// final HashMap<String, Integer> caracdef = new HashMap<>();
		// caracdef.put("Dexterité", 10);
		// caracdef.put("Intelligence", 10);
		// caracdef.put("Force", 10);
		// caracdef.put("Constitution", 10);
		// caracdef.put("Volonté", 10);
		// caracdef.put("Charisme", 10);
		// p.setCaracteristiques(caracdef);
		// // 4.demander les caracteristiques
		// creationCarac(p);
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
		// retour vers menu CreationPersoMenu()
		MenuPerso.creationPersoMenu(j);
	}
	// override

	// tostring
}
