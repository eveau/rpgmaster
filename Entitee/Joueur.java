package Entitee;

import java.io.Serializable;
import java.util.List;

/**
 * Un Joueur peut avoir plusieurs parties.<br/>
 * Un joueur peut avoir plusieurs persos. <br/>
 * Chaque partie contient 1 seul perso.<br/>
 * version Developpement 0.5<br/>
 * 
 * @author baboulou
 */
public class Joueur implements Serializable {
	// propriétés de classe
	private static final long serialVersionUID = 1L;
	private String identifiant, mail, motDePasse;
	boolean isidentifie = false;
	// ArrayList<Personnage> vListe2persos;
	List<Personnage> jListe2persos;

	// List<Partie> vListe2parties;
	// constructeur sans argument
	public Joueur() {

	}

	// getter and setter
	public String getIdentifiant()
	{
		return identifiant;
	}

	public void setIdentifiant(String identifiant)
	{
		this.identifiant = identifiant;
	}

	public String getMail()
	{
		return mail;
	}

	public void setMail(String mail)
	{
		this.mail = mail;
	}

	public String getMotDePasse()
	{
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse)
	{
		this.motDePasse = motDePasse;
	}

	public boolean isIsidentifie()
	{
		return isidentifie;
	}

	public void setIsidentifie(boolean isidentifie)
	{
		this.isidentifie = isidentifie;
	}

	@Override
	public String toString()
	{
		return "Joueur [identifiant=" + identifiant + ", mail=" + mail + ", motDePasse=" + motDePasse + ", isidentifie=" + isidentifie + ", jListe2persos=" + jListe2persos + "]";
	}

	// methodes de classe

	// override

	// tostring
}
