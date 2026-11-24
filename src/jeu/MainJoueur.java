package jeu;

import java.util.ArrayList;

import cartes.Carte;

public class MainJoueur {
	private ArrayList<Carte> main;

	public MainJoueur() {
		this.main = new ArrayList<Carte>();
	}

	private void prendre(Carte carte) {
		this.main.add(carte);

	}

	private void jouer(Carte carte) {
		assert main.contains(carte);
		this.main.remove(carte);
	}
}
