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

@SuppressWarnings("serial")
public class ServerPanel extends JPanel {

	private static final String LOCAL = "http://localhost:8080/";
	private JLabel lblHead;
	private JLabel lblServeradresse;
	private JButton btnLokal;
	private BackendSpielStub backendSpiel;
	private JButton btnServer;
	private JTextField txtAdresse;
	private JButton btnStart;
	private String serveradresse;

	public ServerPanel() {
		super();
		setPreferredSize(new Dimension(2000, 930));

		lblHead = new JLabel("W\u00E4hlen sie auf welchem Server Sie Spielen M\u00F6chten.");
		lblHead.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblServeradresse = new JLabel(" ");
		lblServeradresse.setFont(new Font("Tahoma", Font.PLAIN, 30));

		btnLokal = new JButton("Lokal");
		btnLokal.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnLokal.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				lblServeradresse.setText(" ");
				serveradresse = LOCAL;
				backendSpiel = new BackendSpielStub(serveradresse);
				if (backendSpiel.test().equals("{OK}")) {
					lblServeradresse.setText(LOCAL);
				} else {
					backendSpiel = null;
					UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("Tahoma", Font.PLAIN, 30)));
					JLabel label = new JLabel(
							"Server konnte nicht verbunden werden, bitte überprüfen ob der Server auf Ihren System gestartet ist.");
					label.setFont(new Font("Tahoma", Font.PLAIN, 30));
					JOptionPane.showMessageDialog(null, label, "Fehler", JOptionPane.PLAIN_MESSAGE);
				}

			}
		});

		btnServer = new JButton("Server");
		btnServer.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnServer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				serveradresse = txtAdresse.getText();
				lblServeradresse.setText(" ");
				backendSpiel = new BackendSpielStub(serveradresse);
				if (backendSpiel.test().equals("{OK}")) {
					lblServeradresse.setText(serveradresse);

				} else {
					backendSpiel = null;
					UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("Tahoma", Font.PLAIN, 30)));
					JLabel label = new JLabel(
							"Server konnte nicht verbunden werden, bitte überprüfen Sie die Adresse.");
					label.setFont(new Font("Tahoma", Font.PLAIN, 30));
					JOptionPane.showMessageDialog(null, label, "Fehler", JOptionPane.PLAIN_MESSAGE);
				}
			}
		});

		txtAdresse = new JTextField();
		txtAdresse.setFont(new Font("Tahoma", Font.PLAIN, 30));
		txtAdresse.setColumns(10);

		btnStart = new JButton("Start");
		btnStart.setFont(new Font("Tahoma", Font.PLAIN, 30));

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(88).addGroup(groupLayout
						.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
								.addComponent(txtAdresse, GroupLayout.PREFERRED_SIZE, 235, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(btnServer)
										.addComponent(btnLokal)
										.addComponent(lblServeradresse, GroupLayout.PREFERRED_SIZE, 300,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(btnStart)))
						.addComponent(lblHead)).addContainerGap(61, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addContainerGap().addComponent(lblHead)
				.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnLokal)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(btnServer).addComponent(
						txtAdresse, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(lblServeradresse)
				.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnStart)
				.addContainerGap(211, Short.MAX_VALUE)));
		setLayout(groupLayout);
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
