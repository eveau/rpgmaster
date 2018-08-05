package Systeme;

import Commun.Constante;
import Services.JoueurService;

/**
 * @author baboulou
 * @param Pour
 *            inititialisation de départ au démarrage<br/>
 *            version de Testing<br/>
 */
public class VerifInstallService {
	// propriétés de classe

	// constructeur sans argument
	public VerifInstallService() {

	}

	// getter and setter

	// methodes de classe
	public static void verifInitRep()
	{
		if (!Constante.isJeuRepExist)
		{
			SysService.creationdesRepertoires();
			// a dev utilité ?? Constante.isJeuRepExist = true;
			JoueurService.creationCompteJoueur();
		}

	}
	// override

	// tostring
}
