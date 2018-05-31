package Frontend;

import java.util.List;

public class Partner {
	public List<Interviewpartner> interviewPartner;

	public Partner() {
		// TODO Auto-generated constructor stub
	}

	public Partner(List<Interviewpartner> partnerListe) {
		super();
		this.interviewPartner = partnerListe;
	}

	@Override
	public String toString() {
		String erg = "";
		for (Interviewpartner partner : interviewPartner) {
			erg += partner.toString();
		}
		return erg;
	}

}
