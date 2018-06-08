package UI;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.plaf.FontUIResource;

import com.google.gson.Gson;

import Frontend.*;
import java.awt.Font;
import java.awt.Graphics;
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
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.Color;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class Wirtschaft extends JPanel {
	private static final Gson gson = new Gson();
	private static final int FONT_SIZE = 30;
	private static final String TextPanelName = "TextPanel";
	private static final String InterviewPartnerPanelName = "InterviewPartnerPanel";
	private static final String InterviewPanelName = "InterviewPanel";
	private static final String SponsorenPanelName = "SponsorenPanel";
	private static final String SponsorAnwerbenPanelName = "SponsorAnwerbenPanel";
	private static final String MailPanelName = "MailPanel";
	private static final String PressekonferenzPanelName = "PressekonferenzPanel";
	private final Spiel spiel;

	private List<Mail> mails;
	private Sponsoren sponsoren;
	private Partner partnerListe;
	private boolean presseLauft = false;
	private boolean interviewLauft = false;

	private final JPanel buttonPanel = new JPanel();
	private final JPanel panelContainer = new JPanel();
	private final JPanel TextPanel = new JPanel();
	private final JPanel InterviewPartnerPanel = new JPanel();
	private final JPanel InterviewPanel = new JPanel() {
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			if (background != null) {
				g.drawImage(background, 0, 0, null);
			}
		}
	};

	private Image background;
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
	private final JButton btnAntwort_3 = new JButton("Antwort");

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
	private final JButton btnSponsorAnwerben11 = new JButton("anwerben");
	private final JButton btnSponsorAnwerben12 = new JButton("anwerben");
	private final JButton btnSponsorAnwerben13 = new JButton("anwerben");
	private final JButton btnSponsorAnwerben14 = new JButton("anwerben");
	private final JButton[] sponsorenButtons = { btnSponsorAnwerben1, btnSponsorAnwerben2, btnSponsorAnwerben3,
			btnSponsorAnwerben4, btnSponsorAnwerben5, btnSponsorAnwerben6, btnSponsorAnwerben7, btnSponsorAnwerben8,
			btnSponsorAnwerben9, btnSponsorAnwerben10, btnSponsorAnwerben11, btnSponsorAnwerben12, btnSponsorAnwerben13,
			btnSponsorAnwerben14 };

	private final JButton btnZurueck = new JButton("Zur\u00FCck");
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
	private final JButton btnMglicheMails = new JButton("M\u00F6gliche Mails");

	private final JLabel lblManagerinfo = new JLabel(" ");
	private final JLabel lblArztinfo = new JLabel(" ");
	private final JLabel lblRundeinfo = new JLabel(" ");
	private final JLabel lblWirtschaft = new JLabel("Wirtschaft");
	private final JLabel lblInterviewPartner = new JLabel("Interview Partner");

	private final JLabel lblPartner = new JLabel(" ");
	private final JLabel lblPartner_1 = new JLabel(" ");
	private final JLabel lblPartner_2 = new JLabel(" ");
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
	private final JLabel lblSponsor11 = new JLabel(" ");
	private final JLabel lblSponsor12 = new JLabel(" ");
	private final JLabel lblSponsor13 = new JLabel(" ");
	private final JLabel lblSponsor14 = new JLabel(" ");

	private final JLabel lblSponsorAnwerben = new JLabel("Sponsor anwerben");

	private final JPanel InfoPanel = new JPanel();
	private final JLabel lblRunde = new JLabel("Runde:");
	private final JLabel lblManager = new JLabel("Manager:");
	private final JLabel lblArzt = new JLabel("Arzt:");

	private JTextArea txtrText = new JTextArea(" ", 20, 25);
	private final JPanel mailPanel = new JPanel();
	private final JLabel lblPosteingang = new JLabel("Posteingang");
	private final JButton btnMail1 = new JButton("New button");
	private final JButton btnMail2 = new JButton("New button");
	private final JButton btnMail3 = new JButton("New button");
	private final JButton btnMail4 = new JButton("New button");
	private final JButton btnMail5 = new JButton("New button");
	private final JButton btnMail6 = new JButton("New button");
	private final JButton btnMail7 = new JButton("New button");
	private final JButton btnMail8 = new JButton("New button");
	private final JButton btnMail9 = new JButton("New button");
	private final JButton btnMail10 = new JButton("New button");
	private final JButton btnMail11 = new JButton("New button");
	private final JButton btnMail12 = new JButton("New button");
	private final JButton btnMail13 = new JButton("New button");
	private final JButton btnMail14 = new JButton("New button");
	private final JButton btnMail15 = new JButton("New button");
	private final JButton btnMail16 = new JButton("New button");
	private final JButton btnMail17 = new JButton("New button");
	private final JButton btnMail18 = new JButton("New button");
	private final JButton btnMail19 = new JButton("New button");
	private final JButton btnMail20 = new JButton("New button");
	private final JButton btnMail21 = new JButton("New button");
	private final JButton btnMail22 = new JButton("New button");
	private final JButton btnMail23 = new JButton("New button");
	private final JButton btnMail24 = new JButton("New button");
	private final JButton btnMail25 = new JButton("New button");
	private final JButton btnMail26 = new JButton("New button");
	private final JButton btnMail27 = new JButton("New button");
	private final JButton btnMail28 = new JButton("New button");
	private final JButton btnMail29 = new JButton("New button");
	private final JButton btnMail30 = new JButton("New button");
	private final JButton btnMail31 = new JButton("New button");
	private final JButton btnMail32 = new JButton("New button");
	private final JButton btnMail33 = new JButton("New button");
	private final JButton btnMail34 = new JButton("New button");
	private final JButton btnMail35 = new JButton("New button");
	private final JButton btnMail36 = new JButton("New button");
	private final JButton btnMail37 = new JButton("New button");
	private final JButton btnMail38 = new JButton("New button");
	private final JButton btnMail39 = new JButton("New button");
	private final JButton btnMail40 = new JButton("New button");
	private final JButton btnMail41 = new JButton("New button");
	private final JButton[] mailButtons = { btnMail1, btnMail2, btnMail3, btnMail4, btnMail5, btnMail6, btnMail7,
			btnMail8, btnMail9, btnMail10, btnMail11, btnMail12, btnMail13, btnMail14, btnMail15, btnMail16, btnMail17,
			btnMail18, btnMail19, btnMail20, btnMail21, btnMail22, btnMail23, btnMail24, btnMail25, btnMail26,
			btnMail27, btnMail28, btnMail29, btnMail30, btnMail31, btnMail32, btnMail33, btnMail34, btnMail35,
			btnMail36, btnMail37, btnMail38, btnMail39, btnMail40, btnMail41 };

	private final JPanel MailTestPanel = new JPanel();
	private final JTextArea textArea = new JTextArea();
	private final JButton btnSponsoren = new JButton("Sponsoren");
	private final JLabel lblIhreAnfrageWurde = new JLabel(
			"<html>Ihre Anfrage wurde an den Sponsor gesendet.<br>Der Sponsor wird ihnen eine Mail schicken ob er Sie unterst\u00FCtzt.</html>");
	private final JPanel pressrkonferenzPanel = new JPanel();
	private final JLabel lblPressekonferenz = new JLabel("Pressekonferenz");
	private final JLabel lblThema = new JLabel("Thema");
	private final JLabel lblPresseFrage = new JLabel("Frage1");
	private final JButton btnPresseAntwort1 = new JButton("Antwort1");
	private final JButton btnPresseAntwort2 = new JButton("Antwort2");
	private final JButton btnPresseAntwort3 = new JButton("Antwort3");
	private final JLabel lblEinleitung = new JLabel("Einleiting");
	private final JPanel mailButtonContainerPanel = new JPanel();
	private final JScrollPane scrollPane_2 = new JScrollPane();
	private final JPanel mailButtonPanel = new JPanel();
	private final JLabel lblEmpty = new JLabel(" ");
	private final JLabel lblPartnerName = new JLabel("New label");
	private final JLabel lblStatus = new JLabel("Status");

	/**
	 * Create the panel.
	 */
	public Wirtschaft(Spiel spiel) {
		setBackground(new Color(0, 0, 102));
		this.spiel = spiel;
		setPreferredSize(new Dimension(2000, 930));
		setLayout();
		lblWirtschaft.setForeground(Color.WHITE);

		add(lblWirtschaft, "cell 0 0 3 1,growx,aligny top");
		add(buttonPanel, "cell 0 1,alignx left,aligny top");
		panelContainer.setBackground(new Color(0, 0, 153));
		add(panelContainer, "cell 1 1");

		panelContainer.setLayout(new CardLayout(0, 0));

		GroupLayout gl_TextPanel = new GroupLayout(TextPanel);
		gl_TextPanel.setHorizontalGroup(gl_TextPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_TextPanel.createSequentialGroup().addContainerGap()
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 1187, Short.MAX_VALUE).addContainerGap()));
		scrollPane.setBackground(new Color(0, 0, 153));
		gl_TextPanel.setVerticalGroup(gl_TextPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_TextPanel.createSequentialGroup().addContainerGap()
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 711, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(136, Short.MAX_VALUE)));
		txtrText.setBackground(new Color(0, 0, 204));
		txtrText.setForeground(Color.WHITE);
		scrollPane.setViewportView(txtrText);

		txtrText.setWrapStyleWord(true);
		txtrText.setEditable(false);
		txtrText.setLineWrap(true);
		txtrText.setFocusable(false);
		txtrText.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		textArea.setBackground(new Color(0, 0, 204));
		textArea.setForeground(Color.WHITE);

		textArea.setWrapStyleWord(true);
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		textArea.setFocusable(false);
		TextPanel.setBackground(new Color(0, 0, 153));

		TextPanel.setLayout(gl_TextPanel);

		add(InfoPanel, "cell 2 1,grow");

		setFormat();
		addActionListeners();
		addComponents();
		setBtnInvisibele();

	}

	private void setLayout() {
		setLayout(new MigLayout("", "[340][1230.00px][410.00px]", "[53px][749.00px][]"));
		InfoPanel.setLayout(new MigLayout("", "[305.00px]", "[37px][234.00px][37px][123.00px][37px][129.00px]"));
		SponsorenPanel.setForeground(Color.WHITE);
		SponsorenPanel.setBackground(new Color(0, 0, 153));
		SponsorenPanel.setLayout(new MigLayout("", "[100.00][350][150][350][151.00]", "[][][][][][][][][]"));
		SponsorAnwerbenPanel.setBackground(new Color(0, 0, 153));
		SponsorAnwerbenPanel.setLayout(new MigLayout("", "[115.00][150][980]", "[33.00][][]"));
		InterviewPartnerPanel.setBackground(new Color(0, 0, 153));

		InterviewPartnerPanel.setLayout(new MigLayout("", "[100][320][210][600]", "[][][][][][][]"));
	}

	private void setFormat() {
		buttonPanel.setOpaque(false);
		panelContainer.setOpaque(false);
		InfoPanel.setOpaque(false);
		lblManagerinfo.setForeground(Color.WHITE);

		lblManagerinfo.setHorizontalAlignment(SwingConstants.LEFT);
		lblManagerinfo.setVerticalAlignment(SwingConstants.TOP);
		lblArztinfo.setForeground(Color.WHITE);
		lblArztinfo.setVerticalAlignment(SwingConstants.TOP);
		lblArztinfo.setHorizontalAlignment(SwingConstants.LEFT);

		lblWirtschaft.setHorizontalAlignment(SwingConstants.CENTER);
		lblWirtschaft.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblWirtschaft.setFont(new Font("Tahoma", Font.PLAIN, 35));
		btnInterviewpartner.setBorder(new LineBorder(Color.GRAY, 2));
		btnInterviewpartner.setBackground(Color.DARK_GRAY);
		btnInterviewpartner.setForeground(Color.WHITE);

		btnInterviewpartner.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnZurueckIPartner.setBorder(new LineBorder(Color.GRAY, 2, true));
		btnZurueckIPartner.setBackground(Color.DARK_GRAY);
		btnZurueckIPartner.setForeground(Color.WHITE);
		btnZurueckIPartner.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnBeginneInterview.setForeground(Color.WHITE);
		btnBeginneInterview.setBorder(new LineBorder(Color.GRAY, 2, true));
		btnBeginneInterview.setBackground(Color.DARK_GRAY);
		btnBeginneInterview.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnBeginneInterview_1.setBorder(new LineBorder(Color.GRAY, 2, true));
		btnBeginneInterview_1.setBackground(Color.DARK_GRAY);
		btnBeginneInterview_1.setForeground(Color.WHITE);
		btnBeginneInterview_1.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnBeginneInterview_2.setForeground(Color.WHITE);
		btnBeginneInterview_2.setBorder(new LineBorder(Color.GRAY, 2, true));
		btnBeginneInterview_2.setBackground(Color.DARK_GRAY);
		btnBeginneInterview_2.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnAntwort.setForeground(Color.WHITE);
		btnAntwort.setBackground(Color.DARK_GRAY);
		btnAntwort.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnAntwort_1.setBackground(Color.DARK_GRAY);
		btnAntwort_1.setForeground(Color.WHITE);
		btnAntwort_1.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnAntwort_2.setForeground(Color.WHITE);
		btnAntwort_2.setBackground(Color.DARK_GRAY);
		btnAntwort_2.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnAntwort_3.setForeground(Color.WHITE);
		btnAntwort_3.setBackground(Color.DARK_GRAY);
		btnAntwort_3.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnZurcuekSponsor.setBorder(new LineBorder(Color.GRAY, 2, true));
		btnZurcuekSponsor.setBackground(Color.DARK_GRAY);
		btnZurcuekSponsor.setForeground(Color.WHITE);

		btnZurcuekSponsor.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnZurueck.setForeground(Color.WHITE);

		btnZurueck.setBorder(new LineBorder(Color.GRAY, 2, true));
		btnZurueck.setBackground(Color.DARK_GRAY);

		btnZurueck.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnNeueRunde.setForeground(Color.WHITE);
		btnNeueRunde.setBackground(Color.DARK_GRAY);
		btnNeueRunde.setBorder(new LineBorder(new Color(128, 128, 128), 2, true));

		btnNeueRunde.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnNeueRunde.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnBudgetbreicht.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnBudgetbreicht.setBackground(Color.DARK_GRAY);
		btnBudgetbreicht.setForeground(Color.WHITE);
		btnBudgetbreicht.setBorder(new LineBorder(new Color(128, 128, 128), 2, true));
		btnArztbreicht.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnArztbreicht.setBackground(Color.DARK_GRAY);
		btnArztbreicht.setForeground(Color.WHITE);
		btnArztbreicht.setBorder(new LineBorder(new Color(128, 128, 128), 2, true));
		btnHaltePressekonferenz.setBorder(new LineBorder(new Color(128, 128, 128), 2, true));
		btnHaltePressekonferenz.setBackground(Color.DARK_GRAY);
		btnHaltePressekonferenz.setForeground(Color.WHITE);
		btnHaltePressekonferenz.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnKaufeRntgen.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnKaufeRntgen.setBackground(Color.DARK_GRAY);
		btnKaufeRntgen.setForeground(Color.WHITE);
		btnKaufeRntgen.setBorder(new LineBorder(new Color(128, 128, 128), 2, true));
		btnKaufeUltraschall.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnKaufeUltraschall.setBackground(Color.DARK_GRAY);
		btnKaufeUltraschall.setForeground(Color.WHITE);
		btnKaufeUltraschall.setBorder(new LineBorder(new Color(128, 128, 128), 2, true));
		btnffneKatalog.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnffneKatalog.setBackground(Color.DARK_GRAY);
		btnffneKatalog.setForeground(Color.WHITE);
		btnffneKatalog.setBorder(new LineBorder(new Color(128, 128, 128), 2, true));
		btnPosteingang.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnPosteingang.setBackground(Color.DARK_GRAY);
		btnPosteingang.setForeground(Color.WHITE);
		btnPosteingang.setBorder(new LineBorder(new Color(128, 128, 128), 2, true));
		btnLob.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnLob.setBackground(Color.DARK_GRAY);
		btnLob.setForeground(Color.WHITE);
		btnLob.setBorder(new LineBorder(new Color(128, 128, 128), 2, true));
		btnAbmahnung.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnAbmahnung.setBackground(Color.DARK_GRAY);
		btnAbmahnung.setForeground(Color.WHITE);
		btnAbmahnung.setBorder(new LineBorder(new Color(128, 128, 128), 2, true));
		btnGert.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnGert.setBackground(Color.DARK_GRAY);
		btnGert.setForeground(Color.WHITE);
		btnGert.setBorder(new LineBorder(new Color(128, 128, 128), 2, true));
		btnMglicheMails.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnMglicheMails.setBackground(Color.DARK_GRAY);
		btnMglicheMails.setForeground(Color.WHITE);
		btnMglicheMails.setBorder(new LineBorder(new Color(128, 128, 128), 2, true));

		lblManagerinfo.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		lblArztinfo.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		lblRundeinfo.setForeground(Color.WHITE);
		lblRundeinfo.setHorizontalAlignment(SwingConstants.LEFT);
		lblRundeinfo.setVerticalAlignment(SwingConstants.TOP);
		lblRundeinfo.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		lblWirtschaft.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		lblInterviewPartner.setForeground(Color.WHITE);

		lblInterviewPartner.setHorizontalAlignment(SwingConstants.CENTER);
		lblInterviewPartner.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		lblPartner.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		lblPartner.setForeground(Color.WHITE);
		lblPartner_1.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		lblPartner_1.setForeground(Color.WHITE);
		lblPartner_2.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		lblPartner_2.setForeground(Color.WHITE);
		lblInterview.setForeground(Color.LIGHT_GRAY);
		lblInterview.setHorizontalAlignment(SwingConstants.CENTER);
		lblInterview.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		lblFrage.setBackground(Color.GRAY);
		lblFrage.setForeground(Color.WHITE);
		lblFrage.setHorizontalAlignment(SwingConstants.CENTER);
		lblFrage.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnSponsoren.setBackground(Color.DARK_GRAY);
		btnSponsoren.setForeground(Color.WHITE);
		btnSponsoren.setBorder(new LineBorder(new Color(128, 128, 128), 2, true));

		btnSponsoren.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		lblMglicheSponsoren.setForeground(Color.WHITE);

		lblMglicheSponsoren.setHorizontalAlignment(SwingConstants.CENTER);
		lblMglicheSponsoren.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		lblSponsor1.setForeground(Color.WHITE);
		lblSponsor1.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblSponsor2.setForeground(Color.WHITE);
		lblSponsor2.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblSponsor3.setForeground(Color.WHITE);
		lblSponsor3.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblSponsor4.setForeground(Color.WHITE);
		lblSponsor4.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblSponsor5.setForeground(Color.WHITE);
		lblSponsor5.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblSponsor6.setForeground(Color.WHITE);
		lblSponsor6.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblSponsor7.setForeground(Color.WHITE);
		lblSponsor7.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblSponsor8.setForeground(Color.WHITE);
		lblSponsor8.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblSponsor9.setForeground(Color.WHITE);
		lblSponsor9.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblSponsor10.setForeground(Color.WHITE);
		lblSponsor10.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblSponsor11.setForeground(Color.WHITE);
		lblSponsor11.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblSponsor12.setForeground(Color.WHITE);
		lblSponsor12.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblSponsor13.setForeground(Color.WHITE);
		lblSponsor13.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblSponsor14.setForeground(Color.WHITE);
		lblSponsor14.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblSponsorAnwerben.setForeground(Color.WHITE);

		lblSponsorAnwerben.setHorizontalAlignment(SwingConstants.CENTER);
		lblSponsorAnwerben.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		lblIhreAnfrageWurde.setForeground(Color.WHITE);
		lblIhreAnfrageWurde.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));

		InfoPanel.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		lblRunde.setForeground(Color.WHITE);
		lblRunde.setVerticalAlignment(SwingConstants.TOP);
		lblRunde.setHorizontalAlignment(SwingConstants.LEFT);
		lblRunde.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		lblManager.setForeground(Color.WHITE);
		lblManager.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		lblArzt.setForeground(Color.WHITE);
		lblArzt.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));

		txtrText.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		lblPosteingang.setForeground(Color.WHITE);

		lblPosteingang.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));

		for (JButton button : mailButtons) {
			button.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
			button.setForeground(Color.WHITE);
			button.setBorder(new LineBorder(Color.GRAY, 2, true));
			button.setBackground(Color.DARK_GRAY);
		}

		textArea.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		lblPressekonferenz.setForeground(Color.WHITE);

		lblPressekonferenz.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		lblThema.setForeground(Color.WHITE);
		lblThema.setVerticalAlignment(SwingConstants.TOP);
		lblThema.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		lblPresseFrage.setBackground(new Color(0, 0, 204));
		lblPresseFrage.setForeground(Color.WHITE);
		lblPresseFrage.setOpaque(true);
		lblPresseFrage.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnPresseAntwort1.setForeground(Color.WHITE);
		btnPresseAntwort1.setBorder(new LineBorder(Color.GRAY, 2, true));
		btnPresseAntwort1.setBackground(Color.DARK_GRAY);
		btnPresseAntwort1.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnPresseAntwort2.setForeground(Color.WHITE);
		btnPresseAntwort2.setBorder(new LineBorder(Color.GRAY, 2, true));
		btnPresseAntwort2.setBackground(Color.DARK_GRAY);
		btnPresseAntwort2.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnPresseAntwort3.setForeground(Color.WHITE);
		btnPresseAntwort3.setBorder(new LineBorder(Color.GRAY, 2, true));
		btnPresseAntwort3.setBackground(Color.DARK_GRAY);
		btnPresseAntwort3.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		lblEinleitung.setForeground(Color.WHITE);
		lblEinleitung.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));

		lblPartnerName.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		lblPartnerName.setForeground(Color.WHITE);
		lblStatus.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		lblStatus.setForeground(Color.WHITE);
	}

	private void addComponents() {
		panelContainer.add(TextPanel, TextPanelName);
		panelContainer.add(InterviewPartnerPanel, InterviewPartnerPanelName);
		panelContainer.add(InterviewPanel, InterviewPanelName);
		panelContainer.add(SponsorenPanel, SponsorenPanelName);
		panelContainer.add(SponsorAnwerbenPanel, SponsorAnwerbenPanelName);
		mailPanel.setBackground(new Color(0, 0, 153));
		panelContainer.add(mailPanel, MailPanelName);
		pressrkonferenzPanel.setBackground(new Color(0, 0, 153));
		panelContainer.add(pressrkonferenzPanel, PressekonferenzPanelName);
		pressrkonferenzPanel.setLayout(new MigLayout("", "[1230.00]", "[][][458.00][][][][][]"));
		lblPressekonferenz.setHorizontalAlignment(SwingConstants.CENTER);

		pressrkonferenzPanel.add(lblPressekonferenz, "cell 0 0,growx");
		lblThema.setHorizontalAlignment(SwingConstants.CENTER);

		pressrkonferenzPanel.add(lblThema, "cell 0 1,grow");
		lblEinleitung.setVerticalAlignment(SwingConstants.TOP);
		lblEinleitung.setHorizontalAlignment(SwingConstants.CENTER);

		pressrkonferenzPanel.add(lblEinleitung, "cell 0 2,grow");
		lblPresseFrage.setHorizontalAlignment(SwingConstants.CENTER);

		pressrkonferenzPanel.add(lblPresseFrage, "cell 0 3,growx");

		pressrkonferenzPanel.add(btnPresseAntwort1, "cell 0 5,growx");

		pressrkonferenzPanel.add(btnPresseAntwort2, "cell 0 6,growx");

		pressrkonferenzPanel.add(btnPresseAntwort3, "cell 0 7,growx");

		InterviewPartnerPanel.add(lblInterviewPartner, "cell 1 0 3 1,growx");
		InterviewPartnerPanel.add(lblPartner, "cell 1 2");
		InterviewPartnerPanel.add(lblPartner_1, "cell 1 4");
		InterviewPartnerPanel.add(lblPartner_2, "cell 1 6");

		InterviewPartnerPanel.add(btnZurueckIPartner, "cell 0 0,grow");
		InterviewPartnerPanel.add(btnBeginneInterview, "cell 2 2");
		InterviewPartnerPanel.add(btnBeginneInterview_1, "cell 2 4");
		InterviewPartnerPanel.add(btnBeginneInterview_2, "cell 2 6");
		InterviewPanel.setLayout(new MigLayout("", "[394.00px][904.00]", "[][][][403.00][37px][45px][45px][45px][]"));

		InterviewPanel.add(lblInterview, "cell 0 0 2 1,growx,aligny top");

		InterviewPanel.add(lblPartnerName, "cell 0 1,grow");

		InterviewPanel.add(lblStatus, "cell 0 2");
		InterviewPanel.add(lblFrage, "cell 0 4 2 1,growx,aligny top");

		InterviewPanel.add(btnAntwort, "cell 0 5 2 1,growx,aligny top");
		InterviewPanel.add(btnAntwort_1, "cell 0 6 2 1,growx,aligny top");
		InterviewPanel.add(btnAntwort_2, "cell 0 7 2 1,growx,aligny top");

		InterviewPanel.add(btnAntwort_3, "cell 0 8 2 1,growx");

		SponsorenPanel.add(lblMglicheSponsoren, "cell 1 0 4 1,growx");
		SponsorenPanel.add(lblSponsor1, "cell 1 2");
		SponsorenPanel.add(lblSponsor2, "cell 1 3");
		SponsorenPanel.add(lblSponsor3, "cell 1 4");
		SponsorenPanel.add(lblSponsor4, "cell 1 5");
		SponsorenPanel.add(lblSponsor5, "cell 1 6");
		SponsorenPanel.add(lblSponsor6, "cell 1 7");
		SponsorenPanel.add(lblSponsor7, "cell 1 8");
		SponsorenPanel.add(lblSponsor8, "cell 3 2");
		SponsorenPanel.add(lblSponsor9, "cell 3 3");
		SponsorenPanel.add(lblSponsor10, "cell 3 4");
		SponsorenPanel.add(lblSponsor11, "cell 3 5");
		SponsorenPanel.add(lblSponsor12, "cell 3 6");
		SponsorenPanel.add(lblSponsor13, "cell 3 7");
		SponsorenPanel.add(lblSponsor14, "cell 3 8");

		SponsorenPanel.add(btnZurcuekSponsor, "cell 0 0,grow");
		SponsorenPanel.add(btnSponsorAnwerben1, "cell 2 2,growx");
		SponsorenPanel.add(btnSponsorAnwerben2, "cell 2 3,growx");
		SponsorenPanel.add(btnSponsorAnwerben3, "cell 2 4,growx");
		SponsorenPanel.add(btnSponsorAnwerben4, "cell 2 5,growx");
		SponsorenPanel.add(btnSponsorAnwerben5, "cell 2 6,growx");
		SponsorenPanel.add(btnSponsorAnwerben6, "cell 2 7,growx");
		SponsorenPanel.add(btnSponsorAnwerben7, "cell 2 8,growx");
		SponsorenPanel.add(btnSponsorAnwerben8, "cell 4 2,growx");
		SponsorenPanel.add(btnSponsorAnwerben9, "cell 4 3,growx");
		SponsorenPanel.add(btnSponsorAnwerben10, "cell 4 4,growx");
		SponsorenPanel.add(btnSponsorAnwerben11, "cell 4 5,growx");
		SponsorenPanel.add(btnSponsorAnwerben12, "cell 4 6,growx");
		SponsorenPanel.add(btnSponsorAnwerben13, "cell 4 7,growx");
		SponsorenPanel.add(btnSponsorAnwerben14, "cell 4 8,growx");
		for (JButton button : sponsorenButtons) {
			button.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
			button.setForeground(Color.WHITE);
			button.setBorder(new LineBorder(Color.GRAY, 2, true));
			button.setBackground(Color.DARK_GRAY);
		}
		SponsorAnwerbenPanel.add(btnZurueck, "cell 0 0,growx");

		SponsorAnwerbenPanel.add(lblSponsorAnwerben, "cell 1 0 2 1,growx");

		SponsorAnwerbenPanel.add(lblIhreAnfrageWurde, "cell 2 2");

		mailPanel.setLayout(new MigLayout("", "[415][grow]", "[26px][][42.00,grow]"));
		lblPosteingang.setHorizontalAlignment(SwingConstants.CENTER);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBackground(new Color(0, 0, 153));
		GroupLayout gl_MailTestPanel = new GroupLayout(MailTestPanel);
		gl_MailTestPanel.setHorizontalGroup(gl_MailTestPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 1024, Short.MAX_VALUE));
		gl_MailTestPanel.setVerticalGroup(gl_MailTestPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 698, Short.MAX_VALUE));

		scrollPane_1.setViewportView(textArea);
		MailTestPanel.setBackground(new Color(0, 0, 153));
		MailTestPanel.setLayout(gl_MailTestPanel);

		InfoPanel.add(lblRunde, "cell 0 0,alignx left,aligny top");
		InfoPanel.add(lblRundeinfo, "cell 0 1,grow");
		InfoPanel.add(lblManager, "cell 0 2,alignx left,aligny top");
		InfoPanel.add(lblManagerinfo, "cell 0 3,alignx left,aligny top");
		InfoPanel.add(lblArzt, "cell 0 4,alignx left,aligny top");
		InfoPanel.add(lblArztinfo, "cell 0 5,alignx left,aligny top");
		buttonPanel.setLayout(new GridLayout(0, 1, 0, 0));

		buttonPanel.add(btnNeueRunde);
		buttonPanel.add(btnHaltePressekonferenz);
		buttonPanel.add(btnInterviewpartner);

		buttonPanel.add(btnSponsoren);
		buttonPanel.add(btnffneKatalog);
		buttonPanel.add(btnKaufeRntgen, "cell 0 4,alignx left,aligny top");
		buttonPanel.add(btnKaufeUltraschall, "cell 0 5,alignx left,aligny top");
		buttonPanel.add(btnPosteingang);
		buttonPanel.add(btnMglicheMails);
		buttonPanel.add(btnLob);
		buttonPanel.add(btnAbmahnung);
		buttonPanel.add(btnGert);
		buttonPanel.add(btnKaufeRntgen, "cell 0 4,alignx left,aligny top");
		buttonPanel.add(btnKaufeUltraschall, "cell 0 5,alignx left,aligny top");
		buttonPanel.add(btnArztbreicht);
		buttonPanel.add(btnBudgetbreicht);

		mailPanel.add(lblPosteingang, "cell 0 0 2 1,growx,aligny top");
		mailButtonContainerPanel.setBackground(new Color(0, 0, 153));

		mailPanel.add(mailButtonContainerPanel, "flowx,cell 0 2,grow");
		mailButtonContainerPanel.setLayout(new GridLayout(1, 0, 0, 0));
		mailButtonContainerPanel.add(scrollPane_2);
		mailButtonPanel.setBackground(new Color(0, 0, 153));

		scrollPane_2.setViewportView(mailButtonPanel);
		mailButtonPanel.setLayout(new GridLayout(0, 1, 0, 0));
		lblEmpty.setBackground(new Color(0, 0, 153));
		lblEmpty.setMinimumSize(new Dimension(57, 420));
		lblEmpty.setVerticalAlignment(SwingConstants.TOP);

		mailButtonPanel.add(lblEmpty);

		mailPanel.add(MailTestPanel, "cell 1 2,grow");

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
				if (!presseLauft) {
					btnPresseAntwort3.setVisible(false);
					lblEinleitung.setText("");

					String json = spiel.backendSpiel.haltePressekonferenz();
					Pressekonferenz kon = gson.fromJson(json, Pressekonferenz.class);
					if (!"fehler".equals(kon.getStatus().toLowerCase())) {
						lblThema.setText(kon.getThema());
						lblPresseFrage
								.setText("<html>" + kon.getFrage().toString().replaceAll("\\n", "<br>") + "</html>");
						btnPresseAntwort1.setText(
								"<html>" + kon.getAntworten()[0].toString().replaceAll("\\n", "<br>") + "</html>");
						btnPresseAntwort2.setText(
								"<html>" + kon.getAntworten()[1].toString().replaceAll("\\n", "<br>") + "</html>");

						btnPresseAntwort1.setVisible(true);
						btnPresseAntwort2.setVisible(true);
						presseLauft = true;
					} else {
						lblThema.setText("Momentan ist keine Pressekonferenz verfügbar");
						btnPresseAntwort1.setVisible(false);
						btnPresseAntwort2.setVisible(false);
						btnPresseAntwort3.setVisible(false);
						lblPresseFrage.setText("");
					}
				}
				((CardLayout) panelContainer.getLayout()).show(panelContainer, PressekonferenzPanelName);
			}
		});
		btnPresseAntwort1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				presseAntwort(0);
			}
		});
		btnPresseAntwort2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				presseAntwort(1);
			}
		});
		btnPresseAntwort3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				presseAntwort(2);
			}
		});

		btnInterviewpartner.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String json = spiel.backendSpiel.getInterviewPartner();
				partnerListe = gson.fromJson(json, Partner.class);
				lblPartner.setText(partnerListe.interviewPartner.get(0).toString());
				// lblPartner_1.setText(partnerListe.partnerListe.get(1).toString());
				// lblPartner_2.setText(partnerListe.partnerListe.get(2).toString());
				((CardLayout) panelContainer.getLayout()).show(panelContainer, InterviewPartnerPanelName);
			}
		});
		btnBeginneInterview.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (interviewLauft) {
					((CardLayout) panelContainer.getLayout()).show(panelContainer, InterviewPanelName);
				} else {
					beginneInterview(partnerListe.interviewPartner.get(0).getId());
				}
			}
		});
		btnBeginneInterview_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (interviewLauft) {
					((CardLayout) panelContainer.getLayout()).show(panelContainer, InterviewPanelName);
				} else {
					beginneInterview(partnerListe.interviewPartner.get(1).getId());
				}
			}
		});
		btnBeginneInterview_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (interviewLauft) {
					((CardLayout) panelContainer.getLayout()).show(panelContainer, InterviewPanelName);
				} else {
					beginneInterview(partnerListe.interviewPartner.get(2).getId());
				}
			}
		});
		btnAntwort.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				interviewAntwort(0);

			}
		});
		btnAntwort_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				interviewAntwort(1);

			}
		});
		btnAntwort_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				interviewAntwort(2);

			}
		});
		btnAntwort_3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				interviewAntwort(3);

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
				// btnKaufeUltraschall.setVisible(true);
				// btnKaufeRntgen.setVisible(true);
				txtrText.setText(katalog.toString());
				((CardLayout) panelContainer.getLayout()).show(panelContainer, TextPanelName);
			}
		});
		addMailActionListeners();

		btnLob.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String mailString = spiel.backendSpiel.sendeMail(Mails.LOB.name());
				Mail mail = gson.fromJson(mailString, Mail.class);
				UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("Tahoma", Font.PLAIN, FONT_SIZE)));
				txtrText.setText("Mail gesendet:\n\n" + mail.toString());
				((CardLayout) panelContainer.getLayout()).show(panelContainer, TextPanelName);
			}
		});

		btnAbmahnung.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String mailString = spiel.backendSpiel.sendeMail(Mails.ABMAHNUNG.name());
				Mail mail = gson.fromJson(mailString, Mail.class);
				UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("Tahoma", Font.PLAIN, FONT_SIZE)));
				txtrText.setText("Mail gesendet:\n\n" + mail.toString());
				((CardLayout) panelContainer.getLayout()).show(panelContainer, TextPanelName);
			}
		});

		btnGert.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String mailString = spiel.backendSpiel.sendeMail(Mails.GERAET_GEKAUFT.name());
				Mail mail = gson.fromJson(mailString, Mail.class);
				UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("Tahoma", Font.PLAIN, FONT_SIZE)));
				txtrText.setText("Mail gesendet:\n\n" + mail.toString());
				((CardLayout) panelContainer.getLayout()).show(panelContainer, TextPanelName);
			}
		});

		btnMglicheMails.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String mailString = spiel.backendSpiel.getMoeglicheSendeMails();

				btnLob.setVisible(true);
				btnAbmahnung.setVisible(true);
				// btnGert.setVisible(true);

				txtrText.setText(Mails.LOB.name() + ":\n" + Mails.LOB.getMailText() + " \n\n\n" + Mails.ABMAHNUNG.name()
						+ ":\n" + Mails.ABMAHNUNG.getMailText() + "\n");
				((CardLayout) panelContainer.getLayout()).show(panelContainer, TextPanelName);
			}
		});

		addSponsorActionListeners();

		btnNeueRunde.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String rundenString = spiel.backendSpiel.neueRundeManager();
				RundeManager runde = gson.fromJson(rundenString, RundeManager.class);
				setBtnInvisibele();
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
				((CardLayout) panelContainer.getLayout()).show(panelContainer, SponsorenPanelName);
			}
		});
	}

	private void setBtnInvisibele() {
		for (JButton button : mailButtons) {
			button.setVisible(false);
		}

		btnKaufeRntgen.setVisible(false);
		btnKaufeUltraschall.setVisible(false);
		btnLob.setVisible(false);
		btnAbmahnung.setVisible(false);
		btnGert.setVisible(false);
		btnBeginneInterview_1.setVisible(false);
		btnBeginneInterview_2.setVisible(false);
		btnBudgetbreicht.setVisible(false);
		btnArztbreicht.setVisible(false);

		btnBeginneInterview.setVisible(true);

	}

	private void addSponsorActionListeners() {
		btnSponsoren.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String json = spiel.backendSpiel.getSponsoren();
				sponsoren = gson.fromJson(json, Sponsoren.class);

				if (sponsoren.getSponsoren().size() == 4) {
					lblSponsor1.setText(sponsoren.getSponsoren().get(0).toString());

					if (sponsoren.getSponsoren().get(0).isAngeworben()) {
						btnSponsorAnwerben1.setVisible(false);
					} else {
						btnSponsorAnwerben1.setVisible(true);
					}
					lblSponsor2.setText(sponsoren.getSponsoren().get(1).toString());
					if (sponsoren.getSponsoren().get(1).isAngeworben()) {
						btnSponsorAnwerben2.setVisible(false);
					} else {
						btnSponsorAnwerben2.setVisible(true);
					}
					lblSponsor3.setText(sponsoren.getSponsoren().get(2).toString());
					if (sponsoren.getSponsoren().get(2).isAngeworben()) {
						btnSponsorAnwerben3.setVisible(false);
					} else {
						btnSponsorAnwerben3.setVisible(true);
					}
					lblSponsor4.setText(sponsoren.getSponsoren().get(3).toString());
					if (sponsoren.getSponsoren().get(3).isAngeworben()) {
						btnSponsorAnwerben4.setVisible(false);
					} else {
						btnSponsorAnwerben4.setVisible(true);
					}
					lblSponsor5.setVisible(false);
					lblSponsor6.setVisible(false);
					lblSponsor7.setVisible(false);
					lblSponsor8.setVisible(false);
					lblSponsor9.setVisible(false);
					lblSponsor10.setVisible(false);
					lblSponsor11.setVisible(false);
					lblSponsor12.setVisible(false);
					lblSponsor13.setVisible(false);
					lblSponsor14.setVisible(false);
					lblSponsor1.setFont(new Font("Tahoma", Font.PLAIN, 28));
					lblSponsor2.setFont(new Font("Tahoma", Font.PLAIN, 28));
					lblSponsor3.setFont(new Font("Tahoma", Font.PLAIN, 28));
					lblSponsor4.setFont(new Font("Tahoma", Font.PLAIN, 28));
					btnSponsorAnwerben5.setVisible(false);
					btnSponsorAnwerben6.setVisible(false);
					btnSponsorAnwerben7.setVisible(false);
					btnSponsorAnwerben8.setVisible(false);
					btnSponsorAnwerben9.setVisible(false);
					btnSponsorAnwerben10.setVisible(false);
					btnSponsorAnwerben11.setVisible(false);
					btnSponsorAnwerben12.setVisible(false);
					btnSponsorAnwerben13.setVisible(false);
					btnSponsorAnwerben14.setVisible(false);
				}

				if (sponsoren.getSponsoren().size() == 14) {
					lblSponsor1.setText(sponsoren.getSponsoren().get(0).toString());

					if (sponsoren.getSponsoren().get(0).isAngeworben()) {
						btnSponsorAnwerben1.setVisible(false);
					} else {
						btnSponsorAnwerben1.setVisible(true);
					}
					lblSponsor2.setText(sponsoren.getSponsoren().get(1).toString());
					if (sponsoren.getSponsoren().get(1).isAngeworben()) {
						btnSponsorAnwerben2.setVisible(false);
					} else {
						btnSponsorAnwerben2.setVisible(true);
					}
					lblSponsor3.setText(sponsoren.getSponsoren().get(2).toString());
					if (sponsoren.getSponsoren().get(2).isAngeworben()) {
						btnSponsorAnwerben3.setVisible(false);
					} else {
						btnSponsorAnwerben3.setVisible(true);
					}
					lblSponsor4.setText(sponsoren.getSponsoren().get(3).toString());
					if (sponsoren.getSponsoren().get(3).isAngeworben()) {
						btnSponsorAnwerben4.setVisible(false);
					} else {
						btnSponsorAnwerben4.setVisible(true);
					}
					lblSponsor5.setText(sponsoren.getSponsoren().get(4).toString());
					if (sponsoren.getSponsoren().get(4).isAngeworben()) {
						btnSponsorAnwerben5.setVisible(false);
					} else {
						btnSponsorAnwerben5.setVisible(true);
					}
					lblSponsor6.setText(sponsoren.getSponsoren().get(5).toString());
					if (sponsoren.getSponsoren().get(5).isAngeworben()) {
						btnSponsorAnwerben6.setVisible(false);
					} else {
						btnSponsorAnwerben6.setVisible(true);
					}
					lblSponsor7.setText(sponsoren.getSponsoren().get(6).toString());
					if (sponsoren.getSponsoren().get(6).isAngeworben()) {
						btnSponsorAnwerben7.setVisible(false);
					} else {
						btnSponsorAnwerben7.setVisible(true);
					}
					lblSponsor8.setText(sponsoren.getSponsoren().get(7).toString());
					if (sponsoren.getSponsoren().get(7).isAngeworben()) {
						btnSponsorAnwerben8.setVisible(false);
					} else {
						btnSponsorAnwerben8.setVisible(true);
					}
					lblSponsor9.setText(sponsoren.getSponsoren().get(8).toString());
					if (sponsoren.getSponsoren().get(8).isAngeworben()) {
						btnSponsorAnwerben9.setVisible(false);
					} else {
						btnSponsorAnwerben9.setVisible(true);
					}
					lblSponsor10.setText(sponsoren.getSponsoren().get(9).toString());
					if (sponsoren.getSponsoren().get(9).isAngeworben()) {
						btnSponsorAnwerben10.setVisible(false);
					} else {
						btnSponsorAnwerben10.setVisible(true);
					}
					lblSponsor11.setText(sponsoren.getSponsoren().get(10).toString());
					if (sponsoren.getSponsoren().get(10).isAngeworben()) {
						btnSponsorAnwerben11.setVisible(false);
					} else {
						btnSponsorAnwerben11.setVisible(true);
					}
					lblSponsor12.setText(sponsoren.getSponsoren().get(11).toString());
					if (sponsoren.getSponsoren().get(11).isAngeworben()) {
						btnSponsorAnwerben12.setVisible(false);
					} else {
						btnSponsorAnwerben12.setVisible(true);
					}
					lblSponsor13.setText(sponsoren.getSponsoren().get(12).toString());
					if (sponsoren.getSponsoren().get(12).isAngeworben()) {
						btnSponsorAnwerben13.setVisible(false);
					} else {
						btnSponsorAnwerben13.setVisible(true);
					}
					lblSponsor14.setText(sponsoren.getSponsoren().get(13).toString());
					if (sponsoren.getSponsoren().get(13).isAngeworben()) {
						btnSponsorAnwerben14.setVisible(false);
					} else {
						btnSponsorAnwerben14.setVisible(true);
					}
				}
				((CardLayout) panelContainer.getLayout()).show(panelContainer, SponsorenPanelName);
			}
		});
		btnSponsorAnwerben1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				spiel.backendSpiel.werbeSponsorAn(sponsoren.getSponsoren().get(0).getID());
				((CardLayout) panelContainer.getLayout()).show(panelContainer, SponsorAnwerbenPanelName);
			}
		});
		btnSponsorAnwerben2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				spiel.backendSpiel.werbeSponsorAn(sponsoren.getSponsoren().get(1).getID());
				((CardLayout) panelContainer.getLayout()).show(panelContainer, SponsorAnwerbenPanelName);
			}
		});
		btnSponsorAnwerben3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				spiel.backendSpiel.werbeSponsorAn(sponsoren.getSponsoren().get(2).getID());
				((CardLayout) panelContainer.getLayout()).show(panelContainer, SponsorAnwerbenPanelName);
			}
		});
		btnSponsorAnwerben4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				spiel.backendSpiel.werbeSponsorAn(sponsoren.getSponsoren().get(3).getID());
				((CardLayout) panelContainer.getLayout()).show(panelContainer, SponsorAnwerbenPanelName);
			}
		});
		btnSponsorAnwerben5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				spiel.backendSpiel.werbeSponsorAn(sponsoren.getSponsoren().get(4).getID());
				((CardLayout) panelContainer.getLayout()).show(panelContainer, SponsorAnwerbenPanelName);
			}
		});
		btnSponsorAnwerben6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				spiel.backendSpiel.werbeSponsorAn(sponsoren.getSponsoren().get(5).getID());
				((CardLayout) panelContainer.getLayout()).show(panelContainer, SponsorAnwerbenPanelName);
			}
		});
		btnSponsorAnwerben7.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				spiel.backendSpiel.werbeSponsorAn(sponsoren.getSponsoren().get(6).getID());
				((CardLayout) panelContainer.getLayout()).show(panelContainer, SponsorAnwerbenPanelName);
			}
		});
		btnSponsorAnwerben8.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				spiel.backendSpiel.werbeSponsorAn(sponsoren.getSponsoren().get(7).getID());
				((CardLayout) panelContainer.getLayout()).show(panelContainer, SponsorAnwerbenPanelName);
			}
		});
		btnSponsorAnwerben9.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				spiel.backendSpiel.werbeSponsorAn(sponsoren.getSponsoren().get(8).getID());
				((CardLayout) panelContainer.getLayout()).show(panelContainer, SponsorAnwerbenPanelName);
			}
		});
		btnSponsorAnwerben10.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				spiel.backendSpiel.werbeSponsorAn(sponsoren.getSponsoren().get(9).getID());
				((CardLayout) panelContainer.getLayout()).show(panelContainer, SponsorAnwerbenPanelName);
			}
		});
		btnSponsorAnwerben11.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				spiel.backendSpiel.werbeSponsorAn(sponsoren.getSponsoren().get(10).getID());
				((CardLayout) panelContainer.getLayout()).show(panelContainer, SponsorAnwerbenPanelName);
			}
		});
		btnSponsorAnwerben12.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				spiel.backendSpiel.werbeSponsorAn(sponsoren.getSponsoren().get(11).getID());
				((CardLayout) panelContainer.getLayout()).show(panelContainer, SponsorAnwerbenPanelName);
			}
		});
		btnSponsorAnwerben13.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				spiel.backendSpiel.werbeSponsorAn(sponsoren.getSponsoren().get(12).getID());
				((CardLayout) panelContainer.getLayout()).show(panelContainer, SponsorAnwerbenPanelName);
			}
		});
		btnSponsorAnwerben14.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				spiel.backendSpiel.werbeSponsorAn(sponsoren.getSponsoren().get(13).getID());
				((CardLayout) panelContainer.getLayout()).show(panelContainer, SponsorAnwerbenPanelName);
			}
		});
	}

	private void addMailActionListeners() {
		btnPosteingang.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String json = spiel.backendSpiel.getMails();
				Posteingang post = gson.fromJson(json, Posteingang.class);
				mails = post.getMailliste();
				mailButtonPanel.removeAll();
				for (int i = 0; mailButtons.length < i || i < mails.size(); i++) {
					mailButtons[i].setVisible(true);
					mailButtons[i].setHorizontalAlignment(SwingConstants.LEFT);

					mailButtons[i].setText(
							"<html>" + mails.get(i).getAbsender() + "<br>" + mails.get(i).getBetreff() + "</html>");
					mailButtonPanel.add(mailButtons[i]);
				}
				for (int i = 0; i < (8 - mails.size()); i++) {
					mailButtonPanel.add(new Label(" "));
				}
				((CardLayout) panelContainer.getLayout()).show(panelContainer, MailPanelName);
			}
		});
		addMailButtonBehavior();

	}

	private void beginneInterview(int id) {
		background = new ImageIcon(this.getClass().getResource("/Bilder/Interview1.png")).getImage();
		String json = spiel.backendSpiel.interview(id);
		Interview interview = gson.fromJson(json, Interview.class);
		if (!"ende".equals(interview.getStatus().toLowerCase())) {
			interviewLauft = true;
			lblPartnerName.setText("<html>" + interview.getPartnerName() + "</html>");
			lblStatus.setText("<html>" + interview.getStatus() + "</html>");
			lblFrage.setText("<html>" + interview.getFrage() + "</html>");
			btnAntwort.setText("<html>" + interview.getAntworten()[0] + "</html>");
			btnAntwort_1.setText("<html>" + interview.getAntworten()[1] + "</html>");
			btnAntwort_2.setText("<html>" + interview.getAntworten()[2] + "</html>");
			btnAntwort_3.setText("<html>" + interview.getAntworten()[3] + "</html>");
			btnBeginneInterview.setVisible(false);
			btnAntwort.setVisible(true);
			btnAntwort_1.setVisible(true);
			btnAntwort_2.setVisible(true);
			btnAntwort_3.setVisible(true);
		} else {
			interviewLauft = false;
			lblPartnerName.setText("");
			lblFrage.setText("Das Interview ist beendet.");
			lblStatus.setText(interview.getStatus());
			btnAntwort.setVisible(false);
			btnAntwort_1.setVisible(false);
			btnAntwort_2.setVisible(false);
			btnAntwort_3.setVisible(false);
		}
		((CardLayout) panelContainer.getLayout()).show(panelContainer, InterviewPanelName);
	}

	private void interviewAntwort(int antwort) {
		String json = spiel.backendSpiel.interview(partnerListe.interviewPartner.get(0).getId(), antwort);
		Interview interview = gson.fromJson(json, Interview.class);
		if (!"ende".equals(interview.getFrage().toLowerCase())) {
			interviewLauft = true;
			lblPartnerName.setText("<html>" + interview.getPartnerName() + "</html>");
			lblStatus.setText("<html>" + interview.getStatus() + "</html>");
			lblFrage.setText("<html>" + interview.getFrage() + "</html>");
			btnAntwort.setText("<html>" + interview.getAntworten()[0] + "</html>");
			btnAntwort_1.setText("<html>" + interview.getAntworten()[1] + "</html>");
			btnAntwort_2.setText("<html>" + interview.getAntworten()[2] + "</html>");
			btnAntwort_3.setText("<html>" + interview.getAntworten()[3] + "</html>");
		} else {
			interviewLauft = false;
			lblPartnerName.setText("");
			lblFrage.setText("Das Interview ist beendet.");
			lblStatus.setText(interview.getStatus());
			btnAntwort.setVisible(false);
			btnAntwort_1.setVisible(false);
			btnAntwort_2.setVisible(false);
			btnAntwort_3.setVisible(false);
		}
		((CardLayout) panelContainer.getLayout()).show(panelContainer, InterviewPanelName);
	}

	private void presseAntwort(int ID) {
		String json = spiel.backendSpiel.haltePressekonferenz(ID);
		Pressekonferenz2 kon = gson.fromJson(json, Pressekonferenz2.class);

		if ("ende".equals(kon.getStatus().toLowerCase())) {
			btnPresseAntwort1.setVisible(false);
			btnPresseAntwort2.setVisible(false);
			btnPresseAntwort3.setVisible(false);
			lblPresseFrage.setText("Die Pressekonferenz ist beendet.");
			lblEinleitung.setText(" ");
			lblThema.setText(" ");
			presseLauft = false;
		} else {
			lblThema.setText(kon.getThema());
			lblEinleitung.setText("<html>" + kon.getEinleitung().replaceAll("\\n", "<br>") + "</html>");
			lblPresseFrage.setText("<html>" + kon.getFrage().replaceAll("\\n", "<br>") + "</html>");
			btnPresseAntwort1
					.setText("<html>" + kon.getAntworten()[0].toString().replaceAll("\\n", "<br>") + "</html>");
			btnPresseAntwort2
					.setText("<html>" + kon.getAntworten()[1].toString().replaceAll("\\n", "<br>") + "</html>");
			btnPresseAntwort3
					.setText("<html>" + kon.getAntworten()[2].toString().replaceAll("\\n", "<br>") + "</html>");
			btnPresseAntwort1.setVisible(true);
			btnPresseAntwort2.setVisible(true);
			btnPresseAntwort3.setVisible(true);

		}
		pressrkonferenzPanel.repaint();
	}

	private void addMailButtonBehavior() {
		btnMail1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Mail temp = mails.get(0);
				textArea.setText(temp.toString());
			}
		});
		btnMail2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Mail temp = mails.get(1);
				textArea.setText(temp.toString());
			}
		});
		btnMail3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Mail temp = mails.get(2);
				textArea.setText(temp.toString());
			}
		});
		btnMail4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Mail temp = mails.get(3);
				textArea.setText(temp.toString());
			}
		});
		btnMail5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Mail temp = mails.get(4);
				textArea.setText(temp.toString());
			}
		});
		btnMail6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Mail temp = mails.get(5);
				textArea.setText(temp.toString());
			}
		});
		btnMail7.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Mail temp = mails.get(6);
				textArea.setText(temp.toString());
			}
		});
		btnMail8.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Mail temp = mails.get(7);
				textArea.setText(temp.toString());
			}
		});
		btnMail9.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Mail temp = mails.get(8);
				textArea.setText(temp.toString());
			}
		});
		btnMail10.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Mail temp = mails.get(9);
				textArea.setText(temp.toString());
			}
		});
		btnMail11.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Mail temp = mails.get(10);
				textArea.setText(temp.toString());
			}
		});
		btnMail12.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Mail temp = mails.get(11);
				textArea.setText(temp.toString());
			}
		});
		btnMail13.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Mail temp = mails.get(12);
				textArea.setText(temp.toString());
			}
		});
		btnMail14.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Mail temp = mails.get(13);
				textArea.setText(temp.toString());
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

	public String getFormattedText2(String textInput) {
		List<String> textTokens = Arrays.asList(textInput.split("/."));
		String text = "";
		StringBuilder stringBuilder = new StringBuilder();
		String delimiter = "";
		for (String sextteil : textTokens) {
			stringBuilder.append(delimiter);
			stringBuilder.append(sextteil);
			delimiter = ".";
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

	public void reset() {
		((CardLayout) panelContainer.getLayout()).show(panelContainer, TextPanelName);
		setBtnInvisibele();
	}
}
