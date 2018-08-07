package Applicatif;

import Entitee.Joueur;
import Entitee.Personnage;
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
	 *
	 * @return
	 */
	public static Object creationPersoMenu(Joueur j)
	{
		final String c = Menu
				.choixTxt("1.Création d'un perso 2.Visualiser ses perso 3.Charger un perso ou un modele 4.Modifier un perso \n 5.Supprimer un perso 6.Lancer la partie  7.retour menu general 8. Quitter le jeu ");
		switch (c)
		{
		case "1":
			return Persoservice.creationPerso(j);
		case "2":
			return visuPerso(j);
		case "3":
			System.out.println("vers PersoService.charge1Perso ();");
			return creationPersoMenu(j);
		case "4":
			System.out.println("vers PersoService.modifie1Perso ();");
			return creationPersoMenu(j);
		case "5":
			System.out.println("vers PartieService.effacePerso()");
			return Persoservice.effacePerso(j);
		case "6":
			System.out.println("vers PartieService.lancer1Partie()");
			return creationPersoMenu(j);
		case "8":
			// a dev ajouter un return
			Menu.quitterJeu(j);
			break;
		case "7":
			// a dev ajouter un return
			Menu.general(j);
			break;
		default:
			System.out.println("erreur de saisie, choisir un nombre");
			return creationPersoMenu(j);
		}
		return creationPersoMenu(j);
	}

	public static Object visuPerso(Joueur j)
	{
		final String c = Menu.choixTxt("1.Visu courte 2.Normale 3.Détaillée  4.Retour au menu Gestion de perso 7.retour menu general 8. Quitter le jeu ");
		switch (c)
		{
		case "1":
			return Persoservice.visuListePerso(j, (short) 1);
		case "2":
			return Persoservice.visuListePerso(j, (short) 0);
		case "3":
			return Persoservice.visuListePerso(j, (short) 2);
		case "4":
			return creationPersoMenu(j);
		case "7":
			// a dev ajouter un return
			Menu.general(j);
			break;
		case "8":
			// a dev ajouter un return
			Menu.quitterJeu(j);
			break;
		default:
			System.out.println("erreur de saisie, choisir un nombre");
			return visuPerso(j);
		}
		return visuPerso(j);
	}

	/**
	 * Menu de paramétrage des caracteristiques du personnage <br/>
	 * version à la création du perso ou les valeurs sont vides et non au passsage de niveau supérieur
	 *
	 * @param Personnage
	 *            p
	 * @author baboulou
	 */
	public static Personnage saisieMenuCaracks(Personnage p)
	{
		switch (Menu.choixTxt("saisir caracteristik: 1.Intelligence 2.Dexterité 3.Force 4.Constitution 5.Volonté 6.Charisme 7.Voir les caracteristiques actuelles 8.Terminer"))
		{
		case "1":
			System.out.println("vers methode setting nb intelligence");
			Persoservice.saisieCarack(p, "Intelligence");
			break;
		case "2":
			System.out.println("vers methode setting nb Dexterité");
			Persoservice.saisieCarack(p, "Dexterité");
			break;
		case "3":
			System.out.println("vers methode setting nb Force");
			Persoservice.saisieCarack(p, "Force");
			break;
		case "4":
			System.out.println("vers methode setting nb Constitution");
			Persoservice.saisieCarack(p, "Constitution");
			break;
		case "5":
			System.out.println("vers methode setting nb Volonté");
			Persoservice.saisieCarack(p, "Volonté");
			break;
		case "6":
			System.out.println("vers methode setting nb Charisme");
			Persoservice.saisieCarack(p, "Charisme");
			break;
		case "7":
			System.out.println("vers methode  visuCaracteristiques(p)");
			Persoservice.visuCarak(p);
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

	public static Personnage saisieMenuAspect(Personnage p)
	{
		final String c = Menu.choixTxt("1.Yeux 2.Cheveux 3.Visage 4.Teint de peau 5.forme du corps 6.Taille du corps 7.retour menu creation aspect ");
		switch (c)
		{
		case "1":
			System.out.println("vers yeuxPerso");
			setyeuxPerso(p);
			break;
		case "2":
			System.out.println("vers setcheveuxPerso");
			setcheveuxPerso(p);
			break;
		case "3":
			System.out.println("vers setvisagePerso");
			setvisagePerso(p);
			break;
		case "4":
			System.out.println("vers setpeauPerso");
			setpeauPerso(p);
			break;
		case "5":
			System.out.println("vers setcorpsfPerso");
			setcorpsfPerso(p);
			break;
		case "6":
			System.out.println("vers setcorpstPerso");
			setcorpstPerso(p);
			break;
		case "7":
			System.out.println("Terminer, retour vers menu creation aspect");
			break;
		default:
			System.out.println("erreur de saisie");
			return saisieMenuAspect(p);
		}
		return p;
	}

	public static Object setyeuxPerso(Personnage p)
	{
		if (p.getAspect().isEmpty())
		{
			Persoservice.setAspectdefo(p);
		}
		final String c = Menu.choixTxt("1.bleu 2.vert 3.gris 4.noisette 5.noirs 6.rouge 7.Valider et retour menu aspect ");
		switch (c)
		{
		case "1":
			p.getAspect().put("Yeux", "bleux");
			System.out.println("mis a bleux");
			return setyeuxPerso(p);
		case "2":
			p.getAspect().put("Yeux", "vert");
			System.out.println("mis a vert");
			return setyeuxPerso(p);
		case "3":
			p.getAspect().put("Yeux", "gris");
			System.out.println("mis a gris");
			return setyeuxPerso(p);
		case "4":
			p.getAspect().put("Yeux", "noisette");
			System.out.println("mis a noisette");
			return setyeuxPerso(p);
		case "5":
			p.getAspect().put("Yeux", "noirs");
			System.out.println("mis a noirs");
			return setyeuxPerso(p);
		case "6":
			p.getAspect().put("Yeux", "rouge");
			System.out.println("mis a rouge");
			return setyeuxPerso(p);
		case "7":
			System.out.println("Terminer, retour vers methode Menu aspect()");
			return saisieMenuAspect(p);
		default:
			System.out.println("erreur de saisie");
			return setyeuxPerso(p);
		}
	}

	public static Object setcheveuxPerso(Personnage p)
	{
		if (p.getAspect().isEmpty())
		{
			Persoservice.setAspectdefo(p);
		}
		final String c = Menu.choixTxt("1.violet 2.bleu 3.vert 4.rouge 5.auburn 6.roux 7.marron 8.noir 9.blond 10.gris 11.blanc 12.Valider et retour menu aspect ");
		switch (c)
		{
		case "1":
			p.getAspect().put("Cheveux", "violet");
			System.out.println("mis a violet");
			return setcheveuxPerso(p);
		case "2":
			p.getAspect().put("Cheveux", "bleu");
			System.out.println("mis a bleu");
			return setcheveuxPerso(p);
		case "3":
			p.getAspect().put("Cheveux", "vert");
			System.out.println("mis a vert");
			return setcheveuxPerso(p);
		case "4":
			p.getAspect().put("Cheveux", "rouge");
			System.out.println("mis a rouge");
			return setcheveuxPerso(p);
		case "5":
			p.getAspect().put("Cheveux", "auburn");
			System.out.println("mis a auburn");
			return setcheveuxPerso(p);
		case "6":
			p.getAspect().put("Cheveux", "roux");
			System.out.println("mis a roux");
			return setcheveuxPerso(p);
		case "7":
			p.getAspect().put("Cheveux", "marron");
			System.out.println("mis a marron");
			return setcheveuxPerso(p);
		case "8":
			p.getAspect().put("Cheveux", "noir");
			System.out.println("mis a noir");
			return setcheveuxPerso(p);
		case "9":
			p.getAspect().put("Cheveux", "blond");
			System.out.println("mis a blond");
			return setcheveuxPerso(p);
		case "10":
			p.getAspect().put("Cheveux", "gris");
			System.out.println("mis a gris");
			return setcheveuxPerso(p);
		case "11":
			p.getAspect().put("Cheveux", "blanc");
			System.out.println("mis a blanc");
			return setcheveuxPerso(p);
		case "12":
			System.out.println("Terminer, retour vers methode Menu aspect()");
			return saisieMenuAspect(p);
		default:
			System.out.println("erreur de saisie");
			return setcheveuxPerso(p);
		}
	}

	public static Object setvisagePerso(Personnage p)
	{
		if (p.getAspect().isEmpty())
		{
			Persoservice.setAspectdefo(p);
		}
		final String c = Menu.choixTxt("1.rond 2.carre 3.triangle 4.ovale 5.Valider et retour menu aspect ");
		switch (c)
		{
		case "1":
			p.getAspect().put("Visage", "rond");
			System.out.println("mis a rond");
			return setvisagePerso(p);
		case "2":
			p.getAspect().put("Visage", "carre");
			System.out.println("mis a carre");
			return setvisagePerso(p);
		case "3":
			p.getAspect().put("Visage", "triangle");
			System.out.println("mis a triangle");
			return setvisagePerso(p);
		case "4":
			p.getAspect().put("Visage", "ovale");
			System.out.println("mis a ovale");
			return setvisagePerso(p);
		case "5":
			System.out.println("Terminer, retour vers methode Menu aspect()");
			return saisieMenuAspect(p);
		default:
			System.out.println("erreur de saisie");
			return setvisagePerso(p);
		}

	}

	public static Object setpeauPerso(Personnage p)
	{
		if (p.getAspect().isEmpty())
		{
			Persoservice.setAspectdefo(p);
		}
		final String c = Menu.choixTxt("1.noire 2.marron 3.halée 4.rousse 5.blanche 6.verte 7.bleu 8.jaune 9.rouge  10.Valider et retour menu aspect ");
		switch (c)
		{
		case "1":
			p.getAspect().put("Peau", "noire");
			System.out.println("mis a noire");
			return setpeauPerso(p);
		case "2":
			p.getAspect().put("Peau", "marron");
			System.out.println("mis a marron");
			return setpeauPerso(p);
		case "3":
			p.getAspect().put("Peau", "halée");
			System.out.println("mis a halée");
			return setpeauPerso(p);
		case "4":
			p.getAspect().put("Peau", "rousse");
			System.out.println("mis a rousse");
			return setpeauPerso(p);
		case "5":
			p.getAspect().put("Peau", "blanche");
			System.out.println("mis a blanche");
			return setpeauPerso(p);
		case "6":
			p.getAspect().put("Peau", "verte");
			System.out.println("mis a verte");
			return setpeauPerso(p);
		case "7":
			p.getAspect().put("Peau", "bleu");
			System.out.println("mis a bleu");
			return setpeauPerso(p);
		case "8":
			p.getAspect().put("Peau", "jaune");
			System.out.println("mis a jaune");
			return setpeauPerso(p);
		case "9":
			p.getAspect().put("Peau", "rouge");
			System.out.println("mis a rouge");
			return setpeauPerso(p);
		case "10":
			System.out.println("Terminer, retour vers methode Menu aspect()");
			return saisieMenuAspect(p);
		default:
			System.out.println("erreur de saisie");
			return setpeauPerso(p);
		}
	}

	public static Object setcorpsfPerso(Personnage p)
	{
		if (p.getAspect().isEmpty())
		{
			Persoservice.setAspectdefo(p);
		}
		final String c = Menu.choixTxt("1.obese 2.gros 3.fort 4.musclé 5.athletique 6.emboinpoint 7.mince 8.anorexique 9.Valider et retour menu aspect ");
		switch (c)
		{
		case "1":
			p.getAspect().put("Corpsf", "obese");
			System.out.println("mis a obese");
			return setcorpsfPerso(p);
		case "2":
			p.getAspect().put("Corpsf", "gros");
			System.out.println("mis a gros");
			return setcorpsfPerso(p);
		case "3":
			p.getAspect().put("Corpsf", "fort");
			System.out.println("mis a fort");
			return setcorpsfPerso(p);
		case "4":
			p.getAspect().put("Corpsf", "musclé");
			System.out.println("mis a musclé");
			return setcorpsfPerso(p);
		case "5":
			p.getAspect().put("Corpsf", "athletique");
			System.out.println("mis a athletique");
			return setcorpsfPerso(p);
		case "6":
			p.getAspect().put("Corpsf", "emboinpoint");
			System.out.println("mis a emboinpoint");
			return setcorpsfPerso(p);
		case "7":
			p.getAspect().put("Corpsf", "mince");
			System.out.println("mis a mince");
			return setcorpsfPerso(p);
		case "8":
			p.getAspect().put("Corpsf", "anorexique");
			System.out.println("mis a anorexique");
			return setcorpsfPerso(p);
		case "9":
			System.out.println("Terminer, retour vers methode Menu aspect()");
			return saisieMenuAspect(p);
		default:
			System.out.println("erreur de saisie");
			return setcorpsfPerso(p);
		}
	}

	public static Object setcorpstPerso(Personnage p)
	{
		if (p.getAspect().isEmpty())
		{
			Persoservice.setAspectdefo(p);
		}
		final String c = Menu.choixTxt("1.Geante 2.Grande 3.Normale 4.Petite 5.Naine 6.Liliputienne 7.Valider et retour menu aspect ");
		switch (c)
		{
		case "1":
			p.getAspect().put("Corpst", "geante");
			System.out.println("mis a geante");
			return setcorpstPerso(p);
		case "2":
			p.getAspect().put("Corpst", "grande");
			System.out.println("mis a grande");
			return setcorpstPerso(p);
		case "3":
			p.getAspect().put("Corpst", "normal");
			System.out.println("mis a normal");
			return setcorpstPerso(p);
		case "4":
			p.getAspect().put("Corpst", "petite");
			System.out.println("mis a petite");
			return setcorpstPerso(p);
		case "5":
			p.getAspect().put("Corpst", "naine");
			System.out.println("mis a naine");
			return setcorpstPerso(p);
		case "6":
			p.getAspect().put("Corpst", "liliputienne");
			System.out.println("mis a liliputienne");
			return setcorpstPerso(p);
		case "7":
			System.out.println("Terminer, retour vers methode Menu aspect()");
			return saisieMenuAspect(p);
		default:
			System.out.println("erreur de saisie");
			return setcorpstPerso(p);
		}
	}
	// override

	// tostring
}
