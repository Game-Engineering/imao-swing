package UI;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.plaf.FontUIResource;

import com.google.gson.Gson;

import Frontend.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import javax.swing.JTextArea;

import net.miginfocom.swing.MigLayout;
import java.awt.Component;
import javax.swing.JScrollPane;
import java.awt.Dimension;
import java.awt.CardLayout;

@SuppressWarnings("serial")
public class Wirtschaft extends JPanel {
	private static final Gson gson = new Gson();
	private static final int FONT_SIZE = 30;
	private static final String TextPanelName = "TextPanel";
	private static final String InterviewPartnerPanelName = "InterviewPartnerPanel";
	private static final String InterviewPanelName = "InterviewPanel";
	private static final String SponsorenPanelName = "SponsorenPanel";
	private static final String SponsorAnwerbenPanelName = "SponsorAnwerbenPanel";
	private final Spiel spiel;

	private final JPanel buttonPanel = new JPanel();
	private final JPanel panelContainer = new JPanel();
	private final JPanel TextPanel = new JPanel();
	private final JPanel InterviewPartnerPanel = new JPanel();
	private final JPanel InterviewPanel = new JPanel();
	private final JPanel SponsorenPanel = new JPanel();
	private final JPanel SponsorAnwerbenPanel = new JPanel();
	private final JScrollPane scrollPane = new JScrollPane();

	private final JButton btnInterviewpartner = new JButton("Interviewpartner");
	private final JButton btnZurueckIPartner = new JButton("Zur\u00FCck");
	private final JButton btnBeginneInterview = new JButton("beginne Interview");
	private final JButton btnBeginneInterview_1 = new JButton("beginne Interview");
	private final JButton btnBeginneInterview_2 = new JButton("beginne Interview");
	private final JButton btnAntwort = new JButton("Antwort");
	private final JButton btnAntwort_1 = new JButton("Antwort");
	private final JButton btnAntwort_2 = new JButton("Antwort");

	private final JButton btnZurcuekSponsor = new JButton("Zur\u00FCck");
	private final JButton btnSponsorAnwerben1 = new JButton("anwerben");
	private final JButton btnSponsorAnwerben2 = new JButton("anwerben");
	private final JButton btnSponsorAnwerben3 = new JButton("anwerben");
	private final JButton btnSponsorAnwerben4 = new JButton("anwerben");
	private final JButton btnSponsorAnwerben5 = new JButton("anwerben");
	private final JButton btnSponsorAnwerben6 = new JButton("anwerben");
	private final JButton btnSponsorAnwerben7 = new JButton("anwerben");
	private final JButton btnSponsorAnwerben8 = new JButton("anwerben");
	private final JButton btnSponsorAnwerben9 = new JButton("anwerben");
	private final JButton btnSponsorAnwerben10 = new JButton("anwerben");

	private final JButton btnZurueck = new JButton("Zur\u00FCck");
	private final JButton btnAnwerben = new JButton("anwerben");
	private final JButton btnNeueRunde = new JButton("Neue Runde");
	private final JButton btnBudgetbreicht = new JButton("Budgetbericht");
	private final JButton btnArztbreicht = new JButton("Arztbericht");
	private final JButton btnHaltePressekonferenz = new JButton("Pressekonferenz halten");
	private final JButton btnKaufeRntgen = new JButton("R\u00F6ntgen kaufen");
	private final JButton btnKaufeUltraschall = new JButton("Ultraschall kaufen");
	private final JButton btnffneKatalog = new JButton("Katalog \u00F6ffnen");
	private final JButton btnPosteingang = new JButton("Posteingang");
	private final JButton btnLob = new JButton("Lob");
	private final JButton btnAbmahnung = new JButton("Abmahnung");
	private final JButton btnGert = new JButton("Ger\u00E4t");
	private final JButton btnDefault = new JButton("Default");
	private final JButton btnMglicheMails = new JButton("M\u00F6gliche Mails");

