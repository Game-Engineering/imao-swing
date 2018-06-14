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

import javax.swing.JButton;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.Component;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Label;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.BorderLayout;

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
	private Krankheiten krankheiten = null;
	private List<Mail> mails;

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
	private final JButton btnPosteingang = new JButton("Posteingang");
	private final JLabel lblName = new JLabel("Name");
	private final JLabel lblVerringert = new JLabel("verringert");
	private final JLabel lblNormal = new JLabel("normal");
	private final JLabel lblErhht = new JLabel("erh\u00F6ht");
	private final JLabel lblWert = new JLabel("Wert");

	private final JLabel lblHaemoglobin = new JLabel("H\u00E4moglobin");
	private final JLabel lblHaemoglobinGering = new JLabel(" ");
	private final JLabel lblHaemoglobinNorm = new JLabel(" ");
	private final JLabel lblHaemoglobinHoch = new JLabel(" ");
	private final JLabel lblHaemoglobinWert = new JLabel(" ");
	private final JLabel lblLeukozyten = new JLabel("Leukozyten");
	private final JLabel lblLeukozytenGering = new JLabel(" ");
	private final JLabel lblLeukozytenNorm = new JLabel(" ");
	private final JLabel lblLeukozytenHoch = new JLabel(" ");
	private final JLabel lblLeukozytenWert = new JLabel(" ");
	private final JLabel lblThrombozytenn = new JLabel("Thrombozyten");
	private final JLabel lblThrombozytenGering = new JLabel(" ");
	private final JLabel lblThrombozytenNorm = new JLabel(" ");
	private final JLabel lblThrombozytenHoch = new JLabel(" ");
	private final JLabel lblThrombozytenWert = new JLabel(" ");
	private final JLabel lblHaematokrit = new JLabel("H\u00E4matokrit");
	private final JLabel lblHaematokritGering = new JLabel(" ");
	private final JLabel lblHaematokritNorm = new JLabel(" ");
	private final JLabel lblHaematokritHoch = new JLabel(" ");
	private final JLabel lblHaematokritWert = new JLabel(" ");
	private final JLabel lblMCH = new JLabel("MCH");
	private final JLabel lblMCHGering = new JLabel(" ");
	private final JLabel lblMCHNorm = new JLabel(" ");
	private final JLabel lblMCHHoch = new JLabel(" ");
	private final JLabel lblMCHWert = new JLabel(" ");
	private final JLabel lblMCHC = new JLabel("MCHC");
	private final JLabel lblMCHCGering = new JLabel(" ");
	private final JLabel lblMCHCNorm = new JLabel(" ");
	private final JLabel lblMCHCHoch = new JLabel(" ");
	private final JLabel lblMCHCWert = new JLabel(" ");
	private final JLabel lblMCV = new JLabel("MCV");
	private final JLabel lblMCVGering = new JLabel(" ");
	private final JLabel lblMCVNorm = new JLabel(" ");
	private final JLabel lblMCVHoch = new JLabel(" ");
	private final JLabel lblMCVWert = new JLabel(" ");
	private static final Color GERING = new Color(224, 255, 255);
	private static final Color NORMAL = new Color(152, 251, 152);
	private static final Color HOCH = new Color(255, 182, 193);
	private static final String MailPanelName = "MailPanel";
	private final JPanel mailButtonContainer = new JPanel();
	private final JScrollPane scrollPane = new JScrollPane();
	private final JPanel mailButtonPanel = new JPanel();
	private final JPanel mailTextPanel = new JPanel();
	private final JScrollPane scrollPane_1 = new JScrollPane();
	private final JTextArea txtrMailtext = new JTextArea();

	/**
	 * Create the panel.
	 */
	public Medizin(Spiel spiel) {
		setBackground(new Color(255, 239, 213));
		setMaximumSize(new Dimension(2200, 930));
		setMinimumSize(new Dimension(2200, 930));
		this.spiel = spiel;
		setPreferredSize(new Dimension(2000, 930));
		setLayout(new MigLayout("", "[340][1225,grow][568.00]", "[][870][-32.00]"));
		panelContainer.setBackground(new Color(255, 239, 213));
		panelContainer.setLayout(new CardLayout(0, 0));
		lblMedizin.setForeground(Color.WHITE);
		add(lblMedizin, "cell 0 0 3 1,growx");
		add(buttonPanel, "cell 0 1,growy");
		infoPanel.setBackground(new Color(255, 239, 213));
		add(infoPanel, "cell 2 1");
		buttonPanel.setOpaque(false);
		// infoPanel.setOpaque(false);

		setLayout();

		JPanel RundeInfpPane = new JPanel();
		infoPanel.add(RundeInfpPane, "cell 0 5");
		textWartendePatienten.setBackground(new Color(255, 239, 213));

		JScrollPane infoPane = new JScrollPane(textWartendePatienten, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		infoPane.setBackground(new Color(255, 239, 213));
		GroupLayout gl_RundeInfpPane = new GroupLayout(RundeInfpPane);
		gl_RundeInfpPane.setHorizontalGroup(gl_RundeInfpPane.createParallelGroup(Alignment.LEADING)
				.addComponent(infoPane, GroupLayout.DEFAULT_SIZE, 553, Short.MAX_VALUE));
		gl_RundeInfpPane.setVerticalGroup(gl_RundeInfpPane.createParallelGroup(Alignment.TRAILING)
				.addComponent(infoPane, GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE));
		textWartendePatienten.setWrapStyleWord(true);
		textWartendePatienten.setEditable(false);
		textWartendePatienten.setLineWrap(true);
		textWartendePatienten.setFocusable(false);
		textWartendePatienten.setOpaque(true);

		RundeInfpPane.setLayout(gl_RundeInfpPane);

		activPanel = panel;
		panelContainer.setMaximumSize(new Dimension(1080, 770));

		add(panelContainer, "cell 1 1");
		panelContainer.setOpaque(false);
		dialogPanel.setMaximumSize(new Dimension(1225, 830));

		panelContainer.add(dialogPanel, dialog);
		panel.setBackground(new Color(255, 239, 213));
		panelContainer.add(activPanel, infos);
		BlutbildPanel.setBackground(new Color(255, 239, 213));
		panelContainer.add(BlutbildPanel, blutbild);
		panelContainer.add(UltraschallPanel, ultraschall);
		panelContainer.add(diagnosePanel, diagnose);
		panelContainer.add(roentgenPanel, roentgen);
		panelContainer.add(erfolgPanel, erfolg);
		panelContainer.add(keinErfolgPanel, keinErfolg);

		panel.setOpaque(false);
		dialogPanel.setOpaque(false);
		activPanel.setOpaque(false);

		UltraschallPanel.setOpaque(false);
		diagnosePanel.setOpaque(false);
		roentgenPanel.setOpaque(false);
		erfolgPanel.setOpaque(false);
		keinErfolgPanel.setOpaque(false);
		mailPanel.setBackground(new Color(255, 239, 213));
		mailPanel.setOpaque(false);
		mailButtonContainer.setBackground(new Color(255, 239, 213));
		mailButtonContainer.setOpaque(false);
		mailButtonPanel.setBackground(new Color(255, 239, 213));
		mailButtonPanel.setOpaque(false);
		scrollPane.setBackground(new Color(255, 239, 213));
		scrollPane.setOpaque(false);
		scrollPane_1.setOpaque(false);

		JScrollPane TextPane = new JScrollPane();
		TextPane.setBackground(new Color(255, 239, 213));
		textArea.setBackground(new Color(255, 239, 213));
		TextPane.setRowHeaderView(textArea);
		textArea.setWrapStyleWord(true);
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		textArea.setFocusable(false);
		textArea.setOpaque(true);
		TextPane.setOpaque(false);

		panel.add(TextPane, "cell 0 0,grow");
		lblPatientBild.setPreferredSize(new Dimension(250, 250));
		lblPatientBild.setSize(new Dimension(250, 250));
		lblPatientBild.setMinimumSize(new Dimension(250, 250));
		lblPatientBild.setMaximumSize(new Dimension(250, 250));
		lblPatientBild.setVerticalAlignment(SwingConstants.TOP);

		panel.add(lblPatientBild, "cell 1 0,alignx right,aligny top");

		btnAnamnese.setVisible(false);
		btnAnamnese.setForeground(Color.WHITE);
		btnAnamnese.setBorder(new LineBorder(Color.GRAY, 2, true));
		btnAnamnese.setBackground(Color.DARK_GRAY);
		btnBlutbild.setVisible(false);
		btnBlutbild.setForeground(Color.WHITE);
		btnBlutbild.setBorder(new LineBorder(Color.GRAY, 2, true));
		btnBlutbild.setBackground(Color.DARK_GRAY);
		btnRoentgen.setVisible(false);
		btnRoentgen.setForeground(Color.WHITE);
		btnRoentgen.setBorder(new LineBorder(Color.GRAY, 2, true));
		btnRoentgen.setBackground(Color.DARK_GRAY);
		btnUltraschall.setVisible(false);
		btnUltraschall.setForeground(Color.WHITE);
		btnUltraschall.setBorder(new LineBorder(Color.GRAY, 2, true));
		btnUltraschall.setBackground(Color.DARK_GRAY);
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

		for (JButton button : mailButtons) {
			button.setVisible(false);
			button.setForeground(Color.WHITE);
			button.setBorder(new LineBorder(Color.GRAY, 2, true));
			button.setBackground(Color.DARK_GRAY);
		}

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

		panelContainer.add(mailPanel, MailPanelName);

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Image hintergrund = new ImageIcon(this.getClass().getResource("/Bilder/HintergrundMedizin.png")).getImage();
		g.drawImage(hintergrund, 0, 0, null);

	}

	private void setLayout() {
		buttonPanel.setLayout(new MigLayout("", "[]", "[12.00][][][][][][][][][]"));
		infoPanel.setLayout(new MigLayout("", "[386.00]", "[][206.00][36.00][205.00][41.00][252.00]"));

		dialogPanel.setLayout(new MigLayout("", "[1225]", "[24.00][500][][][][][]"));
		panel.setLayout(new MigLayout("", "[630.00][436.00]", "[830]"));
		roentgenPanel.setLayout(new MigLayout("", "[123][1102]", "[][772.00]"));
		diagnosePanel.setLayout(new MigLayout("", "[123][464.00][481.00]", "[][][][][][][][][][][][]"));
		UltraschallPanel.setLayout(new MigLayout("", "[123][1102]", "[47.00][783.00]"));
		keinErfolgPanel.setLayout(new MigLayout("", "[][1225]", "[][830]"));
		erfolgPanel.setLayout(new MigLayout("", "[][1225]", "[][830]"));
		mailPanel.setLayout(new MigLayout("", "[415][grow]", "[][26px,grow]"));
	}

	private void format() {
		btnUntersuchungsmethoden.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnUntersuchungsmethoden.setForeground(Color.WHITE);
		btnUntersuchungsmethoden.setBorder(new LineBorder(Color.GRAY, 2, true));
		btnUntersuchungsmethoden.setBackground(Color.DARK_GRAY);
		btnNeueRunde.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnNeueRunde.setForeground(Color.WHITE);
		btnNeueRunde.setBorder(new LineBorder(Color.GRAY, 2, true));
		btnNeueRunde.setBackground(Color.DARK_GRAY);
		lblMedizin.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblMedizin.setHorizontalAlignment(SwingConstants.CENTER);
		btnAnamnese.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnUltraschall.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnRoentgen.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnBlutbild.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnPatientHereinbitten.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnPatientHereinbitten.setForeground(Color.WHITE);
		btnPatientHereinbitten.setBorder(new LineBorder(Color.GRAY, 2, true));
		btnPatientHereinbitten.setBackground(Color.DARK_GRAY);
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
		btnBZuruek.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnBZuruek.setForeground(Color.WHITE);
		btnBZuruek.setBorder(new LineBorder(Color.GRAY, 2, true));
		btnBZuruek.setBackground(Color.DARK_GRAY);
		lblUltraschall.setForeground(Color.WHITE);

		lblUltraschall.setHorizontalAlignment(SwingConstants.CENTER);
		lblUltraschall.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnUZurueck.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnUZurueck.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnUZurueck.setForeground(Color.WHITE);
		btnUZurueck.setBorder(new LineBorder(Color.GRAY, 2, true));
		btnUZurueck.setBackground(Color.DARK_GRAY);

		btnDiagnose.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnDiagnose.setForeground(Color.WHITE);
		btnDiagnose.setBorder(new LineBorder(Color.GRAY, 2, true));
		btnDiagnose.setBackground(Color.DARK_GRAY);
		lblDiagnose.setForeground(Color.WHITE);
		lblDiagnose.setHorizontalAlignment(SwingConstants.CENTER);
		lblDiagnose.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnDZurueck.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnDZurueck.setForeground(Color.WHITE);
		btnDZurueck.setBorder(new LineBorder(Color.GRAY, 2, true));
		btnDZurueck.setBackground(Color.DARK_GRAY);
		btnDiagnose0.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnDiagnose0.setForeground(Color.WHITE);
		btnDiagnose0.setBorder(new LineBorder(Color.GRAY, 2, true));
		btnDiagnose0.setBackground(Color.DARK_GRAY);
		btnDiagnose1.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnDiagnose1.setForeground(Color.WHITE);
		btnDiagnose1.setBorder(new LineBorder(Color.GRAY, 2, true));
		btnDiagnose1.setBackground(Color.DARK_GRAY);
		btnDiagnose2.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnDiagnose2.setForeground(Color.WHITE);
		btnDiagnose2.setBorder(new LineBorder(Color.GRAY, 2, true));
		btnDiagnose2.setBackground(Color.DARK_GRAY);
		btnDiagnose3.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnDiagnose3.setForeground(Color.WHITE);
		btnDiagnose3.setBorder(new LineBorder(Color.GRAY, 2, true));
		btnDiagnose3.setBackground(Color.DARK_GRAY);
		btnDiagnose4.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnDiagnose4.setForeground(Color.WHITE);
		btnDiagnose4.setBorder(new LineBorder(Color.GRAY, 2, true));
		btnDiagnose4.setBackground(Color.DARK_GRAY);
		btnDiagnose5.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnDiagnose5.setForeground(Color.WHITE);
		btnDiagnose5.setBorder(new LineBorder(Color.GRAY, 2, true));
		btnDiagnose5.setBackground(Color.DARK_GRAY);
		btnDiagnose6.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnDiagnose6.setForeground(Color.WHITE);
		btnDiagnose6.setBorder(new LineBorder(Color.GRAY, 2, true));
		btnDiagnose6.setBackground(Color.DARK_GRAY);
		btnDiagnose7.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnDiagnose7.setForeground(Color.WHITE);
		btnDiagnose7.setBorder(new LineBorder(Color.GRAY, 2, true));
		btnDiagnose7.setBackground(Color.DARK_GRAY);
		btnDiagnose8.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnDiagnose8.setForeground(Color.WHITE);
		btnDiagnose8.setBorder(new LineBorder(Color.GRAY, 2, true));
		btnDiagnose8.setBackground(Color.DARK_GRAY);
		btnDiagnose9.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnDiagnose9.setForeground(Color.WHITE);
		btnDiagnose9.setBorder(new LineBorder(Color.GRAY, 2, true));
		btnDiagnose9.setBackground(Color.DARK_GRAY);
		lblRntgen.setForeground(Color.WHITE);

		lblRntgen.setHorizontalAlignment(SwingConstants.CENTER);
		lblRntgen.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnRZurueck.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnRZurueck.setForeground(Color.WHITE);
		btnRZurueck.setBorder(new LineBorder(Color.GRAY, 2, true));
		btnRZurueck.setBackground(Color.DARK_GRAY);

		btnEZurueck.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnEZurueck.setForeground(Color.WHITE);
		btnEZurueck.setBorder(new LineBorder(Color.GRAY, 2, true));
		btnEZurueck.setBackground(Color.DARK_GRAY);
		btnKZurueck.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnKZurueck.setForeground(Color.WHITE);
		btnKZurueck.setBorder(new LineBorder(Color.GRAY, 2, true));
		btnKZurueck.setBackground(Color.DARK_GRAY);

		btnPosteingang.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnPosteingang.setForeground(Color.WHITE);
		btnPosteingang.setBorder(new LineBorder(Color.GRAY, 2, true));
		btnPosteingang.setBackground(Color.DARK_GRAY);
		lblPosteingang.setForeground(Color.WHITE);
		lblPosteingang.setHorizontalAlignment(SwingConstants.CENTER);
		lblPosteingang.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		for (JButton button : mailButtons) {
			button.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		}
		txtrMailtext.setBackground(new Color(255, 239, 213));
		txtrMailtext.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		txtrMailtext.setWrapStyleWord(true);
		txtrMailtext.setEditable(false);
		txtrMailtext.setLineWrap(true);
		txtrMailtext.setFocusable(false);
		txtrMailtext.setOpaque(true);

		lblName.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		lblVerringert.setHorizontalAlignment(SwingConstants.CENTER);
		lblVerringert.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		lblNormal.setHorizontalAlignment(SwingConstants.CENTER);
		lblNormal.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		lblErhht.setHorizontalAlignment(SwingConstants.CENTER);
		lblErhht.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		lblWert.setHorizontalAlignment(SwingConstants.CENTER);
		lblWert.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		lblHaemoglobin.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblHaemoglobinGering.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblHaemoglobinGering.setBackground(GERING);
		lblHaemoglobinGering.setOpaque(true);
		lblHaemoglobinNorm.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblHaemoglobinNorm.setBackground(NORMAL);
		lblHaemoglobinNorm.setOpaque(true);
		lblHaemoglobinHoch.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblHaemoglobinHoch.setBackground(HOCH);
		lblHaemoglobinHoch.setOpaque(true);
		lblHaemoglobinWert.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblHaemoglobinWert.setOpaque(true);
		lblHaemoglobinGering.setHorizontalAlignment(SwingConstants.CENTER);
		lblHaemoglobinNorm.setHorizontalAlignment(SwingConstants.CENTER);
		lblHaemoglobinHoch.setHorizontalAlignment(SwingConstants.CENTER);
		lblHaemoglobinWert.setHorizontalAlignment(SwingConstants.CENTER);
		lblLeukozyten.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblLeukozytenGering.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblLeukozytenGering.setBackground(GERING);
		lblLeukozytenGering.setOpaque(true);
		lblLeukozytenNorm.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblLeukozytenNorm.setBackground(NORMAL);
		lblLeukozytenNorm.setOpaque(true);
		lblLeukozytenHoch.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblLeukozytenHoch.setBackground(HOCH);
		lblLeukozytenHoch.setOpaque(true);
		lblLeukozytenWert.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblLeukozytenWert.setOpaque(true);
		lblLeukozytenGering.setHorizontalAlignment(SwingConstants.CENTER);
		lblLeukozytenNorm.setHorizontalAlignment(SwingConstants.CENTER);
		lblLeukozytenHoch.setHorizontalAlignment(SwingConstants.CENTER);
		lblLeukozytenWert.setHorizontalAlignment(SwingConstants.CENTER);
		lblThrombozytenn.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblThrombozytenGering.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblThrombozytenGering.setBackground(GERING);
		lblThrombozytenGering.setOpaque(true);
		lblThrombozytenNorm.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblThrombozytenNorm.setBackground(NORMAL);
		lblThrombozytenNorm.setOpaque(true);
		lblThrombozytenHoch.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblThrombozytenHoch.setBackground(HOCH);
		lblThrombozytenHoch.setOpaque(true);
		lblThrombozytenWert.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblThrombozytenWert.setOpaque(true);
		lblThrombozytenGering.setHorizontalAlignment(SwingConstants.CENTER);
		lblThrombozytenNorm.setHorizontalAlignment(SwingConstants.CENTER);
		lblThrombozytenHoch.setHorizontalAlignment(SwingConstants.CENTER);
		lblThrombozytenWert.setHorizontalAlignment(SwingConstants.CENTER);
		lblHaematokrit.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblHaematokritGering.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblHaematokritGering.setBackground(GERING);
		lblHaematokritGering.setOpaque(true);
		lblHaematokritNorm.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblHaematokritNorm.setBackground(NORMAL);
		lblHaematokritNorm.setOpaque(true);
		lblHaematokritHoch.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblHaematokritHoch.setBackground(HOCH);
		lblHaematokritHoch.setOpaque(true);
		lblHaematokritWert.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblHaematokritWert.setOpaque(true);
		lblHaematokritGering.setHorizontalAlignment(SwingConstants.CENTER);
		lblHaematokritNorm.setHorizontalAlignment(SwingConstants.CENTER);
		lblHaematokritHoch.setHorizontalAlignment(SwingConstants.CENTER);
		lblHaematokritWert.setHorizontalAlignment(SwingConstants.CENTER);
		lblMCH.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblMCHGering.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblMCHGering.setBackground(GERING);
		lblMCHGering.setOpaque(true);
		lblMCHNorm.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblMCHNorm.setBackground(NORMAL);
		lblMCHNorm.setOpaque(true);
		lblMCHHoch.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblMCHHoch.setBackground(HOCH);
		lblMCHHoch.setOpaque(true);
		lblMCHWert.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblMCHWert.setOpaque(true);
		lblMCHGering.setHorizontalAlignment(SwingConstants.CENTER);
		lblMCHNorm.setHorizontalAlignment(SwingConstants.CENTER);
		lblMCHHoch.setHorizontalAlignment(SwingConstants.CENTER);
		lblMCHWert.setHorizontalAlignment(SwingConstants.CENTER);
		lblMCHC.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblMCHCGering.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblMCHCGering.setBackground(GERING);
		lblMCHCGering.setOpaque(true);
		lblMCHCNorm.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblMCHCNorm.setBackground(NORMAL);
		lblMCHCNorm.setOpaque(true);
		lblMCHCHoch.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblMCHCHoch.setBackground(HOCH);
		lblMCHCHoch.setOpaque(true);
		lblMCHCWert.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblMCHCWert.setOpaque(true);
		lblMCHCGering.setHorizontalAlignment(SwingConstants.CENTER);
		lblMCHCNorm.setHorizontalAlignment(SwingConstants.CENTER);
		lblMCHCHoch.setHorizontalAlignment(SwingConstants.CENTER);
		lblMCHCWert.setHorizontalAlignment(SwingConstants.CENTER);
		lblMCV.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblMCVGering.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblMCVGering.setBackground(GERING);
		lblMCVGering.setOpaque(true);
		lblMCVNorm.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblMCVNorm.setBackground(NORMAL);
		lblMCVNorm.setOpaque(true);
		lblMCVHoch.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblMCVHoch.setBackground(HOCH);
		lblMCVHoch.setOpaque(true);
		lblMCVWert.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblMCVWert.setOpaque(true);
		lblMCVGering.setHorizontalAlignment(SwingConstants.CENTER);
		lblMCVNorm.setHorizontalAlignment(SwingConstants.CENTER);
		lblMCVHoch.setHorizontalAlignment(SwingConstants.CENTER);
		lblMCVWert.setHorizontalAlignment(SwingConstants.CENTER);
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

		BlutbildPanel.setLayout(new MigLayout("", "[180][170][170][170][369.00px]", "[45px][][23.00px][][][][][][][]"));
		BlutbildPanel.add(btnBZuruek, "cell 0 0,alignx left");
		BlutbildPanel.add(lblBlutbild, "cell 1 0 3 1,alignx center,aligny center");

		BlutbildPanel.add(lblName, "cell 0 2,growx");
		BlutbildPanel.add(lblVerringert, "cell 1 2,growx");
		BlutbildPanel.add(lblNormal, "cell 2 2,growx");
		BlutbildPanel.add(lblErhht, "cell 3 2,growx");
		BlutbildPanel.add(lblWert, "cell 4 2,grow");
		BlutbildPanel.add(lblHaemoglobin, "cell 0 3,growx");
		BlutbildPanel.add(lblHaemoglobinGering, "cell 1 3,grow");
		BlutbildPanel.add(lblHaemoglobinNorm, "cell 2 3,grow");
		BlutbildPanel.add(lblHaemoglobinHoch, "cell 3 3,growx");
		BlutbildPanel.add(lblHaemoglobinWert, "cell 4 3,growx");
		BlutbildPanel.add(lblLeukozyten, "cell 0 4,growx");
		BlutbildPanel.add(lblLeukozytenGering, "cell 1 4,growx");
		BlutbildPanel.add(lblLeukozytenNorm, "cell 2 4,growx");
		BlutbildPanel.add(lblLeukozytenHoch, "cell 3 4,growx");
		BlutbildPanel.add(lblLeukozytenWert, "cell 4 4,growx");
		BlutbildPanel.add(lblThrombozytenn, "cell 0 5,growx");
		BlutbildPanel.add(lblThrombozytenGering, "cell 1 5,growx");
		BlutbildPanel.add(lblThrombozytenNorm, "cell 2 5,growx");
		BlutbildPanel.add(lblThrombozytenHoch, "cell 3 5,growx");
		BlutbildPanel.add(lblThrombozytenWert, "cell 4 5,growx");
		BlutbildPanel.add(lblHaematokrit, "cell 0 6,growx");
		BlutbildPanel.add(lblHaematokritGering, "cell 1 6,growx");
		BlutbildPanel.add(lblHaematokritNorm, "cell 2 6,growx");
		BlutbildPanel.add(lblHaematokritHoch, "cell 3 6,growx");
		BlutbildPanel.add(lblHaematokritWert, "cell 4 6,growx");
		BlutbildPanel.add(lblMCH, "cell 0 7,growx");
		BlutbildPanel.add(lblMCHGering, "cell 1 7,growx");
		BlutbildPanel.add(lblMCHNorm, "cell 2 7,growx");
		BlutbildPanel.add(lblMCHHoch, "cell 3 7,growx");
		BlutbildPanel.add(lblMCHWert, "cell 4 7,growx");
		BlutbildPanel.add(lblMCHC, "cell 0 8,growx");
		BlutbildPanel.add(lblMCHCGering, "cell 1 8,growx");
		BlutbildPanel.add(lblMCHCNorm, "cell 2 8,growx");
		BlutbildPanel.add(lblMCHCHoch, "cell 3 8,growx");
		BlutbildPanel.add(lblMCHCWert, "cell 4 8,growx");
		BlutbildPanel.add(lblMCV, "cell 0 9,growx");
		BlutbildPanel.add(lblMCVGering, "cell 1 9,growx");
		BlutbildPanel.add(lblMCVNorm, "cell 2 9,growx");
		BlutbildPanel.add(lblMCVHoch, "cell 3 9,growx");
		BlutbildPanel.add(lblMCVWert, "cell 4 9,growx");

		roentgenPanel.add(btnRZurueck, "cell 0 0");
		roentgenPanel.add(lblRntgen, "cell 1 0");

		roentgenPanel.add(lblRorntgenbild, "cell 1 1,grow");

		diagnosePanel.add(lblDiagnose, "cell 1 0");
		diagnosePanel.add(btnDZurueck, "cell 0 0,growx");
		diagnosePanel.add(btnDiagnose0, "cell 1 2,growx");
		diagnosePanel.add(btnDiagnose1, "cell 1 3,growx");
		diagnosePanel.add(btnDiagnose2, "cell 1 4,growx");
		diagnosePanel.add(btnDiagnose3, "cell 1 5,growx");
		diagnosePanel.add(btnDiagnose4, "cell 1 6,growx");
		diagnosePanel.add(btnDiagnose5, "cell 1 7,growx");
		diagnosePanel.add(btnDiagnose6, "cell 1 8,growx");
		diagnosePanel.add(btnDiagnose7, "cell 1 9,growx");
		diagnosePanel.add(btnDiagnose8, "cell 1 10,growx");
		diagnosePanel.add(btnDiagnose9, "cell 1 11,growx");

		UltraschallPanel.add(lblUltraschall, "cell 1 0");
		UltraschallPanel.add(btnUZurueck, "cell 0 0");

		UltraschallPanel.add(lblUltraschallbild, "cell 1 1,grow");

		erfolgPanel.add(btnEZurueck, "cell 0 0");
		erfolgPanel.add(lblErfolg, "cell 1 1");

		keinErfolgPanel.add(btnKZurueck, "cell 0 0");
		keinErfolgPanel.add(lblKeinErfolg, "cell 1 1");

		mailPanel.add(lblPosteingang, "cell 0 0 2 1,growx,aligny top");

		mailPanel.add(mailButtonContainer, "cell 0 1,grow");
		mailButtonContainer.setLayout(new GridLayout(1, 0, 0, 0));

		mailButtonContainer.add(scrollPane);

		scrollPane.setViewportView(mailButtonPanel);
		mailButtonPanel.setLayout(new GridLayout(0, 1, 0, 0));
		mailTextPanel.setBackground(new Color(255, 239, 213));

		mailPanel.add(mailTextPanel, "cell 1 1,grow");
		mailTextPanel.setLayout(new BorderLayout(0, 0));
		scrollPane_1.setBackground(new Color(255, 239, 213));

		mailTextPanel.add(scrollPane_1, BorderLayout.CENTER);
		txtrMailtext.setText(" ");

		scrollPane_1.setViewportView(txtrMailtext);

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
				btnDiagnose.setVisible(false);
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

		btnPosteingang.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String json = spiel.backendSpiel.getMailsArzt();
				Posteingang posteingang = gson.fromJson(json, Posteingang.class);
				mails = posteingang.getMailliste();

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
					lblPatientBild.setIcon(null);
					btnDiagnose.setVisible(false);
				}
				buttonPanel.repaint();
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
					lblHaemoglobinGering.setText(blutwerte.getHaemoglobinkonzentrationVeringertBereich());
					lblHaemoglobinNorm.setText(blutwerte.getHaemoglobinkonzentrationNormalBereich());
					lblHaemoglobinHoch.setText(blutwerte.getHaemoglobinkonzentrationErhoetBereich());
					lblHaemoglobinWert.setText("" + blutwerte.getHaemoglobinkonzentration());
					if (blutwerte.inHaemoglobinkonzentrationVerringert()) {
						lblHaemoglobinWert.setBackground(GERING);
					} else if (blutwerte.inHaemoglobinkonzentrationNormal()) {
						lblHaemoglobinWert.setBackground(NORMAL);
					} else if (blutwerte.inHaemoglobinkonzentrationERhoet()) {
						lblHaemoglobinWert.setBackground(HOCH);
					} else {
						lblHaemoglobinWert.setBackground(Color.LIGHT_GRAY);
					}

					lblLeukozytenGering.setText(blutwerte.getLeukozytenVeringertBereich());
					lblLeukozytenNorm.setText(blutwerte.getLeukozytenNormalBereich());
					lblLeukozytenHoch.setText(blutwerte.getLeukozytenErhoetBereich());
					lblLeukozytenWert.setText("" + blutwerte.getLeukozyten());
					if (blutwerte.inLeukozytenVerringert()) {
						lblLeukozytenWert.setBackground(GERING);
					} else if (blutwerte.inLeukozytenNormal()) {
						lblLeukozytenWert.setBackground(NORMAL);
					} else if (blutwerte.inLeukozytenERhoet()) {
						lblLeukozytenWert.setBackground(HOCH);
					} else {
						lblLeukozytenWert.setBackground(Color.LIGHT_GRAY);
					}

					lblThrombozytenGering.setText(blutwerte.getThrombozytenVeringertBereich());
					lblThrombozytenNorm.setText(blutwerte.getThrombozytenNormalBereich());
					lblThrombozytenHoch.setText(blutwerte.getThrombozytenErhoetBereich());
					lblThrombozytenWert.setText("" + blutwerte.getThrombozyten());
					if (blutwerte.inThrombozytenVerringert()) {
						lblThrombozytenWert.setBackground(GERING);
					} else if (blutwerte.inThrombozytenNormal()) {
						lblThrombozytenWert.setBackground(NORMAL);
					} else if (blutwerte.inThrombozytenERhoet()) {
						lblThrombozytenWert.setBackground(HOCH);
					} else {
						lblThrombozytenWert.setBackground(Color.LIGHT_GRAY);
					}

					lblHaematokritGering.setText(blutwerte.getHaemoglobinkonzentrationVeringertBereich());
					lblHaematokritNorm.setText(blutwerte.getHaematokritNormalBereich());
					lblHaematokritHoch.setText(blutwerte.getHaematokritErhoetBereich());
					lblHaematokritWert.setText("" + blutwerte.getHaematokrit());
					if (blutwerte.inHaematokritVerringert()) {
						lblHaematokritWert.setBackground(GERING);
					} else if (blutwerte.inHaematokritNormal()) {
						lblHaematokritWert.setBackground(NORMAL);
					} else if (blutwerte.inHaematokritERhoet()) {
						lblHaematokritWert.setBackground(HOCH);
					} else {
						lblHaematokritWert.setBackground(Color.LIGHT_GRAY);
					}

					lblMCHGering.setText(blutwerte.getMCHVeringertBereich());
					lblMCHNorm.setText(blutwerte.getMCHNormalBereich());
					lblMCHHoch.setText(blutwerte.getMCHErhoetBereich());
					lblMCHWert.setText("" + blutwerte.getMCH());
					if (blutwerte.inMCHVerringert()) {
						lblMCHWert.setBackground(GERING);
					} else if (blutwerte.inMCHNormal()) {
						lblMCHWert.setBackground(NORMAL);
					} else if (blutwerte.inMCHERhoet()) {
						lblMCHWert.setBackground(HOCH);
					} else {
						lblMCHWert.setBackground(Color.LIGHT_GRAY);
					}

					lblMCHCGering.setText(blutwerte.getMCHCVeringertBereich());
					lblMCHCNorm.setText(blutwerte.getMCHCNormalBereich());
					lblMCHCHoch.setText(blutwerte.getMCHCErhoetBereich());
					lblMCHCWert.setText("" + blutwerte.getMCHC());
					if (blutwerte.inMCHCVerringert()) {
						lblMCHCWert.setBackground(GERING);
					} else if (blutwerte.inMCHCNormal()) {
						lblMCHCWert.setBackground(NORMAL);
					} else if (blutwerte.inMCHCERhoet()) {
						lblMCHCWert.setBackground(HOCH);
					} else {
						lblMCHCWert.setBackground(Color.LIGHT_GRAY);
					}

					lblMCVGering.setText(blutwerte.getMCVVeringertBereich());
					lblMCVNorm.setText(blutwerte.getMCVNormalBereich());
					lblMCVHoch.setText(blutwerte.getMCVErhoetBereich());
					lblMCVWert.setText("" + blutwerte.getMCV());
					if (blutwerte.inMCVVerringert()) {
						lblMCVWert.setBackground(GERING);
					} else if (blutwerte.inMCVNormal()) {
						lblMCVWert.setBackground(NORMAL);
					} else if (blutwerte.inMCVERhoet()) {
						lblMCVWert.setBackground(HOCH);
					} else {
						lblMCVWert.setBackground(Color.LIGHT_GRAY);
					}
					BlutbildPanel.repaint();
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
					krankheiten = gson.fromJson(json, Krankheiten.class);

					btnDiagnose4.setVisible(false);
					btnDiagnose5.setVisible(false);
					btnDiagnose6.setVisible(false);
					btnDiagnose7.setVisible(false);
					btnDiagnose8.setVisible(false);
					btnDiagnose9.setVisible(false);

					btnDiagnose0.setText("Masern");
					btnDiagnose1.setText("Hepatitis A");
					btnDiagnose2.setText("Hepatitis B");
					btnDiagnose3.setText("Hautleishmaniose");
					// btnDiagnose4.setText(krankheiten.getKrankheiten()[4].getName());
					// btnDiagnose5.setText(krankheiten.getKrankheiten()[5].getName());
					// btnDiagnose6.setText(krankheiten.getKrankheiten()[6].getName());
					// btnDiagnose7.setText(krankheiten.getKrankheiten()[7].getName());
					// btnDiagnose8.setText(krankheiten.getKrankheiten()[8].getName());
					// btnDiagnose9.setText(krankheiten.getKrankheiten()[9].getName());

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
				setDiagnose(5);
			}
		});
		btnDiagnose2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setDiagnose(6);
			}
		});
		btnDiagnose3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setDiagnose(10);
			}
		});
		btnDiagnose4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setDiagnose(krankheiten.getKrankheiten()[4].getID());
			}
		});
		btnDiagnose5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setDiagnose(krankheiten.getKrankheiten()[5].getID());
			}
		});
		btnDiagnose6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setDiagnose(krankheiten.getKrankheiten()[6].getID());
			}
		});
		btnDiagnose7.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setDiagnose(krankheiten.getKrankheiten()[7].getID());
			}
		});
		btnDiagnose8.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setDiagnose(krankheiten.getKrankheiten()[8].getID());
			}
		});
		btnDiagnose9.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setDiagnose(krankheiten.getKrankheiten()[9].getID());
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

	private void addMailButtonBehavior() {
		btnMail1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Mail temp = mails.get(0);
				txtrMailtext.setText(temp.toString());
			}
		});
		btnMail2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Mail temp = mails.get(1);
				txtrMailtext.setText(temp.toString());
			}
		});
		btnMail3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Mail temp = mails.get(2);
				txtrMailtext.setText(temp.toString());
			}
		});
		btnMail4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Mail temp = mails.get(3);
				txtrMailtext.setText(temp.toString());
			}
		});
		btnMail5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Mail temp = mails.get(4);
				txtrMailtext.setText(temp.toString());
			}
		});
		btnMail6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Mail temp = mails.get(5);
				txtrMailtext.setText(temp.toString());
			}
		});
		btnMail7.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Mail temp = mails.get(6);
				txtrMailtext.setText(temp.toString());
			}
		});
		btnMail8.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Mail temp = mails.get(7);
				txtrMailtext.setText(temp.toString());
			}
		});
		btnMail9.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Mail temp = mails.get(8);
				txtrMailtext.setText(temp.toString());
			}
		});
		btnMail10.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Mail temp = mails.get(9);
				txtrMailtext.setText(temp.toString());
			}
		});
		btnMail11.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Mail temp = mails.get(10);
				txtrMailtext.setText(temp.toString());
			}
		});
		btnMail12.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Mail temp = mails.get(11);
				txtrMailtext.setText(temp.toString());
			}
		});
		btnMail13.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Mail temp = mails.get(12);
				txtrMailtext.setText(temp.toString());
			}
		});
		btnMail14.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Mail temp = mails.get(13);
				txtrMailtext.setText(temp.toString());
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
