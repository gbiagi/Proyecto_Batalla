import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Fight extends JFrame {
	private boolean win;
	private Warrior newWarrior, newBot;
	private Weapon weapon_1, weapon_2;
	private BufferedImage image_1, image_2, image_3, image_4;
	private int health_X1 = 250, health_X2 = 250, power_X1, power_X2, agility_X1, agility_X2, speed_X1, speed_X2, defense_X1, defense_X2;
	private JTextArea text;
	private JScrollPane console;
	private JLabel extraWarriorLabel_1, extraWarriorLabel_2, extraLabel_1, extraLabel_2, warriorIcon_1, warriorIcon_2, weaponIcon_1, weaponIcon_2, power, agility, speed, defense;
	private JButton characterButton, weaponButton, rankingButton, fightButton, clearButton;
	private JPanel buttonPanel_1, warriorsPanel, extraWarriorPanel_1, extraWarriorPanel_2, warriorPanel_1, warriorPanel_2, statsPanel_1, statsPanel_2, statsNamesPanel_1, statsNamesPanel_2, extraPanel_1, extraPanel_2, buttonPanel_2, consolePanel, mainPanel;
	private int battleScore = 0;
	private int totalScore = 0;
	private int enemiesDefeated = 0;
	private int injuriesCaused = 0;
	private int injuriesSuffered = 0;
	private String username;

	public Fight(Warrior characterChosen, Warrior randomBot) throws SQLException {

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		characterButton = new JButton("Choose Character");
		characterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					WarriorsFrame newSelectWarrior = new WarriorsFrame();
					newSelectWarrior.addWindowListener(
							new WindowAdapter() {
								@Override
								public void windowClosed(WindowEvent e) {
									newWarrior = newSelectWarrior.getWarrior();
									characterChosen.setId(newWarrior.getId());
									characterChosen.setWeapon(null);
									characterChosen.setHealth(newWarrior.getHealth());
									characterChosen.setAgility(newWarrior.getAgility());
									characterChosen.setName(newWarrior.getName());
									characterChosen.setSpeed(newWarrior.getSpeed());
									characterChosen.setUrl(newWarrior.getUrl());
									characterChosen.setDefense(newWarrior.getDefense());
									characterChosen.setPoints(newWarrior.getPoints());
									characterChosen.setStrenght(newWarrior.getStrenght());
									health_X1 = 250;
									repaint();
									try {
										image_1 = ImageIO.read(new File(characterChosen.getUrl()));
									} catch (IOException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									Image icon_1 = image_1.getScaledInstance(250, 250, java.awt.Image.SCALE_SMOOTH);
									warriorIcon_1.setIcon(new ImageIcon(icon_1));
								}
							});
				} catch (SQLException ex) {
					throw new RuntimeException(ex);
				}
			}
		});
		weaponButton = new JButton("Choose weapon");
		weaponButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					WeaponsFrame newWeapon = new WeaponsFrame(characterChosen);
					newWeapon.addWindowListener(
							new WindowAdapter() {
								@Override
								public void windowClosed(WindowEvent e) {
									characterChosen.setWeapon(newWeapon.getWeapon());
									power_X1 = (characterChosen.getStrenght() + newWeapon.getWeapon().getStrenght()) * 6;
									agility_X1 = characterChosen.getAgility() * 6;
									speed_X1 = (characterChosen.getSpeed() + newWeapon.getWeapon().getSpeed()) * 6;
									defense_X1 = characterChosen.getDefense() * 6;
									repaint();
									try {
										image_3 = ImageIO.read(new File(newWeapon.getWeapon().getUrl()));
									} catch (IOException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
							        Image icon_3 = image_3.getScaledInstance(65, 65, java.awt.Image.SCALE_SMOOTH);
							        weaponIcon_1.setIcon(new ImageIcon(icon_3));
								}
							});
				} catch (SQLException ex) {
					throw new RuntimeException(ex);
				}
			}
		});
		
		weapon_1 = characterChosen.getWeapon();
		weapon_2 = randomBot.getWeapon();
		
		rankingButton = new JButton("Ranking");
		buttonPanel_1 = new JPanel();
		buttonPanel_1.add(characterButton);
		buttonPanel_1.add(weaponButton);
		buttonPanel_1.add(rankingButton);
		
		power_X1 = (characterChosen.getStrenght() + weapon_1.getStrenght()) * 6;
		agility_X1 = characterChosen.getAgility() * 6;
		speed_X1 = (characterChosen.getSpeed() + weapon_1.getSpeed()) * 6;
		defense_X1 = characterChosen.getDefense() * 6;
		
		power_X2 = (randomBot.getStrenght() + weapon_2.getStrenght()) * 6;
		agility_X2 = randomBot.getAgility() * 6;
		speed_X2 = (randomBot.getSpeed() + weapon_2.getSpeed()) * 6;
		defense_X2 = randomBot.getDefense() * 6;
		
		extraWarriorLabel_1 = new JLabel(" ");
		extraWarriorPanel_1 = new JPanel();
		extraWarriorPanel_1.add(extraWarriorLabel_1);
		
		extraWarriorLabel_2 = new JLabel(" ");
		extraWarriorPanel_2 = new JPanel();
		extraWarriorPanel_2.add(extraWarriorLabel_2);
		
		try {
			image_1 = ImageIO.read(new File(characterChosen.getUrl()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Image icon_1 = image_1.getScaledInstance(250, 250, java.awt.Image.SCALE_SMOOTH);
        warriorIcon_1 = new JLabel();
        warriorIcon_1.setIcon(new ImageIcon(icon_1));
		
		try {
			image_3 = ImageIO.read(new File(weapon_1.getUrl()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Image icon_3 = image_3.getScaledInstance(65, 65, java.awt.Image.SCALE_SMOOTH);
        weaponIcon_1 = new JLabel();
        weaponIcon_1.setIcon(new ImageIcon(icon_3));
		
		power = new JLabel("Power");
		agility = new JLabel("Agility");
		speed = new JLabel("Speed");
		defense = new JLabel("Defense");
		
		statsNamesPanel_1 = new JPanel();
		statsNamesPanel_1.add(power);
		statsNamesPanel_1.add(agility);
		statsNamesPanel_1.add(speed);
		statsNamesPanel_1.add(defense);
		statsNamesPanel_1.setLayout(new BoxLayout(statsNamesPanel_1, BoxLayout.Y_AXIS));
		
		extraLabel_1 = new JLabel("          ");
		extraPanel_1 = new JPanel();
		extraPanel_1.add(extraLabel_1);
		
		statsPanel_1 = new JPanel();
		statsPanel_1.add(weaponIcon_1);
		statsPanel_1.add(statsNamesPanel_1);
		statsPanel_1.add(extraPanel_1);
		
		warriorPanel_1 = new JPanel();
		warriorPanel_1.add(extraWarriorPanel_1);
		warriorPanel_1.add(warriorIcon_1);
		warriorPanel_1.add(statsPanel_1);
		warriorPanel_1.setLayout(new BoxLayout(warriorPanel_1, BoxLayout.Y_AXIS));
		
		try {
			image_2 = ImageIO.read(new File(randomBot.getUrl()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Image icon_2 = image_2.getScaledInstance(250, 250, java.awt.Image.SCALE_SMOOTH);
        warriorIcon_2 = new JLabel();
        warriorIcon_2.setIcon(new ImageIcon(icon_2));
		
		try {
			image_4 = ImageIO.read(new File(weapon_2.getUrl()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Image icon_4 = image_4.getScaledInstance(65, 65, java.awt.Image.SCALE_SMOOTH);
        weaponIcon_2 = new JLabel();
        weaponIcon_2.setIcon(new ImageIcon(icon_4));
		
		power = new JLabel("Power");
		agility = new JLabel("Agility");
		speed = new JLabel("Speed");
		defense = new JLabel("Defense");
		
		statsNamesPanel_2 = new JPanel();
		statsNamesPanel_2.add(power);
		statsNamesPanel_2.add(agility);
		statsNamesPanel_2.add(speed);
		statsNamesPanel_2.add(defense);
		statsNamesPanel_2.setLayout(new BoxLayout(statsNamesPanel_2, BoxLayout.Y_AXIS));
		
		extraLabel_2 = new JLabel("          ");
		extraPanel_2 = new JPanel();
		extraPanel_2.add(extraLabel_2);
		
		statsPanel_2 = new JPanel();
		statsPanel_2.add(weaponIcon_2);
		statsPanel_2.add(statsNamesPanel_2);
		statsPanel_2.add(extraPanel_2);
		
		warriorPanel_2 = new JPanel();
		warriorPanel_2.add(extraWarriorPanel_2);
		warriorPanel_2.add(warriorIcon_2);
		warriorPanel_2.add(statsPanel_2);
		warriorPanel_2.setLayout(new BoxLayout(warriorPanel_2, BoxLayout.Y_AXIS));
		
		warriorsPanel = new JPanel();
		warriorsPanel.add(warriorPanel_1);
		warriorsPanel.add(warriorPanel_2);
		
		fightButton = new JButton("Fight");
		fightButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					System.out.println(characterChosen.getName() + " ++ " + characterChosen.getWeapon());
					System.out.println(randomBot.getName() + " ++ " + randomBot.getWeapon());
					combat(characterChosen, randomBot);
				} catch (SQLException ex) {
					throw new RuntimeException(ex);
				}
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
		mainPanel.add(warriorsPanel);
		mainPanel.add(buttonPanel_2);
		mainPanel.add(consolePanel);
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		this.add(mainPanel);

		characterButton.setEnabled(false);
		weaponButton.setEnabled(false);

		this.setTitle("Fight");
		this.setLocation(300, 0);
		this.setSize(800, 700);
		this.setResizable(false);
		this.setVisible(true);
	}
	
public void paint(Graphics g) {
		
		super.paint(g);
		Graphics2D g2d = (Graphics2D)g;
		g2d.setStroke(new BasicStroke(2));
		
	//	Player's health bar
		g2d.setColor(Color.GREEN);
		g2d.fillRect(147, 82, health_X1, 25);
		g2d.setColor(Color.BLACK);
		g2d.drawRect(147, 82, 250, 25);
	//	Player's power level bar
		g2d.setColor(Color.RED);
		g2d.fillRect(295, 365, power_X1, 15);
		g2d.setColor(Color.BLACK);
		g2d.drawRect(295, 365, 100, 15);
	//	Player's agility level bar
		g2d.setColor(Color.MAGENTA);
		g2d.fillRect(295, 380, agility_X1, 15);
		g2d.setColor(Color.BLACK);
		g2d.drawRect(295, 380, 100, 15);
	//	Player's speed level bar
		g2d.setColor(Color.ORANGE);
		g2d.fillRect(295, 395, speed_X1, 15);
		g2d.setColor(Color.BLACK);
		g2d.drawRect(295, 395, 100, 15);
	//	Player's defense level bar
		g2d.setColor(Color.BLUE);
		g2d.fillRect(295, 410, defense_X1, 15);
		g2d.setColor(Color.BLACK);
		g2d.drawRect(295, 410, 100, 15);
		
	//	Bot's health bar
		g2d.setColor(Color.GREEN);
		g2d.fillRect(490, 82, health_X2, 25);
		g2d.setColor(Color.BLACK);
		g2d.drawRect(490, 82, 250, 25);
	//	Bot's power level bar
		g2d.setColor(Color.RED);
		g2d.fillRect(640, 365, power_X2, 15);
		g2d.setColor(Color.BLACK);
		g2d.drawRect(640, 365, 100, 15);
	//	Bot's agility level bar
		g2d.setColor(Color.MAGENTA);
		g2d.fillRect(640, 380, agility_X2, 15);
		g2d.setColor(Color.BLACK);
		g2d.drawRect(640, 380, 100, 15);
	//	Bot's speed level bar
		g2d.setColor(Color.ORANGE);
		g2d.fillRect(640, 395, speed_X2, 15);
		g2d.setColor(Color.BLACK);
		g2d.drawRect(640, 395, 100, 15);
	//	Bot's defense level bar
		g2d.setColor(Color.BLUE);
		g2d.fillRect(640, 410, defense_X2, 15);
		g2d.setColor(Color.BLACK);
		g2d.drawRect(640, 410, 100, 15);
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
	public boolean perform_attack(Warrior warrior) {
		String message;
		int num = (int) (Math.floor(Math.random() * 100) + 1);
		if ((warrior.getAgility() * 10) > num) {
			message = "\n" + warrior.getName() + ": Attack successfully performed.";
			text.append(message);
			return true;
		} else {
			message = "\n" + warrior.getName() + ": Attack failed.";
			text.append(message);
			return false;
		}
	}
	//	Method that determines if a warrior can dodge an attack or, in case of receiving it, how much damage recieves
	public String dodge_attack(Warrior attacker, Weapon weapon, Warrior defender) {
		String message;
		int damage = attacker.getStrenght() + weapon.getStrenght() - defender.getDefense();
		int num = (int) (Math.floor(Math.random() * 50) + 1);
		if ((defender.getAgility()) > num) {
			message = defender.getName() + " dodged the attack.";
		} else {
			defender.setHealth(defender.getHealth() - damage);
			message = defender.getName() + " has recieved " + damage + " damage points.";

		}
		return message;
	}

	//	Method that determines if a warrior repeats an attack or gives his turn to his opponent
	public boolean repeat_attack(Warrior attacker, Weapon attackerWeapon, Warrior defender, Weapon defenderWeapon) {
		boolean repeatAttack;
		int num = (int) (Math.floor(Math.random() * 100) + 1);
		if (total_speed(attacker, attackerWeapon) <= total_speed(defender, defenderWeapon)) {
			repeatAttack = false;
		} else {
			if (((total_speed(attacker, attackerWeapon) - total_speed(defender, defenderWeapon)) * 10) > num) {
				repeatAttack = true;
				text.append("\n" + attacker.getName() + " attacks again.");
			} else {
				repeatAttack = false;
			}
		}
		return repeatAttack;
	}

	//	Method that determines who's the warrior that have won
	public String winner(Warrior warrior1, Warrior warrior2) {
		String message = "";
		if (warrior1.getHealth() <= 0) {
			message = warrior2.getName() + " wins!";
		} else if (warrior2.getHealth() <= 0) {
			message = warrior1.getName() + " wins!";
		}
		return message;
	}

	//	Method that determines the fight logic
	public void combat(Warrior player, Warrior bot) throws SQLException {

		Warrior attacker;
		Warrior defender;
		int initialHealthPlayer = player.getHealth();
		int initialHealthBot = bot.getHealth();

		int num = (int) (Math.floor(Math.random() * 2) + 1); // Random num in case both speed and agility are equal

		if (total_speed(player, player.getWeapon()) > total_speed(bot, bot.getWeapon())) {
			attacker = player;
			defender = bot;
		} else if (total_speed(bot, bot.getWeapon()) > total_speed(player, player.getWeapon())) {
			attacker = bot;
			defender = player;
		} else {
			if (total_agility(player) > total_agility(bot)) {
				attacker = player;
				defender = bot;
			} else if (total_agility(bot) > total_agility(player)) {
				attacker = bot;
				defender = player;
			} else {
				if (num == 1) {
					attacker = player;
					defender = bot;
				} else {
					attacker = bot;
					defender = player;
				}
			}
		}
		while (true) {
			while (true) {
				text.append("\n\n" + attacker.getName() + " turn:");
				//perform_attack(attacker);
				if (perform_attack(attacker)) {
					text.append("\n" + dodge_attack(attacker, attacker.getWeapon(), defender));
				}
				text.append("\n" + attacker.getName() + " remaining health: " + attacker.getHealth());
				text.append("\n" + defender.getName() + " remaining health: " + defender.getHealth());
				if (!repeat_attack(attacker, attacker.getWeapon(), defender, defender.getWeapon())) {
					break;
				}

			}
			if (attacker.getHealth() <= 0 || defender.getHealth() <= 0) {
				text.append("\n*******************************\n" + winner(attacker, defender));
				if (winner(attacker, defender).equals(player.getName() + " wins!")) {
					win = true;
					enemiesDefeated += 1;
					health_X1 = player.getHealth() * 4;
					health_X2 = 0;
				}
				else {
					health_X1 = 0;
					health_X2 = bot.getHealth() * 4;
				}
				repaint();
				// Calculate the points, damage taken & done and enemies slayed
				battleScore += calculateScore(bot);
				totalScore += battleScore;
				injuriesSuffered += initialHealthPlayer - player.getHealth();
				injuriesCaused += initialHealthBot - bot.getHealth();

				fightButton.setEnabled(false);
				characterButton.setEnabled(false);
				weaponButton.setEnabled(false);
				int selectContinue = JOptionPane.showOptionDialog(mainPanel, "Do you want to continue fighting?", "Continue",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

				if (selectContinue == 0) {
					// Button "Yes" from joptionpane
					fightButton.setEnabled(true);
					characterButton.setEnabled(true);
					weaponButton.setEnabled(true);

					//create new bot
					//New bot
					WarriorContainer warriorList = new WarriorContainer();
					warriorList.createList();
					newBot = warriorList.getWarrior((int) (Math.random()*warriorList.getList().size()));
					WeaponContainer weaponList = new WeaponContainer();
					weaponList.createList(newBot.getId());
					bot.setWeapon(weaponList.getWeapon((int) (Math.random()*weaponList.getList().size())));
					
					try {
						image_4 = ImageIO.read(new File(bot.getWeapon().getUrl()));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			        Image icon_4 = image_4.getScaledInstance(65, 65, java.awt.Image.SCALE_SMOOTH);
			        weaponIcon_2.setIcon(new ImageIcon(icon_4));
			        
					bot.setId(newBot.getId());
					bot.setHealth(newBot.getHealth());
					bot.setAgility(newBot.getAgility());
					bot.setName(newBot.getName());
					bot.setSpeed(newBot.getSpeed());
					bot.setUrl(newBot.getUrl());
					bot.setDefense(newBot.getDefense());
					bot.setPoints(newBot.getPoints());
					bot.setStrenght(newBot.getStrenght());
					
					try {
						image_2 = ImageIO.read(new File(bot.getUrl()));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					Image icon_2 = image_2.getScaledInstance(250, 250, java.awt.Image.SCALE_SMOOTH);
			        warriorIcon_2.setIcon(new ImageIcon(icon_2));
			        
					player.setHealth(initialHealthPlayer);
					bot.setHealth(initialHealthBot);
					
					health_X1 = 250;
					health_X2 = 250;
					
					power_X2 = (bot.getStrenght() + bot.getWeapon().getStrenght()) * 6;
					agility_X2 = bot.getAgility() * 6;
					speed_X2 = (bot.getSpeed() + bot.getWeapon().getSpeed()) * 6;
					defense_X2 = bot.getDefense() * 6;
					
					repaint();
					
					//Set points for new round
					totalScore += battleScore;
					battleScore = 0;
					enemiesDefeated += 1;
					break;

				} else if (selectContinue == 1) {
					// Button "No" from joptionpane
					//Username check
					int maxUserLength = 5; // Maximum number of characters allowed
					boolean userValid = false;
					while (!userValid) { // Window asking for a username
						username = JOptionPane.showInputDialog(mainPanel, "Enter your username (max. 5 characters):");
						if (username != null && username.length() <= maxUserLength) {
							userValid = true;
						} else {
							JOptionPane.showMessageDialog(mainPanel, "Invalid username. Enter a name with a maximum of 5 characters.");
						}
					}
					// Save user data from this battle
					BBDDConnection.insertPlayer(username,totalScore,enemiesDefeated);
					int playerID = BBDDConnection.getPlayerID("Select PLAYER_ID from players WHERE PLAYER_NAME = '"+username+"'");
					// Save battle data
					JOptionPane.showMessageDialog(mainPanel, "Score saved!");
					BBDDConnection.insertBattle(String.valueOf(playerID), player.getId(),player.getWeapon().getId(),
							bot.getId(),bot.getWeapon().getId(),injuriesCaused,injuriesSuffered,totalScore);
					System.exit(0);
				} else {
					break;
				}
			}
			//Change attacker to defender
			Warrior aux = attacker;
			attacker = defender;
			defender = aux;
		}
	}
	//Method to calculate the user score
	public int calculateScore(Warrior bot) {
		int total = 0;
		total += bot.getPoints() + bot.getWeapon().getPoints();
		return total;
	}
}
