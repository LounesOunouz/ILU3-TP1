package cartes;

public class Borne extends Carte {
	private int km;

	public Borne(int Km) {
		this.km = Km;
	}

	@Override
	public String toString() {
		return this.km + "KM";
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Borne borne) {
			return km == borne.km;
		}
		return false;
	}

}
