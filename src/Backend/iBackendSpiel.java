package Backend;

public interface iBackendSpiel {
	public String test();

	public String erzeugeArzt(String vorname, String nachname, String geschlecht);

	public String erzeugeManager(String vorname, String nachname, String geschlecht);

	public String startArzt();

	public String startManager();

	public String neuesSpiel();

	// Arzt

	public String neueRundeArzt();

	public String getMailsArzt();

	public String getManagerDaten();

	public String frageAnamnese(int PatientID, int frage);

	public String beginneAnamnese(int PatientID);

	public String getUltraschall(int PatientID);

	public String getBlutbild(int PatientID);

	public String getRoentgen(int PatientID);

	public String getUntersuchungsmethoden();

	public String getAlleKrankheiten();

	public String diagnose(int PatientID, int krankheitID);

	public String getKatalog();

	public String getPatatient();

	// Manager

	public String neueRundeManager();

	public String getManagerKatalog();

	public String getArztDaten();

	public String getInterviewPartner();

	public String interview(int partnerID);

	public String interview(int partnerID, int antwortID);

	public String haltePressekonferenz();

	public String haltePressekonferenz(int ID);

	public String getBudgetbreicht();

	public String getArztbreicht();

	public String getMails();

	public String getMoeglicheSendeMails();

	public String sendeMail(String mailID);

	public String getSponsoren();

	public String werbeSponsorAn(int sponsorID);

	public String kaufeGeraet(String geraet);

}