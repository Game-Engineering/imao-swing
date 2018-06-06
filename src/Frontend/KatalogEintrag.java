package Frontend;

public class KatalogEintrag {
	private String name;
	private int behandlungsKosten;
	private int anschaffungsKosten;
	private int unterhaltsKosten;
	private boolean freigeschaltet;

	public KatalogEintrag(String name, int behandlungsKosten, int anschaffungsKosten, int unterhaltsKosten,
			boolean freigeschaltet) {
		super();
		this.name = name;
		this.behandlungsKosten = behandlungsKosten;
		this.anschaffungsKosten = anschaffungsKosten;
		this.unterhaltsKosten = unterhaltsKosten;
		this.freigeschaltet = freigeschaltet;
	}

	@Override
	public String toString() {
		return "name: " + name + "\nbehandlungsKosten: " + behandlungsKosten + "\nanschaffungsKosten: "
				+ anschaffungsKosten + "\nunterhaltsKosten: " + unterhaltsKosten + "\nfreigeschaltet: " + freigeschaltet
				+ "\n";
	}

}
