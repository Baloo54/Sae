import static libtest.Lanceur.lancer;
import static libtest.OutilTest.assertEquals;
import libtest.*;


/**
 * classe de test qui permet de verifier que la classe Paquet
 * fonctionne correctement
 */ 
public class TestPaquetCartes {

	/**
	 * methode de lancement des tests
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		lancer(new TestPaquetCartes(), args);
	}

	/**
	 * test du constructeur vide
	 */
	/*@Test*/
	public void test1_constructeur() {
		PaquetCartes paquet = new PaquetCartes();
		assertEquals("paquet devrait avoir 0 carte", 0, paquet.getNbCartes());
	}

	/**
	 * test du constructeur parametres
	 */
	/*@Test*/
	public void test2_constructeurParam() {
		Carte[] tab = new Carte[3];
		tab[0] = new Carte(2);
		tab[1] = new Carte(3);
		tab[2] = new Carte(4);
					
		PaquetCartes paquet = new PaquetCartes(tab);
		assertEquals("paquet devrait avoir 3 cartes", 3, paquet.getNbCartes());
	}
	/**
	 * test du constructeur parametres null
	 */
	/*@Test*/
	public void test3_constructeurParamNull() {
		Carte[] tab = null;
					
		PaquetCartes paquet = new PaquetCartes(tab);
		assertEquals("paquet devrait avoir 0 cartes", 0, paquet.getNbCartes());
	}

	/**
	 * test getCarte
	 */
	/*@Test*/
	public void test4_getCarte_ok() {
		Carte[] tab = new Carte[3];
		tab[0] = new Carte(2);
		tab[1] = new Carte(3);
		tab[2] = new Carte(4);
					
		PaquetCartes paquet = new PaquetCartes(tab);
		assertEquals("paquet devrait avoir 3 cartes", 3, paquet.getNbCartes());

                Carte c = paquet.getCarte(1);
		assertEquals("la carte 1 a pour valeur 2", 3, c.getValeur());
	}

