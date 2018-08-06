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

	public static void compareStringInt()
	{
		final String e = Menu.choixTxt("1.oui 2.non ");

		if (e.equals("1"))
		{
			System.out.println("e.equals(\"1\") vrai)");
		}
		else
		{
			System.out.println("e.equals(\"1\") faux)");
		}
		if (e.equals(1))
		{
			System.out.println("e.equals(1) vrai)");
		}
		else
		{
			System.out.println("e.equals(1) faux)");
		}

		if (e.contentEquals("1"))
		{
			System.out.println("e.contentEquals(\"1\") vrai)");
		}
		else
		{
			System.out.println("e.contentEquals(\"1\") faux)");
		}
		// if (Integer.parseInt(e) == 1)
		// {
		// System.out.println("Integer.parseInt(e)==1 vrai)");
		// }
		// else
		// {
		// System.out.println("Integer.parseInt(e)==1 faux)");
		// }

		if (e == "1")
		{
			System.out.println("e==\"1\") vrai)");
		}
		else
		{
			System.out.println("e==\"1\") faux)");
		}
		if (e == String.valueOf(1))
		{
			System.out.println("e == String.valueOf(1) vrai)");
		}
		else
		{
			System.out.println("e == String.valueOf(1) faux)");
		}

	}
	// override

	// tostring
}
