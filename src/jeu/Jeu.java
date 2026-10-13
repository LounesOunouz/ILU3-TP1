package jeu;

import java.util.ArrayList;
import java.util.Collections;

import cartes.Carte;
import cartes.JeuDeCartes;
import utils.GestionCartes;

public class Jeu {
	private Sabot sabot;

	public Jeu() {
		JeuDeCartes jeuDeCartes = new JeuDeCartes();
		ArrayList<Carte> listeCartes = new ArrayList<Carte>();
		Collections.addAll(listeCartes, jeuDeCartes.donnerCartes());
		listeCartes = GestionCartes.melanger(listeCartes);

		Carte[] cartesMelangees = listeCartes.toArray(new Carte[listeCartes.size()]);
		this.sabot = new Sabot(cartesMelangees);
	}

	public Sabot getSabot() {
		return sabot;
	}
}
