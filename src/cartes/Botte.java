package cartes;

public class Botte extends Probleme {

	public Botte(Type type) {
		super(type);
	}

	public String toString() {
		return this.getType().getNomBotte();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Botte botte) {
			return this.getType().getNomBotte().equals(botte.getType().getNomBotte());
		}
		return false;
	}
}
