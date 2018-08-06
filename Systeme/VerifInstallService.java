package Systeme;

import java.io.File;

import Applicatif.Menu;
import Commun.Constante;
import Services.JoueurService;

/**
 * Pour inititialisation de départ au démarrage<br/>
 * version Developpement 0.5<br/>
 * 
 * @author baboulou
 */
public class VerifInstallService {
	// propriétés de classe

	// constructeur sans argument
	public VerifInstallService() {

	}

	// getter and setter

	// methodes de classe
	/**
	 * verifie la création des répertoires puis lance la création du compte joueur que le joueur a une connection autorisée<br/>
	 *
	 * @author baboulou
	 */
	public static void verifInitRep()
	{
		if (!new File(Constante.repertoireJeu).exists())
		{
			SysService.creationdesRepertoires();
			// a dev utilité ?? Constante.isJeuRepExist = true;
			Menu.ifechier();
			JoueurService.creationCompteJoueur();
		}

	}
	// override

	// tostring
}
