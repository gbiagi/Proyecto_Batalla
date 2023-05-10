import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class WeaponsFrame extends JFrame {
	public static void main(String[] args) throws SQLException {
		new WeaponsFrame();
	}
	public WeaponsFrame() throws SQLException {
		WeaponContainer selectWeapon = new WeaponContainer();
		selectWeapon.createList(8);
		this.setLayout(new GridLayout(3,3));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		for (Weapon weapon : selectWeapon.getList()) {
			ImageIcon weaponImage = new ImageIcon(weapon.getUrl());
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
