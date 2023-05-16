import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Continue extends JFrame {
	
	private JLabel question;
	private JButton button_1, button_2;
	private JPanel endPanel, questionPanel, buttonsPanel, mainPanel;
	
	public Continue(Warrior player, Warrior bot, boolean win, int initialHealth) {

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		question = new JLabel("Do you want to keep fighting?");
		questionPanel = new JPanel();
		questionPanel.add(question);
		
		button_1 = new JButton("Yes");
		button_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_2 = new JButton("No");
		button_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		buttonsPanel = new JPanel();
		buttonsPanel.add(button_1);
		buttonsPanel.add(button_2);
		
		mainPanel = new JPanel();
		mainPanel.add(questionPanel, BorderLayout.CENTER);
		mainPanel.add(buttonsPanel, BorderLayout.CENTER);
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		this.add(mainPanel);
		
		this.setTitle("Continue");
		this.setSize(250, 150);
		this.setResizable(false);
		this.setLocation(550,350);
		this.setVisible(true);
	}
}
