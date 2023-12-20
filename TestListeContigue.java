/**
 * classe de test pour classe Listecontigue
 */

import static libtest.OutilTest.*;
import static libtest.Lanceur.*;



public class TestListeContigue {
	
	/**
	 * constructeur liste contigue
	 */
	public void test_01_Contructeur()
	{
		//creation de la liste
		Liste lc=new ListeContigue(100);
		
		//verification vide
		int tete=lc.tete();
		assertEquals("la liste devrait etre vide", true, lc.finliste(tete));
	}
	
	/**
	 * creation liste, ajout en tete listevide et verification des valeurs 
	 */
	public void test_02_adjtlis_listeVide()
	{
		//creation de la liste
		Liste lc=new ListeContigue(100);
		lc.adjtlis(new SousTitre(10, "Bonjour"));
		
		//verification non vide
		int tete=lc.tete();
		assertEquals("liste devrait etre non vide", false, lc.finliste(tete));
		
		//test de ce qu'il y a au debut
		SousTitre t=lc.val(tete);
		assertEquals("l'element en tete devrait etre bonjour", "Bonjour", t.getPhrase());
		assertEquals("le temps en tete devrait etre 10", 10, t.getTemps());
		
		//verifier qu'il n'y a rien d'autre
		tete=lc.suc(tete);
		assertEquals("la liste ne devrait avoir qu'un element", true, lc.finliste(tete));
	}
	
	/**
	 * creation liste, ajout en tete liste existante et verification des valeurs 
	 */
	public void test_03_adjtlis_listeNonVide()
	{
		//creation de la liste
		Liste lc=new ListeContigue(100);
		lc.adjtlis(new SousTitre(10, "Bonjour"));
		lc.adjtlis(new SousTitre(20, "Bonjour2"));
		
		//verification non vide
		int tete=lc.tete();
		assertEquals("liste ne devrait pas etre vide", false, lc.finliste(tete));
		
		//test de ce qu'il y a au debut
		SousTitre t=lc.val(tete);
		assertEquals("la liste devrait avoir Bonjour2 en tete", "Bonjour2", t.getPhrase());
		assertEquals("la liste devrait avoir 20 en tete", 20, t.getTemps());
		
		//verifier qu'il n'y a rien d'autre
		tete=lc.suc(tete);
		assertEquals("la liste devrait avoir 2 elements", false, lc.finliste(tete));
		
		//test de ce qu'il y a au debut
		t=lc.val(tete);
		assertEquals("le second element devrait etre Bonjour", "Bonjour", t.getPhrase());
	}
	
	/**
	 * test methode suppression 
	 * suppression en tete liste existante
	 */
	public void test_04_suplis_suppressionTete()
	{
		//creation de la liste
		Liste lc=new ListeContigue(100);
		lc.adjtlis(new SousTitre(10, "Bonjour"));
		lc.adjtlis(new SousTitre(20, "Bonjour2"));
		lc.adjtlis(new SousTitre(30, "Bonjour3"));
		
		//suppression en tete
		lc.suplis(lc.tete());
		
		//verification non vide
		int tete=lc.tete();
		assertEquals("liste ne devrait pas etre vide", false, lc.finliste(tete));
		
		//test de ce qu'il y a au debut
		SousTitre t=lc.val(tete);
		assertEquals("la tete devrait etre Bonjour2", "Bonjour2", t.getPhrase());
		assertEquals("la tete devrait avoir un temps de 20", 20, t.getTemps());
		
		//verifier qu'il n'y a rien d'autre
		tete=lc.suc(tete);
		assertEquals("la liste devrait avoir plus d'un element", false, lc.finliste(tete));
		
		//test de ce qu'il y a au debut
		t=lc.val(tete);
		assertEquals("le second element devrait etre Bonjour", "Bonjour", t.getPhrase());
	}
	
	
	
	/**
	 * test methode suppression 
	 * suppression en tete liste avec un element
	 */
	public void test_05_suplis_SuppressionTeteListe1Element()
	{
		//creation de la liste
		Liste lc=new ListeContigue(100);
		lc.adjtlis(new SousTitre(10, "Bonjour"));
		
		//suppression en tete
		lc.suplis(lc.tete());
		
		//verification vide
		int tete=lc.tete();
		assertEquals("liste devrait etre vide", true, lc.finliste(tete));
	}
	
