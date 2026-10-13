package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.ListIterator;
import java.util.Random;

public class GestionCartes {
	private static final Random random = new Random();

	public static <Element> Element extraire(ArrayList<Element> liste) {
		return liste.remove(random.nextInt(liste.size()));
	}

	public <Element> Element extraire2(ArrayList<Element> Liste) {
		int index = random.nextInt(Liste.size());
		ListIterator<Element> iterator = Liste.listIterator(index);
		Element e = iterator.next();
		iterator.remove();
		return e;
	}

	public static <Element> ArrayList<Element> melanger(ArrayList<Element> Liste) {
		ArrayList<Element> maListe = new ArrayList<Element>();
		while (!Liste.isEmpty()) {
			maListe.add(extraire(Liste));
		}
		return maListe;
	}

	public static <Element> boolean verifierMelange(ArrayList<Element> l1, ArrayList<Element> l2) {
		if (l1.size() != l2.size()) {
			return false;
		}
		for (Element e : l1) {
			if (Collections.frequency(l1, e) != Collections.frequency(l2, e)) {
				return false;
			}
		}
		return true;
	}

	public static <Element> ArrayList<Element> rassembler(ArrayList<Element> liste) {
		ArrayList<Element> resultat = new ArrayList<>();
		for (Element element : liste) {
			if (!resultat.contains(element)) {
				resultat.addAll(Collections.nCopies(Collections.frequency(liste, element), element));
			}
		}
		return resultat;
	}

	public static <T> boolean verifierRassemblement(ArrayList<T> liste) {
		ListIterator<T> it1 = liste.listIterator();
		T precedent = null;
		while (it1.hasNext()) {
			T courant = it1.next();
			if (precedent != null && !courant.equals(precedent)) {
				ListIterator<T> it2 = liste.listIterator(it1.nextIndex());
				while (it2.hasNext()) {
					if (it2.next().equals(precedent)) {
						return false;
					}
				}
			}
			precedent = courant;
		}
		return true;
	}
}
