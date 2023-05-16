import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Fight extends JFrame {
	private Weapon weapon_1, weapon_2;
	private JTextArea text, healthPlayer, healthBot;
	private JScrollPane console;
	private JLabel playerIcon, botIcon;
	private JButton characterButton, weaponButton, rankingButton, fightButton, clearButton;
	private JPanel buttonPanel_1, charactersPanel, characterPanel_1, characterPanel_2, weaponsPanel, statsPanel, statsLvlPanel, buttonPanel_2, consolePanel, mainPanel;

	public Fight(Warrior characterChosen, Warrior randomBot) {

		setDefaultCloseOperation(EXIT_ON_CLOSE);

		characterButton = new JButton("Choose Character");
		characterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new WarriorsFrame();
				} catch (SQLException ex) {
					throw new RuntimeException(ex);
				}
			}
		});
		weaponButton = new JButton("Choose weapon");

		rankingButton = new JButton("Ranking");
		buttonPanel_1 = new JPanel();
		buttonPanel_1.add(characterButton);
		buttonPanel_1.add(weaponButton);
		buttonPanel_1.add(rankingButton);

		healthPlayer = new JTextArea(3, 32);
		healthPlayer.setEditable(false);
		healthPlayer.setText("100%");
		healthPlayer.setAlignmentX(Component.CENTER_ALIGNMENT);
		healthPlayer.setAlignmentY(Component.CENTER_ALIGNMENT);

		characterPanel_1 = new JPanel();
		characterPanel_1.add(healthPlayer);

		healthBot = new JTextArea(3, 32);
		healthBot.setText("100%");
		characterPanel_2 = new JPanel();
		characterPanel_2.add(healthBot);

		charactersPanel = new JPanel();
		charactersPanel.add(characterPanel_1);
		charactersPanel.add(characterPanel_2);

		fightButton = new JButton("Fight");
		fightButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				combat(characterChosen,randomBot);
			}
		});

		clearButton = new JButton("Clear Console");
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text.setText("");
			}
		});
		buttonPanel_2 = new JPanel();
		buttonPanel_2.add(fightButton);
		buttonPanel_2.add(clearButton);

		text = new JTextArea(10, 67);
		text.setEditable(false);
		console = new JScrollPane(text);
		console.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		console.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		consolePanel = new JPanel();
		consolePanel.add(console);
		console.setSize(700, 100);

		mainPanel = new JPanel();
		mainPanel.add(buttonPanel_1);
		mainPanel.add(charactersPanel);
		mainPanel.add(buttonPanel_2);
		mainPanel.add(consolePanel);
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		this.add(mainPanel);

		this.setTitle("Menu");
		this.setSize(700, 700);
		this.setResizable(false);
		this.setVisible(true);
	}


	//	Method that counts a warrior's total speed
	public int total_speed(Warrior warrior, Weapon weapon) {
		int count_speed;
		count_speed = warrior.getSpeed() + weapon.getSpeed();
		return count_speed;
	}

//	Method that counts a warrior's total agility
	public int total_agility(Warrior warrior) {
		int count_agility;
		count_agility = warrior.getAgility();
		return count_agility;
	}

//	Method that determines if a warrior can perform an attack or not
	public String perform_attack(Warrior warrior) {
		String message;
		int num = (int) (Math.floor(Math.random() * 100) + 1);
		if ((warrior.getAgility() * 10) > num) {
			message = "Attack succesfully performed";
		}
		else {
			message = "Failed attack";
		}
		return message;
	}

//	Method that determines if a warrior can dodge an attack or, in case of receiving it, how much damage recieves
	public String dodge_attack(Warrior attacker, Weapon weapon, Warrior defender) {
		String message;
		int damage = attacker.getStrenght() + weapon.getStrenght() - defender.getDefense();
		int num = (int) (Math.floor(Math.random() * 50) + 1);
		if ((defender.getAgility()) > num) {
			message = "The defender dodged the attack";
		}
		else {
			defender.setHealth(defender.getHealth() - damage);
			message = "The defender has recieved " + damage + " damage points";
		}
		return message;
	}

//	Method that determines if a warrior repeats an attack or gives his turn to his opponent
	public boolean repeat_attack(Warrior attacker, Weapon attackerWeapon, Warrior defender, Weapon defenderWeapon) {
		boolean repeatAttack;
		int num = (int) (Math.floor(Math.random() * 100) + 1);
		if (total_speed(attacker, attackerWeapon) <= total_speed(defender, defenderWeapon)) {
			repeatAttack = false;
		}
		else {
			if (((total_speed(attacker, attackerWeapon) - total_speed(defender, defenderWeapon)) * 10) > num) {
				repeatAttack = true;
			}
			else {
				repeatAttack = false;
			}
		}
		return repeatAttack;
	}

//	Method that determines who's the warrior that have won
	public String winner(Warrior warrior1, Warrior warrior2) {
		String message = "";
		if (warrior1.getHealth() == 0) {
			message = warrior1.getName() + " wins!";
		}
		else if (warrior2.getHealth() == 0) {
			message = warrior2.getName() + " wins!";
		}
		return message;
	}

//	Method that determines the fight logic
	public void combat(Warrior player, Warrior bot) {

		Warrior attacker = new Warrior(player.getId(), player.getName(), player.getHealth(), player.getStrenght(), player.getSpeed(), player.getAgility(), player.getDefense(), player.getUrl(), player.getWeapon(), player.getPoints());
		Warrior defender = new Warrior(bot.getId(), bot.getName(), bot.getHealth(), bot.getStrenght(), bot.getSpeed(), bot.getAgility(), bot.getDefense(), bot.getUrl(), bot.getWeapon(), bot.getPoints());

		int num = (int) (Math.floor(Math.random() * 2) + 1); // Random num in case both speed and agility are equal

		if (total_speed(player, player.getWeapon()) > total_speed(bot, bot.getWeapon())) {
			player = attacker;
			bot = defender;
		}
		else if (total_speed(bot, bot.getWeapon()) > total_speed(player, player.getWeapon())) {
			bot = attacker;
			player = defender;
		}
		else {
			if (total_agility(player) > total_agility(bot)) {
				player = attacker;
				bot = defender;
			}
			else if (total_agility(bot) > total_agility(player)) {
				bot = attacker;
				player = defender;
			}
			else {
				if (num == 1) {
					player = attacker;
					bot = defender;
				}
				else{
					bot = attacker;
					player = defender;
				}
			}
		}
		while (true) {
			while (true) {
				System.out.println(perform_attack(attacker));
				System.out.println(dodge_attack(attacker, attacker.getWeapon(), defender));

				System.out.println("Ataquee");
				if (!repeat_attack(attacker, attacker.getWeapon(), defender, defender.getWeapon())) {
					break;
				}
			}
			if (attacker.getHealth() == 0 || defender.getHealth() == 0) {
				System.out.println(winner(attacker,defender));
				new Continue();
				break;
			}
			while (true) {
				System.out.println(perform_attack(defender));
				System.out.println(dodge_attack(defender, defender.getWeapon(), attacker));
				System.out.println("Ataquee2");
				if (!repeat_attack(defender, defender.getWeapon(), attacker, attacker.getWeapon())) {
					break;
				}
			}
			if (attacker.getHealth() == 0 || defender.getHealth() == 0) {
				System.out.println(winner(attacker,defender));
				new Continue();
				break;
			}
		}
	}
}