	/**
	 * test methode suppression 
	 * suppressions en tete successives
	 */
	public void test_06_suplis_SuppressionTetePlusieursFois()
	{
		//creation de la liste
		Liste lc=new ListeContigue(100);
		lc.adjtlis(new SousTitre(10, "Bonjour"));
		lc.adjtlis(new SousTitre(20, "Bonjour2"));
		lc.adjtlis(new SousTitre(30, "Bonjour3"));
		
		
		//suppression en tete
		lc.suplis(lc.tete());
		lc.suplis(lc.tete());
		
		//il ne reste que Bonjour en tete
		
		
		//verification non vide
		int tete=lc.tete();
		assertEquals("liste ne devrait pas etre vide", false, lc.finliste(tete));
		//test bonjour en tete
		SousTitre t=lc.val(tete);
		assertEquals("l'element en tete devrait etre bonjour", "Bonjour", t.getPhrase());
		assertEquals("le temps en tete devrait etre 10", 10, t.getTemps());
		
	}
	
	/**
	 * test methode suppression 
	 * suppressions en queue
	 */
	public void test_07_suplis_SuppressionQueue()
	{
		//creation de la liste
		Liste lc=new ListeContigue(100);
		lc.adjtlis(new SousTitre(10, "Bonjour"));
		lc.adjtlis(new SousTitre(20, "Bonjour2"));
		lc.adjtlis(new SousTitre(30, "Bonjour3"));
		
		
		//suppression en tete
		int place=lc.tete();
		place=lc.suc(place);
		place=lc.suc(place);
		//supprime la queue
		lc.suplis(place);
		
		
		//la liste devrait etre [Bonjour3, bonjour2]
		//verification non vide
		int place2=lc.tete();
		assertEquals("liste ne devrait pas etre vide", false, lc.finliste(place2));
		//test bonjour3 en tete
		SousTitre t=lc.val(place2);
		assertEquals("l'element en tete devrait etre bonjour3", "Bonjour3", t.getPhrase());
		assertEquals("le temps en tete devrait etre 30", 30, t.getTemps());
		//test bonjour2 en second
		place2=lc.suc(place2);
		t=lc.val(place2);
		assertEquals("l'element second devrait etre bonjour2", "Bonjour2", t.getPhrase());
		assertEquals("le second temps devrait etre 20", 20, t.getTemps());
		//test il ne reste rien
		place2=lc.suc(place2);
		assertEquals("il ne devrait avoir que deux elements",true,lc.finliste(place2));		
	}
	
	

	/**
	 * test methode suppression 
	 * suppressions au milieu
	 */
	public void test_08_suplis_SuppressionMilieu()
	{
		//creation de la liste
		Liste lc=new ListeContigue(100);
		lc.adjtlis(new SousTitre(10, "Bonjour"));
		lc.adjtlis(new SousTitre(20, "Bonjour2"));
		lc.adjtlis(new SousTitre(30, "Bonjour3"));
		
		
		//suppression en tete
		int place=lc.tete();
		place=lc.suc(place);
		//supprime le milieu
		lc.suplis(place);
		
		
		//la liste devrait etre [Bonjour3, bonjour]
		//verification non vide
		int place2=lc.tete();
		assertEquals("liste ne devrait pas etre vide", false, lc.finliste(place2));
		//test bonjour3 en tete
		SousTitre t=lc.val(place2);
		assertEquals("element en tete devrait etre bonjour3", "Bonjour3", t.getPhrase());
		assertEquals("temps en tete devrait etre 30", 30, t.getTemps());
		//test bonjour2 en second
		place2=lc.suc(place2);
		t=lc.val(place2);
		assertEquals("second element devrait etre bonjour", "Bonjour", t.getPhrase());
		assertEquals("second temps devrait etre 10", 10, t.getTemps());
		//test il ne reste rien
		place2=lc.suc(place2);
		assertEquals("il ne devrait y avoir que deux elements",true,lc.finliste(place2));		
	}
	
	/**
	 * test methode adjlis 
	 * ajout derriere la tete
	 */
	public void test_09_adjlis_AjoutTete()
	{
		//creation de la liste
		Liste lc=new ListeContigue(100);
		lc.adjtlis(new SousTitre(10, "Bonjour"));
		lc.adjtlis(new SousTitre(20, "Bonjour2"));
		
		//ajout derriere la tete
		lc.adjlis(lc.tete(),new SousTitre(30, "Bonjour3"));
				
		
		//la liste devrait etre [Bonjour2, bonjour3, bonjour]
		//verification non vide
		int place2=lc.tete();
		assertEquals("liste ne devrait pas etre vide", false, lc.finliste(place2));
		//test bonjour2 en tete
		SousTitre t=lc.val(place2);
		assertEquals("element en tete devrait etre bonjour2", "Bonjour2", t.getPhrase());
		assertEquals("temps en tete devrait etre 20", 20, t.getTemps());
		//test bonjour3 en second
		place2=lc.suc(place2);
		t=lc.val(place2);
		assertEquals("le second element devrait etre Bonjour3", "Bonjour3", t.getPhrase());
		assertEquals("le second temps devrait etre 30", 30, t.getTemps());
		//test bonjour en dernier
		place2=lc.suc(place2);
		t=lc.val(place2);
		assertEquals("le troisieme element devrait etre Bonjour", "Bonjour", t.getPhrase());
		assertEquals("le 3e temps devrait etre 10", 10, t.getTemps());		
		//test il ne reste rien
		place2=lc.suc(place2);
		assertEquals("il ne devrait y avoir que 3 elements",true,lc.finliste(place2));		
	}
	
