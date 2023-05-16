import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import javax.swing.*;

public class MainFrame extends JFrame {

    private JLabel labelTitle, front;
    private JPanel panelFiller, panelTitle, panelFront, panelPlay, panelCharacter, panelWeapon, panelExit, panelPrincipal, panelButtons;
    private JButton playButton, characterButton, weaponButton, exitButton;

    WarriorContainer warriorList = new WarriorContainer();
    WeaponContainer weaponList = new WeaponContainer();

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

        playButton = new JButton("Play");
        playButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (player == null) {
                    JOptionPane.showMessageDialog(panelPrincipal, "You haven't chose any armed warrior!");
                }
                else {
                    try {
                        warriorList.createList();
                        bot = warriorList.getWarrior((int) (Math.random()*warriorList.getList().size()));
                        weaponList.createList(bot.getId());
                        bot.setWeapon(weaponList.getWeapon((int) (Math.random()*weaponList.getList().size())));
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                    new Fight(player,bot);
                    dispose();
                }
            }
        });
        panelPlay = new JPanel();
        panelPlay.add(playButton);

        characterButton = new JButton("Choose warrior");
        characterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    WarriorsFrame selectWarrior = new WarriorsFrame();
                    selectWarrior.addWindowListener(
                            new WindowAdapter() {
                                @Override
                                public void windowClosed(WindowEvent e) {
                                    player=selectWarrior.getWarrior();
                                }
                            }
                    );
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
        panelCharacter = new JPanel();
        panelCharacter.add(characterButton);

        weaponButton = new JButton("Choose weapon");
        weaponButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (player == null) {
                    JOptionPane.showMessageDialog(panelPrincipal, "You haven't chose any warrior!");
                }
                else {
                    try {
                        WeaponsFrame selectWeapon = new WeaponsFrame(player);
                        selectWeapon.addWindowListener(
                                new WindowAdapter() {
                                    @Override
                                    public void windowClosed(WindowEvent e) {
                                        player.setWeapon(selectWeapon.getWeapon());
                                    }
                                }
                        );
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });

        panelWeapon = new JPanel();
        panelWeapon.add(weaponButton);

        exitButton = new JButton("Exit");
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        panelExit = new JPanel();
        panelExit.add(exitButton);

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
