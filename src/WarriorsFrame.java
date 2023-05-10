import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class WarriorsFrame extends JFrame {
	public static void main(String[] args) throws SQLException {
		new WarriorsFrame();
	}
	public WarriorsFrame() throws SQLException {

		// Button with images of each character

		WarriorContainer selectWarrior = new WarriorContainer();
		selectWarrior.createList();
		this.setLayout(new GridLayout(3,3));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		for (Warrior warrior : selectWarrior.getList()) {
			ImageIcon weaponImage = new ImageIcon(warrior.getUrl());
			JButton button = new JButton(weaponImage);
			button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					OcultarPer();
				}
			});
			this.add(button);
		}

		this.pack();
		this.setTitle("Weapons");
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);


	}
	public void OcultarPer() {
		this.dispose();
	}
}
