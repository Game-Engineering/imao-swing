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
		String erg = "";
		for (Patient patient : patienten) {
			erg += patient.toString();
		}
		return "runde: " + runde + "\nnachricht: " + nachricht + "\nbudget: " + budget + "\nruf: " + ruf
				+ "\nwartendePatienten: " + wartendePatienten + "\npatienten:\n" + erg;
	}

}
