/**
 * Classe PaquetCartes :
 * permet de représenter un paquet de cartes du jeu the game
 */
class PaquetCartes{
    /**
     * attribut Paquet : tableau de Carte
     * represente le paquet de cartes
    */
    private Carte[] Paquet;
    /**
     * constructeur vide
     * permet de creer un paquet de cartes vide
     */
    public PaquetCartes(){
        Paquet = new Carte[0];
    }
    /**
     * constructeur parametre
     * permet de creer un paquet de cartes à partir d'un tableau de cartes
     * @param tab : tableau de Carte
     */
    public PaquetCartes(Carte[] tab){
        // verifier que le tableau n'est pas null et vérifier que les cartes sont correctes
        if(tab != null){
            //verifie le nombre de cartes incorrectes
            int nbCartesIncorrectes = 0;
            for(int i = 0; i < tab.length; i++){
                if(tab[i] == null) nbCartesIncorrectes++;
            }
            Paquet = new Carte[tab.length - nbCartesIncorrectes];
            int j = 0;
            for(int i = 0; i < tab.length; i++){
                if(tab[i] != null) Paquet[j++] = tab[i];
            }
        }
        else Paquet = new Carte[0];
    }
     /**
     * constructeur parametre int[]
     * permet de creer un paquet de cartes à partir d'un tableau d'entiers
     * @param tab : tableau d'entiers
     */
    public PaquetCartes(int[] tab){
        //verifie tab soit correct
        if(tab != null){
            //verifie le nombre de cartes incorrectes
            int nbCartesIncorrectes = 0;
            for(int i = 0; i < tab.length; i++){
                if(tab[i] < 2 && tab[i] > 99) nbCartesIncorrectes++;
            }
            Paquet = new Carte[tab.length - nbCartesIncorrectes];
            int j = 0;
            for(int i = 0; i < tab.length; i++){
                if(tab[i] >= 2 && tab[i] <= 99) Paquet[j++] = new Carte(tab[i]);
            }
        }
        else Paquet = new Carte[0];
    }
    /**
     * methode toString
     * permet d'afficher le paquet de cartes
     * @return String : representation du paquet de cartes
     */
    public String toString(){
        String res = "--------------------------\n";
        for(int i = 0; i < Paquet.length; i++){
            res += i + ".  carte(" + Paquet[i].getValeur() + ")\n";
        }
        return res+= "--------------------------";
    }
    /**
     * methode retirerCarte
     * permet de retirer une carte du paquet
     * @param place : indice de la carte à retirer
     * @return Carte : la carte retirée
     */
    public Carte retirerCarte(int place){
        Carte carte = null;
        // verifier que l'indice est correct
        if(!(Paquet.length - 1 < place) && !(place < 0 )){
            carte = Paquet[place];
            int taille = Paquet.length;
            Carte[] tabTmp = new Carte[taille -1];
            int j = 0;
            for(int i = 0; i < taille; i++){
                if(i != place)tabTmp[j++] = Paquet[i];
            }
            Paquet = tabTmp;
            }
        return carte;
    }
    /**
     * methode ajouterCarteDebut
     * permet d'ajouter une carte au debut du paquet
     * @param carte : carte à ajouter au debut du paquet
     */
    public void ajouterCarteDebut(Carte carte){
        if (carte != null){
            int taille = Paquet.length;
            Carte[] tabTmp = new Carte[taille + 1];
            tabTmp[0] = carte;
            for(int i = 0; i < taille; i++){
                tabTmp[i+1] = Paquet[i];
            }
            Paquet = tabTmp;
            }
    }
     /**
     * methode ajouterCarteFin
     * permet d'ajouter une carte à la fin du paquet
     * @param carte : carte à ajouter à la fin du paquet
     */
    public void ajouterCarteFin(Carte carte){
        if (carte != null){
            int taille = Paquet.length;
            Carte[] tabTmp = new Carte[taille + 1];
            for(int i = 0; i < taille; i++){
                tabTmp[i] = Paquet[i];
            }
            tabTmp[taille] = carte;
            Paquet = tabTmp;
            }
    }
    /**
     * methode ajouterCarte
     * permet d'ajouter une carte à une place donnée
     * @param c : carte à ajouter
     * @param place : indice de la carte à ajouter
     */
    public void ajouterCarte(Carte c, int place){
        // verifier que l'indice est correct et que la carte n'est pas null
        if (c != null && !(Paquet.length - 1 < place) && !(place < 0 )){
            int taille = Paquet.length, d = place + 1, j = 0;
            Carte[] tabTmp = new Carte[taille + 1];
            for (int i = 0; i < taille; i++) {
                if (i != d) {
                    tabTmp[j++] = Paquet[i];
                }
                else {
                    tabTmp[j++] = c;
                    tabTmp[j++] = Paquet[i];
                }
            }
            Paquet = tabTmp;
            }
    }
    /**
     * methode remplir
     * doit remplir le paquet avec des cartes de valeur 2 à max -1
     * @param max : valeur max des cartes à ajouter
     */
    public void remplir(int max) {
        // verifier que max est correct
        if (max > 2) {
            Carte[] tabTmp = new Carte[max-1];
            for (int valeur = 2; valeur < max; valeur++) {
                tabTmp[valeur-2] = new Carte(valeur);
            }
            Paquet = tabTmp;
        }
    }
    /**
     * methode etreVide
     * permet de savoir si le paquet est vide
     * @return boolean : true si le paquet est vide, false sinon
     */
    public boolean etreVide(){
        return Paquet.length == 0 ? true : false;
    }
    /**
     * methode getDerniereCarte 
     * permet de retourner la derniere carte du paquet
     * @return Carte : derniere carte du paquet
     */
    public Carte getDerniereCarte() {
        return Paquet[Paquet.length - 1];
    }
     /**
     * methode getNbCartes
     * permet de retourner le nombre de cartes dans le paquet
     * @return int : nombre de cartes dans le paquet
     */
    public int getNbCartes(){
        return Paquet.length;
    }
    /**
     * methode getCarte
     * permet de retourner une carte du paquet
     * @param indice : indice de la carte à retourner
     * @return Carte : la carte à l'indice indice
     */
    public Carte getCarte(int indice){
        // verifier que l'indice est correct
        return Paquet.length - 1 < indice || indice < 0 ? null : Paquet[indice];
    }
}
