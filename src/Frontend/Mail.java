package Frontend;

public class Mail {
	private String absender;
	private String mailInhalt;

	public Mail(String absender, String mailInhalt) {
		super();
		this.absender = absender;
		this.mailInhalt = mailInhalt;
	}

	@Override
	public String toString() {

		return "absender: " + absender + "\nmailInhalt: " + mailInhalt + "\n";
	}

}
