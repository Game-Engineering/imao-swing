package Frontend;

import java.util.List;

public class Posteingang {
	private List<Mail> mailliste;

	public Posteingang() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		String erg = "";
		for (Mail mail : mailliste) {
			erg += mail.toString();
		}
		return erg;
	}

	public List<Mail> getMailliste() {
		return mailliste;
	}

}
