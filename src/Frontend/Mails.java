package Frontend;

public enum Mails {
	LOB("Sehr geehrter Arzt,\n\n" + "Wir sind mit ihrer Arbeit in unserem Camp sehr zufrieden.\n"
			+ "Die Quote der geheilten Patienten entspricht unseren Vorstellungen, machen Sie so weiter.\n\n"
			+ "Mit freundlichen Gr��en\n" + "IMAO Manager"), ABMAHNUNG(
					"Sehr geehrter Arzt,\n\n"
							+ "aufgrund der vielen Fehldiagnosen und Todesf�llen bleibt uns nichts anderes �brig, als Ihnen eine Abmahnung zu erteilen. "
							+ "Die Nachforschungen haben ergeben, dass es sich bei diesen Fehlern fast ausschlie�lich um Arztfehler handelt, dies k�nnen wir nicht ohne Folgen lassen. "
							+ "Diese E-Mail ist eine rechtsg�ltige Abmahnung und eine sofortige Besserung Ihres Handeln wird unsererseits erwaret.\n\n"
							+ "Mit freundliche Gr��en,\n" + "das Management von IMAO"), GERAET_GEKAUFT(
									"Ich habe ein neues Ger�t f�r Sie gekauft.");

	private String mailText;

	Mails(String mailText) {

		this.mailText = mailText;
	}

	public String getMailText() {
		return mailText;
	}
}
