package utils;

import java.util.ArrayList;

public class GestionCartes {
	public <Element> Element extraire(ArrayList<Element> liste) {
		return liste.remove(0);
	}
}