	private final JLabel lblManagerinfo = new JLabel(" ");
	private final JLabel lblArztinfo = new JLabel(" ");
	private final JLabel lblRundeinfo = new JLabel(" ");
	private final JLabel lblWirtschaft = new JLabel("Wirtschaft");
	private final JLabel lblInterviewPartner = new JLabel("Interview Partner");

	private final JLabel lblPartner = new JLabel("Partner1");
	private final JLabel lblPartner_1 = new JLabel("Partner2");
	private final JLabel lblPartner_2 = new JLabel("Partner3");
	private final JLabel lblInterview = new JLabel("Interview");
	private final JLabel lblFrage = new JLabel("Frage");

	private final JLabel lblMglicheSponsoren = new JLabel("M\u00F6gliche Sponsoren");
	private final JLabel lblSponsor1 = new JLabel(" ");
	private final JLabel lblSponsor2 = new JLabel(" ");
	private final JLabel lblSponsor3 = new JLabel(" ");
	private final JLabel lblSponsor4 = new JLabel(" ");
	private final JLabel lblSponsor5 = new JLabel(" ");
	private final JLabel lblSponsor6 = new JLabel(" ");
	private final JLabel lblSponsor7 = new JLabel(" ");
	private final JLabel lblSponsor8 = new JLabel(" ");
	private final JLabel lblSponsor9 = new JLabel(" ");
	private final JLabel lblSponsor10 = new JLabel(" ");

	private final JLabel lblSponsorAnwerben = new JLabel("Sponsor anwerben");

	private final JPanel InfoPanel = new JPanel();
	private final JLabel lblRunde = new JLabel("Runde:");
	private final JLabel lblManager = new JLabel("Manager:");
	private final JLabel lblArzt = new JLabel("Arzt:");

	private JTextArea txtrText = new JTextArea(" ", 20, 25);

