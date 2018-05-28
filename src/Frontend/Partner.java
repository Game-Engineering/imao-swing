package Frontend;

import java.util.List;

public class Partner {
	public List<Interviewpartner> partnerListe;

	public Partner() {
		// TODO Auto-generated constructor stub
	}

	public Partner(List<Interviewpartner> partnerListe) {
		super();
		this.partnerListe = partnerListe;
	}

	@Override
	public String toString() {
		String erg = "";
		for (Interviewpartner partner : partnerListe) {
			erg += partner.toString();
		}
		return erg;
	}

}
