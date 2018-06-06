package Frontend;

public class Sponsor {
	private int ID;
	private String sponsorName;
	private int monatlicherBetrag;
	private int benoetigtesAnsehen;
	private int zeitraum;
	private boolean angeworben;

	@Override
	public String toString() {
		return "<html>Name: " + sponsorName + "<br>Monatlicher Betrag: " + monatlicherBetrag
				+ "<br>Benoetigtes Ansehen: " + benoetigtesAnsehen + "<br>Zeitraum: " + zeitraum + "</html>";
	}

	public boolean isAngeworben() {
		return angeworben;
	}

	public int getID() {
		return ID;
	}

}
