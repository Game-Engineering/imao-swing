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

@SuppressWarnings("serial")
public class Wirtschaft extends JPanel {
	private JButton btnInterviewpartner;
	private final JLabel lblManagerinfo = new JLabel(" ");
	private final JLabel lblArztinfo = new JLabel(" ");
	private final JLabel lblRundeinfo = new JLabel(" ");
	private JTextArea txtrText = new JTextArea(" ", 20, 25);
	private static Gson gson = new Gson();
	private static final int FONT_SIZE = 30;

	/**
	 * Create the panel.
	 */
	public Wirtschaft(Spiel spiel) {

		setPreferredSize(new Dimension(2000, 930));
		setLayout(new MigLayout("", "[340px][1230.00px][410.00px]", "[53px][749.00px][]"));

		JLabel lblWirtschaft = new JLabel("Wirtschaft");
		lblWirtschaft.setHorizontalAlignment(SwingConstants.CENTER);
		lblWirtschaft.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(lblWirtschaft, "cell 0 0 3 1,growx,aligny top");
		lblWirtschaft.setFont(new Font("Tahoma", Font.PLAIN, 35));

		JPanel buttonPanel = new JPanel();
		add(buttonPanel, "cell 0 1,alignx left,growy");
		buttonPanel.setOpaque(false);

		JPanel TextPanel = new JPanel();
		add(TextPanel, "cell 1 1,growx,aligny center");
		TextPanel.setOpaque(false);

		JPanel InfoPanel = new JPanel();
		add(InfoPanel, "cell 2 1,grow");
		InfoPanel.setOpaque(false);
		buttonPanel.setLayout(new MigLayout("", "[325px]",
				"[45px][45px][45px][45px][45px][45px][45px][45px][45px][45px][45px][45px][45px][45px]"));

		JButton btnNeueRunde = new JButton("neue Runde");
		btnNeueRunde.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		buttonPanel.add(btnNeueRunde, "cell 0 0,alignx left,aligny top");
		InfoPanel.setLayout(new MigLayout("", "[305.00px]", "[37px][234.00px][37px][123.00px][37px][129.00px]"));

		JLabel lblRunde = new JLabel("Runde:");
		lblRunde.setVerticalAlignment(SwingConstants.TOP);
		lblRunde.setHorizontalAlignment(SwingConstants.LEFT);
		lblRunde.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		InfoPanel.add(lblRunde, "cell 0 0,alignx left,aligny top");

		lblRundeinfo.setHorizontalAlignment(SwingConstants.LEFT);
		lblRundeinfo.setVerticalAlignment(SwingConstants.TOP);
		lblRundeinfo.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		InfoPanel.add(lblRundeinfo, "cell 0 1,grow");

		JLabel lblManager = new JLabel("Manager:");
		InfoPanel.add(lblManager, "cell 0 2,alignx left,aligny top");
		lblManager.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));

		InfoPanel.add(lblManagerinfo, "cell 0 3,alignx left,aligny top");
		lblManagerinfo.setHorizontalAlignment(SwingConstants.LEFT);
		lblManagerinfo.setVerticalAlignment(SwingConstants.TOP);
		lblManagerinfo.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));

		JLabel lblArzt = new JLabel("Arzt:");
		InfoPanel.add(lblArzt, "cell 0 4,alignx left,aligny top");
		lblArzt.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));

		InfoPanel.add(lblArztinfo, "cell 0 5,alignx left,aligny top");
		lblArztinfo.setVerticalAlignment(SwingConstants.TOP);
		lblArztinfo.setHorizontalAlignment(SwingConstants.LEFT);
		lblArztinfo.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));

		JScrollPane scrollPane = new JScrollPane();
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

		JButton btnBudgetbreicht = new JButton("Budgetbreicht");
		btnBudgetbreicht.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		buttonPanel.add(btnBudgetbreicht, "cell 0 1,alignx left,aligny top");
		btnBudgetbreicht.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String json = spiel.backendSpiel.getBudgetbreicht();
				txtrText.setText(json);
			}
		});

		JButton btnArztbreicht = new JButton("Arztbreicht");
		btnArztbreicht.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		buttonPanel.add(btnArztbreicht, "cell 0 2,alignx left,aligny top");
		btnArztbreicht.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String json = spiel.backendSpiel.getArztbreicht();
				txtrText.setText(json);
			}
		});

		JButton btnHaltePressekonferenz = new JButton("halte Pressekonferenz");
		btnHaltePressekonferenz.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		buttonPanel.add(btnHaltePressekonferenz, "cell 0 3,alignx left,aligny top");
		btnHaltePressekonferenz.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String presseMitteilung = spiel.backendSpiel.haltePressekonferenz();
				txtrText.setText(presseMitteilung);
			}
		});

		btnInterviewpartner = new JButton("Interviewpartner");
		btnInterviewpartner.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		buttonPanel.add(btnInterviewpartner, "cell 0 4,alignx left,aligny top");
		btnInterviewpartner.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String interviewpartnerString = spiel.backendSpiel.getInterviewPartner();
				Partner partnerListe = new Partner();
				partnerListe = gson.fromJson(interviewpartnerString, Partner.class);
				txtrText.setText(partnerListe.toString());
			}
		});

		JButton btnKaufeRntgen = new JButton("kaufe R\u00F6ntgen");
		btnKaufeRntgen.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		buttonPanel.add(btnKaufeRntgen, "cell 0 6,alignx left,aligny top");
		btnKaufeRntgen.setVisible(false);

		btnKaufeRntgen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String json = spiel.backendSpiel.kaufeGeraet("Roentgen");
				json = "{\"methoden\":" + json + "}";
				Katalog katalog = gson.fromJson(json, Katalog.class);
				txtrText.setText(katalog.toString());
			}
		});

		JButton btnKaufeUltraschall = new JButton("kaufe Ultraschall");
		btnKaufeUltraschall.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		buttonPanel.add(btnKaufeUltraschall, "cell 0 7,alignx left,aligny top");
		btnKaufeUltraschall.setVisible(false);

		btnKaufeUltraschall.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String json = spiel.backendSpiel.kaufeGeraet("Ultraschall");
				json = "{\"methoden\":" + json + "}";
				Katalog katalog = gson.fromJson(json, Katalog.class);
				txtrText.setText(katalog.toString());
			}
		});

		JButton btnffneKatalog = new JButton("\u00F6ffne Katalog");
		btnffneKatalog.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		buttonPanel.add(btnffneKatalog, "cell 0 5,alignx left,aligny top");

		btnffneKatalog.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String katalogString = spiel.backendSpiel.getManagerKatalog();
				katalogString = "{\"methoden\":" + katalogString + "}";
				Katalog katalog = gson.fromJson(katalogString, Katalog.class);
				btnKaufeUltraschall.setVisible(true);
				btnKaufeRntgen.setVisible(true);
				txtrText.setText(katalog.toString());
			}
		});

		JButton btnPosteingang = new JButton("Posteingang");
		btnPosteingang.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		buttonPanel.add(btnPosteingang, "cell 0 8,alignx left,aligny top");
		btnPosteingang.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String json = spiel.backendSpiel.getMails();
				Posteingang post = gson.fromJson(json, Posteingang.class);
				System.out.println(post.toString());
				txtrText.setText(post.toString());
			}
		});

		JButton btnLob = new JButton("Lob");
		btnLob.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		buttonPanel.add(btnLob, "cell 0 10,alignx left,aligny top");
		btnLob.setVisible(false);

		btnLob.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String mailString = spiel.backendSpiel.sendeMail(Mails.LOB.name());
				Mail mail = gson.fromJson(mailString, Mail.class);
				UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("Tahoma", Font.PLAIN, FONT_SIZE)));
				txtrText.setText(mail.toString());
			}
		});

		JButton btnAbmahnung = new JButton("Abmahnung");
		btnAbmahnung.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		buttonPanel.add(btnAbmahnung, "cell 0 11,alignx left,aligny top");
		btnAbmahnung.setVisible(false);
		btnAbmahnung.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String mailString = spiel.backendSpiel.sendeMail(Mails.ABMAHNUNG.name());
				Mail mail = gson.fromJson(mailString, Mail.class);
				UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("Tahoma", Font.PLAIN, FONT_SIZE)));
				txtrText.setText(mail.toString());
			}
		});

		JButton btnGert = new JButton("Ger\u00E4t");
		btnGert.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		buttonPanel.add(btnGert, "cell 0 12,alignx left,aligny top");
		btnGert.setVisible(false);
		btnGert.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String mailString = spiel.backendSpiel.sendeMail(Mails.GERAET_GEKAUFT.name());
				Mail mail = gson.fromJson(mailString, Mail.class);
				UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("Tahoma", Font.PLAIN, FONT_SIZE)));
				txtrText.setText(mail.toString());
			}
		});

		JButton btnDefault = new JButton("Default");
		btnDefault.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		buttonPanel.add(btnDefault, "cell 0 13,alignx left,aligny top");
		btnDefault.setVisible(false);

		btnDefault.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String mailString = spiel.backendSpiel.sendeMail(Mails.DEFAULT_MAIL.name());
				Mail mail = gson.fromJson(mailString, Mail.class);
				UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("Tahoma", Font.PLAIN, FONT_SIZE)));
				txtrText.setText(mail.toString());
			}
		});

		JButton btnMglicheMails = new JButton("M\u00F6gliche Mails");
		btnMglicheMails.setFont(new Font("Tahoma", Font.PLAIN, 30));
		buttonPanel.add(btnMglicheMails, "cell 0 9,alignx left,aligny top");

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
