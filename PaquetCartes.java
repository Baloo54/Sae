java.util.random
/**
 * Classe PaquetCartes :
 * permet de représenter un paquet de cartes du jeu the game
 */
class PaquetCartes{
    /**
     * attribut Paquet : tableau de Carte
    */
    private Carte[] Paquet;
    /**
     * constructeur vide
     */
    public PaquetCartes(){
        Paquet = new Carte[0];
    }
    /**
     * constructeur parametre
     * @param tab : tableau de Carte
     */
    public PaquetCartes(Carte[] tab){
        // verifier que le tableau n'est pas null
        Paquet = tab != null ? tab : new Carte[0];
    }
    /**
     * methode getNbCartes
     * @return int : nombre de cartes dans le paquet
     */
    public int getNbCartes(){
        return Paquet.length;
    }
    /**
     * methode getCarte
     * @param indice : indice de la carte à retourner
     * @return Carte : la carte à l'indice indice
     */
    public Carte getCarte(int indice){
        // verifier que l'indice est correct
        return Paquet.length - 1 < indice || indice < 0 ? null : Paquet[indice];
    }
    /**
     * methode ajouterCarteFin
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
     * methode retirerCarte
     * @param place : indice de la carte à retirer
     * @return Carte : la carte retirée
     */
    public Carte retirerCarte(int place){
        Carte carte = null;
        // verifier que l'indice est correct
        if(!(Paquet.length -1 < place) ||!(place < 0 )){
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
     * methode toString
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
     * methode ajouterCarteDebut
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
     * methode ajouterCarte
     * @param c : carte à ajouter
     * @param place : indice de la carte à ajouter
     */
    public void ajouterCarte(Carte c, int place){
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
    /**
     * methode remplir
     * doit remplir le paquet avec des cartes de valeur 2 à max -1
     * @param max : valeur max des cartes à ajouter
     */
    public void remplir(int max) {
      for (int valeur = 2; valeur < max-1; valeur++) {
          ajouterCarteFin(new Carte(valeur));
      }
    }
    public PaquetCartes(int[] tab){
      int taille = tab.length;
      Carte[] tableau = new Carte[taille];
      for(int i = 0; i < taille; i++){
        tableau[i] = tab[i];
      }
    }
      public Carte getDerniereCarte() {
        return Paquet.getCarte(Paquet.length - 1);
    }
      public boolean etreVide(){
        return Paquet.length == 0 ? true : false;
      }

}
