package testsFonctionnels;

import java.util.Iterator;

import cartes.Botte;
import cartes.Carte;
import cartes.JeuDeCartes;
import cartes.Type;
import jeu.Sabot;

public class TestSabot {
	private JeuDeCartes jeu = new JeuDeCartes();
	private Sabot sabot;

	private void reinitialiser() {
		sabot = new Sabot(jeu.donnerCartes());
	}

	// a) piocher jusqu'à ce que le sabot soit vide
	public void questionA() {
		System.out.println("--- Question A ---");
		reinitialiser();
		while (!sabot.estVide()) {
			System.out.println("Je pioche " + sabot.piocher());
		}
	}

	// b) itérateur + remove
	public void questionB() {
		System.out.println("--- Question B ---");
		reinitialiser();
		for (Iterator<Carte> it = sabot.iterator(); it.hasNext();) {
			System.out.println("Je pioche " + it.next());
			it.remove();
		}
	}

	// c1) piocher pendant l'itération -> ConcurrentModificationException
	public void questionC1() {
		System.out.println("--- Question C1 ---");
		reinitialiser();
		for (Iterator<Carte> it = sabot.iterator(); it.hasNext();) {
			System.out.println("Je pioche " + it.next());
			it.remove();
			sabot.piocher(); // modification hors de l'itérateur
		}
	}

	// c2) ajouter une carte pendant l'itération -> ConcurrentModificationException
	public void questionC2() {
		System.out.println("--- Question C2 ---");
		reinitialiser();
		sabot.piocher(); // libère une place dans le tableau
		Carte asDuVolant = new Botte(Type.ACCIDENT);
		for (Iterator<Carte> it = sabot.iterator(); it.hasNext();) {
			System.out.println("Je pioche " + it.next());
			sabot.ajouterCarte(asDuVolant); // modification hors de l'itérateur
		}
	}

	public static void main(String[] args) {
		TestSabot test = new TestSabot();
		test.questionA();
		test.questionB();

		// L'exception interrompt le programme : lancer C1 ou C2, pas les deux.
//		test.questionC1();
		 test.questionC2();
	}
}
