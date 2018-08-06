package Commun;

import java.util.logging.Logger;

import Applicatif.Demarrage;
import Services.JoueurService;
import Services.Persoservice;
import Systeme.SysService;

/**
 * @author baboulou
 * @param Constantes
 *            générales<br/>
 *            version Developpement 0.5<br/>
 */
public class Constante {
	// propriétés de classe
	public final static String repertoireCourant = System.getProperty("user.dir");
	public final static String repertoireJeu = "jeu\\";
	public final static String repertoirePartie = "partie\\";
	public final static String repertoirePerso = "personnage\\";

	public final static String chemindirJeu = repertoireCourant + "\\" + repertoireJeu;
	public final static String chemindirPartie = chemindirJeu + "\\" + repertoirePartie;
	public final static String chemindirPerso = chemindirJeu + "\\" + repertoirePerso;

	public final static String fichier1Personnage = chemindirPerso + "unperso.bin";
	public final static String listeDePersos = chemindirPerso + "liste2persos.bin";
	public final static String fichier1Partie = chemindirPartie + "unepartie.bin";
	public final static String listeDeParties = chemindirPartie + "liste2parties.bin";
	public final static String fichierJoueur = chemindirJeu + "compteJoueur.bin";

	public static final Logger LOGSyService = Logger.getLogger(SysService.class.getName());
	public static final Logger LOGPersoservice = Logger.getLogger(Persoservice.class.getName());
	public static final Logger LOGJoueurService = Logger.getLogger(JoueurService.class.getName());
	// public static final Logger LOGMenu =
	// Logger.getLogger(Menu.class.getName());
	public static final Logger LOGDemarrage = Logger.getLogger(Demarrage.class.getName());

	// constructeur sans argument
	public Constante() {

	}

	// getter and setter

	// methodes de classe
	public static String msge(Exception e)
	{
		return "erreur: " + e.getMessage() + " a cause de: " + e.getCause();
	}
	// override

	// tostring
}
