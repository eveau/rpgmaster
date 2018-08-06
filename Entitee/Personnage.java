package Entitee;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Personnage version Developpement 0.5<br/>
 * 
 * @author baboulou
 */
public class Personnage implements Serializable {
	// propriétés de classe
	private static final long serialVersionUID = 1L;
	Inventaire<Object> inventaire;
	List<Object> sac;
	Map<String, Integer> caracteristiques;
	String nom, classe, aspect, genre = A;
	int pointdeVie = 10, endurance = 10, pointMagie = 10;
	Joueur jId;
	public static final String M = "Masculin", F = "Feminin", TS = "Transgenre", A = "Agenree", AA = "autre";

	// constructeur sans argument
	public Personnage() {

	}

	// getter and setter

	// methodes de classe

	// override

	// tostring
}
