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
	int pointdeVie = 10, endurance = 10, pointMagie = 10, pId;
	public static final String M = "Masculin", F = "Feminin", TS = "Transgenre", A = "Agenree", AA = "autre";

	// constructeur sans argument
	public Personnage() {

	}

	// getter and setter
	public Map<String, Integer> getCaracteristiques()
	{
		return caracteristiques;
	}

	public void setCaracteristiques(Map<String, Integer> caracteristiques)
	{
		this.caracteristiques = caracteristiques;
	}

	public String getNom()
	{
		return nom;
	}

	public void setNom(String nom)
	{
		this.nom = nom;
	}

	public String getClasse()
	{
		return classe;
	}

	public void setClasse(String classe)
	{
		this.classe = classe;
	}

	public String getAspect()
	{
		return aspect;
	}

	public void setAspect(String aspect)
	{
		this.aspect = aspect;
	}

	public String getGenre()
	{
		return genre;
	}

	public void setGenre(String genre)
	{
		this.genre = genre;
	}

	public int getPointdeVie()
	{
		return pointdeVie;
	}

	public void setPointdeVie(int pointdeVie)
	{
		this.pointdeVie = pointdeVie;
	}

	public int getEndurance()
	{
		return endurance;
	}

	public void setEndurance(int endurance)
	{
		this.endurance = endurance;
	}

	public int getPointMagie()
	{
		return pointMagie;
	}

	public void setPointMagie(int pointMagie)
	{
		this.pointMagie = pointMagie;
	}

	public int getPId()
	{
		return pId;
	}

	public void setPId(int pId)
	{
		this.pId = pId;
	}

	@Override
	public String toString()
	{
		return "\nPersonnage [nom=" + nom + ", classe=" + classe + ", caracteristiques=" + caracteristiques + ", inventaire=" + inventaire + ", sac=" + sac + ", aspect=" + aspect + ", genre=" + genre + ", pointdeVie="
				+ pointdeVie + ", endurance=" + endurance + ", pointMagie=" + pointMagie + ", pId=" + pId + "]\n";
	}

	// methodes de classe

	// override

	// tostring
}
