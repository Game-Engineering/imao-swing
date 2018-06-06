package UI;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;

import com.google.gson.Gson;

import Frontend.*;
import net.miginfocom.swing.MigLayout;
import javax.swing.border.LineBorder;

public class SwingFE {

	private JFrame frmImaoTestTool;
	private Spiel spiel;

	private JPanel mainPanel;
	private JPanel activePanel;
	private ServerPanel serverPanel;
	private StartPanel startPanel;
	private Wirtschaft wirtschaftPanel;
	private Medizin medizinPanel;
	private boolean serverOK = false;
	private static Gson gson = new Gson();
	private JPanel LogPanel;
	private static String logText = "";
	private final static JTextArea lblLog = new JTextArea(logText, 6, 65);
	private JPanel PanelContainer;
	private JMenu mainMenu;
	private JMenuBar menuBar;
	private JMenuItem neuesSpiel;
	private static final int FONT_SIZE = 30;
	private JMenu ansichtMenu;
	private JMenuItem mntmMedizin;
	private JMenuItem mntmWirtschaft;
	private boolean medizinGestartet;
	private boolean wirtschaftGestartet;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					SwingFE window = new SwingFE();
					window.frmImaoTestTool.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SwingFE() {
		spiel = new Spiel();

		erzeugeFelder();
		initialize();
		mainPanel.setLayout(new BorderLayout(0, 0));

		PanelContainer = new JPanel();
		PanelContainer.setBackground(Color.PINK);
		mainPanel.add(PanelContainer, BorderLayout.NORTH);
		PanelContainer.setLayout(new BorderLayout(0, 0));
		serverPanel = new ServerPanel();

		PanelContainer.add(serverPanel);

		activePanel = serverPanel;
		serverPanel.getBtnStart().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				spiel.backendSpiel = serverPanel.getBackendSpiel();
				if (spiel.backendSpiel != null) {
					serverOK = true;
				}
				if (serverOK) {
					spiel.backendSpiel.neuesSpiel();
					replacePanel(startPanel);
				} else {
					UIManager.put("OptionPane.buttonFont",
							new FontUIResource(new Font("Tahoma", Font.PLAIN, FONT_SIZE)));
					JLabel label = new JLabel("Sie sind mit keinem Server verbuden.");
					label.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
					JOptionPane.showMessageDialog(null, label, "Fehler", JOptionPane.PLAIN_MESSAGE);
				}
			}
		});

		LogPanel = new JPanel();
		LogPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		LogPanel.setBackground(SystemColor.activeCaption);
		mainPanel.add(LogPanel, BorderLayout.SOUTH);
		LogPanel.setLayout(new MigLayout("", "[1900px,grow]", "[][37px,grow]"));

		JLabel lblLogHeadLabel = new JLabel("Log:");
		lblLogHeadLabel.setHorizontalTextPosition(SwingConstants.LEFT);
		lblLogHeadLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblLogHeadLabel.setVerticalTextPosition(SwingConstants.TOP);
		lblLogHeadLabel.setVerticalAlignment(SwingConstants.TOP);
		lblLogHeadLabel.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		LogPanel.add(lblLogHeadLabel, "cell 0 0");

		lblLog.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		lblLog.setWrapStyleWord(true);
		lblLog.setLineWrap(true);
		lblLog.setEditable(false);
		lblLog.setFocusable(false);
		lblLog.setOpaque(false);

		JScrollPane LogTextPanel = new JScrollPane(lblLog, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		LogTextPanel.setMaximumSize(new Dimension(32767, 300));
		LogTextPanel.setMinimumSize(new Dimension(1900, 300));
		LogPanel.add(LogTextPanel, "cell 0 1,growx");

		menuBar = new JMenuBar();
		frmImaoTestTool.getContentPane().add(menuBar, BorderLayout.NORTH);

		mainMenu = new JMenu("Hauptmenü");
		mainMenu.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		menuBar.add(mainMenu);

		neuesSpiel = new JMenuItem("neues Spiel");
		neuesSpiel.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		mainMenu.add(neuesSpiel);
		neuesSpiel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (spiel.backendSpiel != null) {
					spiel.backendSpiel.neuesSpiel();
					wirtschaftPanel.reset();
					medizinPanel.reset();
					replacePanel(startPanel);
				} else {
					System.out.println("Kein Spiel");
				}

			}
		});

		ansichtMenu = new JMenu("Ansicht");
		menuBar.add(ansichtMenu);

		mntmMedizin = new JMenuItem("Medizin");
		mntmMedizin.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		mntmMedizin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (medizinGestartet) {
					replacePanel(medizinPanel);
				} else {
					String antwort = spiel.backendSpiel.startArzt();
					Wilkommen temp = gson.fromJson(antwort, Wilkommen.class);

					if ("Fehler ".equals(temp.ueberschrift)) {
						startPanel.getLblFehler().setText(temp.text);
					} else {
						medizinGestartet = true;
						String rundenString = spiel.backendSpiel.neueRundeArzt();
						RundeArzt runde = gson.fromJson(get1(rundenString), RundeArzt.class);
						medizinPanel.setWartendePatienten(runde.patienten);
						medizinPanel.setRundeInfo(runde);

						startPanel.resetFields();
						medizinPanel.setText(temp.ueberschrift + "\n" + getFormattedText(temp.text));
						replacePanel(medizinPanel);
					}
				}

			}
		});
		ansichtMenu.add(mntmMedizin);
		ansichtMenu.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));

		mntmWirtschaft = new JMenuItem("Wirtschaft");
		mntmWirtschaft.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		mntmWirtschaft.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (wirtschaftGestartet) {
					replacePanel(wirtschaftPanel);
				} else {
					String antwort = spiel.backendSpiel.startManager();
					Wilkommen temp = gson.fromJson(antwort, Wilkommen.class);

					if ("Fehler ".equals(temp.ueberschrift)) {
						startPanel.getLblFehler().setText(temp.text);

					} else {
						wirtschaftGestartet = true;
						String rundenString = spiel.backendSpiel.neueRundeManager();
						RundeManager runde = gson.fromJson(rundenString, RundeManager.class);

						if (spiel.arzt == null) {
							String json = spiel.backendSpiel.getArztDaten();
							spiel.arzt = gson.fromJson(json, Arzt.class);
						}
						if (spiel.manager == null) {
							String json = spiel.backendSpiel.getManagerDaten();
							spiel.manager = gson.fromJson(json, Manager.class);
						}
						wirtschaftPanel.getLblRunde().setText(runde.toString());
						wirtschaftPanel.getLblArztinfo().setText(
								"<html>" + spiel.arzt.getName() + "<br>" + spiel.arzt.getGeschlecht() + "</html>");
						wirtschaftPanel.getLblManagerinfo().setText("<html>" + spiel.manager.getName() + "<br>"
								+ spiel.manager.getGeschlecht() + "</html>");
						startPanel.resetFields();
						wirtschaftPanel.setText(temp.ueberschrift + "\n" + getFormattedText(temp.text));
						replacePanel(wirtschaftPanel);
					}
				}

			}
		});
		ansichtMenu.add(mntmWirtschaft);
		ansichtMenu.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		erzeugeFelder();

		wirtschaftPanel = new Wirtschaft(spiel);
		medizinPanel = new Medizin(spiel);
		startPanel = new StartPanel(spiel);

		startPanel.getBtnStarteSpielArzt().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String antwort = spiel.backendSpiel.startArzt();
				Wilkommen temp = gson.fromJson(antwort, Wilkommen.class);

				if ("Fehler ".equals(temp.ueberschrift)) {
					startPanel.getLblFehler().setText(temp.text);
				} else {
					medizinGestartet = true;
					String rundenString = spiel.backendSpiel.neueRundeArzt();
					RundeArzt runde = gson.fromJson(get1(rundenString), RundeArzt.class);
					medizinPanel.setWartendePatienten(runde.patienten);
					medizinPanel.setRundeInfo(runde);

					startPanel.resetFields();
					medizinPanel.setText(temp.ueberschrift + "\n" + getFormattedText(temp.text));
					System.out.println(getFormattedText(temp.text));
					replacePanel(medizinPanel);
				}

			}
		});
		startPanel.getBtnStarteSpielManager().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String antwort = spiel.backendSpiel.startManager();
				Wilkommen temp = gson.fromJson(antwort, Wilkommen.class);

				if ("Fehler ".equals(temp.ueberschrift)) {
					startPanel.getLblFehler().setText(temp.text);

				} else {
					wirtschaftGestartet = true;
					String rundenString = spiel.backendSpiel.neueRundeManager();
					RundeManager runde = gson.fromJson(rundenString, RundeManager.class);

					if (spiel.arzt == null) {
						String arztString = spiel.backendSpiel.getArztDaten();
						spiel.arzt = gson.fromJson(arztString, Arzt.class);
					}
					wirtschaftPanel.getLblRunde().setText(runde.toString());
					wirtschaftPanel.getLblArztinfo()
							.setText("<html>" + spiel.arzt.getName() + "<br>" + spiel.arzt.getGeschlecht() + "</html>");
					wirtschaftPanel.getLblManagerinfo().setText(
							"<html>" + spiel.manager.getName() + "<br>" + spiel.manager.getGeschlecht() + "</html>");
					startPanel.resetFields();
					wirtschaftPanel.setText(temp.ueberschrift + "\n" + getFormattedText(temp.text));

					replacePanel(wirtschaftPanel);
				}
			}
		});
	}

	private void erzeugeFelder() {
		frmImaoTestTool = new JFrame();
		frmImaoTestTool
				.setIconImage(Toolkit.getDefaultToolkit().getImage(SwingFE.class.getResource("/Bilder/logo-imao.jpg")));
		frmImaoTestTool.setTitle("IMAO Test Tool");
		frmImaoTestTool.setBounds(0, 0, 2000, 1400);
		frmImaoTestTool.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		mainPanel = new JPanel();
		frmImaoTestTool.getContentPane().add(mainPanel, BorderLayout.CENTER);

	}

	public void replacePanel(JPanel panel) {
		PanelContainer.remove(activePanel);
		activePanel = panel;
		PanelContainer.add(activePanel);
		frmImaoTestTool.invalidate();
		frmImaoTestTool.validate();
		medizinPanel.repaint();
		wirtschaftPanel.repaint();
	}

	public String getFormattedText(String textInput) {
		List<String> textTokens = Arrays.asList(textInput.split("\\. "));
		String text = "";
		StringBuilder stringBuilder = new StringBuilder();
		String delimiter = "";
		for (String sextteil : textTokens) {
			stringBuilder.append(delimiter);
			stringBuilder.append(sextteil);
			delimiter = ".\n";
		}
		text = stringBuilder.toString();
		return text;
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

	public static void addLog(String log) {
		logText += (log + "\n");
		lblLog.setText("" + logText + "");
	}
}