	/**
	 * Create the panel.
	 */
	public Wirtschaft(Spiel spiel) {
		this.spiel = spiel;
		setPreferredSize(new Dimension(2000, 930));
		setLayout();

		add(lblWirtschaft, "cell 0 0 3 1,growx,aligny top");
		add(buttonPanel, "cell 0 1,alignx left");
		add(panelContainer, "cell 1 1");

		buttonPanel.setOpaque(false);
		TextPanel.setOpaque(false);

		panelContainer.setLayout(new CardLayout(0, 0));

		GroupLayout gl_TextPanel = new GroupLayout(TextPanel);
		gl_TextPanel.setHorizontalGroup(gl_TextPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_TextPanel.createSequentialGroup().addContainerGap()
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 1187, Short.MAX_VALUE).addContainerGap()));
		gl_TextPanel.setVerticalGroup(gl_TextPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_TextPanel.createSequentialGroup().addContainerGap()
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 711, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(136, Short.MAX_VALUE)));
		scrollPane.setViewportView(txtrText);

		txtrText.setWrapStyleWord(true);
		txtrText.setEditable(false);
		txtrText.setLineWrap(true);
		txtrText.setFocusable(false);
		txtrText.setOpaque(false);
		txtrText.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));

		TextPanel.setLayout(gl_TextPanel);

		add(InfoPanel, "cell 2 1,grow");
		InfoPanel.setOpaque(false);

		setFormat();
		addActionListeners();
		addComponents();

		btnKaufeRntgen.setVisible(false);
		btnKaufeUltraschall.setVisible(false);
		btnLob.setVisible(false);
		btnAbmahnung.setVisible(false);
		btnGert.setVisible(false);
		btnDefault.setVisible(false);

	}

	private void setLayout() {
		setLayout(new MigLayout("", "[340px,grow][1230.00px][410.00px]", "[53px][749.00px][]"));
		InfoPanel.setLayout(new MigLayout("", "[305.00px]", "[37px][234.00px][37px][123.00px][37px][129.00px]"));
		InterviewPanel.setLayout(new MigLayout("", "[1230]", "[][300][][][][][]"));
		SponsorenPanel.setLayout(new MigLayout("", "[100.00][250][150][730]", "[][][][][][][][][][][][]"));
		SponsorAnwerbenPanel.setLayout(new MigLayout("", "[100][150][980]", "[][][]"));
		buttonPanel.setLayout(new MigLayout("", "[325px]",
				"[45px][45px][45px][45px][45px][45px][45px][45px][45px][45px][45px][45px][45px][45px]"));

		InterviewPartnerPanel.setLayout(new MigLayout("", "[100][320][210][600]", "[][][][][][][]"));
	}

	private void setFormat() {

		lblManagerinfo.setHorizontalAlignment(SwingConstants.LEFT);
		lblManagerinfo.setVerticalAlignment(SwingConstants.TOP);
		lblArztinfo.setVerticalAlignment(SwingConstants.TOP);
		lblArztinfo.setHorizontalAlignment(SwingConstants.LEFT);

		lblWirtschaft.setHorizontalAlignment(SwingConstants.CENTER);
		lblWirtschaft.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblWirtschaft.setFont(new Font("Tahoma", Font.PLAIN, 35));

		btnInterviewpartner.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnZurueckIPartner.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnBeginneInterview.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnBeginneInterview_1.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnBeginneInterview_2.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnAntwort.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnAntwort_1.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnAntwort_2.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));

		btnZurcuekSponsor.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnSponsorAnwerben1.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnSponsorAnwerben2.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnSponsorAnwerben3.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnSponsorAnwerben4.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnSponsorAnwerben5.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnSponsorAnwerben6.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnSponsorAnwerben7.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnSponsorAnwerben8.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnSponsorAnwerben9.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnSponsorAnwerben10.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));

		btnZurueck.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnAnwerben.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnNeueRunde.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnNeueRunde.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnBudgetbreicht.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnArztbreicht.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnHaltePressekonferenz.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnKaufeRntgen.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnKaufeUltraschall.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnffneKatalog.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnPosteingang.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnLob.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnAbmahnung.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnGert.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnDefault.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnMglicheMails.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));

		lblManagerinfo.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		lblArztinfo.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		lblRundeinfo.setHorizontalAlignment(SwingConstants.LEFT);
		lblRundeinfo.setVerticalAlignment(SwingConstants.TOP);
		lblRundeinfo.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		lblWirtschaft.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));

		lblInterviewPartner.setHorizontalAlignment(SwingConstants.CENTER);
		lblInterviewPartner.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		lblPartner.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		lblPartner_1.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		lblPartner_2.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		lblInterview.setHorizontalAlignment(SwingConstants.CENTER);
		lblInterview.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		lblFrage.setHorizontalAlignment(SwingConstants.CENTER);
		lblFrage.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));

		lblMglicheSponsoren.setHorizontalAlignment(SwingConstants.CENTER);
		lblMglicheSponsoren.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		lblSponsor1.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		lblSponsor2.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		lblSponsor3.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		lblSponsor4.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		lblSponsor5.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		lblSponsor6.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		lblSponsor7.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		lblSponsor8.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		lblSponsor9.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		lblSponsor10.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));

		lblSponsorAnwerben.setHorizontalAlignment(SwingConstants.CENTER);
		lblSponsorAnwerben.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));

		InfoPanel.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		lblRunde.setVerticalAlignment(SwingConstants.TOP);
		lblRunde.setHorizontalAlignment(SwingConstants.LEFT);
		lblRunde.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		lblManager.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		lblArzt.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));

		txtrText.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));

	}

	private void addComponents() {
		panelContainer.add(TextPanel, TextPanelName);
		panelContainer.add(InterviewPartnerPanel, InterviewPartnerPanelName);
		panelContainer.add(InterviewPanel, InterviewPanelName);
		panelContainer.add(SponsorenPanel, SponsorenPanelName);
		panelContainer.add(SponsorAnwerbenPanel, SponsorAnwerbenPanelName);

		InterviewPartnerPanel.add(lblInterviewPartner, "cell 1 0 3 1,growx");
		InterviewPartnerPanel.add(lblPartner, "cell 1 2");
		InterviewPartnerPanel.add(lblPartner_1, "cell 1 4");
		InterviewPartnerPanel.add(lblPartner_2, "cell 1 6");

		buttonPanel.add(btnInterviewpartner, "cell 0 4,alignx left,aligny top");
		InterviewPartnerPanel.add(btnZurueckIPartner, "cell 0 0");
		InterviewPartnerPanel.add(btnBeginneInterview, "cell 2 2");
		InterviewPartnerPanel.add(btnBeginneInterview_1, "cell 2 4");
		InterviewPartnerPanel.add(btnBeginneInterview_2, "cell 2 6");

		InterviewPanel.add(lblInterview, "cell 0 0,growx");
		InterviewPanel.add(lblFrage, "cell 0 2");

		InterviewPanel.add(btnAntwort, "cell 0 4,growx");
		InterviewPanel.add(btnAntwort_1, "cell 0 5,growx");
		InterviewPanel.add(btnAntwort_2, "cell 0 6,growx");

		SponsorenPanel.add(lblMglicheSponsoren, "cell 1 0 3 1,growx");
		SponsorenPanel.add(lblSponsor1, "cell 1 2");
		SponsorenPanel.add(lblSponsor2, "cell 1 3");
		SponsorenPanel.add(lblSponsor3, "cell 1 4");
		SponsorenPanel.add(lblSponsor4, "cell 1 5");
		SponsorenPanel.add(lblSponsor5, "cell 1 6");
		SponsorenPanel.add(lblSponsor6, "cell 1 7");
		SponsorenPanel.add(lblSponsor7, "cell 1 8");
		SponsorenPanel.add(lblSponsor8, "cell 1 9");
		SponsorenPanel.add(lblSponsor9, "cell 1 10");
		SponsorenPanel.add(lblSponsor10, "cell 1 11");

		SponsorenPanel.add(btnZurcuekSponsor, "cell 0 0");
		SponsorenPanel.add(btnSponsorAnwerben1, "cell 2 2");
		SponsorenPanel.add(btnSponsorAnwerben2, "cell 2 3");
		SponsorenPanel.add(btnSponsorAnwerben3, "cell 2 4");
		SponsorenPanel.add(btnSponsorAnwerben4, "cell 2 5");
		SponsorenPanel.add(btnSponsorAnwerben5, "cell 2 6");
		SponsorenPanel.add(btnSponsorAnwerben6, "cell 2 7");
		SponsorenPanel.add(btnSponsorAnwerben7, "cell 2 8");
		SponsorenPanel.add(btnSponsorAnwerben8, "cell 2 9");
		SponsorenPanel.add(btnSponsorAnwerben9, "cell 2 10");
		SponsorenPanel.add(btnSponsorAnwerben10, "cell 2 11");

		SponsorAnwerbenPanel.add(lblSponsorAnwerben, "cell 1 0 2 1,growx");

		SponsorAnwerbenPanel.add(btnZurueck, "cell 0 0");
		SponsorAnwerbenPanel.add(btnAnwerben, "cell 1 2");

		InfoPanel.add(lblRunde, "cell 0 0,alignx left,aligny top");
		InfoPanel.add(lblRundeinfo, "cell 0 1,grow");
		InfoPanel.add(lblManager, "cell 0 2,alignx left,aligny top");
		InfoPanel.add(lblManagerinfo, "cell 0 3,alignx left,aligny top");
		InfoPanel.add(lblArzt, "cell 0 4,alignx left,aligny top");
		InfoPanel.add(lblArztinfo, "cell 0 5,alignx left,aligny top");

		buttonPanel.add(btnNeueRunde, "cell 0 0,alignx left,aligny top");
		buttonPanel.add(btnBudgetbreicht, "cell 0 1,alignx left,aligny top");
		buttonPanel.add(btnArztbreicht, "cell 0 2,alignx left,aligny top");
		buttonPanel.add(btnHaltePressekonferenz, "cell 0 3,alignx left,aligny top");

		buttonPanel.add(btnffneKatalog, "cell 0 5,alignx left,aligny top");
		buttonPanel.add(btnKaufeRntgen, "cell 0 6,alignx left,aligny top");
		buttonPanel.add(btnKaufeUltraschall, "cell 0 7,alignx left,aligny top");

		buttonPanel.add(btnPosteingang, "cell 0 8,alignx left,aligny top");
		buttonPanel.add(btnMglicheMails, "cell 0 9,alignx left,aligny top");
		buttonPanel.add(btnLob, "cell 0 10,alignx left,aligny top");
		buttonPanel.add(btnAbmahnung, "cell 0 11,alignx left,aligny top");
		buttonPanel.add(btnGert, "cell 0 12,alignx left,aligny top");
		buttonPanel.add(btnDefault, "cell 0 13,alignx left,aligny top");
	}

	private void addActionListeners() {
		btnBudgetbreicht.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String json = spiel.backendSpiel.getBudgetbreicht();
				txtrText.setText(json);
				((CardLayout) panelContainer.getLayout()).show(panelContainer, TextPanelName);
			}
		});

		btnArztbreicht.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String json = spiel.backendSpiel.getArztbreicht();
				txtrText.setText(json);
				((CardLayout) panelContainer.getLayout()).show(panelContainer, TextPanelName);
			}
		});

		btnHaltePressekonferenz.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String presseMitteilung = spiel.backendSpiel.haltePressekonferenz();
				txtrText.setText(presseMitteilung);
				((CardLayout) panelContainer.getLayout()).show(panelContainer, TextPanelName);
			}
		});

		btnInterviewpartner.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String json = spiel.backendSpiel.getInterviewPartner();
				Partner partnerListe = gson.fromJson(json, Partner.class);
				lblPartner.setText(partnerListe.partnerListe.get(0).toString());
				lblPartner_1.setText(partnerListe.partnerListe.get(1).toString());
				lblPartner_2.setText(partnerListe.partnerListe.get(2).toString());
				((CardLayout) panelContainer.getLayout()).show(panelContainer, InterviewPartnerPanelName);
			}
		});

		btnKaufeRntgen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String json = spiel.backendSpiel.kaufeGeraet("Roentgen");
				json = "{\"methoden\":" + json + "}";
				Katalog katalog = gson.fromJson(json, Katalog.class);
				txtrText.setText(katalog.toString());
				((CardLayout) panelContainer.getLayout()).show(panelContainer, TextPanelName);
			}
		});

		btnKaufeUltraschall.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String json = spiel.backendSpiel.kaufeGeraet("Ultraschall");
				json = "{\"methoden\":" + json + "}";
				Katalog katalog = gson.fromJson(json, Katalog.class);
				txtrText.setText(katalog.toString());
				((CardLayout) panelContainer.getLayout()).show(panelContainer, TextPanelName);
			}
		});

		btnffneKatalog.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String katalogString = spiel.backendSpiel.getManagerKatalog();
				katalogString = "{\"methoden\":" + katalogString + "}";
				Katalog katalog = gson.fromJson(katalogString, Katalog.class);
				btnKaufeUltraschall.setVisible(true);
				btnKaufeRntgen.setVisible(true);
				txtrText.setText(katalog.toString());
				((CardLayout) panelContainer.getLayout()).show(panelContainer, TextPanelName);
			}
		});

		btnPosteingang.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String json = spiel.backendSpiel.getMails();
				Posteingang post = gson.fromJson(json, Posteingang.class);
				System.out.println(post.toString());
				txtrText.setText(post.toString());
				((CardLayout) panelContainer.getLayout()).show(panelContainer, TextPanelName);
			}
		});

		btnLob.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String mailString = spiel.backendSpiel.sendeMail(Mails.LOB.name());
				Mail mail = gson.fromJson(mailString, Mail.class);
				UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("Tahoma", Font.PLAIN, FONT_SIZE)));
				txtrText.setText(mail.toString());
				((CardLayout) panelContainer.getLayout()).show(panelContainer, TextPanelName);
			}
		});

		btnAbmahnung.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String mailString = spiel.backendSpiel.sendeMail(Mails.ABMAHNUNG.name());
				Mail mail = gson.fromJson(mailString, Mail.class);
				UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("Tahoma", Font.PLAIN, FONT_SIZE)));
				txtrText.setText(mail.toString());
				((CardLayout) panelContainer.getLayout()).show(panelContainer, TextPanelName);
			}
		});

		btnGert.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String mailString = spiel.backendSpiel.sendeMail(Mails.GERAET_GEKAUFT.name());
				Mail mail = gson.fromJson(mailString, Mail.class);
				UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("Tahoma", Font.PLAIN, FONT_SIZE)));
				txtrText.setText(mail.toString());
				((CardLayout) panelContainer.getLayout()).show(panelContainer, TextPanelName);
			}
		});

		btnDefault.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String mailString = spiel.backendSpiel.sendeMail(Mails.DEFAULT_MAIL.name());
				Mail mail = gson.fromJson(mailString, Mail.class);
				UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("Tahoma", Font.PLAIN, FONT_SIZE)));
				txtrText.setText(mail.toString());
				((CardLayout) panelContainer.getLayout()).show(panelContainer, TextPanelName);
			}
		});

		btnMglicheMails.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String mailString = spiel.backendSpiel.getMoeglicheSendeMails();
				System.out.println(mailString);
				btnLob.setVisible(true);
				btnAbmahnung.setVisible(true);
				btnGert.setVisible(true);
				btnDefault.setVisible(true);

				txtrText.setText(Mails.LOB.name() + ":\n" + Mails.LOB.getMailText() + " \n" + Mails.ABMAHNUNG.name()
						+ ":\n" + Mails.ABMAHNUNG.getMailText() + Mails.GERAET_GEKAUFT.name() + ":\n"
						+ Mails.GERAET_GEKAUFT.getMailText() + "\n" + Mails.DEFAULT_MAIL.name() + ":\n"
						+ Mails.DEFAULT_MAIL.getMailText() + "\n");
				((CardLayout) panelContainer.getLayout()).show(panelContainer, TextPanelName);
			}
		});

		btnNeueRunde.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String rundenString = spiel.backendSpiel.neueRundeManager();
				RundeManager runde = gson.fromJson(rundenString, RundeManager.class);
				btnLob.setVisible(false);
				btnAbmahnung.setVisible(false);
				btnGert.setVisible(false);
				btnDefault.setVisible(false);
				btnKaufeUltraschall.setVisible(false);
				btnKaufeRntgen.setVisible(false);
				txtrText.setText(" ");
				lblRundeinfo.setText(runde.toString());
				((CardLayout) panelContainer.getLayout()).show(panelContainer, TextPanelName);

			}
		});
		btnZurcuekSponsor.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				((CardLayout) panelContainer.getLayout()).show(panelContainer, TextPanelName);
			}
		});
		btnZurueckIPartner.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				((CardLayout) panelContainer.getLayout()).show(panelContainer, TextPanelName);
			}
		});
		btnZurueck.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				((CardLayout) panelContainer.getLayout()).show(panelContainer, TextPanelName);
			}
		});
	}

	public String getFormattedText(String textInput) {
		List<String> textTokens = Arrays.asList(textInput.split(","));
		String text = "";
		StringBuilder stringBuilder = new StringBuilder();
		String delimiter = "";
		for (String sextteil : textTokens) {
			stringBuilder.append(delimiter);
			stringBuilder.append(sextteil);
			delimiter = ", ";
		}
		text = stringBuilder.toString();
		return text;
	}

	public JLabel getLblManagerinfo() {
		return lblManagerinfo;
	}

	public JLabel getLblArztinfo() {
		return lblArztinfo;
	}

	public JLabel getLblRunde() {
		return lblRundeinfo;
	}

	public void setText(String text) {
		txtrText.setText(text);
	}
}
