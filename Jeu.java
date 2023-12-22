/**
 * Classe principale du jeu
 * permet de representer un jeu complet
 */
public class Jeu {
    /**
     * la classe posséde 3 attributs
     * main : la main du joueur de type PaquetCartes
     * pioche : la pioche du joueur de type PaquetCartes
     * piles : de type tableau de PileCartes correspondant aux quatre piles
     * du jeu. Les deux premi`eres piles devront ˆetre dans l’ordre croissant et les deux
     * piles suivantes dans l’ordre d ́ecroissant
     */
    private PaquetCartes main;
    private PaquetCartes pioche;
    private PileCartes[] piles;
    /**
     * Constructeur
     * @param max int : nombre de cartes dans la pioche
     * permet de mettre en place une partie standard dans un jeu de max cartes. Il doit créer la pioche
     * mélange des cartes, les différentes piles et créeer la main initiale du joueur (composée
     * de 8 cartes) triée dans l’ordre des cartes.
     */   
    public Jeu(int max) {
        pioche = new PaquetCartes();
        //verifie si max est valide sinon on le met a 100
        max = max > 0 ? max : 100;
        pioche.remplir(max);
        pioche.melangerPaquet();
        // on cree les 4 piles dont les 2 premieres sont croissantes et les 2 dernieres decroissantes
        piles = new PileCartes[4];
        piles[0] = new PileCartes(true,max);
        piles[1] = new PileCartes(true,max);
        piles[2] = new PileCartes(false,max);
        piles[3] = new PileCartes(false,max);
        // on cree la main du joueur avec 8 cartes triees
        main = new PaquetCartes();
        for (int i = 0; i < 8; i++) {
            main.insererTri((pioche.retirerCarte(pioche.getNbCartes() - 1)));
        }
    }
    /**
     * Constructeur avec un paquet de carte
     * @param p PaquetCartes : paquet de cartes
     * permet de creer un paquet de cartes avec un paquet de cartes
     */
    public Jeu(PaquetCartes p) {
        // on verifie que le paquet n'est pas null sinon on le cree
        if(p != null){
            pioche = p;
        }
        else{
            pioche = new PaquetCartes();
            pioche.remplir(100);
        }
        // on cree les 4 piles dont les 2 premieres sont croissantes et les 2 dernieres decroissantes
        piles = new PileCartes[4];
        piles[0] = new PileCartes(true,p.getNbCartes());
        piles[1] = new PileCartes(true,p.getNbCartes());
        piles[2] = new PileCartes(false,p.getNbCartes());
        piles[3] = new PileCartes(false,p.getNbCartes());
        // on cree la main du joueur avec 8 cartes triees
        main = new PaquetCartes();
        for (int i = 0; i < 8; i++) {
            main.insererTri((pioche.retirerCarte(pioche.getNbCartes() - 1)));
        }
    }
    /**
     * methode toString
     * @return String : chaine de caractere representant le jeu
     * permet d'afficher le jeu sous la forme:
     * ################################################
        - PILE 0 : c-c1(1)
        - PILE 1 : c-c1(1)
        - PILE 2 : d-c100(1)        où d = decroissant et c = croissant
        - PILE 3 : d-c100(1)
        ################################################
        Reste nb cartes dans la pioche
        ################################################
        Main du joueur :
        0-c** 1-c** 2-c** 3-c** 4-c** 5-c** 6-c** 7-c**
        ################################################
     */
    public String toString() {
        String result = "################################################\n";
        for (int i = 0; i < piles.length; i++) {
            result += "- PILE " + i + " : " + piles[i].toString() + "\n";
        }
        result += "################################################\n";
        result += "Reste " + pioche.getNbCartes() + " cartes dans la pioche\n";
        result += "################################################\n";
        result += "Main du joueur :\n";
        result += main.toString();
        result += "################################################\n";
        return result;
    }
    /**
     * methode jouerCarte
     * @param  indice int : numéro de la carte à jouer
     * @param numPile int : numéro de la pile sur laquelle on veut jouer
     * @return boolean : true si la carte a été jouée, false sinon
     * permet de jouer une carte sur une pile si elle est posable
     */
    public boolean jouerCarte(int indice, int numPile) {
        boolean joue = false;
        // on verifie que la carte est posable sur la pile et on la pose
        if (piles[numPile].etrePosable(main.getCarte(indice))) {
            joue = true;
            piles[numPile].poserCarte(main.retirerCarte(indice));
        }
        return joue;
    }
    
}