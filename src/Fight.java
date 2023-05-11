import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Fight extends JFrame {
	
	private ArrayList<Characters> characters = new ArrayList<Characters>();
	private ArrayList<Weapons> weapons = new ArrayList<Weapons>();
	private Warrior player, bot;
	private Weapon weapon_1, weapon_2;
	private JTextArea text, health_1, health_2;
	private JScrollPane console;
	private JLabel characterIcon_1, characterIcon_2;
	private JButton character, weapon, ranking, fight, clear;
	private JPanel buttonPanel_1, charactersPanel, characterPanel_1, characterPanel_2, weaponsPanel, statsPanel, statsLvlPanel, buttonPanel_2, consolePanel, mainPanel;

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
		if ((defender.getAgility() * 10) > num) {
			message = "The defender missed the attack";
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

	public void combat(Warrior player, Weapon playerWeapon, Warrior bot, Weapon botWeapon) {
		
		Warrior attacker = null;
		Weapon attackerWeapon = null;
		Warrior defender = null;
		Weapon defenderWeapon = null;	
		int num = (int) (Math.floor(Math.random() * 2) + 1);
		
		if (total_speed(player, playerWeapon) > total_speed(bot, botWeapon)) {
			player = attacker;
			bot = defender;
		}
		else if (total_speed(bot, botWeapon) > total_speed(player, playerWeapon)) {
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
				perform_attack(attacker);
				dodge_attack(attacker, attackerWeapon, defender);
				if (repeat_attack(attacker, attackerWeapon, defender, defenderWeapon) == false) {
					break;
				}
			}
			if (attacker.getHealth() == 0 || defender.getHealth() == 0) {
				new Continue();
				break;
			}
			while (true) {
				perform_attack(defender);
				dodge_attack(defender, defenderWeapon, attacker);
				if (repeat_attack(defender, defenderWeapon, attacker, attackerWeapon) == false) {
					break;
				}
			}
			if (attacker.getHealth() == 0 || defender.getHealth() == 0) {
				new Continue();
				break;
			}
		}
	}
	
	public Fight() {
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		character = new JButton("Choose Character");
		character.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Characters();
			}
		});
		weapon = new JButton("Choose weapon");
		weapon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (characters.isEmpty()) {
					text.append("You hadn't choose any character\n");
				}
				else {
					new Weapons();
				}
			}
		});
		ranking = new JButton("Ranking");
		buttonPanel_1 = new JPanel();
		buttonPanel_1.add(character);
		buttonPanel_1.add(weapon);
		buttonPanel_1.add(ranking);
		
		health_1 = new JTextArea(3, 32);
		health_1.setEditable(false);
		health_1.setText("100%");
		health_1.setAlignmentX(Component.CENTER_ALIGNMENT);
		health_1.setAlignmentY(Component.CENTER_ALIGNMENT);
		
		characterPanel_1 = new JPanel();
		characterPanel_1.add(health_1);
		
		health_2 = new JTextArea(3, 32);
		health_2.setText("100%");
		characterPanel_2 = new JPanel();
		characterPanel_2.add(health_2);
		
		charactersPanel = new JPanel();
		charactersPanel.add(characterPanel_1);
		charactersPanel.add(characterPanel_2);
		
		fight = new JButton("Fight");
		fight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (weapons.isEmpty()) {
					text.append("You hadn't choose any armed character\n");
				}
				else {
					
				}
			}
		});
		clear = new JButton("Clear Console");
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text.setText("");
			}
		});
		buttonPanel_2 = new JPanel();
		buttonPanel_2.add(fight);
		buttonPanel_2.add(clear);
		
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
		
		this.setTitle("Menú");
		this.setSize(700, 700);
		this.setResizable(false);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Fight();
	}
}
