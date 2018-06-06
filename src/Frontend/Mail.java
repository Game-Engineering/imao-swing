package Frontend;

public class Mail {
	private String absender;
	private String betreff;
	private String mailInhalt;

	public Mail(String absender, String betreff, String mailInhalt) {
		super();
		this.absender = absender;
		this.betreff = betreff;
		this.mailInhalt = mailInhalt;
	}

	@Override
	public String toString() {
		return "Absender: " + absender + "\nBetreff: " + betreff + "\nMailInhalt: " + mailInhalt + "\n";
	}

	public String getAbsender() {
		return absender;
	}

	public String getMailInhalt() {
		return mailInhalt;
	}

	public String getBetreff() {
		return betreff;
	}

}
