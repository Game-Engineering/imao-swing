package Frontend;

public class RundeManager {

	private int runde;
	private String nachricht;
	private int budget;
	private String aufgabe;

	public RundeManager(int runde, String nachricht, int budget, String aufgabe) {
		super();

		this.runde = runde;
		this.nachricht = nachricht;
		this.budget = budget;
		this.aufgabe = aufgabe;
	}

	@Override
	public String toString() {

		return "<html>runde: " + runde + "<br>nachricht: " + nachricht + "<br>budget: " + budget + "<br>aufgabe: "
				+ aufgabe + "</html>";
	}

}
