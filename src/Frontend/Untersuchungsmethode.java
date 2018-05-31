package Frontend;

public class Untersuchungsmethode {
	private int anschaffungsKosten;
	private int behandlungsKosten;
	private boolean freigeschaltet;
	private String name;

	public String getName() {
		return name;
	}

	public boolean isFreigeschaltet() {
		return freigeschaltet;
	}

	@Override
	public String toString() {
		String erg = "";
		return "Name: " + name + "\nAnschaffungskosten: " + anschaffungsKosten + "\nBehandlungskosten: "
				+ behandlungsKosten + "\nFreigeschaltet: " + freigeschaltet;
	}

}
