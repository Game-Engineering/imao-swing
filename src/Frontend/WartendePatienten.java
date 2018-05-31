package Frontend;

import java.util.ArrayList;
import java.util.List;

public class WartendePatienten {
	private List<Patient> patienten;

	public WartendePatienten(Patient[] patienten) {
		super();
		List<Patient> wartendePatienten = new ArrayList();
		for (Patient pat : patienten) {
			wartendePatienten.add(pat);
		}
		this.patienten = wartendePatienten;
	}

	public List<Patient> getPatienten() {
		return patienten;
	}

	@Override
	public String toString() {
		String erg = "";
		for (Patient pat : patienten) {
			erg += pat.toString();
		}
		return erg;
	}

}
