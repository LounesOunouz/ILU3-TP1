/**
 * 
 */
package testsFonctionnels;

import cartes.Attaque;
import cartes.Borne;
import cartes.Carte;
import cartes.Parade;
import cartes.Type;

/**
 * 
 */
public class TestMethodsEquals {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Carte Borne1 = new Borne(25);
		Carte Borne2 = new Borne(25);
		Carte FeuRouge1 = new Attaque(Type.FEU);
		Carte FeuRouge2 = new Attaque(Type.FEU);
		Carte Feuvert = new Parade(Type.FEU);
		if (Borne1.equals(Borne2))
			System.out.println("true borne ");
		if (FeuRouge1.equals(FeuRouge2))
			System.out.println("true feu rouge");
		if (Feuvert.equals(FeuRouge1)) {
			System.out.println("true feu ");
		} else {
			System.out.println("faux, bien joué ");
		}
	}

}
