package Frontend;

public class RundeArzt {
	public int budget;
	public String nachricht;
	public int ruf;
	public int runde;
	public int wartendePatienten;
	public Patient[] patienten;

	@Override
	public String toString() {
		return "<html>Runde: " + runde + "<br>Nachricht: " + nachricht + "<br>Budget: " + budget + "<br>Ruf: " + ruf
				+ "<br>Patienten in dieser Runde: " + wartendePatienten + "</html>";
	}

}
