package Systeme;

import java.io.File;

import Commun.Constante;

/**
 * @author baboulou
 * @param Opération
 *            sur fichiers systèmes<br/>
 *            version Developpement<br/>
 */
public class SysService {
	// propriétés de classe

	// constructeur sans argument
	public SysService() {

	}

	// getter and setter

	// methodes de classe
	public static void creationdesRepertoires()
	{
		final String[] tabRepertoire = { Constante.chemindirJeu, Constante.chemindirPartie, Constante.chemindirPerso };
		File x = new File(tabRepertoire[0]);
		try
		{
			for (int i = 0; i < tabRepertoire.length; i++)
			{
				x = new File(tabRepertoire[i]);
				x.mkdirs();
				Constante.LOGSyService.info("création de " + tabRepertoire[i] + " réussi");
			}
		}
		catch (final Exception e)
		{
			Constante.LOGSyService.severe("erreur de création du répertoire " + x + ", " + e.getCause()
					+ "\nRaison invoquée : " + e.getMessage());
		}
	}
	// override

	// tostring
}
