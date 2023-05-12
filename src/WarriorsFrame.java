import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class WarriorsFrame extends JFrame {
	private Warrior selectedWarrior;
	private WarriorContainer selectWarrior = new WarriorContainer();

	public WarriorsFrame() throws SQLException {

		// Botones con imagenes de cada personaje

		selectWarrior.createList();
		this.setLayout(new GridLayout(3, 3));

		for (Warrior warrior : selectWarrior.getList()) {
			ImageIcon warriorImage = new ImageIcon(warrior.getUrl());
			JButton button = new JButton(warriorImage);
			button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					selectedWarrior = warrior;
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

	public Warrior getWarrior() {
		return selectedWarrior;
	}

}