	/**
	 * test getCarte hors tableau
	 */
	/*@Test*/
	public void test5_getCarte_horsTableau() {
		Carte[] tab = new Carte[3];
		tab[0] = new Carte(2);
		tab[1] = new Carte(3);
		tab[2] = new Carte(4);
					
		PaquetCartes paquet = new PaquetCartes(tab);
		assertEquals("paquet devrait avoir 3 cartes", 3, paquet.getNbCartes());

                Carte c = paquet.getCarte(3);
		assertEquals("la carte 3 n'existe pas", null, c);
	}
	/**
	 * test ajoutCarteFin ok
	 */
	/*@Test*/
	public void test6_ajoutCarteFin() {
		Carte[] tab = new Carte[3];
		tab[0] = new Carte(2);
		tab[1] = new Carte(3);
		tab[2] = new Carte(4);
					
		PaquetCartes paquet = new PaquetCartes(tab);
		paquet.ajouterCarteFin(new Carte(5));

		assertEquals("paquet devrait avoir 4 cartes", 4, paquet.getNbCartes());

                // chaque carte doit etre bien placee: place i => valeur i+1
        for (int i=0;i<3;i++) {
			Carte c = paquet.getCarte(i);
			assertEquals("la carte "+i+"a pour valeur"+(i+2), i+2, c.getValeur());	
		}
	}
	/**
	 * test ajoutCarteFin avec carte null
	 */
	/*@Test*/
	public void test7_ajoutCarteFinNull() {
		Carte[] tab = new Carte[3];
		tab[0] = new Carte(2);
		tab[1] = new Carte(3);
		tab[2] = new Carte(4);
					
		PaquetCartes paquet = new PaquetCartes(tab);
		paquet.ajouterCarteFin(null);

		assertEquals("paquet devrait avoir 3 cartes", 3, paquet.getNbCartes());

				// chaque carte doit etre bien placee: place i => valeur i+1
		for (int i=0;i<3;i++) {
			Carte c = paquet.getCarte(i);
			assertEquals("la carte "+i+"a pour valeur"+(i+2), i+2, c.getValeur());	
		}
	}
	/**
	 * test retirerCarte ok
	 */
	/*@Test*/
	public void test8_retirerCarte() {
		Carte[] tab = new Carte[3];
		tab[0] = new Carte(2);
		tab[1] = new Carte(3);
		tab[2] = new Carte(4);
					
		PaquetCartes paquet = new PaquetCartes(tab);
		Carte c = paquet.retirerCarte(2);
		
		// test paquet
		assertEquals("paquet devrait avoir 2 cartes", 2, paquet.getNbCartes());
		assertEquals("premiere carte valeur 1", 2, paquet.getCarte(0).getValeur());
		assertEquals("seconde carte valeur 3", 3, paquet.getCarte(1).getValeur());
			
		// test carte retournee
		assertEquals("carte retiree a pour valeur 4", 4, c.getValeur());
	}
	/**
	 * test retirerCarte hors tableau: indice supérieur au nombre de carte
	 */
	/*@Test*/
	public void test9_retirerCarteHorsTableau_sup() {
		Carte[] tab = new Carte[3];
		tab[0] = new Carte(2);
		tab[1] = new Carte(3);
		tab[2] = new Carte(4);
					
		PaquetCartes paquet = new PaquetCartes(tab);
		Carte c = paquet.retirerCarte(3);
		
		// test paquet
		assertEquals("paquet devrait avoir 3 cartes", 3, paquet.getNbCartes());
		assertEquals("premiere carte valeur 1", 2, paquet.getCarte(0).getValeur());
		assertEquals("seconde carte valeur 3", 3, paquet.getCarte(1).getValeur());
		assertEquals("troisième carte valeur 4", 4, paquet.getCarte(2).getValeur());
			
		// test carte retournee
		assertEquals("carte retiree a pour valeur null", null, c);
	}
	/**
	 * test retirerCarte hors tableau: indice négatif
	 */
	/*@Test*/
	public void test10_retirerCarteHorsTableau_inf() {
		Carte[] tab = new Carte[3];
		tab[0] = new Carte(2);
		tab[1] = new Carte(3);
		tab[2] = new Carte(4);
					
		PaquetCartes paquet = new PaquetCartes(tab);
		Carte c = paquet.retirerCarte(-1);
		
		// test paquet
		assertEquals("paquet devrait avoir 3 cartes", 3, paquet.getNbCartes());
		assertEquals("premiere carte valeur 1", 2, paquet.getCarte(0).getValeur());
		assertEquals("seconde carte valeur 3", 3, paquet.getCarte(1).getValeur());
		assertEquals("troisième carte valeur 4", 4, paquet.getCarte(2).getValeur());
			
		// test carte retournee
		assertEquals("carte retiree a pour valeur null", null, c);
	}
	/**
	 * test ajoutCarteDebut ok avec la methode ajouterCarteDebut
	 */
	/*@Test*/
	public void test12_ajoutCarteDebut() {
		Carte[] tab = new Carte[3];
		tab[0] = new Carte(2);
		tab[1] = new Carte(3);
		tab[2] = new Carte(4);
					
		PaquetCartes paquet = new PaquetCartes(tab);
		paquet.ajouterCarteDebut(new Carte(5));

		assertEquals("paquet devrait avoir 4 cartes", 4, paquet.getNbCartes());

		// chaque carte doit etre bien placee: place i => valeur i+2
		for (int i=0;i<3;i++) {
			Carte c = paquet.getCarte(i+1);
			assertEquals("la carte "+i+"a pour valeur"+(i+2), i+2, c.getValeur());	
		}	
		Carte c = paquet.getCarte(0);
		assertEquals("la carte 0 a pour valeur 4", 5, c.getValeur());
	}
	/**
	 * test ajoutCarteDebut avec carte null
	 */
	/*@Test*/
	public void test13_ajoutCarteDebutNull() {
		Carte[] tab = new Carte[3];
		tab[0] = new Carte(2);
		tab[1] = new Carte(3);
		tab[2] = new Carte(4);
					
		PaquetCartes paquet = new PaquetCartes(tab);
		paquet.ajouterCarteDebut(null);

		assertEquals("paquet devrait avoir 3 cartes", 3, paquet.getNbCartes());

		// chaque carte doit etre bien placee: place i => valeur i+2
		for (int i=0;i<3;i++) {
			Carte c = paquet.getCarte(i);
			assertEquals("la carte "+i+"a pour valeur"+(i+2), i+2, c.getValeur());	
		}	
	}
	/**
	 * test ajouterCarte ok avec la methode ajouterCarte
	 */
	/*@Test*/
	public void test14_ajouterCarte() {
		Carte[] tab = new Carte[3];
		tab[0] = new Carte(2);
		tab[1] = new Carte(3);
		tab[2] = new Carte(4);
					
		PaquetCartes paquet = new PaquetCartes(tab);
		paquet.ajouterCarte(new Carte(5),1);

		assertEquals("paquet devrait avoir 4 cartes", 4, paquet.getNbCartes());
		Carte a = paquet.getCarte(0);
		Carte b = paquet.getCarte(1);
		Carte c = paquet.getCarte(2);
		Carte d = paquet.getCarte(3);		
		assertEquals("la carte "+0+" a pour valeur "+(2), 2, a.getValeur());		
		assertEquals("la carte "+1+" a pour valeur "+(3), 3, b.getValeur());		
		assertEquals("la carte "+2+" a pour valeur "+(5), 5, c.getValeur());		
		assertEquals("la carte "+3+" a pour valeur "+(4), 4, d.getValeur());		
	}
	/**
	 * test ajouterCarte avec carte null
	 */
	/*@Test*/
	public void test15_ajouterCarteNull() {
		Carte[] tab = new Carte[3];
		tab[0] = new Carte(2);
		tab[1] = new Carte(3);
		tab[2] = new Carte(4);
					
		PaquetCartes paquet = new PaquetCartes(tab);
		paquet.ajouterCarte(null,1);

		assertEquals("paquet devrait avoir 3 cartes", 3, paquet.getNbCartes());
		Carte a = paquet.getCarte(0);
		Carte b = paquet.getCarte(1);
		Carte c = paquet.getCarte(2);
		assertEquals("la carte "+0+" a pour valeur "+(2), 2, a.getValeur());		
		assertEquals("la carte "+1+" a pour valeur "+(4), 4, c.getValeur());		
		assertEquals("la carte "+2+" a pour valeur "+(3), 3, b.getValeur());		
	}
	/**
	 * test ajouterCarte hors tableau: indice supérieur au nombre de carte
	 */
	/*@Test*/
	public void test16_ajouterCarteHorsTableau_sup() {
		Carte[] tab = new Carte[3];
		tab[0] = new Carte(2);
		tab[1] = new Carte(3);
		tab[2] = new Carte(4);
	   /*@Test*/
	   
		PaquetCartes paquet = new PaquetCartes(tab);
		paquet.ajouterCarte(new Carte(5),3);

		assertEquals("paquet devrait avoir 3 cartes", 3, paquet.getNbCartes());
		Carte a = paquet.getCarte(0);
		Carte b = paquet.getCarte(1);
		Carte c = paquet.getCarte(2);
		assertEquals("la carte "+0+" a pour valeur "+(2), 2, a.getValeur());		
		assertEquals("la carte "+1+" a pour valeur "+(3), 3, b.getValeur());		
		assertEquals("la carte "+2+" a pour valeur "+(4), 4, c.getValeur());		
	}
	/**
	 * test ajouterCarte hors tableau: indice négatif
	 */
	/*@Test*/
	public void test17_ajouterCarteHorsTableau_inf() {
		Carte[] tab = new Carte[3];
		tab[0] = new Carte(2);
		tab[1] = new Carte(3);
		tab[2] = new Carte(4);
					
		PaquetCartes paquet = new PaquetCartes(tab);
		paquet.ajouterCarte(new Carte(5),-1);

		assertEquals("paquet devrait avoir 3 cartes", 3, paquet.getNbCartes());
		Carte a = paquet.getCarte(0);
		Carte b = paquet.getCarte(1);
		Carte c = paquet.getCarte(2);
		assertEquals("la carte "+0+" a pour valeur "+(2), 2, a.getValeur());		
		assertEquals("la carte "+1+" a pour valeur "+(3), 3, b.getValeur());		
		assertEquals("la carte "+2+" a pour valeur "+(4), 4, c.getValeur());		
	}
	/**
	 * test constructeur avec un tableau contenanr une carte null
	 */
	/*@Test*/
	public void test18_constructeurParamNull() {
		Carte[] tab = new Carte[3];
		tab[0] = new Carte(2);
		tab[1] = null;
		tab[2] = new Carte(4);
					
		PaquetCartes paquet = new PaquetCartes(tab);
		assertEquals("paquet devrait avoir 2 cartes", 2, paquet.getNbCartes());
		Carte a = paquet.getCarte(0);
		Carte b = paquet.getCarte(1);
		assertEquals("la carte "+0+" a pour valeur "+(2), 2, a.getValeur());		
		assertEquals("la carte "+1+" a pour valeur "+(4), 4, b.getValeur());		
	}
	/**
	 * 
	 */
}