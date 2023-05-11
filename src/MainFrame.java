import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;

public class MainFrame extends JFrame {

    private JLabel labelTitle, front;
    private JPanel panelFiller, panelTitle, panelFront, panelPlay, panelCharacter, panelWeapon, panelExit, panelPrincipal, panelButtons;
    private JButton play, character, weapon, exit;
    private Warrior player;

    private Warrior bot;

    public static void main(String[] args) {
        new MainFrame();

    }
    public MainFrame() {

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        panelFiller = new JPanel();

        labelTitle = new JLabel("Race Battle");
        labelTitle.setFont(new Font("Arial", Font.PLAIN, 50));
        panelTitle = new JPanel();
        panelTitle.add(labelTitle);

        ImageIcon background = new ImageIcon("./M03_Programacio/Background/background.jpg");
        Image resizedImage = background.getImage().getScaledInstance(700, 500, Image.SCALE_SMOOTH);
        ImageIcon resizedBackground = new ImageIcon(resizedImage);

        front = new JLabel(resizedBackground);
        panelFront = new JPanel();
        panelFront.add(front);

        play = new JButton("Play");
        play.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (player == null) {
                    JOptionPane.showMessageDialog(panelPrincipal, "You hadn't choose any armed warrior!");
                }
                else {
                    new Fight();
                    dispose();
                }
            }
        });
        panelPlay = new JPanel();
        panelPlay.add(play);

        character = new JButton("Choose warrior");
        character.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    WarriorsFrame selectWarrior = new WarriorsFrame();
                    player = selectWarrior.getWarrior();
                    System.out.println(player.toString());
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
        panelCharacter = new JPanel();
        panelCharacter.add(character);

        weapon = new JButton("Choose weapon");
        weapon.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (player == null || player.getWeapon() == null) {
                    JOptionPane.showMessageDialog(panelPrincipal, "You hadn't choose any warrior!");
                }
                else {
                    try {
                        WeaponsFrame selectWeapon = new WeaponsFrame(player);
                        player.setWeapon(selectWeapon.getWeapon());
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });

        panelWeapon = new JPanel();
        panelWeapon.add(weapon);

        exit = new JButton("Exit");
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println(player.toString());
                //System.exit(0);
            }
        });
        panelExit = new JPanel();
        panelExit.add(exit);

        panelButtons = new JPanel();
        panelButtons.add(panelPlay, BorderLayout.CENTER);
        panelButtons.add(panelCharacter, BorderLayout.CENTER);
        panelButtons.add(panelWeapon, BorderLayout.CENTER);
        panelButtons.add(panelExit, BorderLayout.CENTER);

        panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
        panelPrincipal.add(panelFiller);
        panelPrincipal.add(panelTitle);
        panelPrincipal.add(panelFront);
        panelPrincipal.add(panelButtons);

        this.add(panelPrincipal);

        this.setTitle("Menu");
        this.setSize(700, 700);
        this.setResizable(false);
        this.setVisible(true);

    }

}
