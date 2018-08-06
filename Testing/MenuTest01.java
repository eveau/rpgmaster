package Testing;

import Applicatif.Menu;
import Commun.Constante;
import Entitee.Joueur;

public class MenuTest01 {
	// propriétés de classe

	// constructeur sans argument
	public MenuTest01() {

	}

	// getter and setter

	// methodes de classe
	public static void testLogger(Joueur j)
	{
		System.out.println("message normal de menu");
		Constante.LOGSyService.info("message d'info");
		Constante.LOGSyService.warning("message warning");
		Constante.LOGSyService.fine("message fine");
		Constante.LOGSyService.finer("message finer");
		Constante.LOGSyService.finest("message finest");
		Constante.LOGSyService.severe("message severe");
		Menu.general(j);
	}
	// override

	// tostring
}
