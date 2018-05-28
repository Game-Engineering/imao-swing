package UI;

import java.awt.*;
import java.awt.event.*;
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
	private boolean serverOK = false;
	private static Gson gson = new Gson();
	private JPanel LogPanel;
	private static String logText = "";
	private final static JTextArea lblLog = new JTextArea(logText, 6, 65);
	private JPanel PanelContainer;
	private JMenu mainMenu;
	private JMenuBar menuBar;
	private JMenuItem neuesSpiel;

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
					UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("Tahoma", Font.PLAIN, 30)));
					JLabel label = new JLabel("Starte Spiel auf dem Server: " + serverPanel.getServeradresse() + ". ");
					label.setFont(new Font("Tahoma", Font.PLAIN, 30));
					JOptionPane.showMessageDialog(null, label, "Fehler", JOptionPane.PLAIN_MESSAGE);
					replacePanel(startPanel);
				} else {
					UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("Tahoma", Font.PLAIN, 30)));
					JLabel label = new JLabel("Sie sind mit keinem Server verbuden.");
					label.setFont(new Font("Tahoma", Font.PLAIN, 30));
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
		lblLogHeadLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		LogPanel.add(lblLogHeadLabel, "cell 0 0");

		lblLog.setFont(new Font("Tahoma", Font.PLAIN, 30));
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
		mainMenu.setFont(new Font("Tahoma", Font.PLAIN, 30));
		menuBar.add(mainMenu);

		neuesSpiel = new JMenuItem("neues Spiel");
		neuesSpiel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		mainMenu.add(neuesSpiel);
		neuesSpiel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (spiel.backendSpiel != null) {
					spiel.backendSpiel.neuesSpiel();
					replacePanel(startPanel);
				} else {
					System.out.println("Kein Spiel");
				}

			}
		});
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		erzeugeFelder();

		wirtschaftPanel = new Wirtschaft(spiel);
		startPanel = new StartPanel(spiel);

		startPanel.getBtnStarteSpielArzt().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String antwort = spiel.backendSpiel.startArzt();
				Wilkommen temp = gson.fromJson(antwort, Wilkommen.class);

				if ("Fehler ".equals(temp.ueberschrift)) {
					startPanel.getLblFehlerarzt().setText(temp.text);
				} else {

					spiel.backendSpiel.neueRundeArzt();
					startPanel.resetFields();
					wirtschaftPanel.setText(getFormattedText(temp.text));
					replacePanel(wirtschaftPanel);
				}

			}
		});
		startPanel.getBtnStarteSpielManager().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String antwort = spiel.backendSpiel.startManager();
				Wilkommen temp = gson.fromJson(antwort, Wilkommen.class);

				if ("Fehler ".equals(temp.ueberschrift)) {
					startPanel.getLblFehlermanager().setText(temp.text);

				} else {
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

	public static void addLog(String log) {
		logText += (log + "\n");
		lblLog.setText("" + logText + "");
	}
}
