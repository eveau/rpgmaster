package Entitee;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Personnage version Developpement 0.5<br/>
 *
 * @author baboulou
 */
public class Personnage implements Serializable { // ,List<Personnage> {
	// propriétés de classe
	private static final long serialVersionUID = 1L;
	Inventaire<Object> inventaire;
	List<Object> sac;
	Map<String, Integer> caracteristiques;
	Map<String, String> aspect = new HashMap<>();
	String nom, classe, genre = A;
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

	public Map<String, String> getAspect()
	{
		return aspect;
	}

	public void setAspect(Map<String, String> aspect)
	{
		this.aspect = aspect;
	}

	public void setAspect(String string, String string2)
	{
		final HashMap<String, String> setAspecta = new HashMap<>();
		setAspecta.put(string, string2);
		this.aspect = setAspecta;
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

	// @Override
	// public boolean add(Personnage e)
	// {
	// // TODO Auto-generated method stub
	// return ((Personnage) aspect).add(e);
	// }
	//
	// @Override
	// public void add(int index, Personnage element)
	// {
	// // TODO Auto-generated method stub
	//
	// }
	//
	// @Override
	// public boolean addAll(Collection<? extends Personnage> c)
	// {
	// // TODO Auto-generated method stub
	// return false;
	// }
	//
	// @Override
	// public boolean addAll(int index, Collection<? extends Personnage> c)
	// {
	// // TODO Auto-generated method stub
	// return false;
	// }
	//
	// @Override
	// public void clear()
	// {
	// // TODO Auto-generated method stub
	//
	// }
	//
	// @Override
	// public boolean contains(Object o)
	// {
	// // TODO Auto-generated method stub
	// return false;
	// }
	//
	// @Override
	// public boolean containsAll(Collection<?> c)
	// {
	// // TODO Auto-generated method stub
	// return false;
	// }
	//
	// @Override
	// public Personnage get(int index)
	// {
	// // TODO Auto-generated method stub
	// return null;
	// }
	//
	// @Override
	// public int indexOf(Object o)
	// {
	// // TODO Auto-generated method stub
	// return 0;
	// }
	//
	// @Override
	// public boolean isEmpty()
	// {
	// // TODO Auto-generated method stub
	// return false;
	// }
	//
	// @Override
	// public Iterator<Personnage> iterator()
	// {
	// // TODO Auto-generated method stub
	// return null;
	// }
	//
	// @Override
	// public int lastIndexOf(Object o)
	// {
	// // TODO Auto-generated method stub
	// return 0;
	// }
	//
	// @Override
	// public ListIterator<Personnage> listIterator()
	// {
	// // TODO Auto-generated method stub
	// return null;
	// }
	//
	// @Override
	// public ListIterator<Personnage> listIterator(int index)
	// {
	// // TODO Auto-generated method stub
	// return null;
	// }
	//
	// @Override
	// public boolean remove(Object o)
	// {
	// // TODO Auto-generated method stub
	// return false;
	// }
	//
	// @Override
	// public Personnage remove(int index)
	// {
	// // TODO Auto-generated method stub
	// return null;
	// }
	//
	// @Override
	// public boolean removeAll(Collection<?> c)
	// {
	// // TODO Auto-generated method stub
	// return false;
	// }
	//
	// @Override
	// public boolean retainAll(Collection<?> c)
	// {
	// // TODO Auto-generated method stub
	// return false;
	// }
	//
	// @Override
	// public Personnage set(int index, Personnage element)
	// {
	// // TODO Auto-generated method stub
	// return null;
	// }
	//
	// @Override
	// public int size()
	// {
	// // TODO Auto-generated method stub
	// return 0;
	// }
	//
	// @Override
	// public List<Personnage> subList(int fromIndex, int toIndex)
	// {
	// // TODO Auto-generated method stub
	// return null;
	// }
	//
	// @Override
	// public Object[] toArray()
	// {
	// // TODO Auto-generated method stub
	// return null;
	// }
	//
	// @Override
	// public <T> T[] toArray(T[] a)
	// {
	// // TODO Auto-generated method stub
	// return null;
	// }

	// methodes de classe

	// override

	// tostring
}
