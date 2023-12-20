/**
* La classe Carte qui a pour objectif de représenter une carte du jeu "The Game"
*/
public class Carte{
    /**
     * attribut valeur de type entier qui represente la valeur de la carte
  	 */
     private int valeur;
     /**
	    *getter nomme getValeur retournant la valeur de la carte
      *@return valeur
	    */
      public int getValeur(){
        return valeur;
      }
      /**
       *constructeur avec un parametre de type entier construisant une carte qui a pour attribut valeur, la valeur passé en parametre
       *@param v correspond à la valeur de la carte
       */
       public Carte(int v){
         //on verifie que v n'excede pas 99 ou n'est pas inferieur à 2
         v = (v>99) ? 99 : (v<2) ? 2 : v;
       }
       /**
       *methode toString
       *@return une chaine sous la forme de c** où (** = valeur de la carte)
       */
       public String toString() {
         return "c" + valeur;
      }
      /**
      *methode etrePlusGrand
      *@param c iteration de classe Carte
      *@return booleen qui verifie si la carte en parametre est inferieur à this
      */
       public boolean etrePlusGrand(Carte c){
         //on verifie que la valeur de la carte en parametre est strictement inferieur à this
         return (c.valeur < valeur) ? true : false;
       }
       /**
       *methode avoirDiffDe10
       *@param c iteration de la classe Carte
       *@return booleen qui verifie si la carte en parametre a une difference d'exactement 10 avec la carte this
       */
       public boolean avoirDiffDe10(Carte c){
         //on verifie que la difference entre les deux est exactement 10 (dans un sens ou dans l'autre)
         return (c.valeur - valeur == 10)||(valeur - c.valeur == 10) ? true : false;
       }

}
