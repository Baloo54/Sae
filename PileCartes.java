/**
 * Classe PileCartes
 * permet de representer une des piles sur laquelle poser des cartes
 */
public class PileCartes{
    /**
     * Attributs
     * croissant boolean:  qui vaut true si les valeurs des cartes pos ́ees sur
     * la pile doivent ˆetre dans l’ordre croissant et false si les valeurs des cartes pos ́ees
     * sur la pile doivent ˆetre dans l’ordre d ́ecroissant 
     * paquet de type PaquetCartes: qui represente la pile de cartes 
     * (la dernière carte du paquet est la carte considéree comme la carte visible)
     */
    private boolean croissant;
    private PaquetCartes paquet;
    /**
     * Constructeur
     * @param pCroissant par défaut 100.
     * @param max int : nombre de cartes maximum dans la pile
     * permet de construire une pile dans le sens pr ́ecis ́e et qui ne contient qu’une seule carte qui depend du sens 
     * par ex: 1 si c'est croissant et 100 si c'est decroissant
     */
    public PileCartes(boolean pCroissant, int max){
        //verifie si max est valide sinon on le met a 100 et qie croissant est valide sinon on le met a true
        max = max > 0 ? max : 100;  
        croissant = pCroissant ? pCroissant : true;
        Carte[] cartes = new Carte[max];
        paquet = new PaquetCartes(cartes);
        paquet.ajouterCarte(new Carte(croissant ? 1 : max), 0);
    }
    /**
     * méthode etrePosable
     * @param c Carte : carte à poser
     * @return boolean : true si la carte peut être posée sur la pile, false sinon 
     * permet de savoir si la carte peut être posée sur la pile en fonction du sens de la pile
     */
    public boolean etrePosable(Carte c){
        // si c'est croissant on verifie que la carte est plus grande que la derniere sinon on verifie qu'elle est plus petite
        int valeur = c.getValeur();
        int derniereValeur = paquet.getDerniereCarte().getValeur();
        return c.avoirDiffDe10(paquet.getDerniereCarte())? true : croissant ? (valeur > derniereValeur) : (valeur < derniereValeur);
    }
    /**
     * méthode poserCarte
     * @param c Carte : carte à poser
     * @return boolean : true si la carte a été posée sur la pile, false sinon
     * permet de poser une carte sur la pile si elle est posable en fin de pile
     */
    public boolean poserCarte(Carte c){
        boolean posable = false;
        // si la carte est posable on l'ajoute a la fin du paquet et on retourne true sinon on retourne false
        if (etrePosable(c)){
            paquet.ajouterCarteFin(c);
           posable = true;
        }
        return posable;
    }
    /**
     * methode ToString
     * @return String : chaine de caractere representant la pile
     * permet d'afficher la pile sous la forme "c-c**-(*)" où c** est la carte visible et (*) est le nombre de cartes dans la pile 
     */
    public String toString(){
        return croissant ? "c-" : "d-" + paquet.getDerniereCarte().toString() + "-(" + paquet.getNbCartes() + ")";
    }
    /**
     * methodes getters
     */
    public boolean getCroissant(){
        return croissant;
    }
    public PaquetCartes getPaquet(){
        return paquet;
    }
}