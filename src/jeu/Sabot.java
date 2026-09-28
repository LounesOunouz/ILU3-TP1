package jeu;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import cartes.Carte;

public class Sabot implements Iterable<Carte> {
	private Carte[] cartes;
	private int nbCartes;
	private int nbOperations = 0;

	public Sabot(Carte[] cartes) {
		this.cartes = cartes;
		this.nbCartes = cartes.length;
	}

	public boolean estVide() {
		return nbCartes == 0;
	}

	public void ajouterCarte(Carte carte) {
		if (nbCartes >= cartes.length) {
			throw new IllegalStateException("Le sabot est plein");
		}
		cartes[nbCartes] = carte;
		nbCartes++;
		nbOperations++;
	}

	public Carte piocher() {
		Iterator<Carte> it = iterator();
		Carte carte = it.next();
		it.remove();
		return carte;
	}

	@Override
	public Iterator<Carte> iterator() {
		return new Iterateur();
	}

	private class Iterateur implements Iterator<Carte> {
		private int indiceIterateur = 0;
		private int nbOperationsReference = nbOperations;
		private boolean nextEffectue = false;

		@Override
		public boolean hasNext() {
			return indiceIterateur < nbCartes;
		}

		@Override
		public Carte next() {
			verificationConcurrence();
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			Carte carte = cartes[indiceIterateur];
			indiceIterateur++;
			nextEffectue = true;
			return carte;
		}

		@Override
		public void remove() {
			verificationConcurrence();
			if (!nextEffectue) {
				throw new IllegalStateException();
			}
			for (int i = indiceIterateur - 1; i < nbCartes - 1; i++) {
				cartes[i] = cartes[i + 1];
			}
			cartes[nbCartes - 1] = null;
			indiceIterateur--;
			nbCartes--;
			nextEffectue = false;
			nbOperations++;
			nbOperationsReference++;
		}

		private void verificationConcurrence() {
			if (nbOperations != nbOperationsReference) {
				throw new ConcurrentModificationException();
			}
		}
	}
}