import static libtest.Lanceur.lancer;
import static libtest.OutilTest.assertEquals;

public class TestPileCartes {
    /**
     * lancement des tests
     */
public static void main(String args[])
    {
        lancer(new TestPileCartes(),args);
    }
    
    /**
     * test des methodes
     */
    public void test_1_testBooleenVrai(){
        PileCartes pile = new PileCartes(true, 20);
        assertEquals("le booleen doit renvoyer true", true, pile.getCroissant());
    }
    public void test_2_testBooleenFaux(){
        PileCartes pile = new PileCartes(false, 20);
        assertEquals("le booleen doit renvoyer false", false, pile.getCroissant());
    }
    public void test_3_testConstructeurDefaut(){
        PileCartes pile = new PileCartes(false, -100);
        assertEquals("la valeur max, étant incorrecte, elle doit renvoyer 100", 100, pile.getPaquet().getDerniereCarte().getValeur());
    }
    public void test_4_testPileOk(){
        PileCartes pile = new PileCartes(true,20);
        assertEquals("le constructeur doit creer une pile de 20 cartes", 20, pile.getPaquet());
    }
    
        // question 5.2
    public void test_5_testEtrePosableOK(){
        PileCartes pile = new PileCartes(true, 20);
        boolean res = pile.etrePosable(new Carte(15));
        assertEquals("la methode ne fonctionne pas", true, res);
    }
    public void test_6_testPoserCarteOK(){
        // question 5.3
        PileCartes pile = new PileCartes(true, 20);
        boolean res2 = pile.poserCarte(new Carte(13));
        assertEquals("La methode poserCarte ne fonctionne pas", true, res2);
    }
    public void test_7_testToStringOK(){
        PileCartes pile = new PileCartes(true, 50);        
        Carte carte = new Carte(15);
        pile.getPaquet().ajouterCarteDebut(carte);
        assertEquals("La représentation toString d'une pile croissante avec une seule carte n'est pas correcte","c-c15-(1)",pile.toString());
}
}

 

