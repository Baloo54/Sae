/**
 * classe de test pour classe Carte 
 */
import static libtest.OutilTest.*;
import static libtest.Lanceur.*;

public class TestListeContigue {
	/**
	 * constructeur de Carte avec parramêtre normal: entre 2 et 99.
	 */
	public void test_01_Contructeur(){
		//creation de la carte
		Carte c=new Carte(50);
		//verification de la valeur
		assertEquals("la Carte devrait avoir pour valeur", 50, c.getValeur());
	}
	/**
	 * constructeur de Carte avec parramêtre inférieur à 2.
	 */
	public void test_02_Contructeur_inf(){
		//creation de la carte
		Carte c=new Carte(-10);
		//verification de la valeur
		assertEquals("la Carte devrait avoir pour valeur", 2, c.getValeur());
	}
	/**
	 * constructeur de Carte avec parramêtre supérieur à 99.
	 */
	public void test_03_Contructeur_sup(){
		//creation de la carte
		Carte c=new Carte(103);
		//verification de la valeur
		assertEquals("la Carte devrait avoir pour valeur", 99, c.getValeur());
	}
	/**
	 * méthode toString: doit renvoyer une châine de carractère sous la forme c** 
	 * où ** est la valeur de la carte.
	 */
	public void test_04_toString(){
		//creation de la carte
		Carte c=new Carte(50);
		//verification de ToSring()
		assertEquals("la châine renvoyer devrait être", "c50", c.ToString());
	}
	/**
	 * méthode etrePlusGrand: carte en paramètre strictement inférieur à this. 
	 */
	public void test_05_etrePlusGrand(){
		//creation de la carte
		Carte c=new Carte(50);
		Carte c2 = new Carte(35);
		//verification de etrePlusGrand
		assertEquals("la méthode doit renvoyer true", true, c.etrePlusGrand(c2));
	}
	/**
	 * méthode etrePlusGrand: carte en paramètre strictement supérieur à this. 
	 */
	public void test_06_etrePlusGrand_sup(){
		//creation de la carte
		Carte c=new Carte(50);
		Carte c2 = new Carte(75);
		//verification de etrePlusGrand
		assertEquals("la méthode doit renvoyer false", false, c.etrePlusGrand(c2));
	}
	/**
	 * méthode etrePlusGrand: carte en paramètre égale à this.
	 */
	public void test_06_etrePlusGrand_egale(){
		//creation de la carte
		Carte c=new Carte(50);
		Carte c2 = new Carte(50);
		//verification de etrePlusGrand
		assertEquals("la méthode doit renvoyer true", false, c.etrePlusGrand(c2));
	}
	/**
	 * méthode avoirDiffDe10: carte en parramètre avec une différence de 10 à this.
	 */
	public void test_07_avoirDiffDe10(){
		//creation de la carte
		Carte c=new Carte(50);
		Carte c2 = new Carte(60);
		//verification de avoirDiffDe10
		assertEquals("la méthode doit renvoyer true", true, c.etrePlusGrand(c2));
	}
	/**
	 * méthode avoirDiffDe10: carte en parramètre avec une différence de (-10) à this.
	 */
	public void test_08_avoirDiffDe10_Moins10(){
		//creation de la carte
		Carte c=new Carte(50);
		Carte c2 = new Carte(40);
		//verification de avoirDiffDe10
		assertEquals("la méthode doit renvoyer true", true, c.etrePlusGrand(c2));
	}
     /**
	 * méthode avoirDiffDe10: carte en parramètre avec une différence pas égale à 10 avec this.
	 */
	public void test_09_avoirDiffDe10_Pas_Egale_10(){
		//creation de la carte
		Carte c=new Carte(50);
		Carte c2 = new Carte(68);
		//verification de avoirDiffDe10
		assertEquals("la méthode doit renvoyer false", false, c.etrePlusGrand(c2));
	}
}
