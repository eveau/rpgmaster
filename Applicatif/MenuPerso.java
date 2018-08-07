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
		final String c = Menu.choixTxt("1.les yeux 2.les cheveux 3.le visage 4.Teint de peau 5.forme du corps 6.tatouage 7.retour menu creation aspect ");
		switch (c)
		{
		case "1":
			System.out.println("vers yeuxPerso pour bleu");
			setyeuxPerso(p);
			break;
		case "2":
			System.out.println("vers PersoService.cheveuxPerso ();");
			break;
		case "3":
			System.out.println("vers PersoService.visagePerso ();");
			break;
		case "4":
			System.out.println("vers PersoService.peauPerso ();");
			break;
		case "5":
			System.out.println("vers PersoService.corps ();");
			break;
		case "6":
			System.out.println("vers PersoService.tatooPerso ();");
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
		final String c = Menu.choixTxt("1.bleu 2.vert 3.gris 4.noisette 5.noirs 6.rouge 7.retour menu aspect ");
		switch (c)
		{
		case "1":
			// final HashMap<String, String> aspectdef = new HashMap<>();
			// aspectdef.putAll(p.getAspect());
			// aspectdef.put("Yeux", "bleux");
			// p.setAspect(aspectdef);
			p.getAspect().put("Yeux", "bleux");
			System.out.println("mis a bleux");
			break;
		case "2":
			p.getAspect().put("Yeux", "vert");
			System.out.println("mis a vert");
			break;
		case "3":
			p.getAspect().put("Yeux", "gris");
			System.out.println("mis a gris");
			break;
		case "4":
			p.getAspect().put("Yeux", "noisette");
			System.out.println("mis a noisette");
			break;
		case "5":
			p.getAspect().put("Yeux", "noirs");
			System.out.println("mis a noirs");
			break;
		case "6":
			p.getAspect().put("Yeux", "rouge");
			System.out.println("mis a rouge");
			break;
		case "7":
			System.out.println("Terminer, retour vers methode Menu aspect()");
			break;
		default:
			System.out.println("erreur de saisie");
			return setyeuxPerso(p);
		}
		return p;
	}

	public static Object setcheveuxPerso(Personnage p)
	{
		if (p.getAspect().isEmpty())
		{
			Persoservice.setAspectdefo(p);
		}
		final String c = Menu.choixTxt("1.bleu 2.vert 3.gris 4.noisette 5.noirs 6.rouge 7.retour menu aspect ");
		switch (c)
		{
		case "1":
			p.getAspect().put("Cheveux", "bleux");
			System.out.println("mis a bleux");
			break;
		case "2":
			p.getAspect().put("Cheveux", "vert");
			System.out.println("mis a vert");
			break;
		case "3":
			p.getAspect().put("Cheveux", "gris");
			System.out.println("mis a gris");
			break;
		case "4":
			p.getAspect().put("Cheveux", "noisette");
			System.out.println("mis a noisette");
			break;
		case "5":
			p.getAspect().put("Cheveux", "noirs");
			System.out.println("mis a noirs");
			break;
		case "6":
			p.getAspect().put("Cheveux", "rouge");
			System.out.println("mis a rouge");
			break;
		case "7":
			System.out.println("Terminer, retour vers methode Menu aspect()");
			break;
		default:
			System.out.println("erreur de saisie");
			return setcheveuxPerso(p);
		}
		return p;
	}
	// override

	// tostring
}
