package Backend;

import javax.ws.rs.client.Client;

import UI.SwingFE;

public class BackendSpielStub implements iBackendSpiel {
	private static final String urlUnterPfad = "imao/api/spiel/";
	private String url;
	private Client client;

	public BackendSpielStub(String url) {
		if (url.endsWith("/"))
			this.url = url + urlUnterPfad;
		else
			this.url = url + "/" + urlUnterPfad;

		try {
			this.client = BackendUtils.ignoreSSLClient();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private String getXmlvonRest(String anfrage) {
		try {
			SwingFE.addLog("CLIENT ANFRAGE: " + url + anfrage);

			String s = client.target(url + anfrage).request().accept("application/json").get(String.class);

			SwingFE.addLog("SERVER ANTWORT: " + s);

			return s;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return "";
		}
	}

	@Override
	public String test() {
		return getXmlvonRest("test/");
	}

	@Override
	public String erzeugeArzt(String vorname, String nachname, String geschlecht) {
		return getXmlvonRest("erzeuge/arzt/" + vorname + "/" + nachname + "/" + geschlecht + "/");
	}

	@Override
	public String erzeugeManager(String vorname, String nachname, String geschlecht) {
		return getXmlvonRest("erzeuge/manager/" + vorname + "/" + nachname + "/" + geschlecht + "/");
	}

	@Override
	public String startArzt() {
		return getXmlvonRest("start/arzt/");
	}

	@Override
	public String startManager() {
		return getXmlvonRest("start/manager/");
	}

	@Override
	public String neuesSpiel() {
		return getXmlvonRest("neuesSpiel/");
	}

	@Override
	public String neueRundeArzt() {
		return getXmlvonRest("medizin/neueRunde");
	}

	@Override
	public String frageAnamnese(int PatientID, int frage) {
		return getXmlvonRest("medizin/getAnamnese/" + PatientID + "/" + frage + "/");
	}

	@Override
	public String beginneAnamnese(int PatientID) {
		return getXmlvonRest("medizin/getAnamnese/" + PatientID + "/");
	}

	@Override
	public String getUltraschall(int PatientID) {
		return getXmlvonRest("medizin/getUltraschall/" + PatientID + "/");
	}

	@Override
	public String getBlutbild(int PatientID) {
		return getXmlvonRest("medizin/getBlutbild/" + PatientID + "/");
	}

	@Override
	public String getRoentgen(int PatientID) {
		return getXmlvonRest("medizin/getRoentgen/" + PatientID + "/");
	}

	@Override
	public String getUntersuchungsmethoden() {
		return getXmlvonRest("medizin/getUntersuchungsmethoden/");
	}

	@Override
	public String getAlleKrankheiten() {
		return getXmlvonRest("medizin/getAlleKrankheiten/");
	}

	@Override
	public String diagnose(int PatientID, int krankheitID) {
		return getXmlvonRest("medizin/diagnose/" + PatientID + "/" + krankheitID + "/");
	}

	@Override
	public String getKatalog() {
		return getXmlvonRest("medizin/getKatalog/");
	}

	@Override
	public String getPatatient() {
		return getXmlvonRest("medizin/getPatient/");
	}

	@Override
	public String neueRundeManager() {
		return getXmlvonRest("wirtschaft/neueRunde/");
	}

	@Override
	public String getManagerKatalog() {
		return getXmlvonRest("wirtschaft/getKatalog/");
	}

	@Override
	public String getArztDaten() {
		return getXmlvonRest("wirtschaft/getArztDaten/");
	}

	@Override
	public String getInterviewPartner() {
		return getXmlvonRest("wirtschaft/getInterviewPartner/");
	}

	@Override
	public String interview(int partnerID) {
		return getXmlvonRest("wirtschaft/interview/" + partnerID + "/");
	}

	@Override
	public String interview(int partnerID, int antwortID) {
		return getXmlvonRest("wirtschaft/interview/" + partnerID + "/" + antwortID + "/");
	}

	@Override
	public String haltePressekonferenz() {
		return getXmlvonRest("wirtschaft/haltePressekonferenz/");
	}

	@Override
	public String getBudgetbreicht() {
		return getXmlvonRest("wirtschaft/getBudgetbreicht/");
	}

	@Override
	public String getArztbreicht() {
		return getXmlvonRest("wirtschaft/getArztbreicht/");
	}

	@Override
	public String getMails() {
		return getXmlvonRest("wirtschaft/getMails/");
	}

	@Override
	public String getMoeglicheSendeMails() {
		return getXmlvonRest("wirtschaft/getMoeglicheSendeMails/");
	}

	@Override
	public String sendeMail(String mailID) {
		return getXmlvonRest("wirtschaft/sendeMail/" + mailID + "/");
	}

	@Override
	public String getAktuelleSponsoren() {
		return getXmlvonRest("wirtschaft/getAktuelleSponsoren/");
	}

	@Override
	public String getMoeglicheSponsoren() {
		return getXmlvonRest("wirtschaft/getMoeglicheSponsoren/");
	}

	@Override
	public String werbeSponsorAn(int sponsorID) {
		return getXmlvonRest("wirtschaft/werbeSponsorAn/" + sponsorID + "/");
	}

	@Override
	public String kaufeGeraet(String geraet) {
		return getXmlvonRest("wirtschaft/kaufeGeraet/" + geraet + "/");
	}

}
