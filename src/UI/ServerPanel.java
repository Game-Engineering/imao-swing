package UI;

import java.awt.Font;
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

@SuppressWarnings("serial")
public class ServerPanel extends JPanel {

	private static final String LOCAL = "localhost:8080/";
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

	public ServerPanel() {
		super();
		setPreferredSize(new Dimension(2000, 930));

		lblHead = new JLabel("Bitte geben Sie die Adresse des Servers auf dem Sie Spielen m\u00F6chten ein.");
		lblHead.setHorizontalAlignment(SwingConstants.CENTER);
		lblHead.setFont(new Font("Tahoma", Font.PLAIN, 30));

		txtAdresse = new JTextField();
		txtAdresse.setFont(new Font("Tahoma", Font.PLAIN, 30));
		txtAdresse.setColumns(10);
		setLayout(new MigLayout("", "[][650][350][10][240][750]", "[37px][49.00][45px][45px][39.00][37px][]"));

		btnLokal = new JButton("Lokal");
		btnLokal.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnLokal.setVisible(false);
		btnLokal.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				serveradresse = LOCAL;
				lblServeradresse.setText(" ");
				verbindeServer(serveradresse);

			}
		});
		add(btnLokal, "cell 4 2,alignx left,aligny top");
		add(txtAdresse, "cell 2 3,growx,aligny center");

		btnServer = new JButton("verbinden");
		btnServer.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnServer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				serveradresse = txtAdresse.getText();
				lblServeradresse.setText(" ");
				verbindeServer(serveradresse);
			}
		});
		add(btnServer, "cell 4 3,alignx left,aligny top");
		lblServeradresse = new JLabel(" ");
		lblServeradresse.setFont(new Font("Tahoma", Font.PLAIN, 30));
		add(lblServeradresse, "cell 4 4 2 1,growx,aligny top");

		btnStart = new JButton("Start");
		btnStart.setFont(new Font("Tahoma", Font.PLAIN, 30));
		add(btnStart, "cell 4 5,alignx left,aligny top");
		add(lblHead, "cell 0 0 6 1,growx,aligny top");

		lblFehler = new JLabel(" ");
		lblFehler.setHorizontalAlignment(SwingConstants.CENTER);
		lblFehler.setForeground(Color.RED);
		lblFehler.setFont(new Font("Tahoma", Font.PLAIN, 30));
		add(lblFehler, "cell 1 6 5 1,growx");
	}

	private void verbindeServer(String adresse) {
		backendSpiel = new BackendSpielStub(PREFIX + adresse);
		if (backendSpiel.test().equals("{OK}")) {
			lblServeradresse.setText(PREFIX + adresse);

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

}
