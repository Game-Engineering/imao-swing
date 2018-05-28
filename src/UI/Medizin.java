package UI;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import com.google.gson.Gson;

import Frontend.*;
import Frontend.Spiel;

import javax.swing.JButton;
import java.awt.TextArea;

@SuppressWarnings("serial")
public class Medizin extends JPanel {
	private final JTextArea textArea = new JTextArea(" ", 20, 25);
	private final JTextArea textRundeInfo = new JTextArea(" ", 1, 1);
	private final JLabel lblMedizin = new JLabel("Medizin");
	private final JButton btnNeueRunde = new JButton("neue Runde");
	private final JButton btnUnterchungsmethoden = new JButton("Unterchungsmethoden");
	private final JButton btnAnamnese = new JButton("Anamnese");
	private final JButton btnUltraschall = new JButton("Ultraschall");
	private final JButton btnRoentgen = new JButton("R\u00F6ntgen");
	private final JButton btnBlutbild = new JButton("Blutbild");
	private final JButton btnPatientHereinbitten = new JButton("Patient hereinbitten");

	private final Spiel spiel;
	private static Gson gson = new Gson();
	private static final int FONT_SIZE = 30;
	private final JLabel lblRunde = new JLabel("Runde:");

	/**
	 * Create the panel.
	 */
	public Medizin(Spiel spiel) {
		this.spiel = spiel;
		setPreferredSize(new Dimension(2000, 930));
		setLayout(new MigLayout("", "[340][1063.00][568.00]", "[][grow][]"));

		lblMedizin.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblMedizin, "cell 0 0 3 1,growx");

		JPanel buttonPanel = new JPanel();
		add(buttonPanel, "cell 0 1,grow");
		buttonPanel.setLayout(new MigLayout("", "[]", "[][][][][][][]"));

		setFontSize();
		addButtons(buttonPanel);
		addActionListeners();

		JPanel panel = new JPanel();
		add(panel, "cell 1 1");

		JScrollPane TextPane = new JScrollPane(textArea);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addContainerGap()
						.addComponent(TextPane, GroupLayout.DEFAULT_SIZE, 1230, Short.MAX_VALUE).addContainerGap()));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addContainerGap()
						.addComponent(TextPane, GroupLayout.DEFAULT_SIZE, 829, Short.MAX_VALUE).addContainerGap()));
		textArea.setWrapStyleWord(true);
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		textArea.setFocusable(false);
		textArea.setOpaque(false);

		panel.setLayout(gl_panel);

		JPanel infoPanel = new JPanel();
		add(infoPanel, "cell 2 1,grow");
		infoPanel.setLayout(new MigLayout("", "[386.00,grow]", "[][397.00,grow][][][]"));

		infoPanel.add(lblRunde, "cell 0 0,growx");

		JPanel RundeInfpPane = new JPanel();
		infoPanel.add(RundeInfpPane, "cell 0 1,grow");

		JScrollPane infoPane = new JScrollPane(textRundeInfo, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		GroupLayout gl_RundeInfpPane = new GroupLayout(RundeInfpPane);
		gl_RundeInfpPane.setHorizontalGroup(gl_RundeInfpPane.createParallelGroup(Alignment.LEADING)
				.addComponent(infoPane, GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE));
		gl_RundeInfpPane.setVerticalGroup(gl_RundeInfpPane.createParallelGroup(Alignment.LEADING).addComponent(infoPane,
				GroupLayout.DEFAULT_SIZE, 717, Short.MAX_VALUE));
		textRundeInfo.setWrapStyleWord(true);
		textRundeInfo.setEditable(false);
		textRundeInfo.setLineWrap(true);
		textRundeInfo.setFocusable(false);
		textRundeInfo.setOpaque(false);

		RundeInfpPane.setLayout(gl_RundeInfpPane);

	}

	private void setFontSize() {
		btnUnterchungsmethoden.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnNeueRunde.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		lblMedizin.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnAnamnese.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnUltraschall.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnRoentgen.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnBlutbild.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		btnPatientHereinbitten.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		textArea.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		lblRunde.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		textRundeInfo.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
	}

	private void addButtons(JPanel buttonPanel) {
		buttonPanel.add(btnNeueRunde, "cell 0 0");
		buttonPanel.add(btnUnterchungsmethoden, "cell 0 1");
		buttonPanel.add(btnAnamnese, "cell 0 2");
		buttonPanel.add(btnUltraschall, "cell 0 3");
		buttonPanel.add(btnRoentgen, "cell 0 4");
		buttonPanel.add(btnBlutbild, "cell 0 5");
		buttonPanel.add(btnPatientHereinbitten, "cell 0 6");
	}

	private void addActionListeners() {
		btnNeueRunde.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String json = spiel.backendSpiel.neueRundeArzt();
				RundeArzt runde = gson.fromJson(get1(json), RundeArzt.class);
				textArea.setText(" ");
				textRundeInfo.setText(runde.toString());

			}
		});
		btnUnterchungsmethoden.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String json = spiel.backendSpiel.getUntersuchungsmethoden();

			}
		});
	}

	public JTextArea getTextRundeInfo() {
		return textRundeInfo;
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
}
