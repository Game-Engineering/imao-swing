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
import java.awt.GridLayout;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
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
	private JLabel lblFehler;
	private JPanel panel;

	/**
	 * Create the panel.
	 */
	public StartPanel(Spiel spiel1) {
		super();
		setPreferredSize(new Dimension(2000, 930));

		this.spiel = spiel1;

		lblHauptmen = new JLabel("Hauptmen\u00FC");
		lblHauptmen.setFont(new Font("Tahoma", Font.PLAIN, 30));
		setLayout(new MigLayout("", "[600][400][400][600]", "[22.00px][255.00][80.00][35.00]"));
		add(lblHauptmen, "cell 0 0 4 1,alignx center,aligny top");

		panel = new JPanel();
		add(panel, "cell 1 1 2 1,growx,aligny top");
		panel.setLayout(new GridLayout(7, 2, 0, 0));

		JLabel lblVornameArzt = new JLabel("Vorname:");
		panel.add(lblVornameArzt);
		lblVornameArzt.setFont(new Font("Tahoma", Font.PLAIN, 30));

		lblVornameManager = new JLabel("Vorname:");
		panel.add(lblVornameManager);
		lblVornameManager.setFont(new Font("Tahoma", Font.PLAIN, 30));

		txtVornameArzt = new JTextField();
		panel.add(txtVornameArzt);
		txtVornameArzt.setFont(new Font("Tahoma", Font.PLAIN, 30));
		txtVornameArzt.setColumns(10);

		txtVornameManager = new JTextField();
		panel.add(txtVornameManager);
		txtVornameManager.setFont(new Font("Tahoma", Font.PLAIN, 30));
		txtVornameManager.setColumns(10);

		JLabel lblNachnameArzt = new JLabel("Nachname:");
		panel.add(lblNachnameArzt);
		lblNachnameArzt.setFont(new Font("Tahoma", Font.PLAIN, 30));

		lblNachnameManager = new JLabel("Nachname:");
		panel.add(lblNachnameManager);
		lblNachnameManager.setFont(new Font("Tahoma", Font.PLAIN, 30));

		txtNachnameArzt = new JTextField();
		panel.add(txtNachnameArzt);
		txtNachnameArzt.setFont(new Font("Tahoma", Font.PLAIN, 30));
		txtNachnameArzt.setColumns(10);

		txtNachnameManager = new JTextField();
		panel.add(txtNachnameManager);
		txtNachnameManager.setFont(new Font("Tahoma", Font.PLAIN, 30));
		txtNachnameManager.setColumns(10);

		tglbtnGeschlechtArzt = new JToggleButton("männlich");
		panel.add(tglbtnGeschlechtArzt);
		tglbtnGeschlechtArzt.setFont(new Font("Tahoma", Font.PLAIN, 30));

		tglbtnGeschlechtManager = new JToggleButton("m\u00E4nnlich");
		panel.add(tglbtnGeschlechtManager);
		tglbtnGeschlechtManager.setFont(new Font("Tahoma", Font.PLAIN, 30));

		btnErzeugeArzt = new JButton("erzeuge Arzt");
		panel.add(btnErzeugeArzt);
		btnErzeugeArzt.setFont(new Font("Tahoma", Font.PLAIN, 30));

		btnErzeugeManager = new JButton("erzeuge Manager");
		panel.add(btnErzeugeManager);
		btnErzeugeManager.setFont(new Font("Tahoma", Font.PLAIN, 30));

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

		btnStarteSpielArzt = new JButton("starte Spiel Arzt");
		panel.add(btnStarteSpielArzt);
		btnStarteSpielArzt.setFont(new Font("Tahoma", Font.PLAIN, 30));

		btnStarteSpielManager = new JButton("starte Spiel Manager");
		panel.add(btnStarteSpielManager);
		btnStarteSpielManager.setFont(new Font("Tahoma", Font.PLAIN, 30));

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

		lblArztinfo = new JLabel(" ");
		lblArztinfo.setVerticalAlignment(SwingConstants.TOP);
		add(lblArztinfo, "cell 1 2,grow");
		lblArztinfo.setFont(new Font("Tahoma", Font.PLAIN, 30));

		lblManagerinfo = new JLabel(" ");
		lblManagerinfo.setVerticalAlignment(SwingConstants.TOP);
		add(lblManagerinfo, "cell 2 2,grow");
		lblManagerinfo.setFont(new Font("Tahoma", Font.PLAIN, 30));

		lblFehler = new JLabel(" ");
		lblFehler.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblFehler, "cell 0 3 4 1,growx");
		lblFehler.setForeground(Color.RED);
		lblFehler.setFont(new Font("Tahoma", Font.PLAIN, 30));
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
		txtVornameArzt.setText("");
		txtNachnameArzt.setText("");
		lblArztinfo.setText(" ");
		tglbtnGeschlechtArzt.setSelected(false);
		lblFehler.setText(" ");
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

	public JLabel getLblFehler() {
		return lblFehler;
	}

}
