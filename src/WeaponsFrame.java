import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class WeaponsFrame extends JFrame {
	Weapon selectedWeapon;
	WeaponContainer selectWeapon = new WeaponContainer();
	public WeaponsFrame(Warrior player) throws SQLException {

		selectWeapon.createList(player.getId());

		this.setLayout(new GridLayout(3,3));

		for (Weapon weapon : selectWeapon.getList()) {
			ImageIcon weaponImage = new ImageIcon(weapon.getUrl());
			JButton button = new JButton(weaponImage);
			button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					selectedWeapon = weapon;
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
	public Weapon getWeapon() {
		return selectedWeapon;
	}

}
