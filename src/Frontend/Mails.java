package Frontend;

public enum Mails {
	LOB("Gut gemacht. Weiter so!"), ABMAHNUNG(
			"Schlimm, schlimm, schlimm. Hören Sie auf leute umzubringen, sonst sind Sie gefeuert!"), GERAET_GEKAUFT(
					"Ich habe ein neues Gerät für Sie gekauft."), DEFAULT_MAIL(
							"JVBERi0xLjQNJeLjz9MNCjQgM CBvYmoNPDwvTGluZW FyaXplZCAxL0wgMTUzODA4L08gNi9FIDE0"
									+ "OTgxNC9OIDEvVC xNTM2MDkvSCBbI Dc3NiAxODFdPj4NZW5kb2JqDSAgICAgICAgICAgICAgICAg"
									+ "DQp4cmVmDQo0IDI0DQowMDAwMDAwM DE2IDAwMDAwIG4NCjAwMDAwMDA5NTc gMDAwMDAgbg0KMDAw"
									+ "MDAwMTAxNyAw MDAwMCBuDQowMDAwMDAxMjUyIDA wMDAwIG4NCjAwMDAwMDEyODIgMDAwMDAgbg0K");

	private String mailText;

	Mails(String mailText) {

		this.mailText = mailText;
	}

	public String getMailText() {
		return mailText;
	}
}
