/**
 * 
 */
package jeu;

/**
 * 
 */
public class Joueur {
	private String nom;
	private ZoneDeJeu zonedejeu;

	public Joueur(String nom) {
		this.nom = nom;
		this.zonedejeu = new ZoneDeJeu();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Joueur joueur) {
			return this.nom.equals(joueur.nom);
		}
		return false;

	}

	@Override
	public String toString() {
		return nom;
	}

	@Override
	public int hashCode() {
		return nom.hashCode();
	}
}
