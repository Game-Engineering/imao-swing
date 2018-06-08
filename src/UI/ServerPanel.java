package UI;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.plaf.FontUIResource;

import Backend.BackendSpielStub;
import java.awt.Dimension;
import net.miginfocom.swing.MigLayout;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class ServerPanel extends JPanel {

	private static final String LOCAL = "localhost:8080";
	private static final String PREFIX = "http://";
	private JLabel lblHead;
	private JLabel lblServeradresse;
	private JButton btnLokal;
	private BackendSpielStub backendSpiel;
	private JButton btnServer;
	private JTextField txtAdresse;
	private JButton btnStart;
	private String serveradresse;
	private JLabel lblFehler;
	private JPanel panel;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;

	public ServerPanel() {
		super();
		setBackground(Color.BLACK);
		setPreferredSize(new Dimension(2000, 930));
		setLayout(new MigLayout("", "[600][800][600]", "[37px][49.00][176.00][35.00px][39.00][37px][]"));

		lblHead = new JLabel("Bitte geben Sie die Adresse des Servers auf dem Sie Spielen m\u00F6chten ein.");
		lblHead.setForeground(Color.WHITE);
		lblHead.setHorizontalAlignment(SwingConstants.CENTER);
		lblHead.setFont(new Font("Tahoma", Font.PLAIN, 30));
		add(lblHead, "cell 0 0 3 1,growx,aligny top");

		panel = new JPanel();
		panel.setBackground(Color.BLACK);
		add(panel, "cell 1 2,growx,aligny top");
		panel.setLayout(new GridLayout(4, 2, 0, 0));

		btnLokal = new JButton("localhost");
		btnLokal.setBackground(Color.DARK_GRAY);
		btnLokal.setBorder(new LineBorder(Color.GRAY, 2, true));
		btnLokal.setForeground(Color.WHITE);
		panel.add(btnLokal);
		btnLokal.setFont(new Font("Tahoma", Font.PLAIN, 30));

		label = new JLabel("");
		label.setForeground(Color.WHITE);
		panel.add(label);

		txtAdresse = new JTextField();
		panel.add(txtAdresse);
		txtAdresse.setFont(new Font("Tahoma", Font.PLAIN, 30));
		txtAdresse.setColumns(10);

		btnServer = new JButton("verbinden");
		btnServer.setForeground(Color.WHITE);
		btnServer.setBorder(new LineBorder(Color.GRAY, 2, true));
		btnServer.setBackground(Color.DARK_GRAY);
		panel.add(btnServer);
		btnServer.setFont(new Font("Tahoma", Font.PLAIN, 30));

		label_1 = new JLabel("");
		label_1.setForeground(Color.WHITE);
		panel.add(label_1);
		lblServeradresse = new JLabel(" ");
		lblServeradresse.setForeground(Color.WHITE);
		panel.add(lblServeradresse);
		lblServeradresse.setFont(new Font("Tahoma", Font.PLAIN, 30));

		label_2 = new JLabel(" ");
		label_2.setForeground(Color.WHITE);
		panel.add(label_2);

		btnStart = new JButton("Start");
		btnStart.setBackground(Color.DARK_GRAY);
		btnStart.setBorder(new LineBorder(Color.GRAY, 2, true));
		btnStart.setForeground(Color.WHITE);
		panel.add(btnStart);
		btnStart.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnServer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				serveradresse = txtAdresse.getText();
				lblServeradresse.setText(" ");
				verbindeServer(serveradresse);
			}
		});
		btnLokal.setVisible(false);
		btnLokal.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// serveradresse = LOCAL;
				// lblServeradresse.setText(" ");
				// verbindeServer(serveradresse);
				txtAdresse.setText(LOCAL);
			}
		});

		lblFehler = new JLabel(" ");
		lblFehler.setHorizontalAlignment(SwingConstants.CENTER);
		lblFehler.setForeground(Color.RED);
		lblFehler.setFont(new Font("Tahoma", Font.PLAIN, 30));
		add(lblFehler, "cell 0 3 3 1,growx");
	}

	private void verbindeServer(String adresse) {
		backendSpiel = new BackendSpielStub(PREFIX + adresse);
		if (backendSpiel.test().equals("{OK}")) {
			lblServeradresse.setText(PREFIX + adresse);
			lblFehler.setText("");

		} else {
			backendSpiel = null;
			lblFehler.setText(
					"Server konnte nicht verbunden werden, bitte überprüfen ob der Server auf Ihren System gestartet ist.");
		}
	}

	public JButton getBtnStart() {
		return btnStart;
	}

	public String getServeradresse() {
		return serveradresse;
	}

	public BackendSpielStub getBackendSpiel() {
		return backendSpiel;
	}

	public JLabel getLblFehler() {
		return lblFehler;
	}

}
