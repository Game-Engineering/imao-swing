package Frontend;

public class RundeManager {

	private int runde;
	private String nachricht;
	private int budget;
	private int ruf;
	private String aufgabe;

	public RundeManager(int runde, String nachricht, int budget, int ruf, String aufgabe) {
		super();

		this.runde = runde;
		this.nachricht = nachricht;
		this.budget = budget;
		this.ruf = ruf;
		this.aufgabe = aufgabe;
	}

	@Override
	public String toString() {

		return "<html>Runde: " + runde + "<br>Nachricht: " + nachricht + "<br>Budget: " + budget + "<br>Ruf: " + ruf
				+ "<br>Aufgabe: " + aufgabe + "</html>";
	}

}
