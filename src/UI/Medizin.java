package UI;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import com.google.gson.Gson;

import Frontend.RundeManager;
import Frontend.Spiel;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class Medizin extends JPanel {
	JTextArea textArea = new JTextArea(" ", 20, 25);
	private static Gson gson = new Gson();
	private static final int FONT_SIZE = 30;

	/**
	 * Create the panel.
	 */
	public Medizin(Spiel spiel) {
		setPreferredSize(new Dimension(2000, 930));
		setLayout(new MigLayout("", "[340][1230][410]", "[][grow][]"));

		JLabel lblMedizin = new JLabel("Medizin");
		lblMedizin.setHorizontalAlignment(SwingConstants.CENTER);
		lblMedizin.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		add(lblMedizin, "cell 0 0 3 1,growx");

		JPanel buttonPanel = new JPanel();
		add(buttonPanel, "cell 0 1,grow");
		buttonPanel.setLayout(new MigLayout("", "[]", "[][][][][]"));

		JButton btnNeueRunde = new JButton("neue Runde");
		btnNeueRunde.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		buttonPanel.add(btnNeueRunde, "cell 0 0");

		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		buttonPanel.add(btnNewButton_1, "cell 0 1");

		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		buttonPanel.add(btnNewButton_2, "cell 0 2");

		JButton btnNewButton_3 = new JButton("New button");
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		buttonPanel.add(btnNewButton_3, "cell 0 3");

		JButton btnNewButton_4 = new JButton("New button");
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		buttonPanel.add(btnNewButton_4, "cell 0 4");

		JPanel panel = new JPanel();
		add(panel, "cell 1 1");

		JScrollPane TextPane = new JScrollPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addContainerGap()
						.addComponent(TextPane, GroupLayout.DEFAULT_SIZE, 1230, Short.MAX_VALUE).addContainerGap()));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addContainerGap()
						.addComponent(TextPane, GroupLayout.DEFAULT_SIZE, 829, Short.MAX_VALUE).addContainerGap()));
		TextPane.setViewportView(textArea);
		textArea.setWrapStyleWord(true);
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		textArea.setFocusable(false);
		textArea.setOpaque(false);
		textArea.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE));
		panel.setLayout(gl_panel);

		JPanel infoPanel = new JPanel();
		add(infoPanel, "cell 2 1,grow");
		btnNeueRunde.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String rundenString = spiel.backendSpiel.neueRundeManager();
				RundeManager runde = gson.fromJson(rundenString, RundeManager.class);

				textArea.setText(" ");
				// lblRundeinfo.setText(runde.toString());

			}
		});
	}

}
