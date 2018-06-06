package UI;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;

import com.google.gson.Gson;

import Frontend.*;
import Frontend.Spiel;

import javax.swing.JButton;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.Component;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

@SuppressWarnings("serial")
public class Medizin extends JPanel {
	private WartendePatienten wartendePatienten;
	private PatientInZelt inZelt;
	private final JTextArea textArea = new JTextArea(" ", 20, 25);
	private final JTextArea textWartendePatienten = new JTextArea(" ", 1, 1);
	private final JLabel lblMedizin = new JLabel("Medizin");
	private final JButton btnNeueRunde = new JButton("Neue Runde");
	private final JButton btnUntersuchungsmethoden = new JButton("Untersuchungsmethoden");
	private final JButton btnAnamnese = new JButton("Anamnese");
	private final JButton btnUltraschall = new JButton("Ultraschall");
	private final JButton btnRoentgen = new JButton("R\u00F6ntgen");
	private final JButton btnBlutbild = new JButton("Blutbild");
	private final JButton btnPatientHereinbitten = new JButton("N\u00E4chster Patient");

	private Image background = null;

	private final JPanel infoPanel = new JPanel();
	private final JPanel panel = new JPanel();
	private final JPanel dialogPanel = new JPanel() {
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			if (background != null) {
				g.drawImage(background, 0, 0, null);
			}
		}
	};
	private final JPanel panelContainer = new JPanel();
	private final JPanel buttonPanel = new JPanel();
	private JPanel activPanel;

	private final Spiel spiel;
	private static Gson gson = new Gson();
	private static final int FONT_SIZE = 30;
	private static final String dialog = "Dialog";
	private static final String infos = "Infos";
	private static final String blutbild = "Blutbild";
	private static final String ultraschall = "Ultraschall";
	private static final String roentgen = "Roentgen";
	private static final String diagnose = "Diagnose";
	private static final String erfolg = "Erfolg";
	private static final String keinErfolg = "Kein Erfolg";
	private boolean anamneseLauft = false;
	private final JLabel lblRunde = new JLabel("Runde:");
	private final JLabel lblAntwort = new JLabel("Antwort");
	private final JButton btnFrage0 = new JButton("Frage1");
	private final JButton btnFrage1 = new JButton("Frage2");
	private final JButton btnFrage2 = new JButton("Frage3");
	private final JButton btnFrage3 = new JButton("Frage4");

	private final JLabel lblRundeinfo = new JLabel(" ");
	private final JLabel lblPatientInZelt = new JLabel("Patient im Zelt:");
	private final JLabel lblPatientinfo = new JLabel(" ");
	private final JLabel lblWartendepatienten = new JLabel("WartendePatienten:");
	private final JPanel BlutbildPanel = new JPanel();
	private final JPanel UltraschallPanel = new JPanel();
	private final JButton btnBZuruek = new JButton("Zur\u00FCck");
	private final JLabel lblBlutbild = new JLabel("Blutbild");
	private final JLabel lblBlutwerte = new JLabel(" ");
	private final JLabel lblPatientBild = new JLabel(" ");
	private final JButton btnDiagnose = new JButton("Diagnose");
	private final JPanel diagnosePanel = new JPanel();
	private final JPanel roentgenPanel = new JPanel();
	private final JButton btnUZurueck = new JButton("Zur\u00FCck");
	private final JLabel lblUltraschall = new JLabel("Ultraschall");
	private final JButton btnDZurueck = new JButton("Zur\u00FCck");
	private final JLabel lblDiagnose = new JLabel("Diagnose");
	private final JButton btnRZurueck = new JButton("Zur\u00FCck");
	private final JLabel lblRntgen = new JLabel("R\u00F6ntgen");

	private final JButton btnDiagnose0 = new JButton(" ");
	private final JButton btnDiagnose1 = new JButton(" ");
	private final JButton btnDiagnose2 = new JButton(" ");
	private final JButton btnDiagnose3 = new JButton(" ");
	private final JButton btnDiagnose4 = new JButton(" ");
	private final JButton btnDiagnose5 = new JButton(" ");
	private final JButton btnDiagnose6 = new JButton(" ");
	private final JButton btnDiagnose7 = new JButton(" ");
	private final JButton btnDiagnose8 = new JButton(" ");
	private final JButton btnDiagnose9 = new JButton(" ");
	private final JPanel erfolgPanel = new JPanel();
	private final JPanel keinErfolgPanel = new JPanel();
	private final JButton btnEZurueck = new JButton("Zur\u00FCck");
	private final JLabel lblErfolg = new JLabel(" ");
	private final JButton btnKZurueck = new JButton("Zur\u00FCck");
	private final JLabel lblKeinErfolg = new JLabel(" ");
	private final JLabel lblUltraschallbild = new JLabel(" ");
	private final JLabel lblRorntgenbild = new JLabel(" ");
	private final JLabel lblAnamnese = new JLabel("Anamnese");
	private final JPanel mailPanel = new JPanel();
	private final JLabel lblPosteingang = new JLabel("Posteingang");
	private final JButton btnNewButton = new JButton("New button");
	private final JButton btnNewButton_1 = new JButton("New button");
	private final JButton btnNewButton_2 = new JButton("New button");
	private final JButton btnNewButton_3 = new JButton("New button");
	private final JButton btnNewButton_4 = new JButton("New button");
	private final JButton btnNewButton_5 = new JButton("New button");
	private final JButton btnNewButton_6 = new JButton("New button");
	private final JButton btnNewButton_7 = new JButton("New button");
	private final JButton btnNewButton_8 = new JButton("New button");
	private final JButton btnNewButton_9 = new JButton("New button");
	private final JButton btnNewButton_10 = new JButton("New button");
	private final JButton btnNewButton_11 = new JButton("New button");
	private final JButton btnNewButton_12 = new JButton("New button");
	private final JButton btnNewButton_13 = new JButton("New button");
	private final JLabel lblMailInhalt = new JLabel("MailInhalt");
	private final JButton btnPosteingang = new JButton("Posteingang");

	/**
	 * Create the panel.
	 */
	public Medizin(Spiel spiel) {
		setMaximumSize(new Dimension(2200, 870));
		this.spiel = spiel;
		setPreferredSize(new Dimension(2000, 930));
		setLayout(new MigLayout("", "[340][1225][568.00]", "[][]"));
		panelContainer.setLayout(new CardLayout(0, 0));
		add(lblMedizin, "cell 0 0 3 1,growx");
		add(buttonPanel, "cell 0 1,growy");
		add(infoPanel, "cell 2 1");

		setLayout();

		JPanel RundeInfpPane = new JPanel();
		infoPanel.add(RundeInfpPane, "cell 0 5");

		JScrollPane infoPane = new JScrollPane(textWartendePatienten, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		GroupLayout gl_RundeInfpPane = new GroupLayout(RundeInfpPane);
		gl_RundeInfpPane.setHorizontalGroup(gl_RundeInfpPane.createParallelGroup(Alignment.LEADING)
				.addComponent(infoPane, GroupLayout.DEFAULT_SIZE, 553, Short.MAX_VALUE));
		gl_RundeInfpPane.setVerticalGroup(gl_RundeInfpPane.createParallelGroup(Alignment.TRAILING)
				.addComponent(infoPane, GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE));
		textWartendePatienten.setWrapStyleWord(true);
		textWartendePatienten.setEditable(false);
		textWartendePatienten.setLineWrap(true);
		textWartendePatienten.setFocusable(false);
		textWartendePatienten.setOpaque(false);

		RundeInfpPane.setLayout(gl_RundeInfpPane);

		activPanel = panel;
		panelContainer.setMaximumSize(new Dimension(1080, 770));

		add(panelContainer, "cell 1 1");
		dialogPanel.setMaximumSize(new Dimension(1225, 830));

		panelContainer.add(dialogPanel, dialog);
		panelContainer.add(activPanel, infos);
		panelContainer.add(BlutbildPanel, blutbild);
		panelContainer.add(UltraschallPanel, ultraschall);
		panelContainer.add(diagnosePanel, diagnose);
		panelContainer.add(roentgenPanel, roentgen);
		panelContainer.add(erfolgPanel, erfolg);
		panelContainer.add(keinErfolgPanel, keinErfolg);

		JScrollPane TextPane = new JScrollPane();
		TextPane.setRowHeaderView(textArea);
		textArea.setWrapStyleWord(true);
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		textArea.setFocusable(false);
		textArea.setOpaque(false);

		panel.add(TextPane, "cell 0 0,grow");
		lblPatientBild.setPreferredSize(new Dimension(250, 250));
		lblPatientBild.setSize(new Dimension(250, 250));
		lblPatientBild.setMinimumSize(new Dimension(250, 250));
		lblPatientBild.setMaximumSize(new Dimension(250, 250));
		lblPatientBild.setVerticalAlignment(SwingConstants.TOP);

		panel.add(lblPatientBild, "cell 1 0,alignx left,aligny top");

		btnAnamnese.setVisible(false);
		btnBlutbild.setVisible(false);
		btnRoentgen.setVisible(false);
		btnUltraschall.setVisible(false);
		btnFrage0.setForeground(Color.WHITE);
		btnFrage0.setBackground(Color.DARK_GRAY);

		btnFrage0.setVisible(false);
		btnFrage1.setForeground(Color.WHITE);
		btnFrage1.setBackground(Color.DARK_GRAY);
		btnFrage1.setVisible(false);
		btnFrage2.setBackground(Color.DARK_GRAY);
		btnFrage2.setForeground(Color.WHITE);
		btnFrage2.setVisible(false);
		btnFrage3.setBackground(Color.DARK_GRAY);
		btnFrage3.setForeground(Color.WHITE);
		btnFrage3.setVisible(false);

		btnDiagnose.setVisible(false);

		format();
		addFields();
		addActionListeners();
		lblErfolg.setMaximumSize(new Dimension(1080, 770));
		lblErfolg.setIcon(new ImageIcon((new ImageIcon(this.getClass().getResource("/Bilder/Erfolg.png")).getImage())
				.getScaledInstance(1080, 730, Image.SCALE_SMOOTH)));

		lblKeinErfolg
				.setIcon(new ImageIcon((new ImageIcon(this.getClass().getResource("/Bilder/keinErfolg.png")).getImage())
						.getScaledInstance(1080, 770, Image.SCALE_SMOOTH)));
		((CardLayout) panelContainer.getLayout()).show(panelContainer, "Infos");

		panelContainer.add(mailPanel, "name_435578306997333");

	}

	private void setLayout() {
		buttonPanel.setLayout(new MigLayout("", "[]", "[12.00][][][][][][][][][]"));
		infoPanel.setLayout(new MigLayout("", "[386.00]", "[][206.00][36.00][205.00][41.00][252.00]"));

		dialogPanel.setLayout(new MigLayout("", "[1225]", "[24.00][500][][][][][]"));
		panel.setLayout(new MigLayout("", "[960][265]", "[830]"));
		roentgenPanel.setLayout(new MigLayout("", "[123][1102]", "[][772.00]"));
		diagnosePanel.setLayout(new MigLayout("", "[123][1102]", "[][][][][][][][][][][][]"));
		UltraschallPanel.setLayout(new MigLayout("", "[123][1102]", "[47.00][783.00]"));
		keinErfolgPanel.setLayout(new MigLayout("", "[][1225]", "[][830]"));
		erfolgPanel.setLayout(new MigLayout("", "[][1225]", "[][830]"));
		mailPanel.setLayout(new MigLayout("", "[114px][874.00]", "[][26px][][][][][][][][][][][][][][][]"));
	}

	private void format() {
		btnUntersuchungsmethoden.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnNeueRunde.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		lblMedizin.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		lblMedizin.setHorizontalAlignment(SwingConstants.CENTER);
		btnAnamnese.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnUltraschall.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnRoentgen.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnBlutbild.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnPatientHereinbitten.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		textArea.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		lblRunde.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		textWartendePatienten.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		lblAntwort.setForeground(Color.WHITE);
		lblAntwort.setBackground(Color.GRAY);
		lblAntwort.setOpaque(true);

		lblAntwort.setHorizontalAlignment(SwingConstants.CENTER);
		lblAntwort.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnFrage0.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnFrage1.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnFrage2.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnFrage3.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));

		lblRunde.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		lblRundeinfo.setVerticalTextPosition(SwingConstants.TOP);
		lblRundeinfo.setHorizontalAlignment(SwingConstants.LEFT);
		lblRundeinfo.setVerticalAlignment(SwingConstants.TOP);
		lblRundeinfo.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		lblPatientInZelt.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		lblPatientinfo.setVerticalAlignment(SwingConstants.TOP);
		lblPatientinfo.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		lblWartendepatienten.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));

		lblBlutbild.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		lblBlutwerte.setVerticalAlignment(SwingConstants.TOP);
		lblBlutwerte.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnBZuruek.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));

		lblUltraschall.setHorizontalAlignment(SwingConstants.CENTER);
		lblUltraschall.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnUZurueck.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));

		btnDiagnose.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		lblDiagnose.setHorizontalAlignment(SwingConstants.CENTER);
		lblDiagnose.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnDZurueck.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnDiagnose0.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnDiagnose1.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnDiagnose2.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnDiagnose3.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnDiagnose4.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnDiagnose5.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnDiagnose6.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnDiagnose7.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnDiagnose8.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnDiagnose9.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));

		lblRntgen.setHorizontalAlignment(SwingConstants.CENTER);
		lblRntgen.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnRZurueck.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));

		btnEZurueck.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnKZurueck.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));

		btnPosteingang.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		lblPosteingang.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		lblMailInhalt.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnNewButton_5.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnNewButton_6.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnNewButton_7.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnNewButton_8.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnNewButton_9.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnNewButton_10.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnNewButton_11.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnNewButton_12.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnNewButton_13.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
	}

	private void addFields() {
		buttonPanel.add(btnNeueRunde, "cell 0 1,growx");

		buttonPanel.add(btnPosteingang, "cell 0 2,growx");
		buttonPanel.add(btnPatientHereinbitten, "cell 0 3,growx");

		buttonPanel.add(btnDiagnose, "cell 0 4,growx");
		buttonPanel.add(btnUntersuchungsmethoden, "cell 0 5,growx");
		buttonPanel.add(btnAnamnese, "cell 0 6,growx");
		buttonPanel.add(btnUltraschall, "cell 0 7,growx");
		buttonPanel.add(btnRoentgen, "cell 0 8,growx");
		buttonPanel.add(btnBlutbild, "cell 0 9,growx");
		lblAnamnese.setForeground(Color.LIGHT_GRAY);
		lblAnamnese.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnamnese.setFont(new Font("Tahoma", Font.PLAIN, 30));

		dialogPanel.add(lblAnamnese, "cell 0 0,growx");

		dialogPanel.add(lblAntwort, "cell 0 2,growx");
		dialogPanel.add(btnFrage0, "cell 0 3,growx");
		dialogPanel.add(btnFrage1, "cell 0 4,growx");
		dialogPanel.add(btnFrage2, "cell 0 5,growx");
		dialogPanel.add(btnFrage3, "cell 0 6,growx");

		infoPanel.add(lblRunde, "cell 0 0");
		infoPanel.add(lblRundeinfo, "cell 0 1");
		infoPanel.add(lblPatientInZelt, "cell 0 2");
		infoPanel.add(lblPatientinfo, "cell 0 3");
		infoPanel.add(lblWartendepatienten, "cell 0 4");

		BlutbildPanel.setLayout(new MigLayout("", "[123px][924.00px]", "[45px][782.00px]"));
		BlutbildPanel.add(btnBZuruek, "cell 0 0,alignx center,aligny center");
		BlutbildPanel.add(lblBlutbild, "cell 1 0,alignx center,aligny center");
		BlutbildPanel.add(lblBlutwerte, "cell 1 1,growy");

		roentgenPanel.add(btnRZurueck, "cell 0 0");
		roentgenPanel.add(lblRntgen, "cell 1 0");

		roentgenPanel.add(lblRorntgenbild, "cell 1 1,grow");

		diagnosePanel.add(lblDiagnose, "cell 1 0");
		diagnosePanel.add(btnDZurueck, "cell 0 0");
		diagnosePanel.add(btnDiagnose0, "cell 1 2");
		diagnosePanel.add(btnDiagnose1, "cell 1 3");
		diagnosePanel.add(btnDiagnose2, "cell 1 4");
		diagnosePanel.add(btnDiagnose3, "cell 1 5");
		diagnosePanel.add(btnDiagnose4, "cell 1 6");
		diagnosePanel.add(btnDiagnose5, "cell 1 7");
		diagnosePanel.add(btnDiagnose6, "cell 1 8");
		diagnosePanel.add(btnDiagnose7, "cell 1 9");
		diagnosePanel.add(btnDiagnose8, "cell 1 10");
		diagnosePanel.add(btnDiagnose9, "cell 1 11");

		UltraschallPanel.add(lblUltraschall, "cell 1 0");
		UltraschallPanel.add(btnUZurueck, "cell 0 0");

		UltraschallPanel.add(lblUltraschallbild, "cell 1 1,grow");

		erfolgPanel.add(btnEZurueck, "cell 0 0");
		erfolgPanel.add(lblErfolg, "cell 1 1");

		keinErfolgPanel.add(btnKZurueck, "cell 0 0");
		keinErfolgPanel.add(lblKeinErfolg, "cell 1 1");

		mailPanel.add(lblPosteingang, "cell 0 1 2 1,growx,aligny top");

		mailPanel.add(btnNewButton, "cell 0 2");
		lblMailInhalt.setVerticalAlignment(SwingConstants.TOP);

		mailPanel.add(lblMailInhalt, "cell 1 2 1 14,grow");
		mailPanel.add(btnNewButton_1, "cell 0 3");
		mailPanel.add(btnNewButton_2, "cell 0 4");
		mailPanel.add(btnNewButton_3, "cell 0 5");
		mailPanel.add(btnNewButton_4, "cell 0 6");
		mailPanel.add(btnNewButton_5, "cell 0 7");
		mailPanel.add(btnNewButton_6, "cell 0 8");
		mailPanel.add(btnNewButton_7, "cell 0 9");
		mailPanel.add(btnNewButton_8, "cell 0 10");
		mailPanel.add(btnNewButton_9, "cell 0 11");
		mailPanel.add(btnNewButton_10, "cell 0 12");
		mailPanel.add(btnNewButton_11, "cell 0 13");
		mailPanel.add(btnNewButton_12, "cell 0 14");
		mailPanel.add(btnNewButton_13, "cell 0 15");
	}

	private void addActionListeners() {
		btnNeueRunde.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String json = spiel.backendSpiel.neueRundeArzt();
				RundeArzt runde = gson.fromJson(get1(json), RundeArzt.class);
				wartendePatienten = new WartendePatienten(runde.patienten);

				textArea.setText(" ");
				inZelt = null;
				lblPatientBild.setIcon(null);
				btnAnamnese.setVisible(false);
				btnBlutbild.setVisible(false);
				btnRoentgen.setVisible(false);
				btnUltraschall.setVisible(false);
				btnFrage0.setVisible(false);
				btnFrage1.setVisible(false);
				btnFrage2.setVisible(false);
				btnFrage3.setVisible(false);
				setRundeInfo(runde);
				((CardLayout) panelContainer.getLayout()).show(panelContainer, infos);
			}
		});

		btnPatientHereinbitten.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!wartendePatienten.getPatienten().isEmpty()) {
					String json = spiel.backendSpiel.getPatatient();
					inZelt = gson.fromJson(json, PatientInZelt.class);
					wartendePatienten.getPatienten().remove(0);
					lblPatientinfo.setText(inZelt.toString());
					textWartendePatienten.setText(wartendePatienten.toString());
					background = new ImageIcon(
							this.getClass().getResource("/Bilder/Patient" + inZelt.getErscheinungID() + ".png"))
									.getImage();
					Image profilbild = new ImageIcon(
							this.getClass().getResource("/Bilder/PatientProfil" + inZelt.getErscheinungID() + ".png"))
									.getImage();
					lblPatientBild.setIcon(new ImageIcon(profilbild.getScaledInstance(lblPatientBild.getWidth(),
							lblPatientBild.getHeight(), Image.SCALE_SMOOTH)));
					btnDiagnose.setVisible(true);
					textArea.setText(inZelt.toPlainString());
				} else {
					inZelt = null;
					lblPatientinfo.setText("Es Gibt Keine Patienten mehr.");
					lblPatientBild.removeAll();
					btnDiagnose.setVisible(false);
				}
				((CardLayout) panelContainer.getLayout()).show(panelContainer, infos);
			}
		});
		btnUntersuchungsmethoden.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String json = spiel.backendSpiel.getUntersuchungsmethoden();
				Untersuchungsmethoden methoden = gson.fromJson("{\"methoden\":" + json + "}",
						Untersuchungsmethoden.class);
				for (Untersuchungsmethode meth : methoden.methoden) {
					switch (meth.getName()) {
					case "Anamnese":
						if (meth.isFreigeschaltet()) {
							btnAnamnese.setVisible(true);
						}
						break;
					case "Roentgen":
						if (meth.isFreigeschaltet()) {
							btnRoentgen.setVisible(true);
						}
						break;
					case "Blutbild":
						if (meth.isFreigeschaltet()) {
							btnBlutbild.setVisible(true);
						}
						break;
					case "Ultraschall":
						if (meth.isFreigeschaltet()) {
							btnUltraschall.setVisible(true);
						}
						break;
					default:
						break;
					}
				}
				textArea.setText(methoden.toString());
				((CardLayout) panelContainer.getLayout()).show(panelContainer, infos);
			}
		});
		btnAnamnese.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (anamneseLauft) {
					((CardLayout) panelContainer.getLayout()).show(panelContainer, dialog);
				} else {
					anamneseLauft = true;
					if (inZelt != null) {
						String json = spiel.backendSpiel.beginneAnamnese(inZelt.getID());
						Anamnese anamnese = gson.fromJson(json, Anamnese.class);
						lblAntwort.setText(anamnese.getAntwort());
						btnFrage0.setText(anamnese.getFragen()[0]);
						btnFrage0.setVisible(true);
						btnFrage1.setText(anamnese.getFragen()[1]);
						btnFrage1.setVisible(true);
						btnFrage2.setText(anamnese.getFragen()[2]);
						btnFrage2.setVisible(true);
						((CardLayout) panelContainer.getLayout()).show(panelContainer, dialog);
					}
				}
			}
		});
		btnFrage0.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frage(0);
			}
		});
		btnFrage1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frage(1);
			}
		});
		btnFrage2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frage(2);
			}
		});
		btnFrage3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frage(3);
			}
		});
		btnBlutbild.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (inZelt != null) {
					String json = spiel.backendSpiel.getBlutbild(inZelt.getID());
					Blutbild blutwerte = gson.fromJson(json, Blutbild.class);
					lblBlutwerte.setText(blutwerte.toString());
					((CardLayout) panelContainer.getLayout()).show(panelContainer, blutbild);
				}
			}
		});
		btnBZuruek.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				zuruek();
			}
		});
		btnUltraschall.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (inZelt != null) {
					String json = spiel.backendSpiel.getUltraschall(inZelt.getID());
					Ultraschall ultraschallBild = gson.fromJson(json, Ultraschall.class);
					Image bild = new ImageIcon(this.getClass()
							.getResource("/Bilder/Ultraschall" + ultraschallBild.getUltraschallID() + ".png"))
									.getImage();
					lblUltraschallbild.setIcon(new ImageIcon(bild.getScaledInstance(lblUltraschallbild.getWidth(),
							lblUltraschallbild.getHeight(), Image.SCALE_SMOOTH)));
					((CardLayout) panelContainer.getLayout()).show(panelContainer, ultraschall);
				}
			}
		});
		btnUZurueck.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				zuruek();
			}
		});
		btnRoentgen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (inZelt != null) {
					String json = spiel.backendSpiel.getRoentgen(inZelt.getID());
					Roentgen roentgenBild = gson.fromJson(json, Roentgen.class);
					Image bild = new ImageIcon(
							this.getClass().getResource("/Bilder/Roentgen" + roentgenBild.getRoentgenID() + ".png"))
									.getImage();
					lblRorntgenbild.setIcon(new ImageIcon(bild.getScaledInstance(lblRorntgenbild.getWidth(),
							lblRorntgenbild.getHeight(), Image.SCALE_SMOOTH)));
					((CardLayout) panelContainer.getLayout()).show(panelContainer, roentgen);
				}
			}
		});
		btnRZurueck.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				zuruek();
			}
		});
		btnDiagnose.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (inZelt != null) {
					String json = spiel.backendSpiel.getAlleKrankheiten();
					Krankheiten krankheiten = gson.fromJson(json, Krankheiten.class);

					btnDiagnose0.setText("MASERN");
					btnDiagnose1.setText("CHOLERA");
					btnDiagnose2.setText("BILHARZIOSE");
					btnDiagnose3.setText("HIV");
					btnDiagnose4.setText("HEP_A");
					btnDiagnose5.setText("HEP_B");
					btnDiagnose6.setText("TETANUS");
					btnDiagnose7.setText("GELBFIEBER");
					btnDiagnose8.setText("DENGUE_FIEBER");
					btnDiagnose9.setText("HAUTLEISHMANIASIS");

					((CardLayout) panelContainer.getLayout()).show(panelContainer, diagnose);
				}
			}
		});
		btnDiagnose0.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setDiagnose(1);
			}
		});
		btnDiagnose1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setDiagnose(2);
			}
		});
		btnDiagnose2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setDiagnose(3);
			}
		});
		btnDiagnose3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setDiagnose(4);
			}
		});
		btnDiagnose4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setDiagnose(5);
			}
		});
		btnDiagnose5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setDiagnose(6);
			}
		});
		btnDiagnose6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setDiagnose(7);
			}
		});
		btnDiagnose7.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setDiagnose(8);
			}
		});
		btnDiagnose8.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setDiagnose(9);
			}
		});
		btnDiagnose9.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setDiagnose(10);
			}
		});
		btnDZurueck.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (anamneseLauft) {
					((CardLayout) panelContainer.getLayout()).show(panelContainer, dialog);
				} else {
					((CardLayout) panelContainer.getLayout()).show(panelContainer, infos);
				}
			}
		});
		btnEZurueck.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				((CardLayout) panelContainer.getLayout()).show(panelContainer, infos);
			}
		});
		btnKZurueck.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				((CardLayout) panelContainer.getLayout()).show(panelContainer, infos);
			}
		});

	}

	private void zuruek() {
		if (anamneseLauft) {
			((CardLayout) panelContainer.getLayout()).show(panelContainer, dialog);
		} else {
			((CardLayout) panelContainer.getLayout()).show(panelContainer, infos);
		}
	}

	private void frage(int frage) {
		String json = spiel.backendSpiel.frageAnamnese(inZelt.getID(), frage);
		Anamnese anamnese = gson.fromJson(json, Anamnese.class);
		lblAntwort.setText(anamnese.getAntwort());
		setFragen(anamnese);
		((CardLayout) panelContainer.getLayout()).show(panelContainer, dialog);
	}

	private void setDiagnose(int diagnose) {
		anamneseLauft = false;
		String json = spiel.backendSpiel.diagnose(inZelt.getID(), diagnose);
		DiagnoseErgebniss ergrbniss = gson.fromJson(json, DiagnoseErgebniss.class);
		if ("erfolgreich".equals(ergrbniss.getNachricht().toLowerCase())) {
			((CardLayout) panelContainer.getLayout()).show(panelContainer, erfolg);
			lblPatientInZelt.setText("Der Patient hat das Zelt verlassen.");
		} else {
			((CardLayout) panelContainer.getLayout()).show(panelContainer, keinErfolg);
			lblPatientInZelt.setText("Der Patient ist gestorben.");
		}
		inZelt = null;
		lblPatientBild.setIcon(null);
		textArea.setText(" ");
		btnDiagnose.setVisible(false);
	}

	public JTextArea getTextRundeInfo() {
		return textWartendePatienten;
	}

	public void setText(String text) {
		textArea.setText(text);
	}

	public String get1(String textInput) {
		String textInput2 = get2(textInput);
		List<String> textTokens = Arrays.asList(textInput2.split("patienten\":\""));
		String text = "";
		StringBuilder stringBuilder = new StringBuilder();
		String delimiter = "";
		for (String sextteil : textTokens) {
			stringBuilder.append(delimiter);
			stringBuilder.append(sextteil);
			delimiter = "patienten\":";
		}
		text = stringBuilder.toString();
		return text;
	}

	public String get2(String textInput) {
		List<String> textTokens = Arrays.asList(textInput.split("]\""));
		String text = "";
		StringBuilder stringBuilder = new StringBuilder();
		String delimiter = "";
		for (String sextteil : textTokens) {
			stringBuilder.append(delimiter);
			stringBuilder.append(sextteil);
			delimiter = "]";
		}
		text = stringBuilder.toString();
		return text;
	}

	public String getKrank(String textInput) {
		textInput = getKrank2(textInput);
		List<String> textTokens = Arrays.asList(textInput.split("{"));
		String text = "";
		StringBuilder stringBuilder = new StringBuilder();
		String delimiter = "";
		for (String sextteil : textTokens) {
			stringBuilder.append(delimiter);
			stringBuilder.append(sextteil);
			delimiter = "[{";
		}
		text = stringBuilder.toString();
		return text;
	}

	public String getKrank2(String textInput) {
		textInput = getKrank3(textInput);
		List<String> textTokens = Arrays.asList(textInput.split("}"));
		String text = "";
		StringBuilder stringBuilder = new StringBuilder();
		String delimiter = "";
		for (String sextteil : textTokens) {
			stringBuilder.append(delimiter);
			stringBuilder.append(sextteil);
			delimiter = "}]";
		}
		text = stringBuilder.toString();
		return text;
	}

	public String getKrank3(String textInput) {
		List<String> textTokens = Arrays.asList(textInput.split(","));
		String text = "";
		StringBuilder stringBuilder = new StringBuilder();
		String delimiter = "";
		for (String sextteil : textTokens) {
			stringBuilder.append(delimiter);
			stringBuilder.append(sextteil);
			delimiter = "},{";
		}
		text = stringBuilder.toString();
		return text;
	}

	public void setWartendePatienten(Patient[] patienten) {
		this.wartendePatienten = new WartendePatienten(patienten);
	}

	public void setRundeInfo(RundeArzt runde) {
		lblRundeinfo.setText(runde.toString());
		lblPatientinfo.setText("Es ist kein Patient im Zelt.");
		textWartendePatienten.setText(wartendePatienten.toString());
	}

	private void setFragen(Anamnese anamnese) {
		if (anamnese.getFragen().length >= 1) {
			btnFrage0.setText(anamnese.getFragen()[0]);
			btnFrage0.setVisible(true);
		} else {
			btnFrage0.setVisible(false);
		}
		if (anamnese.getFragen().length >= 2) {
			btnFrage1.setText(anamnese.getFragen()[1]);
			btnFrage1.setVisible(true);
		} else {
			btnFrage1.setVisible(false);
		}
		if (anamnese.getFragen().length >= 3) {
			btnFrage2.setText(anamnese.getFragen()[2]);
			btnFrage2.setVisible(true);
		} else {
			btnFrage2.setVisible(false);
		}
	}

	public void reset() {
		((CardLayout) panelContainer.getLayout()).show(panelContainer, infos);
		btnDiagnose.setVisible(false);
		btnAnamnese.setVisible(false);
		btnBlutbild.setVisible(false);
		btnUltraschall.setVisible(false);
		btnRoentgen.setVisible(false);
		lblPatientBild.setIcon(null);
	}
}
