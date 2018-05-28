package UI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Arrays;
import java.util.List;
import javax.swing.JButton;
import javax.swing.plaf.FontUIResource;

import com.google.gson.Gson;

import Frontend.*;

import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.UIManager;
import net.miginfocom.swing.MigLayout;
import java.awt.Color;
import java.awt.Dimension;

public class StartPanel extends JPanel {

	private Spiel spiel;
	private JLabel lblHauptmen;
	private JButton btnErzeugeArzt;
	private JButton btnErzeugeManager;
	private JButton btnStarteSpielArzt;
	private JButton btnStarteSpielManager;
	private JTextField txtVornameArzt;
	private JTextField txtNachnameArzt;
	private JLabel lblVornameManager;
	private JTextField txtVornameManager;
	private JLabel lblNachnameManager;
	private JTextField txtNachnameManager;
	private JToggleButton tglbtnGeschlechtManager;
	private JToggleButton tglbtnGeschlechtArzt;
	private static Gson gson = new Gson();
	private JLabel lblArztinfo;
	private JLabel lblManagerinfo;
	private JLabel lblFehlermanager;
	private JLabel lblFehlerarzt;

	/**
	 * Create the panel.
	 */
	public StartPanel(Spiel spiel1) {
		super();
		setPreferredSize(new Dimension(2000, 930));

		this.spiel = spiel1;

		lblHauptmen = new JLabel("Hauptmen\u00FC");
		lblHauptmen.setFont(new Font("Tahoma", Font.PLAIN, 30));

		btnErzeugeArzt = new JButton("erzeuge Arzt");
		btnErzeugeArzt.setFont(new Font("Tahoma", Font.PLAIN, 30));

		btnErzeugeManager = new JButton("erzeuge Manager");
		btnErzeugeManager.setFont(new Font("Tahoma", Font.PLAIN, 30));

		btnStarteSpielArzt = new JButton("starte Spiel Arzt");
		btnStarteSpielArzt.setFont(new Font("Tahoma", Font.PLAIN, 30));

		btnStarteSpielManager = new JButton("starte Spiel Manager");
		btnStarteSpielManager.setFont(new Font("Tahoma", Font.PLAIN, 30));

		txtVornameArzt = new JTextField();
		txtVornameArzt.setFont(new Font("Tahoma", Font.PLAIN, 30));
		txtVornameArzt.setColumns(10);

		txtNachnameArzt = new JTextField();
		txtNachnameArzt.setFont(new Font("Tahoma", Font.PLAIN, 30));
		txtNachnameArzt.setColumns(10);

		tglbtnGeschlechtArzt = new JToggleButton("männlich");
		tglbtnGeschlechtArzt.setFont(new Font("Tahoma", Font.PLAIN, 30));
		tglbtnGeschlechtArzt.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent ev) {
				if (ev.getStateChange() == ItemEvent.SELECTED) {
					tglbtnGeschlechtArzt.setText("weiblich");
				} else if (ev.getStateChange() == ItemEvent.DESELECTED) {
					tglbtnGeschlechtArzt.setText("männlich");
				}
			}
		});

		JLabel lblVornameArzt = new JLabel("Vorname:");
		lblVornameArzt.setFont(new Font("Tahoma", Font.PLAIN, 30));

		JLabel lblNachnameArzt = new JLabel("Nachname:");
		lblNachnameArzt.setFont(new Font("Tahoma", Font.PLAIN, 30));

		lblVornameManager = new JLabel("Vorname:");
		lblVornameManager.setFont(new Font("Tahoma", Font.PLAIN, 30));

		txtVornameManager = new JTextField();
		txtVornameManager.setFont(new Font("Tahoma", Font.PLAIN, 30));
		txtVornameManager.setColumns(10);

		lblNachnameManager = new JLabel("Nachname:");
		lblNachnameManager.setFont(new Font("Tahoma", Font.PLAIN, 30));

		txtNachnameManager = new JTextField();
		txtNachnameManager.setFont(new Font("Tahoma", Font.PLAIN, 30));
		txtNachnameManager.setColumns(10);

		tglbtnGeschlechtManager = new JToggleButton("m\u00E4nnlich");
		tglbtnGeschlechtManager.setFont(new Font("Tahoma", Font.PLAIN, 30));
		tglbtnGeschlechtManager.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent ev) {
				if (ev.getStateChange() == ItemEvent.SELECTED) {
					tglbtnGeschlechtManager.setText("weiblich");
				} else if (ev.getStateChange() == ItemEvent.DESELECTED) {
					tglbtnGeschlechtManager.setText("männlich");
				}
			}
		});

		lblArztinfo = new JLabel(" ");
		lblArztinfo.setFont(new Font("Tahoma", Font.PLAIN, 30));

		lblManagerinfo = new JLabel(" ");
		lblManagerinfo.setFont(new Font("Tahoma", Font.PLAIN, 30));
		setLayout(new MigLayout("", "[680][320px][320px][680]",
				"[37px][][37px][43px][37px][43px][54.00px][54.00px][45px][131px][]"));
		add(lblNachnameArzt, "cell 1 4,alignx left,aligny top");
		add(tglbtnGeschlechtArzt, "cell 1 6,alignx left,aligny top");
		add(btnErzeugeArzt, "cell 1 7,alignx left,aligny top");
		add(txtVornameArzt, "cell 1 3,alignx left,aligny top");
		add(lblVornameArzt, "cell 1 2,alignx left,aligny top");
		add(btnStarteSpielArzt, "cell 1 8,alignx left,aligny top");
		add(lblArztinfo, "cell 1 9,grow");
		add(txtNachnameArzt, "cell 1 5,alignx left,aligny top");
		add(lblHauptmen, "cell 0 0 4 1,alignx center,aligny top");
		add(lblManagerinfo, "cell 2 9,grow");
		add(txtVornameManager, "cell 2 3,alignx left,aligny top");
		add(lblVornameManager, "cell 2 2,alignx left,aligny top");
		add(lblNachnameManager, "cell 2 4,alignx left,aligny top");
		add(txtNachnameManager, "cell 2 5,alignx left,aligny top");
		add(tglbtnGeschlechtManager, "cell 2 6,alignx left,aligny top");
		add(btnErzeugeManager, "cell 2 7,alignx left,aligny top");
		add(btnStarteSpielManager, "cell 2 8,alignx left,aligny top");

		lblFehlerarzt = new JLabel(" ");
		lblFehlerarzt.setForeground(Color.RED);
		lblFehlerarzt.setFont(new Font("Tahoma", Font.PLAIN, 30));
		add(lblFehlerarzt, "cell 1 10");

		lblFehlermanager = new JLabel(" ");
		lblFehlermanager.setForeground(Color.RED);
		lblFehlermanager.setFont(new Font("Tahoma", Font.PLAIN, 30));
		add(lblFehlermanager, "cell 2 10");

		btnErzeugeArzt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String geschlecht = "";
				if (tglbtnGeschlechtArzt.isSelected()) {
					geschlecht = "weiblich";
				} else {
					geschlecht = "maennlich";
				}

				String arztString = spiel.backendSpiel.erzeugeArzt(txtVornameArzt.getText(), txtNachnameArzt.getText(),
						geschlecht);

				Arzt temp = gson.fromJson(arztString, Arzt.class);
				spiel.arzt = temp;
				if (spiel.arzt != null) {
					lblArztinfo
							.setText("<html>" + spiel.arzt.getName() + "<br>" + spiel.arzt.getGeschlecht() + "</html>");
				} else {
					UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("Tahoma", Font.PLAIN, 30)));
					JLabel label = new JLabel("Bitte Tragen Sie einen Vornamen und einen Nachnamen ein.");
					label.setFont(new Font("Tahoma", Font.PLAIN, 30));
					JOptionPane.showMessageDialog(null, label, "Fehler", JOptionPane.PLAIN_MESSAGE);
				}
			}
		});

		btnErzeugeManager.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String geschlecht = "";
				if (tglbtnGeschlechtManager.isSelected()) {
					geschlecht = "weiblich";
				} else {
					geschlecht = "maennlich";
				}
				String managerString = spiel.backendSpiel.erzeugeManager(txtVornameManager.getText(),
						txtNachnameManager.getText(), geschlecht);
				Manager temp = gson.fromJson(managerString, Manager.class);
				spiel.manager = temp;
				if (spiel.manager != null) {
					lblManagerinfo.setText(
							"<html>" + spiel.manager.getName() + "<br>" + spiel.manager.getGeschlecht() + "</html>");
				} else {
					UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("Tahoma", Font.PLAIN, 30)));
					JLabel label = new JLabel("Bitte Tragen Sie einen Vornamen und einen Nachnamen ein.");
					label.setFont(new Font("Tahoma", Font.PLAIN, 30));
					JOptionPane.showMessageDialog(null, label, "Fehler", JOptionPane.PLAIN_MESSAGE);
				}

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

	public void resetFields() {
		lblFehlerarzt.setText(" ");
		txtVornameArzt.setText("");
		txtNachnameArzt.setText("");
		lblArztinfo.setText(" ");
		tglbtnGeschlechtArzt.setSelected(false);
		lblFehlermanager.setText(" ");
		txtVornameManager.setText("");
		txtNachnameManager.setText("");
		lblManagerinfo.setText(" ");
		tglbtnGeschlechtManager.setSelected(false);
	}

	public JButton getBtnStarteSpielArzt() {
		return btnStarteSpielArzt;
	}

	public JButton getBtnStarteSpielManager() {
		return btnStarteSpielManager;
	}

	public JLabel getLblFehlermanager() {
		return lblFehlermanager;
	}

	public JLabel getLblFehlerarzt() {
		return lblFehlerarzt;
	}

}
