package Frontend;

public class Untersuchungsmethoden {
	public Untersuchungsmethode[] methoden;

	@Override
	public String toString() {
		String erg = "";
		for (Untersuchungsmethode met : methoden) {
			erg += met.toString() + "\n";
		}
		return erg + "";
	}

}
