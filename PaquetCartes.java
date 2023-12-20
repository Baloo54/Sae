class PaquetCartes{
    private Carte[] cartes;
    public PaquetCartes(){
        cartes = new Carte[0];
    }
    public PaquetCartes(Carte[] tab){
        cartes = tab;
    }
    public int getNbCartes(){
        return cartes.length;
    }
    public Carte getCarte(int indice){
        return cartes.length - 1 < indice || indice < 0 ? null : cartes[indice];
    }
    public void ajouterCarteFin(Carte carte){
        int taille = cartes.length;
        Carte[] tabTmp = new Carte[taille + 1];
        for(int i = 0; i < taille; i++){
            tabTmp[i] = cartes[i];
        }
        tabTmp[taille] = carte;
        cartes = tabTmp;
    }
    public Carte retirerCarte(int place){
        if(cartes.length -1 < place || place < 0 )return null;
        int taille = cartes.length;
        Carte carte = null ;
        Carte[] tabTmp = new Carte[taille -1];
        int j = 0;
        for(int i = 0; i < taille; i++){
            if(i != place)tabTmp[j++] = cartes[i];
            else carte = cartes[i];
        }
        cartes = tabTmp;
        return carte;
    }
    public String toString(){
        String res = "--------------------------\n";
        for(int i = 0; i < cartes.length; i++){
            res += i + ".  carte(" + cartes[i].getValeur() + ")\n";
        }
        return res+= "--------------------------";
    }
    public void ajouterCarteDebut(Carte carte){
        int taille = cartes.length;
        Carte[] tabTmp = new Carte[taille + 1];
        tabTmp[0] = carte;
        for(int i = 0; i < taille; i++){
            tabTmp[i+1] = cartes[i];
        }
        cartes = tabTmp;
    }
    public void ajouterCarte(Carte c, int place){
        int taille = cartes.length;
        int d = place + 1;
        Carte[] tabTmp = new Carte[taille + 1];
        int j = 0;
        for (int i = 0; i < taille; i++) {
            if (i != d) {
                tabTmp[j++] = cartes[i];
            }
            else {
                tabTmp[j++] = c;
                tabTmp[j++] = cartes[i];
            }
        }
        cartes = tabTmp;

    }
    vpublic void remplir(int max) {
        if (max >= 2) {
          int nombreDeCartes = max - 2;
          cartes = new Carte[nombreDeCartes];
          for (int i = 0; i < nombreDeCartes; i++) {
              cartes[i] = new Carte(i + 2);
            }
        }
    }
}
