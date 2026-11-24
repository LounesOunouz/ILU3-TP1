package jeu;

import java.util.ArrayList;

import cartes.Bataille;
import cartes.Borne;
import cartes.Limite;

public class ZoneDeJeu {
	private ArrayList<Limite> pileLimites;
	private ArrayList<Bataille> pileBataille;
	private ArrayList<Borne> pileBorne;

	public ZoneDeJeu() {
		this.pileLimites = new ArrayList<>();
		this.pileBataille = new ArrayList<>();
		this.pileBorne = new ArrayList<>();
	}

}
