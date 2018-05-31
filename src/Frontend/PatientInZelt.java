package Frontend;

public class PatientInZelt {
	private String vorname;
	private String nachname;
	private int alter;
	private String geschlecht;
	private int erscheinungID;
	private int ID;

	@Override
	public String toString() {
		return "<html>Name: " + vorname + " " + nachname + "<br>Alter: " + alter + "<br>Geschlecht: " + geschlecht
				+ "<br>ErscheinungID: " + erscheinungID + "<br>ID: " + ID + "</html>";
	}

	public String toPlainString() {
		return "Name: " + vorname + " " + nachname + "\nAlter: " + alter + "\nGeschlecht: " + geschlecht
				+ "\nErscheinungID: " + erscheinungID + "\nID: " + ID;
	}

	public int getID() {
		return ID;
	}

	public int getErscheinungID() {
		return erscheinungID;
	}

}
