package Frontend;

public class Arzt {
	private String vorname;
	private String nachname;
	private String geschlecht;

	public Arzt(String vorname, String nachname, String geschlecht) {
		super();
		this.vorname = vorname;
		this.nachname = nachname;
		this.geschlecht = geschlecht;
	}

	public String getName() {
		return vorname + " " + nachname;
	}

	public String getGeschlecht() {
		return geschlecht;
	}

}