	/**
	 * test methode adjlis 
	 * ajout en Queue
	 */
	public void test_10_adjlis_AjoutQueue()
	{
		//creation de la liste
		Liste lc=new ListeContigue(100);
		lc.adjtlis(new SousTitre(10, "Bonjour"));
		lc.adjtlis(new SousTitre(20, "Bonjour2"));
		lc.adjtlis(new SousTitre(30, "Bonjour3"));
		
		//ajout derriere le dernier
		int place=lc.tete();
		place=lc.suc(place);
		place=lc.suc(place);
		lc.adjlis(place,new SousTitre(40, "Bonjour4"));
				
		
		//la liste devrait etre [Bonjour3, bonjour2, bonjour,bonjour4]
		//verification non vide
		int place2=lc.tete();
		assertEquals("liste ne devrait pas etre vide", false, lc.finliste(place2));
		//test bonjour3 en tete
		SousTitre t=lc.val(place2);
		assertEquals("element en tete devrait etre bonjour3", "Bonjour3", t.getPhrase());
		assertEquals("temps en tete devrait etre 30", 30, t.getTemps());
		//test bonjour2 en second
		place2=lc.suc(place2);
		t=lc.val(place2);
		assertEquals("element second devrait etre Bonjour2", "Bonjour2", t.getPhrase());
		assertEquals("temps second devrait etre 20", 20, t.getTemps());
		//test bonjour en trois
		place2=lc.suc(place2);
		t=lc.val(place2);
		assertEquals("3e element devrait etre Bonjour", "Bonjour", t.getPhrase());
		assertEquals("3e temps devrait etre 10", 10, t.getTemps());
		//test bonjour en dernier
		place2=lc.suc(place2);
		t=lc.val(place2);
		assertEquals("4e element devrait etre bonjour4", "Bonjour4", t.getPhrase());
		assertEquals("4e temps devrait etre 40", 40, t.getTemps());		
		//test il ne reste rien
		place2=lc.suc(place2);
		assertEquals("il ne devrait y avoir que 4 elements",true,lc.finliste(place2));		
	}
	
	/**
	 * test methode adjlis 
	 * ajout au milieu
	 */
	public void test_11_adjlis_AjoutMilieu()
	{
		//creation de la liste
		Liste lc=new ListeContigue(100);
		lc.adjtlis(new SousTitre(10, "Bonjour"));
		lc.adjtlis(new SousTitre(20, "Bonjour2"));
		lc.adjtlis(new SousTitre(30, "Bonjour3"));
		
		//ajout derriere le dernier
		int place=lc.tete();
		place=lc.suc(place);
		lc.adjlis(place,new SousTitre(40, "Bonjour4"));
				
		
		//la liste devrait etre [Bonjour3, bonjour2, bonjour4, bonjour]
		//verification non vide
		int place2=lc.tete();
		assertEquals("liste ne devrait pas etre vide", false, lc.finliste(place2));
		//test bonjour3 en tete
		SousTitre t=lc.val(place2);
		assertEquals("element en tete devrait etre Bonjour3", "Bonjour3", t.getPhrase());
		assertEquals("temps en tete devrait etre 30", 30, t.getTemps());
		//test bonjour2 en second
		place2=lc.suc(place2);
		t=lc.val(place2);
		assertEquals("element en second devrait etre Bonjour2", "Bonjour2", t.getPhrase());
		assertEquals("element en second devrait etre 20", 20, t.getTemps());
		//test bonjour4 en trois
		place2=lc.suc(place2);
		t=lc.val(place2);
		assertEquals("3e element devrait etre Bonjour4", "Bonjour4", t.getPhrase());
		assertEquals("3e temps devrait etre 40", 40, t.getTemps());
		//test bonjour en dernier
		place2=lc.suc(place2);
		t=lc.val(place2);
		assertEquals("4e element devrait etre bonjour", "Bonjour", t.getPhrase());
		assertEquals("4e temps devrait etre 10", 10, t.getTemps());		
		//test il ne reste rien
		place2=lc.suc(place2);
		assertEquals("il ne devrait y avoir que 4 elements",true,lc.finliste(place2));		
	}
	
	
	/**
	 * lancement des tests
	 */
	public static void main(String args[])
	{
		lancer(new TestListeContigue(),args);
		
	}

}
